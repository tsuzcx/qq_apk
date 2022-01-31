package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aejx;
import aekb;
import bdcs;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReminderDataManager$5
  implements Runnable
{
  public ReminderDataManager$5(aejx paramaejx, String paramString, aekb paramaekb) {}
  
  public void run()
  {
    File[] arrayOfFile = aejx.b(this.this$0, aejx.a(this.this$0));
    int j;
    int i;
    if (arrayOfFile.length > 0)
    {
      j = arrayOfFile.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        AcsMsg localAcsMsg = this.this$0.a(localFile);
        if ((localAcsMsg == null) || (!localAcsMsg.msg_id.equals(this.jdField_a_of_type_JavaLangString))) {
          break label190;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aejx.a(), 2, "deleteReminderFilesByMsgId msgId: " + this.jdField_a_of_type_JavaLangString);
        }
        if (!bdcs.d(localFile.getAbsolutePath())) {
          break label158;
        }
        aejx.a(this.this$0, localAcsMsg);
        if (QLog.isColorLevel()) {
          QLog.d(aejx.a(), 2, "cancelAlarmById alarmId: " + localAcsMsg.hashCode());
        }
      }
      label158:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(aejx.a(), 2, " deleteFile fail ");
        }
      } while (this.jdField_a_of_type_Aekb == null);
      this.jdField_a_of_type_Aekb.a();
      return;
      label190:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.5
 * JD-Core Version:    0.7.0.1
 */