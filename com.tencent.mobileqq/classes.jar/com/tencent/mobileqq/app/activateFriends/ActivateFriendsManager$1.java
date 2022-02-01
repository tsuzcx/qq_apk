package com.tencent.mobileqq.app.activateFriends;

import aohd;
import aohe;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$1
  implements Runnable
{
  public ActivateFriendsManager$1(aohe paramaohe) {}
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Math.abs(System.currentTimeMillis() - aohe.a(this.this$0)) > aohe.b(this.this$0))
    {
      bool1 = true;
      if (Math.abs(System.currentTimeMillis() - aohe.c(this.this$0)) <= aohe.d(this.this$0)) {
        break label168;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + aohe.a(this.this$0) + " | checkBirthdayInterval = " + aohe.b(this.this$0) + " | lastMemorialCheckInStamp = " + aohe.c(this.this$0) + " | checkMemorialInterval = " + aohe.d(this.this$0) + " | isBirthday = " + bool1 + " | isMemorial = " + bool2);
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
    aohd.a(aohe.a(this.this$0), bool1, bool2);
    this.this$0.a = aohe.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
 * JD-Core Version:    0.7.0.1
 */