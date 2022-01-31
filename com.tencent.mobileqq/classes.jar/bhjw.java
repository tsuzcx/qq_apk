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

public class bhjw
  extends bhii
  implements Handler.Callback, bhjb, bhjo, bhjt, bhju, bhkg, Manager
{
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhiz jdField_a_of_type_Bhiz;
  private bhjk jdField_a_of_type_Bhjk;
  private bhjq jdField_a_of_type_Bhjq;
  bhjx jdField_a_of_type_Bhjx;
  private bhkc jdField_a_of_type_Bhkc;
  private bhke jdField_a_of_type_Bhke;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<bhip> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, PluginRecord> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, WeakReference<bhis>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public bhjw(QQAppInterface paramQQAppInterface)
  {
    QLog.i("QZonePluginManger", 1, "QZonePluginManager init");
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApp();
    this.jdField_a_of_type_Bhke = new bhke(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Bhke.a(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Bhjk = new bhjk(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bhiz = new bhiz(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bhjq = new bhjq(this.jdField_a_of_type_AndroidContentContext);
    this.c = false;
    bhkj.a().a(paramQQAppInterface);
  }
  
  private void a(int paramInt, Context paramContext, bhio parambhio, bhin parambhin)
  {
    if (parambhio == null) {}
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
              QLog.i("QZonePluginManger", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + parambhio.b);
            } while (c());
            if (this.jdField_b_of_type_Boolean) {
              break;
            }
          } while (parambhin == null);
          parambhin.a(false, paramContext, parambhio);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (parambhin == null);
        parambhin.a(false, paramContext, parambhio);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (parambhin == null);
      localObject1 = this.jdField_a_of_type_Bhjq.a(parambhio.b);
      if (localObject1 != null) {
        parambhio.c = ((PluginRecord)localObject1).mInstalledPath;
      }
      parambhin.a(true, paramContext, parambhio);
      return;
      if (paramInt == 1)
      {
        localObject1 = parambhio.b;
        localObject2 = this.jdField_a_of_type_Bhke.a((String)localObject1);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = new bhjx();
          ((bhjx)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
          ((bhjx)localObject2).jdField_a_of_type_Bhio = parambhio;
          ((bhjx)localObject2).jdField_a_of_type_Bhin = parambhin;
          try
          {
            a((String)localObject1, new bhjy(this, (bhjx)localObject2), 0);
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
    Object localObject1 = parambhio.b;
    Object localObject2 = new bhjx();
    ((bhjx)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((bhjx)localObject2).jdField_a_of_type_Bhio = parambhio;
    ((bhjx)localObject2).jdField_a_of_type_Bhin = parambhin;
    try
    {
      a((String)localObject1, new bhjy(this, (bhjx)localObject2), 0);
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
      localPluginRecord1 = this.jdField_a_of_type_Bhjq.a(paramString);
      QLog.i("QZonePluginManger", 1, "installer getInstalledPlugininfo " + localPluginRecord1 + "");
      if (localPluginRecord1 == null)
      {
        localPluginRecord1 = this.jdField_a_of_type_Bhke.a(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
      }
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner final record " + localPluginRecord1 + "");
      return localPluginRecord1;
      boolean bool = this.jdField_a_of_type_Bhke.a(localPluginRecord1);
      QLog.i("QZonePluginManger", 1, "updater.checkUpToDate: " + bool + "");
      if (!bool)
      {
        localPluginRecord1 = this.jdField_a_of_type_Bhke.a(paramString);
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
  
  private void b(Context paramContext, bhio parambhio, bhin parambhin)
  {
    if (parambhio == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("QZonePluginManger", 1, "checkUpdate:" + parambhio.b);
        } while (c());
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (parambhin == null);
      parambhin.a(false, paramContext, parambhio);
      return;
      localObject = parambhio.b;
      PluginRecord localPluginRecord = this.jdField_a_of_type_Bhke.b((String)localObject);
      if (localPluginRecord == null)
      {
        a(0, paramContext, parambhio, parambhin);
        return;
      }
      boolean bool = a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "installed :" + bool);
      }
      localObject = this.jdField_a_of_type_Bhjq.a((String)localObject);
      if (bool)
      {
        bool = this.jdField_a_of_type_Bhke.a((PluginRecord)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "up to day :" + bool);
        }
        if (bool)
        {
          a(2, paramContext, parambhio, parambhin);
          return;
        }
      }
      if ((!bhkh.a(localPluginRecord, paramContext)) || (localPluginRecord == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "plugin still running");
      }
    } while (parambhin == null);
    parambhio.c = ((PluginRecord)localObject).mInstalledPath;
    parambhin.a(true, paramContext, parambhio);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "forceUpdate, deamonInstall：" + true + ", " + true);
    }
    a(3, paramContext, parambhio, parambhin);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (c()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("pluginid", paramString);
    axrn.a(this.jdField_a_of_type_AndroidContentContext).a(null, "actQzonePluginPatch", true, 0L, 0L, localHashMap, null);
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
    this.jdField_a_of_type_Bhke.a();
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
    QQAppInterface localQQAppInterface = bhkj.a().a();
    if (localQQAppInterface == null) {
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter, app is null");
    }
    do
    {
      do
      {
        return;
      } while (!axle.c());
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    } while (axle.a(BaseApplicationImpl.getContext()));
    axle.a(localQQAppInterface, BaseApplicationImpl.getContext());
  }
  
  public void a(Context paramContext, bhio parambhio, bhin parambhin)
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
        if (this.jdField_a_of_type_Bhjx != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "mPengdingLaunchState already set");
          }
          if (parambhin != null) {
            parambhin.a(false, paramContext, parambhio);
          }
          return;
        }
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        d();
        bhjx localbhjx = new bhjx();
        localbhjx.jdField_a_of_type_AndroidContentContext = paramContext;
        localbhjx.jdField_a_of_type_Bhio = parambhio;
        localbhjx.jdField_a_of_type_Bhin = parambhin;
        this.jdField_a_of_type_Bhjx = localbhjx;
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "set mPendingLaunchState");
        }
        return;
      }
    }
    b(paramContext, parambhio, parambhin);
  }
  
  public void a(bhip parambhip, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "installPituSo");
    if (bhkj.a().a() == null) {
      QLog.w("QZonePluginManger", 1, "installPituSo, app is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhip);
      parambhip = bgyp.b();
    } while (TextUtils.isEmpty(parambhip));
    this.jdField_a_of_type_Bhiz.a(parambhip, this, paramInt);
  }
  
  public void a(bhja parambhja)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      parambhja = (bhip)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (parambhja != null) {
        parambhja.a();
      }
      return;
    }
    catch (RemoteException parambhja)
    {
      QLog.e("QZonePluginManger", 1, parambhja, new Object[0]);
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
          localObject = (bhis)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((bhis)localObject).a(paramPluginRecord.id);
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
          localObject = (bhis)((WeakReference)localObject).get();
          if (localObject != null) {
            if (-9998 == paramInt)
            {
              ((bhis)localObject).a(paramPluginRecord.id, 8);
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
    ((bhis)localObject).a(paramPluginRecord.id, 5);
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
    if ((paramBoolean) && (this.jdField_a_of_type_Bhkc != null)) {
      this.jdField_a_of_type_Bhkc.a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bhjx != null)
      {
        QLog.i("QZonePluginManger", 1, "onUpdateFinish. handle pending launch state");
        bhjx localbhjx = this.jdField_a_of_type_Bhjx;
        b(localbhjx.jdField_a_of_type_AndroidContentContext, localbhjx.jdField_a_of_type_Bhio, localbhjx.jdField_a_of_type_Bhin);
        this.jdField_a_of_type_Bhjx = null;
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
          localObject = (bhis)((WeakReference)localObject).get();
          if (localObject != null) {
            ((bhis)localObject).b(paramPluginRecord.id);
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
      localObject = (bhis)((WeakReference)localObject).get();
      if (localObject != null) {
        ((bhis)localObject).a(paramPluginRecord.id, 7);
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
  
  public boolean a(String paramString, bhis parambhis, int paramInt)
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
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new WeakReference(parambhis));
    PluginRecord localPluginRecord1 = this.jdField_a_of_type_Bhke.a(paramString);
    if (localPluginRecord1 != null)
    {
      PluginRecord localPluginRecord2 = this.jdField_a_of_type_Bhjq.a(paramString);
      if ((localPluginRecord2 != null) && (localPluginRecord2.state == 4) && (this.jdField_a_of_type_Bhke.a(localPluginRecord2)))
      {
        QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 已安装");
        if (parambhis != null) {
          parambhis.b(paramString);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhkc == null) {
        this.jdField_a_of_type_Bhkc = new bhkc(this, this.jdField_a_of_type_Bhke);
      }
      return true;
      QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 未安装,开始下载");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginRecord1);
      this.jdField_a_of_type_Bhjk.a(localPluginRecord1, this, paramInt);
      a(localPluginRecord1.id, paramInt);
      continue;
      QLog.e("QZonePluginManger", 1, "installPlugin record==null 没有插件信息，失败");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (parambhis != null) {
        parambhis.a(paramString, 1);
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
  
  public void b(bhja parambhja)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      parambhja = (bhip)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (parambhja != null) {
        parambhja.c();
      }
      return;
    }
    catch (RemoteException parambhja)
    {
      QLog.e("QZonePluginManger", 1, parambhja, new Object[0]);
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
      localObject = (bhis)((WeakReference)localObject).get();
      if (localObject != null) {
        ((bhis)localObject).a(paramPluginRecord.id, 3);
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
    if ((a(paramInt)) && (bhkh.a(paramPluginRecord, this.jdField_a_of_type_AndroidContentContext)))
    {
      if (!paramPluginRecord.id.equals(bhkh.a())) {
        break label248;
      }
      if (!bhoy.f(bhoy.a())) {
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
          localObject = (bhis)((WeakReference)localObject).get();
          if (localObject == null) {}
        }
      }
      try
      {
        ((bhis)localObject).a(paramPluginRecord.id, 2);
        b(paramPluginRecord.id, 2);
        this.jdField_a_of_type_Bhjq.a(localPluginRecord, this);
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
    paramString = this.jdField_a_of_type_Bhke.a(paramString);
    this.jdField_a_of_type_Bhjk.a(paramString, this);
    return false;
  }
  
  public void c(bhja parambhja)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      bhip localbhip = (bhip)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbhip != null) {
        localbhip.a(parambhja.jdField_a_of_type_Int);
      }
      return;
    }
    catch (RemoteException parambhja)
    {
      QLog.e("QZonePluginManger", 1, parambhja, new Object[0]);
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
          localObject = (bhis)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((bhis)localObject).a(paramPluginRecord.id, paramPluginRecord.progress, paramPluginRecord.size);
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
      paramString = this.jdField_a_of_type_Bhke.a(paramString);
      this.jdField_a_of_type_Bhjq.a(paramString, null);
      this.jdField_a_of_type_Bhjk.a(paramString, this);
      paramString = bgyp.b();
    } while (TextUtils.isEmpty(paramString));
    this.jdField_a_of_type_Bhiz.a(paramString);
    return false;
  }
  
  public void d(bhja parambhja)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      parambhja = (bhip)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (parambhja != null) {
        parambhja.b();
      }
      return;
    }
    catch (RemoteException parambhja)
    {
      QLog.e("QZonePluginManger", 1, parambhja, new Object[0]);
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
          localObject = (bhis)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((bhis)localObject).a(paramPluginRecord.id);
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
  
  public void e(bhja parambhja)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (parambhja != null)) {}
    try
    {
      bhip localbhip = (bhip)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbhip != null) {
        localbhip.a(parambhja.jdField_a_of_type_Float);
      }
      return;
    }
    catch (RemoteException parambhja)
    {
      QLog.e("QZonePluginManger", 1, parambhja, new Object[0]);
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
    this.jdField_a_of_type_Bhke = null;
    this.jdField_a_of_type_Bhjq = null;
    if (this.jdField_a_of_type_Bhjk != null) {
      this.jdField_a_of_type_Bhjk.a();
    }
    this.jdField_a_of_type_Bhiz = null;
    this.jdField_a_of_type_Bhjk = null;
    if (this.jdField_a_of_type_Bhkc != null) {
      this.jdField_a_of_type_Bhkc.b();
    }
    this.jdField_a_of_type_Bhkc = null;
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhjw
 * JD-Core Version:    0.7.0.1
 */