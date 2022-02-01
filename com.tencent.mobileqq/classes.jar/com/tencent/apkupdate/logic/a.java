package com.tencent.apkupdate.logic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends Handler
{
  private static HandlerThread a;
  private static a b;
  private final ArrayList c = new ArrayList();
  private ConcurrentHashMap d = new ConcurrentHashMap();
  private final HashMap e = new HashMap();
  
  private a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private int a(List paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          PackageManager localPackageManager = com.tencent.apkupdate.logic.protocol.a.a().b().getPackageManager();
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            paramList = (AppUpdateInfo)localIterator.next();
            boolean bool = this.e.containsKey(paramList.packageName);
            if (!bool) {
              try
              {
                PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramList.packageName, 0);
                com.tencent.apkupdate.a.a locala = new com.tencent.apkupdate.a.a();
                locala.a(localPackageInfo.applicationInfo.sourceDir);
                ApkFileInfo localApkFileInfo = new ApkFileInfo();
                localApkFileInfo.packageName = localPackageInfo.packageName;
                localApkFileInfo.apkId = paramList.apkId;
                String str = (String)this.d.get(localPackageInfo.packageName);
                paramList = str;
                if (TextUtils.isEmpty(str)) {
                  paramList = com.tencent.apkupdate.logic.protocol.a.a(localPackageInfo.packageName).toLowerCase();
                }
                localApkFileInfo.manifestMd5 = paramList;
                localApkFileInfo.fileCRC32 = locala.a();
                this.e.put(localApkFileInfo.packageName, localApkFileInfo);
              }
              catch (PackageManager.NameNotFoundException paramList)
              {
                paramList.printStackTrace();
              }
            }
          }
          int i = this.e.size();
          return i;
        }
      }
      finally {}
    }
    return 0;
  }
  
  public static a a()
  {
    try
    {
      if (b == null)
      {
        localObject1 = new HandlerThread("apkupdate_asyctask");
        a = (HandlerThread)localObject1;
        ((HandlerThread)localObject1).setPriority(10);
        a.start();
        b = new a(a.getLooper());
      }
      Object localObject1 = b;
      return localObject1;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      int i = this.e.size();
      if (i <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add((ApkFileInfo)this.e.get(this.e.keySet().iterator().next()));
      com.tencent.apkupdate.logic.protocol.a.a().a(new com.tencent.apkupdate.logic.protocol.a.b(localArrayList));
      return;
    }
    finally {}
  }
  
  public final void a(ApkUpdateListener paramApkUpdateListener)
  {
    if (!this.c.contains(paramApkUpdateListener)) {
      this.c.add(paramApkUpdateListener);
    }
  }
  
  public final void b(ApkUpdateListener paramApkUpdateListener)
  {
    if (paramApkUpdateListener == null) {
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if ((ApkUpdateListener)localIterator.next() == paramApkUpdateListener) {
        localIterator.remove();
      }
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 8: 
      if (paramMessage.obj == null)
      {
        b();
        return;
      }
      paramMessage = ((ArrayList)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (String)paramMessage.next();
        a().e.remove(localObject1);
      }
      if (a().e.isEmpty()) {
        return;
      }
      b();
      return;
    case 7: 
      if (a((ArrayList)paramMessage.obj) <= 0) {
        return;
      }
      paramMessage = a().obtainMessage();
      paramMessage.what = 8;
      paramMessage.obj = null;
      paramMessage.sendToTarget();
      return;
    case 6: 
      paramMessage = (ArrayList)paramMessage.obj;
      com.tencent.apkupdate.logic.protocol.a.a().a(new com.tencent.apkupdate.logic.protocol.a.a(paramMessage));
      return;
    case 5: 
      Object localObject2 = (List)paramMessage.obj;
      if (localObject2 != null)
      {
        paramMessage = new ArrayList();
        localObject1 = com.tencent.apkupdate.logic.protocol.a.a().b().getPackageManager();
        long l1 = System.currentTimeMillis();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (ApkUpdateParam)((Iterator)localObject2).next();
          String str = ((ApkUpdateParam)localObject3).packageName;
          int i = ((ApkUpdateParam)localObject3).actionFlag;
          int j = ((ApkUpdateParam)localObject3).targetVersionCode;
          int k = ((ApkUpdateParam)localObject3).targetGrayVersionCode;
          if (!TextUtils.isEmpty(str)) {
            try
            {
              localObject3 = ((PackageManager)localObject1).getPackageInfo(str, 0);
              if (localObject3 != null)
              {
                AppInfoForUpdate localAppInfoForUpdate = new AppInfoForUpdate();
                localAppInfoForUpdate.packageName = str;
                localAppInfoForUpdate.versionCode = ((PackageInfo)localObject3).versionCode;
                localAppInfoForUpdate.signatureMd5 = com.tencent.apkupdate.logic.protocol.a.a().b(str);
                localAppInfoForUpdate.manifestMd5 = com.tencent.apkupdate.logic.protocol.a.a(str).toLowerCase();
                this.d.put(str, localAppInfoForUpdate.manifestMd5);
                if ((((PackageInfo)localObject3).applicationInfo.flags & 0x1) <= 0) {
                  localAppInfoForUpdate.appType = 1;
                } else {
                  localAppInfoForUpdate.appType = 2;
                }
                localAppInfoForUpdate.versionName = ((PackageInfo)localObject3).versionName;
                localAppInfoForUpdate.actionFlag = ((byte)i);
                localAppInfoForUpdate.grayVersionCode = com.tencent.apkupdate.b.b.a().a(str);
                localAppInfoForUpdate.targetVersionCode = j;
                localAppInfoForUpdate.targetGrayVersionCode = k;
                paramMessage.add(localAppInfoForUpdate);
              }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              localNameNotFoundException.printStackTrace();
            }
          }
        }
        long l2 = System.currentTimeMillis();
        localObject1 = new StringBuilder("updatecost=");
        ((StringBuilder)localObject1).append(l2 - l1);
        Log.i("updatecost----------", ((StringBuilder)localObject1).toString());
        if (paramMessage.size() > 0)
        {
          localObject1 = a().obtainMessage();
          ((Message)localObject1).what = 6;
          ((Message)localObject1).obj = paramMessage;
          ((Message)localObject1).sendToTarget();
          return;
        }
        paramMessage = a().obtainMessage();
        paramMessage.what = 2;
        paramMessage.sendToTarget();
      }
    case 3: 
    case 4: 
      return;
    case 2: 
      paramMessage = this.c.iterator();
      while (paramMessage.hasNext()) {
        ((ApkUpdateListener)paramMessage.next()).onCheckUpdateFailed("UNKOWN");
      }
      return;
    }
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ApkUpdateListener)((Iterator)localObject1).next()).onCheckUpdateSucceed((ArrayList)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.a
 * JD-Core Version:    0.7.0.1
 */