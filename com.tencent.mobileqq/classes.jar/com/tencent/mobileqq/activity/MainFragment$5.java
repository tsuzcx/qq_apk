package com.tencent.mobileqq.activity;

import alto;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MainFragment$5
  implements Runnable
{
  MainFragment$5(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "getSpecialRecommendStat=" + FriendListHandler.a);
    }
    if ((FriendListHandler.a == 0) || (FriendListHandler.a == 2) || (FriendListHandler.a == 3)) {}
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
    List localList = ((alto)MainFragment.a(this.this$0).getManager(51)).b();
    if ((localList != null) && (localList.size() > 0))
    {
      MainFragment.b(this.this$0, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.this$0));
    }
    ((FriendListHandler)MainFragment.a(this.this$0).a(1)).a(0, 10, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.5
 * JD-Core Version:    0.7.0.1
 */