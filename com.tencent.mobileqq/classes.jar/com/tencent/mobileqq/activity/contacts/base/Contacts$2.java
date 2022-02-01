package com.tencent.mobileqq.activity.contacts.base;

import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class Contacts$2
  extends NewFriendVerificationObserver
{
  Contacts$2(Contacts paramContacts) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ui.onGetAddFriendBlockedRedPoint, success=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",blockedUin=");
      localStringBuilder.append(paramString);
      QLog.i("Tab.Contacts", 2, localStringBuilder.toString());
    }
    ((INewFriendService)this.a.aF.getRuntimeService(INewFriendService.class, "")).refreshContactUnreadCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts.2
 * JD-Core Version:    0.7.0.1
 */