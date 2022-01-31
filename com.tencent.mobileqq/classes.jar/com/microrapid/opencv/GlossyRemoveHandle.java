package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.filter.MRect;
import com.tencent.filter.QImage;
import com.tencent.util.BitmapUtils;
import com.tencent.util.LogUtil;
import com.tencent.view.FilterDefault;

public class GlossyRemoveHandle
{
  private boolean available = false;
  private final long nativeObj = nativeHighLightRemoval();
  
  private void checkavailable()
  {
    if (!this.available) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  private static native void nativeDispose(long paramLong);
  
  private static native long nativeHighLightRemoval();
  
  private static native void nativeProcess(long paramLong, float paramFloat);
  
  private static native void nativeProcessNew(long paramLong, QImage paramQImage1, QImage paramQImage2, float paramFloat);
  
  private static native void nativeRest(long paramLong);
  
  private static native void nativeSetFaceInfo(long paramLong, MRect paramMRect1, MRect paramMRect2, MRect paramMRect3, MRect paramMRect4);
  
  private static native void nativeSetImage(long paramLong, QImage paramQImage);
  
  private static native void nativeSetNeedUpdate(long paramLong);
  
  private static native void nativeSetSkinYCbCrModel(long paramLong, Bitmap paramBitmap);
  
  public void dispose()
  {
    if (this.available)
    {
      LogUtil.v("filter", "GlossyRemoveHandle dispose");
      nativeDispose(this.nativeObj);
      this.available = false;
    }
  }
  
  public void initSkinMask()
  {
    Bitmap localBitmap = FilterDefault.decodeBitmap("cos/skin.png");
    if (localBitmap != null)
    {
      nativeSetSkinYCbCrModel(this.nativeObj, localBitmap);
      LogUtil.v("filter", "GlossyRemoveHandle initSkinMask");
      BitmapUtils.recycle(localBitmap);
    }
  }
  
  public void processImage(float paramFloat)
  {
    checkavailable();
    nativeProcess(this.nativeObj, paramFloat);
  }
  
  public void processImageNew(QImage paramQImage1, QImage paramQImage2, float paramFloat)
  {
    checkavailable();
    nativeProcessNew(this.nativeObj, paramQImage1, paramQImage2, paramFloat);
  }
  
  public void restImage()
  {
    checkavailable();
    nativeRest(this.nativeObj);
  }
  
  public void setFaceInfo(FaceParam paramFaceParam)
  {
    if (paramFaceParam != null)
    {
      LogUtil.v("filter", "GlossyRemoveHandle setFaceInfo");
      checkavailable();
      MRect localMRect1 = MRect.toMRect(paramFaceParam.mFace);
      MRect localMRect2 = MRect.toMRect(paramFaceParam.mLeftEye);
      MRect localMRect3 = MRect.toMRect(paramFaceParam.mRightEye);
      paramFaceParam = MRect.toMRect(paramFaceParam.mMouth);
      nativeSetFaceInfo(this.nativeObj, localMRect1, localMRect2, localMRect3, paramFaceParam);
    }
  }
  
  public void setImage(QImage paramQImage)
  {
    checkavailable();
    nativeSetImage(this.nativeObj, paramQImage);
    initSkinMask();
  }
  
  public void setNeedUpdate()
  {
    checkavailable();
    nativeSetNeedUpdate(this.nativeObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.GlossyRemoveHandle
 * JD-Core Version:    0.7.0.1
 */