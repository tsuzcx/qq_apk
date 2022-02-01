package com.tencent.ilinkservice;

import android.os.IInterface;

public abstract interface IIlinkServiceCallback
  extends IInterface
{
  public abstract void OnCommonFunctionCallback(String paramString, byte[] paramArrayOfByte);
  
  public abstract void OnRequestUploadLogfiles(String paramString, byte[] paramArrayOfByte);
  
  public abstract void onAppSessionTimeout(String paramString);
  
  public abstract void onCancelOAuthComplete(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onCheckLoginQrCode(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onCloneMultiProcessTdiSession(int paramInt, String paramString);
  
  public abstract void onDestroyMultiProcessTdiSession(String paramString);
  
  public abstract void onFaceExtVerifyComplete(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onFaceRecognizeComplete(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onFaceRecognizeConfigComplete(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onFinishGetStrategy();
  
  public abstract void onGetAppPushTokenComplete(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onGetLoginQrCodeComplete(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onGetOAuthCodeComplete(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onLoginComplete(int paramInt, byte[] paramArrayOfByte, String paramString);
  
  public abstract void onLogoutComplete(String paramString, int paramInt);
  
  public abstract void onNetStatusChanged(int paramInt);
  
  public abstract void onNewGetAppPushTokenComplete(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onNewLoginComplete(int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString);
  
  public abstract void onReceiveAppMessage(String paramString, byte[] paramArrayOfByte);
  
  public abstract void onReceiveAppResponse(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onReceiveMessage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract void onReceiveMultiProcessCloneTicket(int paramInt, String paramString1, String paramString2);
  
  public abstract void onSendMsgResult(int paramInt, String paramString);
  
  public abstract void onTdiLoginComplete(String paramString, int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IIlinkServiceCallback
 * JD-Core Version:    0.7.0.1
 */