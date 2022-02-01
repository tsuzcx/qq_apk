package com.tencent.biz.qcircleshadow.lib;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class QCirclePluginInitHelper$2
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null)
    {
      QLog.w("QCirclePluginInitHelper", 1, "preloadQZoneProcess... app == null");
      return;
    }
    QZoneHelper.preloadQzone(localAppRuntime, "QCircle", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper.2
 * JD-Core Version:    0.7.0.1
 */