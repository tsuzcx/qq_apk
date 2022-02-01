package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.interfaces.IILinkCallback;
import com.tencent.ilink.interfaces.ILinkAppImInterfaceService;
import com.tencent.mars.ilink.xlog.Log;

final class aa
  implements IILinkCallback
{
  private final String a = "IlinkImManager";
  private String b = "";
  private String c = "";
  private String d = "";
  private aa.a e;
  
  public aa(String paramString, aa.a parama)
  {
    this.d = paramString;
    this.e = parama;
    ILinkAppImInterfaceService.getInstance().setILinkCallback(this);
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    return ILinkAppImInterfaceService.getInstance().updateDeviceShadow(paramArrayOfByte);
  }
  
  public void a()
  {
    if (this.b.equals("")) {
      return;
    }
    ILinkAppImInterfaceService.getInstance().uninit();
    this.b = "";
    this.c = "";
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = a.a.a(paramArrayOfByte);
      if (this.b.equals(paramArrayOfByte.c()))
      {
        Log.i("IlinkImManager", "appid match do nothing!");
        this.c = paramString;
        return;
      }
      if (this.b.equals(""))
      {
        Log.i("IlinkImManager", "im not create yet try to create one");
        ILinkAppImInterfaceService.getInstance().init(paramArrayOfByte.c(), this.d, false, false);
        this.b = paramArrayOfByte.c();
        this.c = paramString;
        return;
      }
      Log.w("IlinkImManager", "exit im appid not match with new one just recreate one");
      ILinkAppImInterfaceService.getInstance().uninit();
      ILinkAppImInterfaceService.getInstance().init(paramArrayOfByte.c(), this.d, false, false);
      this.b = paramArrayOfByte.c();
      this.c = paramString;
      return;
    }
    catch (InvalidProtocolBufferException paramString)
    {
      paramString.printStackTrace();
      Log.e("IlinkImManager", "proto parse failed!");
    }
  }
  
  public void b()
  {
    ILinkAppImInterfaceService.getInstance().uninit();
    this.b = "";
    this.c = "";
  }
  
  public void c()
  {
    if (this.b.equals(""))
    {
      Log.e("IlinkImManager", "im instance not exit!");
      return;
    }
    ILinkAppImInterfaceService.getInstance().login(30);
  }
  
  public int d()
  {
    return ILinkAppImInterfaceService.getInstance().getDeviceShadow();
  }
  
  public void onAvatarUpdate(int paramInt, String paramString) {}
  
  public void onCloseSdkAccount(int paramInt) {}
  
  public void onContactUpdate(int paramInt, String paramString, com.tencent.luggage.wxa.ar.a.a parama) {}
  
  public void onContactVerifyRequestUpdate(String paramString, byte[] paramArrayOfByte) {}
  
  public void onContactsCleared() {}
  
  public void onCreateRoom(int paramInt, long paramLong, String paramString) {}
  
  public void onDeviceShadowUpdate(byte[] paramArrayOfByte)
  {
    Log.d("IlinkImManager", "im session onDeviceShadowUpdate");
    Object localObject = a.e.g().a(this.b).a(ByteString.copyFrom(paramArrayOfByte)).c();
    paramArrayOfByte = this.e;
    String str = this.c;
    localObject = ((a.e)localObject).toByteArray();
    paramArrayOfByte.addImCallbackTask(str, "OnCommonFunctionCallback", new Class[] { String.class, [B.class }, new Object[] { "onDeviceShadowUpdate", localObject });
  }
  
  public void onGetDeviceShadow(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Log.d("IlinkImManager", "im session onGetDeviceShadow");
    Object localObject = a.f.k().a(this.b).a(paramInt1).b(paramInt2).a(ByteString.copyFrom(paramArrayOfByte)).c();
    paramArrayOfByte = this.e;
    String str = this.c;
    localObject = ((a.f)localObject).toByteArray();
    paramArrayOfByte.addImCallbackTask(str, "OnCommonFunctionCallback", new Class[] { String.class, [B.class }, new Object[] { "onGetDeviceShadow", localObject });
  }
  
  public void onGetPublicAccountQrCode(int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void onGetThingTicket(int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void onHandleContactVerifyRequestComplete(String paramString, int paramInt) {}
  
  public void onHangupVoipComplete(int paramInt, String paramString) {}
  
  public void onInitContacts(int paramInt) {}
  
  public void onInitContactsComplete(int paramInt) {}
  
  public void onInviteVoipComplete(int paramInt, String paramString1, String paramString2) {}
  
  public void onLoginComplete(int paramInt)
  {
    Log.i("IlinkImManager", "im session onLoginComplete");
    Object localObject = a.g.g().a(this.b).a(paramInt).c();
    aa.a locala = this.e;
    String str = this.c;
    localObject = ((a.g)localObject).toByteArray();
    locala.addImCallbackTask(str, "OnCommonFunctionCallback", new Class[] { String.class, [B.class }, new Object[] { "onImLoginComplete", localObject });
  }
  
  public void onLogoutComplete(int paramInt) {}
  
  public void onNetStatusChanged(int paramInt) {}
  
  public void onNicknameUpdate(int paramInt, String paramString) {}
  
  public void onReceiveCertainMessage(int paramInt, byte[] paramArrayOfByte) {}
  
  public void onReceiveILinkThirdNotify(int paramInt, String paramString) {}
  
  public void onReceiveILinkVoipNotify(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt) {}
  
  public void onReceiveMessage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void onReportDataWithCacheKey(int paramInt) {}
  
  public void onSendMsgResult(int paramInt, String paramString) {}
  
  public void onThingTicketAndQrCodeTimeout() {}
  
  public void onUpdateContactAlias(int paramInt, String paramString1, String paramString2) {}
  
  public void onUpdateDeviceShadow(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Log.d("IlinkImManager", "im session onUpdateDeviceShadow");
    Object localObject = a.h.k().a(this.b).a(paramInt1).b(paramInt2).a(ByteString.copyFrom(paramArrayOfByte)).c();
    paramArrayOfByte = this.e;
    String str = this.c;
    localObject = ((a.h)localObject).toByteArray();
    paramArrayOfByte.addImCallbackTask(str, "OnCommonFunctionCallback", new Class[] { String.class, [B.class }, new Object[] { "onUpdateDeviceShadow", localObject });
  }
  
  public void onVoipHanguped(String paramString1, String paramString2, String paramString3, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.aa
 * JD-Core Version:    0.7.0.1
 */