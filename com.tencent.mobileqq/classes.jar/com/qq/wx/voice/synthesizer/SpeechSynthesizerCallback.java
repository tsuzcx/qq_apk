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
      localObject = this.d;
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(200, Integer.valueOf(paramInt)));
      this.c = true;
    }
    Object localObject = new StringBuilder("isError = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" errorCode = ");
    ((StringBuilder)localObject).append(paramInt);
    LogTool.d(((StringBuilder)localObject).toString());
  }
  
  protected final void a(SpeechSynthesizerResult paramSpeechSynthesizerResult)
  {
    Handler localHandler = this.d;
    localHandler.sendMessage(localHandler.obtainMessage(300, paramSpeechSynthesizerResult));
  }
  
  protected final void a(SpeechSynthesizerState paramSpeechSynthesizerState)
  {
    Object localObject = this.d;
    ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(100, paramSpeechSynthesizerState));
    localObject = new StringBuilder("voice record state = ");
    ((StringBuilder)localObject).append(paramSpeechSynthesizerState);
    LogTool.d(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.SpeechSynthesizerCallback
 * JD-Core Version:    0.7.0.1
 */