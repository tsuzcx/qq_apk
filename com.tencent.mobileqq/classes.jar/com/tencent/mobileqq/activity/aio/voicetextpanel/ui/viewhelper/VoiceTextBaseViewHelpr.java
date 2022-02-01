package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextInfoState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import mqq.app.AppRuntime;

public abstract class VoiceTextBaseViewHelpr
{
  protected Context a;
  protected VoiceTextUserOpListener a;
  protected VoiceTextStateModel a;
  protected AppRuntime a;
  
  public VoiceTextBaseViewHelpr(AppRuntime paramAppRuntime, VoiceTextStateModel paramVoiceTextStateModel)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel = paramVoiceTextStateModel;
  }
  
  public VoiceTextInfoState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a();
  }
  
  public VoiceTextSttState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a();
  }
  
  public VoiceTextUIState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextStateModel.a();
  }
  
  public void a(VoiceTextUserOpListener paramVoiceTextUserOpListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextUserOpListener = paramVoiceTextUserOpListener;
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_AndroidContentContext = paramVoiceTextPanel.getContext();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextUserOpListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBaseViewHelpr
 * JD-Core Version:    0.7.0.1
 */