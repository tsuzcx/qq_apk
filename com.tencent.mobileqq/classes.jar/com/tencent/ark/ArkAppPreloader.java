package com.tencent.ark;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ArkAppPreloader
{
  private static final ArkEnvironmentManager ENV = ;
  public static final int PRELOAD_DESTROY_RELOAD = 2;
  public static final int PRELOAD_START_UP = 1;
  private static final String TAG = "ArkApp.ArkAppPreloader";
  private static boolean sArkCommonInit = false;
  private static HashMap<String, ArkAppPreloader.PreloadAppInfo> sPreLoadApplications = new HashMap(8);
  
  public static boolean isAppPreloaded(String paramString)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (sPreLoadApplications)
    {
      if (sPreLoadApplications.containsKey(paramString)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static void preloadApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkAppPreloader.PreloadAppCallback paramPreloadAppCallback, int paramInt)
  {
    if (paramString1 == null)
    {
      ENV.logE("ArkApp.ArkAppPreloader", "profiling.preloadApp failed for appname is null");
      return;
    }
    paramPreloadAppCallback = new WeakReference(paramPreloadAppCallback);
    try
    {
      ArkDispatchQueue.asyncRun(paramString1, new ArkAppPreloader.1(paramPreloadAppCallback, paramString1, paramInt, paramString2, paramString3, paramString5, paramString4));
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      ENV.logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp, exception=%s", new Object[] { paramString1.getMessage() }));
    }
  }
  
  public static void preloadCommon(float paramFloat, String paramString1, String paramString2)
  {
    try
    {
      if (!sArkCommonInit)
      {
        ark.arkHTTPStartup();
        ark.arkSetPixelScale(paramFloat);
        ark.arkSetStoragePath(paramString1, paramString2);
        ark.arkHTTPSetDownloadDirectory(paramString2);
        ArkViewModelBase.setArkHttpProxy();
        ENV.logI("ArkApp.ArkAppPreloader", String.format("profiling.preloadCommon storagePath=%s.cachePath=%s", new Object[] { paramString1, paramString2 }));
        sArkCommonInit = true;
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      ENV.logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadCommon, exception=%s", new Object[] { paramString1.getMessage() }));
    }
  }
  
  public static void releasePreloadApplicationAndReload(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (sPreLoadApplications)
      {
        localObject2 = (ArkAppPreloader.PreloadAppInfo)sPreLoadApplications.get(paramString);
        ENV.logI("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s releasing preloadApp:%s", new Object[] { paramString }));
        if (localObject2 != null)
        {
          str5 = ((ArkAppPreloader.PreloadAppInfo)localObject2).appName;
          str4 = ((ArkAppPreloader.PreloadAppInfo)localObject2).appPath;
          str3 = ((ArkAppPreloader.PreloadAppInfo)localObject2).storagePath;
          str2 = ((ArkAppPreloader.PreloadAppInfo)localObject2).resPath;
          str1 = ((ArkAppPreloader.PreloadAppInfo)localObject2).cachePath;
          if (((ArkAppPreloader.PreloadAppInfo)localObject2).callbackRef != null)
          {
            localObject1 = (ArkAppPreloader.PreloadAppCallback)((ArkAppPreloader.PreloadAppInfo)localObject2).callbackRef.get();
            ark.Application localApplication = ((ArkAppPreloader.PreloadAppInfo)localObject2).application;
            localObject2 = localObject1;
            localObject1 = localApplication;
            if (localObject1 != null)
            {
              ENV.logD("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s releasing.preloadApp.application=%h", new Object[] { localObject1 }));
              ((ark.Application)localObject1).Release();
              sPreLoadApplications.remove(paramString);
            }
            ENV.logD("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s preloadApp.appName=%s,path=%s,storagePath=%s,resPath=%s,cachePath=%s,cb=%h", new Object[] { str5, str4, str3, str2, str1, localObject2 }));
            if ((TextUtils.isEmpty(str5)) || (localObject2 == null)) {
              break;
            }
            ENV.logD("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s.begin.preload.App=%s", new Object[] { str5 }));
            ((ArkAppPreloader.PreloadAppCallback)localObject2).onReleaseAndReload(str5, 2);
            return;
          }
          localObject1 = null;
        }
      }
      Object localObject1 = null;
      Object localObject2 = null;
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkAppPreloader
 * JD-Core Version:    0.7.0.1
 */