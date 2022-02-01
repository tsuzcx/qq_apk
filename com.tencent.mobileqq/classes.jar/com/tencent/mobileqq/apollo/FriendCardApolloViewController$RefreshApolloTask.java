package com.tencent.mobileqq.apollo;

import amme;
import ammu;
import amse;
import anck;
import android.os.Message;
import android.text.TextUtils;
import anhm;
import anis;
import anmb;
import anvk;
import azrb;
import bkys;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
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
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.a.get();
    FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.b.get();
    if ((localFriendProfileCardActivity == null) || (localFriendCardApolloViewController == null) || (localFriendCardApolloViewController.jdField_a_of_type_Bkys == null)) {
      return;
    }
    Object localObject = (amme)localFriendProfileCardActivity.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    int i = anck.b(2);
    if ((localObject != null) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      if ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())) || ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(localFriendProfileCardActivity.app.getCurrentAccountUin()))))
      {
        if (amme.a(localFriendProfileCardActivity.app, "mycard", null) <= 0) {
          anis.a(i, 10, 105, new Object[] { "mycard not open" });
        }
      }
      else if (amme.a(localFriendProfileCardActivity.app, "friendcard", null) <= 0)
      {
        anis.a(i, 10, 105, new Object[] { "friendcard not open" });
        return;
      }
    }
    anmb.a("FriendCard");
    if ((localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; localObject = null)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        anis.a(i, (String)localObject, new int[0]);
        ApolloBaseInfo localApolloBaseInfo = ((amme)localFriendProfileCardActivity.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b((String)localObject);
        if (localApolloBaseInfo != null)
        {
          localFriendCardApolloViewController.jdField_b_of_type_Int = localApolloBaseInfo.apolloStatus;
          localFriendCardApolloViewController.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
        }
        localFriendCardApolloViewController.jdField_b_of_type_Boolean = ((anvk)localFriendProfileCardActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject);
        if ((amme.a(localFriendProfileCardActivity.app) != 1) || (localFriendCardApolloViewController.jdField_b_of_type_Boolean) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localFriendProfileCardActivity.app.getCurrentUin())))) {}
        ammu localammu;
        for (boolean bool = true;; bool = false)
        {
          localFriendCardApolloViewController.jdField_a_of_type_Boolean = bool;
          localammu = amse.a(localFriendProfileCardActivity.app, (String)localObject, localApolloBaseInfo, 2);
          if ((localammu != null) && (!localammu.jdField_a_of_type_Boolean)) {
            break;
          }
          QLog.w("FriendCardApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
          return;
        }
        if (!anhm.a(localFriendProfileCardActivity.app, 7))
        {
          anis.a(i, 10, 110, new Object[] { "role 0 not ready" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("FriendCardApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
          return;
        }
        if ((localApolloBaseInfo != null) && (!localFriendCardApolloViewController.jdField_b_of_type_Boolean) && (amme.a(localFriendProfileCardActivity.app)) && (localammu.d != 0) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime >= 300L)) {
          ((VasExtensionHandler)localFriendProfileCardActivity.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).b((String)localObject);
        }
        localObject = localFriendCardApolloViewController.jdField_a_of_type_Bkys.obtainMessage(1);
        ((Message)localObject).obj = localammu;
        localFriendCardApolloViewController.jdField_a_of_type_Bkys.sendMessage((Message)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */