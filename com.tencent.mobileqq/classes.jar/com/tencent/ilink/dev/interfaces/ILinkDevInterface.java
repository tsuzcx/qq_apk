package com.tencent.ilink.dev.interfaces;

public class ILinkDevInterface
{
  public static native String getIlinkId();
  
  public static native String getToken();
  
  public static native void init(byte[] paramArrayOfByte, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public static native void initLog(String paramString, int paramInt);
  
  public static native void login();
  
  public static native String sendIotMessage(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native int startUploadLog(byte[] paramArrayOfByte);
  
  public static native void stopUploadLog();
  
  public static native void uninit();
  
  public static native void uninitLog();
  
  public static native void updateDeviceParams(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.dev.interfaces.ILinkDevInterface
 * JD-Core Version:    0.7.0.1
 */