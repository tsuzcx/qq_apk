package com.qq.wx.voice.recognizer;

public enum VoiceRecordState
{
  static
  {
    Recording = new VoiceRecordState("Recording", 1);
    Complete = new VoiceRecordState("Complete", 2);
    Canceling = new VoiceRecordState("Canceling", 3);
    Canceled = new VoiceRecordState("Canceled", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.VoiceRecordState
 * JD-Core Version:    0.7.0.1
 */