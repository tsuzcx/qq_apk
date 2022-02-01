package com.qq.wx.voice.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qq.wx.voice.util.LogTool;

final class d
{
  b a = null;
  VoiceRecognizerListener b = null;
  private boolean c = false;
  private Handler d = new e(this);
  
  protected final void a()
  {
    this.c = false;
  }
  
  protected final void a(int paramInt)
  {
    Handler localHandler = this.d;
    localHandler.sendMessage(localHandler.obtainMessage(200, Integer.valueOf(paramInt)));
  }
  
  protected final void a(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    Handler localHandler = this.d;
    localHandler.sendMessage(localHandler.obtainMessage(300, paramVoiceRecognizerResult));
  }
  
  protected final void a(VoiceRecordState paramVoiceRecordState)
  {
    Object localObject = this.d;
    ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(100, paramVoiceRecordState));
    localObject = new StringBuilder("voice record state = ");
    ((StringBuilder)localObject).append(paramVoiceRecordState);
    LogTool.d(((StringBuilder)localObject).toString());
  }
  
  protected final void a(byte[] paramArrayOfByte, String paramString)
  {
    Message localMessage = this.d.obtainMessage(500);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("pack", paramArrayOfByte);
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  protected final void b(int paramInt)
  {
    if (!this.c)
    {
      localObject = this.d;
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(400, Integer.valueOf(paramInt)));
      this.c = true;
    }
    Object localObject = new StringBuilder("isError = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" errorCode = ");
    ((StringBuilder)localObject).append(paramInt);
    LogTool.d(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.d
 * JD-Core Version:    0.7.0.1
 */