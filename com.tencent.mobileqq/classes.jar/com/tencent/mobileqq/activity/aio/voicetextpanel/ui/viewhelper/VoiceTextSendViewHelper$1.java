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
      if (this.a.d().e()) {
        this.a.a(true);
      }
      VoiceTextSendViewHelper.a(this.a, true);
      VoiceTextSendViewHelper.a(this.a).setText(2131916270);
      this.a.e().c(true);
      VoiceTextSendViewHelper.b(this.a);
    }
    else
    {
      VoiceTextSendViewHelper.a(this.a, false);
      VoiceTextSendViewHelper.a(this.a).setText(2131916268);
      if ((this.a.d().f()) && (StringUtil.isEmpty(this.a.c.a()))) {
        this.a.a(false);
      }
      this.a.e().c(false);
      VoiceTextSendViewHelper.c(this.a);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.1
 * JD-Core Version:    0.7.0.1
 */