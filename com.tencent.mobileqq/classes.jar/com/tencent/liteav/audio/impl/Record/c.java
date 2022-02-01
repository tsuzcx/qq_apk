package com.tencent.liteav.audio.impl.Record;

public abstract interface c
{
  public abstract void onAudioRecordError(int paramInt, String paramString);
  
  public abstract void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  public abstract void onAudioRecordStart();
  
  public abstract void onAudioRecordStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.c
 * JD-Core Version:    0.7.0.1
 */