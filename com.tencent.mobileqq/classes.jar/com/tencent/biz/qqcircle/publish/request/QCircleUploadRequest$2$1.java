package com.tencent.biz.qqcircle.publish.request;

import com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

class QCircleUploadRequest$2$1
  implements IAEKitResult
{
  QCircleUploadRequest$2$1(QCircleUploadRequest.2 param2) {}
  
  public void onDone(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retCode:");
    localStringBuilder.append(paramInt);
    QLog.d("[upload2_QCircleUploadRequest]", 1, localStringBuilder.toString());
    QCircleUploadRequest.b(this.a.this$0, paramInt);
    if ((paramInt == 0) && (QCircleConfigHelper.an()))
    {
      QCircleUploadRequest.a(this.a.this$0, true);
      QCircleHostAEHelper.requestGenerateVideo(QCircleUploadRequest.d(this.a.this$0));
      return;
    }
    QCircleUploadRequest.a(this.a.this$0, false);
    QCircleHostAEHelper.retryMission(QCircleUploadRequest.d(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.request.QCircleUploadRequest.2.1
 * JD-Core Version:    0.7.0.1
 */