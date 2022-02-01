package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class BubbleInterActiveAnim$FindOriginalMsg
{
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public BubbleInterActiveAnim$FindOriginalMsg(MessageRecord paramMessageRecord, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
  }
  
  public FindOriginalMsg a()
  {
    if (!this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) {
        this.b = true;
      }
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.FindOriginalMsg
 * JD-Core Version:    0.7.0.1
 */