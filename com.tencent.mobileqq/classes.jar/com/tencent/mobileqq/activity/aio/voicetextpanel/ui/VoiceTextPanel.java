package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextScrollerListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBottomViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextUpViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VoiceTextPanel
  extends BaseVoicetoTextView
{
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  private VoiceTextSttProcessController jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController;
  private VoiceTextScrollerListener jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextScrollerListener;
  private VoiceTextStateModel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel;
  private VoiceTextPanel.VoiceTextUserOpListenerImp jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel$VoiceTextUserOpListenerImp;
  private VoiceTextBottomViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper;
  private VoiceTextMaskViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper;
  private VoiceTextSlideViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper;
  private VoiceTextUpViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public boolean a;
  private boolean b = false;
  
  public VoiceTextPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.i();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.k();
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).restoreChatPieOtherFunction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setIsInVoiceTxt(false);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextScrollerListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextScrollerListener;
  }
  
  public VoiceTextUserOpListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel$VoiceTextUserOpListenerImp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.b() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextPanel onXContainerLayout left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" isShowEidt=");
      localStringBuilder.append(paramBoolean);
      QLog.d("VoiceTextPanel", 2, localStringBuilder.toString());
    }
    if (!this.b)
    {
      int i = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
      if (paramInt2 != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a(paramInt4);
      } else {
        paramInt2 += i;
      }
      if ((paramInt2 > i) && (getTop() == i) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(getRight() - getLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a());
      }
      if ((getTop() == paramInt2) && (paramInt4 == getBottom()) && (paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextPanel", 2, "onXContainerLayout edit state need no layout");
        }
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a() + getTop() - paramInt2 < ScreenUtil.dip2px(2.0F)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextPanel", 2, "onXContainerLayout normal state need no layout");
        }
        return;
      }
      measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
      layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, BaseAIOContext paramBaseAIOContext, BaseSessionInfo paramBaseSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextScrollerListener = new VoiceTextPanel.VoiceTextScrollerListenerImp(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel$VoiceTextUserOpListenerImp = new VoiceTextPanel.VoiceTextUserOpListenerImp(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel = new VoiceTextStateModel();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController = new VoiceTextSttProcessController(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel, paramAppRuntime, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper = new VoiceTextUpViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper = new VoiceTextBottomViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper = new VoiceTextSlideViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper = new VoiceTextMaskViewHelper();
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextPanel onSoftInputShowing  isShow=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" isDrag=");
      localStringBuilder.append(this.b);
      QLog.d("VoiceTextPanel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(paramBoolean);
    if (paramBoolean)
    {
      ReportUtils.a("0X800A1DC", 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper.a();
    }
    else
    {
      if (!this.b) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.c();
    }
    if ((!this.b) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(paramBoolean);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper.c();
  }
  
  public void c()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(getRight() - getLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a());
      return;
    }
    h();
  }
  
  public void e()
  {
    h();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextPanel onLayout  left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      QLog.d("VoiceTextPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void setParam(String paramString1, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper.a(paramString1, paramRecorderParam, paramInt, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, paramRecorderParam, paramInt, paramString2, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a();
    g();
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).hideChatPieOtherFunction(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel
 * JD-Core Version:    0.7.0.1
 */