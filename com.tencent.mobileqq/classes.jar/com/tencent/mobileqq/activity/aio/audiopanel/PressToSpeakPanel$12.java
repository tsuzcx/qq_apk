package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;

class PressToSpeakPanel$12
  implements Runnable
{
  PressToSpeakPanel$12(PressToSpeakPanel paramPressToSpeakPanel, String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    ((AudioPanelAioHelper)PressToSpeakPanel.a(this.this$0).a(128)).b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
    ListenPanel localListenPanel = (ListenPanel)PressToSpeakPanel.a(this.this$0).findViewById(2131370157);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, PressToSpeakPanel.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
    localListenPanel.setJumpSource(ListenPanel.a);
    PressToSpeakPanel.a(this.this$0).setStatus(4);
    this.this$0.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.12
 * JD-Core Version:    0.7.0.1
 */