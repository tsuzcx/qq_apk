package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VoiceTextSendViewHelper$2
  implements View.OnClickListener
{
  VoiceTextSendViewHelper$2(VoiceTextSendViewHelper paramVoiceTextSendViewHelper) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.2
 * JD-Core Version:    0.7.0.1
 */