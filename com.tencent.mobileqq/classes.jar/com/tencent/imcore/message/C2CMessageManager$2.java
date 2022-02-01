package com.tencent.imcore.message;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;

class C2CMessageManager$2
  implements Runnable
{
  C2CMessageManager$2(C2CMessageManager paramC2CMessageManager, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt, String paramString, C2CMessageManager.C2CReplyContext paramC2CReplyContext, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      long l = ((MessageRecord)((List)localObject2).get(0)).uniseq;
      localObject1 = new ArrayList();
      this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l, 200 - ((List)localObject2).size(), this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext, (ArrayList)localObject1);
      if (((ArrayList)localObject1).size() <= 200 - ((List)localObject2).size()) {
        break label397;
      }
      i = ((ArrayList)localObject1).size() - (200 - ((List)localObject2).size());
    }
    for (;;)
    {
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (ChatMessage)((ArrayList)localObject1).get(i);
        if ((MsgProxyUtils.b((MessageRecord)localObject2)) || (((ChatMessage)localObject2).msgUid != this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.a) || (((ChatMessage)localObject2).time != this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.b)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          do
          {
            do
            {
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = 15;
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
              localObject1 = C2CMessageManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext, this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext);
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (ChatMessage)((List)localObject1).get(0);
          } while ((MsgProxyUtils.b((MessageRecord)localObject1)) || (((ChatMessage)localObject1).msgUid != this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.a) || (((ChatMessage)localObject1).time != this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.b));
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.g = true;
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
        }
        for (;;)
        {
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.post(new C2CMessageManager.2.2(this));
          return;
          i += 1;
          break;
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.post(new C2CMessageManager.2.1(this));
        }
      }
      label397:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.2
 * JD-Core Version:    0.7.0.1
 */