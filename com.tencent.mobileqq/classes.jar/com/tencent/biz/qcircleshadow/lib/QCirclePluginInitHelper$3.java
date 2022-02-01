package com.tencent.biz.qcircleshadow.lib;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

final class QCirclePluginInitHelper$3
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {}
    while (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    QZoneHelper.cancelQzoneAlive((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper.3
 * JD-Core Version:    0.7.0.1
 */