package com.tencent.mobileqq.app;

import android.graphics.Bitmap;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

class CardHandler$5
  extends VipUploadConfigImpl
{
  CardHandler$5(CardHandler paramCardHandler, long paramLong)
  {
    super(paramLong);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    paramUploadImageSize = VipUploadUtils.a(paramAbstractUploadTask.uploadFilePath);
    if (paramUploadImageSize != null)
    {
      paramAbstractUploadTask = new IUploadConfig.UploadImageSize(paramUploadImageSize.getWidth(), paramUploadImageSize.getHeight(), 100);
      paramUploadImageSize.recycle();
      return paramAbstractUploadTask;
    }
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.5
 * JD-Core Version:    0.7.0.1
 */