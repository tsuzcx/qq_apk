package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

public final class p
{
  private static volatile boolean a = false;
  
  public static t a(q paramq)
  {
    if (!a) {
      b(paramq);
    }
    return w.a();
  }
  
  private static void b(q paramq)
  {
    boolean bool1 = true;
    try
    {
      bool2 = a;
      if (bool2) {
        return;
      }
      System.currentTimeMillis();
      SystemClock.elapsedRealtime();
      if (paramq == null) {
        throw new r("initParam null");
      }
    }
    finally {}
    Object localObject = paramq.a.getPackageName();
    String str = dc.a(paramq.a);
    boolean bool2 = paramq.h;
    int j = paramq.i;
    if (paramq.c) {}
    for (int i = paramq.b; i <= 0; i = dc.a(paramq.a, (String)localObject)) {
      throw new r("appid illegal:".concat(String.valueOf(i)));
    }
    if ((bool2) && (j <= 0)) {
      throw new r("testAppid illegal:".concat(String.valueOf(j)));
    }
    if (!paramq.c)
    {
      dc.a locala = dc.a(i, paramq.a, (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
      if (locala == null) {
        throw new r("need set PlatformService in manifest for halley");
      }
      if ((locala.d != null) && (locala.a != null))
      {
        if (!locala.d.equals(locala.a)) {
          ac.f = bool1;
        }
      }
      else
      {
        if (locala.c) {
          throw new r("need set PlatformService exported to false");
        }
        if (!locala.b) {
          throw new r("need set PlatformService enabled to true");
        }
        localObject = dc.a(i, paramq.a, (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
        if (localObject == null) {
          break label408;
        }
        if (!((dc.a)localObject).c) {
          throw new r("need set ActivateService exported to true");
        }
        if (((dc.a)localObject).e == null) {
          throw new r("need set security_version for ActivateService");
        }
        if (((dc.a)localObject).e.getInt("security_version") > 0) {
          break label408;
        }
        throw new r("need set valid security_version for ActivateService");
      }
    }
    for (;;)
    {
      label334:
      ac.a(bool2, i, paramq, str);
      af.a();
      as.b = paramq.f;
      paramq = cy.d();
      if (ac.e()) {
        paramq.a = cx.e();
      }
      paramq.a.a(paramq);
      paramq.a.d();
      a = true;
      SystemClock.elapsedRealtime();
      break;
      label408:
      do
      {
        break label334;
        bool1 = false;
        break;
      } while (!bool2);
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.p
 * JD-Core Version:    0.7.0.1
 */