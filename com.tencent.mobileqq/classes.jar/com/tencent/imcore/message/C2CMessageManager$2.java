package com.tencent.imcore.message;

import abss;
import abst;
import abtg;
import abti;
import abts;
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
  public C2CMessageManager$2(abss paramabss, abts paramabts, int paramInt, String paramString, abst paramabst, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_Abts);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Int).f(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      long l = ((MessageRecord)((List)localObject2).get(0)).uniseq;
      localObject1 = new ArrayList();
      this.this$0.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l, 200 - ((List)localObject2).size(), this.jdField_a_of_type_Abts, (ArrayList)localObject1);
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
        if ((abti.b((MessageRecord)localObject2)) || (((ChatMessage)localObject2).msgUid != this.jdField_a_of_type_Abst.a) || (((ChatMessage)localObject2).time != this.jdField_a_of_type_Abst.b)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          do
          {
            do
            {
              this.jdField_a_of_type_Abts.e = 15;
              this.jdField_a_of_type_Abts.jdField_a_of_type_Int = 0;
              localObject1 = abss.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, this.jdField_a_of_type_Abts, this.jdField_a_of_type_Abst);
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (ChatMessage)((List)localObject1).get(0);
          } while ((abti.b((MessageRecord)localObject1)) || (((ChatMessage)localObject1).msgUid != this.jdField_a_of_type_Abst.a) || (((ChatMessage)localObject1).time != this.jdField_a_of_type_Abst.b));
          this.jdField_a_of_type_Abts.g = true;
          this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_Abts);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.2
 * JD-Core Version:    0.7.0.1
 */