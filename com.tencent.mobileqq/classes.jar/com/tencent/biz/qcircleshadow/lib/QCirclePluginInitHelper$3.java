package com.tencent.biz.qcircleshadow.lib;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class QCirclePluginInitHelper$3
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null)
    {
      QLog.w("QCirclePluginInitHelper", 1, "cancelQzoneAlive... app == null");
      return;
    }
    QZoneHelper.cancelQzoneAlive(localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper.3
 * JD-Core Version:    0.7.0.1
 */