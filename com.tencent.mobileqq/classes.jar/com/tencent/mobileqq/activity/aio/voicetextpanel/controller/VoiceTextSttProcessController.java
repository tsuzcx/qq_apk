package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VoiceTextSttProcessController
  implements VoiceTextSttListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private VoiceTextSttQueryController jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController;
  private VoiceTextStateModel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private VoiceTextEditViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper;
  private VoiceTextSendViewHelper jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new VoiceTextSttProcessController.1(this);
  private RecordParams.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public VoiceTextSttProcessController(VoiceTextStateModel paramVoiceTextStateModel, QQAppInterface paramQQAppInterface, VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel = paramVoiceTextStateModel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper = new VoiceTextSendViewHelper(paramVoiceTextStateModel, paramQQAppInterface, paramQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper = new VoiceTextEditViewHelper(paramVoiceTextStateModel, paramQQAppInterface, this.jdField_a_of_type_AndroidOsHandler);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString.length() > 150)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_JavaLangString.substring(0, 150);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), HardCodeUtil.a(2131716682), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299166));
      f();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.c();
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
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), HardCodeUtil.a(2131716681), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299166));
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
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), HardCodeUtil.a(2131716680), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299166));
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().a(5);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramBaseChatPie.b(), paramBaseChatPie.b());
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().c()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().f()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().b(paramString);
    o();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextEditViewHelper.e();
  }
  
  public void b(String paramString)
  {
    if (StringUtil.a(paramString)) {
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiViewhelperVoiceTextSendViewHelper.a();
      return;
      a(true);
    }
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
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()))
    {
      p();
      return;
    }
    com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper.b = true;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelControllerVoiceTextSttQueryController.b();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a().d()) {}
      for (int i = 2;; i = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(this.jdField_a_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, 0, false, i);
        ReportUtils.a("0X800A1DA", 1, 0);
        return;
      }
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    ArrayList localArrayList = new ArrayList();
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a(), localArrayList, localSendMsgParams);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController
 * JD-Core Version:    0.7.0.1
 */