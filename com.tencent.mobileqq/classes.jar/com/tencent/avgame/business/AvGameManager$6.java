package com.tencent.avgame.business;

import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.qphone.base.util.QLog;

class AvGameManager$6
  implements Runnable
{
  AvGameManager$6(AvGameManager paramAvGameManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      String str = AvGameManager.a(this.this$0).getCurrentNickname();
      AVGameShareUtil.a().a(AvGameManager.a(this.this$0), 0, this.a, AvGameEntranceUtil.a(this.b), AvGameManager.a(this.this$0).getLongAccountUin(), str, 1, "", 1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvGameManager", 1, "notifySendMsg error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager.6
 * JD-Core Version:    0.7.0.1
 */