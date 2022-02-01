package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class VoiceTextPanelProvider
  implements OnFinishListener, ILifeCycleHelper, PanelProvider<BaseVoicetoTextView>
{
  private BaseVoicetoTextView a;
  private AIOContext b;
  
  public BaseVoicetoTextView a()
  {
    return this.a;
  }
  
  public BaseVoicetoTextView a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.a = ((IVoice2TxtApi)QRoute.api(IVoice2TxtApi.class)).getVoice2TxtView(paramContext);
    paramContext = this.a;
    QQAppInterface localQQAppInterface = this.b.a();
    AIOContext localAIOContext = this.b;
    paramContext.a(localQQAppInterface, localAIOContext, localAIOContext.O(), this.b.p().d().e().a(), this.b.C());
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openVoiceTextEditPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.a;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e(int paramInt)
  {
    if ((this.b.q().b() == 36) && (paramInt == 0))
    {
      BaseVoicetoTextView localBaseVoicetoTextView = this.a;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.d();
      }
    }
  }
  
  public int getPanelId()
  {
    return 36;
  }
  
  @NonNull
  public String getTag()
  {
    return "VoiceTextPanelProvider";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 11 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    BaseVoicetoTextView localBaseVoicetoTextView;
    if (paramInt != 11)
    {
      if (paramInt != 15) {
        return;
      }
      localBaseVoicetoTextView = this.a;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.e();
      }
    }
    else if ((this.b.q().c() instanceof BaseVoicetoTextView))
    {
      localBaseVoicetoTextView = this.a;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.b();
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 36) && (this.b.C() != null)) {
      this.b.C().setSelected(2);
    }
    if ((paramInt1 == 36) && (paramInt2 != 36) && (paramInt2 != 1))
    {
      BaseVoicetoTextView localBaseVoicetoTextView = this.a;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.VoiceTextPanelProvider
 * JD-Core Version:    0.7.0.1
 */