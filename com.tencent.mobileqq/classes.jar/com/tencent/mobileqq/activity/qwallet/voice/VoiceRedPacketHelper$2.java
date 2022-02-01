package com.tencent.mobileqq.activity.qwallet.voice;

import com.tencent.av.ui.funchat.record.AudioFileDecoder.Callback;
import com.tencent.qphone.base.util.QLog;

class VoiceRedPacketHelper$2
  implements AudioFileDecoder.Callback
{
  VoiceRedPacketHelper$2(VoiceRedPacketHelper paramVoiceRedPacketHelper) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VoiceRedPacketHelper", 1, "convertMp3ToPcm onError " + paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VoiceRedPacketHelper", 1, "convertMp3ToPcm onStart " + paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VoiceRedPacketHelper", 1, "convertMp3ToPcm onFinish " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.2
 * JD-Core Version:    0.7.0.1
 */