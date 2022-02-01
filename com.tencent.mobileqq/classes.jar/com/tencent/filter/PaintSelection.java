package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class PaintSelection
{
  private boolean available = false;
  private int bpp;
  private int height;
  private final long nativeObj;
  private QImage srcimage;
  private int width;
  
  public PaintSelection(QImage paramQImage)
  {
    this.width = paramQImage.getWidth();
    this.height = paramQImage.getHeight();
    this.bpp = paramQImage.getPixelFormat();
    this.srcimage = paramQImage;
    this.nativeObj = nativePaintSection(this.srcimage);
    this.available = true;
  }
  
  public static native void FormatAlphaBitmap(Bitmap paramBitmap);
  
  public static native boolean HasAlphaBitmap(Bitmap paramBitmap);
  
  public static native void ProcessBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  private void checkavailable()
  {
    if (!this.available) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  private native void nativeAddRound(long paramLong, int paramInt1, int paramInt2, double paramDouble);
  
  private native void nativeDispose(long paramLong);
  
  private native byte[] nativeGetResult(long paramLong, int paramInt);
  
  private native int[] nativeGetSelectRect(long paramLong);
  
  private native int nativeGetcurrentUndoMark(long paramLong);
  
  private native void nativeInpaint(long paramLong);
  
  private native long nativePaintSection(QImage paramQImage);
  
  private native void nativeRedo(long paramLong);
  
  private native void nativeReverseSelected(long paramLong);
  
  private native void nativeRmRound(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  private native void nativeSetSelectionMode(long paramLong, int paramInt);
  
  private native void nativeTouchBegin(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeTouchMove(long paramLong, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
  
  private native void nativeUndo(long paramLong);
  
  private native void nativeUpdateUndoMark(long paramLong);
  
  public static native void reverseBitmapAlpha(Bitmap paramBitmap);
  
  private native void touchBegin1(int paramInt1, int paramInt2);
  
  public void addRound(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    checkavailable();
    nativeAddRound(this.nativeObj, paramInt3, paramInt4, paramDouble);
  }
  
  public void dispose()
  {
    if (this.available)
    {
      nativeDispose(this.nativeObj);
      this.srcimage.Dispose();
      this.srcimage = null;
      this.available = false;
    }
  }
  
  protected void finalize()
  {
    dispose();
    super.finalize();
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public byte[] getResult()
  {
    checkavailable();
    return nativeGetResult(this.nativeObj, this.width * this.height * this.bpp);
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
  
  public int getcurrentUndoMark()
  {
    checkavailable();
    return nativeGetcurrentUndoMark(this.nativeObj);
  }
  
  public QImage getimage()
  {
    checkavailable();
    return this.srcimage;
  }
  
  public void inpaint()
  {
    checkavailable();
    nativeInpaint(this.nativeObj);
  }
  
  public void redo()
  {
    checkavailable();
    nativeRedo(this.nativeObj);
  }
  
  public void reverseSelected()
  {
    checkavailable();
    nativeReverseSelected(this.nativeObj);
  }
  
  public void rmRound(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    checkavailable();
    nativeRmRound(this.nativeObj, paramInt1, paramInt2, paramInt3, paramInt4, paramDouble);
  }
  
  public void setSelectionMode(int paramInt)
  {
    checkavailable();
    nativeSetSelectionMode(this.nativeObj, paramInt);
  }
  
  public void touchBegin(int paramInt1, int paramInt2)
  {
    checkavailable();
    nativeTouchBegin(this.nativeObj, paramInt1, paramInt2);
  }
  
  public void touchMove(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    checkavailable();
    nativeTouchMove(this.nativeObj, paramInt1, paramInt2, paramDouble1, paramDouble2);
  }
  
  public void undo()
  {
    checkavailable();
    nativeUndo(this.nativeObj);
  }
  
  public void updateUndoMark()
  {
    checkavailable();
    nativeUpdateUndoMark(this.nativeObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.PaintSelection
 * JD-Core Version:    0.7.0.1
 */