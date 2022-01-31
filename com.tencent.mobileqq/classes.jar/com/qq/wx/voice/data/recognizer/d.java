package com.qq.wx.voice.data.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class d
  extends Handler
{
  d(c paramc) {}
  
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
      this.a.b.onGetResult(paramMessage);
      return;
    case 400: 
      if (this.a.a != null) {
        this.a.a.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.data.recognizer.d
 * JD-Core Version:    0.7.0.1
 */