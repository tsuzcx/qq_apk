package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.filter.QImage;

public class LazyPaintSelect
{
  private boolean available = false;
  private int height;
  private final long nativeObj;
  private int width;
  
  public LazyPaintSelect(Bitmap paramBitmap)
  {
    this.width = paramBitmap.getWidth();
    this.height = paramBitmap.getHeight();
    this.nativeObj = nativeLazySnap(paramBitmap);
    this.available = true;
  }
  
  public static native void FormatAlphaBitmap(Bitmap paramBitmap);
  
  public static native void ProcessBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native void SmoothBitmapForManga(Bitmap paramBitmap);
  
  private void checkavailable()
  {
    if (!this.available) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  public static native byte[] getSrcAlphaBytes(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public static native void maskBitmapAlpha(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  private native void nativeAddEraser(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  private native void nativeAddPoints(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  private native boolean nativeCanRedo(long paramLong);
  
  private native boolean nativeCanUndo(long paramLong);
  
  private native boolean nativeCheckRedBack(long paramLong);
  
  private native void nativeDispose(long paramLong);
  
  private native int nativeGetLabelMode(long paramLong);
  
  private native int[] nativeGetSelectRect(long paramLong);
  
  private native void nativeInitForegroundMask(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  private native long nativeLazySnap(Bitmap paramBitmap);
  
  private native void nativeRedo(long paramLong);
  
  private native void nativeResetForegroundMask(long paramLong, QImage paramQImage);
  
  private native void nativeResetPoints(long paramLong);
  
  private native void nativeSetLabelMode(long paramLong, int paramInt);
  
  private native void nativeUndo(long paramLong);
  
  private native void nativeUpdateBitmap(long paramLong, Bitmap paramBitmap);
  
  private native void nativeUpdateEraser(long paramLong);
  
  private native void nativeUpdateForeBitmap(long paramLong, Bitmap paramBitmap);
  
  private native void nativeUpdateLazy(long paramLong);
  
  public static native void reverseBitmapAlpha(Bitmap paramBitmap);
  
  public boolean CheckRedBack()
  {
    checkavailable();
    return nativeCheckRedBack(this.nativeObj);
  }
  
  public void addEraser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    checkavailable();
    nativeAddEraser(this.nativeObj, paramInt1, paramInt2, paramInt3, paramInt4, paramDouble);
  }
  
  public void addPoints(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    checkavailable();
    nativeAddPoints(this.nativeObj, paramInt1, paramInt2, paramInt3, paramInt4, paramDouble);
  }
  
  public boolean canRedo()
  {
    checkavailable();
    return nativeCanRedo(this.nativeObj);
  }
  
  public boolean canUndo()
  {
    checkavailable();
    return nativeCanUndo(this.nativeObj);
  }
  
  public void dispose()
  {
    if (this.available)
    {
      nativeDispose(this.nativeObj);
      this.available = false;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public Rect getSelectRect()
  {
    checkavailable();
    int[] arrayOfInt = nativeGetSelectRect(this.nativeObj);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void initForegroundMask(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    checkavailable();
    nativeInitForegroundMask(this.nativeObj, paramArrayOfByte, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void redo()
  {
    checkavailable();
    nativeRedo(this.nativeObj);
  }
  
  public void resetForegroundMask(QImage paramQImage)
  {
    checkavailable();
    nativeResetForegroundMask(this.nativeObj, paramQImage);
  }
  
  public void resetPoints()
  {
    checkavailable();
    nativeResetPoints(this.nativeObj);
  }
  
  public void setSelectionMode(int paramInt)
  {
    checkavailable();
    nativeSetLabelMode(this.nativeObj, paramInt);
  }
  
  public void undo()
  {
    checkavailable();
    nativeUndo(this.nativeObj);
  }
  
  public void updateEraser()
  {
    checkavailable();
    nativeUpdateEraser(this.nativeObj);
  }
  
  public void updateLazy()
  {
    checkavailable();
    nativeUpdateLazy(this.nativeObj);
  }
  
  public void updateProcess(Bitmap paramBitmap)
  {
    checkavailable();
    nativeUpdateBitmap(this.nativeObj, paramBitmap);
  }
  
  public void updateProcessFroe(Bitmap paramBitmap)
  {
    checkavailable();
    nativeUpdateForeBitmap(this.nativeObj, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.LazyPaintSelect
 * JD-Core Version:    0.7.0.1
 */