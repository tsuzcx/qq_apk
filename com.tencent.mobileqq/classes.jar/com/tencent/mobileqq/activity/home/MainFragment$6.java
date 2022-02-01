package com.tencent.mobileqq.activity.home;

import anvk;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MainFragment$6
  implements Runnable
{
  MainFragment$6(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "getSpecialRecommendStat=" + FriendListHandler.getSpecialRecommendStat);
    }
    if ((FriendListHandler.getSpecialRecommendStat == 0) || (FriendListHandler.getSpecialRecommendStat == 2) || (FriendListHandler.getSpecialRecommendStat == 3)) {}
    do
    {
      do
      {
        return;
        if (!MainFragment.a(this.this$0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.this$0));
      return;
    } while (MainFragment.a(this.this$0) == null);
    List localList = ((anvk)MainFragment.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).b();
    if ((localList != null) && (localList.size() > 0))
    {
      MainFragment.b(this.this$0, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.this$0));
    }
    ((FriendListHandler)MainFragment.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSpecialCareRecommend(0, 10, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.6
 * JD-Core Version:    0.7.0.1
 */