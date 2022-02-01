package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$7
  extends FriendListObserver
{
  FriendProfileCardActivity$7(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (this.a.a.a.jdField_a_of_type_JavaLangString != null))
    {
      paramString1 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((ProfileActivity.AllInOne.b(this.a.a.a)) && (paramString1 != null))
      {
        paramString2 = paramString1.a(this.a.a.a.jdField_a_of_type_JavaLangString);
        if (paramString2 != null)
        {
          paramString1 = "";
          if (paramString2.remark != null) {
            paramString1 = paramString2.remark;
          }
          this.a.a(paramString1);
        }
      }
    }
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("result_uin");
      if ((ProfileActivity.AllInOne.i(this.a.a.a)) && (FriendProfileCardActivity.a(this.a.a.a).equals(paramString)))
      {
        this.a.a(true, false, paramBundle);
        return;
      }
    } while ((paramBundle == null) || (this.a.a.a == null) || (!paramBundle.equalsIgnoreCase(this.a.a.a.jdField_a_of_type_JavaLangString)));
    this.a.a(false, false, null);
  }
  
  public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.a.a.a)) {
          break;
        }
        Object localObject = (PhoneContactManager)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localObject == null) {}
        for (localObject = null; (localObject != null) && (((PhoneContact)localObject).mobileNo != null) && (this.a.a.a != null) && (((PhoneContact)localObject).mobileNo.equals(this.a.a.a.jdField_a_of_type_JavaLangString)); localObject = ((PhoneContactManager)localObject).a(paramString))
        {
          this.a.a(true, false, paramString);
          return;
        }
      }
    } while ((paramString == null) || (this.a.a.a == null) || (!paramString.equals(this.a.a.a.jdField_a_of_type_JavaLangString)));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAddFriend, uin: " + paramString);
    }
    this.a.a(false, false, null);
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131691544, 2);
      this.a.finish();
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onUpdateFriendList " + paramBoolean1 + ", " + paramBoolean2);
    }
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.a.a.a.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!ProfileActivity.AllInOne.b(this.a.a.a)) {
        break label156;
      }
      if (localObject2 != null)
      {
        localObject2 = ((FriendsManager)localObject2).a(this.a.a.a.jdField_a_of_type_JavaLangString);
        if (localObject2 != null)
        {
          localObject1 = "";
          if (((Friends)localObject2).remark != null) {
            localObject1 = ((Friends)localObject2).remark;
          }
          this.a.a((String)localObject1);
        }
      }
    }
    label156:
    do
    {
      for (;;)
      {
        return;
        if (!ProfileActivity.AllInOne.i(this.a.a.a)) {
          break;
        }
        if (this.a.a.a.jdField_a_of_type_Int == 53)
        {
          this.a.a(0L, null, null, false);
          return;
        }
        PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localPhoneContactManager == null) {}
        while ((localObject2 != null) && (localObject1 != null) && (((FriendsManager)localObject2).b(((PhoneContact)localObject1).uin)))
        {
          this.a.a(true, false, ((PhoneContact)localObject1).uin);
          return;
          localObject1 = localPhoneContactManager.c(FriendProfileCardActivity.a(this.a.a.a));
        }
      }
    } while ((localObject2 == null) || (!((FriendsManager)localObject2).b(this.a.a.a.jdField_a_of_type_JavaLangString)) || (this.a.a.a.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())));
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateFriendList, cardInfo.allinone.uin: " + this.a.a.a.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.excute(new FriendProfileCardActivity.7.1(this), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.7
 * JD-Core Version:    0.7.0.1
 */