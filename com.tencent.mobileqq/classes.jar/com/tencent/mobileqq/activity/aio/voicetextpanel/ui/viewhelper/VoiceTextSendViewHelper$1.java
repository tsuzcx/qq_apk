package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VoiceTextSendViewHelper$1
  implements CompoundButton.OnCheckedChangeListener
{
  VoiceTextSendViewHelper$1(VoiceTextSendViewHelper paramVoiceTextSendViewHelper) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.a().e()) {
        this.a.a(true);
      }
      VoiceTextSendViewHelper.a(this.a, true);
      VoiceTextSendViewHelper.a(this.a).setText(2131719048);
      this.a.a().c(true);
      VoiceTextSendViewHelper.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      VoiceTextSendViewHelper.a(this.a, false);
      VoiceTextSendViewHelper.a(this.a).setText(2131719046);
      if ((this.a.a().f()) && (StringUtil.a(this.a.a.a()))) {
        this.a.a(false);
      }
      this.a.a().c(false);
      VoiceTextSendViewHelper.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.1
 * JD-Core Version:    0.7.0.1
 */