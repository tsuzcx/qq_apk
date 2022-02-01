package com.tencent.mobileqq.app.message;

import adak;
import aosf;
import apas;
import apaw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;

public class DatalineMessageManager$3
  implements Runnable
{
  public DatalineMessageManager$3(aosf paramaosf, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1;
    int i;
    if (this.this$0.a().a(this.a) > 0)
    {
      localObject1 = adak.a(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int);
      if (!this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.containsKey(localObject1)) {
        break label409;
      }
      bool = ((QQMessageFacade.Message)this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.get(localObject1)).hasReply;
      i = ((QQMessageFacade.Message)this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.get(localObject1)).counter;
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.remove(localObject1);
    }
    for (;;)
    {
      long l = this.this$0.a().a().size();
      if (l > 0L)
      {
        localObject2 = this.this$0.a().a();
        localObject1 = localObject2;
        if (localObject2 != null) {
          if ((((DataLineMsgRecord)localObject2).msgtype != -5000) && (((DataLineMsgRecord)localObject2).msgtype != -5041))
          {
            localObject1 = localObject2;
            if (((DataLineMsgRecord)localObject2).msgtype != -2073) {}
          }
          else
          {
            localObject1 = localObject2;
            if (l > 1L) {
              localObject1 = this.this$0.a().a().get((int)(l - 2L)).getLastItem();
            }
          }
        }
        localObject2 = new QQMessageFacade.Message();
        if (localObject1 != null)
        {
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
          ((QQMessageFacade.Message)localObject2).emoRecentMsg = null;
          ((QQMessageFacade.Message)localObject2).counter = i;
          ((QQMessageFacade.Message)localObject2).hasReply = bool;
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((QQMessageFacade.Message)localObject2);
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.put(adak.a(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int), localObject2);
        }
      }
      Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = (RecentUser)((apaw)localObject2).findRecentUserByUin(String.valueOf(this.this$0.jdField_a_of_type_JavaLangString), this.this$0.jdField_a_of_type_Int);
      ((EntityManager)localObject1).close();
      if (localObject2 != null) {
        this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject2);
      }
      return;
      label409:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.3
 * JD-Core Version:    0.7.0.1
 */