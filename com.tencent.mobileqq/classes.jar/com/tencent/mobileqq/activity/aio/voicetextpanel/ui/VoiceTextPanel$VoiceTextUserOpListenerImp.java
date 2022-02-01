package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextUpViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;

public class VoiceTextPanel$VoiceTextUserOpListenerImp
  implements VoiceTextUserOpListener
{
  public VoiceTextPanel$VoiceTextUserOpListenerImp(VoiceTextPanel paramVoiceTextPanel) {}
  
  public void a()
  {
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setCustomTitleVisiable(VoiceTextPanel.b(this.a), 0);
    VoiceTextPanel.d(this.a).j();
    if (!VoiceTextPanel.e(this.a).e().a())
    {
      VoiceTextPanel.b(this.a).q().a(2, false);
      VoiceTextPanel.g(this.a).b();
    }
    else
    {
      VoiceTextPanel.g(this.a).a(1);
      VoiceTextPanel.b(this.a).q().a(true);
    }
    VoiceTextPanel.h(this.a);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 2)
    {
      if (!VoiceTextPanel.e(this.a).e().a()) {
        return;
      }
      VoiceTextPanel.a(this.a).a(paramMotionEvent);
    }
  }
  
  public void a(String paramString)
  {
    VoiceTextPanel.d(this.a).b(paramString);
    VoiceTextPanel.e(this.a).e().b(true);
    VoiceTextPanel.f(this.a).a();
    this.a.c();
  }
  
  public void b()
  {
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setCustomTitleVisiable(VoiceTextPanel.b(this.a), 0);
    if (!VoiceTextPanel.e(this.a).e().a())
    {
      VoiceTextPanel.b(this.a).q().a(2, false);
      VoiceTextPanel.g(this.a).b();
      VoiceTextPanel.d(this.a).g();
      ReportUtils.a("0X800A1DB", 1, 0);
    }
    else
    {
      VoiceTextPanel.g(this.a).a(1);
      VoiceTextPanel.b(this.a).q().a(true);
      ReportUtils.a("0X800A1DB", 2, 0);
    }
    VoiceTextPanel.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel.VoiceTextUserOpListenerImp
 * JD-Core Version:    0.7.0.1
 */