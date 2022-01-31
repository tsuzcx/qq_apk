package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public class ETEngine
{
  private static final int ETRUMP_FONT_SIZE_MINIMUM = 24;
  public static final int STYLE_BOLD = 1;
  public static final int STYLE_CROCHET = 8;
  public static final int STYLE_REGULAR = 0;
  public static final int STYLE_SHADOW = 128;
  public static final String TAG = "ETEngine";
  public static AtomicBoolean isSOLoaded = new AtomicBoolean(false);
  private static ETEngine sInstance;
  private static ETEngine sInstanceDiyAddon;
  private static ETEngine sInstanceHiBoom;
  private static ETEngine sInstanceRP;
  private static ETEngine sInstanceSpace;
  private static final int sMemPoolSize = 1048576;
  public AtomicBoolean isEngineInited = new AtomicBoolean(false);
  public AtomicBoolean isEngineReady = new AtomicBoolean(false);
  private Canvas mCanvas;
  private final boolean mEnableCallbackDrawing = true;
  private boolean mInitialized;
  private long mNativeFontManagerHandle;
  private Paint mPaint;
  
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
  
  public static ETEngine getInstanceForDiyPendant()
  {
    if (sInstanceDiyAddon == null) {
      sInstanceDiyAddon = new ETEngine();
    }
    return sInstanceDiyAddon;
  }
  
  public static ETEngine getInstanceForHiBoom()
  {
    try
    {
      if (sInstanceHiBoom == null) {
        sInstanceHiBoom = new ETEngine();
      }
      ETEngine localETEngine = sInstanceHiBoom;
      return localETEngine;
    }
    finally {}
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
    if (sInstanceSpace == null) {
      sInstanceSpace = new ETEngine();
    }
    return sInstanceSpace;
  }
  
  public static native boolean native_ftf2ttf(String paramString1, String paramString2);
  
  public static native int native_getFontType(String paramString);
  
  public static native boolean native_quickCheck(String paramString1, String paramString2);
  
  public boolean initEngine(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!isSOLoaded.get()) {
      bool = false;
    }
    while (native_initEngine(paramInt1, paramInt2, true)) {
      return bool;
    }
    throw new Exception("init engine fail");
  }
  
  public boolean isEnableCallbackDrawing()
  {
    return true;
  }
  
  public native void native_colorDisableEffects(ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public native boolean native_containComplexScript(String paramString);
  
  public native long native_decorationCreateDescriptor(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETFont paramETFont);
  
  public native void native_decorationDeleteDescriptor(long paramLong);
  
  public native void native_decorationDrawBackground(long paramLong, int paramInt, ETFont paramETFont, Bitmap paramBitmap);
  
  public native void native_decorationDrawForeground(long paramLong, int paramInt, ETFont paramETFont, Bitmap paramBitmap);
  
  public native boolean native_decorationDrawText(long paramLong, int paramInt1, int paramInt2, int paramInt3, ETFont paramETFont, Bitmap paramBitmap, int paramInt4, int paramInt5);
  
  public native int native_decorationGetFrameDelay(long paramLong, int paramInt);
  
  public native int native_decorationGetFrameNum(long paramLong);
  
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
  
  public native int native_diyFontGetThemeStyleCount(ETFont paramETFont);
  
  public native int native_diyFontGetUPEM(ETFont paramETFont);
  
  public native int native_diyFontGetVersion(ETFont paramETFont);
  
  public native boolean native_diyFontIsDIYFont(ETFont paramETFont);
  
  public native void native_doneEngine();
  
  public native boolean native_drawBackground(String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, ETFont paramETFont);
  
  public native boolean native_drawInRect(String paramString, Bitmap paramBitmap, ETFont paramETFont);
  
  public native boolean native_drawText(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont);
  
  public native long native_emoticonCreateDescriptor(String paramString, int paramInt, ETFont paramETFont);
  
  public native EMImage native_emoticonCreateImage(String paramString, int paramInt, ETFont paramETFont);
  
  public native void native_emoticonDeleteDescriptor(long paramLong);
  
  public native void native_emoticonDrawFrame(long paramLong, int paramInt, ETFont paramETFont, Bitmap paramBitmap);
  
  public native int native_emoticonGetFrameDelay(long paramLong, int paramInt);
  
  public native int native_emoticonGetFrameNum(long paramLong);
  
  public native int native_emoticonGetHeight(long paramLong);
  
  public native int native_emoticonGetWidth(long paramLong);
  
  public native int[] native_emoticonRetrieveCollection(String paramString, ETFont paramETFont);
  
  public native boolean native_getFontMetrics(Paint.FontMetrics paramFontMetrics, ETFont paramETFont);
  
  public native boolean native_initEngine(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native boolean native_isDecorationFont(String paramString);
  
  public native boolean native_isFontLoaded(int paramInt);
  
  public native boolean native_isPaintableChar(char paramChar, ETFont paramETFont);
  
  public native boolean native_loadFont(String paramString, int paramInt, boolean paramBoolean);
  
  public native boolean native_measure(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Rect paramRect);
  
  public native void native_printTrace();
  
  public native boolean native_setPersistentFont(ETFont paramETFont);
  
  public native void native_spaceDrawText(String paramString, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint);
  
  public native int native_spaceGetTextWidths(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint, int[] paramArrayOfInt);
  
  public native int native_spaceMeasureText(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint);
  
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
    paramPaint.setTextSize(paramInt4);
    if ((paramInt6 & 0x80) > 0) {
      paramPaint.setShadowLayer(paramInt10, paramInt8, paramInt9, paramInt7);
    }
    if ((paramInt6 & 0x1) > 0) {
      paramPaint.setFakeBoldText(true);
    }
    paramInt3 = Math.abs(paramInt3);
    paramCanvas.drawText(paramString, paramInt1, paramInt2 + paramInt3, paramPaint);
    if ((paramInt6 & 0x8) > 0)
    {
      paramPaint = new Paint(1);
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setColor(paramInt11);
      paramPaint.setStrokeWidth(paramInt12 / 2.0F);
      paramPaint.setTextSize(paramInt4);
      paramCanvas.drawText(paramString, paramInt1, paramInt3 + paramInt2, paramPaint);
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
    this.mPaint.setColor(paramInt2);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setTextSize(paramInt1);
    this.mPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.mPaint.setFakeBoldText(false);
    if ((paramInt3 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt10, paramInt8, paramInt9, paramInt7);
    }
    if (this.mCanvas == null) {
      this.mCanvas = new Canvas();
    }
    paramInt2 = Math.abs(paramInt6);
    this.mCanvas.setBitmap(paramBitmap);
    this.mCanvas.drawText(paramString, paramInt4, paramInt5 + paramInt2, this.mPaint);
    if ((paramInt3 & 0x8) > 0)
    {
      paramBitmap = new Paint(1);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setColor(paramInt11);
      paramBitmap.setStrokeWidth(paramInt12);
      paramBitmap.setTextSize(paramInt1);
      this.mCanvas.drawText(paramString, paramInt4, paramInt2 + paramInt5, paramBitmap);
    }
  }
  
  public int sysFontHeight(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setTextSize(paramInt1);
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
      paramString.setTextSize(paramInt1);
      paramString = paramString.getFontMetrics();
      f1 = paramString.bottom - paramString.top;
      if (f2 <= f1) {
        break label150;
      }
      f1 = f2;
    }
    label150:
    for (;;)
    {
      return (int)f1;
    }
  }
  
  public int sysMeasureText(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mPaint == null) {
      this.mPaint = new Paint();
    }
    this.mPaint.setTextSize(paramInt1);
    if ((paramInt2 & 0x80) > 0) {
      this.mPaint.setShadowLayer(paramInt6, paramInt4, paramInt5, paramInt3);
    }
    float f2 = this.mPaint.measureText(paramString);
    float f1 = f2;
    if ((paramInt2 & 0x8) > 0)
    {
      Paint localPaint = new Paint(1);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setColor(paramInt7);
      localPaint.setStrokeWidth(paramInt8);
      localPaint.setTextSize(paramInt1);
      f1 = localPaint.measureText(paramString);
      if (f2 <= f1) {
        break label138;
      }
      f1 = f2;
    }
    label138:
    for (;;)
    {
      return (int)f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETEngine
 * JD-Core Version:    0.7.0.1
 */