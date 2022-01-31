package com.tencent.mobileqq.activity.aio.tips;

import acup;
import aeyo;
import andn;
import andp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(aeyo paramaeyo) {}
  
  public void run()
  {
    Object localObject2 = aeyo.a(this.this$0).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (aeyo.a(this.this$0).jdField_a_of_type_Int == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > aeyo.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aeyo.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aeyo.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (aeyo.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > aeyo.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aeyo.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aeyo.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (aeyo.a(this.this$0).jdField_a_of_type_Int != 0) {
            break label408;
          }
          aeyo.a(this.this$0, ((ChatMessage)localObject2).time);
          aeyo.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = andn.a(aeyo.a(this.this$0));
      localObject1 = ((andn)localObject2).a(aeyo.a(this.this$0).jdField_a_of_type_JavaLangString, aeyo.a(this.this$0).jdField_a_of_type_Int, aeyo.a(this.this$0), (List)localObject1, false, -1);
      if (((andp)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((andp)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((andn)localObject2).a(aeyo.a(this.this$0).jdField_a_of_type_JavaLangString, aeyo.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aeyo.a(this.this$0));
      }
      return;
      label408:
      if (aeyo.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        aeyo.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        aeyo.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */