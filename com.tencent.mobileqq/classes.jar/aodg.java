import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArResourceManager.1;
import com.tencent.mobileqq.ar.ArResourceManager.2;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import mqq.manager.Manager;

public class aodg
  implements Handler.Callback, Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public aocv a;
  public aodc a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected volatile ArConfigInfo a;
  protected volatile ArEffectConfig a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public String a;
  private Vector<WeakReference<aodu>> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean;
  private Handler b;
  
  public aodg(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppInterface.getApp().getSharedPreferences("pref_ar_config" + paramAppInterface.getAccount(), 0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangString = aocu.a();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.post(new ArResourceManager.1(this), 8, null, true);
    this.jdField_a_of_type_Aodc = new aodc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("ApplicationVersionCode", 0);
  }
  
  public ArConfigInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceManager", 2, "getArConfigInfo | load config from file.");
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = ArConfigInfo.loadConfigFromFile(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    }
    finally {}
  }
  
  public ArEffectConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = ArEffectConfig.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  }
  
  /* Error */
  public ArDownloadInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 102	aodg:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: ldc 167
    //   23: aload_1
    //   24: invokevirtual 173	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   27: checkcast 167	com/tencent/mobileqq/ar/model/ArDownloadInfo
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -23 -> 13
    //   39: ldc 139
    //   41: iconst_2
    //   42: new 42	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   49: ldc 175
    //   51: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_3
    //   65: astore_1
    //   66: goto -53 -> 13
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	aodg
    //   0	74	1	paramString	String
    //   6	2	2	bool	boolean
    //   30	35	3	localArDownloadInfo	ArDownloadInfo
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   17	31	69	finally
    //   33	64	69	finally
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceManager", 2, "clearArConfigInfo");
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = null;
      ArConfigInfo.deleteConfigFile(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("ApplicationVersionCode", paramInt).commit();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "downloadError errorCode: " + paramInt1 + ", result: " + paramInt2);
    }
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    paramInt2 = 0;
    for (;;)
    {
      try
      {
        if (paramInt2 < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(paramInt2);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilVector;
            int i = paramInt2 - 1;
            ((Vector)localObject1).remove(paramInt2);
            paramInt2 = i;
          }
          else
          {
            ((aodu)((WeakReference)localObject1).get()).a(paramInt1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramInt2 += 1;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "downloadProgress downloadSize: " + paramLong1 + ", totalSize: " + paramLong2);
    }
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilVector;
            int j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
          else
          {
            ((aodu)((WeakReference)localObject1).get()).a(paramLong1, paramLong2);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a(aodu paramaodu)
  {
    if (paramaodu != null) {
      this.jdField_a_of_type_JavaUtilVector.add(new WeakReference(paramaodu));
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "handleNewConfig config: " + paramArConfigInfo);
    }
    if (paramArConfigInfo == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      ArVideoResourceInfo localArVideoResourceInfo;
      try
      {
        localObject1 = paramArConfigInfo.mArCloudConfigInfos.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ArCloudConfigInfo)((Iterator)localObject1).next();
        ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c = (this.jdField_a_of_type_JavaLangString + "ar_feature/" + ((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int + File.separator + ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString + "_signature.db");
        ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "ar_model/" + ((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int + File.separator);
        if (((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
        {
          if (((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int == 100) {
            ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (this.jdField_a_of_type_JavaLangString + "ar_cloud_marker_model/" + ((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int + File.separator + ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
          }
        }
        else
        {
          if ((((ArCloudConfigInfo)localObject2).jdField_a_of_type_JavaUtilArrayList == null) || (((ArCloudConfigInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            continue;
          }
          Iterator localIterator = ((ArCloudConfigInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            localArVideoResourceInfo = (ArVideoResourceInfo)localIterator.next();
            if (localArVideoResourceInfo.jdField_d_of_type_Int != 4) {
              break label425;
            }
            localArVideoResourceInfo.e = aoma.a(localArVideoResourceInfo.jdField_d_of_type_JavaLangString);
            continue;
          }
          continue;
        }
        ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f = (this.jdField_a_of_type_JavaLangString + "ar_model/" + ((ArCloudConfigInfo)localObject2).jdField_d_of_type_Int + File.separator + ((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "_model.zip");
      }
      catch (Exception paramArConfigInfo)
      {
        QLog.i("ArConfig_ArResourceManager", 1, "handleNewConfig config: " + paramArConfigInfo.getMessage());
        return;
      }
      continue;
      label425:
      localArVideoResourceInfo.e = (((ArCloudConfigInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + localArVideoResourceInfo.c + "_model.zip");
    }
    int i;
    if (a(paramArConfigInfo))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilVector;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          localObject2 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject2 == null) || (((WeakReference)localObject2).get() == null))
          {
            localObject2 = this.jdField_a_of_type_JavaUtilVector;
            int j = i - 1;
            ((Vector)localObject2).remove(i);
            i = j;
            break label600;
          }
          ((aodu)((WeakReference)localObject2).get()).a(paramArConfigInfo);
          break label600;
        }
        a(paramArConfigInfo, true, true);
        return;
      }
      finally {}
      a();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_ArResourceManager", 2, "saveArConfigToFile error!");
      return;
      label600:
      i += 1;
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource isAuto: " + paramBoolean1 + ", needCheckZip: " + paramBoolean2 + ", config: " + paramArConfigInfo);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    if (paramBoolean1)
    {
      i = 1;
      localMessage.arg1 = i;
      if (!paramBoolean2) {
        break label119;
      }
    }
    label119:
    for (int i = j;; i = 0)
    {
      localMessage.arg2 = i;
      localMessage.obj = paramArConfigInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 0L);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (paramArEffectConfig == null) {
      return;
    }
    Vector localVector;
    int i;
    if (ArEffectConfig.a(paramArEffectConfig))
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = paramArEffectConfig;
      localVector = this.jdField_a_of_type_JavaUtilVector;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.jdField_a_of_type_JavaUtilVector;
            int j = i - 1;
            ((Vector)localObject).remove(i);
            i = j;
            break label134;
          }
          ((aodu)((WeakReference)localObject).get()).a(paramArEffectConfig);
          break label134;
        }
        return;
      }
      finally {}
      b();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_ArResourceManager", 2, "saveArEffectInfoToFile error!");
      return;
      label134:
      i += 1;
    }
  }
  
  /* Error */
  public void a(ArDownloadInfo paramArDownloadInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 102	aodg:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: invokevirtual 390	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   21: aload_0
    //   22: getfield 102	aodg:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: aload_1
    //   26: invokevirtual 399	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   29: aload_2
    //   30: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   33: aload_2
    //   34: invokevirtual 404	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   37: goto -31 -> 6
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   56: aload_2
    //   57: invokevirtual 404	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   60: goto -54 -> 6
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 404	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	aodg
    //   0	70	1	paramArDownloadInfo	ArDownloadInfo
    //   16	49	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   9	17	40	finally
    //   33	37	40	finally
    //   56	60	40	finally
    //   64	70	40	finally
    //   17	33	45	java/lang/Exception
    //   17	33	63	finally
    //   46	56	63	finally
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      long l;
      ArDownloadInfo localArDownloadInfo;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        l = System.currentTimeMillis();
        localArDownloadInfo = a(paramString);
        if (localArDownloadInfo == null)
        {
          if (paramBoolean) {
            continue;
          }
          localArDownloadInfo = new ArDownloadInfo();
          localArDownloadInfo.md5 = paramString;
          localArDownloadInfo.dailyRetryCount = 1;
          localArDownloadInfo.totalRetryCount = 1;
          localArDownloadInfo.dailyStartTime = l;
          a(localArDownloadInfo);
          continue;
        }
        if (!paramBoolean) {
          break label133;
        }
      }
      finally {}
      localArDownloadInfo.dailyRetryCount = 0;
      localArDownloadInfo.dailyStartTime = l;
      label100:
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      try
      {
        paramString.begin();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(localArDownloadInfo);
        paramString.commit();
        paramString.end();
        continue;
        label133:
        if (l - localArDownloadInfo.dailyStartTime >= 86400000L)
        {
          localArDownloadInfo.dailyRetryCount = 1;
          localArDownloadInfo.dailyStartTime = l;
          localArDownloadInfo.totalRetryCount += 1;
          break label100;
        }
        localArDownloadInfo.dailyRetryCount += 1;
        localArDownloadInfo.totalRetryCount += 1;
        break label100;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        paramString.end();
      }
      finally
      {
        paramString.end();
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          if (!paramBoolean) {
            break label46;
          }
        }
        label46:
        for (Handler localHandler = this.b;; localHandler = this.jdField_a_of_type_AndroidOsHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource isAuto: " + paramBoolean1 + ", needCheckZip: " + paramBoolean2);
    }
    ArConfigInfo localArConfigInfo = a();
    if (localArConfigInfo == null)
    {
      QLog.i("ArConfig_ArResourceManager", 1, "config  null");
      return;
    }
    a(localArConfigInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (this.jdField_a_of_type_Aocv == null) {}
    for (int i = 3; i == 1; i = this.jdField_a_of_type_Aocv.a) {
      return true;
    }
    int j = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if (i == 0) {
      if ((j == 1) || (j == 4)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceManager", 2, "isNetworkCanPreDownload,dpcNet=" + i + ", type=" + j);
      }
      return bool1;
      if (i == 3)
      {
        if (j == 1) {}
        for (bool1 = bool2;; bool1 = false) {
          break;
        }
      }
      if ((j == 1) || (j == 4) || (j == 3)) {
        bool1 = true;
      }
    }
  }
  
  /* Error */
  public boolean a(ArConfigInfo paramArConfigInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 139
    //   10: iconst_2
    //   11: new 42	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 472
    //   21: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 34	aodg:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   39: invokevirtual 183	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   42: invokestatic 476	com/tencent/mobileqq/ar/aidl/ArConfigInfo:saveArConfigToFile	(Lcom/tencent/mobileqq/ar/aidl/ArConfigInfo;Ljava/lang/String;)Z
    //   45: ifeq +14 -> 59
    //   48: aload_0
    //   49: aload_1
    //   50: putfield 131	aodg:jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArConfigInfo;
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: iconst_0
    //   60: istore_2
    //   61: goto -6 -> 55
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	aodg
    //   0	69	1	paramArConfigInfo	ArConfigInfo
    //   54	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	64	finally
    //   34	53	64	finally
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    int j;
    label55:
    label94:
    label105:
    label111:
    do
    {
      do
      {
        return bool1;
        paramString = a(paramString);
        bool1 = bool2;
      } while (paramString == null);
      long l = System.currentTimeMillis();
      int i;
      if (this.jdField_a_of_type_Aocv == null)
      {
        i = 3;
        if (this.jdField_a_of_type_Aocv != null) {
          break label94;
        }
        j = 1000;
        if (l - paramString.dailyStartTime <= 86400000L) {
          break label111;
        }
        if (paramString.totalRetryCount >= j) {
          break label105;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        return bool1;
        i = this.jdField_a_of_type_Aocv.b;
        break;
        j = this.jdField_a_of_type_Aocv.c;
        break label55;
      }
      if (paramString.dailyRetryCount > i) {
        break;
      }
      bool1 = bool2;
    } while (paramString.totalRetryCount <= j);
    return false;
  }
  
  public int b()
  {
    int i = 0;
    if (a() != null) {
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_config_server_version", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "getLocalVersion | version = " + i);
    }
    return i;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      anxz.a().a(this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig);
    }
    ArEffectConfig.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_config_server_version", paramInt).commit();
  }
  
  public void b(aodu paramaodu)
  {
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.jdField_a_of_type_JavaUtilVector;
            int j = i - 1;
            ((Vector)localObject).remove(i);
            i = j;
          }
          else if (((WeakReference)localObject).get() == paramaodu)
          {
            this.jdField_a_of_type_JavaUtilVector.remove(i);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void b(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "downloadResource isAuto: " + paramBoolean1 + ", needCheckZip: " + paramBoolean2 + ", config: " + paramArConfigInfo);
        }
        if (paramBoolean1)
        {
          a(false, 1, 0L, null);
          a(false, 3, 0L, null);
        }
        if (!anxz.a().b())
        {
          if (QLog.isColorLevel()) {
            QLog.i("ArConfig_ArResourceManager", 2, "downloadResource device is not support AR!");
          }
          return;
        }
        if ((paramArConfigInfo != null) && (paramBoolean1))
        {
          QLog.i("ArConfig_ArResourceManager", 1, "sendMessage REPORT_AR_RESOURCE ");
          a(false, 2, 10000L, null);
        }
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ArConfig_ArResourceManager", 2, "downloadResource isNetSupport = false!");
          continue;
        }
        if (!paramBoolean1) {
          break label218;
        }
      }
      finally {}
      if (!b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isCanAutoPreDownload = false");
        }
      }
      else if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isNetworkCanPreDownload = false");
        }
      }
      else {
        label218:
        ThreadManager.post(new ArResourceManager.2(this, paramArConfigInfo, paramBoolean1, paramBoolean2), 5, null, true);
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aocv == null) {}
    for (int i = 1; i == 1; i = this.jdField_a_of_type_Aocv.e) {
      return true;
    }
    return false;
  }
  
  public int c()
  {
    ArEffectConfig localArEffectConfig = a();
    int i = 0;
    if (localArEffectConfig != null) {
      i = localArEffectConfig.a;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "getEntranceVersion | version = " + i);
    }
    return i;
  }
  
  public void c()
  {
    bool = true;
    Object localObject;
    if (this.jdField_a_of_type_Aocv == null)
    {
      this.jdField_a_of_type_Aocv = new aocv();
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.olympic_act_config.name());
    }
    try
    {
      if (((String)localObject).length() <= 0) {
        break label276;
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 9) {
        break label276;
      }
      this.jdField_a_of_type_Aocv.a = Integer.valueOf(localObject[4]).intValue();
      this.jdField_a_of_type_Aocv.b = Integer.valueOf(localObject[5]).intValue();
      this.jdField_a_of_type_Aocv.c = Integer.valueOf(localObject[6]).intValue();
      this.jdField_a_of_type_Aocv.jdField_d_of_type_Int = Integer.valueOf(localObject[7]).intValue();
      this.jdField_a_of_type_Aocv.e = Integer.valueOf(localObject[8]).intValue();
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "loadDPCConfig Exception:" + localException.toString());
        }
        int i = 1;
        continue;
        bool = false;
      }
    }
    if (i != 0)
    {
      this.jdField_a_of_type_Aocv.a = 3;
      this.jdField_a_of_type_Aocv.b = 3;
      this.jdField_a_of_type_Aocv.c = 1000;
      this.jdField_a_of_type_Aocv.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_Aocv.e = 1;
    }
    if (this.jdField_a_of_type_Aocv.jdField_d_of_type_Int == 1)
    {
      axsb.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceManager", 2, "loadDPCConfig|dpc:" + this.jdField_a_of_type_Aocv.toString());
      }
      return;
    }
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Aocv == null) {
      return 3;
    }
    return this.jdField_a_of_type_Aocv.a;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "downloadSuccess");
    }
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilVector;
            int j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
          else
          {
            ((aodu)((WeakReference)localObject1).get()).b();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.version;
        bool1 = false;
      }
      break;
    }
    while (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("ar_config_report_time", 0L) >= 86400000L)
    {
      aocu.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), bool1, i);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("ar_config_report_time", l).commit();
      return false;
      if (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("ar_so_report_time", 0L) < 86400000L) {
        break;
      }
      i = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getInt("ar_native_so_version", 0);
      if (i > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        Object localObject = new HashMap();
        if (bool1) {}
        for (paramMessage = "1";; paramMessage = "0")
        {
          ((HashMap)localObject).put("param_FailCode", paramMessage);
          ((HashMap)localObject).put("ar_so_version", String.valueOf(i));
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "olympic_ar_native_so_report", bool1, 0L, 0L, (HashMap)localObject, null);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("ar_so_report_time", l).commit();
          return false;
        }
        label516:
        label522:
        for (;;)
        {
          try
          {
            if ((l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("ar_res_report_time", 0L) < 86400000L) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null)) {
              break;
            }
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.iterator();
            if (!paramMessage.hasNext()) {
              break label522;
            }
            localObject = (ArCloudConfigInfo)paramMessage.next();
            if (FileUtils.fileExists(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.c)) {
              break label432;
            }
            bool1 = false;
            aocu.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), bool1, bool2);
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("ar_res_report_time", l).commit();
            return false;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ArConfig_ArResourceManager", 2, "REPORT_AR_RESOURCE:" + paramMessage.toString());
          return false;
          label432:
          if (((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null)
          {
            bool1 = FileUtils.fileExists(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.f);
            if (!bool1)
            {
              bool1 = true;
              bool2 = false;
              continue;
              QLog.d("ArConfig_ArResourceManager", 2, "start DOWNLAOD_AR_RESOURCE ");
              if (paramMessage.arg1 == 1)
              {
                bool1 = true;
                if (paramMessage.arg2 != 1) {
                  break label516;
                }
              }
              for (bool2 = bool3;; bool2 = false)
              {
                b((ArConfigInfo)paramMessage.obj, bool1, bool2);
                return false;
                bool1 = false;
                break;
              }
              bool1 = true;
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodg
 * JD-Core Version:    0.7.0.1
 */