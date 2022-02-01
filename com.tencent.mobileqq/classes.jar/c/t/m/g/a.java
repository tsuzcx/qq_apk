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
    for (;;)
    {
      try
      {
        bool = a;
        if (bool) {
          return;
        }
        System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        if (paramb != null)
        {
          Object localObject = paramb.a.getPackageName();
          String str = ck.a(paramb.a);
          int i;
          if (paramb.c) {
            i = paramb.b;
          } else {
            i = ck.a(paramb.a, (String)localObject);
          }
          if (i > 0)
          {
            if (!paramb.c)
            {
              ck.a locala = ck.a(i, paramb.a, (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
              if (locala != null)
              {
                if ((locala.d != null) && (locala.a != null))
                {
                  if (locala.d.equals(locala.a)) {
                    break label364;
                  }
                  bool = true;
                  m.e = bool;
                }
                if (!locala.c)
                {
                  if (locala.b)
                  {
                    localObject = ck.a(i, paramb.a, (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
                    if (localObject != null) {
                      if (((ck.a)localObject).c)
                      {
                        if (((ck.a)localObject).e != null)
                        {
                          if (((ck.a)localObject).e.getInt("security_version") <= 0) {
                            throw new c("need set valid security_version for ActivateService");
                          }
                        }
                        else {
                          throw new c("need set security_version for ActivateService");
                        }
                      }
                      else {
                        throw new c("need set ActivateService exported to true");
                      }
                    }
                  }
                  else
                  {
                    throw new c("need set PlatformService enabled to true");
                  }
                }
                else {
                  throw new c("need set PlatformService exported to false");
                }
              }
              else
              {
                throw new c("need set PlatformService in manifest for halley");
              }
            }
            m.a(i, paramb, str);
            p.a();
            x.a.a = paramb.f;
            paramb = cg.d();
            if (m.g()) {
              paramb.a = cf.e();
            }
            paramb.a.a(paramb);
            paramb.a.d();
            a = true;
            SystemClock.elapsedRealtime();
          }
          else
          {
            throw new c("appid illegal:".concat(String.valueOf(i)));
          }
        }
        else
        {
          throw new c("initParam null");
        }
      }
      finally {}
      label364:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.a
 * JD-Core Version:    0.7.0.1
 */