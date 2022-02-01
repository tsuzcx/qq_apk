package com.qq.wx.voice.synthesizer;

import android.os.Handler;
import com.qq.wx.voice.util.LogTool;

public class SpeechSynthesizerCallback
{
  a a = null;
  SpeechSynthesizerListener b = null;
  private boolean c = false;
  private Handler d = new b(this);
  
  protected final void a()
  {
    this.c = false;
  }
  
  protected final void a(int paramInt)
  {
    if (!this.c)
    {
      this.d.sendMessage(this.d.obtainMessage(200, Integer.valueOf(paramInt)));
      this.c = true;
    }
    LogTool.d("isError = " + this.c + " errorCode = " + paramInt);
  }
  
  protected final void a(SpeechSynthesizerResult paramSpeechSynthesizerResult)
  {
    this.d.sendMessage(this.d.obtainMessage(300, paramSpeechSynthesizerResult));
  }
  
  protected final void a(SpeechSynthesizerState paramSpeechSynthesizerState)
  {
    this.d.sendMessage(this.d.obtainMessage(100, paramSpeechSynthesizerState));
    LogTool.d("voice record state = " + paramSpeechSynthesizerState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.SpeechSynthesizerCallback
 * JD-Core Version:    0.7.0.1
 */