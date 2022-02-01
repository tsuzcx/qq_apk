package com.tencent.mobileqq.app.message;

import com.dataline.util.WaitEvent;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class DatalineMessageManager$1
  implements Runnable
{
  DatalineMessageManager$1(DatalineMessageManager paramDatalineMessageManager, DataLineMsgRecord paramDataLineMsgRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = MessageCache.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      DatalineMessageManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, (EntityManager)localObject1);
      if (!QFileAssistantUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        RecentUserProxy localRecentUserProxy = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int);
        localRecentUser.setType(this.this$0.jdField_a_of_type_Int);
        localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
        localRecentUserProxy.b(localRecentUser);
        this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
      ((EntityManager)localObject1).close();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mr.msgId: ");
        ((StringBuilder)localObject1).append(l);
        QLog.d("Q.msg.DatalineMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.1
 * JD-Core Version:    0.7.0.1
 */