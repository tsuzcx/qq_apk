package com.tencent.mobileqq.activity.aio.tips;

import aezn;
import ahqh;
import aqlq;
import aqls;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(ahqh paramahqh) {}
  
  public void run()
  {
    Object localObject2 = ahqh.a(this.this$0).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (ahqh.a(this.this$0).curType == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > ahqh.a(this.this$0)))
          {
            if (localChatMessage.uniseq != ahqh.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              ahqh.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (ahqh.a(this.this$0).curType == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > ahqh.a(this.this$0)))
          {
            if (localChatMessage.uniseq != ahqh.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              ahqh.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (ahqh.a(this.this$0).curType != 0) {
            break label408;
          }
          ahqh.a(this.this$0, ((ChatMessage)localObject2).time);
          ahqh.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = aqlq.a(ahqh.a(this.this$0));
      localObject1 = ((aqlq)localObject2).a(ahqh.a(this.this$0).curFriendUin, ahqh.a(this.this$0).curType, ahqh.a(this.this$0), (List)localObject1, false, -1);
      if (((aqls)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((aqls)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((aqlq)localObject2).a(ahqh.a(this.this$0).curFriendUin, ahqh.a(this.this$0).curType, (ArrayList)localObject1, ahqh.a(this.this$0));
      }
      return;
      label408:
      if (ahqh.a(this.this$0).curType == 3000)
      {
        ahqh.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        ahqh.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */