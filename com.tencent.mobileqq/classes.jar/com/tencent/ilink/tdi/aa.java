package com.tencent.ilink.tdi;

public class aa
  implements z
{
  private long a;
  
  public aa(long paramLong)
  {
    this.a = paramLong;
  }
  
  public int a(b.c paramc)
  {
    return TdiInterfaceAdapter.sendAppRequest(this.a, paramc.toByteArray());
  }
  
  public int a(b.e parame)
  {
    return TdiInterfaceAdapter.cancelOAuth(this.a, parame.toByteArray());
  }
  
  public int a(b.q paramq)
  {
    return TdiInterfaceAdapter.getOAuthCode(this.a, paramq.toByteArray());
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    return TdiInterfaceAdapter.getAppPushToken(this.a, paramArrayOfByte);
  }
  
  public void a()
  {
    TdiInterfaceAdapter.uninit(this.a);
  }
  
  public void a(int paramInt)
  {
    TdiInterfaceAdapter.cancelAppRequest(this.a, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TdiInterfaceAdapter.requestUploadLogfiles(this.a, paramInt1, paramInt2);
  }
  
  public void a(b.f paramf)
  {
    TdiInterfaceAdapter.cancel(this.a, paramf.getNumber());
  }
  
  public void a(b.i parami)
  {
    TdiInterfaceAdapter.faceExtVerify(this.a, parami.toByteArray());
  }
  
  public void a(b.k paramk)
  {
    TdiInterfaceAdapter.faceRecognizeConfig(this.a, paramk.toByteArray());
  }
  
  public void a(b.m paramm)
  {
    TdiInterfaceAdapter.faceRecognize(this.a, paramm.toByteArray());
  }
  
  public void a(b.o paramo)
  {
    TdiInterfaceAdapter.getLoginQrCode(this.a, paramo.toByteArray());
  }
  
  public void a(b.s params)
  {
    TdiInterfaceAdapter.init(this.a, params.toByteArray());
  }
  
  public void a(b.u paramu)
  {
    TdiInterfaceAdapter.faceLogin(this.a, paramu.toByteArray());
  }
  
  public void a(x paramx)
  {
    TdiCallbackAdapter.setCallback(this.a, paramx);
  }
  
  public void b()
  {
    TdiInterfaceAdapter.logout(this.a);
  }
  
  public void b(int paramInt)
  {
    TdiInterfaceAdapter.cancelRequest(this.a, paramInt);
  }
  
  public void b(b.u paramu)
  {
    TdiInterfaceAdapter.qrCodeLogin(this.a, paramu.toByteArray());
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    TdiInterfaceAdapter.writeKvData(this.a, paramArrayOfByte);
  }
  
  public b.z c()
  {
    try
    {
      b.z localz = b.z.a(TdiInterfaceAdapter.getUserInfo(this.a));
      return localz;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void c(int paramInt)
  {
    TdiInterfaceAdapter.setSmcUin(this.a, paramInt);
  }
  
  public void c(b.u paramu)
  {
    TdiInterfaceAdapter.oauthLogin(this.a, paramu.toByteArray());
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    TdiInterfaceAdapter.setSmcBaseInfo(this.a, paramArrayOfByte);
  }
  
  public void d()
  {
    TdiInterfaceAdapter.autoLogin(this.a);
  }
  
  public void d(b.u paramu)
  {
    TdiInterfaceAdapter.thirdAppLogin(this.a, paramu.toByteArray());
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    TdiInterfaceAdapter.updateIlinkToken(this.a, paramArrayOfByte);
  }
  
  public void e()
  {
    TdiInterfaceAdapter.checkLoginQrCode(this.a);
  }
  
  public void e(b.u paramu)
  {
    TdiInterfaceAdapter.visitorLogin(this.a, paramu.toByteArray());
  }
  
  public long f()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.aa
 * JD-Core Version:    0.7.0.1
 */