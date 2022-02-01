package com.tencent.mobileqq.activity.aio.voicetextpanel.model;

public class VoiceTextStateModel
{
  private VoiceTextInfoState jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextInfoState = new VoiceTextInfoState();
  private VoiceTextSttState jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextSttState = new VoiceTextSttState();
  private VoiceTextUIState jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextUIState = new VoiceTextUIState();
  
  public VoiceTextInfoState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextInfoState;
  }
  
  public VoiceTextSttState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextSttState;
  }
  
  public VoiceTextUIState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextUIState;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextUIState.b) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextInfoState.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextSttState.f()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextInfoState.a();
    }
    return "";
  }
  
  public void a()
  {
    a().b("");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextSttState.a(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelModelVoiceTextUIState.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel
 * JD-Core Version:    0.7.0.1
 */