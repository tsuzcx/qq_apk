package com.tencent.ilink.dev.ota;

public abstract interface IlinkOtaCallback
{
  public abstract void OnCheckupdateComplete(byte[] paramArrayOfByte);
  
  public abstract void OnDownloadComplete(String paramString1, String paramString2);
  
  public abstract void OnDownloadError(String paramString, int paramInt);
  
  public abstract void OnDownloadProgress(String paramString, double paramDouble1, double paramDouble2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.dev.ota.IlinkOtaCallback
 * JD-Core Version:    0.7.0.1
 */