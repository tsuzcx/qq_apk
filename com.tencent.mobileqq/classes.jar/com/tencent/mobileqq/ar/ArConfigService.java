package com.tencent.mobileqq.ar;

import amnv;
import amsc;
import amsd;
import amse;
import amsf;
import amsg;
import amsh;
import amsi;
import amsj;
import amsk;
import amso;
import amsq;
import amsx;
import amtb;
import amtl;
import amus;
import amuu;
import amva;
import amvd;
import amvg;
import amvq;
import amvu;
import amzd;
import anaf;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import apgj;
import apgm;
import apgr;
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
  public amnv a;
  public amsx a;
  private amtl jdField_a_of_type_Amtl = new amsc(this);
  private final amus jdField_a_of_type_Amus = new amsk(this);
  private amzd jdField_a_of_type_Amzd = new amsg(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private RemoteCallbackList<amvd> jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private apgm jdField_a_of_type_Apgm = new amsf(this);
  public QQAppInterface a;
  public Object a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private amzd jdField_b_of_type_Amzd = new amsh(this);
  private RemoteCallbackList<amuu> jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private amzd jdField_c_of_type_Amzd = new amsi(this);
  private RemoteCallbackList<amva> jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private amzd jdField_d_of_type_Amzd = new amsj(this);
  private RemoteCallbackList<amvg> jdField_d_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public ArConfigService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Amsx = null;
    this.jdField_a_of_type_Amnv = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    if (c()) {}
    apgr localapgr;
    for (boolean bool = true;; bool = b())
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label118;
      }
      localapgr = (apgr)((apgj)this.app.getManager(77)).a("qq.android.ar.native.so_v8.0.0");
      if (localapgr != null)
      {
        localapgr.a(this.jdField_a_of_type_Apgm);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localapgr.a();
        if ((localXmlData == null) || (localXmlData.loadState != 2)) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
        localapgr.a(true, true);
      }
      return;
    }
    localapgr.a(true);
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
            ((amvg)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
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
    paramAppRuntime = (apgr)((apgj)paramAppRuntime.getManager(77)).a("qq.android.ar.native.so_v8.0.0");
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
      boolean bool4 = amso.b("ArMapEngine800");
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
    amvu localamvu = amvq.a();
    if (localamvu == null)
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
        localObject = (amnv)this.app.getManager(220);
      } while (localObject == null);
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new amsq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localamvu.a(), this.jdField_c_of_type_Amzd);
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
    amvu localamvu = amvq.a();
    if (localamvu == null) {
      return true;
    }
    Object localObject = (amnv)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label118;
        }
        bool = new amsq((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localamvu.a());
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
      Object localObject = (amnv)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new amsq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.jdField_d_of_type_Amzd);
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
    return amso.a("ArMapEngine800");
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
      Object localObject = (amnv)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new amsq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_Amzd);
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
    Object localObject = (amnv)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new amsq((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
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
      Object localObject = (amnv)this.app.getManager(220);
      if (localObject != null) {}
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new amsq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_Amzd);
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
          ((amvg)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
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
    Object localObject = (amnv)paramAppRuntime.getManager(220);
    if (localObject != null)
    {
      try
      {
        localObject = ((amnv)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label105;
        }
        bool = new amsq((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
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
          ((amvg)this.jdField_d_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
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
    return this.jdField_a_of_type_Amus;
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
      this.jdField_a_of_type_Amsx = ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(168));
      if (this.jdField_a_of_type_Amsx != null) {
        this.jdField_a_of_type_Amsx.a(this.jdField_a_of_type_Amtl);
      }
      this.jdField_a_of_type_Amnv = ((amnv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220));
      if (this.jdField_a_of_type_Amnv != null) {
        this.jdField_a_of_type_Amnv.a(this.jdField_a_of_type_Amtl);
      }
      amtb.a(new amsd(this));
      anaf.a(new amse(this));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    amtb.a();
    anaf.a();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Amsx != null) {
      this.jdField_a_of_type_Amsx.b(this.jdField_a_of_type_Amtl);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */