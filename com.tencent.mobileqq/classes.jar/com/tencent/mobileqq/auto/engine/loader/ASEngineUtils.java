package com.tencent.mobileqq.auto.engine.loader;

import com.tencent.mobileqq.auto.engine.loader.net.ASDataBaseInfo;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ASEngineUtils
{
  public static int a()
  {
    String[] arrayOfString = ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion().split("\\.");
    if ((arrayOfString != null) && (arrayOfString.length >= 3))
    {
      StringBuilder localStringBuilder = new StringBuilder(arrayOfString[0]);
      if (arrayOfString[1].length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(arrayOfString[1]);
      }
      else
      {
        localStringBuilder.append(arrayOfString[1]);
      }
      if (arrayOfString[2].length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(arrayOfString[2]);
      }
      else
      {
        localStringBuilder.append(arrayOfString[2]);
      }
      localStringBuilder.append("00");
      return Integer.parseInt(localStringBuilder.toString());
    }
    return 2147483647;
  }
  
  public static ASPluginBean a(ASDataBaseInfo paramASDataBaseInfo)
  {
    if (paramASDataBaseInfo == null) {
      return null;
    }
    ASPluginBean localASPluginBean = new ASPluginBean();
    localASPluginBean.setType("TYPE_NET").setVersionCode(paramASDataBaseInfo.mVersion).setBusinessKey(paramASDataBaseInfo.mBusinessKey).setPluginZipPath(paramASDataBaseInfo.mPluginZipPath).setZipFileLength(paramASDataBaseInfo.mZipFileLength).setPluginMangerApkPath(paramASDataBaseInfo.mPluginManagerPath).setManagerFileLength(paramASDataBaseInfo.mManagerFileLength);
    return localASPluginBean;
  }
  
  public static String b()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static long c()
  {
    return Long.valueOf(b()).longValue();
  }
  
  public static EntityManager d()
  {
    if (e() != null) {
      return e().getEntityManagerFactory(e().getAccount()).createEntityManager();
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return localAppRuntime.getEntityManagerFactory(localAppRuntime.getAccount()).createEntityManager();
  }
  
  public static AppRuntime e()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.ASEngineUtils
 * JD-Core Version:    0.7.0.1
 */