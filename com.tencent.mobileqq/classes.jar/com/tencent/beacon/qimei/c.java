package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import java.util.LinkedHashMap;
import java.util.Map;

public final class c
  extends com.tencent.beacon.core.c.a
{
  private Context g = null;
  private RequestPackage h = null;
  
  public c(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.g = paramContext;
  }
  
  public final RequestPackage a()
  {
    Object localObject1 = null;
    com.tencent.beacon.core.d.b.b("[qimei] start", new Object[0]);
    if (this.h != null) {
      return this.h;
    }
    a locala;
    try
    {
      locala = a.a(this.g);
      if (locala != null) {
        break label58;
      }
      com.tencent.beacon.core.d.b.d("[qimei] qimeiInfo is null, return", new Object[0]);
      return null;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.d.b.a(localThrowable);
    }
    return this.h;
    label58:
    if (locala == null) {}
    for (;;)
    {
      Object localObject2 = localThrowable.toByteArray();
      Object localObject3 = com.tencent.beacon.core.b.b.a(this.c);
      this.h = a(this.a, (com.tencent.beacon.core.b.b)localObject3, (byte[])localObject2, 2, 3, this.f);
      if (c() == 102)
      {
        localObject2 = com.tencent.beacon.core.b.c.a(((com.tencent.beacon.core.b.b)localObject3).j());
        localObject3 = new LinkedHashMap();
        ((Map)localObject3).put("A141", QimeiSDK.getInstance().getBeaconIdInfo(this.c));
        ((Map)localObject3).put("A142", ((com.tencent.beacon.core.b.c)localObject2).g());
        ((Map)localObject3).put("A143", ((com.tencent.beacon.core.b.c)localObject2).h());
        this.h.reserved = com.tencent.beacon.core.d.a.a((Map)localObject3);
      }
      com.tencent.beacon.core.d.b.b("[qimei] QIMEI upload data: %s", new Object[] { this.h });
      break;
      localObject3 = new QimeiPackage();
      String str = locala.c();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).imei = ((String)localObject2);
      str = locala.e();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).imsi = ((String)localObject2);
      str = locala.d();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).mac = ((String)localObject2);
      str = locala.f();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).androidId = ((String)localObject2);
      str = locala.a();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).qimei = ((String)localObject2);
      str = locala.i();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).model = ((String)localObject2);
      str = locala.j();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).brand = ((String)localObject2);
      str = locala.g();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).osVersion = ((String)localObject2);
      ((QimeiPackage)localObject3).broot = false;
      str = locala.h();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).qq = ((String)localObject2);
      str = locala.k();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((QimeiPackage)localObject3).cid = ((String)localObject2);
      localObject2 = localObject3;
    }
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.c
 * JD-Core Version:    0.7.0.1
 */