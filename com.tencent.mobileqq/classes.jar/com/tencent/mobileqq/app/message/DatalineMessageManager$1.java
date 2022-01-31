package com.tencent.mobileqq.app.message;

import akpf;
import aktf;
import aukp;
import aukq;
import awzy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import gn;

public class DatalineMessageManager$1
  implements Runnable
{
  public DatalineMessageManager$1(akpf paramakpf, DataLineMsgRecord paramDataLineMsgRecord, gn paramgn) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = awzy.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      aktf localaktf = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localaktf.a(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int);
      localRecentUser.setType(this.this$0.jdField_a_of_type_Int);
      localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
      localaktf.a(localRecentUser);
      akpf.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, localaukp);
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      this.jdField_a_of_type_Gn.a();
      localaukp.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l);
      }
      return;
    }
    finally
    {
      localaukp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.1
 * JD-Core Version:    0.7.0.1
 */