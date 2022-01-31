package com.tencent.mobileqq.app.activateFriends;

import ajvl;
import ajvm;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$1
  implements Runnable
{
  public ActivateFriendsManager$1(ajvm paramajvm) {}
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Math.abs(System.currentTimeMillis() - ajvm.a(this.this$0)) > ajvm.b(this.this$0))
    {
      bool1 = true;
      if (Math.abs(System.currentTimeMillis() - ajvm.c(this.this$0)) <= ajvm.d(this.this$0)) {
        break label168;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + ajvm.a(this.this$0) + " | checkBirthdayInterval = " + ajvm.b(this.this$0) + " | lastMemorialCheckInStamp = " + ajvm.c(this.this$0) + " | checkMemorialInterval = " + ajvm.d(this.this$0) + " | isBirthday = " + bool1 + " | isMemorial = " + bool2);
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
    ajvl.a(ajvm.a(this.this$0), bool1, bool2);
    this.this$0.a = ajvm.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1
 * JD-Core Version:    0.7.0.1
 */