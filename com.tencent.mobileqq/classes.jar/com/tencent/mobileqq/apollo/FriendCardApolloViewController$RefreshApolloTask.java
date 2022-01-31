package com.tencent.mobileqq.apollo;

import akji;
import akjx;
import akou;
import akwt;
import albu;
import alda;
import alfz;
import aloz;
import android.os.Message;
import android.text.TextUtils;
import awmk;
import bdpx;
import bhow;
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
    if ((localFriendProfileCardActivity == null) || (localFriendCardApolloViewController == null) || (localFriendCardApolloViewController.jdField_a_of_type_Bhow == null)) {
      return;
    }
    Object localObject = (akji)localFriendProfileCardActivity.app.getManager(153);
    int i = akwt.b(2);
    if ((localObject != null) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      if ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())) || ((localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(localFriendProfileCardActivity.app.getCurrentAccountUin()))))
      {
        if (akji.a(localFriendProfileCardActivity.app, "mycard", null) <= 0) {
          alda.a(i, 10, 105, new Object[] { "mycard not open" });
        }
      }
      else if (akji.a(localFriendProfileCardActivity.app, "friendcard", null) <= 0)
      {
        alda.a(i, 10, 105, new Object[] { "friendcard not open" });
        return;
      }
    }
    alfz.a("FriendCard");
    if ((localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; localObject = null)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        localObject = localFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        alda.a(i, (String)localObject, new int[0]);
        ApolloBaseInfo localApolloBaseInfo = ((akji)localFriendProfileCardActivity.app.getManager(153)).b((String)localObject);
        if (localApolloBaseInfo != null)
        {
          localFriendCardApolloViewController.jdField_b_of_type_Int = localApolloBaseInfo.apolloStatus;
          localFriendCardApolloViewController.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
        }
        localFriendCardApolloViewController.jdField_b_of_type_Boolean = ((aloz)localFriendProfileCardActivity.app.getManager(51)).b((String)localObject);
        if ((akji.a(localFriendProfileCardActivity.app) != 1) || (localFriendCardApolloViewController.jdField_b_of_type_Boolean) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localFriendProfileCardActivity.app.c())))) {}
        akjx localakjx;
        for (boolean bool = true;; bool = false)
        {
          localFriendCardApolloViewController.jdField_a_of_type_Boolean = bool;
          localakjx = akou.a(localFriendProfileCardActivity.app, (String)localObject, localApolloBaseInfo, 2);
          if ((localakjx != null) && (!localakjx.jdField_a_of_type_Boolean)) {
            break;
          }
          QLog.w("FriendCardApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
          return;
        }
        if (!albu.a(localFriendProfileCardActivity.app, 7))
        {
          alda.a(i, 10, 110, new Object[] { "role 0 not ready" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("FriendCardApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
          return;
        }
        if ((localApolloBaseInfo != null) && (!localFriendCardApolloViewController.jdField_b_of_type_Boolean) && (akji.a(localFriendProfileCardActivity.app)) && (localakjx.d != 0) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime >= 300L)) {
          ((bdpx)localFriendProfileCardActivity.app.a(71)).b((String)localObject);
        }
        localObject = localFriendCardApolloViewController.jdField_a_of_type_Bhow.obtainMessage(1);
        ((Message)localObject).obj = localakjx;
        localFriendCardApolloViewController.jdField_a_of_type_Bhow.sendMessage((Message)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */