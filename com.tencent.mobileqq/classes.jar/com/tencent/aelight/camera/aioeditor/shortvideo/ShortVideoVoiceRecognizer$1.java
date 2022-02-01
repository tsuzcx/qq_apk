package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener;

class ShortVideoVoiceRecognizer$1
  implements VoiceTextRecognizer.VRErrorListener
{
  ShortVideoVoiceRecognizer$1(ShortVideoVoiceRecognizer paramShortVideoVoiceRecognizer) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextRecognizer error! errorCode = ");
      localStringBuilder.append(paramInt);
      QLog.e("ShortVideoVoiceRecognizer", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoVoiceRecognizer.1
 * JD-Core Version:    0.7.0.1
 */