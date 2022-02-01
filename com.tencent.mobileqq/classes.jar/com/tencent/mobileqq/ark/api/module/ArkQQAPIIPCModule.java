package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkQQAPIIPCModule
{
  public static String a()
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.1(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.2(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.3(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static void a(long paramLong1, long paramLong2, ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler paramOnLoginEventHandler)
  {
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.6(paramLong1, paramLong2, paramOnLoginEventHandler, paramLong2));
  }
  
  public static void a(String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler)
  {
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.9(paramString, paramOnGetPSKeyHandler));
  }
  
  public static String b()
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.4(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.5(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static int c()
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.8(localArrayList));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  public static String c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.7(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public static boolean d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkQQAPIIPCModule.10(paramString, localArrayList));
    return ((Boolean)localArrayList.get(0)).booleanValue();
  }
  
  private static QQAppInterface e()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule
 * JD-Core Version:    0.7.0.1
 */