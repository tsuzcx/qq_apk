package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

public final class a
{
  private static volatile boolean a = false;
  
  public static d a(b paramb)
  {
    if (!a) {
      b(paramb);
    }
    return g.a();
  }
  
  private static void b(b paramb)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = a;
      if (bool2) {
        return;
      }
      System.currentTimeMillis();
      SystemClock.elapsedRealtime();
      if (paramb == null) {
        throw new c("initParam null");
      }
    }
    finally {}
    Object localObject = paramb.a.getPackageName();
    String str = cc.a(paramb.a);
    int i = paramb.g;
    if (paramb.c) {}
    for (i = paramb.b; i <= 0; i = cc.a(paramb.a, (String)localObject)) {
      throw new c("appid illegal:" + i);
    }
    cc.a locala;
    if (!paramb.c)
    {
      locala = cc.a(i, paramb.a, (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
      if (locala == null) {
        throw new c("need set PlatformService in manifest for halley");
      }
      if ((locala.d != null) && (locala.a != null)) {
        if (locala.d.equals(locala.a)) {
          break label338;
        }
      }
    }
    for (;;)
    {
      l.g = bool1;
      if (locala.c) {
        throw new c("need set PlatformService exported to false");
      }
      if (!locala.b) {
        throw new c("need set PlatformService enabled to true");
      }
      localObject = cc.a(i, paramb.a, (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
      if (localObject != null)
      {
        if (!((cc.a)localObject).c) {
          throw new c("need set ActivateService exported to true");
        }
        if (((cc.a)localObject).e == null) {
          throw new c("need set security_version for ActivateService");
        }
        if (((cc.a)localObject).e.getInt("security_version") <= 0) {
          throw new c("need set valid security_version for ActivateService");
        }
      }
      l.a(i, paramb, str);
      v.a = paramb.f;
      by.c().f();
      a = true;
      SystemClock.elapsedRealtime();
      break;
      label338:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.a
 * JD-Core Version:    0.7.0.1
 */