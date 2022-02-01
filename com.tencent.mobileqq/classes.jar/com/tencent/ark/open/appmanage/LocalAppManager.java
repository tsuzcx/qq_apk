package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import java.io.File;

public class LocalAppManager
{
  private static final String TAG = "ArkApp.ArkAppMgr";
  
  public static void deleteAllLocalApps()
  {
    String[] arrayOfString = enumInstalledAppName();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      deleteAppByName(arrayOfString[i], true);
      i += 1;
    }
  }
  
  public static void deleteAppByName(String paramString, boolean paramBoolean)
  {
    paramString = Utility.getAppDirByNameAndVersion(paramString);
    int i = 0;
    if (paramBoolean)
    {
      File localFile1 = new File(String.format("%s_%d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
      File localFile2 = new File(paramString);
      if (!localFile2.renameTo(localFile1)) {
        Logger.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, failed to rename, %s->%s", new Object[] { paramString, localFile1 }));
      }
      if (!Utility.deleteFile(localFile1)) {
        Logger.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, failed to delete dir, %s->%s", new Object[] { paramString, localFile1 }));
      }
      if (localFile2.exists()) {
        Logger.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, dir still exists, %s->%s", new Object[] { paramString, localFile1 }));
      }
    }
    else
    {
      paramString = new File(paramString);
      if (paramString.isFile())
      {
        Utility.deleteFile(paramString);
        return;
      }
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = paramString.length;
        while (i < j)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static String[] enumInstalledAppName()
  {
    File[] arrayOfFile = new File(ArkEnvironmentManager.getInstance().getAppInstallDirectory()).listFiles(new LocalAppManager.1());
    int i = 0;
    if ((arrayOfFile != null) && (arrayOfFile.length != 0))
    {
      String[] arrayOfString = new String[arrayOfFile.length];
      while (i < arrayOfFile.length)
      {
        arrayOfString[i] = arrayOfFile[i].getName();
        i += 1;
      }
      return arrayOfString;
    }
    return new String[0];
  }
  
  public static ArkAppMgr.AppPathInfo getLocalAppPathByAppName(String paramString)
  {
    Object localObject2 = Utility.getAppDirByNameAndVersion(paramString);
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/")) {
      localObject1 = ((String)localObject2).concat("/");
    }
    File[] arrayOfFile = new File((String)localObject1).listFiles(new LocalAppManager.2());
    if (arrayOfFile == null) {
      return null;
    }
    int j = arrayOfFile.length;
    localObject1 = null;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      String str = localFile.getName();
      int k = str.lastIndexOf('.');
      if (k >= 0)
      {
        localObject2 = str.substring(k);
        str = str.substring(0, k);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (Utility.isValidAppVersion(str)))
        {
          if (localObject1 == null)
          {
            localObject2 = new ArkAppMgr.AppPathInfo();
            ((ArkAppMgr.AppPathInfo)localObject2).desc.name = paramString;
            ((ArkAppMgr.AppPathInfo)localObject2).desc.version = str;
            ((ArkAppMgr.AppPathInfo)localObject2).path = localFile.getAbsolutePath();
          }
          else
          {
            localObject2 = localObject1;
            if (Utility.compareVersionString(str, ((ArkAppMgr.AppPathInfo)localObject1).desc.version) > 0)
            {
              ((ArkAppMgr.AppPathInfo)localObject1).desc.name = paramString;
              ((ArkAppMgr.AppPathInfo)localObject1).desc.version = str;
              ((ArkAppMgr.AppPathInfo)localObject1).path = localFile.getAbsolutePath();
              localObject2 = localObject1;
            }
          }
          ArkAppCacheMgr.cacheManifestInfo(((ArkAppMgr.AppPathInfo)localObject2).path, paramString);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.LocalAppManager
 * JD-Core Version:    0.7.0.1
 */