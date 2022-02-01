package com.tencent.mobileqq.activity.messagesearch;

import akcc;
import akcy;
import android.os.Message;
import bkyc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class C2CMessageResultAdapter$1
  implements Runnable
{
  public C2CMessageResultAdapter$1(akcc paramakcc, String paramString, long paramLong, List paramList) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryAllHistroyByKey(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (this.this$0.a(localMessageRecord)) {
          this.this$0.jdField_a_of_type_JavaUtilList.add(new akcy(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgListByID(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (this.this$0.a(localMessageRecord)) {
            this.this$0.jdField_a_of_type_JavaUtilList.add(new akcy(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "localCacheMsgs size: " + this.this$0.jdField_a_of_type_JavaUtilList.size());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject).put("data", this.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_Bkyc.obtainMessage(6, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */