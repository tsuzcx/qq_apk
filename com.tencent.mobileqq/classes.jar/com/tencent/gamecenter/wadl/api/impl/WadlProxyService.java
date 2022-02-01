package com.tencent.gamecenter.wadl.api.impl;

import android.content.ServiceConnection;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginOpenParams.Builder;
import mqq.app.MobileQQ;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    WLog.c("WadlProxyService", "bindWadlService proxy WadlRemoteService");
    QRoutePluginOpenParams.Builder localBuilder = new QRoutePluginOpenParams.Builder();
    localBuilder.setComponentName("com.tencent.gamecenter.wadl.ipc.WadlRemoteService").setComponentProxyClass(WadlProxyService.class).setPluginName("qqwadl").setContext(MobileQQ.sMobileQQ);
    QRoute.plugin("qqwadl.apk").bindService(localBuilder.build(), paramServiceConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */