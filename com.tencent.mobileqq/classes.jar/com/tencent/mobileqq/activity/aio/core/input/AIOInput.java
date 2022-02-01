package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;

public class AIOInput
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final BaseMessageSender jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputBaseMessageSender;
  private final MessageSignal jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputMessageSignal;
  private InputUIContainer jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputUIContainer;
  private final InputCallbackRegister jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputInputCallbackRegister;
  
  public AIOInput(AIOContext paramAIOContext, BaseMessageSender paramBaseMessageSender)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputInputCallbackRegister = new InputCallbackRegister(paramAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputMessageSignal = new MessageSignal(paramAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputBaseMessageSender = paramBaseMessageSender;
  }
  
  public BaseMessageSender a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputBaseMessageSender;
  }
  
  public MessageSignal a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputMessageSignal;
  }
  
  public InputUIContainer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputUIContainer;
  }
  
  public InputCallbackRegister a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputInputCallbackRegister;
  }
  
  public final void a(InputUIContainer paramInputUIContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputUIContainer = paramInputUIContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.AIOInput
 * JD-Core Version:    0.7.0.1
 */