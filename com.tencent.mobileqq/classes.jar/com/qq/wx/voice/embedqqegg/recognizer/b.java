package com.qq.wx.voice.embedqqegg.recognizer;

final class b
{
  byte[] a;
  InnerAudioState b;
  
  public b(byte[] paramArrayOfByte, InnerAudioState paramInnerAudioState)
  {
    Object localObject = null;
    this.a = null;
    this.b = InnerAudioState.stop;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = localObject;
    } else {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    }
    this.a = paramArrayOfByte;
    this.b = paramInnerAudioState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.b
 * JD-Core Version:    0.7.0.1
 */