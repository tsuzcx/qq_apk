package com.tencent.mobileqq.activity.contacts.base;

import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationObserver;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class Contacts$2
  extends NewFriendVerificationObserver
{
  Contacts$2(Contacts paramContacts) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onGetAddFriendBlockedRedPoint, success=" + paramBoolean1 + ",blockedUin=" + paramString);
    }
    ((NewFriendManager)this.a.a.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts.2
 * JD-Core Version:    0.7.0.1
 */