package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPttPlayView;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;

public class VoiceTextUpViewHelper
{
  private VoiceTextPttPlayView a;
  private TextView b;
  private LinearLayout c;
  
  public void a()
  {
    this.c.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.b = ((TextView)paramVoiceTextPanel.findViewById(2131445598));
    this.c = ((LinearLayout)paramVoiceTextPanel.findViewById(2131450044));
    this.a = ((VoiceTextPttPlayView)paramVoiceTextPanel.findViewById(2131446105));
  }
  
  public void a(String paramString, RecordParams.RecorderParam paramRecorderParam, int paramInt, VoiceTextPanel paramVoiceTextPanel)
  {
    VoiceTextPttPlayView localVoiceTextPttPlayView = this.a;
    if (localVoiceTextPttPlayView != null) {
      localVoiceTextPttPlayView.setDuration(paramInt, paramString, paramRecorderParam, paramVoiceTextPanel);
    }
  }
  
  public void b()
  {
    this.c.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void c()
  {
    VoiceTextPttPlayView localVoiceTextPttPlayView = this.a;
    if (localVoiceTextPttPlayView != null) {
      localVoiceTextPttPlayView.a();
    }
  }
  
  public void d()
  {
    VoiceTextPttPlayView localVoiceTextPttPlayView = this.a;
    if (localVoiceTextPttPlayView != null) {
      localVoiceTextPttPlayView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextUpViewHelper
 * JD-Core Version:    0.7.0.1
 */