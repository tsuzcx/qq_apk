package com.tencent.mobileqq.ar;

import android.os.Handler;
import android.os.RemoteCallbackList;
import com.tencent.biz.qrcode.ipc.QrMainProcManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.mobileqq.ar.aidl.IArMiniCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldResInfo;
import dov.com.qq.im.ae.download.old.AEOldResManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;

class ArConfigService$ArConfigManagerStub
  extends IArConfigManager.Stub
{
  WeakReference<ArConfigService> a;
  
  public ArConfigService$ArConfigManagerStub(ArConfigService paramArConfigService)
  {
    QLog.d("ArConfig_ArConfigService", 1, "ArConfigManagerStub constructor");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramArConfigService);
  }
  
  public ARCommonConfigInfo a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "getARCommonConfigInfo error arConfigService is null");
        return null;
      }
      if (((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager.a();; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject }));
        }
        return localObject;
      }
    }
  }
  
  public ArConfigInfo a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "getArConfigInfo error arConfigService is null");
        return null;
      }
      localObject = (QQAppInterface)((ArConfigService)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
        if (localObject == null) {}
      }
      for (localObject = ((ArResourceManager)localObject).a();; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "getArConfigInfo | mConfigInfo = " + localObject);
        }
        return localObject;
      }
    }
  }
  
  public ArEffectConfig a()
  {
    Object localObject2 = null;
    Object localObject3 = null;
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        ArConfigService localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localArConfigService != null) {
          break label52;
        }
        QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService is null");
        localObject2 = localObject3;
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label52:
      do
      {
        for (;;)
        {
          QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error weakArConfigService is null");
          localObject1 = null;
        }
        if (((ArConfigService)localObject1).jdField_a_of_type_JavaLangRefWeakReference == null)
        {
          QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService.weakApp is null");
          return null;
        }
        localObject3 = (QQAppInterface)((ArConfigService)localObject1).jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = (ArResourceManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((ArResourceManager)localObject3).a();
          }
        }
        localObject2 = localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("ArConfig_ArConfigService", 2, "getArEffectConfig|mEffectConfig=" + localObject1);
      return localObject1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject1 = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject1 = null)
    {
      if (localObject1 == null) {
        QLog.d("ArConfig_ArConfigService", 1, "downloadResource error arConfigService is null");
      }
      do
      {
        do
        {
          return;
          localObject1 = (QQAppInterface)((ArConfigService)localObject1).jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject1 == null);
        localObject2 = (ArResourceManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      } while (localObject2 == null);
      ((ArResourceManager)localObject2).a(false, false);
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("click_download", "1");
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(((QQAppInterface)localObject1).getCurrentAccountUin(), "ar_client_download_times", true, 0L, 0L, (HashMap)localObject2, null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadFaceResource error arConfigService is null");
    }
    while (!(ArConfigService.a(localArConfigService) instanceof QQAppInterface)) {
      return;
    }
    FaceScanDownloadManager.a(paramInt, (QQAppInterface)ArConfigService.b(localArConfigService));
    AEOldResManager.a().b(AEOldResInfo.b, new ArConfigService.ArConfigManagerStub.1(this), false);
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localObject == null) {
      QLog.d("ArConfig_ArConfigService", 1, "handleNewConfig error arConfigService is null");
    }
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)((ArConfigService)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    } while (localObject == null);
    ((ArResourceManager)localObject).a(paramArConfigInfo);
  }
  
  public void a(IArFaceCallback paramIArFaceCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
    }
    while ((paramIArFaceCallback == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).register(paramIArFaceCallback);
  }
  
  public void a(IArMiniCallback paramIArMiniCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerMiniCallback error arConfigService is null");
    }
    while ((paramIArMiniCallback == null) || (ArConfigService.c(localArConfigService) == null)) {
      return;
    }
    ArConfigService.c(localArConfigService).register(paramIArMiniCallback);
  }
  
  public void a(IArRemoteCallback paramIArRemoteCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
    }
    while ((paramIArRemoteCallback == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).register(paramIArRemoteCallback);
  }
  
  public void a(IArSoCallback paramIArSoCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
    }
    while (paramIArSoCallback == null) {
      return;
    }
    ArConfigService.d(localArConfigService).register(paramIArSoCallback);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (ArConfigService localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localArConfigService = null)
    {
      if (localArConfigService == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "isFaceResConfigReady error arConfigService is null");
        return false;
      }
      if ((ArConfigService.c(localArConfigService) instanceof QQAppInterface))
      {
        boolean bool = FaceScanDownloadManager.a((QQAppInterface)ArConfigService.d(localArConfigService));
        if (!bool) {
          FaceScanDownloadManager.a((QQAppInterface)ArConfigService.e(localArConfigService));
        }
        return bool;
      }
      return false;
    }
  }
  
  public void b()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localObject == null) {
      QLog.d("ArConfig_ArConfigService", 1, "cancelDownload error arConfigService is null");
    }
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)((ArConfigService)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    } while (localObject == null);
    ((ArResourceManager)localObject).a.a();
  }
  
  public void b(int paramInt)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadMiniResource error arConfigService is null");
    }
    while (!(ArConfigService.f(localArConfigService) instanceof QQAppInterface)) {
      return;
    }
    MiniResDownloadManager.a(paramInt, (QQAppInterface)ArConfigService.g(localArConfigService));
  }
  
  public void b(IArFaceCallback paramIArFaceCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
    }
    while ((paramIArFaceCallback == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).unregister(paramIArFaceCallback);
  }
  
  public void b(IArMiniCallback paramIArMiniCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterMiniCallback error arConfigService is null");
    }
    while ((paramIArMiniCallback == null) || (ArConfigService.c(localArConfigService) == null)) {
      return;
    }
    ArConfigService.c(localArConfigService).unregister(paramIArMiniCallback);
  }
  
  public void b(IArRemoteCallback paramIArRemoteCallback)
  {
    QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback");
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
    }
    while ((paramIArRemoteCallback == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).unregister(paramIArRemoteCallback);
  }
  
  public void b(IArSoCallback paramIArSoCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
    }
    while (paramIArSoCallback == null) {
      return;
    }
    ArConfigService.d(localArConfigService).unregister(paramIArSoCallback);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (ArConfigService localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localArConfigService = null)
    {
      if (localArConfigService == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "isMiniResConfigReady error arConfigService is null");
        return false;
      }
      if ((ArConfigService.h(localArConfigService) instanceof QQAppInterface))
      {
        boolean bool = MiniResDownloadManager.a(true, (QQAppInterface)ArConfigService.i(localArConfigService));
        if (!bool) {
          MiniResDownloadManager.a(true, (QQAppInterface)ArConfigService.j(localArConfigService));
        }
        if (!MiniResDownloadManager.a(false, (QQAppInterface)ArConfigService.k(localArConfigService))) {
          MiniResDownloadManager.a(false, (QQAppInterface)ArConfigService.l(localArConfigService));
        }
        return bool;
      }
      return false;
    }
  }
  
  public void c()
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSo error arConfigService is null");
    }
    int i;
    do
    {
      do
      {
        return;
        ArConfigService.a(localArConfigService, false);
        ArConfigService.a(localArConfigService);
        ArConfigService.b(localArConfigService);
        ArConfigService.c(localArConfigService);
        ArConfigService.d(localArConfigService);
        ArConfigService.e(localArConfigService);
      } while (ArConfigService.e(localArConfigService));
      i = (ArConfigService.a(localArConfigService) + ArConfigService.b(localArConfigService) + ArConfigService.c(localArConfigService) + ArConfigService.d(localArConfigService) + ArConfigService.e(localArConfigService)) / 5;
      ArConfigService.a(localArConfigService).post(new ArConfigService.ArConfigManagerStub.2(this, localArConfigService, i));
    } while (i != 100);
    ArConfigService.a(localArConfigService).post(new ArConfigService.ArConfigManagerStub.3(this, localArConfigService));
  }
  
  public void c(int paramInt)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localObject == null) {
      QLog.d("ArConfig_ArConfigService", 1, "onToolScannerActivityStateChanged error arConfigService is null");
    }
    do
    {
      return;
      localObject = (QrMainProcManager)ArConfigService.m((ArConfigService)localObject).getManager(QQManagerFactory.QR_MAIN_PROC_MANAGER);
    } while (localObject == null);
    ((QrMainProcManager)localObject).a(paramInt);
  }
  
  public boolean c()
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "isArSoReady error arConfigService is null");
      return false;
    }
    if ((ArConfigService.a()) && (ArConfigService.a(localArConfigService)) && (ArConfigService.b(localArConfigService)) && (ArConfigService.c(localArConfigService)) && (ArConfigService.d(localArConfigService))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void d()
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArCoreSo error arConfigService is null");
      return;
    }
    ArConfigService.d(localArConfigService);
  }
  
  public boolean d()
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "isArCoreSoReady error arConfigService is null");
      return false;
    }
    return ArConfigService.c(localArConfigService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub
 * JD-Core Version:    0.7.0.1
 */