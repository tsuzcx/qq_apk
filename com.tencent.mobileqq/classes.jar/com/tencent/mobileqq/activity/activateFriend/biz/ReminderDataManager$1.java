package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aftv;
import bgmg;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReminderDataManager$1
  implements Runnable
{
  public ReminderDataManager$1(aftv paramaftv, AcsMsg paramAcsMsg) {}
  
  public void run()
  {
    synchronized ()
    {
      if (aftv.a(this.this$0, aftv.a(this.this$0)).length == 3) {
        aftv.a(this.this$0, aftv.a(this.this$0));
      }
      JceOutputStream localJceOutputStream = new JceOutputStream();
      String str = aftv.a(this.this$0) + "_" + this.a.notice_time * 1000L + "_" + this.a.msg_id;
      try
      {
        localJceOutputStream.setServerEncoding("utf-8");
        this.a.writeTo(localJceOutputStream);
        File localFile = new File(aftv.a(this.this$0), str);
        bgmg.a(localJceOutputStream.toByteArray(), localFile.getAbsolutePath());
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e(aftv.a(), 1, "save file : " + str + " fail because throw an exception " + localThrowable);
          aftv.a(this.this$0, this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.1
 * JD-Core Version:    0.7.0.1
 */