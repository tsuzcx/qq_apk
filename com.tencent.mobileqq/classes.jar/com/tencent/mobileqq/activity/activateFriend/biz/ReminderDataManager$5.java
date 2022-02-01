package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aftv;
import aftz;
import bgmg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReminderDataManager$5
  implements Runnable
{
  public ReminderDataManager$5(aftv paramaftv, String paramString, aftz paramaftz) {}
  
  public void run()
  {
    File[] arrayOfFile = aftv.b(this.this$0, aftv.a(this.this$0));
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
          break label193;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aftv.a(), 2, "deleteReminderFilesByMsgId msgId: " + this.jdField_a_of_type_JavaLangString);
        }
        if (!bgmg.d(localFile.getAbsolutePath())) {
          break label161;
        }
        aftv.a(this.this$0, localAcsMsg);
        if (QLog.isColorLevel()) {
          QLog.d(aftv.a(), 2, "cancelAlarmById alarmId: " + localAcsMsg.msg_id.hashCode());
        }
      }
      label161:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(aftv.a(), 2, " deleteFile fail ");
        }
      } while (this.jdField_a_of_type_Aftz == null);
      this.jdField_a_of_type_Aftz.a();
      return;
      label193:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.5
 * JD-Core Version:    0.7.0.1
 */