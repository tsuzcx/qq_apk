package com.tencent.mobileqq.activity.aio.audiopanel;

import android.widget.TextView;

class CommonRecordSoundPanel$3
  implements Runnable
{
  CommonRecordSoundPanel$3(CommonRecordSoundPanel paramCommonRecordSoundPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.this$0.b(i);
    CommonRecordSoundPanel.a(this.this$0).setText(AudioPanel.a(this.jdField_a_of_type_Double));
    this.this$0.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.3
 * JD-Core Version:    0.7.0.1
 */