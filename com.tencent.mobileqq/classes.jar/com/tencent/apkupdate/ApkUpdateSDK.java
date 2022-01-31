package com.tencent.apkupdate;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Message;
import com.tencent.apkupdate.a.d;
import com.tencent.apkupdate.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApkUpdateSDK
{
  private static ApkUpdateSDK instance = null;
  
  public static String about()
  {
    return "ApkUpdateSDK_20140409144158_release_31238";
  }
  
  public static ApkUpdateSDK getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new ApkUpdateSDK();
      }
      ApkUpdateSDK localApkUpdateSDK = instance;
      return localApkUpdateSDK;
    }
    finally {}
  }
  
  public void addListener(ApkUpdateListener paramApkUpdateListener)
  {
    com.tencent.apkupdate.logic.a.a().a(paramApkUpdateListener);
  }
  
  public void checkUpdate(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new ApkUpdateParam((String)paramList.next(), 0, 0));
      }
      checkUpdateList(localArrayList);
    }
  }
  
  public void checkUpdateList(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Message localMessage = com.tencent.apkupdate.logic.a.a().obtainMessage();
      localMessage.what = 5;
      localMessage.obj = paramList;
      localMessage.sendToTarget();
    }
  }
  
  public void destory()
  {
    com.tencent.apkupdate.logic.protocol.a.a().c();
  }
  
  public void init(Context paramContext)
  {
    com.tencent.apkupdate.logic.protocol.a.a().a(paramContext);
    b.a().a(paramContext);
  }
  
  public int patchNewApk(String paramString1, String paramString2, String paramString3)
  {
    return d.b(paramString1, paramString2, paramString3);
  }
  
  public int patchNewApkByPath(String paramString1, String paramString2, String paramString3)
  {
    PackageManager localPackageManager = com.tencent.apkupdate.logic.protocol.a.a().b().getPackageManager();
    int j = new d().a(paramString1, paramString2, paramString3);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (localPackageManager.getPackageArchiveInfo(paramString3, 1) == null) {
        i = -11;
      }
    }
    return i;
  }
  
  public void removeListener(ApkUpdateListener paramApkUpdateListener)
  {
    com.tencent.apkupdate.logic.a.a().b(paramApkUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.apkupdate.ApkUpdateSDK
 * JD-Core Version:    0.7.0.1
 */