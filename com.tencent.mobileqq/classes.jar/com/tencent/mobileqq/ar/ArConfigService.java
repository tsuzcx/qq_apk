package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager;
import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.Constants.LogoutReason;

public class ArConfigService
  extends AppService
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private RemoteCallbackList<IArRemoteCallback> jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  ARGlobalConfigManager jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = null;
  private IArConfigListener jdField_a_of_type_ComTencentMobileqqArIArConfigListener = new ArConfigService.1(this);
  private final IArConfigManager.Stub jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager$Stub = new ArConfigService.ArConfigManagerStub(this);
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.4(this);
  private EarlyDownLoadListener jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownLoadListener = new ArConfigService.3(this);
  Object jdField_a_of_type_JavaLangObject = new Object();
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private RemoteCallbackList<IArFaceCallback> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_b_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.5(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private RemoteCallbackList<IArSoCallback> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_c_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.6(this);
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 100;
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_d_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.7(this);
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 100;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f = true;
  
  public ArConfigService()
  {
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    boolean bool;
    if (c()) {
      bool = true;
    } else {
      bool = b();
    }
    this.jdField_b_of_type_Boolean = bool;
    if (!this.jdField_b_of_type_Boolean)
    {
      ArNativeSoDownloadHandler localArNativeSoDownloadHandler = (ArNativeSoDownloadHandler)((IEarlyDownloadService)this.app.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.ar.native.so_v8.3.6");
      if (localArNativeSoDownloadHandler != null)
      {
        localArNativeSoDownloadHandler.a(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownLoadListener);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localArNativeSoDownloadHandler.a();
        if ((localXmlData != null) && (localXmlData.loadState == 2))
        {
          QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
          localArNativeSoDownloadHandler.a(true, true);
          return;
        }
        localArNativeSoDownloadHandler.a(true);
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 100;
    }
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/tencent/mobileqq/ar/ArConfigService:jdField_c_of_type_AndroidOsRemoteCallbackList	Landroid/os/RemoteCallbackList;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +66 -> 74
    //   11: aload 4
    //   13: invokevirtual 185	android/os/RemoteCallbackList:beginBroadcast	()I
    //   16: istore_3
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: iload_3
    //   21: if_icmpge +27 -> 48
    //   24: aload_0
    //   25: getfield 62	com/tencent/mobileqq/ar/ArConfigService:jdField_c_of_type_AndroidOsRemoteCallbackList	Landroid/os/RemoteCallbackList;
    //   28: iload_2
    //   29: invokevirtual 189	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   32: checkcast 191	com/tencent/mobileqq/ar/aidl/IArSoCallback
    //   35: iload_1
    //   36: invokeinterface 193 2 0
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_2
    //   45: goto -26 -> 19
    //   48: aload_0
    //   49: getfield 62	com/tencent/mobileqq/ar/ArConfigService:jdField_c_of_type_AndroidOsRemoteCallbackList	Landroid/os/RemoteCallbackList;
    //   52: invokevirtual 196	android/os/RemoteCallbackList:finishBroadcast	()V
    //   55: return
    //   56: astore 4
    //   58: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +13 -> 74
    //   64: ldc 111
    //   66: iconst_2
    //   67: ldc 198
    //   69: aload 4
    //   71: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: return
    //   75: astore 4
    //   77: goto -29 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ArConfigService
    //   0	80	1	paramInt	int
    //   18	27	2	i	int
    //   16	6	3	j	int
    //   4	8	4	localRemoteCallbackList	RemoteCallbackList
    //   56	14	4	localException1	Exception
    //   75	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	17	56	java/lang/Exception
    //   48	55	56	java/lang/Exception
    //   24	41	75	java/lang/Exception
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ArNativeSoDownloadHandler)((IEarlyDownloadService)paramAppRuntime.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.ar.native.so_v8.3.6");
    boolean bool2;
    if (paramAppRuntime != null)
    {
      boolean bool4 = paramAppRuntime.g();
      int i = paramAppRuntime.b();
      boolean bool1;
      if ((paramAppRuntime.g()) && (i > 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool5 = ArNativeSoLoader.b("ArMapEngine836");
      boolean bool3 = bool1 & bool5;
      bool2 = bool3;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_ArConfigService", 2, String.format("isArSoDownload isSuccess=%s version=%s fileExist = %s result=%s ", new Object[] { Boolean.valueOf(bool4), Integer.valueOf(i), Boolean.valueOf(bool5), Boolean.valueOf(bool3) }));
        bool2 = bool3;
      }
    }
    else
    {
      bool2 = false;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("isArSoDownload ArNativeSoDownloadHandler so ready:=");
    paramAppRuntime.append(bool2);
    QLog.d("ArConfig_ArConfigService", 1, paramAppRuntime.toString());
    return bool2;
  }
  
  private void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downArCoreSoInternal,mApp is null! ");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
    }
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if (localIArCoreNativeSoLoader == null)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 100;
      return;
    }
    this.jdField_e_of_type_Boolean = d();
    if (!this.jdField_e_of_type_Boolean)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localIArCoreNativeSoLoader.a(), this.jdField_c_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback);
          }
          this.jdField_d_of_type_Int = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downArCoreSoInternal fail!", localException);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.8(this));
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_d_of_type_Int = 100;
    }
  }
  
  private boolean b()
  {
    return a(this.app);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if (localIArCoreNativeSoLoader == null) {
      return true;
    }
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      boolean bool;
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localIArCoreNativeSoLoader.a());
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ArConfig_ArConfigService", 1, "isARCoreSoDownload fail!", paramAppRuntime);
        bool = false;
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isARCoreSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    return false;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArFeatureSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArFeatureSoInternal,mApp is null! ");
      return;
    }
    this.f = e();
    if (!this.f)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback);
          }
          this.jdField_e_of_type_Int = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.9(this));
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_e_of_type_Int = 100;
    }
  }
  
  private static boolean c()
  {
    return ArNativeSoLoader.a("ArMapEngine836");
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    return true;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArCloudSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal,mApp is null! ");
      return;
    }
    this.jdField_c_of_type_Boolean = f();
    if (!this.jdField_c_of_type_Boolean)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback);
          }
          this.jdField_b_of_type_Int = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.10(this));
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_b_of_type_Int = 100;
    }
  }
  
  private boolean d()
  {
    return b(this.app);
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      boolean bool;
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ArConfig_ArConfigService", 1, "isArCloudSoDownload fail!", paramAppRuntime);
        bool = false;
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArCloudSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    return false;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSDK2SoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal,mApp is null! ");
      return;
    }
    this.jdField_d_of_type_Boolean = g();
    if (!this.jdField_d_of_type_Boolean)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback);
          }
          this.jdField_c_of_type_Int = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal fail!", localException);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.11(this));
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_c_of_type_Int = 100;
    }
  }
  
  private boolean e()
  {
    return c(this.app);
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    return (c()) && (d(paramAppRuntime)) && (f(paramAppRuntime)) && (b(paramAppRuntime));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess ");
    }
    RemoteCallbackList localRemoteCallbackList = this.jdField_c_of_type_AndroidOsRemoteCallbackList;
    if (localRemoteCallbackList != null) {}
    for (;;)
    {
      try
      {
        int j = localRemoteCallbackList.beginBroadcast();
        i = 0;
        if (i >= j) {}
      }
      catch (Exception localException1)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess fail!", localException1);
        }
      }
      try
      {
        ((IArSoCallback)this.jdField_c_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
        i += 1;
      }
      catch (Exception localException2) {}
    }
    this.jdField_c_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    return;
  }
  
  private boolean f()
  {
    return d(this.app);
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      boolean bool;
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ArConfig_ArConfigService", 1, "isArSDK2SoDownload fail!", paramAppRuntime);
        bool = false;
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArSDK2SoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    return false;
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/tencent/mobileqq/ar/ArConfigService:jdField_c_of_type_AndroidOsRemoteCallbackList	Landroid/os/RemoteCallbackList;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +63 -> 69
    //   9: aload_3
    //   10: invokevirtual 185	android/os/RemoteCallbackList:beginBroadcast	()I
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpge +26 -> 44
    //   21: aload_0
    //   22: getfield 62	com/tencent/mobileqq/ar/ArConfigService:jdField_c_of_type_AndroidOsRemoteCallbackList	Landroid/os/RemoteCallbackList;
    //   25: iload_1
    //   26: invokevirtual 189	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   29: checkcast 191	com/tencent/mobileqq/ar/aidl/IArSoCallback
    //   32: invokeinterface 401 1 0
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: istore_1
    //   41: goto -25 -> 16
    //   44: aload_0
    //   45: getfield 62	com/tencent/mobileqq/ar/ArConfigService:jdField_c_of_type_AndroidOsRemoteCallbackList	Landroid/os/RemoteCallbackList;
    //   48: invokevirtual 196	android/os/RemoteCallbackList:finishBroadcast	()V
    //   51: return
    //   52: astore_3
    //   53: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +13 -> 69
    //   59: ldc 111
    //   61: iconst_2
    //   62: ldc_w 403
    //   65: aload_3
    //   66: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: return
    //   70: astore_3
    //   71: goto -27 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ArConfigService
    //   15	26	1	i	int
    //   13	6	2	j	int
    //   4	6	3	localRemoteCallbackList	RemoteCallbackList
    //   52	14	3	localException1	Exception
    //   70	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	14	52	java/lang/Exception
    //   44	51	52	java/lang/Exception
    //   21	37	70	java/lang/Exception
  }
  
  private boolean g()
  {
    return f(this.app);
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("ArConfig_ArConfigService", 1, "[onAccountChanged]");
    stopSelf();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager$Stub;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate, ");
      ((StringBuilder)localObject).append(this);
      QLog.d("ArConfig_ArConfigService", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((QQAppInterface)this.app);
      localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "onCreate,mApp is null! ");
        return;
      }
      ArResourceManager localArResourceManager = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localArResourceManager != null) {
        localArResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = ((ARGlobalConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER));
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager;
      if (localObject != null) {
        ((ARGlobalConfigManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
      }
      FaceScanDownloadManager.a(new ArConfigService.2(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, ");
      localStringBuilder.append(this);
      QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_b_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    this.jdField_b_of_type_AndroidOsRemoteCallbackList = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = null;
    FaceScanDownloadManager.a();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    stopSelf();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localObject != null) {
        ((ArResourceManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
      }
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */