package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager;
import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
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
  WeakReference<QQAppInterface> a;
  ARGlobalConfigManager b = null;
  Object c = new Object();
  private RemoteCallbackList<IArRemoteCallback> d = new RemoteCallbackList();
  private RemoteCallbackList<IArFaceCallback> e = new RemoteCallbackList();
  private IArConfigListener f = new ArConfigService.1(this);
  private final IArConfigManager.Stub g = new ArConfigService.ArConfigManagerStub(this);
  private Handler h = new Handler();
  private RemoteCallbackList<IArSoCallback> i = new RemoteCallbackList();
  private boolean j = false;
  private boolean k = false;
  private int l = 0;
  private boolean m = false;
  private int n = 0;
  private boolean o = false;
  private int p = 0;
  private boolean q = true;
  private int r = 100;
  private boolean s = true;
  private int t = 100;
  private EarlyDownLoadListener u = new ArConfigService.3(this);
  private ARPreSoResourceDownload.ARResourceDownloadCallback v = new ArConfigService.4(this);
  private ARPreSoResourceDownload.ARResourceDownloadCallback w = new ArConfigService.5(this);
  private ARPreSoResourceDownload.ARResourceDownloadCallback x = new ArConfigService.6(this);
  private ARPreSoResourceDownload.ARResourceDownloadCallback y = new ArConfigService.7(this);
  
  public ArConfigService()
  {
    QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/mobileqq/ar/ArConfigService:i	Landroid/os/RemoteCallbackList;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +66 -> 74
    //   11: aload 4
    //   13: invokevirtual 155	android/os/RemoteCallbackList:beginBroadcast	()I
    //   16: istore_3
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: iload_3
    //   21: if_icmpge +27 -> 48
    //   24: aload_0
    //   25: getfield 81	com/tencent/mobileqq/ar/ArConfigService:i	Landroid/os/RemoteCallbackList;
    //   28: iload_2
    //   29: invokevirtual 159	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   32: checkcast 161	com/tencent/mobileqq/ar/aidl/IArSoCallback
    //   35: iload_1
    //   36: invokeinterface 163 2 0
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_2
    //   45: goto -26 -> 19
    //   48: aload_0
    //   49: getfield 81	com/tencent/mobileqq/ar/ArConfigService:i	Landroid/os/RemoteCallbackList;
    //   52: invokevirtual 166	android/os/RemoteCallbackList:finishBroadcast	()V
    //   55: return
    //   56: astore 4
    //   58: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +13 -> 74
    //   64: ldc 130
    //   66: iconst_2
    //   67: ldc 172
    //   69: aload 4
    //   71: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: return
    //   75: astore 4
    //   77: goto -29 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ArConfigService
    //   0	80	1	paramInt	int
    //   18	27	2	i1	int
    //   16	6	3	i2	int
    //   4	8	4	localRemoteCallbackList	RemoteCallbackList
    //   56	14	4	localException1	Exception
    //   75	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	17	56	java/lang/Exception
    //   48	55	56	java/lang/Exception
    //   24	41	75	java/lang/Exception
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ArNativeSoDownloadHandler)((IEarlyDownloadService)paramAppRuntime.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.ar.native.so_v8.3.6");
    boolean bool2;
    if (paramAppRuntime != null)
    {
      boolean bool4 = paramAppRuntime.r();
      int i1 = paramAppRuntime.f();
      boolean bool1;
      if ((paramAppRuntime.r()) && (i1 > 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool5 = ArNativeSoLoader.b("ArMapEngine836");
      boolean bool3 = bool1 & bool5;
      bool2 = bool3;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_ArConfigService", 2, String.format("isArSoDownload isSuccess=%s version=%s fileExist = %s result=%s ", new Object[] { Boolean.valueOf(bool4), Integer.valueOf(i1), Boolean.valueOf(bool5), Boolean.valueOf(bool3) }));
        bool2 = bool3;
      }
    }
    else
    {
      bool2 = false;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("isArSoDownload ArNativeSoDownloadHandler so ready:=");
    paramAppRuntime.append(bool2);
    QLog.d("ArConfig_ArConfigService", 1, paramAppRuntime.toString());
    return bool2;
  }
  
  private boolean b()
  {
    return a(this.app);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if (localIArCoreNativeSoLoader == null) {
      return true;
    }
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      boolean bool;
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, localIArCoreNativeSoLoader.a());
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ArConfig_ArConfigService", 1, "isARCoreSoDownload fail!", paramAppRuntime);
        bool = false;
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isARCoreSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    return false;
  }
  
  private static boolean c()
  {
    return ArNativeSoLoader.a("ArMapEngine836");
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    return true;
  }
  
  private boolean d()
  {
    return b(this.app);
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      boolean bool;
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ArConfig_ArConfigService", 1, "isArCloudSoDownload fail!", paramAppRuntime);
        bool = false;
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArCloudSoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    return false;
  }
  
  private boolean e()
  {
    return c(this.app);
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    return (c()) && (d(paramAppRuntime)) && (f(paramAppRuntime)) && (b(paramAppRuntime));
  }
  
  private boolean f()
  {
    return d(this.app);
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    Object localObject = (ARGlobalConfigManager)paramAppRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localObject != null)
    {
      boolean bool;
      try
      {
        localObject = ((ARGlobalConfigManager)localObject).a(true);
        if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
          bool = new ArNativeSoManager((QQAppInterface)paramAppRuntime).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ArConfig_ArConfigService", 1, "isArSDK2SoDownload fail!", paramAppRuntime);
        bool = false;
      }
      QLog.d("ArConfig_ArConfigService", 1, String.format("isArSDK2SoDownload result=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    return false;
  }
  
  private boolean g()
  {
    return f(this.app);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
    }
    boolean bool;
    if (c()) {
      bool = true;
    } else {
      bool = b();
    }
    this.k = bool;
    if (!this.k)
    {
      ArNativeSoDownloadHandler localArNativeSoDownloadHandler = (ArNativeSoDownloadHandler)((IEarlyDownloadService)this.app.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.ar.native.so_v8.3.6");
      if (localArNativeSoDownloadHandler != null)
      {
        localArNativeSoDownloadHandler.a(this.u);
        this.l = 0;
        XmlData localXmlData = localArNativeSoDownloadHandler.h();
        if ((localXmlData != null) && (localXmlData.loadState == 2))
        {
          QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
          localArNativeSoDownloadHandler.a(true, true);
          return;
        }
        localArNativeSoDownloadHandler.a(true);
      }
    }
    else
    {
      this.l = 100;
    }
  }
  
  private void i()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downArCoreSoInternal,mApp is null! ");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
    }
    IArCoreNativeSoLoader localIArCoreNativeSoLoader = ArCoreNativeSoManager.a();
    if (localIArCoreNativeSoLoader == null)
    {
      this.q = true;
      this.r = 100;
      return;
    }
    this.q = d();
    if (!this.q)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, localIArCoreNativeSoLoader.a(), this.x);
          }
          this.r = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downArCoreSoInternal fail!", localException);
          if (this.j) {
            return;
          }
        }
        this.h.post(new ArConfigService.8(this));
        this.j = true;
      }
    }
    else
    {
      this.r = 100;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArFeatureSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArFeatureSoInternal,mApp is null! ");
      return;
    }
    this.s = e();
    if (!this.s)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arfeature", this.y);
          }
          this.t = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
          if (this.j) {
            return;
          }
        }
        this.h.post(new ArConfigService.9(this));
        this.j = true;
      }
    }
    else
    {
      this.t = 100;
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArCloudSoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal,mApp is null! ");
      return;
    }
    this.m = f();
    if (!this.m)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arcloud", this.w);
          }
          this.n = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", localException);
          if (this.j) {
            return;
          }
        }
        this.h.post(new ArConfigService.10(this));
        this.j = true;
      }
    }
    else
    {
      this.n = 100;
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "downloadArSDK2SoInternal");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal,mApp is null! ");
      return;
    }
    this.o = g();
    if (!this.o)
    {
      Object localObject = (ARGlobalConfigManager)this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
      if (localObject != null)
      {
        try
        {
          localObject = ((ARGlobalConfigManager)localObject).a(true);
          if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0)) {
            new ArNativeSoManager(localQQAppInterface).a(((ARCommonConfigInfo)localObject).nativeSoResList, "arsdk2", this.v);
          }
          this.p = 0;
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal fail!", localException);
          if (this.j) {
            return;
          }
        }
        this.h.post(new ArConfigService.11(this));
        this.j = true;
      }
    }
    else
    {
      this.p = 100;
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess ");
    }
    RemoteCallbackList localRemoteCallbackList = this.i;
    if (localRemoteCallbackList != null) {}
    for (;;)
    {
      try
      {
        int i2 = localRemoteCallbackList.beginBroadcast();
        i1 = 0;
        if (i1 >= i2) {}
      }
      catch (Exception localException1)
      {
        int i1;
        if (QLog.isColorLevel()) {
          QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess fail!", localException1);
        }
      }
      try
      {
        ((IArSoCallback)this.i.getBroadcastItem(i1)).a();
        i1 += 1;
      }
      catch (Exception localException2) {}
    }
    this.i.finishBroadcast();
    return;
  }
  
  /* Error */
  private void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/mobileqq/ar/ArConfigService:i	Landroid/os/RemoteCallbackList;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +63 -> 69
    //   9: aload_3
    //   10: invokevirtual 155	android/os/RemoteCallbackList:beginBroadcast	()I
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpge +26 -> 44
    //   21: aload_0
    //   22: getfield 81	com/tencent/mobileqq/ar/ArConfigService:i	Landroid/os/RemoteCallbackList;
    //   25: iload_1
    //   26: invokevirtual 159	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   29: checkcast 161	com/tencent/mobileqq/ar/aidl/IArSoCallback
    //   32: invokeinterface 419 1 0
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: istore_1
    //   41: goto -25 -> 16
    //   44: aload_0
    //   45: getfield 81	com/tencent/mobileqq/ar/ArConfigService:i	Landroid/os/RemoteCallbackList;
    //   48: invokevirtual 166	android/os/RemoteCallbackList:finishBroadcast	()V
    //   51: return
    //   52: astore_3
    //   53: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +13 -> 69
    //   59: ldc 130
    //   61: iconst_2
    //   62: ldc_w 421
    //   65: aload_3
    //   66: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: return
    //   70: astore_3
    //   71: goto -27 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ArConfigService
    //   15	26	1	i1	int
    //   13	6	2	i2	int
    //   4	6	3	localRemoteCallbackList	RemoteCallbackList
    //   52	14	3	localException1	Exception
    //   70	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	14	52	java/lang/Exception
    //   44	51	52	java/lang/Exception
    //   21	37	70	java/lang/Exception
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
    return this.g;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate, ");
      ((StringBuilder)localObject).append(this);
      QLog.d("ArConfig_ArConfigService", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.app instanceof QQAppInterface))
    {
      this.a = new WeakReference((QQAppInterface)this.app);
      localObject = (QQAppInterface)this.a.get();
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "onCreate,mApp is null! ");
        return;
      }
      ArResourceManager localArResourceManager = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localArResourceManager != null) {
        localArResourceManager.a(this.f);
      }
      this.b = ((ARGlobalConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER));
      localObject = this.b;
      if (localObject != null) {
        ((ARGlobalConfigManager)localObject).a(this.f);
      }
      FaceScanDownloadManager.a(new ArConfigService.2(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, ");
      localStringBuilder.append(this);
      QLog.d("ArConfig_ArConfigService", 2, localStringBuilder.toString());
    }
    this.d.kill();
    this.e.kill();
    this.d = null;
    this.e = null;
    this.a = null;
    this.b = null;
    FaceScanDownloadManager.a();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    stopSelf();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Object localObject = (QQAppInterface)this.a.get();
    if (localObject != null)
    {
      localObject = (ArResourceManager)((QQAppInterface)localObject).getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
      if (localObject != null) {
        ((ArResourceManager)localObject).b(this.f);
      }
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService
 * JD-Core Version:    0.7.0.1
 */