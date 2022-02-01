package com.qq.wx.voice.embedqqegg.recognizer;

public class VoiceRecognizerResult
{
  public boolean isEnd = false;
  public boolean isHalf = false;
  public String text = new String();
  public byte[] voiceRecordPCMData = null;
  
  VoiceRecognizerResult(boolean paramBoolean)
  {
    this.isEnd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerResult
 * JD-Core Version:    0.7.0.1
 */