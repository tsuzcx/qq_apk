package com.qq.wx.voice.embedqqegg.recognizer;

final class b
{
  byte[] a = null;
  InnerAudioState b = InnerAudioState.stop;
  
  public b(byte[] paramArrayOfByte, InnerAudioState paramInnerAudioState)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.b
 * JD-Core Version:    0.7.0.1
 */