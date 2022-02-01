package com.tencent.biz.qqcircle.flutter;

import android.os.Handler;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;
import com.tencent.qphone.base.util.QLog;

final class QCircleFlutterUtils$1
  implements FlutterInstallCallBack
{
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onProgress] progress=");
      localStringBuilder.append(paramInt);
      QLog.d("QCircleFlutterUtils", 2, localStringBuilder.toString());
    }
  }
  
  public void onResult(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onResult] success=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", installDir=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isEngineExist=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", isAppExist=");
      localStringBuilder.append(paramBoolean3);
      QLog.d("QCircleFlutterUtils", 2, localStringBuilder.toString());
    }
    QCircleFlutterUtils.a(paramBoolean1);
    if ((QCircleFlutterUtils.d()) && (QCircleHostConstants._AppSetting.isDebugVersion())) {
      RFThreadManager.getUIHandler().postDelayed(new QCircleFlutterUtils.1.1(this), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils.1
 * JD-Core Version:    0.7.0.1
 */