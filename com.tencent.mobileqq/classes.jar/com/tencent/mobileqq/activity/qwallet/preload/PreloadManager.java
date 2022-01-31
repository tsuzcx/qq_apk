package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.DownloadChooseReq;
import agkg;
import agkn;
import agmo;
import agmq;
import agmu;
import agos;
import agov;
import agow;
import agox;
import agoy;
import agoz;
import agpa;
import agpb;
import agpc;
import agpe;
import agpf;
import agpg;
import agph;
import agqh;
import agwj;
import alzs;
import amdx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import awmr;
import bace;
import baip;
import batl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadManager
  extends agpg
  implements agmu, INetInfoHandler, Manager
{
  private int jdField_a_of_type_Int = 30;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PreloadBackControlConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig;
  private PreloadConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig;
  public boolean a;
  private int b = 1024;
  
  public PreloadManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig = PreloadConfig.readConfig("preload.config", this.jdField_a_of_type_MqqAppAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig = PreloadBackControlConfig.readBackControlConfig(this.jdField_a_of_type_MqqAppAppRuntime);
    e();
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
      g();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        QLog.d("PreloadManager", 1, "AppNetConnInfo.registerConnectionChangeReceiver is error msg=" + paramQQAppInterface.getMessage());
        a(paramQQAppInterface);
      }
    }
  }
  
  public static agpg a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (PreloadManager)((QQAppInterface)localAppRuntime).getManager(151);
    }
    return agph.a();
  }
  
  public static PreloadManager.PathResult a(DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResPathSync: param" + paramDownloadParam);
    }
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {}
    ResourceInfo localResourceInfo;
    do
    {
      return null;
      paramDownloadParam.standardlize();
      localResourceInfo = a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
    } while (!a(localResourceInfo, paramDownloadParam));
    PreloadManager.PathResult localPathResult = new PreloadManager.PathResult();
    localPathResult.url = paramDownloadParam.url;
    localPathResult.filePath = localResourceInfo.filePath;
    localPathResult.folderPath = localResourceInfo.folderPath;
    localPathResult.isAlreadyExist = true;
    return localPathResult;
  }
  
  public static PreloadManager.PathResult a(String paramString)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString;
    return a(localDownloadParam);
  }
  
  public static ResourceInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = agqh.a(paramString, paramBoolean, 0, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResInfoByUrl :" + paramString + "|" + paramBoolean + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  private List<PreloadModule> a(List<PreloadModule> paramList, batl parambatl)
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
      ThreadManager.getTimer().schedule(new PreloadManager.4(this, paramList, localArrayList2, parambatl), this.jdField_a_of_type_Int * 1000);
    }
    return localArrayList1;
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = a(paramString, paramBoolean, paramInt);
    if (localResourceInfo != null)
    {
      agqh.b(paramString, paramInt);
      agwj.a(localResourceInfo.filePath);
      agwj.a(localResourceInfo.folderPath);
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(paramThrowable.toString());
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int i = 0;
        while ((i < paramThrowable.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramThrowable[i].toString());
          i += 1;
        }
      }
      VACDReportUtil.a("preload_crash", "qqwallet", "crash", "Catch", null, 668814, localStringBuilder.toString());
    }
  }
  
  private void a(List<PreloadModule> paramList, batl parambatl)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((PreloadModule)paramList.next()).downloadModule(false, parambatl, this, true);
      }
    }
  }
  
  private void a(List<PreloadModule> paramList, batl parambatl, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig.isLocalResNewest())
    {
      DownloadChooseReq localDownloadChooseReq = new DownloadChooseReq();
      localDownloadChooseReq.iUin = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
      localDownloadChooseReq.vecResInfo = PreloadConfig.modulesToResInfos(paramList);
      agkg.a(localDownloadChooseReq, new agow(this, paramList, parambatl, paramBoolean));
      return;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.resInfosToModules(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig.getLastBackResInfos());
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadBackControlModules|choose res:" + paramList);
    }
    b(paramList, parambatl, paramBoolean);
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
      long l2 = awmr.a(str);
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
  
  private static boolean a(ResourceInfo paramResourceInfo, DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam == null) {}
    do
    {
      String str;
      long l;
      boolean bool;
      do
      {
        do
        {
          return false;
        } while ((paramResourceInfo == null) || (TextUtils.isEmpty(paramResourceInfo.filePath)));
        str = paramDownloadParam.md5;
        l = paramDownloadParam.md5Time;
        bool = paramDownloadParam.isForceUnzip;
        paramDownloadParam = paramDownloadParam.md5ForChecked;
      } while (((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!str.equalsIgnoreCase(paramResourceInfo.fileMd5)) && (paramResourceInfo.doneTime < l)) || ((!TextUtils.isEmpty(paramDownloadParam)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!paramDownloadParam.equalsIgnoreCase(paramResourceInfo.fileMd5))));
      if ((!bool) && (!PreloadResource.isNeedAutoUnzip(paramResourceInfo.url, 0))) {
        break;
      }
    } while (TextUtils.isEmpty(paramResourceInfo.folderPath));
    return true;
    return true;
  }
  
  public static String b(String paramString)
  {
    ResourceInfo localResourceInfo = agqh.a(paramString, false, 0, 0);
    paramString = null;
    if (localResourceInfo != null) {
      paramString = localResourceInfo.folderPath;
    }
    return paramString;
  }
  
  private void b(List<PreloadModule> paramList, batl parambatl, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModules|afterGetConfig");
      }
      localObject = a(paramList, parambatl);
    }
    a((List)localObject, parambatl);
  }
  
  public static String c(String paramString)
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
  
  private void d()
  {
    if (!agqh.a()) {}
    try
    {
      String str = c();
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = new File(str);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = d();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            bace.c(str, (String)localObject);
          }
        }
      }
      agqh.a(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("PreloadManager", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  private void e()
  {
    int i = agkn.a(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin() + "", "deal_delay_interval", 30);
    int j = agkn.a(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin() + "", "need_wait_size", 1024);
    a(i, j);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "initPreloadHelpConfig|" + i + "|" + j + "|" + this.jdField_a_of_type_Int + "|" + this.b);
    }
  }
  
  private void f()
  {
    if (agqh.b()) {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "clearOldFolder already Check");
      }
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      Object localObject2 = g();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = e();
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
            if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (baip.c(((File)localObject2).getName())))
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
                    bace.a(localObject3.getAbsolutePath(), false);
                  }
                  j += 1;
                }
              }
            }
            i += 1;
          }
        }
      }
      agqh.b(true);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadManager", 2, "clearOldFolder" + (System.currentTimeMillis() - l));
  }
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new PreloadManager.1(this));
  }
  
  private void h()
  {
    b(false);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new agoz(this, ThreadManager.getSubThreadLooper());
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
      if (!agwj.c(paramString, ((PreloadResource)localObject1).mResId)) {
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
    ResourceInfo localResourceInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getResInfoByResId(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResInfoByResId :" + paramString + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.folderPath;
    }
    return null;
  }
  
  public void a()
  {
    f();
    if (!agpg.b) {
      agqh.a(0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig);
    }
    agqh.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig);
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
  public void a(agmo paramagmo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 571	org/json/JSONArray
    //   5: dup
    //   6: invokespecial 572	org/json/JSONArray:<init>	()V
    //   9: astore 8
    //   11: aload_1
    //   12: ifnull +18 -> 30
    //   15: ldc_w 574
    //   18: aload_1
    //   19: getfield 578	agmo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +59 -> 95
    //   39: ldc 73
    //   41: iconst_2
    //   42: new 75	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 580
    //   52: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 582	agmo:jdField_a_of_type_Long	J
    //   59: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 186
    //   64: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   71: getfield 585	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   74: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc 186
    //   79: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: getfield 587	agmo:b	Ljava/lang/String;
    //   86: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_1
    //   96: getfield 582	agmo:jdField_a_of_type_Long	J
    //   99: lstore 4
    //   101: aload_0
    //   102: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   105: getfield 585	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   108: lstore 6
    //   110: lload 4
    //   112: lload 6
    //   114: lcmp
    //   115: ifle -85 -> 30
    //   118: new 589	org/json/JSONObject
    //   121: dup
    //   122: aload_1
    //   123: getfield 587	agmo:b	Ljava/lang/String;
    //   126: invokespecial 590	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: ldc_w 592
    //   132: invokevirtual 596	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   135: astore 9
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_2
    //   140: aload 9
    //   142: invokevirtual 599	org/json/JSONArray:length	()I
    //   145: if_icmpge +29 -> 174
    //   148: aload 8
    //   150: aload 9
    //   152: iload_2
    //   153: invokevirtual 603	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   156: invokevirtual 607	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   159: pop
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: goto -25 -> 139
    //   167: astore 9
    //   169: aload 9
    //   171: invokevirtual 610	java/lang/Throwable:printStackTrace	()V
    //   174: aload_0
    //   175: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   178: aload 8
    //   180: aload_0
    //   181: iconst_1
    //   182: invokevirtual 614	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:innerReplaceConfig	(Lorg/json/JSONArray;Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;I)V
    //   185: aload_0
    //   186: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   189: aload_1
    //   190: getfield 582	agmo:jdField_a_of_type_Long	J
    //   193: putfield 585	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   196: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +32 -> 231
    //   202: ldc 73
    //   204: iconst_2
    //   205: new 75	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 616
    //   215: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   222: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   235: invokevirtual 619	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:savePreloadConfig	()V
    //   238: goto -208 -> 30
    //   241: astore_1
    //   242: aload_0
    //   243: monitorexit
    //   244: aload_1
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PreloadManager
    //   0	246	1	paramagmo	agmo
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
  
  public void a(amdx paramamdx)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if ((paramamdx != null) && (paramamdx.a != null))
        {
          paramamdx = paramamdx.a;
          int k = paramamdx.length;
          i = 0;
          if (i < k)
          {
            Object localObject = paramamdx[i].jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.d("PreloadManager", 2, "receiveAllConfigs|type: 68,content: " + (String)localObject);
            }
            try
            {
              localObject = new JSONObject((String)localObject).getJSONArray("module_config");
              int j = 0;
              if (j >= ((JSONArray)localObject).length()) {
                break label165;
              }
              localJSONArray.put(((JSONArray)localObject).get(j));
              j += 1;
              continue;
              c(localJSONArray.toString());
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.innerReplaceConfig(localJSONArray, this, 0);
        return;
      }
      finally {}
      label165:
      i += 1;
    }
  }
  
  /* Error */
  public void a(batl parambatl, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 73
    //   10: iconst_2
    //   11: new 75	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 636
    //   21: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 189	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc 186
    //   30: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: invokevirtual 638	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	()V
    //   50: aload_0
    //   51: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   54: invokevirtual 641	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModuleNum	()I
    //   57: ifle +12 -> 69
    //   60: aload_0
    //   61: invokespecial 642	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	()Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifne +6 -> 72
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   76: aload_0
    //   77: invokevirtual 645	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:filterInvalidModules	(Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;)V
    //   80: aload_0
    //   81: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   84: invokevirtual 546	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModules	()Ljava/util/List;
    //   87: astore 4
    //   89: new 192	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 193	java/util/ArrayList:<init>	()V
    //   96: astore 5
    //   98: new 192	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 193	java/util/ArrayList:<init>	()V
    //   105: astore 6
    //   107: aload 4
    //   109: aload 5
    //   111: aload 6
    //   113: invokestatic 649	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:splitModulesByBackControl	(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    //   116: aload 6
    //   118: invokeinterface 203 1 0
    //   123: ifle +44 -> 167
    //   126: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +30 -> 159
    //   132: ldc 73
    //   134: iconst_2
    //   135: new 75	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 651
    //   145: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: aload 6
    //   162: aload_1
    //   163: iload_2
    //   164: invokespecial 341	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:b	(Ljava/util/List;Lbatl;Z)V
    //   167: aload 5
    //   169: invokeinterface 203 1 0
    //   174: ifle +44 -> 218
    //   177: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +30 -> 210
    //   183: ldc 73
    //   185: iconst_2
    //   186: new 75	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 653
    //   196: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 5
    //   201: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_0
    //   211: aload 5
    //   213: aload_1
    //   214: iload_2
    //   215: invokespecial 240	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	(Ljava/util/List;Lbatl;Z)V
    //   218: aload_0
    //   219: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   222: invokevirtual 619	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:savePreloadConfig	()V
    //   225: goto -156 -> 69
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	PreloadManager
    //   0	233	1	parambatl	batl
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
  
  public void a(DownloadParam paramDownloadParam, agpe paramagpe)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {
      if (paramagpe != null) {
        paramagpe.onResult(1, PreloadManager.PathResult.getFailRes(null));
      }
    }
    ResourceInfo localResourceInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPath: param" + paramDownloadParam);
      }
      paramDownloadParam.standardlize();
      localResourceInfo = a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
      boolean bool = a(localResourceInfo, paramDownloadParam);
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPath: isValidFileExist" + bool + "|" + localResourceInfo);
      }
      if (!bool) {
        break;
      }
    } while (paramagpe == null);
    PreloadManager.PathResult localPathResult = new PreloadManager.PathResult();
    localPathResult.url = paramDownloadParam.url;
    localPathResult.filePath = localResourceInfo.filePath;
    localPathResult.folderPath = localResourceInfo.folderPath;
    localPathResult.isAlreadyExist = true;
    paramagpe.onResult(0, localPathResult);
    return;
    if (localResourceInfo != null)
    {
      agqh.b(paramDownloadParam.url, paramDownloadParam.filePos);
      agwj.a(localResourceInfo.filePath);
      agwj.a(localResourceInfo.folderPath);
    }
    b(paramDownloadParam, paramagpe);
  }
  
  public void a(PreloadResource paramPreloadResource, PreloadModule paramPreloadModule, batl parambatl)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      i();
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new agpb(paramPreloadResource, paramPreloadModule, parambatl);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
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
  
  public void a(String paramString, agpe paramagpe)
  {
    a(paramString, "", paramagpe);
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
            break label211;
          }
          PreloadModule localPreloadModule = (PreloadModule)localIterator1.next();
          Iterator localIterator2 = localPreloadModule.getResList().iterator();
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (!localIterator2.hasNext()) {
            continue;
          }
          localObject2 = (PreloadResource)localIterator2.next();
          if (agwj.c(paramString, ((PreloadResource)localObject2).mResId)) {
            localObject1 = a(((PreloadResource)localObject2).getResDownloadUrl(localPreloadModule), ((PreloadResource)localObject2).getFilePos());
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
      label211:
      localObject1 = localObject2;
    }
  }
  
  public void a(String paramString1, String paramString2, agmo paramagmo)
  {
    if (agwj.c(paramString1, "preload"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "configFromMoggy onUpdate");
      }
      a(paramagmo);
      h();
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, agpa paramagpa)
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
        if (!agwj.c(paramString1, ((PreloadResource)localObject2).mResId)) {
          break label265;
        }
        localObject1 = localObject2;
        paramString2 = localPreloadModule;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadRes ERR_CONFIG_NOT_EXIST");
      }
      paramagpa.onDownloadResFinished(null, -7, null, null);
      return;
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadRes|disk space not enough");
        }
        paramagpa.onDownloadResFinished(null, -4, null, null);
      }
      else
      {
        ((PreloadResource)localObject2).startDownload(this, str, new agox(this, paramagpa), false);
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
  
  public void a(String paramString1, String paramString2, agpe paramagpe)
  {
    Object localObject;
    long l;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = (agmq)this.jdField_a_of_type_MqqAppAppRuntime.getManager(245);
      if (localObject != null) {
        l = ((agmq)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).url = paramString1;
      ((DownloadParam)localObject).md5 = paramString2;
      ((DownloadParam)localObject).md5Time = l;
      ((DownloadParam)localObject).isForceUnzip = true;
      a((DownloadParam)localObject, paramagpe);
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
  
  public void a(LinkedList<DownloadParam> paramLinkedList, agpf paramagpf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResPath: params" + paramLinkedList + ",OnGetPathsListener=" + paramagpf);
    }
    if (paramLinkedList == null)
    {
      if (paramagpf != null) {
        paramagpf.a(1, null);
      }
      return;
    }
    new agpc(this, paramLinkedList, paramagpf).a();
  }
  
  public void a(List<String> paramList, agpe paramagpe)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((String)paramList.next(), paramagpe);
      }
    }
  }
  
  public void a(JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PreloadManager", 2, "[replaceConfig] fromType=" + paramInt + "configJa=" + paramJSONArray);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.innerReplaceConfig(paramJSONArray, this, paramInt);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      a(null, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("PreloadManager", 1, "checkAndDownload is error msg= " + localThrowable.getMessage());
      }
    }
    finally {}
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
  
  public void b()
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
  
  public void b(DownloadParam paramDownloadParam, agpe paramagpe)
  {
    paramagpe = new agov(this, paramDownloadParam, paramagpe, new WeakReference(this));
    if (TextUtils.isEmpty(paramDownloadParam.filePath)) {
      paramDownloadParam.filePath = b(paramDownloadParam.url, paramDownloadParam.filePos);
    }
    paramDownloadParam.isPreDownload = false;
    agos.a().a(paramDownloadParam, paramagpe, null);
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
  
  public void b(String paramString, agpe paramagpe)
  {
    b(paramString, "", paramagpe);
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, agpa paramagpa)
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
          if ((!bool) && (paramagpa != null)) {}
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
          paramagpa.onDownloadResFinished(paramString1, -7, null, null);
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
      paramagpa.onDownloadResFinished(paramString1, -4, null, null);
      continue;
      label171:
      paramString2.downloadModule(true, new agoy(this, paramString1, paramagpa), this, false);
    }
  }
  
  public void b(String paramString1, String paramString2, agpe paramagpe)
  {
    Object localObject;
    long l;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = (agmq)this.jdField_a_of_type_MqqAppAppRuntime.getManager(245);
      if (localObject != null) {
        l = ((agmq)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).url = paramString1;
      ((DownloadParam)localObject).md5 = paramString2;
      ((DownloadParam)localObject).md5Time = l;
      ((DownloadParam)localObject).isForceUnzip = false;
      a((DownloadParam)localObject, paramagpe);
      return;
      l = 0L;
      continue;
      l = 0L;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new PreloadManager.5(this, new WeakReference(this), paramBoolean), 5, null, true);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      i();
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  /* Error */
  public String d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 73
    //   10: iconst_2
    //   11: new 75	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 865
    //   21: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 186
    //   30: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 45	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   50: aload_1
    //   51: invokevirtual 809	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModuleByID	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadModule;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +77 -> 133
    //   59: aload_1
    //   60: invokevirtual 549	com/tencent/mobileqq/activity/qwallet/preload/PreloadModule:getResList	()Ljava/util/List;
    //   63: invokeinterface 280 1 0
    //   68: astore_2
    //   69: aload_2
    //   70: invokeinterface 285 1 0
    //   75: ifeq +58 -> 133
    //   78: aload_2
    //   79: invokeinterface 289 1 0
    //   84: checkcast 395	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource
    //   87: astore_3
    //   88: aload_3
    //   89: getfield 868	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:type	I
    //   92: iconst_5
    //   93: if_icmpne -24 -> 69
    //   96: aload_3
    //   97: getfield 869	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:url	Ljava/lang/String;
    //   100: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +13 -> 116
    //   106: aload_3
    //   107: getfield 872	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:urlPath	Ljava/lang/String;
    //   110: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -44 -> 69
    //   116: aload_3
    //   117: aload_1
    //   118: invokevirtual 706	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getResDownloadUrl	(Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadModule;)Ljava/lang/String;
    //   121: aload_3
    //   122: invokevirtual 709	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getFilePos	()I
    //   125: invokestatic 712	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: areturn
    //   133: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc 73
    //   141: iconst_2
    //   142: ldc_w 874
    //   145: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -21 -> 129
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	PreloadManager
    //   0	158	1	paramString	String
    //   68	11	2	localIterator	Iterator
    //   87	35	3	localPreloadResource	PreloadResource
    // Exception table:
    //   from	to	target	type
    //   2	46	153	finally
    //   46	55	153	finally
    //   59	69	153	finally
    //   69	116	153	finally
    //   116	129	153	finally
    //   133	148	153	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    agmq localagmq = (agmq)this.jdField_a_of_type_MqqAppAppRuntime.getManager(245);
    if (localagmq != null) {
      localagmq.d("preload", this);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager
 * JD-Core Version:    0.7.0.1
 */