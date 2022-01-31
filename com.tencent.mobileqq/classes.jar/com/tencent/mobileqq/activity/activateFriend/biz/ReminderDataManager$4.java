package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import acic;
import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReminderDataManager$4
  implements Runnable
{
  public ReminderDataManager$4(acic paramacic) {}
  
  public void run()
  {
    File[] arrayOfFile = acic.b(this.this$0, acic.a(this.this$0));
    if (arrayOfFile.length > 0)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (QLog.isColorLevel()) {
          QLog.i(acic.a(), 2, "delete file name: " + localFile.getName());
        }
        if ((localFile != null) && (localFile.isFile()) && (localFile.exists()))
        {
          AcsMsg localAcsMsg = this.this$0.a(localFile);
          if (bace.d(localFile.getAbsolutePath())) {
            acic.a(this.this$0, localAcsMsg);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.4
 * JD-Core Version:    0.7.0.1
 */