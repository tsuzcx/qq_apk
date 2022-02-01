package com.tencent.featuretoggle.hltxkg;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpClient;
import com.tencent.featuretoggle.hltxkg.common.a.b;
import com.tencent.featuretoggle.hltxkg.common.c.f;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import com.tencent.featuretoggle.hltxkg.common.c.j.a;

public class HalleyAgent
{
  private static volatile boolean a = false;
  
  public static int getCurAppid()
  {
    return com.tencent.featuretoggle.hltxkg.common.a.c();
  }
  
  public static IHttpClient getHttpClient(HalleyInitParam paramHalleyInitParam)
  {
    if (!a) {
      init(paramHalleyInitParam);
    }
    return com.tencent.featuretoggle.hltxkg.access.http.a.a.a();
  }
  
  public static void init(HalleyInitParam paramHalleyInitParam)
  {
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      int k;
      int i;
      try
      {
        bool1 = a;
        if (bool1) {
          return;
        }
        System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        if (paramHalleyInitParam != null)
        {
          Object localObject = paramHalleyInitParam.getContext().getPackageName();
          String str = j.a(paramHalleyInitParam.getContext());
          bool2 = paramHalleyInitParam.isTestMode();
          k = paramHalleyInitParam.getTestAppid();
          if (paramHalleyInitParam.isSDKMode())
          {
            i = paramHalleyInitParam.getAppid();
          }
          else
          {
            i = j.a(paramHalleyInitParam.getContext(), (String)localObject);
            break label409;
            paramHalleyInitParam = new StringBuilder("testAppid illegal:");
            paramHalleyInitParam.append(k);
            throw new HalleyRuntimeException(paramHalleyInitParam.toString());
            bool1 = paramHalleyInitParam.isSDKMode();
            int m = 0;
            int j = m;
            if (bool1) {
              break label431;
            }
            j.a locala = j.a(i, paramHalleyInitParam.getContext(), (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
            if (locala != null)
            {
              if ((locala.d != null) && (locala.a != null))
              {
                if (locala.d.equals(locala.a)) {
                  break label425;
                }
                bool1 = true;
                com.tencent.featuretoggle.hltxkg.common.a.g = bool1;
              }
              if (!locala.c)
              {
                if (locala.b)
                {
                  localObject = j.a(i, paramHalleyInitParam.getContext(), (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
                  j = m;
                  if (localObject == null) {
                    break label431;
                  }
                  if (((j.a)localObject).c)
                  {
                    if (((j.a)localObject).e != null)
                    {
                      j = ((j.a)localObject).e.getInt("security_version");
                      if (j > 0) {
                        break label431;
                      }
                      throw new HalleyRuntimeException("need set valid security_version for ActivateService");
                    }
                    throw new HalleyRuntimeException("need set security_version for ActivateService");
                  }
                  throw new HalleyRuntimeException("need set ActivateService exported to true");
                }
                throw new HalleyRuntimeException("need set PlatformService enabled to true");
              }
              throw new HalleyRuntimeException("need set PlatformService exported to false");
            }
            throw new HalleyRuntimeException("need set PlatformService in manifest for halley");
            com.tencent.featuretoggle.hltxkg.common.a.a(bool2, i, paramHalleyInitParam, str, j);
            b.a();
            paramHalleyInitParam.getBeaconAppKey();
            f.d().g();
            com.tencent.featuretoggle.hltxkg.common.a.g();
            a = true;
            SystemClock.elapsedRealtime();
            return;
            paramHalleyInitParam = new StringBuilder("appid illegal:");
            paramHalleyInitParam.append(i);
            throw new HalleyRuntimeException(paramHalleyInitParam.toString());
          }
        }
        else
        {
          throw new HalleyRuntimeException("initParam null");
        }
      }
      finally {}
      label409:
      if (i > 0) {
        if (bool2) {
          if (k > 0)
          {
            continue;
            label425:
            bool1 = false;
            continue;
            label431:
            if (bool2) {
              i = k;
            }
          }
        }
      }
    }
  }
  
  public static boolean isInit()
  {
    return a;
  }
  
  public static boolean isTestMode()
  {
    return com.tencent.featuretoggle.hltxkg.common.a.b();
  }
  
  public static void keepPlatformAlive()
  {
    boolean bool = a;
  }
  
  public static void setAppisBackground(boolean paramBoolean)
  {
    if (a) {
      f.d().a(paramBoolean);
    }
  }
  
  public static void setChannelId(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.featuretoggle.hltxkg.common.a.e = paramString;
    }
  }
  
  public static void setCustomVersionCode(int paramInt)
  {
    com.tencent.featuretoggle.hltxkg.common.a.c = paramInt;
  }
  
  public static void setCustomVersionName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.featuretoggle.hltxkg.common.a.a = paramString;
    }
  }
  
  public static void setFileLog(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public static void updateUuid(String paramString)
  {
    if ((a) && (paramString != null) && (!paramString.equals(com.tencent.featuretoggle.hltxkg.common.a.d)))
    {
      com.tencent.featuretoggle.hltxkg.common.a.d = paramString;
      f.d().a(com.tencent.featuretoggle.hltxkg.common.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.HalleyAgent
 * JD-Core Version:    0.7.0.1
 */