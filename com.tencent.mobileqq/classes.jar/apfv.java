import android.os.Handler;
import android.os.RemoteCallbackList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.1;
import com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.2;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class apfv
  extends apid
{
  WeakReference<ArConfigService> a;
  
  public apfv(ArConfigService paramArConfigService)
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
      if (((ArConfigService)localObject).jdField_a_of_type_Apbf != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_Apbf.a();; localObject = null)
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
        localObject = (apgi)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
        if (localObject == null) {}
      }
      for (localObject = ((apgi)localObject).a();; localObject = null)
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
        localObject3 = (QQAppInterface)((ArConfigService)localObject1).jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = (apgi)((QQAppInterface)localObject3).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((apgi)localObject3).a();
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
        localObject2 = (apgi)((QQAppInterface)localObject1).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      } while (localObject2 == null);
      ((apgi)localObject2).a(false, false);
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
    apgm.a(paramInt, (QQAppInterface)ArConfigService.b(localArConfigService));
  }
  
  public void a(apif paramapif)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
    }
    while ((paramapif == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).register(paramapif);
  }
  
  public void a(apil paramapil)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerMiniCallback error arConfigService is null");
    }
    while ((paramapil == null) || (ArConfigService.c(localArConfigService) == null)) {
      return;
    }
    ArConfigService.c(localArConfigService).register(paramapil);
  }
  
  public void a(apio paramapio)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
    }
    while ((paramapio == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).register(paramapio);
  }
  
  public void a(apir paramapir)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
    }
    while (paramapir == null) {
      return;
    }
    ArConfigService.d(localArConfigService).register(paramapir);
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
      localObject = (apgi)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    } while (localObject == null);
    ((apgi)localObject).a(paramArConfigInfo);
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
        boolean bool = apgm.a((QQAppInterface)ArConfigService.d(localArConfigService));
        if (!bool) {
          apgm.a((QQAppInterface)ArConfigService.e(localArConfigService));
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
      localObject = (apgi)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    } while (localObject == null);
    ((apgi)localObject).a.a();
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
    apnj.a(paramInt, (QQAppInterface)ArConfigService.g(localArConfigService));
  }
  
  public void b(apif paramapif)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
    }
    while ((paramapif == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).unregister(paramapif);
  }
  
  public void b(apil paramapil)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterMiniCallback error arConfigService is null");
    }
    while ((paramapil == null) || (ArConfigService.c(localArConfigService) == null)) {
      return;
    }
    ArConfigService.c(localArConfigService).unregister(paramapil);
  }
  
  public void b(apio paramapio)
  {
    QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback");
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
    }
    while ((paramapio == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).unregister(paramapio);
  }
  
  public void b(apir paramapir)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
    }
    while (paramapir == null) {
      return;
    }
    ArConfigService.d(localArConfigService).unregister(paramapir);
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
        boolean bool = apnj.a(true, (QQAppInterface)ArConfigService.i(localArConfigService));
        if (!bool) {
          apnj.a(true, (QQAppInterface)ArConfigService.j(localArConfigService));
        }
        if (!apnj.a(false, (QQAppInterface)ArConfigService.k(localArConfigService))) {
          apnj.a(false, (QQAppInterface)ArConfigService.l(localArConfigService));
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
      ArConfigService.a(localArConfigService).post(new ArConfigService.ArConfigManagerStub.1(this, localArConfigService, i));
    } while (i != 100);
    ArConfigService.a(localArConfigService).post(new ArConfigService.ArConfigManagerStub.2(this, localArConfigService));
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
      localObject = (zmv)ArConfigService.m((ArConfigService)localObject).getManager(QQManagerFactory.QR_MAIN_PROC_MANAGER);
    } while (localObject == null);
    ((zmv)localObject).a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfv
 * JD-Core Version:    0.7.0.1
 */