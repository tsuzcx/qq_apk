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
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setCustomTitleVisiable(VoiceTextPanel.a(this.a), 0);
    VoiceTextPanel.a(this.a).j();
    if (!VoiceTextPanel.a(this.a).a().a())
    {
      VoiceTextPanel.a(this.a).a().a(2, false);
      VoiceTextPanel.a(this.a).a();
    }
    else
    {
      VoiceTextPanel.a(this.a).a(1);
      VoiceTextPanel.a(this.a).a().a(true);
    }
    VoiceTextPanel.a(this.a);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 2)
    {
      if (!VoiceTextPanel.a(this.a).a().a()) {
        return;
      }
      VoiceTextPanel.a(this.a).a(paramMotionEvent);
    }
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
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setCustomTitleVisiable(VoiceTextPanel.a(this.a), 0);
    if (!VoiceTextPanel.a(this.a).a().a())
    {
      VoiceTextPanel.a(this.a).a().a(2, false);
      VoiceTextPanel.a(this.a).a();
      VoiceTextPanel.a(this.a).g();
      ReportUtils.a("0X800A1DB", 1, 0);
    }
    else
    {
      VoiceTextPanel.a(this.a).a(1);
      VoiceTextPanel.a(this.a).a().a(true);
      ReportUtils.a("0X800A1DB", 2, 0);
    }
    VoiceTextPanel.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel.VoiceTextUserOpListenerImp
 * JD-Core Version:    0.7.0.1
 */