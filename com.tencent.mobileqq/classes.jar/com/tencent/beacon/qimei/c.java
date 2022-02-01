package com.tencent.beacon.qimei;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.a.i;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.base.net.a.k.a;
import com.tencent.beacon.base.net.c.e.a;
import com.tencent.beacon.pack.QimeiPackage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  implements com.tencent.beacon.base.net.a.b<byte[]>, e.a, Runnable
{
  private final Context a;
  private AtomicInteger b = new AtomicInteger();
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("q_m", paramHashMap);
    com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(1, localHashMap));
  }
  
  private void d()
  {
    com.tencent.beacon.base.util.c.a("[Qimei]", 4, "stop netListen.", new Object[0]);
    com.tencent.beacon.base.net.c.e.a(this);
  }
  
  public void a()
  {
    this.b.set(0);
    com.tencent.beacon.a.b.a.a().a(this);
  }
  
  public void a(com.tencent.beacon.base.net.e parame)
  {
    com.tencent.beacon.base.util.c.a("[Qimei]", 1, "onFailure msg: %s. Waiting next query.", new Object[] { parame.toString() });
    com.tencent.beacon.a.b.d.b().a("498", parame.toString());
    if (a.a().b().isEmpty()) {
      com.tencent.beacon.a.b.a.a().a(10000L, this);
    }
  }
  
  public void a(String paramString)
  {
    Qimei localQimei = a.a().b();
    HashMap localHashMap = f.a(paramString);
    paramString = localQimei;
    if (localHashMap != null)
    {
      paramString = new Qimei((String)localHashMap.get("A3"), (String)localHashMap.get("A153"), localHashMap);
      f.b(this.a, paramString.toString());
    }
    a.a().a(paramString);
    a(localHashMap);
  }
  
  public void a(@NonNull byte[] paramArrayOfByte)
  {
    com.tencent.beacon.base.util.c.a("[Qimei]", 1, "onResponse length: %d. ", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    paramArrayOfByte = new com.tencent.beacon.pack.a(paramArrayOfByte);
    QimeiPackage localQimeiPackage = new QimeiPackage();
    localQimeiPackage.readFrom(paramArrayOfByte);
    paramArrayOfByte = localQimeiPackage.qimei;
    com.tencent.beacon.base.util.c.a("[Qimei]", 2, "get new qimei: %s", new Object[] { paramArrayOfByte });
    if (!TextUtils.isEmpty(paramArrayOfByte))
    {
      com.tencent.beacon.base.util.c.a("[Qimei]", 3, "dispatch qimei to listener and save qimei!", new Object[0]);
      a(paramArrayOfByte);
      f.a(this.a, paramArrayOfByte);
      f.a(System.currentTimeMillis());
      d();
    }
  }
  
  public void b() {}
  
  public void c()
  {
    com.tencent.beacon.a.b.a.a().a(300L, new b(this));
  }
  
  public void run()
  {
    com.tencent.beacon.base.net.c.e.a(this.a, this);
    if (!com.tencent.beacon.base.net.c.d.d()) {
      return;
    }
    if (!com.tencent.beacon.a.c.b.g(this.a))
    {
      c();
      return;
    }
    Object localObject = QimeiSDK.getInstance();
    localObject = k.a().a(RequestType.QIMEI).a(com.tencent.beacon.base.net.c.b.b(true), 8081).b(com.tencent.beacon.base.net.c.b.b(false)).a(((QimeiSDK)localObject).getAppKey()).a(102).b(103).a(a.a().c()).b("A141", ((QimeiSDK)localObject).getBeaconIdInfo()).b("A142", String.valueOf(((QimeiSDK)localObject).getContext().getApplicationInfo().targetSdkVersion)).b("A143", ((QimeiSDK)localObject).getOmgID()).b("A144", com.tencent.beacon.a.c.f.p().y()).b("A23", com.tencent.beacon.a.c.c.d().a()).a();
    com.tencent.beacon.base.net.d.c().a((k)localObject).a(this);
    com.tencent.beacon.base.util.c.a("[Qimei]", 0, "QimeiQueryTask start. RequestEntity: %s", new Object[] { ((k)localObject).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.c
 * JD-Core Version:    0.7.0.1
 */