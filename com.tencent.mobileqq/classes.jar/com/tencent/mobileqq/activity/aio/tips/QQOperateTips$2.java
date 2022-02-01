package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

class QQOperateTips$2
  implements Runnable
{
  QQOperateTips$2(QQOperateTips paramQQOperateTips) {}
  
  public void run()
  {
    Object localObject2 = QQOperateTips.d(this.this$0).e().b().d();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      Object localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (QQOperateTips.a(this.this$0).a == 0)
      {
        i = j - 1;
        while (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage == null) || (localChatMessage.time <= QQOperateTips.e(this.this$0))) {
            break;
          }
          if (localChatMessage.uniseq != QQOperateTips.f(this.this$0)) {
            ((ArrayList)localObject1).add(localChatMessage);
          } else {
            QQOperateTips.a(this.this$0, localChatMessage.time);
          }
          i -= 1;
        }
      }
      if (QQOperateTips.a(this.this$0).a == 3000)
      {
        i = j - 1;
        while (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage == null) || (localChatMessage.shmsgseq <= QQOperateTips.e(this.this$0))) {
            break;
          }
          if (localChatMessage.uniseq != QQOperateTips.f(this.this$0)) {
            ((ArrayList)localObject1).add(localChatMessage);
          } else {
            QQOperateTips.a(this.this$0, localChatMessage.shmsgseq);
          }
          i -= 1;
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null) {
          if (QQOperateTips.a(this.this$0).a == 0)
          {
            QQOperateTips.a(this.this$0, ((ChatMessage)localObject2).time);
            QQOperateTips.b(this.this$0, ((ChatMessage)localObject2).uniseq);
          }
          else if (QQOperateTips.a(this.this$0).a == 3000)
          {
            QQOperateTips.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
            QQOperateTips.b(this.this$0, ((ChatMessage)localObject2).uniseq);
          }
        }
        localObject2 = QQOperateManager.a(QQOperateTips.b(this.this$0));
        localObject1 = ((QQOperateManager)localObject2).a(QQOperateTips.a(this.this$0).b, QQOperateTips.a(this.this$0).a, QQOperateTips.b(this.this$0), (List)localObject1, false, -1);
        if (((QQOperationRequestInfo)localObject1).a)
        {
          localObject1 = ((QQOperationRequestInfo)localObject1).b;
          ((QQOperateManager)localObject2).a(QQOperateTips.a(this.this$0).b, QQOperateTips.a(this.this$0).a, (ArrayList)localObject1, QQOperateTips.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */