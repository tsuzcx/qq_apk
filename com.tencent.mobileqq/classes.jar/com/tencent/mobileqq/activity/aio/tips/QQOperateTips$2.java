package com.tencent.mobileqq.activity.aio.tips;

import aggs;
import aivw;
import arrs;
import arru;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(aivw paramaivw) {}
  
  public void run()
  {
    Object localObject2 = aivw.a(this.this$0).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (aivw.a(this.this$0).jdField_a_of_type_Int == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > aivw.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aivw.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aivw.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (aivw.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > aivw.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aivw.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aivw.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (aivw.a(this.this$0).jdField_a_of_type_Int != 0) {
            break label408;
          }
          aivw.a(this.this$0, ((ChatMessage)localObject2).time);
          aivw.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = arrs.a(aivw.a(this.this$0));
      localObject1 = ((arrs)localObject2).a(aivw.a(this.this$0).jdField_a_of_type_JavaLangString, aivw.a(this.this$0).jdField_a_of_type_Int, aivw.a(this.this$0), (List)localObject1, false, -1);
      if (((arru)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((arru)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((arrs)localObject2).a(aivw.a(this.this$0).jdField_a_of_type_JavaLangString, aivw.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aivw.a(this.this$0));
      }
      return;
      label408:
      if (aivw.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        aivw.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        aivw.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */