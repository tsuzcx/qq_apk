package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import aewd;
import aewj;
import com.tencent.mobileqq.activity.activateFriend.biz.entity.ReminderEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ReminderDataManager$6
  implements Runnable
{
  public ReminderDataManager$6(aewd paramaewd, String paramString, aewj paramaewj) {}
  
  public void run()
  {
    if (!aewd.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      AcsMsg localAcsMsg = ((ReminderEntity)aewd.a(this.this$0).get(this.jdField_a_of_type_JavaLangString)).getAcsMsg();
      if (aewd.a(this.this$0, this.jdField_a_of_type_JavaLangString, localAcsMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderByMsgId MsgId: ", this.jdField_a_of_type_JavaLangString, " success, remove reminder..." });
        }
        aewd.b(this.this$0, localAcsMsg);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderByMsgId MsgId: ", this.jdField_a_of_type_JavaLangString, " failed!!" });
      }
    } while (this.jdField_a_of_type_Aewj == null);
    this.jdField_a_of_type_Aewj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.6
 * JD-Core Version:    0.7.0.1
 */