package com.tencent.mobileqq.apollo.api.impl;

import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
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
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject1;
    int i;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = (QQSettingMe)this.a.get();
          } while (localObject1 == null);
          localObject2 = ((QQSettingMe)localObject1).a();
        } while (localObject2 == null);
        localObject1 = (SettingMeApolloViewControllerImpl)this.b.get();
      } while (localObject1 == null);
      CmShowStatUtil.b("drawer_pre");
      i = SpriteUtil.b(1);
      TraceReportUtil.a(i);
      TraceReportUtil.a(i, 1);
      TraceReportUtil.a(i, 10);
      localObject3 = (IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
      ((IApolloManagerService)localObject3).initApolloConfig();
      localObject3 = ((IApolloManagerService)localObject3).getApolloBaseInfo(((QQAppInterface)localObject2).getCurrentAccountUin());
      if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS != ((ApolloBaseInfo)localObject3).apolloServerTS)) {
        ((ApolloExtensionHandlerImpl)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("qqSettingMe");
      }
      localObject3 = ApolloDrawerInfoManager.a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).getCurrentUin(), (ApolloBaseInfo)localObject3, 1);
      if ((localObject3 == null) || (((CheckApolloInfoResult)localObject3).a))
      {
        QLog.w("SettingMeApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
        return;
      }
      if (ApolloActionHelperImpl.checkDrawerBasicApolloAction((QQAppInterface)localObject2, 11)) {
        break;
      }
      TraceReportUtil.a(((CheckApolloInfoResult)localObject3).e, 10, 110, new Object[] { "role 0 not ready" });
    } while (!QLog.isColorLevel());
    QLog.w("SettingMeApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
    return;
    TraceReportUtil.a(((CheckApolloInfoResult)localObject3).e, 10, 0, new Object[] { "switch done" });
    TraceReportUtil.a(i, 11);
    Object localObject2 = ((SettingMeApolloViewControllerImpl)localObject1).mUIHandler.obtainMessage(65536);
    ((Message)localObject2).obj = localObject3;
    ((SettingMeApolloViewControllerImpl)localObject1).mApolloFeatureFlag = ((CheckApolloInfoResult)localObject3).c;
    ((SettingMeApolloViewControllerImpl)localObject1).mUIHandler.sendMessageAtFrontOfQueue((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.SettingMeApolloViewControllerImpl.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */