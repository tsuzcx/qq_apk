package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryMediaBaseFragment$1$1
  implements Runnable
{
  ChatHistoryMediaBaseFragment$1$1(ChatHistoryMediaBaseFragment.1 param1, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment$1.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment$1.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryMediaBaseFragment$1.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment.1.1
 * JD-Core Version:    0.7.0.1
 */