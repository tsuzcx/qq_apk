package com.tencent.gamecenter.wadl.api.impl;

import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams.Builder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class WadlProxyService
  extends PluginProxyService
{
  public static void a(ServiceConnection paramServiceConnection)
  {
    QLog.i("Wadl_WadlProxyService", 1, "bindWadlService proxy WadlRemoteService");
    QRoutePluginServiceParams.Builder localBuilder = new QRoutePluginServiceParams.Builder(MobileQQ.getContext());
    localBuilder.setServiceName("com.tencent.gamecenter.wadl.ipc.WadlRemoteService").setServiceProxy(WadlProxyService.class).setContext(MobileQQ.sMobileQQ);
    IQRoutePlugin localIQRoutePlugin = QRoute.plugin("qqwadl.apk");
    if (localIQRoutePlugin != null) {
      localIQRoutePlugin.bindService(localBuilder.build(), paramServiceConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.WadlProxyService
 * JD-Core Version:    0.7.0.1
 */