package com.tencent.mobileqq.activity.history.link.search;

import ajbe;
import ajhk;
import android.os.Message;
import bjmp;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class TroopAllMessageResultAdapter$2
  implements Runnable
{
  public TroopAllMessageResultAdapter$2(ajbe paramajbe, String paramString, long paramLong, List paramList) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = ajbe.d(this.this$0).getMessageFacade().queryAllHistroyByKey(ajbe.c(this.this$0), this.jdField_a_of_type_JavaLangString);
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (ajbe.a(this.this$0, localMessageRecord)) {
          this.this$0.jdField_a_of_type_JavaUtilList.add(new ajhk(ajbe.e(this.this$0), localMessageRecord));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = ajbe.f(this.this$0).getMessageFacade().queryMsgListByID(ajbe.d(this.this$0).curFriendUin, ajbe.e(this.this$0).curType, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (ajbe.b(this.this$0, localMessageRecord)) {
            this.this$0.jdField_a_of_type_JavaUtilList.add(new ajhk(ajbe.g(this.this$0), localMessageRecord));
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
    ajbe.c(this.this$0).obtainMessage(6, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.2
 * JD-Core Version:    0.7.0.1
 */