package com.tencent.common.config.provider;

import NS_UNDEAL_COUNT.entrance_cfg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZConfigProviderUtilProxy;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

public class QZConfigProviderUtil
{
  public static boolean a = false;
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).getHighPriorityConfig(paramString1, paramString2, paramString3);
  }
  
  public static void a(long paramLong)
  {
    ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).saveIspCheckTime(paramLong);
  }
  
  public static void a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).saveNavigatorBar(paramString, paramArrayList);
  }
  
  public static void a(Map<String, String> paramMap)
  {
    ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).saveIspConfig(paramMap);
  }
  
  public static void a(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).updateConfigAndCookie(paramMap, paramString1, paramString2, paramAppRuntime);
  }
  
  public static boolean a()
  {
    return ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).isQQCircleUseEeveeRedPoint();
  }
  
  public static Map<String, String> b()
  {
    return ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).loadIspConfigs();
  }
  
  public static boolean b(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    return ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).getNavigatorConfigs(paramString, paramArrayList);
  }
  
  public static String c()
  {
    return ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).getConfigCookie();
  }
  
  public static long d()
  {
    return ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).getLastCheckTime();
  }
  
  public static void e()
  {
    ((IQZConfigProviderUtilProxy)QRoute.api(IQZConfigProviderUtilProxy.class)).cleanAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigProviderUtil
 * JD-Core Version:    0.7.0.1
 */