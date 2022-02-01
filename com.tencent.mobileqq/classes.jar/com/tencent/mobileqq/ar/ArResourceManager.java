package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
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

public class ArResourceManager
  implements Handler.Callback, Manager
{
  SharedPreferences a;
  public String b;
  protected volatile ArConfigInfo c;
  protected volatile ArEffectConfig d;
  public ArResourceDownload e;
  public ArDownloadDPC f;
  private WeakReference<AppInterface> g;
  private Vector<WeakReference<IArConfigListener>> h = new Vector();
  private EntityManager i;
  private Handler j;
  private Handler k;
  private boolean l;
  private String m;
  
  public ArResourceManager(AppInterface paramAppInterface)
  {
    this.g = new WeakReference(paramAppInterface);
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_ar_config");
    localStringBuilder.append(paramAppInterface.getAccount());
    this.a = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    this.j = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.k = new Handler(Looper.getMainLooper(), this);
    this.b = ArConfigUtils.a();
    this.i = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.m = paramAppInterface.getAccount();
    ThreadManager.post(new ArResourceManager.1(this), 8, null, true);
    this.e = new ArResourceDownload(paramAppInterface, this);
  }
  
  public ArConfigInfo a()
  {
    AppInterface localAppInterface = (AppInterface)this.g.get();
    if ((this.c == null) && (localAppInterface != null)) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "getArConfigInfo | load config from file.");
        }
        this.c = ArConfigInfo.loadConfigFromFile(localAppInterface.getAccount());
      }
      finally {}
    }
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadError errorCode: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", result: ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.h;
    paramInt2 = 0;
    for (;;)
    {
      try
      {
        if (paramInt2 < this.h.size())
        {
          WeakReference localWeakReference = (WeakReference)this.h.get(paramInt2);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((IArConfigListener)localWeakReference.get()).a(paramInt1);
          }
          else
          {
            this.h.remove(paramInt2);
            paramInt2 -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        paramInt2 += 1;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadProgress downloadSize: ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", totalSize: ");
      ((StringBuilder)localObject1).append(paramLong2);
      QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.h;
    int n = 0;
    for (;;)
    {
      try
      {
        if (n < this.h.size())
        {
          WeakReference localWeakReference = (WeakReference)this.h.get(n);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((IArConfigListener)localWeakReference.get()).a(paramLong1, paramLong2);
          }
          else
          {
            this.h.remove(n);
            n -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        n += 1;
      }
    }
  }
  
  void a(IArConfigListener paramIArConfigListener)
  {
    if (paramIArConfigListener != null) {
      this.h.add(new WeakReference(paramIArConfigListener));
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    //   10: getfield 119	com/tencent/mobileqq/ar/ArResourceManager:i	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: invokevirtual 221	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 226	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   21: aload_0
    //   22: getfield 119	com/tencent/mobileqq/ar/ArResourceManager:i	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: aload_1
    //   26: invokevirtual 230	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   29: aload_2
    //   30: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   33: aload_2
    //   34: invokevirtual 236	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   37: goto +21 -> 58
    //   40: astore_1
    //   41: goto +20 -> 61
    //   44: astore_1
    //   45: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq -15 -> 33
    //   51: aload_1
    //   52: invokevirtual 239	java/lang/Exception:printStackTrace	()V
    //   55: goto -22 -> 33
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_2
    //   62: invokevirtual 236	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: goto +5 -> 75
    //   73: aload_1
    //   74: athrow
    //   75: goto -2 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ArResourceManager
    //   0	78	1	paramArDownloadInfo	ArDownloadInfo
    //   16	46	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   17	33	40	finally
    //   45	55	40	finally
    //   17	33	44	java/lang/Exception
    //   9	17	67	finally
    //   33	37	67	finally
    //   61	67	67	finally
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 252	java/lang/System:currentTimeMillis	()J
    //   17: lstore 4
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 255	com/tencent/mobileqq/ar/ArResourceManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/model/ArDownloadInfo;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnonnull +50 -> 78
    //   31: iload_2
    //   32: ifne +43 -> 75
    //   35: new 257	com/tencent/mobileqq/ar/model/ArDownloadInfo
    //   38: dup
    //   39: invokespecial 258	com/tencent/mobileqq/ar/model/ArDownloadInfo:<init>	()V
    //   42: astore 6
    //   44: aload 6
    //   46: aload_1
    //   47: putfield 261	com/tencent/mobileqq/ar/model/ArDownloadInfo:md5	Ljava/lang/String;
    //   50: aload 6
    //   52: iconst_1
    //   53: putfield 265	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyRetryCount	I
    //   56: aload 6
    //   58: iconst_1
    //   59: putfield 268	com/tencent/mobileqq/ar/model/ArDownloadInfo:totalRetryCount	I
    //   62: aload 6
    //   64: lload 4
    //   66: putfield 272	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyStartTime	J
    //   69: aload_0
    //   70: aload 6
    //   72: invokevirtual 274	com/tencent/mobileqq/ar/ArResourceManager:a	(Lcom/tencent/mobileqq/ar/model/ArDownloadInfo;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: iload_2
    //   79: ifeq +19 -> 98
    //   82: aload 6
    //   84: iconst_0
    //   85: putfield 265	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyRetryCount	I
    //   88: aload 6
    //   90: lload 4
    //   92: putfield 272	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyStartTime	J
    //   95: goto +70 -> 165
    //   98: lload 4
    //   100: aload 6
    //   102: getfield 272	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyStartTime	J
    //   105: lsub
    //   106: ldc2_w 275
    //   109: lcmp
    //   110: iflt +31 -> 141
    //   113: aload 6
    //   115: iconst_1
    //   116: putfield 265	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyRetryCount	I
    //   119: aload 6
    //   121: lload 4
    //   123: putfield 272	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyStartTime	J
    //   126: aload 6
    //   128: aload 6
    //   130: getfield 268	com/tencent/mobileqq/ar/model/ArDownloadInfo:totalRetryCount	I
    //   133: iconst_1
    //   134: iadd
    //   135: putfield 268	com/tencent/mobileqq/ar/model/ArDownloadInfo:totalRetryCount	I
    //   138: goto +27 -> 165
    //   141: aload 6
    //   143: aload 6
    //   145: getfield 265	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyRetryCount	I
    //   148: iconst_1
    //   149: iadd
    //   150: putfield 265	com/tencent/mobileqq/ar/model/ArDownloadInfo:dailyRetryCount	I
    //   153: aload 6
    //   155: aload 6
    //   157: getfield 268	com/tencent/mobileqq/ar/model/ArDownloadInfo:totalRetryCount	I
    //   160: iconst_1
    //   161: iadd
    //   162: putfield 268	com/tencent/mobileqq/ar/model/ArDownloadInfo:totalRetryCount	I
    //   165: aload_0
    //   166: getfield 119	com/tencent/mobileqq/ar/ArResourceManager:i	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   169: invokevirtual 221	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 226	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   177: aload_0
    //   178: getfield 119	com/tencent/mobileqq/ar/ArResourceManager:i	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   181: aload 6
    //   183: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   186: pop
    //   187: aload_1
    //   188: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   191: aload_1
    //   192: invokevirtual 236	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   195: goto +24 -> 219
    //   198: astore 6
    //   200: goto +22 -> 222
    //   203: astore 6
    //   205: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -17 -> 191
    //   211: aload 6
    //   213: invokevirtual 239	java/lang/Exception:printStackTrace	()V
    //   216: goto -25 -> 191
    //   219: aload_0
    //   220: monitorexit
    //   221: return
    //   222: aload_1
    //   223: invokevirtual 236	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   226: aload 6
    //   228: athrow
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: goto +5 -> 237
    //   235: aload_1
    //   236: athrow
    //   237: goto -2 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	ArResourceManager
    //   0	240	1	paramString	String
    //   0	240	2	paramBoolean	boolean
    //   6	2	3	bool	boolean
    //   17	105	4	l1	long
    //   24	158	6	localArDownloadInfo	ArDownloadInfo
    //   198	1	6	localObject	Object
    //   203	24	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   173	191	198	finally
    //   205	216	198	finally
    //   173	191	203	java/lang/Exception
    //   2	7	229	finally
    //   14	26	229	finally
    //   35	75	229	finally
    //   82	95	229	finally
    //   98	138	229	finally
    //   141	165	229	finally
    //   165	173	229	finally
    //   191	195	229	finally
    //   222	229	229	finally
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.l) {
      try
      {
        if (!this.l)
        {
          Handler localHandler;
          if (paramBoolean) {
            localHandler = this.k;
          } else {
            localHandler = this.j;
          }
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadArResource isAuto: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", needCheckZip: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("ArConfig_ArResourceManager", 1, "config  null");
      return;
    }
    a((ArConfigInfo)localObject, paramBoolean1, paramBoolean2);
  }
  
  public boolean a(ArConfigInfo paramArConfigInfo)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateArConfigInfo | config = ");
        ((StringBuilder)localObject).append(paramArConfigInfo);
        QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (AppInterface)this.g.get();
      if ((localObject != null) && (ArConfigInfo.saveArConfigToFile(paramArConfigInfo, ((AppInterface)localObject).getCurrentAccountUin())))
      {
        this.c = paramArConfigInfo;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = b(paramString);
    if (paramString == null) {
      return true;
    }
    long l1 = System.currentTimeMillis();
    ArDownloadDPC localArDownloadDPC = this.f;
    int n;
    if (localArDownloadDPC == null) {
      n = 3;
    } else {
      n = localArDownloadDPC.b;
    }
    localArDownloadDPC = this.f;
    int i1;
    if (localArDownloadDPC == null) {
      i1 = 1000;
    } else {
      i1 = localArDownloadDPC.c;
    }
    if (l1 - paramString.dailyStartTime > 86400000L) {
      return paramString.totalRetryCount < i1;
    }
    return (paramString.dailyRetryCount <= n) && (paramString.totalRetryCount <= i1);
  }
  
  public ArDownloadInfo b(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      paramString = (ArDownloadInfo)this.i.find(ArDownloadInfo.class, paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEntity, info=");
        localStringBuilder.append(paramString);
        QLog.d("ArConfig_ArResourceManager", 2, localStringBuilder.toString());
      }
      return paramString;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceManager", 2, "clearArConfigInfo");
      }
      this.c = null;
      AppInterface localAppInterface = (AppInterface)this.g.get();
      if (localAppInterface != null) {
        ArConfigInfo.deleteConfigFile(localAppInterface.getCurrentAccountUin());
      }
      return;
    }
    finally {}
  }
  
  void b(IArConfigListener paramIArConfigListener)
  {
    Vector localVector = this.h;
    int n = 0;
    for (;;)
    {
      try
      {
        if (n < this.h.size())
        {
          WeakReference localWeakReference = (WeakReference)this.h.get(n);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            i1 = n;
            if (localWeakReference.get() == paramIArConfigListener) {
              this.h.remove(n);
            }
          }
          else
          {
            this.h.remove(n);
            i1 = n - 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        int i1;
        continue;
        throw paramIArConfigListener;
        continue;
        n = i1 + 1;
      }
    }
  }
  
  public void b(ArConfigInfo paramArConfigInfo)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNewConfig config: ");
      ((StringBuilder)localObject1).append(paramArConfigInfo);
      QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArConfigInfo == null) {
      return;
    }
    for (;;)
    {
      int n;
      try
      {
        localObject1 = paramArConfigInfo.mArCloudConfigInfos.iterator();
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArCloudConfigInfo)((Iterator)localObject1).next();
          Object localObject3 = ((ArCloudConfigInfo)localObject2).j;
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.b);
          ((StringBuilder)localObject4).append("ar_feature/");
          ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).e);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).j.a);
          ((StringBuilder)localObject4).append("_signature.db");
          ((ArFeatureInfo)localObject3).d = ((StringBuilder)localObject4).toString();
          localObject3 = ((ArCloudConfigInfo)localObject2).j;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(this.b);
          ((StringBuilder)localObject4).append("ar_model/");
          ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).e);
          ((StringBuilder)localObject4).append(File.separator);
          ((ArFeatureInfo)localObject3).e = ((StringBuilder)localObject4).toString();
          if (((ArCloudConfigInfo)localObject2).k != null) {
            if (((ArCloudConfigInfo)localObject2).e == 100)
            {
              localObject3 = ((ArCloudConfigInfo)localObject2).k;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.b);
              ((StringBuilder)localObject4).append("ar_cloud_marker_model/");
              ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).e);
              ((StringBuilder)localObject4).append(File.separator);
              ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).k.b);
              ((StringBuilder)localObject4).append("_model.zip");
              ((ArModelResource)localObject3).h = ((StringBuilder)localObject4).toString();
            }
            else
            {
              localObject3 = ((ArCloudConfigInfo)localObject2).k;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.b);
              ((StringBuilder)localObject4).append("ar_model/");
              ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).e);
              ((StringBuilder)localObject4).append(File.separator);
              ((StringBuilder)localObject4).append(((ArCloudConfigInfo)localObject2).k.b);
              ((StringBuilder)localObject4).append("_model.zip");
              ((ArModelResource)localObject3).h = ((StringBuilder)localObject4).toString();
            }
          }
          if ((((ArCloudConfigInfo)localObject2).i == null) || (((ArCloudConfigInfo)localObject2).i.size() <= 0)) {
            continue;
          }
          localObject3 = ((ArCloudConfigInfo)localObject2).i.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ArVideoResourceInfo)((Iterator)localObject3).next();
            if (((ArVideoResourceInfo)localObject4).h == 4)
            {
              ((ArVideoResourceInfo)localObject4).j = AROnlineVideoUtil.a(((ArVideoResourceInfo)localObject4).i);
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((ArCloudConfigInfo)localObject2).j.e);
            localStringBuilder.append(((ArVideoResourceInfo)localObject4).e);
            localStringBuilder.append("_model.zip");
            ((ArVideoResourceInfo)localObject4).j = localStringBuilder.toString();
            continue;
          }
          continue;
        }
        if (a(paramArConfigInfo))
        {
          localObject1 = this.h;
          n = 0;
          try
          {
            if (n < this.h.size())
            {
              localObject2 = (WeakReference)this.h.get(n);
              if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
              {
                ((IArConfigListener)((WeakReference)localObject2).get()).a(paramArConfigInfo);
                break label715;
              }
              this.h.remove(n);
              n -= 1;
              break label715;
            }
            a(paramArConfigInfo, true, true);
            return;
          }
          finally {}
        }
        b();
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_ArResourceManager", 2, "saveArConfigToFile error!");
          return;
        }
      }
      catch (Exception paramArConfigInfo)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleNewConfig config: ");
        ((StringBuilder)localObject1).append(paramArConfigInfo.getMessage());
        QLog.i("ArConfig_ArResourceManager", 1, ((StringBuilder)localObject1).toString());
      }
      return;
      label715:
      n += 1;
    }
  }
  
  public void b(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadResource isAuto: ");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append(", needCheckZip: ");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append(", config: ");
        ((StringBuilder)localObject).append(paramArConfigInfo);
        QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean1)
      {
        a(false, 1, 0L, null);
        a(false, 3, 0L, null);
      }
      if (!ARDeviceController.a().c())
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
      Object localObject = (AppInterface)this.g.get();
      if (localObject == null) {
        return;
      }
      if (!NetworkUtil.isNetSupport(((AppInterface)localObject).getApp()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArConfig_ArResourceManager", 2, "downloadResource isNetSupport = false!");
        }
        return;
      }
      if (paramBoolean1)
      {
        if (!f())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isCanAutoPreDownload = false");
          }
          return;
        }
        if (!e())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isNetworkCanPreDownload = false");
          }
          return;
        }
      }
      ThreadManager.post(new ArResourceManager.2(this, paramArConfigInfo, paramBoolean1, paramBoolean2), 5, null, true);
      return;
    }
    finally {}
  }
  
  public ArEffectConfig c()
  {
    if (this.d == null) {
      this.d = ArEffectConfig.a();
    }
    return this.d;
  }
  
  protected void d()
  {
    if (this.f == null)
    {
      this.f = new ArDownloadDPC();
      Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
      boolean bool = false;
      int n;
      try
      {
        if (((String)localObject1).length() > 0)
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 9)
          {
            this.f.a = Integer.valueOf(localObject1[4]).intValue();
            this.f.b = Integer.valueOf(localObject1[5]).intValue();
            this.f.c = Integer.valueOf(localObject1[6]).intValue();
            this.f.d = Integer.valueOf(localObject1[7]).intValue();
            this.f.e = Integer.valueOf(localObject1[8]).intValue();
            n = 0;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadDPCConfig Exception:");
          localStringBuilder.append(localException.toString());
          QLog.d("ArConfig_ArResourceManager", 2, localStringBuilder.toString());
        }
        n = 1;
      }
      Object localObject2;
      if (n != 0)
      {
        localObject2 = this.f;
        ((ArDownloadDPC)localObject2).a = 3;
        ((ArDownloadDPC)localObject2).b = 3;
        ((ArDownloadDPC)localObject2).c = 1000;
        ((ArDownloadDPC)localObject2).d = 1;
        ((ArDownloadDPC)localObject2).e = 1;
      }
      if (this.f.d == 1) {
        bool = true;
      }
      OlympicUtil.a(bool);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadDPCConfig|dpc:");
        ((StringBuilder)localObject2).append(this.f.toString());
        QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public boolean e()
  {
    Object localObject = this.f;
    int n;
    if (localObject == null) {
      n = 3;
    } else {
      n = ((ArDownloadDPC)localObject).a;
    }
    boolean bool2 = true;
    if (n == 1) {
      return true;
    }
    int i1 = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if (n == 0)
    {
      bool1 = bool2;
      if (i1 == 1) {
        break label107;
      }
      if (i1 == 4)
      {
        bool1 = bool2;
        break label107;
      }
    }
    do
    {
      do
      {
        bool1 = false;
        break label107;
        if (n != 3) {
          break;
        }
      } while (i1 != 1);
      bool1 = bool2;
      break;
      bool1 = bool2;
      if (i1 == 1) {
        break;
      }
      bool1 = bool2;
      if (i1 == 4) {
        break;
      }
    } while (i1 != 3);
    boolean bool1 = bool2;
    label107:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNetworkCanPreDownload,dpcNet=");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public boolean f()
  {
    ArDownloadDPC localArDownloadDPC = this.f;
    int n;
    if (localArDownloadDPC == null) {
      n = 1;
    } else {
      n = localArDownloadDPC.e;
    }
    return n == 1;
  }
  
  public int g()
  {
    ArDownloadDPC localArDownloadDPC = this.f;
    if (localArDownloadDPC == null) {
      return 3;
    }
    return localArDownloadDPC.a;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "downloadSuccess");
    }
    Vector localVector = this.h;
    int n = 0;
    for (;;)
    {
      try
      {
        if (n < this.h.size())
        {
          WeakReference localWeakReference = (WeakReference)this.h.get(n);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((IArConfigListener)localWeakReference.get()).b();
          }
          else
          {
            this.h.remove(n);
            n -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        n += 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    int n = paramMessage.what;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    if (n != 1) {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4) {
            return false;
          }
          QLog.d("ArConfig_ArResourceManager", 2, "start DOWNLAOD_AR_RESOURCE ");
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (paramMessage.arg2 != 1) {
            bool2 = false;
          }
          b((ArConfigInfo)paramMessage.obj, bool1, bool2);
          return false;
        }
        if (l1 - this.a.getLong("ar_so_report_time", 0L) < 86400000L) {
          break label528;
        }
        n = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getInt("ar_native_so_version", 0);
        if (n > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject = new HashMap();
        if (bool1) {
          paramMessage = "1";
        } else {
          paramMessage = "0";
        }
        ((HashMap)localObject).put("param_FailCode", paramMessage);
        ((HashMap)localObject).put("ar_so_version", String.valueOf(n));
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.m, "olympic_ar_native_so_report", bool1, 0L, 0L, (HashMap)localObject, null);
        this.a.edit().putLong("ar_so_report_time", l1).commit();
        return false;
      }
    }
    for (;;)
    {
      try
      {
        if ((l1 - this.a.getLong("ar_res_report_time", 0L) < 86400000L) || (this.c == null)) {
          break label528;
        }
        paramMessage = this.c.mArCloudConfigInfos.iterator();
        if (!paramMessage.hasNext()) {
          break label530;
        }
        localObject = (ArCloudConfigInfo)paramMessage.next();
        if (!FileUtils.fileExists(((ArCloudConfigInfo)localObject).j.d))
        {
          bool1 = true;
          bool2 = false;
        }
        else
        {
          if ((((ArCloudConfigInfo)localObject).k == null) || (FileUtils.fileExists(((ArCloudConfigInfo)localObject).k.h))) {
            continue;
          }
          bool1 = false;
          bool2 = bool3;
        }
        ArConfigUtils.a(this.m, bool2, bool1);
        this.a.edit().putLong("ar_res_report_time", l1).commit();
        return false;
      }
      catch (Exception paramMessage)
      {
        if (!QLog.isColorLevel()) {
          break label528;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("REPORT_AR_RESOURCE:");
      ((StringBuilder)localObject).append(paramMessage.toString());
      QLog.d("ArConfig_ArResourceManager", 2, ((StringBuilder)localObject).toString());
      return false;
      if (this.c != null)
      {
        n = this.c.version;
        bool1 = false;
      }
      else
      {
        n = 0;
      }
      if (l1 - this.a.getLong("ar_config_report_time", 0L) >= 86400000L)
      {
        ArConfigUtils.b(this.m, bool1, n);
        this.a.edit().putLong("ar_config_report_time", l1).commit();
      }
      label528:
      return false;
      label530:
      bool1 = true;
      bool2 = bool3;
    }
  }
  
  public void onDestroy()
  {
    this.l = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceManager
 * JD-Core Version:    0.7.0.1
 */