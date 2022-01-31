package com.tencent.mobileqq.app.message;

import amfy;
import amjk;
import awbw;
import awbx;
import ayvc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import ew;

public class DatalineMessageManager$1
  implements Runnable
{
  public DatalineMessageManager$1(amfy paramamfy, DataLineMsgRecord paramDataLineMsgRecord, ew paramew) {}
  
  public void run()
  {
    awbw localawbw = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = ayvc.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      amjk localamjk = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localamjk.a(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int);
      localRecentUser.setType(this.this$0.jdField_a_of_type_Int);
      localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
      localamjk.a(localRecentUser);
      amfy.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, localawbw);
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      this.jdField_a_of_type_Ew.a();
      localawbw.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l);
      }
      return;
    }
    finally
    {
      localawbw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.1
 * JD-Core Version:    0.7.0.1
 */