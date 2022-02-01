package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryEmotionBaseFragment$2$1
  implements Runnable
{
  ChatHistoryEmotionBaseFragment$2$1(ChatHistoryEmotionBaseFragment.2 param2, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$2.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$2.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment$2.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */