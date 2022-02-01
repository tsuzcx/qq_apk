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
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected volatile ARCommonConfigInfo a;
  private final Vector<WeakReference<IArConfigListener>> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public ARGlobalConfigManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "ARGlobalConfigManager constructor");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ar_global_config");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    ThreadManager.post(new ARGlobalConfigManager.1(this), 8, null, true);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("ar_global_app_version", 0);
  }
  
  public ARScanAR a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "getQQArEntryTypeInfo");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "config is null");
      }
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.arControllers.iterator();
    while (localIterator.hasNext())
    {
      ARScanAR localARScanAR = (ARScanAR)localIterator.next();
      if (localARScanAR.jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARGlobalConfigManager", 2, "config is found");
        }
        return localARScanAR;
      }
    }
    return null;
  }
  
  public ARCommonConfigInfo a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null) {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            return null;
          }
          QLog.d("AREngine_ARGlobalConfigManager", 2, "getArCommonConfigInfo load config from file.");
          this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = ARCommonConfigInfo.loadConfigFromFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
        finally {}
      }
      QLog.d("AREngine_ARGlobalConfigManager", 2, String.format("getArCommonConfigInfo mConfigInfo=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo }));
      ARCommonConfigInfo localARCommonConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
      return localARCommonConfigInfo;
    }
    finally {}
  }
  
  public ARCommonConfigInfo a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    }
    if (paramBoolean) {
      a();
    } else {
      ThreadManager.postImmediately(new ARGlobalConfigManager.2(this), null, false);
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
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
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("ar_global_app_version", i).commit();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("ar_global_key_config_version", paramInt).commit();
  }
  
  public void a(IArConfigListener paramIArConfigListener)
  {
    if (paramIArConfigListener != null) {
      this.jdField_a_of_type_JavaUtilVector.add(new WeakReference(paramIArConfigListener));
    }
  }
  
  public boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    try
    {
      int i = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionCode;
      int j = a();
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
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = 0;
        if ((localQQAppInterface == null) || (!ARCommonConfigInfo.saveArConfigToFile(???, localQQAppInterface.getCurrentAccountUin()))) {
          continue;
        }
        Object localObject4 = new ArrayList();
        Object localObject3 = new ArrayList();
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
        {
          localObject1 = localObject4;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = ARCommonConfigInfo.parseArConfig(???);
        ??? = SharedPreferencesProxyManager.getInstance().getProxy("qrcode", 0).edit();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("ar_guide_b_showed_c");
        ((StringBuilder)localObject4).append(localQQAppInterface.getCurrentAccountUin());
        ???.putInt(((StringBuilder)localObject4).toString(), 0).commit();
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "parseArconfigxml fail");
          }
          b();
          return false;
        }
        ??? = (String)localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
        {
          ??? = (String)localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
            ??? = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
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
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
          {
            ((IArConfigListener)((WeakReference)localObject1).get()).a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
            continue;
          }
          this.jdField_a_of_type_JavaUtilVector.remove(i);
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
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("ar_global_key_config_version", 0);
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "clearArConfigInfo");
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
      a(0);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "after delete ARConfig, we should remove serverVersionCode");
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localQQAppInterface == null) {
        return;
      }
      ARCommonConfigInfo.deleteConfigFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    ARScanAR localARScanAR = a();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (localARScanAR == null) {
      return false;
    }
    if ((localARScanAR.jdField_a_of_type_Long <= l) && (l <= localARScanAR.b)) {
      return true;
    }
    QLog.d("AREngine_ARGlobalConfigManager", 1, "isShowArPort | getQQArEntryTypeInfo out of date !");
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalConfigManager
 * JD-Core Version:    0.7.0.1
 */