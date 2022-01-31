package com.tencent.mobileqq.ar;

import aabz;
import aaca;
import aacb;
import aacf;
import aacj;
import aacn;
import aaco;
import aacp;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class ArConfigService
  extends AppService
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private RemoteCallbackList jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  public QQAppInterface a;
  public ARGlobalConfigManager a;
  public ArResourceManager a;
  private IArConfigListener jdField_a_of_type_ComTencentMobileqqArIArConfigListener = new aabz(this);
  private final IArConfigManager.Stub jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager$Stub = new aacp(this);
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new aacf(this);
  private EarlyDownloadManager.EarlyDownLoadListener jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener = new aacb(this);
  public Object a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private RemoteCallbackList jdField_b_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private ARPreSoResourceDownload.ARResourceDownloadCallback jdField_b_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback = new aacj(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private RemoteCallbackList jdField_c_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public ArConfigService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = null;
    this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    this.jdField_b_of_type_Boolean = a();
    if (!this.jdField_b_of_type_Boolean)
    {
      ArNativeSoDownloadHandler localArNativeSoDownloadHandler = (ArNativeSoDownloadHandler)((EarlyDownloadManager)this.app.getManager(76)).a("qq.android.ar.native.so_v7.6.5.1");
      if (localArNativeSoDownloadHandler != null)
      {
        localArNativeSoDownloadHandler.a(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadEarlyDownloadManager$EarlyDownLoadListener);
        this.jdField_a_of_type_Int = 0;
        XmlData localXmlData = localArNativeSoDownloadHandler.a();
        if ((localXmlData != null) && (localXmlData.loadState == 2))
        {
          QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
          localArNativeSoDownloadHandler.a(true, true);
        }
      }
      else
      {
        return;
      }
      localArNativeSoDownloadHandler.a(true);
      return;
    }
    this.jdField_a_of_type_Int = 100;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidOsRemoteCallbackList != null) {}
    try
    {
      int j = this.jdField_c_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((IArSoCallback)this.jdField_c_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramInt);
            i += 1;
          }
          catch (Exception localException1) {}
        }
      }
      this.jdField_c_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadProcess fail!", localException2);
    }
  }
  
  private boolean a()
  {
    return a(this.app);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ArNativeSoDownloadHandler)((EarlyDownloadManager)paramAppRuntime.getManager(76)).a("qq.android.ar.native.so_v7.6.5.1");
    if (paramAppRuntime != null)
    {
      boolean bool2 = paramAppRuntime.h();
      int i = paramAppRuntime.b();
      if ((paramAppRuntime.h()) && (i > 0)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, String.format("isArSoDownload isSuccess=%s version=%s result=%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) }));
        }
        return bool1;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArCloudSoInternal");
    }
    this.jdField_c_of_type_Boolean = b();
    if (!this.jdField_c_of_type_Boolean)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(219);
      if (localObject != null) {}
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new ArNativeSoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.jdField_b_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback);
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
        this.jdField_a_of_type_AndroidOsHandler.post(new aacn(this));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    this.jdField_b_of_type_Int = 100;
  }
  
  private boolean b()
  {
    return b(this.app);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(219);
    if (localObject != null)
    {
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label110;
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
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, String.format("isArCloudSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
    }
    label110:
    return false;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSDK2SoInternal");
    }
    this.d = c();
    if (!this.d)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(219);
      if (localObject != null) {}
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          new ArNativeSoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback);
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
        this.jdField_a_of_type_AndroidOsHandler.post(new aaco(this));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    this.jdField_c_of_type_Int = 100;
  }
  
  private boolean c()
  {
    return d(this.app);
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    return (a(paramAppRuntime)) && (b(paramAppRuntime)) && (d(paramAppRuntime));
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_AndroidOsRemoteCallbackList != null) {}
    try
    {
      int j = this.jdField_c_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      while (i < j) {
        try
        {
          ((IArSoCallback)this.jdField_c_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a();
          i += 1;
        }
        catch (Exception localException1) {}
      }
      this.jdField_c_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess fail!", localException2);
    }
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(219);
    if (localObject != null)
    {
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject == null) || (((ARCommonConfigInfo)localObject).nativeSoResList == null) || (((ARCommonConfigInfo)localObject).nativeSoResList.size() <= 0)) {
          break label111;
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
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, String.format("isArSDK2SoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
    }
    label111:
    return false;
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_AndroidOsRemoteCallbackList != null) {}
    try
    {
      int j = this.jdField_c_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      while (i < j) {
        try
        {
          ((IArSoCallback)this.jdField_c_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).b();
          i += 1;
        }
        catch (Exception localException1) {}
      }
      this.jdField_c_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
    catch (Exception localException2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadFail fail!", localException2);
    }
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
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = ((ArResourceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(167));
      if (this.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = ((ARGlobalConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219));
      if (this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
      }
      FaceScanDownloadManager.a(new aaca(this));
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
    FaceScanDownloadManager.a();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */