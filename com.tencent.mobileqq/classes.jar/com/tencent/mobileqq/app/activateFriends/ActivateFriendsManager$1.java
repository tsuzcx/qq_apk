package com.tencent.mobileqq.app.activateFriends;

import com.tencent.qphone.base.util.QLog;

class ActivateFriendsManager$1
  implements Runnable
{
  ActivateFriendsManager$1(ActivateFriendsManager paramActivateFriendsManager) {}
  
  public void run()
  {
    long l1 = Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.this$0));
    long l2 = ActivateFriendsManager.b(this.this$0);
    boolean bool2 = true;
    boolean bool1;
    if (l1 > l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.c(this.this$0)) <= ActivateFriendsManager.d(this.this$0)) {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkRunnable | lastBirthdayCheckInStamp = ");
      ((StringBuilder)localObject).append(ActivateFriendsManager.a(this.this$0));
      ((StringBuilder)localObject).append(" | checkBirthdayInterval = ");
      ((StringBuilder)localObject).append(ActivateFriendsManager.b(this.this$0));
      ((StringBuilder)localObject).append(" | lastMemorialCheckInStamp = ");
      ((StringBuilder)localObject).append(ActivateFriendsManager.c(this.this$0));
      ((StringBuilder)localObject).append(" | checkMemorialInterval = ");
      ((StringBuilder)localObject).append(ActivateFriendsManager.d(this.this$0));
      ((StringBuilder)localObject).append(" | isBirthday = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" | isMemorial = ");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if ((!bool1) && (!bool2)) {
      return;
    }
    ActivateFriendServlet.a(ActivateFriendsManager.a(this.this$0), bool1, bool2);
    Object localObject = this.this$0;
    ((ActivateFriendsManager)localObject).a = ActivateFriendsManager.a((ActivateFriendsManager)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
 * JD-Core Version:    0.7.0.1
 */