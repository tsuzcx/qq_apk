package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.view.View.MeasureSpec;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextScrollerListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBottomViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class VoiceTextPanel$VoiceTextScrollerListenerImp
  implements VoiceTextScrollerListener
{
  public VoiceTextPanel$VoiceTextScrollerListenerImp(VoiceTextPanel paramVoiceTextPanel) {}
  
  public void a()
  {
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).hideSoftInput(VoiceTextPanel.b(this.a));
  }
  
  public void a(int paramInt)
  {
    if (VoiceTextPanel.a(this.a).g() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextPanel", 2, "onActionDown but mHeader cannot see");
      }
      return;
    }
    VoiceTextPanel.a(this.a, true);
    VoiceTextPanel localVoiceTextPanel = this.a;
    localVoiceTextPanel.measure(View.MeasureSpec.makeMeasureSpec(localVoiceTextPanel.getRight() - this.a.getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt - this.a.getTop(), 1073741824));
    localVoiceTextPanel = this.a;
    localVoiceTextPanel.layout(localVoiceTextPanel.getLeft(), this.a.getTop(), this.a.getRight(), paramInt);
    VoiceTextPanel.a(this.a).a(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom(), paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextPanel", 2, "enterEditState");
    }
    VoiceTextPanel.c(this.a).a();
    VoiceTextPanel.a(this.a).a(paramInt1, paramInt2, this.a.getHeight(), this.a.getTop());
    VoiceTextPanel.b(this.a).q().a(1, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    VoiceTextPanel.a(this.a).a(paramInt1, paramInt2, paramInt3);
    VoiceTextPanel.c(this.a).b();
  }
  
  public void b()
  {
    VoiceTextPanel.a(this.a).a(true);
    VoiceTextPanel.a(this.a, false);
    VoiceTextPanel.d(this.a).b();
  }
  
  public void c()
  {
    VoiceTextPanel.a(this.a).a(false);
    VoiceTextPanel.a(this.a, false);
  }
  
  public int d()
  {
    return XPanelContainer.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel.VoiceTextScrollerListenerImp
 * JD-Core Version:    0.7.0.1
 */