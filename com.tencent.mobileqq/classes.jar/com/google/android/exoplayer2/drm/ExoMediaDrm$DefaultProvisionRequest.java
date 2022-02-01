package com.google.android.exoplayer2.drm;

public final class ExoMediaDrm$DefaultProvisionRequest
  implements ExoMediaDrm.ProvisionRequest
{
  private final byte[] data;
  private final String defaultUrl;
  
  public ExoMediaDrm$DefaultProvisionRequest(byte[] paramArrayOfByte, String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm.DefaultProvisionRequest
 * JD-Core Version:    0.7.0.1
 */