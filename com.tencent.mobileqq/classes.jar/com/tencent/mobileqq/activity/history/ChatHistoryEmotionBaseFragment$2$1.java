package com.tencent.mobileqq.activity.history;

import afly;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment$2$1
  implements Runnable
{
  public ChatHistoryEmotionBaseFragment$2$1(afly paramafly, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_Afly.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afly.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_a_of_type_Afly.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */