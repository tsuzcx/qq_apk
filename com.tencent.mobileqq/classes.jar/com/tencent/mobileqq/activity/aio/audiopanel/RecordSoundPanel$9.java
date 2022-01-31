package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

class RecordSoundPanel$9
  implements Runnable
{
  RecordSoundPanel$9(RecordSoundPanel paramRecordSoundPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    ListenPanel localListenPanel = (ListenPanel)this.this$0.f.findViewById(2131303640);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    localListenPanel.setJumpSource(ListenPanel.b);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(4);
    this.this$0.setVisibility(8);
    this.this$0.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel.9
 * JD-Core Version:    0.7.0.1
 */