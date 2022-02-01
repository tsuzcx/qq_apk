package com.tencent.mobileqq.activity.history;

import ajss;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment$2$1
  implements Runnable
{
  public ChatHistoryEmotionBaseFragment$2$1(ajss paramajss, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_Ajss.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByMessageRecord((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajss.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_a_of_type_Ajss.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMultiMsgByMessageRecord(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */