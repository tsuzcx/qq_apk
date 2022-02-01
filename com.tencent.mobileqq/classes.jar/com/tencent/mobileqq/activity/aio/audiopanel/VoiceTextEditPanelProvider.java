package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class VoiceTextEditPanelProvider
  implements PanelProvider<BaseVoicetoTextView>
{
  private BaseChatPie a;
  private QQAppInterface b;
  private BaseVoicetoTextView c;
  
  public VoiceTextEditPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.d;
  }
  
  public BaseVoicetoTextView a()
  {
    return this.c;
  }
  
  public BaseVoicetoTextView a(Context paramContext)
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OpenPanelVoiceTextEditPanelProvider", 1, "createPanel chatPie is null");
      }
      return null;
    }
    long l = System.currentTimeMillis();
    this.c = ((IVoice2TxtApi)QRoute.api(IVoice2TxtApi.class)).getVoice2TxtView(this.a.e);
    this.c.a(this.b, this.a.bv(), this.a.ah, this.a.X, this.a.W);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openVoiceTextEditPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.c;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceTextEditPanelProvider", 1, "doOnPreFinish chatPie is null");
      }
      return;
    }
    if ((((BaseChatPie)localObject).bm().getCurrentPanel() == 36) && (paramInt == 0))
    {
      localObject = this.c;
      if (localObject != null) {
        ((BaseVoicetoTextView)localObject).d();
      }
    }
  }
  
  public void a(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.c != null)
    {
      AudioPanelAioHelper localAudioPanelAioHelper = (AudioPanelAioHelper)this.a.q(128);
      this.c.setParam(paramString, paramRecorderParam, paramInt, localAudioPanelAioHelper.c);
    }
  }
  
  public void b()
  {
    BaseVoicetoTextView localBaseVoicetoTextView = this.c;
    if (localBaseVoicetoTextView != null) {
      localBaseVoicetoTextView.e();
    }
  }
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceTextEditPanelProvider", 1, "doOnPause chatPie is null");
      }
      return;
    }
    if (((BaseChatPie)localObject).bm().getCurrentPanel() == 36)
    {
      localObject = this.c;
      if (localObject != null) {
        ((BaseVoicetoTextView)localObject).b();
      }
    }
  }
  
  public int getPanelId()
  {
    return 36;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 36) && (paramInt2 != 36) && (paramInt2 != 1))
    {
      BaseVoicetoTextView localBaseVoicetoTextView = this.c;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanelProvider
 * JD-Core Version:    0.7.0.1
 */