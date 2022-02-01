package com.tencent.ilink.interfaces;

import java.util.ArrayList;

public class ILinkAppImInterface
{
  public static native void cancelLogin();
  
  public static native void closeSdkAccount();
  
  public static native void deleteContactByIlinkimId(String paramString);
  
  public static native ArrayList<byte[]> getAllContacts();
  
  public static native ArrayList<byte[]> getAllUnVerifyRequests();
  
  public static native byte[] getContactByIlinkimId(String paramString);
  
  public static native int getDeviceShadow();
  
  public static native void getImTicket(int paramInt);
  
  public static native byte[] getProfile();
  
  public static native void getPublicAccountQrCode(int paramInt);
  
  public static native long getUin();
  
  public static native void handleContactVerifyRequest(String paramString, boolean paramBoolean);
  
  public static native void init(String paramString1, String paramString2, boolean paramBoolean);
  
  public static native void initContacts();
  
  public static native void login();
  
  public static native void logout(boolean paramBoolean);
  
  public static native void reportDataWithCacheKey(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public static native String sendImageMessage(String paramString, byte[] paramArrayOfByte);
  
  public static native String sendIotMessage(String paramString1, String paramString2, String paramString3);
  
  public static native String sendTextMessage(String paramString1, String paramString2);
  
  public static native String sendVideoMessage(String paramString, byte[] paramArrayOfByte);
  
  public static native void setVoipAppid(String paramString);
  
  public static native void startAutoSync(int paramInt);
  
  public static native void uninit();
  
  public static native void updateAvatar(String paramString);
  
  public static native void updateContactAlias(String paramString1, String paramString2);
  
  public static native int updateDeviceShadow(byte[] paramArrayOfByte);
  
  public static native void updateNickname(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.interfaces.ILinkAppImInterface
 * JD-Core Version:    0.7.0.1
 */