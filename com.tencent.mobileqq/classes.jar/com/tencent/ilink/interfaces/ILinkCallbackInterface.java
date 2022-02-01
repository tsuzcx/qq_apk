package com.tencent.ilink.interfaces;

import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.luggage.wxa.ar.a.a;
import java.nio.charset.StandardCharsets;

class ILinkCallbackInterface
{
  private static final String TAG = "ILinkCallbackInterface";
  
  static void onAvatarUpdate(int paramInt, String paramString)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onAvatarUpdate(paramInt, paramString);
    }
  }
  
  static void onCloseSdkAccount(int paramInt)
  {
    Log.d("ILinkCallbackInterface", "onCloseSdkAccount");
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onCloseSdkAccount(paramInt);
    }
  }
  
  static void onContactUpdate(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = a.a.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (localIILinkCallback != null) {
          localIILinkCallback.onContactUpdate(paramInt, paramString, paramArrayOfByte);
        }
      }
      else
      {
        Log.e("ILinkCallbackInterface", "onContactUpdate contact is null!");
        return;
      }
    }
    catch (InvalidProtocolBufferException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  static void onContactVerifyRequestUpdate(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onContactVerifyRequestUpdate profileLocal");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
      localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
      if (localObject != null) {
        ((IILinkCallback)localObject).onContactVerifyRequestUpdate(paramString, paramArrayOfByte);
      }
    }
    else
    {
      Log.e("ILinkCallbackInterface", "onContactVerifyRequestUpdate profile is null !");
    }
  }
  
  static void onContactsCleared()
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onContactsCleared();
    }
  }
  
  static void onCreateRoom(int paramInt, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateRoom errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" roomId:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("  groupid: ");
    ((StringBuilder)localObject).append("123");
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onCreateRoom(paramInt, paramLong, "123");
    }
  }
  
  static void onCreateRoom(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateRoom errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" roomId:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("  groupid: ");
    ((StringBuilder)localObject).append(paramString);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onCreateRoom(paramInt, paramLong, paramString);
    }
  }
  
  static void onDeviceShadowUpdate(byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDeviceShadowUpdate");
    ((StringBuilder)localObject).append(new String(paramArrayOfByte, StandardCharsets.UTF_8));
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onDeviceShadowUpdate(paramArrayOfByte);
    }
  }
  
  static void onGetDeviceShadow(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetDeviceShadow");
    ((StringBuilder)localObject).append(new String(paramArrayOfByte, StandardCharsets.UTF_8));
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onGetDeviceShadow(paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  static void onGetPublicAccountQrCode(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetPublicAccountQrCode  errCode = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" qrcodePath:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" expireTime:");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onGetPublicAccountQrCode(paramInt1, paramString, paramInt2, paramInt3);
    }
  }
  
  static void onGetThingTicket(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetThingTicket  errCode = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" thingTicket:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" expireTime:");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onGetThingTicket(paramInt1, paramString, paramInt2, paramInt3);
    }
  }
  
  static void onHandleContactVerifyRequestComplete(String paramString, int paramInt)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onHandleContactVerifyRequestComplete(paramString, paramInt);
    }
  }
  
  static void onHangupVoipComplete(int paramInt, String paramString) {}
  
  static void onInitContacts(int paramInt)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onInitContacts(paramInt);
    }
  }
  
  static void onInitContactsComplete(int paramInt)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onInitContactsComplete(paramInt);
    }
  }
  
  static void onInviteVoipComplete(int paramInt, String paramString1, String paramString2) {}
  
  static void onLoginComplete(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoginComplete errCode:");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    ILinkAppImInterfaceService.getInstance().cancelInterfaceTimer();
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onLoginComplete(paramInt);
    }
  }
  
  static void onLogoutComplete(int paramInt)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onLogoutComplete(paramInt);
    }
  }
  
  static void onNetStatusChanged(int paramInt)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onNetStatusChanged(paramInt);
    }
  }
  
  static void onNicknameUpdate(int paramInt, String paramString)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onNicknameUpdate(paramInt, paramString);
    }
  }
  
  static void onReceiveCertainMessage(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveCertainMessage cmdid:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" message=");
    ((StringBuilder)localObject).append(paramArrayOfByte);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onReceiveCertainMessage(paramInt, paramArrayOfByte);
    }
  }
  
  static void onReceiveILinkThirdNotify(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveILinkThirdNotify  cmdid = ");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onReceiveILinkThirdNotify(paramInt, paramString);
    }
  }
  
  static void onReceiveILinkVoipNotify(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveILinkVoipNotify  roomId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" groupId = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" fromIlinkId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" fromOpenid ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" callType:");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onReceiveILinkVoipNotify(paramLong, paramString1, paramString2, paramString3, paramBoolean, paramInt);
    }
  }
  
  static void onReceiveMessage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveMessage fromIlinkId:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" content:");
    ((StringBuilder)localObject).append(paramString4);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onReceiveMessage(paramString1, paramString2, paramString3, paramString4, paramInt);
    }
  }
  
  static void onReportDataWithCacheKey(int paramInt)
  {
    Log.d("ILinkCallbackInterface", "onReportDataWithCacheKey");
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onReportDataWithCacheKey(paramInt);
    }
  }
  
  static void onSendMsgResult(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSendMsgResult errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msgid=");
    ((StringBuilder)localObject).append(paramString);
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onSendMsgResult(paramInt, paramString);
    }
  }
  
  static void onThingTicketAndQrCodeTimeout()
  {
    Log.d("ILinkCallbackInterface", "onThingTicketAndQrCodeTimeout");
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onThingTicketAndQrCodeTimeout();
    }
  }
  
  static void onUpdateContactAlias(int paramInt, String paramString1, String paramString2)
  {
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onUpdateContactAlias(paramInt, paramString1, paramString2);
    }
  }
  
  static void onUpdateDeviceShadow(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateDeviceShadow");
    ((StringBuilder)localObject).append(new String(paramArrayOfByte, StandardCharsets.UTF_8));
    Log.d("ILinkCallbackInterface", ((StringBuilder)localObject).toString());
    localObject = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localObject != null) {
      ((IILinkCallback)localObject).onUpdateDeviceShadow(paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  static void onVoipHanguped(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Log.d("ILinkCallbackInterface", "onVoipHanguped");
    IILinkCallback localIILinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
    if (localIILinkCallback != null) {
      localIILinkCallback.onVoipHanguped(paramString1, paramString2, paramString3, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.interfaces.ILinkCallbackInterface
 * JD-Core Version:    0.7.0.1
 */