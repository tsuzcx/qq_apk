package com.tencent.mobileqq.app.activateFriends;

import ambk;
import ambl;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$1
  implements Runnable
{
  public ActivateFriendsManager$1(ambl paramambl) {}
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Math.abs(System.currentTimeMillis() - ambl.a(this.this$0)) > ambl.b(this.this$0))
    {
      bool1 = true;
      if (Math.abs(System.currentTimeMillis() - ambl.c(this.this$0)) <= ambl.d(this.this$0)) {
        break label168;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + ambl.a(this.this$0) + " | checkBirthdayInterval = " + ambl.b(this.this$0) + " | lastMemorialCheckInStamp = " + ambl.c(this.this$0) + " | checkMemorialInterval = " + ambl.d(this.this$0) + " | isBirthday = " + bool1 + " | isMemorial = " + bool2);
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
    ambk.a(ambl.a(this.this$0), bool1, bool2);
    this.this$0.a = ambl.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
 * JD-Core Version:    0.7.0.1
 */