package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aeom;
import aeoq;
import bdhb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReminderDataManager$5
  implements Runnable
{
  public ReminderDataManager$5(aeom paramaeom, String paramString, aeoq paramaeoq) {}
  
  public void run()
  {
    File[] arrayOfFile = aeom.b(this.this$0, aeom.a(this.this$0));
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
          QLog.d(aeom.a(), 2, "deleteReminderFilesByMsgId msgId: " + this.jdField_a_of_type_JavaLangString);
        }
        if (!bdhb.d(localFile.getAbsolutePath())) {
          break label158;
        }
        aeom.a(this.this$0, localAcsMsg);
        if (QLog.isColorLevel()) {
          QLog.d(aeom.a(), 2, "cancelAlarmById alarmId: " + localAcsMsg.hashCode());
        }
      }
      label158:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(aeom.a(), 2, " deleteFile fail ");
        }
      } while (this.jdField_a_of_type_Aeoq == null);
      this.jdField_a_of_type_Aeoq.a();
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