import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginManager.1;
import cooperation.qzone.plugin.QZonePluginManager.2;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class bgau
  extends bfzg
  implements Handler.Callback, bfzz, bgam, bgar, bgas, bgbe, Manager
{
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bfzx jdField_a_of_type_Bfzx;
  private bgai jdField_a_of_type_Bgai;
  private bgao jdField_a_of_type_Bgao;
  bgav jdField_a_of_type_Bgav;
  private bgba jdField_a_of_type_Bgba;
  private bgbc jdField_a_of_type_Bgbc;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<bfzn> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, PluginRecord> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, WeakReference<bfzq>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public bgau(QQAppInterface paramQQAppInterface)
  {
    QLog.i("QZonePluginManger", 1, "QZonePluginManager init");
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApp();
    this.jdField_a_of_type_Bgbc = new bgbc(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Bgbc.a(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Bgai = new bgai(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bfzx = new bfzx(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bgao = new bgao(this.jdField_a_of_type_AndroidContentContext);
    this.c = false;
    bgbh.a().a(paramQQAppInterface);
  }
  
  private void a(int paramInt, Context paramContext, bfzm parambfzm, bfzl parambfzl)
  {
    if (parambfzm == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              QLog.i("QZonePluginManger", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + parambfzm.b);
            } while (c());
            if (this.jdField_b_of_type_Boolean) {
              break;
            }
          } while (parambfzl == null);
          parambfzl.a(false, paramContext, parambfzm);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (parambfzl == null);
        parambfzl.a(false, paramContext, parambfzm);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (parambfzl == null);
      localObject1 = this.jdField_a_of_type_Bgao.a(parambfzm.b);
      if (localObject1 != null) {
        parambfzm.c = ((PluginRecord)localObject1).mInstalledPath;
      }
      parambfzl.a(true, paramContext, parambfzm);
      return;
      if (paramInt == 1)
      {
        localObject1 = parambfzm.b;
        localObject2 = this.jdField_a_of_type_Bgbc.a((String)localObject1);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = new bgav();
          ((bgav)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
          ((bgav)localObject2).jdField_a_of_type_Bfzm = parambfzm;
          ((bgav)localObject2).jdField_a_of_type_Bfzl = parambfzl;
          try
          {
            a((String)localObject1, new bgaw(this, (bgav)localObject2), 0);
            return;
          }
          catch (RemoteException paramContext)
          {
            QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
            return;
          }
          localObject2 = ((PluginRecord)localObject2).name;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = parambfzm.b;
    Object localObject2 = new bgav();
    ((bgav)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((bgav)localObject2).jdField_a_of_type_Bfzm = parambfzm;
    ((bgav)localObject2).jdField_a_of_type_Bfzl = parambfzl;
    try
    {
      a((String)localObject1, new bgaw(this, (bgav)localObject2), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QZonePluginManager.1(this, paramString, paramInt));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private PluginRecord b(String paramString)
  {
    if (c()) {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner: manager is close. pluginId=" + paramString);
    }
    do
    {
      return null;
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner " + paramString + "");
    } while (TextUtils.isEmpty(paramString));
    PluginRecord localPluginRecord2 = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    QLog.i("QZonePluginManger", 1, "mProcessingPlugins getInstalledPlugininfo " + localPluginRecord2 + "");
    PluginRecord localPluginRecord1;
    if (localPluginRecord2 == null)
    {
      localPluginRecord1 = this.jdField_a_of_type_Bgao.a(paramString);
      QLog.i("QZonePluginManger", 1, "installer getInstalledPlugininfo " + localPluginRecord1 + "");
      if (localPluginRecord1 == null)
      {
        localPluginRecord1 = this.jdField_a_of_type_Bgbc.a(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
      }
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner final record " + localPluginRecord1 + "");
      return localPluginRecord1;
      boolean bool = this.jdField_a_of_type_Bgbc.a(localPluginRecord1);
      QLog.i("QZonePluginManger", 1, "updater.checkUpToDate: " + bool + "");
      if (!bool)
      {
        localPluginRecord1 = this.jdField_a_of_type_Bgbc.a(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
        continue;
        int i = localPluginRecord2.state;
        if ((i != -1) && (i != 4))
        {
          localPluginRecord1 = localPluginRecord2;
          if (i != -2) {}
        }
        else
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
          localPluginRecord1 = localPluginRecord2;
        }
      }
    }
  }
  
  private void b(Context paramContext, bfzm parambfzm, bfzl parambfzl)
  {
    if (parambfzm == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("QZonePluginManger", 1, "checkUpdate:" + parambfzm.b);
        } while (c());
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (parambfzl == null);
      parambfzl.a(false, paramContext, parambfzm);
      return;
      localObject = parambfzm.b;
      PluginRecord localPluginRecord = this.jdField_a_of_type_Bgbc.b((String)localObject);
      if (localPluginRecord == null)
      {
        a(0, paramContext, parambfzm, parambfzl);
        return;
      }
      boolean bool = a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "installed :" + bool);
      }
      localObject = this.jdField_a_of_type_Bgao.a((String)localObject);
      if (bool)
      {
        bool = this.jdField_a_of_type_Bgbc.a((PluginRecord)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "up to day :" + bool);
        }
        if (bool)
        {
          a(2, paramContext, parambfzm, parambfzl);
          return;
        }
      }
      if ((!bgbf.a(localPluginRecord, paramContext)) || (localPluginRecord == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "plugin still running");
      }
    } while (parambfzl == null);
    parambfzm.c = ((PluginRecord)localObject).mInstalledPath;
    parambfzl.a(true, paramContext, parambfzm);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "forceUpdate, deamonInstall：" + true + ", " + true);
    }
    a(3, paramContext, parambfzm, parambfzl);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (c()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("pluginid", paramString);
    awrn.a(this.jdField_a_of_type_AndroidContentContext).a(null, "actQzonePluginPatch", true, 0L, 0L, localHashMap, null);
  }
  
  public static boolean b()
  {
    boolean bool2 = true;
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadOnlyWifi", 1);
    QLog.d("QZonePluginManger", 1, "canDownloadPlugin, onlyWifi=" + i);
    boolean bool1;
    if (i > 0) {
      bool1 = NetworkState.isWifiConn();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            i = NetworkState.getNetworkType();
            QLog.d("QZonePluginManger", 1, "network type = " + i);
            bool1 = bool2;
          } while (1 == i);
          bool1 = bool2;
        } while (4 == i);
        bool1 = bool2;
      } while (5 == i);
      bool1 = bool2;
    } while (3 == i);
    return false;
  }
  
  private void c()
  {
    QLog.i("QZonePluginManger", 2, "getPluginList  pluginInfoRequesting:" + this.jdField_a_of_type_Boolean);
    if (c()) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bgbc.a();
  }
  
  private boolean c()
  {
    return this.c;
  }
  
  private void d()
  {
    QLog.i("QZonePluginManger", 1, "getPluginListIfNeed  pluginInfoRequesting:" + this.jdField_a_of_type_Boolean + " isReady:" + a() + " :lastUpdateSuccess:" + this.d);
    if (c()) {}
    while ((this.jdField_a_of_type_Boolean) || (this.d)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public PluginRecord a(String paramString)
  {
    if (c()) {
      QLog.i("QZonePluginManger", 1, "queryPlugin: manager is close. pluginId=" + paramString);
    }
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PluginRecord localPluginRecord2 = b(paramString);
    PluginRecord localPluginRecord1 = localPluginRecord2;
    if (localPluginRecord2 != null) {
      localPluginRecord1 = localPluginRecord2.clone();
    }
    d();
    QLog.i("QZonePluginManger", 1, "queryPlugin queryPlugin：" + paramString + ",record:" + localPluginRecord1);
    return localPluginRecord1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    }
    QQAppInterface localQQAppInterface = bgbh.a().a();
    if (localQQAppInterface == null) {
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter, app is null");
    }
    do
    {
      do
      {
        return;
      } while (!awlw.c());
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    } while (awlw.a(BaseApplicationImpl.getContext()));
    awlw.a(localQQAppInterface, BaseApplicationImpl.getContext());
  }
  
  public void a(Context paramContext, bfzm parambfzm, bfzl parambfzl)
  {
    if (c())
    {
      QLog.w("QZonePluginManger", 1, "QZonePluginManagerIsClosed=true");
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Bgav != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "mPengdingLaunchState already set");
          }
          if (parambfzl != null) {
            parambfzl.a(false, paramContext, parambfzm);
          }
          return;
        }
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        d();
        bgav localbgav = new bgav();
        localbgav.jdField_a_of_type_AndroidContentContext = paramContext;
        localbgav.jdField_a_of_type_Bfzm = parambfzm;
        localbgav.jdField_a_of_type_Bfzl = parambfzl;
        this.jdField_a_of_type_Bgav = localbgav;
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "set mPendingLaunchState");
        }
        return;
      }
    }
    b(paramContext, parambfzm, parambfzl);
  }
  
  public void a(bfzn parambfzn, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "installPituSo");
    if (bgbh.a().a() == null) {
      QLog.w("QZonePluginManger", 1, "installPituSo, app is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambfzn);
      parambfzn = bfpr.b();
    } while (TextUtils.isEmpty(parambfzn));
    this.jdField_a_of_type_Bfzx.a(parambfzn, this, paramInt);
  }
  
  public void a(bfzy parambfzy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      parambfzy = (bfzn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (parambfzy != null) {
        parambfzy.a();
      }
      return;
    }
    catch (RemoteException parambfzy)
    {
      QLog.e("QZonePluginManger", 1, parambfzy, new Object[0]);
    }
  }
  
  public void a(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onDownLoadStart record:" + paramPluginRecord);
    if (c()) {
      break label33;
    }
    for (;;)
    {
      label33:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        ((PluginRecord)localObject).state = 1;
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (bfzq)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((bfzq)localObject).a(paramPluginRecord.id);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void a(PluginRecord paramPluginRecord, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadFailed record:" + paramPluginRecord);
    if (c()) {
      break label33;
    }
    label33:
    Object localObject;
    for (;;)
    {
      return;
      if (paramPluginRecord != null)
      {
        paramPluginRecord.state = -2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.id);
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (bfzq)((WeakReference)localObject).get();
          if (localObject != null) {
            if (-9998 == paramInt)
            {
              ((bfzq)localObject).a(paramPluginRecord.id, 8);
              b(paramPluginRecord.id, 8);
              return;
            }
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
          return;
        }
      }
    }
    ((bfzq)localObject).a(paramPluginRecord.id, 5);
    b(paramPluginRecord.id, 5);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("QZonePluginManger", 1, "onUpdatefinish success:" + paramBoolean);
    if (c()) {
      return;
    }
    this.d = paramBoolean;
    this.jdField_b_of_type_Boolean = true;
    if ((paramBoolean) && (this.jdField_a_of_type_Bgba != null)) {
      this.jdField_a_of_type_Bgba.a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bgav != null)
      {
        QLog.i("QZonePluginManger", 1, "onUpdateFinish. handle pending launch state");
        bgav localbgav = this.jdField_a_of_type_Bgav;
        b(localbgav.jdField_a_of_type_AndroidContentContext, localbgav.jdField_a_of_type_Bfzm, localbgav.jdField_a_of_type_Bfzl);
        this.jdField_a_of_type_Bgav = null;
        this.jdField_a_of_type_AndroidOsHandler.post(new QZonePluginManager.2(this));
        return;
      }
      QLog.i("QZonePluginManger", 1, "mPendingLaunchState is null");
    }
  }
  
  public void a(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onInstallFinish record:" + paramPluginRecord);
    if (c()) {}
    while (paramPluginRecord == null) {
      return;
    }
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.id);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.id);
      if (paramBoolean)
      {
        if (localObject != null)
        {
          localObject = (bfzq)((WeakReference)localObject).get();
          if (localObject != null) {
            ((bfzq)localObject).b(paramPluginRecord.id);
          }
        }
        b(paramPluginRecord.id, 0);
        return;
      }
    }
    catch (RemoteException paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
      return;
    }
    if (localObject != null)
    {
      localObject = (bfzq)((WeakReference)localObject).get();
      if (localObject != null) {
        ((bfzq)localObject).a(paramPluginRecord.id, 7);
      }
    }
    b(paramPluginRecord.id, 7);
  }
  
  public boolean a()
  {
    if (c()) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    QLog.i("QZonePluginManger", 1, "isPluginInstalled: " + paramString);
    if (c()) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      paramString = a(paramString);
    } while (paramString == null);
    QLog.i("QZonePluginManger", 1, " isPluginInstalled record :" + paramString);
    if (paramString.state == 4) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(String paramString, bfzq parambfzq, int paramInt)
  {
    if (c()) {
      QLog.i("QZonePluginManger", 1, "installPlugin: manager is closed. pluginId=" + paramString);
    }
    do
    {
      return false;
      QLog.i("QZonePluginManger", 1, "installPlugin pluginid=" + paramString + " refer=" + paramInt);
    } while (TextUtils.isEmpty(paramString));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      QLog.d("QZonePluginManger", 1, "installPlugin pluginid:" + paramString + ",正在处理，skip。。。");
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new WeakReference(parambfzq));
    PluginRecord localPluginRecord1 = this.jdField_a_of_type_Bgbc.a(paramString);
    if (localPluginRecord1 != null)
    {
      PluginRecord localPluginRecord2 = this.jdField_a_of_type_Bgao.a(paramString);
      if ((localPluginRecord2 != null) && (localPluginRecord2.state == 4) && (this.jdField_a_of_type_Bgbc.a(localPluginRecord2)))
      {
        QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 已安装");
        if (parambfzq != null) {
          parambfzq.b(paramString);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bgba == null) {
        this.jdField_a_of_type_Bgba = new bgba(this, this.jdField_a_of_type_Bgbc);
      }
      return true;
      QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 未安装,开始下载");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginRecord1);
      this.jdField_a_of_type_Bgai.a(localPluginRecord1, this, paramInt);
      a(localPluginRecord1.id, paramInt);
      continue;
      QLog.e("QZonePluginManger", 1, "installPlugin record==null 没有插件信息，失败");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (parambfzq != null) {
        parambfzq.a(paramString, 1);
      }
      b(paramString, 1);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    d();
  }
  
  public void b(bfzy parambfzy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      parambfzy = (bfzn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (parambfzy != null) {
        parambfzy.c();
      }
      return;
    }
    catch (RemoteException parambfzy)
    {
      QLog.e("QZonePluginManger", 1, parambfzy, new Object[0]);
    }
  }
  
  public void b(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadCanceled record:" + paramPluginRecord);
    if (c()) {}
    while (paramPluginRecord == null) {
      return;
    }
    paramPluginRecord.state = -1;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.id);
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.id);
    if (localObject != null) {}
    try
    {
      localObject = (bfzq)((WeakReference)localObject).get();
      if (localObject != null) {
        ((bfzq)localObject).a(paramPluginRecord.id, 3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
      }
    }
    b(paramPluginRecord.id, 3);
  }
  
  public void b(PluginRecord paramPluginRecord, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadSucceed record:" + paramPluginRecord + " refer=" + paramInt);
    if (c()) {}
    PluginRecord localPluginRecord;
    do
    {
      do
      {
        return;
      } while (paramPluginRecord == null);
      localPluginRecord = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
    } while (localPluginRecord == null);
    localPluginRecord.state = 2;
    boolean bool;
    if ((a(paramInt)) && (bgbf.a(paramPluginRecord, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (!paramPluginRecord.id.equals(bgbf.a())) {
        break label248;
      }
      if (!bgfp.f(bgfp.a())) {
        break label243;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "onDownloadSucceed record=" + paramPluginRecord + " isPluginRealRunning=" + bool);
      Object localObject;
      if (bool)
      {
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject != null)
        {
          localObject = (bfzq)((WeakReference)localObject).get();
          if (localObject == null) {}
        }
      }
      try
      {
        ((bfzq)localObject).a(paramPluginRecord.id, 2);
        b(paramPluginRecord.id, 2);
        this.jdField_a_of_type_Bgao.a(localPluginRecord, this);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
        }
      }
      label243:
      bool = false;
      continue;
      label248:
      bool = true;
    }
  }
  
  public void b(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onUnInstallFinish reslut:" + paramBoolean + "record:" + paramPluginRecord);
    if (c()) {}
  }
  
  public boolean b(String paramString)
  {
    QLog.i("QZonePluginManger", 1, "cancelInstall " + paramString + "");
    if (c()) {}
    while (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = this.jdField_a_of_type_Bgbc.a(paramString);
    this.jdField_a_of_type_Bgai.a(paramString, this);
    return false;
  }
  
  public void c(bfzy parambfzy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      bfzn localbfzn = (bfzn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbfzn != null) {
        localbfzn.a(parambfzy.jdField_a_of_type_Int);
      }
      return;
    }
    catch (RemoteException parambfzy)
    {
      QLog.e("QZonePluginManger", 1, parambfzy, new Object[0]);
    }
  }
  
  public void c(PluginRecord paramPluginRecord)
  {
    if (c()) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject != null) {
          ((PluginRecord)localObject).state = 1;
        }
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (bfzq)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((bfzq)localObject).a(paramPluginRecord.id, paramPluginRecord.progress, paramPluginRecord.size);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public boolean c(String paramString)
  {
    QLog.i("QZonePluginManger", 1, "uninstallPlugin " + paramString);
    if (c()) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      paramString = this.jdField_a_of_type_Bgbc.a(paramString);
      this.jdField_a_of_type_Bgao.a(paramString, null);
      this.jdField_a_of_type_Bgai.a(paramString, this);
      paramString = bfpr.b();
    } while (TextUtils.isEmpty(paramString));
    this.jdField_a_of_type_Bfzx.a(paramString);
    return false;
  }
  
  public void d(bfzy parambfzy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      parambfzy = (bfzn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (parambfzy != null) {
        parambfzy.b();
      }
      return;
    }
    catch (RemoteException parambfzy)
    {
      QLog.e("QZonePluginManger", 1, parambfzy, new Object[0]);
    }
  }
  
  public void d(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onInstallBegin record:" + paramPluginRecord);
    if (c()) {
      break label33;
    }
    for (;;)
    {
      label33:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        ((PluginRecord)localObject).state = 3;
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (bfzq)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((bfzq)localObject).a(paramPluginRecord.id);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void e(bfzy parambfzy)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (parambfzy != null)) {}
    try
    {
      bfzn localbfzn = (bfzn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbfzn != null) {
        localbfzn.a(parambfzy.jdField_a_of_type_Float);
      }
      return;
    }
    catch (RemoteException parambfzy)
    {
      QLog.e("QZonePluginManger", 1, parambfzy, new Object[0]);
    }
  }
  
  public void e(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onUnInstallBegin record:" + paramPluginRecord);
    if (c()) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
    }
  }
  
  public void onDestroy()
  {
    QLog.i("QZonePluginManger", 1, "onDestroy");
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Bgbc = null;
    this.jdField_a_of_type_Bgao = null;
    if (this.jdField_a_of_type_Bgai != null) {
      this.jdField_a_of_type_Bgai.a();
    }
    this.jdField_a_of_type_Bfzx = null;
    this.jdField_a_of_type_Bgai = null;
    if (this.jdField_a_of_type_Bgba != null) {
      this.jdField_a_of_type_Bgba.b();
    }
    this.jdField_a_of_type_Bgba = null;
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgau
 * JD-Core Version:    0.7.0.1
 */