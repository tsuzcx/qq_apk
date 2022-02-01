package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;

class RecordSoundPanel$9
  implements Runnable
{
  RecordSoundPanel$9(RecordSoundPanel paramRecordSoundPanel, String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    ((AudioPanelAioHelper)this.this$0.a.q(128)).b(this.a, this.b);
    this.this$0.c.setVisibility(8);
    ListenPanel localListenPanel = (ListenPanel)this.this$0.o.findViewById(2131437321);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.a, this.this$0.s, this.b);
    localListenPanel.setJumpSource(ListenPanel.b);
    this.this$0.d.setStatus(4);
    this.this$0.setVisibility(8);
    this.this$0.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel.9
 * JD-Core Version:    0.7.0.1
 */