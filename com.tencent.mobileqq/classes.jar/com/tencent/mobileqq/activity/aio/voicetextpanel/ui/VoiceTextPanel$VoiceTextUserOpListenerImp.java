package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextUpViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class VoiceTextPanel$VoiceTextUserOpListenerImp
  implements VoiceTextUserOpListener
{
  public VoiceTextPanel$VoiceTextUserOpListenerImp(VoiceTextPanel paramVoiceTextPanel) {}
  
  public void a()
  {
    VoiceTextPanel.a(this.a).a.setVisibility(0);
    VoiceTextPanel.a(this.a).j();
    if (!VoiceTextPanel.a(this.a).a().a())
    {
      VoiceTextPanel.a(this.a).f(false);
      VoiceTextPanel.a(this.a).a();
    }
    for (;;)
    {
      VoiceTextPanel.a(this.a);
      return;
      VoiceTextPanel.a(this.a).a(1);
      VoiceTextPanel.a(this.a).aF();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) || (!VoiceTextPanel.a(this.a).a().a())) {
      return;
    }
    VoiceTextPanel.a(this.a).a(paramMotionEvent);
  }
  
  public void a(String paramString)
  {
    VoiceTextPanel.a(this.a).b(paramString);
    VoiceTextPanel.a(this.a).a().b(true);
    VoiceTextPanel.a(this.a).a();
    this.a.c();
  }
  
  public void b()
  {
    VoiceTextPanel.a(this.a).a.setVisibility(0);
    if (!VoiceTextPanel.a(this.a).a().a())
    {
      VoiceTextPanel.a(this.a).f(false);
      VoiceTextPanel.a(this.a).a();
      VoiceTextPanel.a(this.a).g();
      ReportUtils.a("0X800A1DB", 1, 0);
    }
    for (;;)
    {
      VoiceTextPanel.a(this.a);
      return;
      VoiceTextPanel.a(this.a).a(1);
      VoiceTextPanel.a(this.a).aF();
      ReportUtils.a("0X800A1DB", 2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel.VoiceTextUserOpListenerImp
 * JD-Core Version:    0.7.0.1
 */