package com.tencent.ilink.interfaces;

import com.tencent.luggage.wxa.ar.a.a;

public abstract interface IILinkCallback
{
  public abstract void onAvatarUpdate(int paramInt, String paramString);
  
  public abstract void onCloseSdkAccount(int paramInt);
  
  public abstract void onContactUpdate(int paramInt, String paramString, a.a parama);
  
  public abstract void onContactVerifyRequestUpdate(String paramString, byte[] paramArrayOfByte);
  
  public abstract void onContactsCleared();
  
  public abstract void onCreateRoom(int paramInt, long paramLong, String paramString);
  
  public abstract void onDeviceShadowUpdate(byte[] paramArrayOfByte);
  
  public abstract void onGetDeviceShadow(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onGetPublicAccountQrCode(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract void onGetThingTicket(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract void onHandleContactVerifyRequestComplete(String paramString, int paramInt);
  
  public abstract void onHangupVoipComplete(int paramInt, String paramString);
  
  public abstract void onInitContacts(int paramInt);
  
  public abstract void onInitContactsComplete(int paramInt);
  
  public abstract void onInviteVoipComplete(int paramInt, String paramString1, String paramString2);
  
  public abstract void onLoginComplete(int paramInt);
  
  public abstract void onLogoutComplete(int paramInt);
  
  public abstract void onNetStatusChanged(int paramInt);
  
  public abstract void onNicknameUpdate(int paramInt, String paramString);
  
  public abstract void onReceiveCertainMessage(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void onReceiveILinkThirdNotify(int paramInt, String paramString);
  
  public abstract void onReceiveILinkVoipNotify(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt);
  
  public abstract void onReceiveMessage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract void onReportDataWithCacheKey(int paramInt);
  
  public abstract void onSendMsgResult(int paramInt, String paramString);
  
  public abstract void onThingTicketAndQrCodeTimeout();
  
  public abstract void onUpdateContactAlias(int paramInt, String paramString1, String paramString2);
  
  public abstract void onUpdateDeviceShadow(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void onVoipHanguped(String paramString1, String paramString2, String paramString3, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.interfaces.IILinkCallback
 * JD-Core Version:    0.7.0.1
 */