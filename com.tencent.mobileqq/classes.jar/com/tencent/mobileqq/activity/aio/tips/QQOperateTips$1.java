package com.tencent.mobileqq.activity.aio.tips;

import abwp;
import ahqh;
import aqlq;
import aqls;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTips$1
  implements Runnable
{
  public QQOperateTips$1(ahqh paramahqh) {}
  
  public void run()
  {
    Object localObject1 = ahqh.a(this.this$0).getMessageFacade().getAIOList(ahqh.a(this.this$0).curFriendUin, ahqh.a(this.this$0).curType);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (ahqh.a(this.this$0).curType != 0) {
          break label333;
        }
        ahqh.a(this.this$0, ((ChatMessage)localObject2).time);
        ahqh.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (ahqh.a(this.this$0).getConversationFacade().a(ahqh.a(this.this$0).curFriendUin, ahqh.a(this.this$0).curType) <= 0) {
        break label365;
      }
      i = 1;
      label145:
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject2 = (ChatMessage)((List)localObject1).get(i - 1);
        if ((localObject2 == null) || (!((ChatMessage)localObject2).isread)) {}
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + ahqh.a(this.this$0));
        }
        localObject2 = aqlq.a(ahqh.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((aqlq)localObject2).a(ahqh.a(this.this$0).curFriendUin, ahqh.a(this.this$0).curType, ahqh.a(this.this$0), (List)localObject1, true, ahqh.a(this.this$0));
          if (((aqls)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((aqls)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((aqlq)localObject2).a(ahqh.a(this.this$0).curFriendUin, ahqh.a(this.this$0).curType, (ArrayList)localObject1, ahqh.a(this.this$0));
          }
        }
        ahqh.a(this.this$0, -1);
        return;
        label333:
        if (ahqh.a(this.this$0).curType != 3000) {
          break;
        }
        ahqh.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      ahqh.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */