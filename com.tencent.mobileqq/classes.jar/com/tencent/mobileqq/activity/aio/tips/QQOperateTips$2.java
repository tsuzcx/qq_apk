package com.tencent.mobileqq.activity.aio.tips;

import afqz;
import ailg;
import arpb;
import arpd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(ailg paramailg) {}
  
  public void run()
  {
    Object localObject2 = ailg.a(this.this$0).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (ailg.a(this.this$0).curType == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > ailg.a(this.this$0)))
          {
            if (localChatMessage.uniseq != ailg.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              ailg.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (ailg.a(this.this$0).curType == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > ailg.a(this.this$0)))
          {
            if (localChatMessage.uniseq != ailg.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              ailg.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (ailg.a(this.this$0).curType != 0) {
            break label408;
          }
          ailg.a(this.this$0, ((ChatMessage)localObject2).time);
          ailg.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = arpb.a(ailg.a(this.this$0));
      localObject1 = ((arpb)localObject2).a(ailg.a(this.this$0).curFriendUin, ailg.a(this.this$0).curType, ailg.a(this.this$0), (List)localObject1, false, -1);
      if (((arpd)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((arpd)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((arpb)localObject2).a(ailg.a(this.this$0).curFriendUin, ailg.a(this.this$0).curType, (ArrayList)localObject1, ailg.a(this.this$0));
      }
      return;
      label408:
      if (ailg.a(this.this$0).curType == 3000)
      {
        ailg.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        ailg.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */