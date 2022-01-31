package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.filter.MRect;

public class SketchHandle
{
  private boolean available = false;
  private final long nativeObj = nativeBokehProcess();
  
  private void checkavailable()
  {
    if (!this.available) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  private static native void nativeAutobodyCut(long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nativeAutobodyCut2(long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2, MRect paramMRect1, MRect paramMRect2, MRect paramMRect3);
  
  private static native long nativeBokehProcess();
  
  private static native void nativeDispose(long paramLong);
  
  public static native int nativeGetHandleWidth();
  
  private static native void nativeLanderBitmap(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeProcessBitmap(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeSetFaceFeatures(long paramLong, int[][] paramArrayOfInt);
  
  private static native void nativeSetFemale(long paramLong, boolean paramBoolean);
  
  private static native void nativeTestProcessBitmap(long paramLong, Bitmap paramBitmap, String paramString1, String paramString2);
  
  static MRect toMRect(Rect paramRect)
  {
    return new MRect(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
  }
  
  public void autoBodyCutWithFace(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    checkavailable();
    nativeAutobodyCut(this.nativeObj, paramBitmap1, paramBitmap2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void autoBodyCutWithFace(Bitmap paramBitmap1, Bitmap paramBitmap2, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    checkavailable();
    nativeAutobodyCut2(this.nativeObj, paramBitmap1, paramBitmap2, toMRect(paramRect1), toMRect(paramRect2), toMRect(paramRect3));
  }
  
  public void dispose()
  {
    if (this.available)
    {
      nativeDispose(this.nativeObj);
      this.available = false;
    }
  }
  
  public void landerBitmap(Bitmap paramBitmap)
  {
    checkavailable();
    nativeLanderBitmap(this.nativeObj, paramBitmap);
  }
  
  public void processBitmap(Bitmap paramBitmap)
  {
    checkavailable();
    nativeProcessBitmap(this.nativeObj, paramBitmap);
  }
  
  public void processTestBitmap(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    checkavailable();
    nativeTestProcessBitmap(this.nativeObj, paramBitmap, paramString1, paramString2);
  }
  
  public void setFaceFeatures(int[][] paramArrayOfInt)
  {
    checkavailable();
    nativeSetFaceFeatures(this.nativeObj, paramArrayOfInt);
  }
  
  public void setFemale(boolean paramBoolean)
  {
    checkavailable();
    nativeSetFemale(this.nativeObj, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.SketchHandle
 * JD-Core Version:    0.7.0.1
 */