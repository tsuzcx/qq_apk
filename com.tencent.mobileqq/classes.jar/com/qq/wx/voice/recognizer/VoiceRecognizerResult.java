package com.qq.wx.voice.recognizer;

import java.util.List;
import org.json.JSONObject;

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
  
  public static class Word
  {
    public JSONObject semanticJsonObject = null;
    public String text = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.VoiceRecognizerResult
 * JD-Core Version:    0.7.0.1
 */