package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class QCirclePluginInitHelper$1
  implements Runnable
{
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      return;
    }
    localObject = (IWebProcessManagerService)((AppRuntime)localObject).getRuntimeService(IWebProcessManagerService.class, "all");
    if (localObject != null) {
      ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper.1
 * JD-Core Version:    0.7.0.1
 */