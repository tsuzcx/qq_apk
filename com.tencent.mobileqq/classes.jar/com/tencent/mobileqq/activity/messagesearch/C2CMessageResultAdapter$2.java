package com.tencent.mobileqq.activity.messagesearch;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class C2CMessageResultAdapter$2
  implements Runnable
{
  C2CMessageResultAdapter$2(C2CMessageResultAdapter paramC2CMessageResultAdapter, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.this$0.h.getMessageFacade().a(this.a, this.this$0.g.b, this.this$0.g.a, this.this$0.g.e);
    int j = 0;
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (this.this$0.a(localMessageRecord))
        {
          this.this$0.a.add(new MessageItem(this.this$0.h, localMessageRecord));
          this.this$0.b.add(Long.valueOf(localMessageRecord.shmsgseq));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = this.this$0.h.getMessageFacade().b(this.this$0.g.b, this.this$0.g.a, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (this.this$0.a(localMessageRecord))
          {
            this.this$0.a.add(new MessageItem(this.this$0.h, localMessageRecord));
            this.this$0.b.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("localCacheMsgs size: ");
      ((StringBuilder)localObject).append(this.this$0.a.size());
      QLog.d("C2CMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.a);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.b));
    this.this$0.f.obtainMessage(8, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter.2
 * JD-Core Version:    0.7.0.1
 */