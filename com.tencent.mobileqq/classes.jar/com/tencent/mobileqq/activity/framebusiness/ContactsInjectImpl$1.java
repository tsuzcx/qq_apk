package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class ContactsInjectImpl$1
  implements Runnable
{
  ContactsInjectImpl$1(ContactsInjectImpl paramContactsInjectImpl, FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSpecialRecommendStat=");
      ((StringBuilder)localObject).append(FriendListHandler.getSpecialRecommendStat);
      QLog.d("SpecialCare", 2, ((StringBuilder)localObject).toString());
    }
    if ((FriendListHandler.getSpecialRecommendStat != 0) && (FriendListHandler.getSpecialRecommendStat != 2))
    {
      if (FriendListHandler.getSpecialRecommendStat == 3) {
        return;
      }
      if (this.a.k)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, "hasSpecialCareFriend=true");
        }
        return;
      }
      if (this.a.a == null) {
        return;
      }
      localObject = ((FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).f();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.a.k = true;
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasSpecialCareFriend=");
        ((StringBuilder)localObject).append(this.a.k);
        QLog.d("SpecialCare", 2, ((StringBuilder)localObject).toString());
      }
      ((FriendListHandler)((QQAppInterface)this.a.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSpecialCareRecommend(0, 10, null, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.ContactsInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */