package com.tencent.mobileqq.activity.history.link.search;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class LinkMessageResultAdapter$3
  implements Runnable
{
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((LinkMessageResultAdapter)localObject).a(LinkMessageResultAdapter.n((LinkMessageResultAdapter)localObject), this.a);
    int j = 0;
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (LinkMessageResultAdapter.c(this.this$0, localMessageRecord))
        {
          this.this$0.b.add(new MessageItem(LinkMessageResultAdapter.o(this.this$0), localMessageRecord));
          this.this$0.c.add(Long.valueOf(localMessageRecord.shmsgseq));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = LinkMessageResultAdapter.r(this.this$0).getMessageFacade().b(LinkMessageResultAdapter.p(this.this$0).b, LinkMessageResultAdapter.q(this.this$0).a, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (LinkMessageResultAdapter.d(this.this$0, localMessageRecord))
          {
            this.this$0.b.add(new MessageItem(LinkMessageResultAdapter.s(this.this$0), localMessageRecord));
            this.this$0.c.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("localCacheMsgs size: ");
      ((StringBuilder)localObject).append(this.this$0.b.size());
      QLog.d("LinkMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.a);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.b));
    LinkMessageResultAdapter.t(this.this$0).obtainMessage(8, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.3
 * JD-Core Version:    0.7.0.1
 */