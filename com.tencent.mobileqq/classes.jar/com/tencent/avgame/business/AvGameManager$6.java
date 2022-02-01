package com.tencent.avgame.business;

import aobd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mwd;
import nga;

public class AvGameManager$6
  implements Runnable
{
  public AvGameManager$6(mwd parammwd, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      String str = mwd.a(this.this$0).getCurrentNickname();
      aobd.a().a(mwd.a(this.this$0), 0, this.a, nga.a(this.b), mwd.a(this.this$0).getLongAccountUin(), str, 1, "", 1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvGameManager", 1, "notifySendMsg error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager.6
 * JD-Core Version:    0.7.0.1
 */