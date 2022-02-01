package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.manager.Manager;

public class ARGlobalConfigManager
  implements Manager
{
  SharedPreferences a;
  protected volatile ARCommonConfigInfo b;
  private QQAppInterface c;
  private final Vector<WeakReference<IArConfigListener>> d = new Vector();
  
  public ARGlobalConfigManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "ARGlobalConfigManager constructor");
    }
    this.c = paramQQAppInterface;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ar_global_config");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    this.a = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    ThreadManager.post(new ARGlobalConfigManager.1(this), 8, null, true);
  }
  
  public ARCommonConfigInfo a(boolean paramBoolean)
  {
    if (this.b != null) {
      return this.b;
    }
    if (paramBoolean) {
      d();
    } else {
      ThreadManager.postImmediately(new ARGlobalConfigManager.2(this), null, false);
    }
    return this.b;
  }
  
  public void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    int i = 0;
    try
    {
      int j = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    this.a.edit().putInt("ar_global_app_version", i).commit();
  }
  
  public void a(int paramInt)
  {
    this.a.edit().putInt("ar_global_key_config_version", paramInt).commit();
  }
  
  public void a(IArConfigListener paramIArConfigListener)
  {
    if (paramIArConfigListener != null) {
      this.d.add(new WeakReference(paramIArConfigListener));
    }
  }
  
  public boolean a(String arg1)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateArConfigInfo | config = ");
          ((StringBuilder)localObject1).append(???);
          QLog.d("AREngine_ARGlobalConfigManager", 2, ((StringBuilder)localObject1).toString());
        }
        QQAppInterface localQQAppInterface = this.c;
        i = 0;
        if ((localQQAppInterface == null) || (!ARCommonConfigInfo.saveArConfigToFile(???, localQQAppInterface.getCurrentAccountUin()))) {
          continue;
        }
        Object localObject4 = new ArrayList();
        Object localObject3 = new ArrayList();
        localObject1 = localObject4;
        if (this.b != null)
        {
          localObject1 = localObject4;
          if (this.b.nativeSoResList != null) {
            localObject1 = this.b.nativeSoResList;
          }
        }
        this.b = ARCommonConfigInfo.parseArConfig(???);
        ??? = SharedPreferencesProxyManager.getInstance().getProxy("qrcode", 0).edit();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("ar_guide_b_showed_c");
        ((StringBuilder)localObject4).append(localQQAppInterface.getCurrentAccountUin());
        ???.putInt(((StringBuilder)localObject4).toString(), 0).commit();
        if (this.b == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "parseArconfigxml fail");
          }
          e();
          return false;
        }
        ??? = (String)localObject3;
        if (this.b != null)
        {
          ??? = (String)localObject3;
          if (this.b.nativeSoResList != null) {
            ??? = this.b.nativeSoResList;
          }
        }
        localObject3 = new ArNativeSoManager(localQQAppInterface);
        ((ArNativeSoManager)localObject3).a((ArrayList)localObject1, ???, "arsdk2");
        ((ArNativeSoManager)localObject3).a((ArrayList)localObject1, ???, "arcloud");
      }
      finally
      {
        Object localObject1;
        int i;
        continue;
        throw ???;
        continue;
        i += 1;
        continue;
      }
      synchronized (this.d)
      {
        if (i < this.d.size())
        {
          localObject1 = (WeakReference)this.d.get(i);
          if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
          {
            ((IArConfigListener)((WeakReference)localObject1).get()).a(this.b);
            continue;
          }
          this.d.remove(i);
          i -= 1;
          continue;
        }
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.a.getInt("ar_global_app_version", 0);
  }
  
  public boolean c()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    try
    {
      int i = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionCode;
      int j = b();
      if (j != 0)
      {
        if (i != j) {
          return false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AppVersionEqualsLocalVersion version code is  ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("local version type is ");
        ((StringBuilder)localObject).append(j);
        QLog.d("AREngine_ARGlobalConfigManager", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion error happen");
    }
    return true;
  }
  
  public ARCommonConfigInfo d()
  {
    try
    {
      if (this.b == null) {
        try
        {
          if (this.c == null) {
            return null;
          }
          QLog.d("AREngine_ARGlobalConfigManager", 2, "getArCommonConfigInfo load config from file.");
          this.b = ARCommonConfigInfo.loadConfigFromFile(this.c.getAccount());
        }
        finally {}
      }
      QLog.d("AREngine_ARGlobalConfigManager", 2, String.format("getArCommonConfigInfo mConfigInfo=%s", new Object[] { this.b }));
      ARCommonConfigInfo localARCommonConfigInfo = this.b;
      return localARCommonConfigInfo;
    }
    finally {}
  }
  
  public void e()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "clearArConfigInfo");
      }
      this.b = null;
      a(0);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "after delete ARConfig, we should remove serverVersionCode");
      }
      QQAppInterface localQQAppInterface = this.c;
      if (localQQAppInterface == null) {
        return;
      }
      ARCommonConfigInfo.deleteConfigFile(this.c.getCurrentAccountUin());
      return;
    }
    finally {}
  }
  
  public int f()
  {
    return this.a.getInt("ar_global_key_config_version", 0);
  }
  
  public ARScanAR g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "getQQArEntryTypeInfo");
    }
    d();
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "config is null");
      }
      return null;
    }
    Iterator localIterator = this.b.arControllers.iterator();
    while (localIterator.hasNext())
    {
      ARScanAR localARScanAR = (ARScanAR)localIterator.next();
      if (localARScanAR.a == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARGlobalConfigManager", 2, "config is found");
        }
        return localARScanAR;
      }
    }
    return null;
  }
  
  public boolean h()
  {
    ARScanAR localARScanAR = g();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (localARScanAR == null) {
      return false;
    }
    if ((localARScanAR.b <= l) && (l <= localARScanAR.c)) {
      return true;
    }
    QLog.d("AREngine_ARGlobalConfigManager", 1, "isShowArPort | getQQArEntryTypeInfo out of date !");
    return false;
  }
  
  public void onDestroy()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalConfigManager
 * JD-Core Version:    0.7.0.1
 */