package com.tencent.mobileqq.apollo;

import aknx;
import akom;
import aktj;
import albi;
import algj;
import alhp;
import alko;
import alto;
import android.os.Message;
import android.text.TextUtils;
import awqt;
import bdug;
import bhtd;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
    if ((localFriendProfileCardActivity == null) || (localFriendCardApolloViewController == null) || (localFriendCardApolloViewController.jdField_a_of_type_Bhtd == null)) {
      return;
    }
    Object localObject = (aknx)localFriendProfileCardActivity.app.getManager(153);
    int i = albi.b(2);
    if ((localObject != null) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      if ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())) || ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(localFriendProfileCardActivity.app.getCurrentAccountUin()))))
      {
        if (aknx.a(localFriendProfileCardActivity.app, "mycard", null) <= 0) {
          alhp.a(i, 10, 105, new Object[] { "mycard not open" });
        }
      }
      else if (aknx.a(localFriendProfileCardActivity.app, "friendcard", null) <= 0)
      {
        alhp.a(i, 10, 105, new Object[] { "friendcard not open" });
        return;
      }
    }
    alko.a("FriendCard");
    if ((localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; localObject = null)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        alhp.a(i, (String)localObject, new int[0]);
        ApolloBaseInfo localApolloBaseInfo = ((aknx)localFriendProfileCardActivity.app.getManager(153)).b((String)localObject);
        if (localApolloBaseInfo != null)
        {
          localFriendCardApolloViewController.jdField_b_of_type_Int = localApolloBaseInfo.apolloStatus;
          localFriendCardApolloViewController.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
        }
        localFriendCardApolloViewController.jdField_b_of_type_Boolean = ((alto)localFriendProfileCardActivity.app.getManager(51)).b((String)localObject);
        if ((aknx.a(localFriendProfileCardActivity.app) != 1) || (localFriendCardApolloViewController.jdField_b_of_type_Boolean) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localFriendProfileCardActivity.app.c())))) {}
        akom localakom;
        for (boolean bool = true;; bool = false)
        {
          localFriendCardApolloViewController.jdField_a_of_type_Boolean = bool;
          localakom = aktj.a(localFriendProfileCardActivity.app, (String)localObject, localApolloBaseInfo, 2);
          if ((localakom != null) && (!localakom.jdField_a_of_type_Boolean)) {
            break;
          }
          QLog.w("FriendCardApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
          return;
        }
        if (!algj.a(localFriendProfileCardActivity.app, 7))
        {
          alhp.a(i, 10, 110, new Object[] { "role 0 not ready" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("FriendCardApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
          return;
        }
        if ((localApolloBaseInfo != null) && (!localFriendCardApolloViewController.jdField_b_of_type_Boolean) && (aknx.a(localFriendProfileCardActivity.app)) && (localakom.d != 0) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime >= 300L)) {
          ((bdug)localFriendProfileCardActivity.app.a(71)).b((String)localObject);
        }
        localObject = localFriendCardApolloViewController.jdField_a_of_type_Bhtd.obtainMessage(1);
        ((Message)localObject).obj = localakom;
        localFriendCardApolloViewController.jdField_a_of_type_Bhtd.sendMessage((Message)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */