package com.tencent.mobileqq.activity.history;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryC2CLinkFragment$3$1
  implements Runnable
{
  ChatHistoryC2CLinkFragment$3$1(ChatHistoryC2CLinkFragment.3 param3, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment$3.a.b.getMessageFacade().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    for (;;)
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment$3.a.a.obtainMessage(2);
      localMessage.obj = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment$3.a.a.sendMessage(localMessage);
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment$3.a.b.getMessageFacade().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.3.1
 * JD-Core Version:    0.7.0.1
 */