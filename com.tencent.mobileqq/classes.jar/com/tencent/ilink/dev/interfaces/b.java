package com.tencent.ilink.dev.interfaces;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class b
{
  public static final int a = ILinkDevInterface.a.a.a();
  public static final int b = ILinkDevInterface.a.b.a();
  public static final int c = ILinkDevInterface.a.c.a();
  public static final int d = ILinkDevInterface.a.d.a();
  private static b f;
  public a e;
  private Timer g;
  private TimerTask h;
  
  public static b a()
  {
    if (f == null) {
      f = new b();
    }
    return f;
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return ILinkDevInterface.sendIotMessage(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(int paramInt)
  {
    Log.v("ILinkImInterfaceService", "login");
    this.g = new Timer();
    this.h = new b.1(this);
    this.g.schedule(this.h, paramInt * 1000);
    ILinkDevInterface.login();
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(String paramString, int paramInt)
  {
    ILinkDevInterface.initLog(paramString, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ILinkDevInterface.updateDeviceParams(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ILinkDevInterface.init(paramArrayOfByte, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    return ILinkDevInterface.startUploadLog(paramArrayOfByte);
  }
  
  public void b() {}
  
  public String c()
  {
    return ILinkDevInterface.getToken();
  }
  
  public String d()
  {
    return ILinkDevInterface.getIlinkId();
  }
  
  public void e() {}
  
  public void f() {}
  
  protected a g()
  {
    return this.e;
  }
  
  public void h()
  {
    this.g.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.dev.interfaces.b
 * JD-Core Version:    0.7.0.1
 */