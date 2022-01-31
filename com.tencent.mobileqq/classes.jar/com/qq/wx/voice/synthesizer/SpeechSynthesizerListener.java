package com.qq.wx.voice.synthesizer;

public abstract interface SpeechSynthesizerListener
{
  public abstract void onGetError(int paramInt);
  
  public abstract void onGetResult(SpeechSynthesizerResult paramSpeechSynthesizerResult);
  
  public abstract void onGetVoiceRecordState(SpeechSynthesizerState paramSpeechSynthesizerState);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.SpeechSynthesizerListener
 * JD-Core Version:    0.7.0.1
 */