package com.tencent.mobileqq.apollo;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

class FriendCardApolloViewController$RefreshApolloTask
  implements Runnable
{
  private WeakReference<FriendProfileCardActivity> a;
  private WeakReference<FriendCardApolloViewController> b;
  
  public FriendCardApolloViewController$RefreshApolloTask(FriendProfileCardActivity paramFriendProfileCardActivity, FriendCardApolloViewController paramFriendCardApolloViewController)
  {
    this.a = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramFriendCardApolloViewController);
  }
  
  public void run()
  {
    CheckApolloInfoResult localCheckApolloInfoResult = null;
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.a.get();
    FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.b.get();
    if ((localFriendProfileCardActivity == null) || (localFriendCardApolloViewController == null) || (localFriendCardApolloViewController.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null)) {
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localFriendProfileCardActivity.app.getRuntimeService(IApolloManagerService.class, "all");
    int i = SpriteUtil.b(2);
    if ((localApolloManagerServiceImpl != null) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      if ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())) || ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(localFriendProfileCardActivity.app.getCurrentAccountUin()))))
      {
        if (localApolloManagerServiceImpl.queryStatusInConfig(localFriendProfileCardActivity.app, "mycard", null) <= 0) {
          TraceReportUtil.a(i, 10, 105, new Object[] { "mycard not open" });
        }
      }
      else if (localApolloManagerServiceImpl.queryStatusInConfig(localFriendProfileCardActivity.app, "friendcard", null) <= 0)
      {
        TraceReportUtil.a(i, 10, 105, new Object[] { "friendcard not open" });
        return;
      }
    }
    ApolloSoLoaderImpl.loadSo("FriendCard");
    Object localObject = localCheckApolloInfoResult;
    if (localFriendProfileCardActivity.a != null)
    {
      localObject = localCheckApolloInfoResult;
      if (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      TraceReportUtil.a(i, (String)localObject, new int[0]);
      ApolloBaseInfo localApolloBaseInfo = ((ApolloManagerServiceImpl)localFriendProfileCardActivity.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo((String)localObject);
      if (localApolloBaseInfo != null)
      {
        localFriendCardApolloViewController.jdField_b_of_type_Int = localApolloBaseInfo.apolloStatus;
        localFriendCardApolloViewController.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo = localApolloBaseInfo;
      }
      localFriendCardApolloViewController.jdField_b_of_type_Boolean = ((FriendsManager)localFriendProfileCardActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject);
      if ((localApolloManagerServiceImpl.getWhiteListStatus(localFriendProfileCardActivity.app) != 1) || (localFriendCardApolloViewController.jdField_b_of_type_Boolean) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localFriendProfileCardActivity.app.getCurrentUin())))) {}
      for (boolean bool = true;; bool = false)
      {
        localFriendCardApolloViewController.jdField_a_of_type_Boolean = bool;
        localCheckApolloInfoResult = ApolloDrawerInfoManager.a(localFriendProfileCardActivity.app, (String)localObject, localApolloBaseInfo, 2);
        if ((localCheckApolloInfoResult != null) && (!localCheckApolloInfoResult.jdField_a_of_type_Boolean)) {
          break;
        }
        QLog.w("FriendCardApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
        return;
      }
      if (!ApolloActionHelperImpl.checkDrawerBasicApolloAction(localFriendProfileCardActivity.app, 7))
      {
        TraceReportUtil.a(i, 10, 110, new Object[] { "role 0 not ready" });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("FriendCardApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
        return;
      }
      if ((localApolloBaseInfo != null) && (!localFriendCardApolloViewController.jdField_b_of_type_Boolean) && (localApolloManagerServiceImpl.is3dAvailable(localFriendProfileCardActivity.app)) && (localCheckApolloInfoResult.d != 0) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime >= 300L)) {
        ((ApolloExtensionHandlerImpl)localFriendProfileCardActivity.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b((String)localObject);
      }
      localObject = localFriendCardApolloViewController.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1);
      ((Message)localObject).obj = localCheckApolloInfoResult;
      localFriendCardApolloViewController.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */