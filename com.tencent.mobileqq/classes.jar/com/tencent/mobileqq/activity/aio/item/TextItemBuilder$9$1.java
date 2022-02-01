package com.tencent.mobileqq.activity.aio.item;

import ahit;
import ahja;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class TextItemBuilder$9$1
  implements Runnable
{
  public TextItemBuilder$9$1(ahja paramahja, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ahja.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(this.jdField_a_of_type_Ahja.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Ahja.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.9.1
 * JD-Core Version:    0.7.0.1
 */