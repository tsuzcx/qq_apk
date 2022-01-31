package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import acsn;
import bbdx;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReminderDataManager$1
  implements Runnable
{
  public ReminderDataManager$1(acsn paramacsn, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    synchronized ()
    {
      if (acsn.a(this.this$0, acsn.a(this.this$0)).length == 3) {
        acsn.a(this.this$0, acsn.a(this.this$0));
      }
      JceOutputStream localJceOutputStream = new JceOutputStream();
      String str = acsn.a(this.this$0) + "_" + this.a.notice_time * 1000L + "_" + this.a.msg_id;
      try
      {
        localJceOutputStream.setServerEncoding("utf-8");
        this.a.writeTo(localJceOutputStream);
        File localFile = new File(acsn.a(this.this$0), str);
        bbdx.a(localJceOutputStream.toByteArray(), localFile.getAbsolutePath());
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e(acsn.a(), 1, "save file : " + str + " fail because throw an exception " + localThrowable);
          acsn.a(this.this$0, this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.1
 * JD-Core Version:    0.7.0.1
 */