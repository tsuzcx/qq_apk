package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import aper;
import apiy;
import apiz;
import apja;
import apjb;
import apjc;
import apjd;
import apje;
import apjf;
import apjg;
import apjk;
import apjm;
import apjt;
import apjx;
import apkh;
import aplo;
import aplq;
import aplw;
import aplz;
import apmc;
import apmm;
import apmo;
import appt;
import apqv;
import asde;
import asdh;
import asdk;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private RemoteCallbackList<aplz> jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  public aper a;
  public apjt a;
  private apkh jdField_a_of_type_Apkh = new apiy(this);
  private final aplo jdField_a_of_type_Aplo = new apjg(this);
  private appt jdField_a_of_type_Appt = new apjc(this);
  private asdh jdField_a_of_type_Asdh = new apjb(this);
  public Object a;
  public WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private RemoteCallbackList<aplq> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private appt jdField_b_of_type_Appt = new apjd(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private RemoteCallbackList<aplw> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private appt jdField_c_of_type_Appt = new apje(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private RemoteCallbackList<apmc> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private appt jdField_d_of_type_Appt = new apjf(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public ArConfigService()
  {
    this.jdField_a_of_type_Apjt = null;
    this.jdField_a_of_type_Aper = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (c()) {}
    asdk localasdk;
    for (boolean bool = true;; bool = b())
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label118;
      }
      localasdk = (asdk)((asde)this.app.getManager(77)).a("qq.android.ar.native.so_v8.3.6");
      if (localasdk != null)
      {
        localasdk.a(this.jdField_a_of_type_Asdh);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localasdk.a();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localasdk.a(true, true);
      }
      return;
    }
    localasdk.a(true);
    return;
    label118:
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
            ((apmc)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
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
    paramAppRuntime = (asdk)((asde)paramAppRuntime.getManager(77)).a("qq.android.ar.native.so_v8.3.6");
    boolean bool3;
    int i;
    if (paramAppRuntime != null)
    {
      bool3 = paramAppRuntime.g();
      i = paramAppRuntime.b();
      if ((!paramAppRuntime.g()) || (i <= 0)) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool4 = apjk.b("ArMapEngine836");
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
      apmo localapmo;
      Object localObject;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
        }
        localapmo = apmm.a();
        if (localapmo == null)
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_d_of_type_Int = 100;
          return;
        }
        this.jdField_e_of_type_Boolean = d();
        if (this.jdField_e_of_type_Boolean) {
          break;
        }
        localObject = (aper)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apjm(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localapmo.a(), this.jdField_c_of_type_Appt);
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
    apmo localapmo = apmm.a();
    if (localapmo == null) {
      return true;
    }
    Object localObject = (aper)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new apjm((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localapmo.a());
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
        localObject = (aper)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apjm(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_Appt);
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
    return apjk.a("ArMapEngine836");
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
        localObject = (aper)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apjm(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_Appt);
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
    Object localObject = (aper)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new apjm((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
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
        localObject = (aper)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new apjm(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_Appt);
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
          ((apmc)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
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
    Object localObject = (aper)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((aper)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new apjm((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
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
          ((apmc)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
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
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_Aplo;
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
    this.jdField_a_of_type_Apjt = ((apjt)localQQAppInterface.getManager(168));
    if (this.jdField_a_of_type_Apjt != null) {
      this.jdField_a_of_type_Apjt.a(this.jdField_a_of_type_Apkh);
    }
    this.jdField_a_of_type_Aper = ((aper)localQQAppInterface.getManager(220));
    if (this.jdField_a_of_type_Aper != null) {
      this.jdField_a_of_type_Aper.a(this.jdField_a_of_type_Apkh);
    }
    apjx.a(new apiz(this));
    apqv.a(new apja(this));
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
    apjx.a();
    apqv.a();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    stopSelf();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Apjt != null) {
      this.jdField_a_of_type_Apjt.b(this.jdField_a_of_type_Apkh);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */