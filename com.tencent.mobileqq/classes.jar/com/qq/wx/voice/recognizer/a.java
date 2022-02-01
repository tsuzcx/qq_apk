package com.qq.wx.voice.recognizer;

final class a
{
  byte[] a;
  InnerAudioState b;
  int c;
  
  public a(byte[] paramArrayOfByte, InnerAudioState paramInnerAudioState)
  {
    Object localObject = null;
    this.a = null;
    this.b = InnerAudioState.stop;
    this.c = 16000;
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
 * Qualified Name:     com.qq.wx.voice.recognizer.a
 * JD-Core Version:    0.7.0.1
 */