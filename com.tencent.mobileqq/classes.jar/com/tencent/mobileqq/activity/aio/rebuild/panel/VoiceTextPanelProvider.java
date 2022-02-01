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
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseVoicetoTextView jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
  
  public int a()
  {
    return 0;
  }
  
  public BaseVoicetoTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
  }
  
  public BaseVoicetoTextView a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView = ((IVoice2TxtApi)QRoute.api(IVoice2TxtApi.class)).getVoice2TxtView(paramContext);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    paramContext.a(localQQAppInterface, localAIOContext, localAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openVoiceTextEditPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 36) && (paramInt == 0))
    {
      BaseVoicetoTextView localBaseVoicetoTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
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
      localBaseVoicetoTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
      if (localBaseVoicetoTextView != null) {
        localBaseVoicetoTextView.e();
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() instanceof BaseVoicetoTextView))
    {
      localBaseVoicetoTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelViewBaseVoicetoTextView;
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
    if ((paramInt2 == 36) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setSelected(2);
    }
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.VoiceTextPanelProvider
 * JD-Core Version:    0.7.0.1
 */