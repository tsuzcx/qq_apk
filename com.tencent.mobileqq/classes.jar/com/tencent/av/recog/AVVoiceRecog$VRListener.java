package com.tencent.av.recog;

import android.text.TextUtils;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizer;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecordState;
import com.tencent.qphone.base.util.QLog;

class AVVoiceRecog$VRListener
  implements VoiceRecognizerListener
{
  AVVoiceRecog$VRListener(AVVoiceRecog paramAVVoiceRecog) {}
  
  public void onGetError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetError. err = ");
    localStringBuilder.append(paramInt);
    QLog.d("AVVoiceRecog", 2, localStringBuilder.toString());
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if ((AVVoiceRecog.a(this.a)) && (!AVVoiceRecog.b(this.a)))
    {
      if (paramVoiceRecognizerResult.isHalf)
      {
        QLog.i("AVVoiceRecog", 1, "onGetResult. result.isHalf.");
        return;
      }
      if (TextUtils.isEmpty(paramVoiceRecognizerResult.text))
      {
        QLog.i("AVVoiceRecog", 1, "onGetResult. result.text == null.");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetResult. result.text = ");
        localStringBuilder.append(paramVoiceRecognizerResult.text);
        QLog.i("AVVoiceRecog", 1, localStringBuilder.toString());
        if (AVVoiceRecog.c(this.a) != null) {
          AVVoiceRecog.c(this.a).a(paramVoiceRecognizerResult.text);
        }
      }
      if (paramVoiceRecognizerResult.isEnd)
      {
        int i = VoiceRecognizer.shareInstance().startReceiving();
        if (i < 0)
        {
          paramVoiceRecognizerResult = new StringBuilder();
          paramVoiceRecognizerResult.append("restart falied. ret = ");
          paramVoiceRecognizerResult.append(i);
          QLog.i("AVVoiceRecog", 1, paramVoiceRecognizerResult.toString());
        }
      }
      return;
    }
    QLog.i("AVVoiceRecog", 1, "onGetResult. discard. !mIsInitAndStart || mIsPause.");
  }
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetVoiceRecordState. state = ");
    localStringBuilder.append(paramVoiceRecordState);
    QLog.d("AVVoiceRecog", 2, localStringBuilder.toString());
  }
  
  public void onVolumeChanged(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVolumeChanged. volume = ");
      localStringBuilder.append(paramInt);
      QLog.d("AVVoiceRecog", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.recog.AVVoiceRecog.VRListener
 * JD-Core Version:    0.7.0.1
 */