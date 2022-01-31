package com.qq.wx.voice.recognizer;

final class a
{
  byte[] a = null;
  InnerAudioState b = InnerAudioState.stop;
  int c = 0;
  
  public a(byte[] paramArrayOfByte, InnerAudioState paramInnerAudioState)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = localObject;; paramArrayOfByte = (byte[])paramArrayOfByte.clone())
    {
      this.a = paramArrayOfByte;
      this.b = paramInnerAudioState;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.a
 * JD-Core Version:    0.7.0.1
 */