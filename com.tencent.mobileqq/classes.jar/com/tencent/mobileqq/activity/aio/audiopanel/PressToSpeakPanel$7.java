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
    if (PressToSpeakPanel.f(this.this$0).a()) {
      this.this$0.a(this.a);
    }
    if (PressToSpeakPanel.g(this.this$0) == 1)
    {
      if (this.this$0.i())
      {
        PressToSpeakPanel.h(this.this$0).setText(HardCodeUtil.a(2131906189));
        return;
      }
      PressToSpeakPanel.h(this.this$0).setText(HardCodeUtil.a(2131906187));
      return;
    }
    if (PressToSpeakPanel.g(this.this$0) == 2)
    {
      PressToSpeakPanel.h(this.this$0).setText(HardCodeUtil.a(2131906184));
      return;
    }
    PressToSpeakPanel.h(this.this$0).setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.7
 * JD-Core Version:    0.7.0.1
 */