package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryBubbleListFragment$5$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$5$1(ChatHistoryBubbleListFragment.5 param5) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("do delete uniseq=");
      ((StringBuilder)localObject).append(this.a.a.uniseq);
      ((StringBuilder)localObject).append(",id=");
      ((StringBuilder)localObject).append(this.a.a.getId());
      QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QSlowTableManager)this.a.c.f.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (localObject != null) {
      ((QSlowTableManager)localObject).a(this.a.a, false);
    }
    this.a.c.f.getMessageFacade().a(this.a.a, true);
    if ((this.a.a instanceof IMessageForApollo)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.c.f, "chat_history_start_del_msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */