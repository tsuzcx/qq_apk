package com.qq.wx.voice.data.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qq.wx.voice.util.LogTool;

final class c
{
  b a = null;
  VoiceRecognizerListener b = null;
  private boolean c = false;
  private Handler d = new d(this);
  
  protected final void a()
  {
    this.c = false;
  }
  
  protected final void a(int paramInt)
  {
    this.d.sendMessage(this.d.obtainMessage(200, Integer.valueOf(paramInt)));
  }
  
  protected final void a(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    this.d.sendMessage(this.d.obtainMessage(300, paramVoiceRecognizerResult));
  }
  
  protected final void a(VoiceRecordState paramVoiceRecordState)
  {
    this.d.sendMessage(this.d.obtainMessage(100, paramVoiceRecordState));
    LogTool.d("voice record state = " + paramVoiceRecordState);
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
      this.d.sendMessage(this.d.obtainMessage(400, Integer.valueOf(paramInt)));
      this.c = true;
    }
    LogTool.d("isError = " + this.c + " errorCode = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.data.recognizer.c
 * JD-Core Version:    0.7.0.1
 */