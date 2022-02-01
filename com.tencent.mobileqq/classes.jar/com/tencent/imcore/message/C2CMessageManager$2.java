package com.tencent.imcore.message;

import acml;
import acmm;
import acnf;
import acnh;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;

public class C2CMessageManager$2
  implements Runnable
{
  public C2CMessageManager$2(acml paramacml, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt, String paramString, acmm paramacmm, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).f(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
        if ((acnh.b((MessageRecord)localObject2)) || (((ChatMessage)localObject2).msgUid != this.jdField_a_of_type_Acmm.a) || (((ChatMessage)localObject2).time != this.jdField_a_of_type_Acmm.b)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          do
          {
            do
            {
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.count = 15;
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.retryIndex = 0;
              localObject1 = acml.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext, this.jdField_a_of_type_Acmm);
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (ChatMessage)((List)localObject1).get(0);
          } while ((acnh.b((MessageRecord)localObject1)) || (((ChatMessage)localObject1).msgUid != this.jdField_a_of_type_Acmm.a) || (((ChatMessage)localObject1).time != this.jdField_a_of_type_Acmm.b));
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.isSuccess = true;
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
        }
        for (;;)
        {
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.mUIHandler.post(new C2CMessageManager.2.2(this));
          return;
          i += 1;
          break;
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.mUIHandler.post(new C2CMessageManager.2.1(this));
        }
      }
      label397:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.2
 * JD-Core Version:    0.7.0.1
 */