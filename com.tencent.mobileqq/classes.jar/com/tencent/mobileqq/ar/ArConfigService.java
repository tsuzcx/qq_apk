package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import apbf;
import apfn;
import apfo;
import apfp;
import apfq;
import apfr;
import apfs;
import apft;
import apfu;
import apfv;
import apfz;
import apgb;
import apgi;
import apgm;
import apgw;
import apid;
import apif;
import apil;
import apio;
import apir;
import apjb;
import apjd;
import apmi;
import apnj;
import asbm;
import asbp;
import asbs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
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
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private RemoteCallbackList<apio> jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  public apbf a;
  private apgw jdField_a_of_type_Apgw = new apfn(this);
  private final apid jdField_a_of_type_Apid = new apfv(this);
  private apmi jdField_a_of_type_Apmi = new apfr(this);
  private asbp jdField_a_of_type_Asbp = new apfq(this);
  public Object a;
  public WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private RemoteCallbackList<apif> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private apmi jdField_b_of_type_Apmi = new apfs(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private RemoteCallbackList<apil> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private apmi jdField_c_of_type_Apmi = new apft(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private RemoteCallbackList<apir> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private apmi jdField_d_of_type_Apmi = new apfu(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public ArConfigService()
  {
    this.jdField_a_of_type_Apbf = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (c()) {}
    asbs localasbs;
    for (boolean bool = true;; bool = b())
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label119;
      }
      localasbs = (asbs)((asbm)this.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.ar.native.so_v8.3.6");
      if (localasbs != null)
      {
        localasbs.a(this.jdField_a_of_type_Asbp);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localasbs.a();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localasbs.a(true, true);
      }
      return;
    }
    localasbs.a(true);
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
            ((apir)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
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
    paramAppRuntime = (asbs)((asbm)paramAppRuntime.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.ar.native.so_v8.3.6");
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
      boolean bool4 = apfz.b("ArMapEngine836");
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
      apjd localapjd;
      Object localObject;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
        }
        localapjd = apjb.a();
        if (localapjd == null)
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_d_of_type_Int = 100;
          return;
        }
        this.jdField_e_of_type_Boolean = d();
        if (this.jdField_e_of_type_Boolean) {
          break;
        }
        localObject = (apbf)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apgb(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localapjd.a(), this.jdField_c_of_type_Apmi);
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
    apjd localapjd = apjb.a();
    if (localapjd == null) {
      return true;
    }
    Object localObject = (apbf)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new apgb((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localapjd.a());
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
        localObject = (apbf)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apgb(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_Apmi);
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
    return apfz.a("ArMapEngine836");
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
        localObject = (apbf)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apgb(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_Apmi);
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
    Object localObject = (apbf)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new apgb((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
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
        localObject = (apbf)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      } while (localObject == null);
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apgb(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_Apmi);
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
          ((apir)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
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
    Object localObject = (apbf)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      try
      {
        localObject = ((apbf)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new apgb((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
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
          ((apir)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
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
    return this.jdField_a_of_type_Apid;
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
    apgi localapgi = (apgi)localQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localapgi != null) {
      localapgi.a(this.jdField_a_of_type_Apgw);
    }
    this.jdField_a_of_type_Apbf = ((apbf)localQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER));
    if (this.jdField_a_of_type_Apbf != null) {
      this.jdField_a_of_type_Apbf.a(this.jdField_a_of_type_Apgw);
    }
    apgm.a(new apfo(this));
    apnj.a(new apfp(this));
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
    this.jdField_a_of_type_Apbf = null;
    apgm.a();
    apnj.a();
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
      localObject = (apgi)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localObject != null) {
        ((apgi)localObject).b(this.jdField_a_of_type_Apgw);
      }
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */