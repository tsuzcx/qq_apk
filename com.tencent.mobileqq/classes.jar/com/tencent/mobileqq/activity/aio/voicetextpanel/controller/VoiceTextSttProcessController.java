package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextSttListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextInfoState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VoiceTextSttProcessController
  implements VoiceTextSttListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  private VoiceTextSttQueryController jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController;
  private VoiceTextStateModel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private VoiceTextEditViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper;
  private VoiceTextSendViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new VoiceTextSttProcessController.1(this);
  private RecordParams.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private String b;
  
  public VoiceTextSttProcessController(VoiceTextStateModel paramVoiceTextStateModel, AppRuntime paramAppRuntime, VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel = paramVoiceTextStateModel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper = new VoiceTextSendViewHelper(paramVoiceTextStateModel, paramAppRuntime, paramAppRuntime.getApp().getSharedPreferences("check_update_sp_key", 0));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper = new VoiceTextEditViewHelper(paramVoiceTextStateModel, paramAppRuntime, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController = new VoiceTextSttQueryController();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a(paramBoolean);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b())
    {
      ReportUtils.a("0X800A1DA", 3, 0);
      return;
    }
    ReportUtils.a("0X800A1DA", 2, 0);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().d())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b();
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString.length() > 150))
      {
        RecordParams.RecorderParam localRecorderParam = this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
        localRecorderParam.jdField_a_of_type_JavaLangString = localRecorderParam.jdField_a_of_type_JavaLangString.substring(0, 150);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), HardCodeUtil.a(2131716333), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299168));
      f();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(5);
    }
  }
  
  private void o()
  {
    if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(2);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a()) {
        a(true);
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "sendRequest  net unAvailable");
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), HardCodeUtil.a(2131716332), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299168));
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), HardCodeUtil.a(2131716333), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299168));
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(5);
  }
  
  public void a(BaseAIOContext paramBaseAIOContext, BaseSessionInfo paramBaseSessionInfo, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.a(paramString1, this.jdField_a_of_type_MqqAppAppRuntime, this, paramBaseSessionInfo.jdField_a_of_type_Int, paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().c()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b(paramString);
      o();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.e();
  }
  
  public void b(String paramString)
  {
    if (StringUtil.a(paramString)) {
      a(false);
    } else {
      a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextSttProcessController.2(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(4);
  }
  
  public void e()
  {
    if (this.b == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()))
    {
      p();
      return;
    }
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setIsInVoiceTxt(true);
    ReportUtils.a("0X800A1D7", 0, 0);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.g();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a().setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.a();
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(null);
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.h();
  }
  
  public void i()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.c();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().c()))
    {
      m();
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().d()) {
        i = 2;
      } else {
        i = 1;
      }
      ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).sendVoiceAndTxt(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext, this.jdField_a_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, 0, false, i);
      ReportUtils.a("0X800A1DA", 1, 0);
      return;
    }
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).sendTxt(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext());
    l();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController
 * JD-Core Version:    0.7.0.1
 */