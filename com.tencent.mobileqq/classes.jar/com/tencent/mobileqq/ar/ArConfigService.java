package com.tencent.mobileqq.ar;

import akxf;
import albm;
import albn;
import albo;
import albp;
import albq;
import albr;
import albs;
import albt;
import albu;
import alby;
import alca;
import alch;
import alcl;
import alcv;
import alec;
import alee;
import alek;
import alen;
import aleq;
import alfa;
import alfe;
import alin;
import aljp;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import anpc;
import anpf;
import anpk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class ArConfigService
  extends AppService
{
  private int jdField_a_of_type_Int;
  public akxf a;
  public alch a;
  private alcv jdField_a_of_type_Alcv = new albm(this);
  private final alec jdField_a_of_type_Alec = new albu(this);
  private alin jdField_a_of_type_Alin = new albq(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private RemoteCallbackList<alen> jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private anpf jdField_a_of_type_Anpf = new albp(this);
  public QQAppInterface a;
  public Object a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private alin jdField_b_of_type_Alin = new albr(this);
  private RemoteCallbackList<alee> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private alin jdField_c_of_type_Alin = new albs(this);
  private RemoteCallbackList<alek> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private alin jdField_d_of_type_Alin = new albt(this);
  private RemoteCallbackList<aleq> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public ArConfigService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Alch = null;
    this.jdField_a_of_type_Akxf = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (c()) {}
    anpk localanpk;
    for (boolean bool = true;; bool = b())
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label119;
      }
      localanpk = (anpk)((anpc)this.app.getManager(77)).a(anpk.a);
      if (localanpk != null)
      {
        localanpk.a(this.jdField_a_of_type_Anpf);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localanpk.a();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localanpk.a(true, true);
      }
      return;
    }
    localanpk.a(true);
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
            ((aleq)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
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
    paramAppRuntime = (anpk)((anpc)paramAppRuntime.getManager(77)).a(anpk.a);
    boolean bool3;
    int i;
    if (paramAppRuntime != null)
    {
      bool3 = paramAppRuntime.g();
      i = paramAppRuntime.b();
      if ((!paramAppRuntime.g()) || (i <= 0)) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool4 = alby.b(alby.a);
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
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
    }
    alfe localalfe = alfa.a();
    if (localalfe == null)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 100;
    }
    do
    {
      Object localObject;
      do
      {
        return;
        this.jdField_e_of_type_Boolean = d();
        if (this.jdField_e_of_type_Boolean) {
          break;
        }
        localObject = (akxf)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new alca(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localalfe.a(), this.jdField_c_of_type_Alin);
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
    alfe localalfe = alfa.a();
    if (localalfe == null) {
      return true;
    }
    Object localObject = (akxf)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new alca((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localalfe.a());
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
    this.f = e();
    if (!this.f)
    {
      Object localObject = (akxf)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new alca(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_Alin);
        }
        this.jdField_e_of_type_Int = 0;
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.10(this));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    this.jdField_e_of_type_Int = 100;
  }
  
  private static boolean c()
  {
    return alby.a(alby.a);
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
    this.jdField_c_of_type_Boolean = f();
    if (!this.jdField_c_of_type_Boolean)
    {
      Object localObject = (akxf)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new alca(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_Alin);
        }
        this.jdField_b_of_type_Int = 0;
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.11(this));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    this.jdField_b_of_type_Int = 100;
  }
  
  private boolean d()
  {
    return b(this.app);
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    Object localObject = (akxf)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new alca((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
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
    this.jdField_d_of_type_Boolean = g();
    if (!this.jdField_d_of_type_Boolean)
    {
      Object localObject = (akxf)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new alca(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_Alin);
        }
        this.jdField_c_of_type_Int = 0;
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal fail!", localException);
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsHandler.post(new ArConfigService.12(this));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
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
          ((aleq)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
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
    Object localObject = (akxf)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((akxf)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new alca((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
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
          ((aleq)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
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
    return this.jdField_a_of_type_Alec;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onCreate, " + this);
    }
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      this.jdField_a_of_type_Alch = ((alch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(168));
      if (this.jdField_a_of_type_Alch != null) {
        this.jdField_a_of_type_Alch.a(this.jdField_a_of_type_Alcv);
      }
      this.jdField_a_of_type_Akxf = ((akxf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220));
      if (this.jdField_a_of_type_Akxf != null) {
        this.jdField_a_of_type_Akxf.a(this.jdField_a_of_type_Alcv);
      }
      alcl.a(new albn(this));
      aljp.a(new albo(this));
    }
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
    alcl.a();
    aljp.a();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Alch != null) {
      this.jdField_a_of_type_Alch.b(this.jdField_a_of_type_Alcv);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */