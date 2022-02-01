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
import com.tencent.mobileqq.ar.aidl.IArMiniCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager;
import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
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
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.5(this);
  private EarlyDownloadManager.EarlyDownLoadListener jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener = new ArConfigService.4(this);
  Object jdField_a_of_type_JavaLangObject = new Object();
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private RemoteCallbackList<IArFaceCallback> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_b_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.6(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private RemoteCallbackList<IArMiniCallback> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_c_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.7(this);
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private RemoteCallbackList<IArSoCallback> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_d_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new ArConfigService.8(this);
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  public ArConfigService()
  {
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (c()) {}
    ArNativeSoDownloadHandler localArNativeSoDownloadHandler;
    for (boolean bool = true;; bool = b())
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label119;
      }
      localArNativeSoDownloadHandler = (ArNativeSoDownloadHandler)((EarlyDownloadManager)this.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.ar.native.so_v8.3.6");
      if (localArNativeSoDownloadHandler != null)
      {
        localArNativeSoDownloadHandler.a(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localArNativeSoDownloadHandler.a();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localArNativeSoDownloadHandler.a(true, true);
      }
      return;
    }
    localArNativeSoDownloadHandler.a(true);
    return;
    label119:
    this.jdField_a_of_type_Int = 100;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidOsRemoteCallbackList != null) {}
    try
    {
      int j = this.jdField_d_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((IArSoCallback)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
            i += 1;
          }
          catch (Exception localException1) {}
        }
      }
      this.jdField_d_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadProcess fail!", localException2);
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    paramAppRuntime = (ArNativeSoDownloadHandler)((EarlyDownloadManager)paramAppRuntime.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.ar.native.so_v8.3.6");
    boolean bool3;
    int i;
    if (paramAppRuntime != null)
    {
      bool3 = paramAppRuntime.g();
      i = paramAppRuntime.b();
      if ((!paramAppRuntime.g()) || (i <= 0)) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool4 = ArNativeSoLoader.b("ArMapEngine836");
      bool2 = bool1 & bool4;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, String.format("isArSoDownload isSuccess=%s version=%s fileExist = %s result=%s ", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool4), Boolean.valueOf(bool2) }));
      }
      QLog.d("ArConfig_ArConfigService", 1, "isArSoDownload ArNativeSoDownloadHandler so ready:=" + bool2);
      return bool2;
    }
  }
  
  private void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downArCoreSoInternal,mApp is null! ");
    }
    do
    {
      IArCoreNativeSoLoader localIArCoreNativeSoLoader;
      Object localObject;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
        }
        localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
        if (localIArCoreNativeSoLoader == null)
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_d_of_type_Int = 100;
          return;
        }
        this.jdField_e_of_type_Boolean = d();
        if (this.jdField_e_of_type_Boolean) {
          break;
        }
        localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
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
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.9(this));
    this.jdField_a_of_type_Boolean = true;
    return;
    this.jdField_d_of_type_Int = 100;
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
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localIArCoreNativeSoLoader.a());
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArConfigService", 1, "isARCoreSoDownload fail!", paramAppRuntime);
          boolean bool = false;
          continue;
          bool = false;
        }
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isARCoreSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    label118:
    return false;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArFeatureSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArFeatureSoInternal,mApp is null! ");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.f = e();
        if (this.f) {
          break;
        }
        localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
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
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.10(this));
    this.jdField_a_of_type_Boolean = true;
    return;
    this.jdField_e_of_type_Int = 100;
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
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal,mApp is null! ");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.jdField_c_of_type_Boolean = f();
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
        localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
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
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.11(this));
    this.jdField_a_of_type_Boolean = true;
    return;
    this.jdField_b_of_type_Int = 100;
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
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArConfigService", 1, "isArCloudSoDownload fail!", paramAppRuntime);
          boolean bool = false;
          continue;
          bool = false;
        }
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArCloudSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    label105:
    return false;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSDK2SoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal,mApp is null! ");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.jdField_d_of_type_Boolean = g();
        if (this.jdField_d_of_type_Boolean) {
          break;
        }
        localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
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
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.12(this));
    this.jdField_a_of_type_Boolean = true;
    return;
    this.jdField_c_of_type_Int = 100;
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
    if (this.jdField_d_of_type_AndroidOsRemoteCallbackList != null) {}
    try
    {
      int j = this.jdField_d_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      while (i < j) {
        try
        {
          ((IArSoCallback)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
          i += 1;
        }
        catch (Exception localException1) {}
      }
      this.jdField_d_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess fail!", localException2);
    }
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
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.e("ArConfig_ArConfigService", 1, "isArSDK2SoDownload fail!", paramAppRuntime);
          boolean bool = false;
          continue;
          bool = false;
        }
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArSDK2SoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    label105:
    return false;
  }
  
  private void g()
  {
    if (this.jdField_d_of_type_AndroidOsRemoteCallbackList != null) {}
    try
    {
      int j = this.jdField_d_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      while (i < j) {
        try
        {
          ((IArSoCallback)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
          i += 1;
        }
        catch (Exception localException1) {}
      }
      this.jdField_d_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadFail fail!", localException2);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onCreate, " + this);
    }
    QQAppInterface localQQAppInterface;
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((QQAppInterface)this.app);
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQAppInterface == null) {
        QLog.d("ArConfig_ArConfigService", 1, "onCreate,mApp is null! ");
      }
    }
    else
    {
      return;
    }
    ArResourceManager localArResourceManager = (ArResourceManager)localQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localArResourceManager != null) {
      localArResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = ((ARGlobalConfigManager)localQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER));
    if (this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
    }
    FaceScanDownloadManager.a(new ArConfigService.2(this));
    MiniResDownloadManager.a(new ArConfigService.3(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onDestroy, " + this);
    }
    this.jdField_a_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_b_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    this.jdField_b_of_type_AndroidOsRemoteCallbackList = null;
    this.jdField_c_of_type_AndroidOsRemoteCallbackList.kill();
    this.jdField_c_of_type_AndroidOsRemoteCallbackList = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = null;
    FaceScanDownloadManager.a();
    MiniResDownloadManager.a();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */