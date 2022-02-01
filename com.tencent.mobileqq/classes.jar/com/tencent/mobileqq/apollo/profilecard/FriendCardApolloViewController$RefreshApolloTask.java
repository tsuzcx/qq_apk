package com.tencent.mobileqq.apollo.profilecard;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class FriendCardApolloViewController$RefreshApolloTask
  implements Runnable
{
  private WeakReference<QBaseActivity> a;
  private WeakReference<FriendCardApolloViewController> b;
  private ProfileCardInfo c;
  
  public FriendCardApolloViewController$RefreshApolloTask(QBaseActivity paramQBaseActivity, FriendCardApolloViewController paramFriendCardApolloViewController, ProfileCardInfo paramProfileCardInfo)
  {
    this.a = new WeakReference(paramQBaseActivity);
    this.b = new WeakReference(paramFriendCardApolloViewController);
    this.c = paramProfileCardInfo;
  }
  
  public void run()
  {
    Object localObject1 = (QBaseActivity)this.a.get();
    FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.b.get();
    if ((localObject1 != null) && (localFriendCardApolloViewController != null))
    {
      if (localFriendCardApolloViewController.a == null) {
        return;
      }
      Object localObject3 = ((QBaseActivity)localObject1).getAppRuntime();
      if (localObject3 == null) {
        return;
      }
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)((AppRuntime)localObject3).getRuntimeService(IApolloManagerService.class, "all");
      int i = TraceReportUtil.c(2);
      Object localObject2 = null;
      if (localApolloManagerServiceImpl != null)
      {
        localObject1 = this.c;
        if ((localObject1 != null) && (((ProfileCardInfo)localObject1).card != null)) {
          if ((!this.c.card.uin.equals(((AppRuntime)localObject3).getCurrentAccountUin())) && ((this.c.allInOne == null) || (!this.c.allInOne.uin.equals(((AppRuntime)localObject3).getCurrentAccountUin()))))
          {
            if (localApolloManagerServiceImpl.queryStatusInConfig("friendcard", null) <= 0) {
              TraceReportUtil.a(i, 10, 105, new Object[] { "friendcard not open" });
            }
          }
          else if (localApolloManagerServiceImpl.queryStatusInConfig("mycard", null) <= 0)
          {
            TraceReportUtil.a(i, 10, 105, new Object[] { "mycard not open" });
            return;
          }
        }
      }
      ApolloSoLoaderImpl.loadSo("FriendCard");
      Object localObject4 = this.c;
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject1 = localObject2;
        if (((ProfileCardInfo)localObject4).allInOne != null) {
          localObject1 = this.c.allInOne.uin;
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = this.c;
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          if (((ProfileCardInfo)localObject4).card != null) {
            localObject2 = this.c.card.uin;
          }
        }
      }
      localObject1 = (ApolloExtensionHandler)((AppInterface)localObject3).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      ((ApolloExtensionHandler)localObject1).a((String)localObject2, 2147483648L, "profilecard");
      TraceReportUtil.a(i, (String)localObject2, new int[0]);
      localObject4 = ((ApolloDaoManagerServiceImpl)((AppRuntime)localObject3).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo((String)localObject2);
      if (localObject4 != null)
      {
        localFriendCardApolloViewController.i = ((ApolloBaseInfo)localObject4).apolloStatus;
        localFriendCardApolloViewController.j = ((ApolloBaseInfo)localObject4);
      }
      localFriendCardApolloViewController.h = ((FriendsManager)((AppRuntime)localObject3).getManager(QQManagerFactory.FRIENDS_MANAGER)).n((String)localObject2);
      boolean bool;
      if ((localApolloManagerServiceImpl.getWhiteListStatus() == 1) && (!localFriendCardApolloViewController.h) && ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(((AppRuntime)localObject3).getCurrentUin())))) {
        bool = false;
      } else {
        bool = true;
      }
      localFriendCardApolloViewController.g = bool;
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject3;
      localObject3 = ApolloDrawerInfoManager.a(localQQAppInterface, (String)localObject2, (ApolloBaseInfo)localObject4, 2);
      if ((localObject3 != null) && (!((CheckApolloInfoResult)localObject3).needStatic))
      {
        IApolloResManager localIApolloResManager = FriendCardApolloViewController.a(localFriendCardApolloViewController);
        if ((localIApolloResManager != null) && (localIApolloResManager.a(localQQAppInterface)))
        {
          if ((localObject4 != null) && (!localFriendCardApolloViewController.h) && (localApolloManagerServiceImpl.is3dAvailable()) && (((CheckApolloInfoResult)localObject3).userStatus != 0) && (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject4).apolloUpdateTime >= 300L)) {
            ((ApolloExtensionHandler)localObject1).b((String)localObject2);
          }
          localObject1 = localFriendCardApolloViewController.a.obtainMessage(1);
          ((Message)localObject1).obj = localObject3;
          localFriendCardApolloViewController.a.sendMessage((Message)localObject1);
          return;
        }
        TraceReportUtil.a(i, 10, 110, new Object[] { "role 0 not ready" });
        if (QLog.isColorLevel()) {
          QLog.w("[cmshow]FriendCardApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
        }
        return;
      }
      QLog.w("[cmshow]FriendCardApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */