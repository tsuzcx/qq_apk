package com.tencent.mobileqq.ar;

import android.os.Handler;
import android.os.RemoteCallbackList;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.download.old.api.IAEOldResDownload;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanMainProcService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
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
    this.a = new WeakReference(paramArConfigService);
  }
  
  public ArConfigInfo a()
  {
    Object localObject1 = this.a;
    StringBuilder localStringBuilder = null;
    if (localObject1 != null) {
      localObject1 = (ArConfigService)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "getArConfigInfo error arConfigService is null");
      return null;
    }
    Object localObject2 = (QQAppInterface)((ArConfigService)localObject1).a.get();
    localObject1 = localStringBuilder;
    if (localObject2 != null)
    {
      localObject2 = (ArResourceManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      localObject1 = localStringBuilder;
      if (localObject2 != null) {
        localObject1 = ((ArResourceManager)localObject2).a();
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getArConfigInfo | mConfigInfo = ");
      localStringBuilder.append(localObject1);
      QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadFaceResource error arConfigService is null");
      return;
    }
    if ((ArConfigService.c((ArConfigService)localObject) instanceof QQAppInterface))
    {
      FaceScanDownloadManager.a(paramInt, (QQAppInterface)ArConfigService.d((ArConfigService)localObject));
      ((IAEOldResDownload)QRoute.api(IAEOldResDownload.class)).requestDownload(AEOldResInfo.b, new ArConfigService.ArConfigManagerStub.1(this), false);
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "handleNewConfig error arConfigService is null");
      return;
    }
    localObject = (QQAppInterface)((ArConfigService)localObject).a.get();
    if (localObject != null)
    {
      localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localObject != null) {
        ((ArResourceManager)localObject).b(paramArConfigInfo);
      }
    }
  }
  
  public void a(IArFaceCallback paramIArFaceCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
      return;
    }
    if ((paramIArFaceCallback != null) && (ArConfigService.b((ArConfigService)localObject) != null)) {
      ArConfigService.b((ArConfigService)localObject).register(paramIArFaceCallback);
    }
  }
  
  public void a(IArRemoteCallback paramIArRemoteCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
      return;
    }
    if ((paramIArRemoteCallback != null) && (ArConfigService.a((ArConfigService)localObject) != null)) {
      ArConfigService.a((ArConfigService)localObject).register(paramIArRemoteCallback);
    }
  }
  
  public void a(IArSoCallback paramIArSoCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
      return;
    }
    if (paramIArSoCallback != null) {
      ArConfigService.y((ArConfigService)localObject).register(paramIArSoCallback);
    }
  }
  
  public ArEffectConfig b()
  {
    StringBuilder localStringBuilder = null;
    try
    {
      if (this.a == null) {
        break label31;
      }
      localObject1 = (ArConfigService)this.a.get();
    }
    catch (Exception localException)
    {
      Object localObject1;
      label23:
      Object localObject2;
      break label23;
    }
    QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error weakArConfigService is null");
    label31:
    localObject1 = null;
    if (localObject1 == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService is null");
      return null;
    }
    if (((ArConfigService)localObject1).a == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService.weakApp is null");
      return null;
    }
    localObject2 = (QQAppInterface)((ArConfigService)localObject1).a.get();
    localObject1 = localStringBuilder;
    if (localObject2 != null)
    {
      localObject2 = (ArResourceManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      localObject1 = localStringBuilder;
      if (localObject2 != null) {
        localObject1 = ((ArResourceManager)localObject2).c();
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getArEffectConfig|mEffectConfig=");
      localStringBuilder.append(localObject1);
      QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "onToolScannerActivityStateChanged error arConfigService is null");
      return;
    }
    localObject = (IQRScanMainProcService)ArConfigService.z((ArConfigService)localObject).getRuntimeService(IQRScanMainProcService.class, "");
    if (localObject != null) {
      ((IQRScanMainProcService)localObject).onToolScannerActivityStateChanged(paramInt);
    }
  }
  
  public void b(IArFaceCallback paramIArFaceCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
      return;
    }
    if ((paramIArFaceCallback != null) && (ArConfigService.b((ArConfigService)localObject) != null)) {
      ArConfigService.b((ArConfigService)localObject).unregister(paramIArFaceCallback);
    }
  }
  
  public void b(IArRemoteCallback paramIArRemoteCallback)
  {
    QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback");
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
      return;
    }
    if ((paramIArRemoteCallback != null) && (ArConfigService.a((ArConfigService)localObject) != null)) {
      ArConfigService.a((ArConfigService)localObject).unregister(paramIArRemoteCallback);
    }
  }
  
  public void b(IArSoCallback paramIArSoCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
      return;
    }
    if (paramIArSoCallback != null) {
      ArConfigService.y((ArConfigService)localObject).unregister(paramIArSoCallback);
    }
  }
  
  public ARCommonConfigInfo c()
  {
    Object localObject = this.a;
    ARCommonConfigInfo localARCommonConfigInfo = null;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "getARCommonConfigInfo error arConfigService is null");
      return null;
    }
    if (((ArConfigService)localObject).b != null) {
      localARCommonConfigInfo = ((ArConfigService)localObject).b.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localARCommonConfigInfo }));
    }
    return localARCommonConfigInfo;
  }
  
  public void d()
  {
    Object localObject1 = this.a;
    if (localObject1 != null) {
      localObject1 = (ArConfigService)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadResource error arConfigService is null");
      return;
    }
    localObject1 = (QQAppInterface)((ArConfigService)localObject1).a.get();
    if (localObject1 != null)
    {
      Object localObject2 = (ArResourceManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localObject2 != null)
      {
        ((ArResourceManager)localObject2).a(false, false);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("click_download", "1");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(((QQAppInterface)localObject1).getCurrentAccountUin(), "ar_client_download_times", true, 0L, 0L, (HashMap)localObject2, null);
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "cancelDownload error arConfigService is null");
      return;
    }
    localObject = (QQAppInterface)((ArConfigService)localObject).a.get();
    if (localObject != null)
    {
      localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localObject != null) {
        ((ArResourceManager)localObject).e.a();
      }
    }
  }
  
  public boolean f()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    boolean bool1 = false;
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "isFaceResConfigReady error arConfigService is null");
      return false;
    }
    if ((ArConfigService.e((ArConfigService)localObject) instanceof QQAppInterface))
    {
      boolean bool2 = FaceScanDownloadManager.a((QQAppInterface)ArConfigService.f((ArConfigService)localObject));
      bool1 = bool2;
      if (!bool2)
      {
        FaceScanDownloadManager.b((QQAppInterface)ArConfigService.g((ArConfigService)localObject));
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean g()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    boolean bool2 = false;
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "isArSoReady error arConfigService is null");
      return false;
    }
    boolean bool1 = bool2;
    if (ArConfigService.a())
    {
      bool1 = bool2;
      if (ArConfigService.h((ArConfigService)localObject))
      {
        bool1 = bool2;
        if (ArConfigService.i((ArConfigService)localObject))
        {
          bool1 = bool2;
          if (ArConfigService.j((ArConfigService)localObject))
          {
            bool1 = bool2;
            if (ArConfigService.k((ArConfigService)localObject)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void h()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSo error arConfigService is null");
      return;
    }
    ArConfigService.a((ArConfigService)localObject, false);
    ArConfigService.l((ArConfigService)localObject);
    ArConfigService.m((ArConfigService)localObject);
    ArConfigService.n((ArConfigService)localObject);
    ArConfigService.o((ArConfigService)localObject);
    ArConfigService.p((ArConfigService)localObject);
    if (!ArConfigService.q((ArConfigService)localObject))
    {
      int i = (ArConfigService.r((ArConfigService)localObject) + ArConfigService.s((ArConfigService)localObject) + ArConfigService.t((ArConfigService)localObject) + ArConfigService.u((ArConfigService)localObject) + ArConfigService.v((ArConfigService)localObject)) / 5;
      ArConfigService.w((ArConfigService)localObject).post(new ArConfigService.ArConfigManagerStub.2(this, (ArConfigService)localObject, i));
      if (i == 100) {
        ArConfigService.w((ArConfigService)localObject).post(new ArConfigService.ArConfigManagerStub.3(this, (ArConfigService)localObject));
      }
    }
  }
  
  public boolean i()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "isArCoreSoReady error arConfigService is null");
      return false;
    }
    return ArConfigService.j((ArConfigService)localObject);
  }
  
  public void j()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (ArConfigService)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArCoreSo error arConfigService is null");
      return;
    }
    ArConfigService.o((ArConfigService)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub
 * JD-Core Version:    0.7.0.1
 */