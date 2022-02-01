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
    ((AudioPanelAioHelper)PressToSpeakPanel.i(this.this$0).q(128)).b(this.a, this.b);
    ListenPanel localListenPanel = (ListenPanel)PressToSpeakPanel.j(this.this$0).findViewById(2131437321);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.a, PressToSpeakPanel.k(this.this$0), this.b);
    localListenPanel.setJumpSource(ListenPanel.a);
    PressToSpeakPanel.c(this.this$0).setStatus(4);
    this.this$0.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.12
 * JD-Core Version:    0.7.0.1
 */