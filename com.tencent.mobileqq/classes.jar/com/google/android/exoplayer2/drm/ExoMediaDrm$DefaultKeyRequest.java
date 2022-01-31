package com.google.android.exoplayer2.drm;

public final class ExoMediaDrm$DefaultKeyRequest
  implements ExoMediaDrm.KeyRequest
{
  private final byte[] data;
  private final String defaultUrl;
  
  public ExoMediaDrm$DefaultKeyRequest(byte[] paramArrayOfByte, String paramString)
  {
    this.data = paramArrayOfByte;
    this.defaultUrl = paramString;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public String getDefaultUrl()
  {
    return this.defaultUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm.DefaultKeyRequest
 * JD-Core Version:    0.7.0.1
 */