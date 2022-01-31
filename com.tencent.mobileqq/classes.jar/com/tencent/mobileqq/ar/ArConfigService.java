package com.tencent.mobileqq.ar;

import akiu;
import aknb;
import aknc;
import aknd;
import akne;
import aknf;
import akng;
import aknh;
import akni;
import aknj;
import aknn;
import aknp;
import aknw;
import akoa;
import akok;
import akpr;
import akpt;
import akpz;
import akqc;
import akqf;
import akqp;
import akqt;
import akuc;
import akve;
import amyp;
import amys;
import amyx;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
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
  public akiu a;
  public aknw a;
  private akok jdField_a_of_type_Akok = new aknb(this);
  private final akpr jdField_a_of_type_Akpr = new aknj(this);
  private akuc jdField_a_of_type_Akuc = new aknf(this);
  private amys jdField_a_of_type_Amys = new akne(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private RemoteCallbackList<akqc> jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  public QQAppInterface a;
  public Object a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private akuc jdField_b_of_type_Akuc = new akng(this);
  private RemoteCallbackList<akpt> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private akuc jdField_c_of_type_Akuc = new aknh(this);
  private RemoteCallbackList<akpz> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private akuc jdField_d_of_type_Akuc = new akni(this);
  private RemoteCallbackList<akqf> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public ArConfigService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Aknw = null;
    this.jdField_a_of_type_Akiu = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (c()) {}
    amyx localamyx;
    for (boolean bool = true;; bool = b())
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label118;
      }
      localamyx = (amyx)((amyp)this.app.getManager(77)).a("qq.android.ar.native.so_v8.0.0");
      if (localamyx != null)
      {
        localamyx.a(this.jdField_a_of_type_Amys);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localamyx.a();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localamyx.a(true, true);
      }
      return;
    }
    localamyx.a(true);
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
            ((akqf)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
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
    paramAppRuntime = (amyx)((amyp)paramAppRuntime.getManager(77)).a("qq.android.ar.native.so_v8.0.0");
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
      boolean bool4 = aknn.b("ArMapEngine800");
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
    akqt localakqt = akqp.a();
    if (localakqt == null)
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
        localObject = (akiu)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new aknp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localakqt.a(), this.jdField_c_of_type_Akuc);
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
    akqt localakqt = akqp.a();
    if (localakqt == null) {
      return true;
    }
    Object localObject = (akiu)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new aknp((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localakqt.a());
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
      Object localObject = (akiu)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new aknp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_Akuc);
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
    return aknn.a("ArMapEngine800");
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
      Object localObject = (akiu)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new aknp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_Akuc);
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
    Object localObject = (akiu)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new aknp((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
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
      Object localObject = (akiu)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new aknp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_Akuc);
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
          ((akqf)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
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
    Object localObject = (akiu)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((akiu)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new aknp((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
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
          ((akqf)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
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
    return this.jdField_a_of_type_Akpr;
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
      this.jdField_a_of_type_Aknw = ((aknw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(168));
      if (this.jdField_a_of_type_Aknw != null) {
        this.jdField_a_of_type_Aknw.a(this.jdField_a_of_type_Akok);
      }
      this.jdField_a_of_type_Akiu = ((akiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220));
      if (this.jdField_a_of_type_Akiu != null) {
        this.jdField_a_of_type_Akiu.a(this.jdField_a_of_type_Akok);
      }
      akoa.a(new aknc(this));
      akve.a(new aknd(this));
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
    akoa.a();
    akve.a();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aknw != null) {
      this.jdField_a_of_type_Aknw.b(this.jdField_a_of_type_Akok);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */