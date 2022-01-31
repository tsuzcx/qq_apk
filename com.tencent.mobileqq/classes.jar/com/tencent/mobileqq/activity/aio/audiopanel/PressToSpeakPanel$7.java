package com.tencent.mobileqq.activity.aio.audiopanel;

import ajjy;
import android.widget.TextView;
import auck;

class PressToSpeakPanel$7
  implements Runnable
{
  PressToSpeakPanel$7(PressToSpeakPanel paramPressToSpeakPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    if (PressToSpeakPanel.a(this.this$0).a()) {
      this.this$0.b(this.jdField_a_of_type_Int);
    }
    if (PressToSpeakPanel.c(this.this$0) == 1)
    {
      if (this.this$0.b())
      {
        PressToSpeakPanel.a(this.this$0).setText(ajjy.a(2131642621));
        return;
      }
      PressToSpeakPanel.a(this.this$0).setText(ajjy.a(2131642619));
      return;
    }
    if (PressToSpeakPanel.c(this.this$0) == 2)
    {
      PressToSpeakPanel.a(this.this$0).setText(ajjy.a(2131642616));
      return;
    }
    PressToSpeakPanel.a(this.this$0).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.7
 * JD-Core Version:    0.7.0.1
 */