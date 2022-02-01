package com.tencent.mobileqq.activity;

import android.database.Cursor;
import android.os.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import mqq.os.MqqHandler;

class ChatHistory$ChatHistoryAdapter$10
  implements Runnable
{
  ChatHistory$ChatHistoryAdapter$10(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject3 = "ORDER BY shmsgseq";
    Object localObject1 = localObject3;
    if (i != 1)
    {
      localObject1 = localObject3;
      if (i != 3000) {
        localObject1 = "ORDER BY time asc , longMsgIndex asc";
      }
    }
    i = this.b;
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.l)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.d = true;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.d = false;
      i = this.b - this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.l;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("( msgtype ");
    ((StringBuilder)localObject3).append(UinTypeUtil.a());
    ((StringBuilder)localObject3).append(" and isValid=1 ) ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" limit ");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(String.valueOf(8));
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    String str = MessageRecord.getOldTableName(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.d)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a((String)localObject3, str, (String)localObject1);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager == null) {
          break label307;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a((String)localObject3, (String)localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label266:
        continue;
        Object localObject2 = null;
      }
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      ((Cursor)localObject1).getCount();
      localObject3 = localObject1;
      break label266;
      localObject3 = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(8);
    ((Message)localObject1).obj = localObject3;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.10
 * JD-Core Version:    0.7.0.1
 */