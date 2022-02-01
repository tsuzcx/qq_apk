package com.tencent.mobileqq.activity.aio.tips;

import afwy;
import aimc;
import arcd;
import arcf;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(aimc paramaimc) {}
  
  public void run()
  {
    Object localObject2 = aimc.a(this.this$0).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (aimc.a(this.this$0).jdField_a_of_type_Int == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > aimc.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aimc.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aimc.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (aimc.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > aimc.a(this.this$0)))
          {
            if (localChatMessage.uniseq != aimc.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              aimc.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (aimc.a(this.this$0).jdField_a_of_type_Int != 0) {
            break label408;
          }
          aimc.a(this.this$0, ((ChatMessage)localObject2).time);
          aimc.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = arcd.a(aimc.a(this.this$0));
      localObject1 = ((arcd)localObject2).a(aimc.a(this.this$0).jdField_a_of_type_JavaLangString, aimc.a(this.this$0).jdField_a_of_type_Int, aimc.a(this.this$0), (List)localObject1, false, -1);
      if (((arcf)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((arcf)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((arcd)localObject2).a(aimc.a(this.this$0).jdField_a_of_type_JavaLangString, aimc.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, aimc.a(this.this$0));
      }
      return;
      label408:
      if (aimc.a(this.this$0).jdField_a_of_type_Int == 3000)
      {
        aimc.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        aimc.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */