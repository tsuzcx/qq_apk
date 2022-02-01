package com.google.android.exoplayer2.drm;

public final class ExoMediaDrm$DefaultKeyStatus
  implements ExoMediaDrm.KeyStatus
{
  private final byte[] keyId;
  private final int statusCode;
  
  ExoMediaDrm$DefaultKeyStatus(int paramInt, byte[] paramArrayOfByte)
  {
    this.statusCode = paramInt;
    this.keyId = paramArrayOfByte;
  }
  
  public byte[] getKeyId()
  {
    return this.keyId;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm.DefaultKeyStatus
 * JD-Core Version:    0.7.0.1
 */