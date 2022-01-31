package com.qq.wx.voice.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class e
  extends Handler
{
  e(d paramd) {}
  
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
      paramMessage = (VoiceRecordState)paramMessage.obj;
      this.a.b.onGetVoiceRecordState(paramMessage);
      return;
    case 200: 
      paramMessage = (Integer)paramMessage.obj;
      this.a.b.onVolumeChanged(paramMessage.intValue());
      return;
    case 300: 
      paramMessage = (VoiceRecognizerResult)paramMessage.obj;
      if ((this.a.a != null) && (!InfoRecognizer.f) && (paramMessage.isEnd)) {
        this.a.a.b();
      }
      this.a.b.onGetResult(paramMessage);
      return;
    case 400: 
      if (this.a.a != null) {
        this.a.a.c();
      }
      paramMessage = (Integer)paramMessage.obj;
      this.a.b.onGetError(paramMessage.intValue());
      return;
    }
    Object localObject = paramMessage.getData();
    paramMessage = ((Bundle)localObject).getByteArray("pack");
    localObject = ((Bundle)localObject).getString("url");
    this.a.b.onGetVoicePackage(paramMessage, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.e
 * JD-Core Version:    0.7.0.1
 */