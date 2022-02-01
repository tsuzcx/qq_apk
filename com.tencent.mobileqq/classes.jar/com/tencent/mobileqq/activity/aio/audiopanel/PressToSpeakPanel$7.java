package com.tencent.mobileqq.activity.aio.audiopanel;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.qroute.QRoute;

class PressToSpeakPanel$7
  implements Runnable
{
  PressToSpeakPanel$7(PressToSpeakPanel paramPressToSpeakPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    if (PressToSpeakPanel.a(this.this$0).a()) {
      this.this$0.a(this.jdField_a_of_type_Int);
    }
    if (PressToSpeakPanel.c(this.this$0) == 1)
    {
      if (this.this$0.b())
      {
        PressToSpeakPanel.a(this.this$0).setText(HardCodeUtil.a(2131708401));
        return;
      }
      PressToSpeakPanel.a(this.this$0).setText(HardCodeUtil.a(2131708399));
      return;
    }
    if (PressToSpeakPanel.c(this.this$0) == 2)
    {
      PressToSpeakPanel.a(this.this$0).setText(HardCodeUtil.a(2131708396));
      return;
    }
    PressToSpeakPanel.a(this.this$0).setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.7
 * JD-Core Version:    0.7.0.1
 */