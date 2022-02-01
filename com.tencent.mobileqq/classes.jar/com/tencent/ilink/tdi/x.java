package com.tencent.ilink.tdi;

public abstract interface x
{
  public abstract void onAppSessionTimeout();
  
  public abstract void onCancelOAuthComplete(int paramInt1, int paramInt2);
  
  public abstract void onCheckLoginQrCodeComplete(int paramInt, b.g paramg);
  
  public abstract void onFaceExtVerifyComplete(int paramInt, b.j paramj);
  
  public abstract void onFaceRecognizeComplete(int paramInt, b.n paramn);
  
  public abstract void onFaceRecognizeConfigComplete(int paramInt, b.l paraml);
  
  public abstract void onGetAppPushTokenComplete(int paramInt1, int paramInt2, b.b paramb);
  
  public abstract void onGetLoginQrCodeComplete(int paramInt, b.p paramp);
  
  public abstract void onGetOAuthCodeComplete(int paramInt1, int paramInt2, b.r paramr);
  
  public abstract void onLoginComplete(int paramInt, b.v paramv);
  
  public abstract void onLogoutComplete(int paramInt);
  
  public abstract void onReceiveAppMessage(b.a parama);
  
  public abstract void onReceiveAppResponse(int paramInt1, int paramInt2, b.d paramd);
  
  public abstract void onRequestUploadLogfiles(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.x
 * JD-Core Version:    0.7.0.1
 */