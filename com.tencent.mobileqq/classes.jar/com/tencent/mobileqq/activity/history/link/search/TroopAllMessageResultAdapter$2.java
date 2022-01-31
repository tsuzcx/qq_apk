package com.tencent.mobileqq.activity.history.link.search;

import agbr;
import ager;
import android.os.Message;
import bfmt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class TroopAllMessageResultAdapter$2
  implements Runnable
{
  public TroopAllMessageResultAdapter$2(agbr paramagbr, String paramString, long paramLong, List paramList) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = agbr.d(this.this$0).a().a(agbr.c(this.this$0), this.jdField_a_of_type_JavaLangString);
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (agbr.a(this.this$0, localMessageRecord)) {
          this.this$0.jdField_a_of_type_JavaUtilList.add(new ager(agbr.e(this.this$0), localMessageRecord));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = agbr.f(this.this$0).a().a(agbr.d(this.this$0).jdField_a_of_type_JavaLangString, agbr.e(this.this$0).jdField_a_of_type_Int, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (agbr.b(this.this$0, localMessageRecord)) {
            this.this$0.jdField_a_of_type_JavaUtilList.add(new ager(agbr.g(this.this$0), localMessageRecord));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "localCacheMsgs size: " + this.this$0.jdField_a_of_type_JavaUtilList.size());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject).put("data", this.jdField_a_of_type_JavaUtilList);
    agbr.c(this.this$0).obtainMessage(6, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.2
 * JD-Core Version:    0.7.0.1
 */