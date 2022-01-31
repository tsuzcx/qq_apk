package com.tencent.beacon.core.c;

import android.content.Context;
import com.tencent.beacon.core.b.c;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.core.strategy.a.a;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class a
{
  protected final int a;
  protected final int b;
  protected Context c;
  protected String d;
  protected int e;
  protected String f;
  
  public a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.f = paramString;
  }
  
  public a(Context paramContext, String paramString)
  {
    this.c = paramContext;
    this.a = 102;
    this.b = 0;
    this.f = paramString;
  }
  
  public static RequestPackage a(int paramInt1, com.tencent.beacon.core.b.b paramb, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString)
  {
    if (paramb == null)
    {
      com.tencent.beacon.core.d.b.d("error no com info! ", new Object[0]);
      return null;
    }
    for (;;)
    {
      try
      {
        RequestPackage localRequestPackage = new RequestPackage();
        localRequestPackage.model = paramb.e();
        localRequestPackage.osVersion = paramb.f();
        localRequestPackage.platformId = paramb.g();
        localRequestPackage.appkey = paramString;
        localRequestPackage.appVersion = paramb.b(paramString);
        localRequestPackage.sdkId = paramb.c();
        localRequestPackage.sdkVersion = paramb.d();
        localRequestPackage.reserved = "";
        HashMap localHashMap;
        if (paramInt1 == 100)
        {
          localHashMap = new HashMap();
          localHashMap.put("A1", UserAction.getUserID(null));
          localObject = c.a(paramb.j());
          localHashMap.put("A2", ((c)localObject).a());
          localHashMap.put("A4", ((c)localObject).c());
          localHashMap.put("A6", ((c)localObject).b());
          localHashMap.put("A7", ((c)localObject).d());
          localHashMap.put("A3", QimeiSDK.getInstance().getQimeiInternal());
          localHashMap.put("A23", paramb.a(null));
          localHashMap.put("A31", ((c)localObject).e());
          d.a(paramb.j());
          localHashMap.put("A33", d.j(paramb.j()));
          if (com.tencent.beacon.core.b.a.g(paramb.j()))
          {
            localHashMap.put("A66", "F");
            localHashMap.put("A67", com.tencent.beacon.core.b.a.i(paramb.j()));
            localHashMap.put("A68", com.tencent.beacon.core.b.a.h(paramb.j()));
            if (!com.tencent.beacon.core.b.a.a) {
              break label636;
            }
            localObject = "Y";
            localHashMap.put("A85", localObject);
            localRequestPackage.reserved = com.tencent.beacon.core.d.a.a(localHashMap);
          }
        }
        else
        {
          if (paramInt1 != 102) {
            break label643;
          }
          paramb = c.a(paramb.j());
          localObject = new LinkedHashMap();
          ((Map)localObject).put("A141", paramb.f());
          ((Map)localObject).put("A142", paramb.g());
          ((Map)localObject).put("A143", paramb.h());
          localRequestPackage.reserved = com.tencent.beacon.core.d.a.a((Map)localObject);
          break label643;
          localRequestPackage.reserved = com.tencent.beacon.core.d.a.a(UserAction.getAdditionalInfo(paramString));
          localRequestPackage.cmd = paramInt1;
          localRequestPackage.encryType = ((byte)paramInt3);
          localRequestPackage.zipType = ((byte)paramInt2);
          paramb = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            paramb = "".getBytes();
          }
          localRequestPackage.sBuffer = paramb;
          return localRequestPackage;
        }
        localHashMap.put("A66", "B");
        continue;
        Object localObject = "N";
      }
      catch (Throwable paramb)
      {
        com.tencent.beacon.core.d.b.a(paramb);
        return null;
      }
      label636:
      continue;
      label643:
      if ((paramInt1 != 4) && (paramInt1 != 2)) {
        if (paramInt1 != 1) {}
      }
    }
  }
  
  public static RequestPackage a(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    com.tencent.beacon.core.d.b.b("[event] origin events byte size: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = a(paramInt, com.tencent.beacon.core.b.b.a(UserAction.mContext), paramArrayOfByte, 2, 3, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.core.d.b.c("[event] encode request package error:%s", new Object[] { paramArrayOfByte.toString() });
      com.tencent.beacon.core.d.b.a(paramArrayOfByte);
    }
    return null;
  }
  
  public abstract RequestPackage a();
  
  public void b()
  {
    com.tencent.beacon.core.d.b.c("[db] encode failed, clear db data", new Object[0]);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public final int c()
  {
    return this.a;
  }
  
  public final String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      if (this.b == 0) {
        return StrategyQueryModule.getInstance(this.c).getStrategy().b();
      }
      String str = StrategyQueryModule.getInstance(this.c).getStrategy().b(this.b).b();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.d.b.c("[strategy] get strategy error:%s", new Object[] { localThrowable.toString() });
      com.tencent.beacon.core.d.b.a(localThrowable);
    }
    return null;
  }
  
  public final int f()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.c.a
 * JD-Core Version:    0.7.0.1
 */