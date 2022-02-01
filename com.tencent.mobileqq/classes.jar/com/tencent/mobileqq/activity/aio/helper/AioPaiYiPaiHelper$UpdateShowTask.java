package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

class AioPaiYiPaiHelper$UpdateShowTask
  implements Runnable
{
  private AioPaiYiPaiHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperAioPaiYiPaiHelper;
  private MessageForUniteGrayTip jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip;
  
  AioPaiYiPaiHelper$UpdateShowTask(AioPaiYiPaiHelper paramAioPaiYiPaiHelper, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAioPaiYiPaiHelper = paramAioPaiYiPaiHelper;
    this.jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip = paramMessageForUniteGrayTip;
  }
  
  public void run()
  {
    AioPaiYiPaiHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAioPaiYiPaiHelper).a().getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip.frienduin, this.jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip.istroop, this.jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper.UpdateShowTask
 * JD-Core Version:    0.7.0.1
 */