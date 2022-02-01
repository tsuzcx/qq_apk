package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import afno;
import afnu;
import com.tencent.mobileqq.activity.activateFriend.biz.entity.ReminderEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ReminderDataManager$6
  implements Runnable
{
  public ReminderDataManager$6(afno paramafno, String paramString, afnu paramafnu) {}
  
  public void run()
  {
    if (!afno.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      AcsMsg localAcsMsg = ((ReminderEntity)afno.a(this.this$0).get(this.jdField_a_of_type_JavaLangString)).getAcsMsg();
      if (afno.a(this.this$0, this.jdField_a_of_type_JavaLangString, localAcsMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderByMsgId MsgId: ", this.jdField_a_of_type_JavaLangString, " success, remove reminder..." });
        }
        afno.b(this.this$0, localAcsMsg);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderByMsgId MsgId: ", this.jdField_a_of_type_JavaLangString, " failed!!" });
      }
    } while (this.jdField_a_of_type_Afnu == null);
    this.jdField_a_of_type_Afnu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.6
 * JD-Core Version:    0.7.0.1
 */