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
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      int j;
      int i;
      try
      {
        bool1 = a;
        if (bool1) {
          return;
        }
        System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        if (paramq != null)
        {
          Object localObject = paramq.a.getPackageName();
          String str = dc.a(paramq.a);
          bool2 = paramq.h;
          j = paramq.i;
          if (paramq.c)
          {
            i = paramq.b;
          }
          else
          {
            i = dc.a(paramq.a, (String)localObject);
            break label395;
            throw new r("testAppid illegal:".concat(String.valueOf(j)));
            if (paramq.c) {
              break label416;
            }
            dc.a locala = dc.a(i, paramq.a, (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
            if (locala != null)
            {
              if ((locala.d != null) && (locala.a != null))
              {
                if (locala.d.equals(locala.a)) {
                  break label411;
                }
                bool1 = true;
                ac.f = bool1;
              }
              if (!locala.c)
              {
                if (locala.b)
                {
                  localObject = dc.a(i, paramq.a, (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
                  if (localObject == null) {
                    break label416;
                  }
                  if (((dc.a)localObject).c)
                  {
                    if (((dc.a)localObject).e != null)
                    {
                      if (((dc.a)localObject).e.getInt("security_version") > 0) {
                        break label416;
                      }
                      throw new r("need set valid security_version for ActivateService");
                    }
                    throw new r("need set security_version for ActivateService");
                  }
                  throw new r("need set ActivateService exported to true");
                }
                throw new r("need set PlatformService enabled to true");
              }
              throw new r("need set PlatformService exported to false");
            }
            throw new r("need set PlatformService in manifest for halley");
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
            return;
            throw new r("appid illegal:".concat(String.valueOf(i)));
          }
        }
        else
        {
          throw new r("initParam null");
        }
      }
      finally {}
      label395:
      if (i > 0) {
        if (bool2) {
          if (j > 0)
          {
            continue;
            label411:
            bool1 = false;
            continue;
            label416:
            if (bool2) {
              i = j;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.p
 * JD-Core Version:    0.7.0.1
 */