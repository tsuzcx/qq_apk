package com.tencent.mobileqq.activity.history;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBaseTenDocFragment$1$1
  implements Runnable
{
  ChatHistoryBaseTenDocFragment$1$1(ChatHistoryBaseTenDocFragment.1 param1, List paramList) {}
  
  public void run()
  {
    if (this.a.size() == 1)
    {
      this.b.b.a.getMessageFacade().a(((TencentDocItem)this.a.get(0)).mRecord, false);
    }
    else if (this.a.size() > 1)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((TencentDocItem)localIterator.next()).mRecord);
      }
      this.b.b.a.getMessageFacade().a((List)localObject, false);
    }
    Object localObject = ChatHistoryBaseTenDocFragment.b(this.b.b).obtainMessage(5678, this.a);
    ChatHistoryBaseTenDocFragment.b(this.b.b).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.1.1
 * JD-Core Version:    0.7.0.1
 */