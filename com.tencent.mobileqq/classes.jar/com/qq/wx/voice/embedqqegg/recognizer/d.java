package com.qq.wx.voice.embedqqegg.recognizer;

import android.os.Handler;
import com.qq.wx.voice.embedqqegg.util.LogTool;

final class d
{
  c a = null;
  VoiceRecognizerListener b = null;
  private boolean c = false;
  private Handler d = new e(this);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.d
 * JD-Core Version:    0.7.0.1
 */