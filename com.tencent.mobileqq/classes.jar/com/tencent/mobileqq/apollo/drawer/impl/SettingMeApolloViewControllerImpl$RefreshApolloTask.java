package com.tencent.mobileqq.apollo.drawer.impl;

import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

class SettingMeApolloViewControllerImpl$RefreshApolloTask
  implements Runnable
{
  private WeakReference<QQSettingMe> a;
  private WeakReference<SettingMeApolloViewControllerImpl> b;
  
  public SettingMeApolloViewControllerImpl$RefreshApolloTask(QQSettingMe paramQQSettingMe, SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl)
  {
    this.a = new WeakReference(paramQQSettingMe);
    this.b = new WeakReference(paramSettingMeApolloViewControllerImpl);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      localObject1 = (QQSettingMe)this.a.get();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = (QQAppInterface)((QQSettingMe)localObject1).h();
      if (localObject2 == null) {
        return;
      }
      localObject1 = (SettingMeApolloViewControllerImpl)this.b.get();
      if (localObject1 == null) {
        return;
      }
      CmShowStatUtil.b("drawer_pre");
      int i = TraceReportUtil.c(1);
      TraceReportUtil.a(i);
      TraceReportUtil.a(i, 1);
      TraceReportUtil.a(i, 10);
      ((IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all")).initApolloConfig();
      Object localObject3 = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(((QQAppInterface)localObject2).getCurrentAccountUin());
      if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS != ((ApolloBaseInfo)localObject3).apolloServerTS)) {
        ((ApolloExtensionHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("qqSettingMe");
      }
      localObject3 = ApolloDrawerInfoManager.a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).getCurrentUin(), (ApolloBaseInfo)localObject3, 1);
      if ((localObject3 != null) && (!((CheckApolloInfoResult)localObject3).needStatic))
      {
        if (!ApolloResManagerFacade.a.a(Scene.DRAWER).a((QQAppInterface)localObject2))
        {
          TraceReportUtil.a(((CheckApolloInfoResult)localObject3).traceFeatureId, 10, 110, new Object[] { "role 0 not ready" });
          if (QLog.isColorLevel()) {
            QLog.w("[cmshow][SettingMeApolloViewController]", 2, "checkDrawerBasicApolloAction up and down not ready");
          }
          return;
        }
        TraceReportUtil.a(((CheckApolloInfoResult)localObject3).traceFeatureId, 10, 0, new Object[] { "switch done" });
        TraceReportUtil.a(i, 11);
        localObject2 = SettingMeApolloViewControllerImpl.access$2100((SettingMeApolloViewControllerImpl)localObject1).obtainMessage(65536);
        ((Message)localObject2).obj = localObject3;
        SettingMeApolloViewControllerImpl.access$2202((SettingMeApolloViewControllerImpl)localObject1, ((CheckApolloInfoResult)localObject3).apolloFeatureFlag);
        SettingMeApolloViewControllerImpl.access$2100((SettingMeApolloViewControllerImpl)localObject1).sendMessageAtFrontOfQueue((Message)localObject2);
        return;
      }
      QLog.w("[cmshow][SettingMeApolloViewController]", 1, "checkDrawerRoleDressInfo not ready");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */