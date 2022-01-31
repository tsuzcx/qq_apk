package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.DownloadChooseReq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.ConfigInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.ConfigUpdateListener;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import xfn;
import xfo;
import xfp;
import xfr;
import xfs;
import xft;
import xfu;
import xfv;

public class PreloadManager
  extends PreloadManagerAbs
  implements QWalletConfigManager.ConfigUpdateListener, INetInfoHandler, Manager
{
  private int jdField_a_of_type_Int = 30;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private PreloadBackControlConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig = PreloadBackControlConfig.readBackControlConfig(this.jdField_a_of_type_MqqAppAppRuntime);
  public PreloadConfig a;
  public boolean a;
  private int b = 1024;
  
  public PreloadManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig = PreloadConfig.readConfig("preload.config", this.jdField_a_of_type_MqqAppAppRuntime);
    e();
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
    g();
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getSharedPreferences("qwallet_preload_config", 4);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((SharedPreferences)localObject3).getString("config_from_qq" + paramString, null);
      }
    }
    return localObject1;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    return b(paramAppRuntime) + "preload.config";
  }
  
  private List a(List paramList, DownloadListener paramDownloadListener)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    PreloadConfig.splitModulesBySize(this.b, paramList, localArrayList1, localArrayList2);
    if (localArrayList2.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "delayLargerModulesAndReturnSmallerModules|begin delay download:" + this.jdField_a_of_type_Int + "|" + this.b + "|" + localArrayList2);
      }
      paramList = new WeakReference(this);
      ThreadManager.getTimer().schedule(new xfr(this, paramList, localArrayList2, paramDownloadListener), this.jdField_a_of_type_Int * 1000);
    }
    return localArrayList1;
  }
  
  private void a(List paramList, DownloadListener paramDownloadListener)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((PreloadModule)paramList.next()).downloadModule(false, paramDownloadListener, this, true);
      }
    }
  }
  
  private void a(List paramList, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig.isLocalResNewest())
    {
      DownloadChooseReq localDownloadChooseReq = new DownloadChooseReq();
      localDownloadChooseReq.iUin = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
      localDownloadChooseReq.vecResInfo = PreloadConfig.modulesToResInfos(paramList);
      QWalletCommonServlet.a(localDownloadChooseReq, new xfp(this, paramList, paramDownloadListener, paramBoolean));
      return;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.resInfosToModules(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig.getLastBackResInfos());
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadBackControlModules|choose res:" + paramList);
    }
    b(paramList, paramDownloadListener, paramBoolean);
  }
  
  private boolean a()
  {
    String str = a();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(str))
    {
      long l2 = StorageManager.a(str);
      l1 = l2;
      if (l2 > 104857600L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "isDiskEnoughToDownload|true|" + str + "|" + l2);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "isDiskEnoughToDownload|false|" + str + "|" + l1);
    }
    return false;
  }
  
  public static boolean a(PreloadManager paramPreloadManager)
  {
    return (paramPreloadManager != null) && (!paramPreloadManager.jdField_a_of_type_Boolean);
  }
  
  private boolean a(ResourceInfo paramResourceInfo, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramResourceInfo == null) || (TextUtils.isEmpty(paramResourceInfo.filePath))) {}
    do
    {
      do
      {
        return false;
      } while ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!paramString.equalsIgnoreCase(paramResourceInfo.fileMd5)) && (paramResourceInfo.doneTime < paramLong));
      if ((!paramBoolean) && (!PreloadResource.isNeedAutoUnzip(paramResourceInfo.url, 0))) {
        break;
      }
    } while (TextUtils.isEmpty(paramResourceInfo.folderPath));
    return true;
    return true;
  }
  
  private void b(List paramList, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    List localList = paramList;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModules|afterGetConfig");
      }
      localList = a(paramList, paramDownloadListener);
    }
    a(localList, paramDownloadListener);
  }
  
  private void c(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qwallet_preload_config", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("config_from_qq" + this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), paramString).apply();
      }
    }
  }
  
  private void e()
  {
    int i = QWalletSetting.a(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin() + "", "deal_delay_interval", 30);
    int j = QWalletSetting.a(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin() + "", "need_wait_size", 1024);
    a(i, j);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "initPreloadHelpConfig|" + i + "|" + j + "|" + this.jdField_a_of_type_Int + "|" + this.b);
    }
  }
  
  private void f()
  {
    if (ResUtil.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "clearOldFolder already Check");
      }
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      Object localObject2 = e();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = d();
      }
      localObject1 = new File((String)localObject1);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            localObject2 = localObject1[i];
            if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (StringUtil.c(((File)localObject2).getName())))
            {
              localObject2 = ((File)localObject2).listFiles();
              if (localObject2 != null)
              {
                int m = localObject2.length;
                int j = 0;
                while (j < m)
                {
                  Object localObject3 = localObject2[j];
                  if ((localObject3 != null) && (localObject3.exists()) && (localObject3.isDirectory()) && (localObject3.getName().equals(".preloaduni"))) {
                    FileUtils.a(localObject3.getAbsolutePath(), false);
                  }
                  j += 1;
                }
              }
            }
            i += 1;
          }
        }
      }
      ResUtil.a(true);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadManager", 2, "clearOldFolder" + (System.currentTimeMillis() - l));
  }
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new xfn(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new xfs(this, new WeakReference(this)), 5, null, true);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("FlowControlThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new xfv(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  public PreloadModule a(String paramString)
  {
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByName(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public PreloadResource a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModules().iterator();
      Iterator localIterator2;
      do
      {
        localObject2 = localObject1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((PreloadModule)localIterator1.next()).getResList().iterator();
        localObject2 = localObject1;
        localObject1 = localObject2;
      } while (!localIterator2.hasNext());
      localObject1 = (PreloadResource)localIterator2.next();
      if (!QWalletTools.c(paramString, ((PreloadResource)localObject1).mResId)) {
        break label100;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return localObject2;
      label100:
      localObject1 = localObject2;
    }
  }
  
  public ResourceInfo a(String paramString)
  {
    ResourceInfo localResourceInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getResInfoByResId(paramString, this);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResInfoByResId :" + paramString + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  public ResourceInfo a(String paramString, boolean paramBoolean)
  {
    ResourceInfo localResourceInfo = ResUtil.a(paramString, this, paramBoolean, 0);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResInfoByUrl :" + paramString + "|" + paramBoolean + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  public void a()
  {
    f();
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 5) {
      this.jdField_a_of_type_Int = 5;
    }
    while (paramInt2 <= 0)
    {
      this.b = 1024;
      return;
      if (paramInt1 > 1800) {
        this.jdField_a_of_type_Int = 1800;
      } else {
        this.jdField_a_of_type_Int = paramInt1;
      }
    }
    this.b = paramInt2;
  }
  
  /* Error */
  public void a(QWalletConfig.ConfigInfo paramConfigInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 473	org/json/JSONArray
    //   5: dup
    //   6: invokespecial 474	org/json/JSONArray:<init>	()V
    //   9: astore 8
    //   11: aload_1
    //   12: ifnull +18 -> 30
    //   15: ldc_w 476
    //   18: aload_1
    //   19: getfield 480	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +59 -> 95
    //   39: ldc 126
    //   41: iconst_2
    //   42: new 83	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 482
    //   52: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 484	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_Long	J
    //   59: invokevirtual 265	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 133
    //   64: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   71: getfield 487	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   74: invokevirtual 265	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc 133
    //   79: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: getfield 489	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:b	Ljava/lang/String;
    //   86: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_1
    //   96: getfield 484	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_Long	J
    //   99: lstore 4
    //   101: aload_0
    //   102: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   105: getfield 487	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   108: lstore 6
    //   110: lload 4
    //   112: lload 6
    //   114: lcmp
    //   115: ifle -85 -> 30
    //   118: new 491	org/json/JSONObject
    //   121: dup
    //   122: aload_1
    //   123: getfield 489	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:b	Ljava/lang/String;
    //   126: invokespecial 492	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: ldc_w 494
    //   132: invokevirtual 498	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   135: astore 9
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_2
    //   140: aload 9
    //   142: invokevirtual 501	org/json/JSONArray:length	()I
    //   145: if_icmpge +29 -> 174
    //   148: aload 8
    //   150: aload 9
    //   152: iload_2
    //   153: invokevirtual 505	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   156: invokevirtual 509	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   159: pop
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: goto -25 -> 139
    //   167: astore 9
    //   169: aload 9
    //   171: invokevirtual 512	java/lang/Throwable:printStackTrace	()V
    //   174: aload_0
    //   175: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   178: aload 8
    //   180: aload_0
    //   181: iconst_1
    //   182: invokevirtual 516	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:innerReplaceConfig	(Lorg/json/JSONArray;Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;I)V
    //   185: aload_0
    //   186: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   189: aload_1
    //   190: getfield 484	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$ConfigInfo:jdField_a_of_type_Long	J
    //   193: putfield 487	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   196: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +32 -> 231
    //   202: ldc 126
    //   204: iconst_2
    //   205: new 83	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 518
    //   215: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   222: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   235: invokevirtual 521	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:savePreloadConfig	()V
    //   238: goto -208 -> 30
    //   241: astore_1
    //   242: aload_0
    //   243: monitorexit
    //   244: aload_1
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PreloadManager
    //   0	246	1	paramConfigInfo	QWalletConfig.ConfigInfo
    //   138	26	2	i	int
    //   25	2	3	bool	boolean
    //   99	12	4	l1	long
    //   108	5	6	l2	long
    //   9	170	8	localJSONArray1	JSONArray
    //   135	16	9	localJSONArray2	JSONArray
    //   167	3	9	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   118	137	167	java/lang/Throwable
    //   139	160	167	java/lang/Throwable
    //   2	11	241	finally
    //   15	26	241	finally
    //   33	95	241	finally
    //   95	110	241	finally
    //   118	137	241	finally
    //   139	160	241	finally
    //   169	174	241	finally
    //   174	231	241	finally
    //   231	238	241	finally
  }
  
  public void a(PreloadResource paramPreloadResource, PreloadModule paramPreloadModule, DownloadListener paramDownloadListener)
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null) {
      i();
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new PreloadManager.FlowControlDownloadStruct(paramPreloadResource, paramPreloadModule, paramDownloadListener);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      if ((paramConfig != null) && (paramConfig.content_list != null))
      {
        Iterator localIterator = paramConfig.content_list.get().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("PreloadManager", 2, "receiveAllConfigs|type: 68,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            try
            {
              localObject = new JSONObject((String)localObject).getJSONArray("module_config");
              int i = 0;
              while (i < ((JSONArray)localObject).length())
              {
                localJSONArray.put(((JSONArray)localObject).get(i));
                i += 1;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
      c(localJSONArray.toString());
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.innerReplaceConfig(localJSONArray, this, 0);
  }
  
  /* Error */
  public void a(DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 126
    //   10: iconst_2
    //   11: new 83	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 576
    //   21: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 464	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc 133
    //   30: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   37: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: invokevirtual 578	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	()V
    //   50: aload_0
    //   51: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   54: invokevirtual 581	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModuleNum	()I
    //   57: ifle +12 -> 69
    //   60: aload_0
    //   61: invokespecial 582	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	()Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifne +6 -> 72
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   76: aload_0
    //   77: invokevirtual 585	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:filterInvalidModules	(Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;)V
    //   80: aload_0
    //   81: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   84: invokevirtual 437	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModules	()Ljava/util/List;
    //   87: astore 4
    //   89: new 107	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 108	java/util/ArrayList:<init>	()V
    //   96: astore 5
    //   98: new 107	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 108	java/util/ArrayList:<init>	()V
    //   105: astore 6
    //   107: aload 4
    //   109: aload 5
    //   111: aload 6
    //   113: invokestatic 589	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:splitModulesByBackControl	(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    //   116: aload 6
    //   118: invokeinterface 118 1 0
    //   123: ifle +44 -> 167
    //   126: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +30 -> 159
    //   132: ldc 126
    //   134: iconst_2
    //   135: new 83	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 591
    //   145: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: aload 6
    //   162: aload_1
    //   163: iload_2
    //   164: invokespecial 234	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:b	(Ljava/util/List;Lcom/tencent/mobileqq/vip/DownloadListener;Z)V
    //   167: aload 5
    //   169: invokeinterface 118 1 0
    //   174: ifle +44 -> 218
    //   177: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +30 -> 210
    //   183: ldc 126
    //   185: iconst_2
    //   186: new 83	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 593
    //   196: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 5
    //   201: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_0
    //   211: aload 5
    //   213: aload_1
    //   214: iload_2
    //   215: invokespecial 170	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	(Ljava/util/List;Lcom/tencent/mobileqq/vip/DownloadListener;Z)V
    //   218: aload_0
    //   219: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   222: invokevirtual 521	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:savePreloadConfig	()V
    //   225: goto -156 -> 69
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	PreloadManager
    //   0	233	1	paramDownloadListener	DownloadListener
    //   0	233	2	paramBoolean	boolean
    //   64	2	3	bool	boolean
    //   87	21	4	localList	List
    //   96	116	5	localArrayList1	ArrayList
    //   105	56	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	46	228	finally
    //   46	65	228	finally
    //   72	159	228	finally
    //   159	167	228	finally
    //   167	210	228	finally
    //   210	218	228	finally
    //   218	225	228	finally
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = b(paramString);
      if (paramString != null) {
        paramString.downloadModule(true, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, ResultReceiver paramResultReceiver)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModules().iterator();
          localObject2 = null;
          if (!localIterator1.hasNext()) {
            break label207;
          }
          PreloadModule localPreloadModule = (PreloadModule)localIterator1.next();
          Iterator localIterator2 = localPreloadModule.getResList().iterator();
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (!localIterator2.hasNext()) {
            continue;
          }
          localObject2 = (PreloadResource)localIterator2.next();
          if (QWalletTools.c(paramString, ((PreloadResource)localObject2).mResId)) {
            localObject1 = c(((PreloadResource)localObject2).getResDownloadUrl(localPreloadModule));
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadManager", 2, "getFilePathByResID|" + paramString + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig + "|" + (String)localObject1);
          }
          if (paramResultReceiver != null)
          {
            paramString = new Bundle();
            paramString.putString("path", (String)localObject1);
            paramResultReceiver.send(0, paramString);
          }
          return;
        }
      }
      finally {}
      continue;
      label207:
      localObject1 = localObject2;
    }
  }
  
  public void a(String paramString, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    a(paramString, "", paramOnGetPathListener);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, PreloadManager.OnGetPathListener paramOnGetPathListener, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    PreloadManager.PathResult localPathResult;
    ResourceInfo localResourceInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPath: params" + paramString1 + "|" + paramString2 + "|" + paramLong + "|" + paramBoolean);
      }
      localPathResult = new PreloadManager.PathResult();
      localPathResult.url = paramString1;
      localResourceInfo = a(paramString1, paramBoolean);
      boolean bool = a(localResourceInfo, paramString2, paramLong, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPath: isValidFileExist" + bool + "|" + localResourceInfo);
      }
      if (!bool) {
        break;
      }
    } while (paramOnGetPathListener == null);
    localPathResult.filePath = localResourceInfo.filePath;
    localPathResult.folderPath = localResourceInfo.folderPath;
    paramOnGetPathListener.onResult(0, localPathResult);
    return;
    if (localResourceInfo != null)
    {
      ResUtil.b(paramString1);
      QWalletTools.a(localResourceInfo.filePath);
      QWalletTools.a(localResourceInfo.folderPath);
    }
    a(paramString1, paramBoolean, paramOnGetPathListener);
  }
  
  public void a(String paramString1, String paramString2, QWalletConfig.ConfigInfo paramConfigInfo)
  {
    if (QWalletTools.c(paramString1, "preload"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "configFromMoggy onUpdate");
      }
      a(paramConfigInfo);
      h();
    }
  }
  
  public void a(String paramString1, String paramString2, PreloadManager.DownloadCallback paramDownloadCallback)
  {
    String str = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadRes|" + paramString1 + "|" + paramString2);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          b(paramString2);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.savePreloadConfig();
        }
        Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModules().iterator();
        localObject2 = null;
        if (!localIterator1.hasNext()) {
          break label268;
        }
        PreloadModule localPreloadModule = (PreloadModule)localIterator1.next();
        Iterator localIterator2 = localPreloadModule.getResList().iterator();
        Object localObject1 = localObject2;
        paramString2 = str;
        str = paramString2;
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject2 = (PreloadResource)localIterator2.next();
        if (!QWalletTools.c(paramString1, ((PreloadResource)localObject2).mResId)) {
          break label265;
        }
        localObject1 = localObject2;
        paramString2 = localPreloadModule;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadRes ERR_CONFIG_NOT_EXIST");
      }
      paramDownloadCallback.onDownloadResFinished(null, -7, null, null);
      return;
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadRes|disk space not enough");
        }
        paramDownloadCallback.onDownloadResFinished(null, -4, null, null);
      }
      else
      {
        ((PreloadResource)localObject2).startDownload(this, str, new xft(this, paramDownloadCallback), false);
        continue;
        label265:
        continue;
        label268:
        if (str != null) {
          if (localObject2 != null) {}
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    long l;
    if (!TextUtils.isEmpty(paramString2))
    {
      QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(244);
      if (localQWalletConfigManager != null) {
        l = localQWalletConfigManager.a();
      }
    }
    for (;;)
    {
      a(paramString1, paramString2, l, paramOnGetPathListener, true);
      return;
      l = 0L;
      continue;
      l = 0L;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = a(paramString);
      if (paramString != null) {
        paramString.downloadModule(paramBoolean, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, boolean paramBoolean, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    paramOnGetPathListener = new PreloadResource.RealTimeDownloadListener(new xfo(this, new WeakReference(this), paramBoolean, paramOnGetPathListener));
    PreloadComDownloader.a().a(paramString, d(paramString), null, paramOnGetPathListener, false);
  }
  
  public void a(List paramList, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((String)paramList.next(), paramOnGetPathListener);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      a(null, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(PreloadResource paramPreloadResource)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.isResInConfig(paramPreloadResource);
  }
  
  public PreloadModule b(String paramString)
  {
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByID(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 126
    //   10: iconst_2
    //   11: new 83	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 726
    //   21: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 133
    //   30: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   37: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 40	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   50: aload_1
    //   51: invokevirtual 724	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModuleByID	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadModule;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +74 -> 130
    //   59: aload_1
    //   60: invokevirtual 440	com/tencent/mobileqq/activity/qwallet/preload/PreloadModule:getResList	()Ljava/util/List;
    //   63: invokeinterface 174 1 0
    //   68: astore_2
    //   69: aload_2
    //   70: invokeinterface 179 1 0
    //   75: ifeq +55 -> 130
    //   78: aload_2
    //   79: invokeinterface 183 1 0
    //   84: checkcast 294	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource
    //   87: astore_3
    //   88: aload_3
    //   89: getfield 729	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:type	I
    //   92: iconst_5
    //   93: if_icmpne -24 -> 69
    //   96: aload_3
    //   97: getfield 730	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:url	Ljava/lang/String;
    //   100: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +13 -> 116
    //   106: aload_3
    //   107: getfield 733	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:urlPath	Ljava/lang/String;
    //   110: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -44 -> 69
    //   116: aload_0
    //   117: aload_3
    //   118: aload_1
    //   119: invokevirtual 600	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getResDownloadUrl	(Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadModule;)Ljava/lang/String;
    //   122: invokevirtual 602	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: areturn
    //   130: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +12 -> 145
    //   136: ldc 126
    //   138: iconst_2
    //   139: ldc_w 735
    //   142: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aconst_null
    //   146: astore_1
    //   147: goto -21 -> 126
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	PreloadManager
    //   0	155	1	paramString	String
    //   68	11	2	localIterator	Iterator
    //   87	31	3	localPreloadResource	PreloadResource
    // Exception table:
    //   from	to	target	type
    //   2	46	150	finally
    //   46	55	150	finally
    //   59	69	150	finally
    //   69	116	150	finally
    //   116	126	150	finally
    //   130	145	150	finally
  }
  
  public void b()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (l1 - ResUtil.a() < 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "removeSurplusRes already Check Today");
      }
      return;
    }
    Object localObject = a();
    long l2 = System.currentTimeMillis();
    long l3 = FileUtils.b((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "resFolderPathSize:" + l3 + "|" + 209715200L + "|" + (System.currentTimeMillis() - l2));
    }
    if (l3 > 209715200L)
    {
      localObject = ResUtil.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResUtil.ResTimeInfo localResTimeInfo = (ResUtil.ResTimeInfo)((Iterator)localObject).next();
        if ((localResTimeInfo != null) && (!TextUtils.isEmpty(localResTimeInfo.jdField_a_of_type_JavaLangString)) && (l1 - localResTimeInfo.jdField_a_of_type_Long > 2592000000L) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.isUrlInConfig(localResTimeInfo.jdField_a_of_type_JavaLangString)))
        {
          ResourceInfo localResourceInfo = a(localResTimeInfo.jdField_a_of_type_JavaLangString, false);
          if (localResourceInfo != null)
          {
            ResUtil.b(localResTimeInfo.jdField_a_of_type_JavaLangString);
            QWalletTools.a(localResourceInfo.filePath);
            QWalletTools.a(localResourceInfo.folderPath);
            ResDownRecordUtil.a(localResTimeInfo.jdField_a_of_type_JavaLangString, 8);
          }
        }
      }
    }
    ResUtil.a(l1);
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.mergeConfig(paramString, this);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    b(paramString, "", paramOnGetPathListener);
  }
  
  public void b(String paramString1, String paramString2, PreloadManager.DownloadCallback paramDownloadCallback)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadModule|" + paramString1 + " | " + paramString2);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          boolean bool = TextUtils.isEmpty(paramString1);
          if ((!bool) && (paramDownloadCallback != null)) {}
        }
        else
        {
          return;
        }
        b(paramString2);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.savePreloadConfig();
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByID(paramString1);
        if ((paramString2 == null) || (paramString2.getResNum() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadManager", 2, "downloadModule|json wrong");
          }
          paramDownloadCallback.onDownloadResFinished(paramString1, -7, null, null);
          continue;
        }
        if (a()) {
          break label171;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModule|disk space not enough");
      }
      paramDownloadCallback.onDownloadResFinished(paramString1, -4, null, null);
      continue;
      label171:
      paramString2.downloadModule(true, new xfu(this, paramString1, paramDownloadCallback), this, false);
    }
  }
  
  public void b(String paramString1, String paramString2, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    long l;
    if (!TextUtils.isEmpty(paramString2))
    {
      QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(244);
      if (localQWalletConfigManager != null) {
        l = localQWalletConfigManager.a();
      }
    }
    for (;;)
    {
      a(paramString1, paramString2, l, paramOnGetPathListener, false);
      return;
      l = 0L;
      continue;
      l = 0L;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.savePreloadConfig();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null) {
      i();
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(244);
    if (localQWalletConfigManager != null) {
      localQWalletConfigManager.b("preload", this);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig = null;
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetMobile2Wifi");
    }
    h();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetNone2Mobile");
    }
    h();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetNone2Wifi");
    }
    h();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetWifi2Mobile");
    }
    h();
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager
 * JD-Core Version:    0.7.0.1
 */