package com.tencent.mobileqq.activity.aio.tips;

import acmw;
import ailg;
import arpb;
import arpd;
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
  public QQOperateTips$1(ailg paramailg) {}
  
  public void run()
  {
    Object localObject1 = ailg.a(this.this$0).getMessageFacade().getAIOList(ailg.a(this.this$0).curFriendUin, ailg.a(this.this$0).curType);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (ailg.a(this.this$0).curType != 0) {
          break label333;
        }
        ailg.a(this.this$0, ((ChatMessage)localObject2).time);
        ailg.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (ailg.a(this.this$0).getConversationFacade().a(ailg.a(this.this$0).curFriendUin, ailg.a(this.this$0).curType) <= 0) {
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
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + ailg.a(this.this$0));
        }
        localObject2 = arpb.a(ailg.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((arpb)localObject2).a(ailg.a(this.this$0).curFriendUin, ailg.a(this.this$0).curType, ailg.a(this.this$0), (List)localObject1, true, ailg.a(this.this$0));
          if (((arpd)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = ((arpd)localObject1).jdField_a_of_type_JavaUtilArrayList;
            ((arpb)localObject2).a(ailg.a(this.this$0).curFriendUin, ailg.a(this.this$0).curType, (ArrayList)localObject1, ailg.a(this.this$0));
          }
        }
        ailg.a(this.this$0, -1);
        return;
        label333:
        if (ailg.a(this.this$0).curType != 3000) {
          break;
        }
        ailg.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      ailg.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */