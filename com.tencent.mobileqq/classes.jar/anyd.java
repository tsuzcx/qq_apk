import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGlobalConfigManager.1;
import com.tencent.mobileqq.ar.ARGlobalConfigManager.2;
import com.tencent.mobileqq.ar.ARScanAR;
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

public class anyd
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected volatile ARCommonConfigInfo a;
  volatile ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
  private final Vector<WeakReference<aodu>> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public anyd(QQAppInterface paramQQAppInterface)
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
    //   3: getfield 101	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   6: ifnonnull +29 -> 35
    //   9: aload_0
    //   10: monitorenter
    //   11: ldc 31
    //   13: iconst_2
    //   14: ldc 133
    //   16: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 39	anyd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   27: invokestatic 137	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:loadConfigFromFile	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   30: putfield 101	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc 31
    //   37: iconst_2
    //   38: ldc 139
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 101	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   50: aastore
    //   51: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 101	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	anyd
    //   61	4	1	localARCommonConfigInfo	ARCommonConfigInfo
    //   66	4	1	localObject1	Object
    //   71	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	35	66	finally
    //   67	69	66	finally
    //   2	11	71	finally
    //   35	62	71	finally
    //   69	71	71	finally
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
    //   3: getfield 155	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   6: ifnonnull +29 -> 35
    //   9: aload_0
    //   10: monitorenter
    //   11: ldc 31
    //   13: iconst_2
    //   14: ldc 157
    //   16: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 39	anyd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   27: invokestatic 162	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   30: putfield 155	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc 31
    //   37: iconst_2
    //   38: ldc 164
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 155	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   50: aastore
    //   51: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 155	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	anyd
    //   61	4	1	localARScanStarFaceConfigInfo	ARScanStarFaceConfigInfo
    //   66	4	1	localObject1	Object
    //   71	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	35	66	finally
    //   67	69	66	finally
    //   2	11	71	finally
    //   35	62	71	finally
    //   69	71	71	finally
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
  
  public void a(aodu paramaodu)
  {
    if (paramaodu != null) {
      this.jdField_a_of_type_JavaUtilVector.add(new WeakReference(paramaodu));
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
        boolean bool1 = bool2;
        Object localObject1;
        if (ARCommonConfigInfo.saveArConfigToFile(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
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
          SharedPreferencesProxyManager.getInstance().getProxy("qrcode", 0).edit().putInt("ar_guide_b_showed_c" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).commit();
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARGlobalConfigManager", 2, "parseArconfigxml fail");
            }
            b();
            bool1 = bool2;
          }
        }
        else
        {
          return bool1;
        }
        paramString = (String)localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
        {
          paramString = (String)localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
            paramString = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
          }
        }
        Object localObject3 = new aocz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((aocz)localObject3).a((ArrayList)localObject1, paramString, "arsdk2");
        ((aocz)localObject3).a((ArrayList)localObject1, paramString, "arcloud");
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
              ((aodu)((WeakReference)localObject1).get()).a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
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
      ARCommonConfigInfo.deleteConfigFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    finally {}
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
    //   20: ldc_w 324
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iload_3
    //   37: istore_2
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 39	anyd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 238	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: invokestatic 326	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   49: ifeq +39 -> 88
    //   52: aload_0
    //   53: aload_1
    //   54: invokestatic 328	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   57: putfield 155	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   60: aload_0
    //   61: getfield 155	anyd:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   64: ifnonnull +28 -> 92
    //   67: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +12 -> 82
    //   73: ldc 31
    //   75: iconst_2
    //   76: ldc_w 330
    //   79: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: invokevirtual 333	anyd:c	()V
    //   86: iload_3
    //   87: istore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: iload_2
    //   91: ireturn
    //   92: iconst_1
    //   93: istore_2
    //   94: goto -6 -> 88
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	anyd
    //   0	102	1	paramString	String
    //   37	57	2	bool1	boolean
    //   1	86	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	36	97	finally
    //   38	82	97	finally
    //   82	86	97	finally
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("ar_scan_star_face_config_version", 0);
  }
  
  public void c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "clearScanStarFaceConfigInfo");
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = null;
      ARScanStarFaceConfigInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyd
 * JD-Core Version:    0.7.0.1
 */