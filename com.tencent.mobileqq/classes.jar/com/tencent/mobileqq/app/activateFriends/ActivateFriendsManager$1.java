package com.tencent.mobileqq.app.activateFriends;

import com.tencent.qphone.base.util.QLog;

class ActivateFriendsManager$1
  implements Runnable
{
  ActivateFriendsManager$1(ActivateFriendsManager paramActivateFriendsManager) {}
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.this$0)) > ActivateFriendsManager.b(this.this$0))
    {
      bool1 = true;
      if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.c(this.this$0)) <= ActivateFriendsManager.d(this.this$0)) {
        break label168;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + ActivateFriendsManager.a(this.this$0) + " | checkBirthdayInterval = " + ActivateFriendsManager.b(this.this$0) + " | lastMemorialCheckInStamp = " + ActivateFriendsManager.c(this.this$0) + " | checkMemorialInterval = " + ActivateFriendsManager.d(this.this$0) + " | isBirthday = " + bool1 + " | isMemorial = " + bool2);
      }
      if ((bool1) || (bool2)) {
        break label173;
      }
      return;
      bool1 = false;
      break;
      label168:
      bool2 = false;
    }
    label173:
    ActivateFriendServlet.a(ActivateFriendsManager.a(this.this$0), bool1, bool2);
    this.this$0.a = ActivateFriendsManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
 * JD-Core Version:    0.7.0.1
 */