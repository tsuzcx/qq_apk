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
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
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
  volatile ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
  private final Vector<WeakReference<IArConfigListener>> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public ARGlobalConfigManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "ARGlobalConfigManager constructor");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("ar_global_config" + paramQQAppInterface.getAccount(), 0);
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
    a();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "config is null");
      }
      localObject = null;
    }
    ARScanAR localARScanAR;
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.arControllers.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localARScanAR = (ARScanAR)((Iterator)localObject).next();
      } while (localARScanAR.jdField_a_of_type_Int != 1);
      localObject = localARScanAR;
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_ARGlobalConfigManager", 2, "config is found");
    return localARScanAR;
    return null;
  }
  
  /* Error */
  public ARCommonConfigInfo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   6: ifnonnull +44 -> 50
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: ldc 31
    //   28: iconst_2
    //   29: ldc 133
    //   31: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 137	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:loadConfigFromFile	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   45: putfield 101	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   48: aload_0
    //   49: monitorexit
    //   50: ldc 31
    //   52: iconst_2
    //   53: ldc 139
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 101	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   65: aastore
    //   66: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: getfield 101	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   76: astore_1
    //   77: goto -55 -> 22
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ARGlobalConfigManager
    //   19	58	1	localARCommonConfigInfo	ARCommonConfigInfo
    //   80	4	1	localObject1	Object
    //   85	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	80	finally
    //   20	22	80	finally
    //   26	50	80	finally
    //   81	83	80	finally
    //   2	11	85	finally
    //   50	77	85	finally
    //   83	85	85	finally
  }
  
  public ARCommonConfigInfo a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    }
    if (paramBoolean) {
      a();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
      ThreadManager.postImmediately(new ARGlobalConfigManager.2(this), null, false);
    }
  }
  
  /* Error */
  public ARScanStarFaceConfigInfo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   6: ifnonnull +52 -> 58
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: ifnonnull +19 -> 34
    //   18: ldc 31
    //   20: iconst_1
    //   21: ldc 157
    //   23: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: ldc 31
    //   36: iconst_2
    //   37: ldc 159
    //   39: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   50: invokestatic 164	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   53: putfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   56: aload_0
    //   57: monitorexit
    //   58: ldc 31
    //   60: iconst_2
    //   61: ldc 166
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   73: aastore
    //   74: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: getfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   84: astore_1
    //   85: goto -55 -> 30
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	ARGlobalConfigManager
    //   27	58	1	localARScanStarFaceConfigInfo	ARScanStarFaceConfigInfo
    //   88	4	1	localObject1	Object
    //   93	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	26	88	finally
    //   28	30	88	finally
    //   34	58	88	finally
    //   89	91	88	finally
    //   2	11	93	finally
    //   58	85	93	finally
    //   91	93	93	finally
  }
  
  public void a()
  {
    int i = 0;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    try
    {
      int j = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
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
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    try
    {
      int i = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
      int j = a();
      if (j == 0) {
        break label88;
      }
      if (i != j) {
        return false;
      }
      QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion version code is  " + i + "local version type is " + j);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion error happen");
      }
    }
    return true;
    label88:
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARGlobalConfigManager", 2, "updateArConfigInfo | config = " + paramString);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        boolean bool1 = bool2;
        Object localObject1;
        if (localQQAppInterface != null)
        {
          bool1 = bool2;
          if (ARCommonConfigInfo.saveArConfigToFile(paramString, localQQAppInterface.getCurrentAccountUin()))
          {
            ArrayList localArrayList = new ArrayList();
            localObject3 = new ArrayList();
            localObject1 = localArrayList;
            if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
            {
              localObject1 = localArrayList;
              if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = ARCommonConfigInfo.parseArConfig(paramString);
            SharedPreferencesProxyManager.getInstance().getProxy("qrcode", 0).edit().putInt("ar_guide_b_showed_c" + localQQAppInterface.getCurrentAccountUin(), 0).commit();
            if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARGlobalConfigManager", 2, "parseArconfigxml fail");
            }
            b();
            bool1 = bool2;
          }
        }
        return bool1;
        paramString = (String)localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
        {
          paramString = (String)localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
            paramString = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
          }
        }
        Object localObject3 = new ArNativeSoManager(localQQAppInterface);
        ((ArNativeSoManager)localObject3).a((ArrayList)localObject1, paramString, "arsdk2");
        ((ArNativeSoManager)localObject3).a((ArrayList)localObject1, paramString, "arcloud");
        paramString = this.jdField_a_of_type_JavaUtilVector;
        int i = 0;
        try
        {
          if (i < this.jdField_a_of_type_JavaUtilVector.size())
          {
            localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
            if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
            {
              localObject1 = this.jdField_a_of_type_JavaUtilVector;
              int j = i - 1;
              ((Vector)localObject1).remove(i);
              i = j;
            }
            else
            {
              ((IArConfigListener)((WeakReference)localObject1).get()).a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
            }
          }
          else
          {
            bool1 = true;
            continue;
          }
        }
        finally {}
        i += 1;
      }
      finally {}
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("ar_global_key_config_version", 0);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 31
    //   10: iconst_2
    //   11: ldc_w 299
    //   14: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 101	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   22: aload_0
    //   23: iconst_0
    //   24: invokevirtual 301	com/tencent/mobileqq/ar/ARGlobalConfigManager:a	(I)V
    //   27: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +12 -> 42
    //   33: ldc 31
    //   35: iconst_2
    //   36: ldc_w 303
    //   39: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnonnull +6 -> 54
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokevirtual 240	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   61: invokestatic 307	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:deleteConfigFile	(Ljava/lang/String;)V
    //   64: goto -13 -> 51
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	ARGlobalConfigManager
    //   46	2	1	localQQAppInterface	QQAppInterface
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	67	finally
    //   17	42	67	finally
    //   42	47	67	finally
    //   54	64	67	finally
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("ar_scan_star_face_config_version", paramInt).commit();
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
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 31
    //   12: iconst_2
    //   13: new 47	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 326
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: astore 4
    //   42: iload_3
    //   43: istore_2
    //   44: aload 4
    //   46: ifnull +53 -> 99
    //   49: iload_3
    //   50: istore_2
    //   51: aload_1
    //   52: aload 4
    //   54: invokevirtual 240	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   57: invokestatic 328	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   60: ifeq +39 -> 99
    //   63: aload_0
    //   64: aload_1
    //   65: invokestatic 330	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   68: putfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   71: aload_0
    //   72: getfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   75: ifnonnull +28 -> 103
    //   78: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +12 -> 93
    //   84: ldc 31
    //   86: iconst_2
    //   87: ldc_w 332
    //   90: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_0
    //   94: invokevirtual 335	com/tencent/mobileqq/ar/ARGlobalConfigManager:c	()V
    //   97: iload_3
    //   98: istore_2
    //   99: aload_0
    //   100: monitorexit
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -6 -> 99
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ARGlobalConfigManager
    //   0	113	1	paramString	String
    //   43	62	2	bool1	boolean
    //   1	97	3	bool2	boolean
    //   40	13	4	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   4	36	108	finally
    //   36	42	108	finally
    //   51	93	108	finally
    //   93	97	108	finally
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("ar_scan_star_face_config_version", 0);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 31
    //   10: iconst_2
    //   11: ldc_w 337
    //   14: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 155	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   22: aload_0
    //   23: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +6 -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 39	com/tencent/mobileqq/ar/ARGlobalConfigManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokevirtual 240	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   41: invokestatic 339	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:a	(Ljava/lang/String;)V
    //   44: goto -13 -> 31
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ARGlobalConfigManager
    //   26	2	1	localQQAppInterface	QQAppInterface
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	47	finally
    //   17	27	47	finally
    //   34	44	47	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalConfigManager
 * JD-Core Version:    0.7.0.1
 */