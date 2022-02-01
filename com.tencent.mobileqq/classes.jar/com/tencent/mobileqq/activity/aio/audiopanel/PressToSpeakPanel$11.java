package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;

class PressToSpeakPanel$11
  implements Runnable
{
  PressToSpeakPanel$11(PressToSpeakPanel paramPressToSpeakPanel, String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble) {}
  
  public void run()
  {
    ((AudioPanelAioHelper)PressToSpeakPanel.i(this.this$0).q(128)).b(this.a, this.b);
    ((AudioPanelAioHelper)PressToSpeakPanel.i(this.this$0).q(128)).c(this.a, 2, this.b);
    ((AudioPanelAioHelper)PressToSpeakPanel.i(this.this$0).q(128)).a(this.a, null);
    this.this$0.a();
    ((AudioPanelAioHelper)PressToSpeakPanel.i(this.this$0).q(128)).a(this.a, (int)this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.11
 * JD-Core Version:    0.7.0.1
 */