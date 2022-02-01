import android.os.Handler;
import android.os.RemoteCallbackList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.1;
import com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.2;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class aovq
  extends aoxy
{
  WeakReference<ArConfigService> a;
  
  public aovq(ArConfigService paramArConfigService)
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
      if (((ArConfigService)localObject).jdField_a_of_type_Aorb != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_Aorb.a();; localObject = null)
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
      if (((ArConfigService)localObject).jdField_a_of_type_Aowd != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_Aowd.a();; localObject = null)
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService is null");
        return null;
      }
      if (((ArConfigService)localObject).jdField_a_of_type_Aowd != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_Aowd.a();; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "getArEffectConfig|mEffectConfig=" + localObject);
        }
        return localObject;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject == null) {
        QLog.d("ArConfig_ArConfigService", 1, "downloadResource error arConfigService is null");
      }
      while (((ArConfigService)localObject).jdField_a_of_type_Aowd == null) {
        return;
      }
      ((ArConfigService)localObject).jdField_a_of_type_Aowd.a(false, false);
      HashMap localHashMap = new HashMap();
      localHashMap.put("click_download", "1");
      localObject = (QQAppInterface)((ArConfigService)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "downloadResource,mApp is null! ");
        return;
      }
      bctj.a(BaseApplicationImpl.getContext()).a(((QQAppInterface)localObject).getCurrentAccountUin(), "ar_client_download_times", true, 0L, 0L, localHashMap, null);
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
    aowh.a(paramInt, (QQAppInterface)ArConfigService.b(localArConfigService));
  }
  
  public void a(aoya paramaoya)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
    }
    while ((paramaoya == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).register(paramaoya);
  }
  
  public void a(aoyg paramaoyg)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerMiniCallback error arConfigService is null");
    }
    while ((paramaoyg == null) || (ArConfigService.c(localArConfigService) == null)) {
      return;
    }
    ArConfigService.c(localArConfigService).register(paramaoyg);
  }
  
  public void a(aoyj paramaoyj)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
    }
    while ((paramaoyj == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).register(paramaoyj);
  }
  
  public void a(aoym paramaoym)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
    }
    while (paramaoym == null) {
      return;
    }
    ArConfigService.d(localArConfigService).register(paramaoym);
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "handleNewConfig error arConfigService is null");
    }
    while (localArConfigService.jdField_a_of_type_Aowd == null) {
      return;
    }
    localArConfigService.jdField_a_of_type_Aowd.a(paramArConfigInfo);
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
        boolean bool = aowh.a((QQAppInterface)ArConfigService.d(localArConfigService));
        if (!bool) {
          aowh.a((QQAppInterface)ArConfigService.e(localArConfigService));
        }
        return bool;
      }
      return false;
    }
  }
  
  public void b()
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "cancelDownload error arConfigService is null");
    }
    while (localArConfigService.jdField_a_of_type_Aowd == null) {
      return;
    }
    localArConfigService.jdField_a_of_type_Aowd.a.a();
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
    apdf.a(paramInt, (QQAppInterface)ArConfigService.g(localArConfigService));
  }
  
  public void b(aoya paramaoya)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
    }
    while ((paramaoya == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).unregister(paramaoya);
  }
  
  public void b(aoyg paramaoyg)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterMiniCallback error arConfigService is null");
    }
    while ((paramaoyg == null) || (ArConfigService.c(localArConfigService) == null)) {
      return;
    }
    ArConfigService.c(localArConfigService).unregister(paramaoyg);
  }
  
  public void b(aoyj paramaoyj)
  {
    QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback");
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
    }
    while ((paramaoyj == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).unregister(paramaoyj);
  }
  
  public void b(aoym paramaoym)
  {
    ArConfigService localArConfigService = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localArConfigService = (ArConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
    }
    while (paramaoym == null) {
      return;
    }
    ArConfigService.d(localArConfigService).unregister(paramaoym);
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
        boolean bool = apdf.a(true, (QQAppInterface)ArConfigService.i(localArConfigService));
        if (!bool) {
          apdf.a(true, (QQAppInterface)ArConfigService.j(localArConfigService));
        }
        if (!apdf.a(false, (QQAppInterface)ArConfigService.k(localArConfigService))) {
          apdf.a(false, (QQAppInterface)ArConfigService.l(localArConfigService));
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
      localObject = (zum)ArConfigService.m((ArConfigService)localObject).getManager(243);
    } while (localObject == null);
    ((zum)localObject).a(paramInt);
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
 * Qualified Name:     aovq
 * JD-Core Version:    0.7.0.1
 */