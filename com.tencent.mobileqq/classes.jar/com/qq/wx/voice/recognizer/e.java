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
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i != 200)
      {
        if (i != 300)
        {
          if (i != 400)
          {
            if (i != 500) {
              return;
            }
            Object localObject = paramMessage.getData();
            paramMessage = ((Bundle)localObject).getByteArray("pack");
            localObject = ((Bundle)localObject).getString("url");
            this.a.b.onGetVoicePackage(paramMessage, (String)localObject);
            return;
          }
          if (this.a.a != null) {
            this.a.a.c();
          }
          paramMessage = (Integer)paramMessage.obj;
          this.a.b.onGetError(paramMessage.intValue());
          return;
        }
        paramMessage = (VoiceRecognizerResult)paramMessage.obj;
        if ((this.a.a != null) && (!InfoRecognizer.f) && (paramMessage.isEnd)) {
          this.a.a.b();
        }
        this.a.b.onGetResult(paramMessage);
        return;
      }
      paramMessage = (Integer)paramMessage.obj;
      this.a.b.onVolumeChanged(paramMessage.intValue());
      return;
    }
    paramMessage = (VoiceRecordState)paramMessage.obj;
    this.a.b.onGetVoiceRecordState(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.e
 * JD-Core Version:    0.7.0.1
 */