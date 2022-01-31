package com.qq.wx.voice.synthesizer;

import android.os.Handler;
import android.os.Message;

final class b
  extends Handler
{
  b(SpeechSynthesizerCallback paramSpeechSynthesizerCallback) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.b == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      paramMessage = (SpeechSynthesizerState)paramMessage.obj;
      this.a.b.onGetVoiceRecordState(paramMessage);
      return;
    case 300: 
      if (this.a.a != null) {
        this.a.a.a = null;
      }
      paramMessage = (SpeechSynthesizerResult)paramMessage.obj;
      this.a.b.onGetResult(paramMessage);
      return;
    }
    if (this.a.a != null) {
      this.a.a.a();
    }
    paramMessage = (Integer)paramMessage.obj;
    this.a.b.onGetError(paramMessage.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.b
 * JD-Core Version:    0.7.0.1
 */