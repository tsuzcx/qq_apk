package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.dev.interfaces.a;
import com.tencent.ilink.dev.interfaces.b;
import com.tencent.ilink.network.DeviceInterface;
import com.tencent.ilink.network.a.a;
import com.tencent.ilink.network.a.b;
import com.tencent.ilink.network.a.b.a;
import com.tencent.ilink.network.c;
import com.tencent.luggage.wxa.aq.a.c;
import com.tencent.luggage.wxa.aq.a.c.a;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mars.ilink.xlog.Xlog;
import java.util.concurrent.ConcurrentHashMap;

final class z
  implements a, c
{
  private final String a = "IlinkDeviceManager";
  private z.a b;
  private ConcurrentHashMap<String, String> c = new ConcurrentHashMap();
  private Xlog d;
  
  public z(z.a parama)
  {
    Log.d("IlinkDeviceManager", "Create IlinkDeviceManager");
    this.b = parama;
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString2 = b.a().a(paramString2, paramString3, paramString4, paramString5);
    this.c.put(paramString2, paramString1);
    return paramString2;
  }
  
  public void a()
  {
    Log.d("IlinkDeviceManager", "onFinishGetStrategy");
    this.b.addDeviceCallbackTask("", "onFinishGetStrategy", new Class[0], new Object[0]);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetStatusChanged:");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("IlinkDeviceManager", ((StringBuilder)localObject).toString());
    localObject = Integer.TYPE;
    this.b.addDeviceCallbackTask("", "onNetStatusChanged", new Class[] { localObject }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoginComplete:");
    localStringBuilder.append(paramInt1);
    Log.d("IlinkDeviceManager", localStringBuilder.toString());
    this.b.onLoginComplete(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSendMsgResult:");
    ((StringBuilder)localObject).append(paramInt);
    Log.i("IlinkDeviceManager", ((StringBuilder)localObject).toString());
    if (this.c.containsKey(paramString))
    {
      localObject = Integer.TYPE;
      String str = (String)this.c.get(paramString);
      this.c.remove(paramString);
      this.b.addDeviceCallbackTask(str, "onSendMsgResult", new Class[] { localObject, String.class }, new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("no body care about this message just ignore:");
    ((StringBuilder)localObject).append(paramString);
    Log.i("IlinkDeviceManager", ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceiveMessage cmdid:");
    ((StringBuilder)localObject1).append(paramInt);
    Log.i("IlinkDeviceManager", ((StringBuilder)localObject1).toString());
    if (paramInt != 1)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Not addmsg type cmdid:");
      paramArrayOfByte.append(paramInt);
      Log.w("IlinkDeviceManager", paramArrayOfByte.toString());
      return;
    }
    try
    {
      Object localObject2 = ag.a.a(paramArrayOfByte);
      if (((ag.a)localObject2).k() == 10003)
      {
        paramArrayOfByte = Integer.TYPE;
        localObject1 = this.b;
        String str = ((ag.a)localObject2).e();
        localObject2 = ((ag.a)localObject2).m();
        ((z.a)localObject1).addDeviceCallbackTask("", "onReceiveMessage", new Class[] { String.class, String.class, String.class, String.class, paramArrayOfByte }, new Object[] { str, "", "", localObject2, Integer.valueOf(0) });
        return;
      }
      Log.i("IlinkDeviceManager", "Not 10003 msgtype just ignore!");
      return;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      Log.e("IlinkDeviceManager", "parseFrom addmsg failed!");
    }
  }
  
  public void a(String paramString1, ag.f paramf, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("/log");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (paramf.p())
    {
      localObject1 = localObject2;
      if (!paramf.q().equals("")) {
        localObject1 = paramf.q();
      }
    }
    Xlog.setConsoleLogOpen(false);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("_ilinkservice");
    Xlog.appenderOpen(2, 0, (String)localObject1, (String)localObject1, ((StringBuilder)localObject2).toString(), 0, "1aee6c1d19ac4865e89c8898343c047ba99bd17808567cdb3e5c07b769a52715942a76a0cc54f5311f3bc4a6ac59feb2257f1c05e224b55833bc2ea1ce1eed59");
    this.d = new Xlog();
    Log.setLogImp(this.d);
    Log.d("IlinkDeviceManager", "init Xlog ok!");
    paramString2 = a.c.k();
    paramString2.a(paramString1);
    if (paramf.r()) {
      paramString2.b(paramf.s());
    } else {
      paramString2.b("");
    }
    paramString2.a(paramf.o());
    b.a().a((String)localObject1, 2);
    b.a().a(this);
    b.a().a(paramString2.c().toByteArray(), paramf.c(), paramf.e(), paramf.g(), paramf.i(), paramf.k(), paramf.m(), false);
    b.a().a(300);
    this.c.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    Xlog.setConsoleLogOpen(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(String paramString1, ag.f paramf, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("/log");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (paramf.p())
    {
      localObject1 = localObject2;
      if (!paramf.q().equals("")) {
        localObject1 = paramf.q();
      }
    }
    Xlog.setConsoleLogOpen(false);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("_ilinkservice");
    Xlog.appenderOpen(2, 0, (String)localObject1, (String)localObject1, ((StringBuilder)localObject2).toString(), 0, "1aee6c1d19ac4865e89c8898343c047ba99bd17808567cdb3e5c07b769a52715942a76a0cc54f5311f3bc4a6ac59feb2257f1c05e224b55833bc2ea1ce1eed59");
    this.d = new Xlog();
    Log.setLogImp(this.d);
    Log.d("IlinkDeviceManager", "init Xlog ok!");
    b.a().a((String)localObject1, 0);
    paramString2 = a.b.m();
    paramString2.a(paramString1);
    if (paramf.r()) {
      paramString2.b(paramf.s());
    } else {
      paramString2.b("");
    }
    paramString2.a(paramf.o());
    paramString2.a(a.a.b);
    b.a().a(this);
    DeviceInterface.a().a(this);
    DeviceInterface.Start(paramString2.c().toByteArray());
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    DeviceInterface.SetProxyInfo(paramArrayOfByte);
  }
  
  public void c()
  {
    Log.d("IlinkDeviceManager", "OnLonglinkConnected");
    Class localClass = Integer.TYPE;
    this.b.addDeviceCallbackTask("", "onNetStatusChanged", new Class[] { localClass }, new Object[] { Integer.valueOf(1) });
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onUploadLogComplete:");
    ((StringBuilder)localObject1).append(paramInt);
    Log.d("IlinkDeviceManager", ((StringBuilder)localObject1).toString());
    Object localObject2 = a.i.e().a(paramInt).c();
    localObject1 = this.b;
    localObject2 = ((a.i)localObject2).toByteArray();
    ((z.a)localObject1).addDeviceCallbackTask("", "OnCommonFunctionCallback", new Class[] { String.class, [B.class }, new Object[] { "onUploadLogComplete", localObject2 });
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    b.a().a(paramArrayOfByte);
  }
  
  public void d()
  {
    Log.d("IlinkDeviceManager", "OnLonglinkDisconnected");
    Class localClass = Integer.TYPE;
    this.b.addDeviceCallbackTask("", "onNetStatusChanged", new Class[] { localClass }, new Object[] { Integer.valueOf(0) });
  }
  
  public void d(int paramInt)
  {
    Xlog.setLogLevel(paramInt);
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    try
    {
      DeviceInterface.SetLonglinkIplist(a.k.a(paramArrayOfByte).c().toByteArray());
      return;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void e()
  {
    Log.d("IlinkDeviceManager", "ilinknetwork onFinishGetStrategy");
    this.b.addDeviceCallbackTask("", "onFinishGetStrategy", new Class[0], new Object[0]);
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    try
    {
      DeviceInterface.SetShortlinkIplist(a.l.a(paramArrayOfByte).c().toByteArray());
      return;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void f()
  {
    b.a().f();
    this.c.clear();
    this.d.appenderClose();
    this.d = null;
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    b.a().b(paramArrayOfByte);
  }
  
  public void g()
  {
    DeviceInterface.Stop();
    DeviceInterface.a().a(null);
    b.a().b();
    this.d.appenderClose();
    this.d = null;
  }
  
  public void h()
  {
    b.a().a(300);
  }
  
  public String i()
  {
    return b.a().d();
  }
  
  public String j()
  {
    return b.a().c();
  }
  
  public boolean k()
  {
    return DeviceInterface.isAlreadyGetStrategy();
  }
  
  public void l()
  {
    b.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.z
 * JD-Core Version:    0.7.0.1
 */