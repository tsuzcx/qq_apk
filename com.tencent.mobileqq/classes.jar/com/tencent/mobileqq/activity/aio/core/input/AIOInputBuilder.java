package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;

public class AIOInputBuilder
{
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseMessageSender jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputBaseMessageSender;
  
  public AIOInput a()
  {
    return new AIOInput(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputBaseMessageSender);
  }
  
  public AIOInputBuilder a(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    return this;
  }
  
  public AIOInputBuilder a(BaseMessageSender paramBaseMessageSender)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputBaseMessageSender = paramBaseMessageSender;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder
 * JD-Core Version:    0.7.0.1
 */