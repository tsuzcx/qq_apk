package com.tencent.avgame.business;

import anha;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mxn;
import njk;

public class AvGameManager$6
  implements Runnable
{
  public AvGameManager$6(mxn parammxn, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      String str = mxn.a(this.this$0).getCurrentNickname();
      anha.a().a(mxn.a(this.this$0), 0, this.a, njk.a(this.b), mxn.a(this.this$0).getLongAccountUin(), str, 1, "", 1);
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