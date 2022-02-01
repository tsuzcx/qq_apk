package com.tencent.liteav.audio;

public abstract interface g
{
  public abstract void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onRecordError(int paramInt, String paramString);
  
  public abstract void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.g
 * JD-Core Version:    0.7.0.1
 */