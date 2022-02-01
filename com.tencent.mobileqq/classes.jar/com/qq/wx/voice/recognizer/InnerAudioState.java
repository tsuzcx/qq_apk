package com.qq.wx.voice.recognizer;

public enum InnerAudioState
{
  static
  {
    end = new InnerAudioState("end", 2);
    stop = new InnerAudioState("stop", 3);
    cancel = new InnerAudioState("cancel", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.InnerAudioState
 * JD-Core Version:    0.7.0.1
 */