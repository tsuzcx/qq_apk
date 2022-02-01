package com.tencent.mobileqq.activity.aio.audiopanel;

import android.widget.TextView;
import anni;
import aztd;

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
        PressToSpeakPanel.a(this.this$0).setText(anni.a(2131707177));
        return;
      }
      PressToSpeakPanel.a(this.this$0).setText(anni.a(2131707175));
      return;
    }
    if (PressToSpeakPanel.c(this.this$0) == 2)
    {
      PressToSpeakPanel.a(this.this$0).setText(anni.a(2131707172));
      return;
    }
    PressToSpeakPanel.a(this.this$0).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.7
 * JD-Core Version:    0.7.0.1
 */