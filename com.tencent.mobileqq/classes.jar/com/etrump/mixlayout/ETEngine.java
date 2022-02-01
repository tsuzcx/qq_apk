package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ETEngine
  implements IETEngine
{
  private static final int BITMAP_INDEX_BACK = 0;
  private static final int BITMAP_INDEX_FORE = 1;
  private static final int ETRUMP_FONT_SIZE_MINIMUM = 24;
  public static final int STYLE_BOLD = 1;
  public static final int STYLE_CROCHET = 8;
  public static final int STYLE_REGULAR = 0;
  public static final int STYLE_SHADOW = 128;
  private static final int S_MEM_POOL_SIZE = 1048576;
  public static final String TAG = "ETEngine";
  public static AtomicBoolean isSOLoaded = new AtomicBoolean(false);
  private static ETEngine sInstance;
  private static ETEngine sInstanceAnimation;
  private static ETEngine sInstanceDiyAddon;
  private static ETEngine sInstanceRP;
  private static ETEngine sInstanceSpace;
  public AtomicBoolean isEngineInited = new AtomicBoolean(false);
  public AtomicBoolean isEngineReady = new AtomicBoolean(false);
  private Paint mBitmapPaint = null;
  private Bitmap[] mBitmaps = null;
  private Canvas mCanvas = null;
  public HashMap<Long, WeakReference<IETDecoration>> mDescriptorMap = new HashMap();
  private final boolean mEnableCallbackDrawing = true;
  private boolean mInitialized = false;
  private long mNativeFontManagerHandle = 0L;
  private Paint mPaint = null;
  
  public static ETEngine getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new ETEngine();
      }
      ETEngine localETEngine = sInstance;
      return localETEngine;
    }
    finally {}
  }
  
  public static ETEngine getInstanceForAnimation()
  {
    try
    {
      if (sInstanceAnimation == null) {
        sInstanceAnimation = new ETEngine();
      }
      ETEngine localETEngine = sInstanceAnimation;
      return localETEngine;
    }
    finally {}
  }
  
  public static ETEngine getInstanceForDiyPendant()
  {
    if (sInstanceDiyAddon == null) {
      sInstanceDiyAddon = new ETEngine();
    }
    return sInstanceDiyAddon;
  }
  
  public static ETEngine getInstanceForRedPacket()
  {
    if (sInstanceRP == null) {
      sInstanceRP = new ETEngine();
    }
    return sInstanceRP;
  }
  
  public static ETEngine getInstanceForSpace()
  {
    try
    {
      if (sInstanceSpace == null) {
        sInstanceSpace = new ETEngine();
      }
      ETEngine localETEngine = sInstanceSpace;
      return localETEngine;
    }
    finally {}
  }
  
  public static native boolean native_ftf2ttf(String paramString1, String paramString2);
  
  public static native int native_getFontType(String paramString);
  
  public static native boolean native_quickCheck(String paramString1, String paramString2);
  
  public void callbackDrawBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mCanvas == null) {
      this.mCanvas = new Canvas();
    }
    if (this.mBitmapPaint == null) {
      this.mBitmapPaint = new Paint(1);
    }
    this.mBitmapPaint.setAlpha((int)(paramFloat3 * 255.0F));
    this.mCanvas.setBitmap(paramBitmap1);
    this.mCanvas.translate(paramFloat1, paramFloat2);
    this.mCanvas.drawBitmap(paramBitmap2, paramMatrix, this.mBitmapPaint);
  }
  
  public Bitmap createBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.mBitmaps == null)
    {
      this.mBitmaps = new Bitmap[2];
      localObject = this.mBitmaps;
      localObject[1] = null;
      localObject[0] = null;
    }
    if (paramInt3 > 1) {
      return null;
    }
    Bitmap localBitmap = this.mBitmaps[paramInt3];
    if (localBitmap == null)
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    else
    {
      int j = localBitmap.getWidth();
      int i = localBitmap.getHeight();
      if (j >= paramInt1)
      {
        localObject = localBitmap;
        if (i >= paramInt2) {}
      }
      else
      {
        if (j >= paramInt1) {
          paramInt1 = j;
        }
        if (i >= paramInt2) {
          paramInt2 = i;
        }
        localBitmap.recycle();
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
    }
    this.mBitmaps[paramInt3] = localObject;
    return localObject;
  }
  
  public byte[] getPicture(String paramString)
  {
    Object localObject = ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getDIYFontImage(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return Base64.decode((String)localObject, 0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/diy_fonts");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".png");
    return ETDIYConfig.a(new File(((StringBuilder)localObject).toString()));
  }
  
  public boolean initEngine(int paramInt1, int paramInt2)
  {
    if (!isSOLoaded.get()) {
      return false;
    }
    if (native_initEngine(paramInt1, paramInt2, true)) {
      return true;
    }
    throw new Exception("init engine fail");
  }
  
  public boolean isEnableCallbackDrawing()
  {
    return true;
  }
  
  public boolean nativeCloneBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    return native_cloneBitmap(paramBitmap1, paramBitmap2);
  }
  
  public long nativeCloneNativeSubstitutionConfig(long paramLong)
  {
    return native_CloneNativeSubstitutionConfig(paramLong);
  }
  
  public void nativeColorDisableEffects(IETFont paramIETFont, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    native_colorDisableEffects((ETFont)paramIETFont, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public boolean nativeContainComplexScript(String paramString)
  {
    return native_containComplexScript(paramString);
  }
  
  public long nativeCreateNativeSubstitutionConfig(IETFont paramIETFont, byte[] paramArrayOfByte)
  {
    return native_CreateNativeSubstitutionConfig((ETFont)paramIETFont, paramArrayOfByte);
  }
  
  public long nativeDecorationCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, IETFont paramIETFont)
  {
    return native_decorationCreateDescriptor(paramString, paramArrayOfETSegment, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, (ETFont)paramIETFont);
  }
  
  public void nativeDecorationDeleteDescriptor(long paramLong)
  {
    native_decorationDeleteDescriptor(paramLong);
  }
  
  public void nativeDecorationDrawBackground(long paramLong, int paramInt, IETFont paramIETFont, Bitmap paramBitmap)
  {
    native_decorationDrawBackground(paramLong, paramInt, (ETFont)paramIETFont, paramBitmap);
  }
  
  public void nativeDecorationDrawForeground(long paramLong, int paramInt, IETFont paramIETFont, Bitmap paramBitmap)
  {
    native_decorationDrawForeground(paramLong, paramInt, (ETFont)paramIETFont, paramBitmap);
  }
  
  public boolean nativeDecorationDrawScene(long paramLong, int paramInt1, IETFont paramIETFont, Object[] paramArrayOfObject, Bitmap paramBitmap, int paramInt2, int paramInt3)
  {
    return native_decorationDrawScene(paramLong, paramInt1, (ETFont)paramIETFont, paramArrayOfObject, paramBitmap, paramInt2, paramInt3);
  }
  
  public boolean nativeDecorationDrawText(long paramLong, int paramInt1, int paramInt2, int paramInt3, IETFont paramIETFont, Bitmap paramBitmap, int paramInt4, int paramInt5)
  {
    return native_decorationDrawText(paramLong, paramInt1, paramInt2, paramInt3, (ETFont)paramIETFont, paramBitmap, paramInt4, paramInt5);
  }
  
  public boolean nativeDecorationDrawTextOnAnimatingEnd(long paramLong, IETFont paramIETFont)
  {
    return native_decorationDrawTextOnAnimatingEnd(paramLong, (ETFont)paramIETFont);
  }
  
  public long nativeDecorationGetDescriptor(IETFont paramIETFont, String paramString, int paramInt1, int paramInt2)
  {
    return native_decorationGetDescriptor((ETFont)paramIETFont, paramString, paramInt1, paramInt2);
  }
  
  public int nativeDecorationGetFrameDelay(long paramLong, int paramInt)
  {
    return native_decorationGetFrameDelay(paramLong, paramInt);
  }
  
  public int nativeDecorationGetFrameNum(long paramLong)
  {
    return native_decorationGetFrameNum(paramLong);
  }
  
  public int nativeDecorationGetTemplateID(IETFont paramIETFont, int paramInt1, int paramInt2, int paramInt3)
  {
    return native_decorationGetTemplateID((ETFont)paramIETFont, paramInt1, paramInt2, paramInt3);
  }
  
  public int nativeDecorationGetTempletIndex(long paramLong)
  {
    return native_decorationGetTempletIndex(paramLong);
  }
  
  public int nativeDecorationGetType(long paramLong)
  {
    return native_decorationGetType(paramLong);
  }
  
  public void nativeDeleteNativeSubstitutionConfig(long paramLong)
  {
    native_DeleteNativeSubstitutionConfig(paramLong);
  }
  
  public long nativeDiyFontCreateNativeConfig(IETFont paramIETFont, byte[] paramArrayOfByte)
  {
    return native_diyFontCreateNativeConfig((ETFont)paramIETFont, paramArrayOfByte);
  }
  
  public void nativeDiyFontDeleteNativeConfig(long paramLong)
  {
    native_diyFontDeleteNativeConfig(paramLong);
  }
  
  public void nativeDiyFontDrawChar(int paramInt1, IETFont paramIETFont, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    native_diyFontDrawChar(paramInt1, (ETFont)paramIETFont, paramBitmap, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
  }
  
  public void nativeDiyFontDrawGlyph(int paramInt1, IETFont paramIETFont, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    native_diyFontDrawGlyph(paramInt1, (ETFont)paramIETFont, paramBitmap, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
  }
  
  public int[] nativeDiyFontGetAccessoryList(IETFont paramIETFont)
  {
    return native_diyFontGetAccessoryList((ETFont)paramIETFont);
  }
  
  public int nativeDiyFontGetCharIndex(int paramInt, IETFont paramIETFont)
  {
    return native_diyFontGetCharIndex(paramInt, (ETFont)paramIETFont);
  }
  
  public int nativeDiyFontGetColorStyleCount(IETFont paramIETFont)
  {
    return native_diyFontGetColorStyleCount((ETFont)paramIETFont);
  }
  
  public int nativeDiyFontGetCurrentColorStyle(IETFont paramIETFont)
  {
    return native_diyFontGetCurrentColorStyle((ETFont)paramIETFont);
  }
  
  public int nativeDiyFontGetCurrentThemeStyle(IETFont paramIETFont)
  {
    return native_diyFontGetCurrentThemeStyle((ETFont)paramIETFont);
  }
  
  public boolean nativeDiyFontGetGlyphBound(int paramInt, IETFont paramIETFont, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Rect paramRect)
  {
    return native_diyFontGetGlyphBound(paramInt, (ETFont)paramIETFont, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramRect);
  }
  
  public int nativeDiyFontGetSdkVersion()
  {
    return native_diyFontGetSdkVersion();
  }
  
  public int nativeDiyFontGetThemeStyleCount(IETFont paramIETFont)
  {
    return native_diyFontGetThemeStyleCount((ETFont)paramIETFont);
  }
  
  public int nativeDiyFontGetUPEM(IETFont paramIETFont)
  {
    return native_diyFontGetUPEM((ETFont)paramIETFont);
  }
  
  public int nativeDiyFontGetVersion(IETFont paramIETFont)
  {
    return native_diyFontGetVersion((ETFont)paramIETFont);
  }
  
  public boolean nativeDiyFontIsDIYFont(IETFont paramIETFont)
  {
    return native_diyFontIsDIYFont((ETFont)paramIETFont);
  }
  
  public void nativeDoneEngine()
  {
    native_doneEngine();
  }
  
  public boolean nativeDrawBackground(String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, IETFont paramIETFont)
  {
    return native_drawBackground(paramString, paramInt1, paramBitmap, paramInt2, paramInt3, (ETFont)paramIETFont);
  }
  
  public boolean nativeDrawInRect(String paramString, Bitmap paramBitmap, IETFont paramIETFont)
  {
    return native_drawInRect(paramString, paramBitmap, (ETFont)paramIETFont);
  }
  
  public boolean nativeDrawText(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont)
  {
    return native_drawText(paramString, paramBitmap, paramInt1, paramInt2, (ETFont)paramIETFont);
  }
  
  public long nativeEmoticonCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, IETFont paramIETFont, int paramInt2)
  {
    return native_emoticonCreateDescriptor(paramString, paramArrayOfETSegment, paramInt1, (ETFont)paramIETFont, paramInt2);
  }
  
  public EMImage nativeEmoticonCreateImage(String paramString, int paramInt, IETFont paramIETFont)
  {
    return native_emoticonCreateImage(paramString, paramInt, (ETFont)paramIETFont);
  }
  
  public void nativeEmoticonDeleteDescriptor(long paramLong)
  {
    native_emoticonDeleteDescriptor(paramLong);
  }
  
  public void nativeEmoticonDrawFrame(long paramLong, int paramInt, IETFont paramIETFont, Bitmap paramBitmap)
  {
    native_emoticonDrawFrame(paramLong, paramInt, (ETFont)paramIETFont, paramBitmap);
  }
  
  public int nativeEmoticonGetFrameDelay(long paramLong, int paramInt)
  {
    return native_emoticonGetFrameDelay(paramLong, paramInt);
  }
  
  public int nativeEmoticonGetFrameNum(long paramLong)
  {
    return native_emoticonGetFrameNum(paramLong);
  }
  
  public int nativeEmoticonGetHeight(long paramLong)
  {
    return native_emoticonGetHeight(paramLong);
  }
  
  public int nativeEmoticonGetHeightByIndex(int paramInt, IETFont paramIETFont)
  {
    return native_emoticonGetHeightByIndex(paramInt, (ETFont)paramIETFont);
  }
  
  public int nativeEmoticonGetWidth(long paramLong)
  {
    return native_emoticonGetWidth(paramLong);
  }
  
  public int nativeEmoticonGetWidthByIndex(int paramInt, IETFont paramIETFont)
  {
    return native_emoticonGetWidthByIndex(paramInt, (ETFont)paramIETFont);
  }
  
  public int[] nativeEmoticonRetrieveCollection(String paramString, int paramInt, IETFont paramIETFont)
  {
    return native_emoticonRetrieveCollection(paramString, paramInt, (ETFont)paramIETFont);
  }
  
  public boolean nativeFtf2ttf(String paramString1, String paramString2)
  {
    return native_ftf2ttf(paramString1, paramString2);
  }
  
  public int nativeGetFontCategory(IETFont paramIETFont)
  {
    return native_getFontCategory((ETFont)paramIETFont);
  }
  
  public boolean nativeGetFontMetrics(Paint.FontMetrics paramFontMetrics, IETFont paramIETFont)
  {
    return native_getFontMetrics(paramFontMetrics, (ETFont)paramIETFont);
  }
  
  public int nativeGetFontType(String paramString)
  {
    return native_getFontType(paramString);
  }
  
  public int nativeGetHorizontalMarginThreshold(IETFont paramIETFont, int paramInt)
  {
    return native_getHorizontalMarginThreshold((ETFont)paramIETFont, paramInt);
  }
  
  public Rect nativeGetMargins(long paramLong)
  {
    return native_getMargins(paramLong);
  }
  
  public int nativeGetTextColor(IETFont paramIETFont)
  {
    return native_getTextColor((ETFont)paramIETFont);
  }
  
  public boolean nativeGetTextWidths(String paramString, IETFont paramIETFont, Paint paramPaint, int[] paramArrayOfInt)
  {
    return native_getTextWidths(paramString, (ETFont)paramIETFont, paramPaint, paramArrayOfInt);
  }
  
  public int nativeGetVariantStyleComboCount(IETFont paramIETFont)
  {
    return native_getVariantStyleComboCount((ETFont)paramIETFont);
  }
  
  public boolean nativeInitEngine(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return native_initEngine(paramInt1, paramInt2, paramBoolean);
  }
  
  public boolean nativeIsColorVariantFont(IETFont paramIETFont)
  {
    return native_isColorVariantFont((ETFont)paramIETFont);
  }
  
  public boolean nativeIsDecorationFont(IETFont paramIETFont)
  {
    return native_isDecorationFont((ETFont)paramIETFont);
  }
  
  public boolean nativeIsFontLoaded(int paramInt)
  {
    return native_isFontLoaded(paramInt);
  }
  
  public boolean nativeIsHiboomFont(IETFont paramIETFont)
  {
    return native_isHiboomFont((ETFont)paramIETFont);
  }
  
  public boolean nativeIsPaintableChar(char paramChar, IETFont paramIETFont)
  {
    return native_isPaintableChar(paramChar, (ETFont)paramIETFont);
  }
  
  public boolean nativeLoadFont(String paramString, int paramInt, boolean paramBoolean)
  {
    return native_loadFont(paramString, paramInt, paramBoolean);
  }
  
  public int nativeMatchTextStyle(IETFont paramIETFont, String paramString)
  {
    return native_matchTextStyle((ETFont)paramIETFont, paramString);
  }
  
  public boolean nativeMeasure(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Rect paramRect)
  {
    return native_measure(paramString, paramInt1, paramInt2, (ETFont)paramIETFont, paramRect);
  }
  
  public void nativePrintTrace()
  {
    native_printTrace();
  }
  
  public boolean nativeQuickCheck(String paramString1, String paramString2)
  {
    return native_quickCheck(paramString1, paramString2);
  }
  
  public void nativeResetEngine()
  {
    native_resetEngine();
  }
  
  public boolean nativeSetPersistentFont(IETFont paramIETFont)
  {
    return native_setPersistentFont((ETFont)paramIETFont);
  }
  
  public long nativeSpaceDecorationCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, IETFont paramIETFont)
  {
    return native_space_decorationCreateDescriptor(paramString, paramArrayOfETSegment, paramInt1, paramInt2, paramPoint, paramInt3, paramArrayOfPoint, paramInt4, paramBoolean1, paramInt5, paramBoolean2, (ETFont)paramIETFont);
  }
  
  public void nativeSpaceDecorationDeleteDescriptor(long paramLong)
  {
    native_space_decorationDeleteDescriptor(paramLong);
  }
  
  public void nativeSpaceDecorationDrawBackground(long paramLong, int paramInt1, IETFont paramIETFont, Bitmap paramBitmap, int paramInt2, int paramInt3)
  {
    native_space_decorationDrawBackground(paramLong, paramInt1, (ETFont)paramIETFont, paramBitmap, paramInt2, paramInt3);
  }
  
  public boolean nativeSpaceDecorationDrawScene(long paramLong, int paramInt1, IETFont paramIETFont, Object[] paramArrayOfObject, Bitmap paramBitmap, int paramInt2, int paramInt3)
  {
    return native_space_decorationDrawScene(paramLong, paramInt1, (ETFont)paramIETFont, paramArrayOfObject, paramBitmap, paramInt2, paramInt3);
  }
  
  public int nativeSpaceDecorationGetFrameDelay(long paramLong, int paramInt)
  {
    return native_space_decorationGetFrameDelay(paramLong, paramInt);
  }
  
  public int nativeSpaceDecorationGetFrameNum(long paramLong)
  {
    return native_space_decorationGetFrameNum(paramLong);
  }
  
  public void nativeSpaceDrawText(String paramString, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint)
  {
    native_spaceDrawText(paramString, paramCanvas, paramBitmap, paramInt1, paramInt2, (ETFont)paramIETFont, paramPaint);
  }
  
  public int nativeSpaceGetFontType(IETFont paramIETFont)
  {
    return native_space_getFontType((ETFont)paramIETFont);
  }
  
  public int nativeSpaceGetHorizontalMarginThreshold(IETFont paramIETFont, int paramInt)
  {
    return native_space_getHorizontalMarginThreshold((ETFont)paramIETFont, paramInt);
  }
  
  public Rect nativeSpaceGetMargins(long paramLong)
  {
    return native_space_getMargins(paramLong);
  }
  
  public int nativeSpaceGetTextWidths(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint, int[] paramArrayOfInt)
  {
    return native_spaceGetTextWidths(paramString, paramInt1, paramInt2, (ETFont)paramIETFont, paramPaint, paramArrayOfInt);
  }
  
  public boolean nativeSpaceIsDecorationFont(IETFont paramIETFont)
  {
    return native_space_isDecorationFont((ETFont)paramIETFont);
  }
  
  public int nativeSpaceMeasureText(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint)
  {
    return native_spaceMeasureText(paramString, paramInt1, paramInt2, (ETFont)paramIETFont, paramPaint);
  }
  
  public boolean nativeTextLayoutHasPreLine(long paramLong)
  {
    return native_textLayoutHasPreLine(paramLong);
  }
  
  public int nativeTextLayoutLineHeight(long paramLong, int paramInt)
  {
    return native_textLayoutLineHeight(paramLong, paramInt);
  }
  
  public int nativeTextLayoutLineRangeFrom(long paramLong, int paramInt)
  {
    return native_textLayoutLineRangeFrom(paramLong, paramInt);
  }
  
  public int nativeTextLayoutLineRangeTo(long paramLong, int paramInt)
  {
    return native_textLayoutLineRangeTo(paramLong, paramInt);
  }
  
  public int nativeTextLayoutLineTotal(long paramLong)
  {
    return native_textLayoutLineTotal(paramLong);
  }
  
  public int nativeTextLayoutLineWidth(long paramLong, int paramInt)
  {
    return native_textLayoutLineWidth(paramLong, paramInt);
  }
  
  public long nativeTextLayoutLock(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IETFont paramIETFont)
  {
    return native_textLayoutLock(paramString, paramInt1, paramInt2, paramInt3, paramInt4, (ETFont)paramIETFont);
  }
  
  public void nativeTextLayoutUnlock(long paramLong)
  {
    native_textLayoutUnlock(paramLong);
  }
  
  public native long native_CloneNativeSubstitutionConfig(long paramLong);
  
  public native long native_CreateNativeSubstitutionConfig(ETFont paramETFont, byte[] paramArrayOfByte);
  
  public native void native_DeleteNativeSubstitutionConfig(long paramLong);
  
  public native boolean native_cloneBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public native void native_colorDisableEffects(ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public native boolean native_containComplexScript(String paramString);
  
  public native long native_decorationCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, ETFont paramETFont);
  
  public native void native_decorationDeleteDescriptor(long paramLong);
  
  public native void native_decorationDrawBackground(long paramLong, int paramInt, ETFont paramETFont, Bitmap paramBitmap);
  
  public native void native_decorationDrawForeground(long paramLong, int paramInt, ETFont paramETFont, Bitmap paramBitmap);
  
  public native boolean native_decorationDrawScene(long paramLong, int paramInt1, ETFont paramETFont, Object[] paramArrayOfObject, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public native boolean native_decorationDrawText(long paramLong, int paramInt1, int paramInt2, int paramInt3, ETFont paramETFont, Bitmap paramBitmap, int paramInt4, int paramInt5);
  
  public native boolean native_decorationDrawTextOnAnimatingEnd(long paramLong, ETFont paramETFont);
  
  public native long native_decorationGetDescriptor(ETFont paramETFont, String paramString, int paramInt1, int paramInt2);
  
  public native int native_decorationGetFrameDelay(long paramLong, int paramInt);
  
  public native int native_decorationGetFrameNum(long paramLong);
  
  public native int native_decorationGetTemplateID(ETFont paramETFont, int paramInt1, int paramInt2, int paramInt3);
  
  public native int native_decorationGetTempletIndex(long paramLong);
  
  public native int native_decorationGetType(long paramLong);
  
  public native long native_diyFontCreateNativeConfig(ETFont paramETFont, byte[] paramArrayOfByte);
  
  public native void native_diyFontDeleteNativeConfig(long paramLong);
  
  public native void native_diyFontDrawChar(int paramInt1, ETFont paramETFont, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public native void native_diyFontDrawGlyph(int paramInt1, ETFont paramETFont, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean);
  
  public native int[] native_diyFontGetAccessoryList(ETFont paramETFont);
  
  public native int native_diyFontGetCharIndex(int paramInt, ETFont paramETFont);
  
  public native int native_diyFontGetColorStyleCount(ETFont paramETFont);
  
  public native int native_diyFontGetCurrentColorStyle(ETFont paramETFont);
  
  public native int native_diyFontGetCurrentThemeStyle(ETFont paramETFont);
  
  public native boolean native_diyFontGetGlyphBound(int paramInt, ETFont paramETFont, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Rect paramRect);
  
  public native int native_diyFontGetSdkVersion();
  
  public native int native_diyFontGetThemeStyleCount(ETFont paramETFont);
  
  public native int native_diyFontGetUPEM(ETFont paramETFont);
  
  public native int native_diyFontGetVersion(ETFont paramETFont);
  
  public native boolean native_diyFontIsDIYFont(ETFont paramETFont);
  
  public native void native_doneEngine();
  
  public native boolean native_drawBackground(String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, ETFont paramETFont);
  
  public native boolean native_drawInRect(String paramString, Bitmap paramBitmap, ETFont paramETFont);
  
  public native boolean native_drawText(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont);
  
  public native long native_emoticonCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, ETFont paramETFont, int paramInt2);
  
  public native EMImage native_emoticonCreateImage(String paramString, int paramInt, ETFont paramETFont);
  
  public native void native_emoticonDeleteDescriptor(long paramLong);
  
  public native void native_emoticonDrawFrame(long paramLong, int paramInt, ETFont paramETFont, Bitmap paramBitmap);
  
  public native int native_emoticonGetFrameDelay(long paramLong, int paramInt);
  
  public native int native_emoticonGetFrameNum(long paramLong);
  
  public native int native_emoticonGetHeight(long paramLong);
  
  public native int native_emoticonGetHeightByIndex(int paramInt, ETFont paramETFont);
  
  public native int native_emoticonGetWidth(long paramLong);
  
  public native int native_emoticonGetWidthByIndex(int paramInt, ETFont paramETFont);
  
  public native int[] native_emoticonRetrieveCollection(String paramString, int paramInt, ETFont paramETFont);
  
  public native int native_getFontCategory(ETFont paramETFont);
  
  public native boolean native_getFontMetrics(Paint.FontMetrics paramFontMetrics, ETFont paramETFont);
  
  public native int native_getHorizontalMarginThreshold(ETFont paramETFont, int paramInt);
  
  public native Rect native_getMargins(long paramLong);
  
  public native int native_getTextColor(ETFont paramETFont);
  
  public native boolean native_getTextWidths(String paramString, ETFont paramETFont, Paint paramPaint, int[] paramArrayOfInt);
  
  public native int native_getVariantStyleComboCount(ETFont paramETFont);
  
  public native boolean native_initEngine(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native boolean native_isColorVariantFont(ETFont paramETFont);
  
  public native boolean native_isDecorationFont(ETFont paramETFont);
  
  public native boolean native_isFontLoaded(int paramInt);
  
  public native boolean native_isHiboomFont(ETFont paramETFont);
  
  public native boolean native_isPaintableChar(char paramChar, ETFont paramETFont);
  
  public native boolean native_loadFont(String paramString, int paramInt, boolean paramBoolean);
  
  public native int native_matchTextStyle(ETFont paramETFont, String paramString);
  
  public native boolean native_measure(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Rect paramRect);
  
  public native void native_printTrace();
  
  public native void native_resetEngine();
  
  public native boolean native_setPersistentFont(ETFont paramETFont);
  
  public native void native_spaceDrawText(String paramString, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint);
  
  public native int native_spaceGetTextWidths(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint, int[] paramArrayOfInt);
  
  public native int native_spaceMeasureText(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint);
  
  public native long native_space_decorationCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, ETFont paramETFont);
  
  public native void native_space_decorationDeleteDescriptor(long paramLong);
  
  public native void native_space_decorationDrawBackground(long paramLong, int paramInt1, ETFont paramETFont, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public native boolean native_space_decorationDrawScene(long paramLong, int paramInt1, ETFont paramETFont, Object[] paramArrayOfObject, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public native int native_space_decorationGetFrameDelay(long paramLong, int paramInt);
  
  public native int native_space_decorationGetFrameNum(long paramLong);
  
  public native int native_space_getFontType(ETFont paramETFont);
  
  public native int native_space_getHorizontalMarginThreshold(ETFont paramETFont, int paramInt);
  
  public native Rect native_space_getMargins(long paramLong);
  
  public native boolean native_space_isDecorationFont(ETFont paramETFont);
  
  public native boolean native_textLayoutHasPreLine(long paramLong);
  
  public native int native_textLayoutLineHeight(long paramLong, int paramInt);
  
  public native int native_textLayoutLineRangeFrom(long paramLong, int paramInt);
  
  public native int native_textLayoutLineRangeTo(long paramLong, int paramInt);
  
  public native int native_textLayoutLineTotal(long paramLong);
  
  public native int native_textLayoutLineWidth(long paramLong, int paramInt);
  
  public native long native_textLayoutLock(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETFont paramETFont);
  
  public native void native_textLayoutUnlock(long paramLong);
  
  public void onAIODestroy()
  {
    this.mCanvas = null;
    Object localObject = this.mBitmaps;
    if (localObject != null)
    {
      int i = localObject.length - 1;
      while (i >= 0)
      {
        localObject = this.mBitmaps[i];
        if (localObject != null) {
          ((Bitmap)localObject).recycle();
        }
        i -= 1;
      }
    }
    this.mBitmaps = null;
  }
  
  public void printLog(String paramString)
  {
    Log.e("ETEngine", paramString);
  }
  
  public void spaceCallbackDrawText(String paramString, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    paramPaint = new Paint();
    paramPaint.setColor(paramInt5);
    paramPaint.setAntiAlias(true);
    paramPaint.setDither(true);
    float f1 = paramInt4;
    paramPaint.setTextSize(f1);
    if ((paramInt6 & 0x80) > 0) {
      paramPaint.setShadowLayer(paramInt10, paramInt8, paramInt9, paramInt7);
    }
    if ((paramInt6 & 0x1) > 0) {
      paramPaint.setFakeBoldText(true);
    }
    paramInt3 = Math.abs(paramInt3);
    float f2 = paramInt1;
    float f3 = paramInt3 + paramInt2;
    paramCanvas.drawText(paramString, f2, f3, paramPaint);
    if ((paramInt6 & 0x8) > 0)
    {
      paramPaint = new Paint(1);
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setColor(paramInt11);
      paramPaint.setStrokeWidth(paramInt12 / 2.0F);
      paramPaint.setTextSize(f1);
      paramCanvas.drawText(paramString, f2, f3, paramPaint);
    }
  }
  
  public int spaceCallbackGetTextWidths(String paramString, Paint paramPaint, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    paramPaint = new Paint();
    paramPaint.setTextSize(paramInt1);
    if ((paramInt3 & 0x80) > 0) {
      paramPaint.setShadowLayer(paramInt7, paramInt5, paramInt6, paramInt4);
    }
    if ((paramInt3 & 0x8) > 0) {
      paramPaint.setStrokeWidth(paramInt9);
    }
    float[] arrayOfFloat = new float[paramArrayOfInt.length];
    paramInt2 = paramPaint.getTextWidths(paramString, arrayOfFloat);
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramArrayOfInt[paramInt1] = ((int)Math.ceil(arrayOfFloat[paramInt1]));
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public int spaceCallbackMeasureText(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    paramPaint = new Paint();
    paramPaint.setTextSize(paramInt1);
    if ((paramInt3 & 0x80) > 0) {
      paramPaint.setShadowLayer(paramInt7, paramInt5, paramInt6, paramInt4);
    }
    if ((paramInt3 & 0x8) > 0) {
      paramPaint.setStrokeWidth(paramInt9);
    }
    return (int)Math.ceil(paramPaint.measureText(paramString));
  }
  
  public void sysDrawText(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    if (this.mCanvas == null) {
      this.mCanvas = new Canvas();
    }
    this.mCanvas.setBitmap(paramBitmap);
    paramInt6 = Math.abs(paramInt6);
    this.mPaint.reset();
    this.mPaint.setColor(paramInt2);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    paramBitmap = this.mPaint;
    float f2 = paramInt1;
    paramBitmap.setTextSize(f2);
    paramInt1 = paramInt3 & 0x80;
    float f1 = 0.01F;
    if ((paramInt1 > 0) && ((paramInt3 & 0x8) > 0))
    {
      if (paramInt10 != 0) {
        f1 = paramInt10;
      }
      this.mPaint.setShadowLayer(f1, paramInt8, paramInt9, paramInt7);
      paramBitmap = this.mCanvas;
      f1 = paramInt4;
      float f3 = paramInt5 + paramInt6;
      paramBitmap.drawText(paramString, f1, f3, this.mPaint);
      paramBitmap = new Paint(1);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setColor(paramInt11);
      paramBitmap.setStrokeWidth(paramInt12 / 2.0F);
      paramBitmap.setTextSize(f2);
      this.mCanvas.drawText(paramString, f1, f3, paramBitmap);
      this.mPaint.clearShadowLayer();
    }
    else
    {
      if ((paramInt3 & 0x8) > 0)
      {
        paramBitmap = new Paint(1);
        paramBitmap.setStyle(Paint.Style.STROKE);
        paramBitmap.setColor(paramInt11);
        paramBitmap.setStrokeWidth(paramInt12 / 2.0F);
        paramBitmap.setTextSize(f2);
        this.mCanvas.drawText(paramString, paramInt4, paramInt5 + paramInt6, paramBitmap);
      }
      if (paramInt1 > 0)
      {
        if (paramInt10 != 0) {
          f1 = paramInt10;
        }
        this.mPaint.setShadowLayer(f1, paramInt8, paramInt9, paramInt7);
      }
    }
    this.mCanvas.drawText(paramString, paramInt4, paramInt5 + paramInt6, this.mPaint);
  }
  
  public int sysFontHeight(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    paramString = this.mPaint;
    float f3 = paramInt1;
    paramString.setTextSize(f3);
    if ((paramInt2 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt6, paramInt4, paramInt5, paramInt3);
    }
    paramString = this.mPaint.getFontMetrics();
    float f2 = paramString.bottom - paramString.top;
    float f1 = f2;
    if ((paramInt2 & 0x8) > 0)
    {
      paramString = new Paint(1);
      paramString.setStyle(Paint.Style.STROKE);
      paramString.setColor(paramInt7);
      paramString.setStrokeWidth(paramInt8);
      paramString.setTextSize(f3);
      paramString = paramString.getFontMetrics();
      f1 = paramString.bottom - paramString.top;
      if (f2 > f1) {
        f1 = f2;
      }
    }
    return (int)f1;
  }
  
  public int sysMeasureText(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    Paint localPaint = this.mPaint;
    float f3 = paramInt1;
    localPaint.setTextSize(f3);
    if ((paramInt2 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt6, paramInt4, paramInt5, paramInt3);
    }
    float f2 = this.mPaint.measureText(paramString);
    float f1 = f2;
    if ((paramInt2 & 0x8) > 0)
    {
      localPaint = new Paint(1);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setColor(paramInt7);
      localPaint.setStrokeWidth(paramInt8);
      localPaint.setTextSize(f3);
      f1 = localPaint.measureText(paramString);
      if (f2 > f1) {
        f1 = f2;
      }
    }
    return (int)f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETEngine
 * JD-Core Version:    0.7.0.1
 */