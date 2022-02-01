package com.tencent.ilink.dev.ota;

public class IlinkOtaCallbackInterface
{
  public static IlinkOtaCallback callback;
  
  public static void OnCheckupdateComplete(byte[] paramArrayOfByte)
  {
    IlinkOtaCallback localIlinkOtaCallback = callback;
    if (localIlinkOtaCallback != null) {
      localIlinkOtaCallback.OnCheckupdateComplete(paramArrayOfByte);
    }
  }
  
  public static void OnDownloadComplete(String paramString1, String paramString2)
  {
    IlinkOtaCallback localIlinkOtaCallback = callback;
    if (localIlinkOtaCallback != null) {
      localIlinkOtaCallback.OnDownloadComplete(paramString1, paramString2);
    }
  }
  
  public static void OnDownloadError(String paramString, int paramInt)
  {
    IlinkOtaCallback localIlinkOtaCallback = callback;
    if (localIlinkOtaCallback != null) {
      localIlinkOtaCallback.OnDownloadError(paramString, paramInt);
    }
  }
  
  public static void OnDownloadProgress(String paramString, double paramDouble1, double paramDouble2)
  {
    IlinkOtaCallback localIlinkOtaCallback = callback;
    if (localIlinkOtaCallback != null) {
      localIlinkOtaCallback.OnDownloadProgress(paramString, paramDouble1, paramDouble2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.dev.ota.IlinkOtaCallbackInterface
 * JD-Core Version:    0.7.0.1
 */