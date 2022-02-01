package com.etrump.mixlayout.api;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.EMImage;
import com.etrump.mixlayout.ETSegment;

public abstract interface IETEngine
{
  public abstract void callbackDrawBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract Bitmap createBitmap(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract byte[] getPicture(String paramString);
  
  public abstract boolean initEngine(int paramInt1, int paramInt2);
  
  public abstract boolean isEnableCallbackDrawing();
  
  public abstract boolean nativeCloneBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public abstract long nativeCloneNativeSubstitutionConfig(long paramLong);
  
  public abstract void nativeColorDisableEffects(IETFont paramIETFont, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract boolean nativeContainComplexScript(String paramString);
  
  public abstract long nativeCreateNativeSubstitutionConfig(IETFont paramIETFont, byte[] paramArrayOfByte);
  
  public abstract long nativeDecorationCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, IETFont paramIETFont);
  
  public abstract void nativeDecorationDeleteDescriptor(long paramLong);
  
  public abstract void nativeDecorationDrawBackground(long paramLong, int paramInt, IETFont paramIETFont, Bitmap paramBitmap);
  
  public abstract void nativeDecorationDrawForeground(long paramLong, int paramInt, IETFont paramIETFont, Bitmap paramBitmap);
  
  public abstract boolean nativeDecorationDrawScene(long paramLong, int paramInt1, IETFont paramIETFont, Object[] paramArrayOfObject, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public abstract boolean nativeDecorationDrawText(long paramLong, int paramInt1, int paramInt2, int paramInt3, IETFont paramIETFont, Bitmap paramBitmap, int paramInt4, int paramInt5);
  
  public abstract boolean nativeDecorationDrawTextOnAnimatingEnd(long paramLong, IETFont paramIETFont);
  
  public abstract long nativeDecorationGetDescriptor(IETFont paramIETFont, String paramString, int paramInt1, int paramInt2);
  
  public abstract int nativeDecorationGetFrameDelay(long paramLong, int paramInt);
  
  public abstract int nativeDecorationGetFrameNum(long paramLong);
  
  public abstract int nativeDecorationGetTemplateID(IETFont paramIETFont, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int nativeDecorationGetTempletIndex(long paramLong);
  
  public abstract int nativeDecorationGetType(long paramLong);
  
  public abstract void nativeDeleteNativeSubstitutionConfig(long paramLong);
  
  public abstract long nativeDiyFontCreateNativeConfig(IETFont paramIETFont, byte[] paramArrayOfByte);
  
  public abstract void nativeDiyFontDeleteNativeConfig(long paramLong);
  
  public abstract void nativeDiyFontDrawChar(int paramInt1, IETFont paramIETFont, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public abstract void nativeDiyFontDrawGlyph(int paramInt1, IETFont paramIETFont, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean);
  
  public abstract int[] nativeDiyFontGetAccessoryList(IETFont paramIETFont);
  
  public abstract int nativeDiyFontGetCharIndex(int paramInt, IETFont paramIETFont);
  
  public abstract int nativeDiyFontGetColorStyleCount(IETFont paramIETFont);
  
  public abstract int nativeDiyFontGetCurrentColorStyle(IETFont paramIETFont);
  
  public abstract int nativeDiyFontGetCurrentThemeStyle(IETFont paramIETFont);
  
  public abstract boolean nativeDiyFontGetGlyphBound(int paramInt, IETFont paramIETFont, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Rect paramRect);
  
  public abstract int nativeDiyFontGetSdkVersion();
  
  public abstract int nativeDiyFontGetThemeStyleCount(IETFont paramIETFont);
  
  public abstract int nativeDiyFontGetUPEM(IETFont paramIETFont);
  
  public abstract int nativeDiyFontGetVersion(IETFont paramIETFont);
  
  public abstract boolean nativeDiyFontIsDIYFont(IETFont paramIETFont);
  
  public abstract void nativeDoneEngine();
  
  public abstract boolean nativeDrawBackground(String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, IETFont paramIETFont);
  
  public abstract boolean nativeDrawInRect(String paramString, Bitmap paramBitmap, IETFont paramIETFont);
  
  public abstract boolean nativeDrawText(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont);
  
  public abstract long nativeEmoticonCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, IETFont paramIETFont, int paramInt2);
  
  public abstract EMImage nativeEmoticonCreateImage(String paramString, int paramInt, IETFont paramIETFont);
  
  public abstract void nativeEmoticonDeleteDescriptor(long paramLong);
  
  public abstract void nativeEmoticonDrawFrame(long paramLong, int paramInt, IETFont paramIETFont, Bitmap paramBitmap);
  
  public abstract int nativeEmoticonGetFrameDelay(long paramLong, int paramInt);
  
  public abstract int nativeEmoticonGetFrameNum(long paramLong);
  
  public abstract int nativeEmoticonGetHeight(long paramLong);
  
  public abstract int nativeEmoticonGetHeightByIndex(int paramInt, IETFont paramIETFont);
  
  public abstract int nativeEmoticonGetWidth(long paramLong);
  
  public abstract int nativeEmoticonGetWidthByIndex(int paramInt, IETFont paramIETFont);
  
  public abstract int[] nativeEmoticonRetrieveCollection(String paramString, int paramInt, IETFont paramIETFont);
  
  public abstract boolean nativeFtf2ttf(String paramString1, String paramString2);
  
  public abstract int nativeGetFontCategory(IETFont paramIETFont);
  
  public abstract boolean nativeGetFontMetrics(Paint.FontMetrics paramFontMetrics, IETFont paramIETFont);
  
  public abstract int nativeGetFontType(String paramString);
  
  public abstract int nativeGetHorizontalMarginThreshold(IETFont paramIETFont, int paramInt);
  
  public abstract Rect nativeGetMargins(long paramLong);
  
  public abstract int nativeGetTextColor(IETFont paramIETFont);
  
  public abstract boolean nativeGetTextWidths(String paramString, IETFont paramIETFont, Paint paramPaint, int[] paramArrayOfInt);
  
  public abstract int nativeGetVariantStyleComboCount(IETFont paramIETFont);
  
  public abstract boolean nativeInitEngine(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract boolean nativeIsColorVariantFont(IETFont paramIETFont);
  
  public abstract boolean nativeIsDecorationFont(IETFont paramIETFont);
  
  public abstract boolean nativeIsFontLoaded(int paramInt);
  
  public abstract boolean nativeIsHiboomFont(IETFont paramIETFont);
  
  public abstract boolean nativeIsPaintableChar(char paramChar, IETFont paramIETFont);
  
  public abstract boolean nativeLoadFont(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract int nativeMatchTextStyle(IETFont paramIETFont, String paramString);
  
  public abstract boolean nativeMeasure(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Rect paramRect);
  
  public abstract void nativePrintTrace();
  
  public abstract boolean nativeQuickCheck(String paramString1, String paramString2);
  
  public abstract void nativeResetEngine();
  
  public abstract boolean nativeSetPersistentFont(IETFont paramIETFont);
  
  public abstract long nativeSpaceDecorationCreateDescriptor(String paramString, ETSegment[] paramArrayOfETSegment, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, IETFont paramIETFont);
  
  public abstract void nativeSpaceDecorationDeleteDescriptor(long paramLong);
  
  public abstract void nativeSpaceDecorationDrawBackground(long paramLong, int paramInt1, IETFont paramIETFont, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public abstract boolean nativeSpaceDecorationDrawScene(long paramLong, int paramInt1, IETFont paramIETFont, Object[] paramArrayOfObject, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public abstract int nativeSpaceDecorationGetFrameDelay(long paramLong, int paramInt);
  
  public abstract int nativeSpaceDecorationGetFrameNum(long paramLong);
  
  public abstract void nativeSpaceDrawText(String paramString, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint);
  
  public abstract int nativeSpaceGetFontType(IETFont paramIETFont);
  
  public abstract int nativeSpaceGetHorizontalMarginThreshold(IETFont paramIETFont, int paramInt);
  
  public abstract Rect nativeSpaceGetMargins(long paramLong);
  
  public abstract int nativeSpaceGetTextWidths(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint, int[] paramArrayOfInt);
  
  public abstract boolean nativeSpaceIsDecorationFont(IETFont paramIETFont);
  
  public abstract int nativeSpaceMeasureText(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint);
  
  public abstract boolean nativeTextLayoutHasPreLine(long paramLong);
  
  public abstract int nativeTextLayoutLineHeight(long paramLong, int paramInt);
  
  public abstract int nativeTextLayoutLineRangeFrom(long paramLong, int paramInt);
  
  public abstract int nativeTextLayoutLineRangeTo(long paramLong, int paramInt);
  
  public abstract int nativeTextLayoutLineTotal(long paramLong);
  
  public abstract int nativeTextLayoutLineWidth(long paramLong, int paramInt);
  
  public abstract long nativeTextLayoutLock(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IETFont paramIETFont);
  
  public abstract void nativeTextLayoutUnlock(long paramLong);
  
  public abstract void onAIODestroy();
  
  public abstract void printLog(String paramString);
  
  public abstract void spaceCallbackDrawText(String paramString, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  public abstract int spaceCallbackGetTextWidths(String paramString, Paint paramPaint, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public abstract int spaceCallbackMeasureText(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public abstract void sysDrawText(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  public abstract int sysFontHeight(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public abstract int sysMeasureText(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.api.IETEngine
 * JD-Core Version:    0.7.0.1
 */