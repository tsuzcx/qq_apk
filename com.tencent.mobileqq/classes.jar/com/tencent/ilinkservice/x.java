package com.tencent.ilinkservice;

import java.util.Vector;

final class x
  implements y
{
  private final String a = "IlinkServiceDevice";
  private w b = null;
  private boolean c = false;
  private Vector<Integer> d = new Vector();
  
  void a()
  {
    this.d.clear();
    this.c = true;
  }
  
  void a(int paramInt)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetStatusChanged status:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceDevice", localStringBuilder.toString(), new Object[0]);
    localObject = this.b;
    if (localObject != null) {
      ((w)localObject).a(paramInt);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (!this.d.contains(Integer.valueOf(paramInt2))) {
      return;
    }
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendMsgResult error:");
    localStringBuilder.append(paramInt1);
    ((af)localObject).a("IlinkServiceDevice", localStringBuilder.toString(), new Object[0]);
    localObject = this.b;
    if (localObject != null) {
      ((w)localObject).a(paramInt1, paramInt2);
    }
  }
  
  void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoginComplete error:");
    localStringBuilder.append(paramInt1);
    ((af)localObject).b("IlinkServiceDevice", localStringBuilder.toString(), new Object[0]);
    localObject = this.b;
    if (localObject != null) {
      ((w)localObject).a(paramInt1, paramInt2, paramArrayOfByte, paramString);
    }
  }
  
  public void a(ag.e parame)
  {
    if (this.c)
    {
      af.a().d("IlinkServiceDevice", "already destroyed!", new Object[0]);
      return;
    }
    parame = a.n.e().a(parame.toByteString()).c().toByteArray();
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "voidCommFunction", new Class[] { String.class, [B.class }, new Object[] { "startUploadLog", parame });
  }
  
  public void a(w paramw)
  {
    this.b = paramw;
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveMessage from:");
    localStringBuilder.append(paramString1);
    ((af)localObject).a("IlinkServiceDevice", localStringBuilder.toString(), new Object[0]);
    localObject = this.b;
    if (localObject != null) {
      ((w)localObject).a(paramString1, paramString2, paramString3, paramString4, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c)
    {
      af.a().d("IlinkServiceDevice", "already destroyed!", new Object[0]);
      return;
    }
    Class localClass = Boolean.TYPE;
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "setConsoleLogOpen", new Class[] { localClass }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void b()
  {
    if (this.c)
    {
      af.a().d("IlinkServiceDevice", "already destroyed!", new Object[0]);
      return;
    }
    v.a().a(IlinkServiceImpl.getInstance(), IlinkServiceImpl.class, "autoLogin", new Class[0], new Object[0]);
  }
  
  void b(int paramInt)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUploadLogComplete errcode:");
    localStringBuilder.append(paramInt);
    ((af)localObject).a("IlinkServiceDevice", localStringBuilder.toString(), new Object[0]);
    localObject = this.b;
    if (localObject != null) {
      ((w)localObject).b(paramInt);
    }
  }
  
  void c()
  {
    af.a().a("IlinkServiceDevice", "onFinishGetStrategy", new Object[0]);
    w localw = this.b;
    if (localw != null) {
      localw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.x
 * JD-Core Version:    0.7.0.1
 */