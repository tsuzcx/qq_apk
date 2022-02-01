package com.qq.wx.voice.recognizer;

import java.util.List;

public class VoiceRecognizerResult
{
  public byte[] httpRes = null;
  public boolean isAllEnd = false;
  public boolean isEnd = false;
  public double startTime = 0.0D;
  public double stopTime = 0.0D;
  public String text = new String();
  public int type = 0;
  public byte[] voiceRecordPCMData = null;
  public byte[] voiceSpeexData = null;
  public List words = null;
  
  VoiceRecognizerResult(boolean paramBoolean)
  {
    this.isEnd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.VoiceRecognizerResult
 * JD-Core Version:    0.7.0.1
 */