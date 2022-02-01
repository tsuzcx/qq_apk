package com.tencent.biz.qqcircle.publish.uploader;

import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import cooperation.qqcircle.utils.NetworkState.NetworkStateListener;

class QcircleUploadEnv$1
  implements NetworkState.NetworkStateListener
{
  QcircleUploadEnv$1(QcircleUploadEnv paramQcircleUploadEnv, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：");
      localStringBuilder.append(paramBoolean);
      QLog.d("[upload2]QcircleUploadEnv", 2, localStringBuilder.toString());
    }
    QcircleUploadEnv.a(this.b, paramBoolean);
    this.a.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadEnv.1
 * JD-Core Version:    0.7.0.1
 */