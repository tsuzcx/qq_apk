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
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseVoicetoTextView jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public VoiceTextEditPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public BaseVoicetoTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
  }
  
  public BaseVoicetoTextView a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OpenPanelVoiceTextEditPanelProvider", 1, "createPanel chatPie is null");
      }
      return null;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView = ((IVoice2TxtApi)QRoute.api(IVoice2TxtApi.class)).getVoice2TxtView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openVoiceTextEditPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
  }
  
  public void a()
  {
    BaseVoicetoTextView localBaseVoicetoTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
    if (localBaseVoicetoTextView != null) {
      localBaseVoicetoTextView.e();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceTextEditPanelProvider", 1, "doOnPreFinish chatPie is null");
      }
      return;
    }
    if ((((BaseChatPie)localObject).a().a() == 36) && (paramInt == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
      if (localObject != null) {
        ((BaseVoicetoTextView)localObject).d();
      }
    }
  }
  
  public void a(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView != null)
    {
      AudioPanelAioHelper localAudioPanelAioHelper = (AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView.setParam(paramString, paramRecorderParam, paramInt, localAudioPanelAioHelper.a);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceTextEditPanelProvider", 1, "doOnPause chatPie is null");
      }
      return;
    }
    if (((BaseChatPie)localObject).a().a() == 36)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
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
      BaseVoicetoTextView localBaseVoicetoTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanelProvider
 * JD-Core Version:    0.7.0.1
 */