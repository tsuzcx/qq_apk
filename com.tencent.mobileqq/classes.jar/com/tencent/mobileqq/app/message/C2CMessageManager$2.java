package com.tencent.mobileqq.app.message;

import akou;
import akov;
import akpv;
import akpy;
import akqs;
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
  public C2CMessageManager$2(akou paramakou, akqs paramakqs, int paramInt, String paramString, akov paramakov, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_Akqs);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Int).e(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      long l = ((MessageRecord)((List)localObject2).get(0)).uniseq;
      localObject1 = new ArrayList();
      this.this$0.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l, 200 - ((List)localObject2).size(), this.jdField_a_of_type_Akqs, (ArrayList)localObject1);
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
        if ((akpy.b((MessageRecord)localObject2)) || (((ChatMessage)localObject2).msgUid != this.jdField_a_of_type_Akov.a) || (((ChatMessage)localObject2).time != this.jdField_a_of_type_Akov.b)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          do
          {
            do
            {
              this.jdField_a_of_type_Akqs.e = 15;
              this.jdField_a_of_type_Akqs.jdField_a_of_type_Int = 0;
              localObject1 = akou.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, this.jdField_a_of_type_Akqs, this.jdField_a_of_type_Akov);
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (ChatMessage)((List)localObject1).get(0);
          } while ((akpy.b((MessageRecord)localObject1)) || (((ChatMessage)localObject1).msgUid != this.jdField_a_of_type_Akov.a) || (((ChatMessage)localObject1).time != this.jdField_a_of_type_Akov.b));
          this.jdField_a_of_type_Akqs.g = true;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_Akqs);
        }
        for (;;)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.post(new C2CMessageManager.2.2(this));
          return;
          i += 1;
          break;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.post(new C2CMessageManager.2.1(this));
        }
      }
      label397:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageManager.2
 * JD-Core Version:    0.7.0.1
 */