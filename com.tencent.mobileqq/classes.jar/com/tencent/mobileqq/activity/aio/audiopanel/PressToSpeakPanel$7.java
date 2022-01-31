package com.tencent.mobileqq.activity.aio.audiopanel;

import alpo;
import android.widget.TextView;
import awtf;

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
        PressToSpeakPanel.a(this.this$0).setText(alpo.a(2131708789));
        return;
      }
      PressToSpeakPanel.a(this.this$0).setText(alpo.a(2131708787));
      return;
    }
    if (PressToSpeakPanel.c(this.this$0) == 2)
    {
      PressToSpeakPanel.a(this.this$0).setText(alpo.a(2131708784));
      return;
    }
    PressToSpeakPanel.a(this.this$0).setText(AudioPanel.a(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.7
 * JD-Core Version:    0.7.0.1
 */