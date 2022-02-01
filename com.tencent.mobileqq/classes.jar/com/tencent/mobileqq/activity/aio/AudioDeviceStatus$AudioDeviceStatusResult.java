package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper.AudioPlayerParameter;

public class AudioDeviceStatus$AudioDeviceStatusResult
{
  int jdField_a_of_type_Int;
  AudioPlayerHelper.AudioPlayerParameter jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
  volatile boolean jdField_a_of_type_Boolean;
  
  public AudioDeviceStatus$AudioDeviceStatusResult(AudioPlayerHelper.AudioPlayerParameter paramAudioPlayerParameter, int paramInt)
  {
    this(paramAudioPlayerParameter, paramInt, false);
  }
  
  public AudioDeviceStatus$AudioDeviceStatusResult(AudioPlayerHelper.AudioPlayerParameter paramAudioPlayerParameter, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = paramAudioPlayerParameter;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AudioPlayerHelper.AudioPlayerParameter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(AudioDeviceStatusResult paramAudioDeviceStatusResult)
  {
    if ((paramAudioDeviceStatusResult == null) || (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter == null)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.equals(paramAudioDeviceStatusResult.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioDeviceStatus.AudioDeviceStatusResult
 * JD-Core Version:    0.7.0.1
 */