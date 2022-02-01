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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (sPreLoadApplications)
    {
      boolean bool = sPreLoadApplications.containsKey(paramString);
      return bool;
    }
  }
  
  public static void preloadApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkAppPreloader.PreloadAppCallback paramPreloadAppCallback, int paramInt)
  {
    if (paramString1 == null)
    {
      Logger.logE("ArkApp.ArkAppPreloader", "profiling.preloadApp failed for appname is null");
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
      Logger.logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadApp, exception=%s", new Object[] { paramString1.getMessage() }));
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
        Logger.logI("ArkApp.ArkAppPreloader", String.format("profiling.preloadCommon storagePath=%s.cachePath=%s", new Object[] { paramString1, paramString2 }));
        sArkCommonInit = true;
        return;
      }
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.logE("ArkApp.ArkAppPreloader", String.format("profiling.preloadCommon, exception=%s", new Object[] { paramString1.getMessage() }));
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
        localObject4 = (ArkAppPreloader.PreloadAppInfo)sPreLoadApplications.get(paramString);
        Logger.logI("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s releasing preloadApp:%s", new Object[] { paramString }));
        String str1 = null;
        localObject1 = null;
        if (localObject4 != null)
        {
          str1 = ((ArkAppPreloader.PreloadAppInfo)localObject4).appName;
          localObject3 = ((ArkAppPreloader.PreloadAppInfo)localObject4).appPath;
          localObject2 = ((ArkAppPreloader.PreloadAppInfo)localObject4).storagePath;
          String str2 = ((ArkAppPreloader.PreloadAppInfo)localObject4).resPath;
          localObject5 = ((ArkAppPreloader.PreloadAppInfo)localObject4).cachePath;
          if (((ArkAppPreloader.PreloadAppInfo)localObject4).callbackRef != null) {
            localObject1 = (ArkAppPreloader.PreloadAppCallback)((ArkAppPreloader.PreloadAppInfo)localObject4).callbackRef.get();
          }
          localApplication = ((ArkAppPreloader.PreloadAppInfo)localObject4).application;
          localObject4 = localObject1;
          localObject1 = str2;
          if (localApplication != null)
          {
            Logger.logD("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s releasing.preloadApp.application=%h", new Object[] { localApplication }));
            localApplication.Release();
            sPreLoadApplications.remove(paramString);
          }
          Logger.logD("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s preloadApp.appName=%s,path=%s,storagePath=%s,resPath=%s,cachePath=%s,cb=%h", new Object[] { str1, localObject3, localObject2, localObject1, localObject5, localObject4 }));
          if ((!TextUtils.isEmpty(str1)) && (localObject4 != null))
          {
            Logger.logD("ArkApp.ArkAppPreloader", String.format("profiling.releasePreloadApplicationAndReload.delay 5s.begin.preload.App=%s", new Object[] { str1 }));
            ((ArkAppPreloader.PreloadAppCallback)localObject4).onReleaseAndReload(str1, 2);
          }
          return;
        }
      }
      ark.Application localApplication = null;
      Object localObject4 = localApplication;
      Object localObject3 = localObject4;
      Object localObject2 = localObject3;
      Object localObject1 = localObject2;
      Object localObject5 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkAppPreloader
 * JD-Core Version:    0.7.0.1
 */