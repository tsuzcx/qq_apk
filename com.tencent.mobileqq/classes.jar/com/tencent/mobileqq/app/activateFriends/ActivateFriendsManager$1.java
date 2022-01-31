package com.tencent.mobileqq.app.activateFriends;

import akjv;
import akjw;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$1
  implements Runnable
{
  public ActivateFriendsManager$1(akjw paramakjw) {}
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Math.abs(System.currentTimeMillis() - akjw.a(this.this$0)) > akjw.b(this.this$0))
    {
      bool1 = true;
      if (Math.abs(System.currentTimeMillis() - akjw.c(this.this$0)) <= akjw.d(this.this$0)) {
        break label168;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + akjw.a(this.this$0) + " | checkBirthdayInterval = " + akjw.b(this.this$0) + " | lastMemorialCheckInStamp = " + akjw.c(this.this$0) + " | checkMemorialInterval = " + akjw.d(this.this$0) + " | isBirthday = " + bool1 + " | isMemorial = " + bool2);
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
    akjv.a(akjw.a(this.this$0), bool1, bool2);
    this.this$0.a = akjw.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
 * JD-Core Version:    0.7.0.1
 */