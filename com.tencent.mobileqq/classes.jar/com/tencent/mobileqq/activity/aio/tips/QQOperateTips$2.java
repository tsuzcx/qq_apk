package com.tencent.mobileqq.activity.aio.tips;

import acka;
import aenu;
import amnb;
import amnd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(aenu paramaenu) {}
  
  public void run()
  {
    Object localObject2 = aenu.a(this.this$0).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (aenu.a(this.this$0).jdField_a_of_type_Int == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > aenu.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aenu.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aenu.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (aenu.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > aenu.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aenu.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aenu.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (aenu.a(this.this$0).jdField_a_of_type_Int != 0) {
            break label408;
          }
          aenu.a(this.this$0, ((ChatMessage)localObject2).time);
          aenu.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = amnb.a(aenu.a(this.this$0));
      localObject1 = ((amnb)localObject2).a(aenu.a(this.this$0).jdField_a_of_type_JavaLangString, aenu.a(this.this$0).jdField_a_of_type_Int, aenu.a(this.this$0), (List)localObject1, false, -1);
      if (((amnd)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((amnd)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((amnb)localObject2).a(aenu.a(this.this$0).jdField_a_of_type_JavaLangString, aenu.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aenu.a(this.this$0));
      }
      return;
      label408:
      if (aenu.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        aenu.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        aenu.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */