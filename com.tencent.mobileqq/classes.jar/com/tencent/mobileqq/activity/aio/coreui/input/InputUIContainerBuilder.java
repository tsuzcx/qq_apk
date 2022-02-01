package com.tencent.mobileqq.activity.aio.coreui.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;

public final class InputUIContainerBuilder
{
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private EditTextUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI;
  private FunBtnUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI;
  private InputBarUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI;
  private InputRightIconUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI;
  
  public InputUIContainer a()
  {
    return new InputUIContainer(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI);
  }
  
  public InputUIContainerBuilder a(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    return this;
  }
  
  public InputUIContainerBuilder a(EditTextUI paramEditTextUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputEditTextUI = paramEditTextUI;
    return this;
  }
  
  public InputUIContainerBuilder a(FunBtnUI paramFunBtnUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputFunBtnUI = paramFunBtnUI;
    return this;
  }
  
  public InputUIContainerBuilder a(InputBarUI paramInputBarUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputBarUI = paramInputBarUI;
    return this;
  }
  
  public InputUIContainerBuilder a(InputRightIconUI paramInputRightIconUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiInputInputRightIconUI = paramInputRightIconUI;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainerBuilder
 * JD-Core Version:    0.7.0.1
 */