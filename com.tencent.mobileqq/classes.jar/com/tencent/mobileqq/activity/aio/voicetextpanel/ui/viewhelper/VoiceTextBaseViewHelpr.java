package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextInfoState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import mqq.app.AppRuntime;

public abstract class VoiceTextBaseViewHelpr
{
  protected AppRuntime a;
  protected Context b;
  protected VoiceTextStateModel c;
  protected VoiceTextUserOpListener d;
  
  public VoiceTextBaseViewHelpr(AppRuntime paramAppRuntime, VoiceTextStateModel paramVoiceTextStateModel)
  {
    this.a = paramAppRuntime;
    this.c = paramVoiceTextStateModel;
  }
  
  public void a(VoiceTextUserOpListener paramVoiceTextUserOpListener)
  {
    this.d = paramVoiceTextUserOpListener;
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.b = paramVoiceTextPanel.getContext();
  }
  
  public void b()
  {
    this.d = null;
  }
  
  public VoiceTextInfoState c()
  {
    return this.c.d();
  }
  
  public VoiceTextSttState d()
  {
    return this.c.c();
  }
  
  public VoiceTextUIState e()
  {
    return this.c.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBaseViewHelpr
 * JD-Core Version:    0.7.0.1
 */