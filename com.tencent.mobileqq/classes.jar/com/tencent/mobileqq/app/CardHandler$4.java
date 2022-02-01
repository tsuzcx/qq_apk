package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.util.ArrayList;

class CardHandler$4
  implements IUploadTaskCallback
{
  CardHandler$4(CardHandler paramCardHandler) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUploadError ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" path:");
      localStringBuilder.append(paramAbstractUploadTask.uploadFilePath);
      QLog.e("Q.qzonephotowall", 2, localStringBuilder.toString());
    }
    this.a.notifyUI(69, false, new Object[] { paramAbstractUploadTask.uploadFilePath });
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2)
    {
      this.a.d = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "onUploadProgress is 100%");
      }
    }
  }
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt) {}
  
  public void onUploadSucceed(AbstractUploadTask arg1, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "onUploadSucceed ");
    }
    synchronized (CardHandler.c(this.a))
    {
      if (CardHandler.c(this.a).size() != 0) {
        CardHandler.b(this.a);
      } else {
        this.a.notifyUI(69, true, new Object[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.4
 * JD-Core Version:    0.7.0.1
 */