package com.tencent.biz.qcircleshadow.local;

import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.qphone.base.util.QLog;

class QCircleShadow$1$1
  extends ILoadPluginDelegate
{
  QCircleShadow$1$1(QCircleShadow.1 param1, long paramLong) {}
  
  public void onLoadingFailed(int paramInt, String paramString)
  {
    QCirclePluginManager.a().b();
  }
  
  public void onLoadingSuccess()
  {
    QCirclePluginManager.a().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("back ground preload cost:");
    localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    QLog.d("QCIRCLE_PLUGIN", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleShadow.1.1
 * JD-Core Version:    0.7.0.1
 */