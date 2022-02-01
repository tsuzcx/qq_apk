package com.tencent.mobileqq.activity;

import android.hardware.SensorManager;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;

class ChatHistory$25
  implements AudioPlayerBase.AudioPlayerListener
{
  ChatHistory$25(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.d();
    }
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.a.b(2131694926);
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.25
 * JD-Core Version:    0.7.0.1
 */