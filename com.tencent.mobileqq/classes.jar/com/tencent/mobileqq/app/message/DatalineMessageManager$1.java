package com.tencent.mobileqq.app.message;

import akau;
import akeu;
import atmp;
import atmq;
import awao;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import eu;

public class DatalineMessageManager$1
  implements Runnable
{
  public DatalineMessageManager$1(akau paramakau, DataLineMsgRecord paramDataLineMsgRecord, eu parameu) {}
  
  public void run()
  {
    atmp localatmp = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = awao.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      akeu localakeu = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localakeu.a(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int);
      localRecentUser.setType(this.this$0.jdField_a_of_type_Int);
      localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
      localakeu.a(localRecentUser);
      akau.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, localatmp);
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      this.jdField_a_of_type_Eu.a();
      localatmp.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l);
      }
      return;
    }
    finally
    {
      localatmp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.1
 * JD-Core Version:    0.7.0.1
 */