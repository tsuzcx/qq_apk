import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginUpdater;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class bgmh
  extends bglh
  implements Handler.Callback, bgly, bgme, bgmq
{
  private Application jdField_a_of_type_AndroidAppApplication;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bglb jdField_a_of_type_Bglb;
  private bglv jdField_a_of_type_Bglv;
  private bgmb jdField_a_of_type_Bgmb;
  private bgmm jdField_a_of_type_Bgmm;
  private bgmo jdField_a_of_type_Bgmo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PluginUpdater jdField_a_of_type_CooperationPluginPluginUpdater;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<bgml> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, PluginInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, OnPluginInstallListener> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public bgmh(QQAppInterface paramQQAppInterface)
  {
    QLog.d("plugin_tag", 1, "init plugin manager");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    b();
    this.jdField_a_of_type_CooperationPluginPluginUpdater = new PluginUpdater(this.jdField_a_of_type_AndroidAppApplication, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Bgmo = new bgmo(this.jdField_a_of_type_AndroidAppApplication, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this);
    this.jdField_a_of_type_Bglv = new bglv(this.jdField_a_of_type_AndroidAppApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    try
    {
      this.jdField_a_of_type_Bgmb = new bgmb(this.jdField_a_of_type_AndroidAppApplication, bglv.a(this.jdField_a_of_type_AndroidAppApplication).getCanonicalPath());
      label160:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_Bglb = bglb.a(this.jdField_a_of_type_AndroidAppApplication);
      this.jdField_a_of_type_Bgmm = new bgmm(this);
      this.jdField_a_of_type_Bgmm.a();
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      localPluginCommunicationHandler.setCommunicationChannel(new bgmr());
      localPluginCommunicationHandler.register(new bgms(paramQQAppInterface));
      paramQQAppInterface = PluginManageHandler.getInstance();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
        paramQQAppInterface.setPluginManagerProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      }
      QLog.d("plugin_tag", 1, "init plugin manager end");
      return;
    }
    catch (IOException localIOException)
    {
      break label160;
    }
  }
  
  private static AlertDialog a(Context paramContext, String paramString, long paramLong, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = ajya.a(2131708295) + paramString + "（" + bglc.a(paramLong) + ajya.a(2131708292);; paramString = paramString + "（" + bglc.a(paramLong) + ajya.a(2131708294)) {
      return new AlertDialog.Builder(paramContext).setMessage(paramString).setNegativeButton(ajya.a(2131708293), paramOnClickListener2).setPositiveButton(ajya.a(2131708297), paramOnClickListener1).create();
    }
  }
  
  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ProgressDialog(paramContext);
    paramContext.setProgressStyle(1);
    paramContext.setIndeterminate(false);
    paramContext.setTitle(paramString);
    paramContext.setMessage(ajya.a(2131708296));
    paramContext.setCancelable(false);
    paramContext.setButton(-2, ajya.a(2131708298), new bgmi(paramOnClickListener));
    return paramContext;
  }
  
  private void a(int paramInt, Context paramContext, bglq parambglq, bglo parambglo)
  {
    a(paramInt, false, paramContext, parambglq, parambglo);
  }
  
  private void a(int paramInt, boolean paramBoolean, Context paramContext, bglq parambglq, bglo parambglo)
  {
    QLog.d("plugin_tag", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + parambglq.b + ", " + this.c);
    if ((!this.c) && (!bglb.b(parambglq.b))) {
      if (parambglo != null) {
        parambglo.a(false, paramContext, parambglq);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (parambglo == null);
        parambglo.a(false, paramContext, parambglq);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (parambglo == null);
      localObject1 = this.jdField_a_of_type_Bgmb.a(parambglq.b);
      if ((localObject1 != null) && (((PluginInfo)localObject1).mInstalledPath != null))
      {
        parambglq.c = ((PluginInfo)localObject1).mInstalledPath;
        parambglq.a((PluginBaseInfo)localObject1);
      }
      parambglo.a(true, paramContext, parambglq);
      return;
      if (paramInt == 4)
      {
        localObject1 = parambglq.b;
        localObject2 = new bgml();
        ((bgml)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
        ((bgml)localObject2).jdField_a_of_type_Bglq = parambglq;
        ((bgml)localObject2).jdField_a_of_type_Bglo = parambglo;
        ((bgml)localObject2).jdField_a_of_type_Boolean = true;
        a((String)localObject1, new bgmn(this, (bgml)localObject2));
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = parambglq.b;
        localObject1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a((String)localObject2);
        if (localObject1 == null) {}
        for (localObject1 = "";; localObject1 = ((PluginInfo)localObject1).mName)
        {
          bgml localbgml = new bgml();
          localbgml.jdField_a_of_type_AndroidContentContext = paramContext;
          localbgml.jdField_a_of_type_Bglq = parambglq;
          localbgml.jdField_a_of_type_Bglo = parambglo;
          localbgml.jdField_a_of_type_Boolean = false;
          localbgml.jdField_a_of_type_AndroidAppProgressDialog = a(paramContext, (String)localObject1, new bgmj(this, parambglq.b, null));
          a((String)localObject2, paramBoolean, new bgmn(this, localbgml));
          return;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = parambglq.b;
    Object localObject2 = new bgml();
    ((bgml)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((bgml)localObject2).jdField_a_of_type_Bglq = parambglq;
    ((bgml)localObject2).jdField_a_of_type_Bglo = parambglo;
    ((bgml)localObject2).jdField_a_of_type_Boolean = true;
    a((String)localObject1, paramBoolean, new bgmn(this, (bgml)localObject2));
  }
  
  private void a(String paramString, bglp parambglp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doQueryPlugin: " + paramString + ", " + parambglp);
    }
    PluginInfo localPluginInfo2 = b(paramString);
    PluginInfo localPluginInfo1 = localPluginInfo2;
    if (localPluginInfo2 != null) {
      localPluginInfo1 = localPluginInfo2.a();
    }
    b();
    parambglp.a(paramString, localPluginInfo1, this);
  }
  
  public static boolean a()
  {
    boolean bool3 = false;
    if (!DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.disable_dex2oat.name())) {}
    for (boolean bool1 = true; bool1; bool1 = false)
    {
      boolean bool4 = Dex2Oat.a();
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (bool4)
        {
          bool2 = bool3;
          if (Build.VERSION.SDK_INT >= 21) {
            bool2 = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 1, "isPluginSupportDex2Oat = " + bool2 + ", " + bool4);
      }
      return bool2;
    }
    return bool1;
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Bglb.a(paramString);
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
  }
  
  private PluginInfo b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "fetchPlugin :" + paramString);
    }
    Object localObject2 = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      PluginInfo localPluginInfo = this.jdField_a_of_type_Bgmb.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed info :" + localPluginInfo);
      }
      localObject1 = localObject2;
      if (localPluginInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "up to day info");
          }
          localObject1 = localPluginInfo;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
      }
      return localObject2;
      int i = ((PluginInfo)localObject2).mState;
      if ((i != -1) && (i != 4))
      {
        localObject1 = localObject2;
        if (i != -2) {}
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        localObject1 = localObject2;
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
    }
    File localFile1 = this.jdField_a_of_type_AndroidAppApplication.getDir("plugins", 0);
    File localFile2 = this.jdField_a_of_type_AndroidAppApplication.getDir("NetPlugins", 0);
    try
    {
      bbdx.a(localFile1.getCanonicalPath());
      bbdx.a(localFile2.getCanonicalPath());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private boolean b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(66049);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      if ((localPluginInfo != null) && (localPluginInfo.mState == 1) && (localPluginInfo.a == 1)) {
        cancelInstall(localPluginInfo.mID);
      }
    }
  }
  
  private void c(Context paramContext, bglq parambglq, bglo parambglo)
  {
    int j = 2;
    boolean bool2 = false;
    boolean bool3 = true;
    if (parambglq == null) {}
    PluginInfo localPluginInfo2;
    boolean bool4;
    boolean bool1;
    label309:
    do
    {
      do
      {
        return;
        QLog.d("plugin_tag", 1, "checkUpdate:" + parambglq.b + ", " + parambglq.e);
        if ((this.c) || (bglb.b(parambglq.b))) {
          break;
        }
      } while (parambglo == null);
      parambglo.a(false, paramContext, parambglq);
      return;
      String str = parambglq.b;
      localPluginInfo2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(str);
      if (localPluginInfo2 == null)
      {
        a(0, paramContext, parambglq, parambglo);
        return;
      }
      bool4 = this.jdField_a_of_type_Bgmb.a(str);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed :" + bool4);
      }
      if (bool4)
      {
        PluginInfo localPluginInfo1 = this.jdField_a_of_type_Bgmb.a(str);
        bool1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo1);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "up to day :" + bool1);
        }
        localObject = localPluginInfo1;
        if (bool1)
        {
          int i = j;
          if (a())
          {
            i = j;
            if (Dex2Oat.a(localPluginInfo1.mFingerPrint))
            {
              if (!bglz.a(localPluginInfo2, this.jdField_a_of_type_AndroidAppApplication)) {
                break label309;
              }
              QLog.d("plugin_tag", 1, "systemOTA but running " + str);
              i = j;
            }
          }
          for (;;)
          {
            a(i, paramContext, parambglq, parambglo);
            return;
            i = 4;
            QLog.d("plugin_tag", 1, "systemOTA runDex2Oat");
          }
        }
      }
      else
      {
        localObject = null;
      }
      if ((!bglz.a(localPluginInfo2, this.jdField_a_of_type_AndroidAppApplication)) || (localObject == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
    } while (parambglo == null);
    parambglq.c = ((PluginInfo)localObject).mInstalledPath;
    parambglq.a((PluginBaseInfo)localObject);
    parambglo.a(true, paramContext, parambglq);
    return;
    if ((localPluginInfo2.mUpdateType == 0) && (bool4)) {
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "forceUpdate, deamonInstall：" + bool1 + ", " + bool2);
      }
      if (!bool2) {
        break;
      }
      a(3, paramContext, parambglq, parambglo);
      return;
      bool1 = bool3;
      if (localPluginInfo2.mInstallType != 1)
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    if (localObject != null) {}
    for (Object localObject = ((PluginInfo)localObject).mFingerPrint;; localObject = null)
    {
      parambglq = new bgmk(this, parambglo, bool1, paramContext, parambglq, bool4, (String)localObject, null);
      a(paramContext, localPluginInfo2.mName, localPluginInfo2.mLength, parambglq, parambglq, bool1).show();
      return;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "getPluginList");
        }
        boolean bool = this.jdField_b_of_type_Boolean;
        if (bool) {
          return;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          if (!bbfj.g(this.jdField_a_of_type_AndroidAppApplication)) {
            a(false);
          } else {
            this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
      finally {}
    }
  }
  
  private void f()
  {
    if (NetworkState.isMobile()) {
      c();
    }
    while ((!NetworkState.isWifiConn()) || (!this.c)) {
      return;
    }
    this.jdField_a_of_type_Bgmo.b();
  }
  
  public PluginInfo a(String paramString)
  {
    PluginInfo localPluginInfo = b(paramString);
    paramString = localPluginInfo;
    if (localPluginInfo != null) {
      paramString = localPluginInfo.a();
    }
    b();
    return paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    b();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1) && (paramInt2 > 0)) {
      ((PluginInfo)localObject).mDownloadProgress = (paramInt1 / paramInt2);
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallDownloadProgress(paramString, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void a(Context paramContext, bglq parambglq, bglo parambglo)
  {
    if ((!this.c) && (!bglb.b(parambglq.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        bgml localbgml;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "mPendingLaunchStateList not empty");
          }
          localbgml = new bgml();
          localbgml.jdField_a_of_type_AndroidContentContext = paramContext;
          localbgml.jdField_a_of_type_Bglq = parambglq;
          localbgml.jdField_a_of_type_Bglo = parambglo;
          this.jdField_a_of_type_JavaUtilArrayList.add(localbgml);
          return;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          b();
          localbgml = new bgml();
          localbgml.jdField_a_of_type_AndroidContentContext = paramContext;
          localbgml.jdField_a_of_type_Bglq = parambglq;
          localbgml.jdField_a_of_type_Bglo = parambglo;
          this.jdField_a_of_type_JavaUtilArrayList.add(localbgml);
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "set mPendingLaunchStateList");
          }
          return;
        }
      }
    }
    c(paramContext, parambglq, parambglo);
  }
  
  public void a(String paramString)
  {
    installPlugin(paramString, null);
  }
  
  public void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    QLog.d("plugin_tag", 1, "dex2oatPlugin." + paramString);
    PluginInfo localPluginInfo = this.jdField_a_of_type_Bgmb.a(paramString);
    if (localPluginInfo == null) {
      return;
    }
    if (bglz.a(localPluginInfo, this.jdField_a_of_type_AndroidAppApplication))
    {
      QLog.d("plugin_tag", 1, "dex2oatPlugin plugin still running " + paramString);
      return;
    }
    if (paramOnPluginInstallListener != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramOnPluginInstallListener);
    }
    localPluginInfo.mState = 5;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginInfo);
    this.jdField_a_of_type_Bgmb.b(localPluginInfo, this);
  }
  
  public void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean)
  {
    a(paramString, false, paramBoolean, paramOnPluginInstallListener);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, " recordPluginStartupTime " + paramString1 + ", key = " + paramString2 + ", span = " + paramLong);
    }
    paramString1 = this.jdField_a_of_type_Bgmb.a(paramString1);
    if (paramString1 != null)
    {
      if (!"pluginApkCost".equals(paramString2)) {
        break label81;
      }
      paramString1.costApk = paramLong;
    }
    label81:
    do
    {
      return;
      if ("pluginOatCost".equals(paramString2))
      {
        paramString1.costDex2Oat = paramLong;
        return;
      }
      if ("pluginDownloadCost".equals(paramString2))
      {
        paramString1.costDownload = paramLong;
        return;
      }
    } while (!"pluginLibCost".equals(paramString2));
    paramString1.costLib = paramLong;
  }
  
  public void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, paramBoolean, false, paramOnPluginInstallListener);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, OnPluginInstallListener paramOnPluginInstallListener)
  {
    QLog.d("plugin_tag", 1, "installPlugin." + paramString);
    PluginInfo localPluginInfo1 = null;
    if (paramBoolean1)
    {
      localPluginInfo1 = this.jdField_a_of_type_Bglb.a(paramString);
      if ((localPluginInfo1 == null) && (paramOnPluginInstallListener == null)) {}
    }
    for (;;)
    {
      try
      {
        paramOnPluginInstallListener.onInstallError(paramString, 1);
        return;
      }
      catch (RemoteException paramString) {}
      PluginInfo localPluginInfo2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
      if (localPluginInfo2 == null) {
        break;
      }
      localPluginInfo1 = localPluginInfo2.a();
      break;
      if (bglz.a(localPluginInfo1, this.jdField_a_of_type_AndroidAppApplication))
      {
        QLog.d("plugin_tag", 1, "plugin still running");
        if (paramOnPluginInstallListener == null) {
          continue;
        }
        try
        {
          paramOnPluginInstallListener.onInstallError(paramString, 2);
          return;
        }
        catch (RemoteException paramString)
        {
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin not run");
      }
      if (paramOnPluginInstallListener != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramOnPluginInstallListener);
      }
      localPluginInfo1.mState = 5;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginInfo1);
      if ((a(paramString)) || (paramBoolean1))
      {
        this.jdField_a_of_type_Bgmb.a(localPluginInfo1, this);
        return;
      }
      this.jdField_a_of_type_Bglv.a(localPluginInfo1, this, paramBoolean2);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = true;
    if (!paramBoolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label121;
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending");
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        bgml localbgml = (bgml)localIterator.next();
        c(localbgml.jdField_a_of_type_AndroidContentContext, localbgml.jdField_a_of_type_Bglq, localbgml.jdField_a_of_type_Bglo);
      }
      this.jdField_a_of_type_Bgmo.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      return;
      label121:
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "mPendingLaunchStateList empty");
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onDownloadFinish:" + paramBoolean);
    }
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      if (!paramBoolean) {
        break label72;
      }
      ((PluginInfo)localObject).mState = 2;
      ((PluginInfo)localObject).mDownloadProgress = 1.0F;
      this.jdField_a_of_type_Bgmb.a((PluginInfo)localObject, this);
    }
    label72:
    do
    {
      return;
      ((PluginInfo)localObject).mState = -2;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    } while (localObject == null);
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 5);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_Bglv.a(paramPluginInfo.mID);
    return this.jdField_a_of_type_Bgmb.b(paramPluginInfo.mID);
  }
  
  public void b(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    ((PluginInfo)localObject).mState = -2;
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 4);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localPluginInfo != null) {
      if (!paramBoolean) {
        break label70;
      }
    }
    for (int i = 4;; i = -2)
    {
      localPluginInfo.mState = i;
      if ((localOnPluginInstallListener != null) && (!paramBoolean)) {
        break;
      }
      label70:
      try
      {
        localOnPluginInstallListener.onInstallFinish(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    }
    try
    {
      localOnPluginInstallListener.onInstallError(paramString, 7);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void c(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((PluginInfo)localObject).mState = 1;
      ((PluginInfo)localObject).a = bbfj.b(this.jdField_a_of_type_AndroidAppApplication);
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallBegin(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void cancelInstall(String paramString)
  {
    this.jdField_a_of_type_Bglv.a(paramString);
    this.jdField_a_of_type_Bgmb.b(paramString);
  }
  
  public void d(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1))
    {
      ((PluginInfo)localObject).mState = -1;
      ((PluginInfo)localObject).a = 0;
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 3);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void e(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {
      ((PluginInfo)localObject).mState = -2;
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 6);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void f(String paramString)
  {
    paramString = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      paramString.mState = 3;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 65536: 
      a(paramMessage.getData().getString("index_for_id"), (bglp)paramMessage.obj);
      return true;
    case 66049: 
      e();
      return true;
    case 66304: 
      f();
      return true;
    }
    d();
    return true;
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, false, false, paramOnPluginInstallListener);
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.mState == 4)
      {
        bool1 = bool2;
        if (paramString.mInstalledPath != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isReady()
  {
    return this.c;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65537).sendToTarget();
    this.jdField_a_of_type_Bgmm.b();
    ??? = PluginCommunicationHandler.getInstance();
    ((PluginCommunicationHandler)???).setCommunicationChannel(null);
    ((PluginCommunicationHandler)???).unregister("common.get_qq_app_interface_data");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmh
 * JD-Core Version:    0.7.0.1
 */