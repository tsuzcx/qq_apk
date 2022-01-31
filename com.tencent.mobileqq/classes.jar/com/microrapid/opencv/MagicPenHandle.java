package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.filter.QImage;
import com.tencent.util.BitmapUtils;
import com.tencent.view.FilterDefault;

public class MagicPenHandle
{
  private boolean available = false;
  private int height;
  private final long nativeObj = nativeMagicPen();
  private int width;
  
  private void checkavailable()
  {
    if ((!this.available) || (this.nativeObj == 0L)) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  private native void nativeAddCenterToList(long paramLong, float paramFloat1, float paramFloat2);
  
  private native boolean nativeCanRedo(long paramLong);
  
  private native boolean nativeCanUndo(long paramLong);
  
  private native void nativeCleanCenterList(long paramLong);
  
  private native void nativeDispose(long paramLong);
  
  private native void nativeEnablePatternColor(long paramLong, boolean paramBoolean);
  
  private native int[] nativeGetSelectRect(long paramLong);
  
  private native void nativeIsFollowDirection(long paramLong, boolean paramBoolean);
  
  private native long nativeMagicPen();
  
  private native void nativeProcessImage(long paramLong);
  
  private native void nativeRSSColor(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeRedo(long paramLong);
  
  private native void nativeResetPoints(long paramLong);
  
  private native void nativeSetOptMode(long paramLong, int paramInt);
  
  private native void nativeSetPaintAlpha(long paramLong, float paramFloat);
  
  private native void nativeSetPaintMode(long paramLong, int paramInt);
  
  private native void nativeSetPaintSubMode(long paramLong, int paramInt);
  
  private native void nativeSetPatternImageList(long paramLong, Bitmap[] paramArrayOfBitmap);
  
  private native void nativeSetRadius(long paramLong, float paramFloat);
  
  private native void nativeSetTileRatio(long paramLong, float paramFloat);
  
  private native void nativeTouchBegin(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeTouchCancel(long paramLong);
  
  private native void nativeTouchEnd(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeTouchMove(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeUndo(long paramLong);
  
  private native long nativeUpdateAlphaBitmap(long paramLong, Bitmap paramBitmap);
  
  private native void nativeUpdateMosaicAlignType(long paramLong, int paramInt);
  
  private native void nativeUpdateMosaicHorizontalSpace(long paramLong, float paramFloat);
  
  private native void nativeUpdateMosaicVerticalSpace(long paramLong, float paramFloat);
  
  private native void nativeUpdatePatternIntervalRatioWidth(long paramLong, float paramFloat);
  
  private native long nativeUpdateSrcImage(long paramLong, QImage paramQImage);
  
  public void addCenterToList(float paramFloat1, float paramFloat2)
  {
    checkavailable();
    nativeAddCenterToList(this.nativeObj, paramFloat1, paramFloat2);
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
  
  public void cleanCenterList()
  {
    checkavailable();
    nativeCleanCenterList(this.nativeObj);
  }
  
  public void dispose()
  {
    if (this.available)
    {
      nativeDispose(this.nativeObj);
      this.available = false;
    }
  }
  
  public void enablePatternColor(boolean paramBoolean)
  {
    checkavailable();
    nativeEnablePatternColor(this.nativeObj, paramBoolean);
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
  
  public void initAlphaMask()
  {
    checkavailable();
    Bitmap localBitmap = FilterDefault.decodeBitmap("magicpen/colorpen.png");
    if (localBitmap != null)
    {
      nativeUpdateAlphaBitmap(this.nativeObj, localBitmap);
      BitmapUtils.recycle(localBitmap);
    }
  }
  
  public void isFollowDirection(boolean paramBoolean)
  {
    checkavailable();
    nativeIsFollowDirection(this.nativeObj, paramBoolean);
  }
  
  public void processImage()
  {
    checkavailable();
    nativeProcessImage(this.nativeObj);
  }
  
  public void redo()
  {
    checkavailable();
    nativeRedo(this.nativeObj);
  }
  
  public void resetPoints()
  {
    checkavailable();
    nativeResetPoints(this.nativeObj);
  }
  
  public void setBrushColor(int paramInt1, int paramInt2, int paramInt3)
  {
    checkavailable();
    nativeRSSColor(this.nativeObj, paramInt1, paramInt2, paramInt3);
  }
  
  public void setOptMode(int paramInt)
  {
    checkavailable();
    nativeSetOptMode(this.nativeObj, paramInt);
  }
  
  public void setPaintAlpha(float paramFloat)
  {
    checkavailable();
    nativeSetPaintAlpha(this.nativeObj, paramFloat);
  }
  
  public void setPaintMode(int paramInt)
  {
    checkavailable();
    nativeSetPaintMode(this.nativeObj, paramInt);
  }
  
  public void setPaintRadius(float paramFloat)
  {
    checkavailable();
    nativeSetRadius(this.nativeObj, paramFloat);
  }
  
  public void setPaintSubMode(int paramInt)
  {
    checkavailable();
    nativeSetPaintSubMode(this.nativeObj, paramInt);
  }
  
  public void setPatternImageList(Bitmap[] paramArrayOfBitmap)
  {
    checkavailable();
    nativeSetPatternImageList(this.nativeObj, paramArrayOfBitmap);
  }
  
  public void setTileRatio(float paramFloat)
  {
    checkavailable();
    nativeSetTileRatio(this.nativeObj, paramFloat);
  }
  
  public void touchBegin(int paramInt1, int paramInt2)
  {
    checkavailable();
    nativeTouchBegin(this.nativeObj, paramInt1, paramInt2);
  }
  
  public void touchCancel()
  {
    checkavailable();
    nativeTouchCancel(this.nativeObj);
  }
  
  public void touchEnd(int paramInt1, int paramInt2)
  {
    checkavailable();
    nativeTouchEnd(this.nativeObj, paramInt1, paramInt2);
  }
  
  public void touchMove(int paramInt1, int paramInt2)
  {
    checkavailable();
    nativeTouchMove(this.nativeObj, paramInt1, paramInt2);
  }
  
  public void undo()
  {
    checkavailable();
    nativeUndo(this.nativeObj);
  }
  
  public void updateMosaicAlignType(int paramInt)
  {
    checkavailable();
    nativeUpdateMosaicAlignType(this.nativeObj, paramInt);
  }
  
  public void updateMosaicHorizontalSpace(float paramFloat)
  {
    checkavailable();
    nativeUpdateMosaicHorizontalSpace(this.nativeObj, paramFloat);
  }
  
  public void updateMosaicVerticalSpace(float paramFloat)
  {
    checkavailable();
    nativeUpdateMosaicVerticalSpace(this.nativeObj, paramFloat);
  }
  
  public void updatePatternIntervalRatioWidth(float paramFloat)
  {
    checkavailable();
    nativeUpdatePatternIntervalRatioWidth(this.nativeObj, paramFloat);
  }
  
  public void updateSrcImage(QImage paramQImage)
  {
    checkavailable();
    this.width = paramQImage.getWidth();
    this.height = paramQImage.getHeight();
    nativeUpdateSrcImage(this.nativeObj, paramQImage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.MagicPenHandle
 * JD-Core Version:    0.7.0.1
 */