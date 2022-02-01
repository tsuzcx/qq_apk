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
    localObject = ((LinkMessageResultAdapter)localObject).a(LinkMessageResultAdapter.f((LinkMessageResultAdapter)localObject), this.jdField_a_of_type_JavaLangString);
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
          this.this$0.jdField_a_of_type_JavaUtilList.add(new MessageItem(LinkMessageResultAdapter.e(this.this$0), localMessageRecord));
          this.this$0.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(localMessageRecord.shmsgseq));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = LinkMessageResultAdapter.f(this.this$0).getMessageFacade().a(LinkMessageResultAdapter.g(this.this$0).jdField_a_of_type_JavaLangString, LinkMessageResultAdapter.h(this.this$0).jdField_a_of_type_Int, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (LinkMessageResultAdapter.d(this.this$0, localMessageRecord))
          {
            this.this$0.jdField_a_of_type_JavaUtilList.add(new MessageItem(LinkMessageResultAdapter.g(this.this$0), localMessageRecord));
            this.this$0.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("localCacheMsgs size: ");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaUtilList.size());
      QLog.d("LinkMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.jdField_a_of_type_Long));
    LinkMessageResultAdapter.d(this.this$0).obtainMessage(8, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.3
 * JD-Core Version:    0.7.0.1
 */