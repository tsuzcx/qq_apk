package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextScrollerListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBottomViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextUpViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.BaseChatPieCompatibleUtils;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class VoiceTextPanel
  extends RelativeLayout
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private VoiceTextSttProcessController jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController;
  private VoiceTextScrollerListener jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextScrollerListener;
  private VoiceTextStateModel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel;
  private VoiceTextPanel.VoiceTextUserOpListenerImp jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel$VoiceTextUserOpListenerImp;
  private VoiceTextBottomViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper;
  private VoiceTextMaskViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper;
  private VoiceTextSlideViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper;
  private VoiceTextUpViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    BaseChatPieCompatibleUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper.b = false;
    this.b = false;
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
    int i;
    if (!this.b)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getBottom();
      if (paramInt2 == 0) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a(paramInt4);
      if ((paramInt2 > i) && (getTop() == i) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(getRight() - getLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a());
      }
      if ((getTop() != paramInt2) || (paramInt4 != getBottom()) || (!paramBoolean)) {
        break label122;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextPanel", 2, "onXContainerLayout edit state need no layout");
      }
    }
    label114:
    label122:
    do
    {
      return;
      paramInt2 += i;
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a() + getTop() - paramInt2 >= ScreenUtil.dip2px(2.0F))) {
        break label168;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextPanel", 2, "onXContainerLayout normal state need no layout");
    return;
    label168:
    measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextScrollerListener = new VoiceTextPanel.VoiceTextScrollerListenerImp(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel$VoiceTextUserOpListenerImp = new VoiceTextPanel.VoiceTextUserOpListenerImp(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel = new VoiceTextStateModel();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController = new VoiceTextSttProcessController(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel, paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper = new VoiceTextUpViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper = new VoiceTextBottomViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper = new VoiceTextSlideViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper = new VoiceTextMaskViewHelper();
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextPanel", 2, " onSoftInputShowing  isShow=" + paramBoolean + " isDrag=" + this.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(paramBoolean);
    if (paramBoolean)
    {
      ReportUtils.a("0X800A1DC", 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper.a();
    }
    for (;;)
    {
      if ((!this.b) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextMaskViewHelper.a(paramBoolean);
      }
      return;
      if (!this.b) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextBottomViewHelper.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.c();
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
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void setParam(String paramString1, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextUpViewHelper.a(paramString1, paramRecorderParam, paramInt, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRecorderParam, paramInt, paramString2, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSlideViewHelper.a();
    g();
    BaseChatPieCompatibleUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttProcessController.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel
 * JD-Core Version:    0.7.0.1
 */