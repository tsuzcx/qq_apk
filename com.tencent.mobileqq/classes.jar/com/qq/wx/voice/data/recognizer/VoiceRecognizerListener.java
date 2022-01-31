package com.qq.wx.voice.data.recognizer;

public abstract interface VoiceRecognizerListener
{
  public abstract void onGetError(int paramInt);
  
  public abstract void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult);
  
  public abstract void onGetVoicePackage(byte[] paramArrayOfByte, String paramString);
  
  public abstract void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState);
  
  public abstract void onVolumeChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.data.recognizer.VoiceRecognizerListener
 * JD-Core Version:    0.7.0.1
 */