package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

class PressToSpeakPanel$11
  implements Runnable
{
  PressToSpeakPanel$11(PressToSpeakPanel paramPressToSpeakPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble) {}
  
  public void run()
  {
    PressToSpeakPanel.a(this.this$0).recoderToListen(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    PressToSpeakPanel.a(this.this$0).cancelSendPtt(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    PressToSpeakPanel.a(this.this$0).recorderEnd(this.jdField_a_of_type_JavaLangString, null);
    this.this$0.d();
    PressToSpeakPanel.a(this.this$0).showVoiceEditPanel(this.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.11
 * JD-Core Version:    0.7.0.1
 */