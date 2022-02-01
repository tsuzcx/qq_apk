package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.ResNetChangeInterface;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskPreloadMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.DownloadMd5CheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep.AdResCheckInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskStepUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoySkinUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyBaseResManager;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AdMaterialResManager
  extends ReadInJoyBaseResManager
  implements ResNetChangeInterface
{
  private static String jdField_a_of_type_JavaLangString = "adMaterial";
  private AdMaterialObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver = new AdMaterialResManager.1(this);
  private NetInfoHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadNetInfoHandler;
  
  public AdMaterialResManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static int a()
  {
    return Aladdin.getConfig(398).getIntegerFromString("ad_max_cache_count", 40);
  }
  
  public static AdMaterialResManager a(AppRuntime paramAppRuntime)
  {
    return (AdMaterialResManager)paramAppRuntime.getManager(QQManagerFactory.READINJOY_AD_MATERIAL_MANAGER);
  }
  
  private DownloadListener a(String paramString1, BaseResData paramBaseResData, String paramString2)
  {
    return new AdMaterialResManager.6(this, paramBaseResData, paramString2, paramString1);
  }
  
  private String a(MaterialData paramMaterialData)
  {
    Object localObject;
    if (paramMaterialData.bid_mask == 1) {
      localObject = a(paramMaterialData.ad_source, paramMaterialData.adid, paramMaterialData.res_version);
    } else {
      localObject = paramMaterialData.res_path;
    }
    int i = paramMaterialData.res_version;
    paramMaterialData = new StringBuilder();
    paramMaterialData.append(File.separator);
    paramMaterialData.append(i);
    paramMaterialData = paramMaterialData.toString();
    if ((localObject != null) && (((String)localObject).endsWith(paramMaterialData)))
    {
      paramMaterialData = ((String)localObject).substring(0, ((String)localObject).length() - paramMaterialData.length());
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRootDirectory = ");
      localStringBuilder.append(paramMaterialData);
      ((IRIJAdLogService)localObject).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
      return paramMaterialData;
    }
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append(".readInjoy/resource/");
    Object localObject2 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(paramInt);
    return ((StringBuilder)localObject2).toString();
  }
  
  private List<MaterialData> a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class);
    if (b((Collection)localObject1)) {
      return new ArrayList();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("localData = [ ");
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Entity)((Iterator)localObject1).next();
      if ((localObject2 instanceof MaterialData))
      {
        localObject2 = (MaterialData)localObject2;
        localArrayList.add(localObject2);
        localStringBuilder.append(((MaterialData)localObject2).id);
        localStringBuilder.append(" , ");
      }
    }
    localStringBuilder.append(" ] ");
    return localArrayList;
  }
  
  private List<MaterialData> a(Set<MaterialData> paramSet, long paramLong)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = new HashSet();
    paramSet = paramSet.iterator();
    MaterialData localMaterialData;
    while (paramSet.hasNext())
    {
      localMaterialData = (MaterialData)paramSet.next();
      if (localMaterialData.bid_mask == 1) {
        ((Set)localObject).add(localMaterialData);
      } else {
        localHashSet.add(localMaterialData);
      }
    }
    paramSet = b(localHashSet, paramLong);
    localObject = b((Set)localObject, paramLong);
    if (localHashSet.size() >= a()) {
      return paramSet;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localMaterialData = (MaterialData)((Iterator)localObject).next();
      if (localHashSet.size() >= a()) {
        return paramSet;
      }
      paramSet.add(localMaterialData);
    }
    return paramSet;
  }
  
  private List<MaterialData> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      Object localObject1 = "uin=? and end_time>? and isReady=?";
      localObject2 = new String[3];
      localObject2[0] = str;
      localObject2[1] = String.valueOf(l);
      localObject2[2] = String.valueOf(0);
      if (paramBoolean)
      {
        localObject1 = "uin=? and end_time>? and isReady=? and enable_4g=?";
        localObject2 = new String[4];
        localObject2[0] = str;
        localObject2[1] = String.valueOf(l);
        localObject2[2] = String.valueOf(0);
        localObject2[3] = String.valueOf(1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, (String)localObject1, (String[])localObject2, null, null, null, null);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getMaterialDataList query  failed ");
      ((StringBuilder)localObject2).append(QLog.getStackTraceString(localException));
      c(((StringBuilder)localObject2).toString());
    }
    return localArrayList;
  }
  
  private Set<MaterialData> a(List<MaterialData> paramList1, List<MaterialData> paramList2)
  {
    if ((b(paramList1)) && (b(paramList2))) {
      return new HashSet();
    }
    if (b(paramList1)) {
      return new HashSet(paramList2);
    }
    if (b(paramList2)) {
      return new HashSet(paramList1);
    }
    paramList2 = new HashSet(paramList2);
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SuperMaskResMgr.a.a();
    SuperMaskPreloadMgr.a.a();
  }
  
  private void a(List<MaterialData> paramList)
  {
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      if ((paramList != null) && (paramList.size() > 0))
      {
        Object localObject1 = a();
        paramList = a(a((List)localObject1, paramList), l);
        if (b(paramList))
        {
          c("checkAndRefresh, 过滤后无有效广告");
          return;
        }
        Object localObject2 = ((List)localObject1).iterator();
        MaterialData localMaterialData;
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localMaterialData = (MaterialData)((Iterator)localObject2).next();
          if (!paramList.contains(localMaterialData))
          {
            b(localMaterialData);
            SuperMaskResMgr.a.b(localMaterialData);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkAndRefresh, 删除被过滤掉的本地数据: ");
            ((StringBuilder)localObject3).append(localMaterialData.id);
            c(((StringBuilder)localObject3).toString());
          }
        }
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localMaterialData = (MaterialData)((Iterator)localObject2).next();
          if (((List)localObject1).contains(localMaterialData))
          {
            localObject3 = (MaterialData)((List)localObject1).get(((List)localObject1).indexOf(localMaterialData));
            localMaterialData.res_path = ((MaterialData)localObject3).res_path;
            localMaterialData.setStatus(((MaterialData)localObject3).getStatus());
            localMaterialData.isReady = ((MaterialData)localObject3).isReady;
            localMaterialData.animFileName = ((MaterialData)localObject3).animFileName;
            localMaterialData.superMaskType = ((MaterialData)localObject3).superMaskType;
            localMaterialData.setId(((MaterialData)localObject3).getId());
            if (localMaterialData.res_version != ((MaterialData)localObject3).res_version)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkAndRefresh, 删除旧版本资源: ");
              localStringBuilder.append(localMaterialData.id);
              c(localStringBuilder.toString());
              FileUtils.deleteDirectory(a((MaterialData)localObject3));
              localMaterialData.isReady = false;
              localMaterialData.setStatus(1000);
            }
          }
          else
          {
            localMaterialData.setStatus(1000);
          }
          d(localMaterialData);
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (MaterialData)paramList.next();
          if (a((MaterialData)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkAndRefresh, 跳过素材已下载且校验通过的广告: ");
            ((StringBuilder)localObject2).append(((MaterialData)localObject1).id);
            c(((StringBuilder)localObject2).toString());
          }
          else
          {
            c((MaterialData)localObject1);
          }
        }
        return;
      }
      c("checkAndRefresh, 网络回包为空");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.2(this, paramBoolean));
  }
  
  private boolean a(MaterialData paramMaterialData)
  {
    return (paramMaterialData.isReady) && (SuperMaskExtKt.a(paramMaterialData)) && (SuperMaskExtKt.b(paramMaterialData));
  }
  
  private boolean a(MaterialData paramMaterialData, File paramFile)
  {
    paramMaterialData = new DownloadMd5CheckStep(paramMaterialData, paramFile);
    return SuperMaskStepUtil.a.a("[PRELOAD]", new SuperMaskStep[] { paramMaterialData });
  }
  
  private boolean a(BaseResData paramBaseResData, DownloadTask paramDownloadTask, String paramString)
  {
    if (((paramBaseResData instanceof MaterialData)) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime() != null))
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResDownloadDone(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), paramDownloadTask, (MaterialData)paramBaseResData, new File(paramString));
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2, BaseResData paramBaseResData, String paramString3, DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: new 94	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 442	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 449	java/io/File:exists	()Z
    //   13: istore 7
    //   15: iconst_0
    //   16: istore 6
    //   18: iload 7
    //   20: ifeq +107 -> 127
    //   23: aload_1
    //   24: invokevirtual 452	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 454	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 458	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 58	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   41: invokevirtual 462	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 465	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/biz/skin/entity/BaseResData;)V
    //   50: aload_1
    //   51: invokevirtual 468	java/io/File:delete	()Z
    //   54: pop
    //   55: iload 6
    //   57: ireturn
    //   58: astore_2
    //   59: goto +61 -> 120
    //   62: astore_2
    //   63: new 90	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc_w 470
    //   75: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: aload 4
    //   82: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: ldc_w 472
    //   90: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: aload_2
    //   96: invokestatic 277	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   99: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc_w 474
    //   106: iconst_2
    //   107: aload_3
    //   108: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iconst_1
    //   115: istore 6
    //   117: goto -67 -> 50
    //   120: aload_1
    //   121: invokevirtual 468	java/io/File:delete	()Z
    //   124: pop
    //   125: aload_2
    //   126: athrow
    //   127: aload_0
    //   128: aload_2
    //   129: aload 4
    //   131: invokevirtual 480	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 484	com/tencent/mobileqq/utils/FileUtils:createDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   137: pop
    //   138: aload_0
    //   139: getfield 487	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   142: aload 5
    //   144: getfield 490	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokevirtual 495	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 109	java/lang/String
    //   153: invokestatic 498	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   156: ifeq +198 -> 354
    //   159: aload_0
    //   160: getfield 487	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   163: aload 5
    //   165: getfield 490	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokevirtual 495	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 109	java/lang/String
    //   174: aload_0
    //   175: aload_2
    //   176: aload 4
    //   178: invokevirtual 480	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: iconst_0
    //   182: invokestatic 502	com/tencent/mobileqq/utils/FileUtils:copyDirectory	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   185: pop
    //   186: new 90	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   193: astore_1
    //   194: aload_1
    //   195: ldc_w 504
    //   198: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_1
    //   203: aload_0
    //   204: getfield 487	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   207: aload 5
    //   209: getfield 490	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   212: invokevirtual 495	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   215: checkcast 109	java/lang/String
    //   218: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_1
    //   223: ldc_w 506
    //   226: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: aload_0
    //   232: aload_2
    //   233: aload 4
    //   235: invokevirtual 480	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   238: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc_w 474
    //   245: iconst_2
    //   246: aload_1
    //   247: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_1
    //   256: aload_0
    //   257: getfield 167	com/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/AdMaterialResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   260: astore_3
    //   261: new 90	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   268: astore 5
    //   270: aload 5
    //   272: aload_2
    //   273: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 5
    //   279: ldc 159
    //   281: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 5
    //   287: aload 4
    //   289: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_3
    //   294: aload 5
    //   296: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 511	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: pop
    //   303: new 90	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   310: astore_2
    //   311: aload_2
    //   312: ldc_w 513
    //   315: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_2
    //   320: aload 4
    //   322: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 472
    //   330: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload_1
    //   336: invokestatic 277	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   339: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: ldc_w 474
    //   346: iconst_2
    //   347: aload_2
    //   348: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	AdMaterialResManager
    //   0	356	1	paramString1	String
    //   0	356	2	paramString2	String
    //   0	356	3	paramBaseResData	BaseResData
    //   0	356	4	paramString3	String
    //   0	356	5	paramDownloadTask	DownloadTask
    //   16	100	6	bool1	boolean
    //   13	6	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   23	50	58	finally
    //   63	114	58	finally
    //   23	50	62	java/lang/Exception
    //   127	253	255	java/lang/Exception
  }
  
  public static int b()
  {
    return Aladdin.getConfig(398).getIntegerFromString("ad_max_req_count", 10);
  }
  
  private List<MaterialData> b(Set<MaterialData> paramSet, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)paramSet.next();
      if (localMaterialData != null)
      {
        if ((localMaterialData.bid_mask == 1) && (localMaterialData.end_time == 0L)) {
          localMaterialData.end_time = (604800L + paramLong);
        }
        if (localMaterialData.end_time < paramLong)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("filterMaterialData , 过滤已过期的广告: ");
          localStringBuilder.append(localMaterialData.id);
          c(localStringBuilder.toString());
        }
        else if (localMaterialData.start_time < paramLong)
        {
          localArrayList.add(localMaterialData);
        }
        else
        {
          ((List)localObject).add(localMaterialData);
        }
      }
    }
    int j = a();
    int i = localArrayList.size() + ((List)localObject).size();
    if (i <= j)
    {
      paramSet = new StringBuilder();
      paramSet.append("filterMaterialData , 有效的广告数(");
      paramSet.append(i);
      paramSet.append(") 不足maxCacheCount : ");
      paramSet.append(j);
      c(paramSet.toString());
      localArrayList.addAll((Collection)localObject);
      return localArrayList;
    }
    int k = localArrayList.size();
    i = 0;
    if (k < j)
    {
      Collections.sort((List)localObject, new AdMaterialResManager.4(this));
      k = localArrayList.size();
      while ((i < j - k) && (i < ((List)localObject).size()))
      {
        localArrayList.add(((List)localObject).get(i));
        i += 1;
      }
      return localArrayList;
    }
    Collections.sort(localArrayList, new AdMaterialResManager.5(this));
    i = j;
    while (i < localArrayList.size())
    {
      paramSet = (MaterialData)localArrayList.get(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("filterMaterialData , 删除超过最大数目的广告: ");
      ((StringBuilder)localObject).append(paramSet.id);
      ((StringBuilder)localObject).append(" start_time = ");
      ((StringBuilder)localObject).append(paramSet.start_time);
      c(((StringBuilder)localObject).toString());
      b(paramSet);
      i += 1;
    }
    return localArrayList.subList(0, j);
  }
  
  private void b(MaterialData paramMaterialData)
  {
    SuperMaskResMgr.a.b(paramMaterialData);
    f(paramMaterialData);
    FileUtils.deleteDirectory(a(paramMaterialData));
  }
  
  private void b(DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile)
  {
    if ((paramDownloadTask != null) && (paramMaterialData != null))
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramMaterialData.id);
      localHashMap.remove(localStringBuilder.toString());
      if (paramDownloadTask.jdField_a_of_type_Int != 0)
      {
        SuperMaskReportMgr.a.a(paramMaterialData.adid, "downloadFail", paramMaterialData.res_version);
        FileUtils.deleteFile(paramFile);
        return;
      }
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "downloadSuccess", paramMaterialData.res_version);
      if ((paramFile != null) && (paramFile.exists()))
      {
        if (!a(paramMaterialData, paramFile))
        {
          SuperMaskReportMgr.a.a(paramMaterialData.adid, "md5Fail", paramMaterialData.res_version);
          FileUtils.deleteFile(paramFile);
          return;
        }
        paramMaterialData.res_path = a(paramMaterialData.ad_source, paramMaterialData.adid, paramMaterialData.res_version);
        try
        {
          if (paramMaterialData.bid_mask == 1)
          {
            if (paramMaterialData.url.lastIndexOf(".") == -1) {
              return;
            }
            paramDownloadTask = new StringBuilder();
            paramDownloadTask.append(paramMaterialData.res_path);
            paramDownloadTask.append("/bid_mask.jpg");
            paramDownloadTask = new File(paramDownloadTask.toString());
            if (!paramDownloadTask.exists()) {
              FileUtils.copyFile(paramFile, paramDownloadTask);
            }
            paramMaterialData.res_path = paramDownloadTask.getAbsolutePath();
          }
          else
          {
            FileUtils.uncompressZip(paramFile.getAbsolutePath(), paramMaterialData.res_path, false);
          }
          SuperMaskReportMgr.a.a(paramMaterialData.adid, "zipSuccess", paramMaterialData.res_version);
        }
        catch (IOException paramDownloadTask)
        {
          SuperMaskReportMgr.a.a(paramMaterialData.adid, "zipFail", paramMaterialData.res_version);
          paramDownloadTask.printStackTrace();
        }
        if (b(paramMaterialData))
        {
          paramMaterialData.isReady = true;
          paramMaterialData.setStatus(1001);
          SuperMaskReportMgr.a.a(paramMaterialData.adid, "AllSuccess", paramMaterialData.res_version);
          SuperMaskResMgr.a.a(paramMaterialData);
          g(paramMaterialData);
        }
        else
        {
          FileUtils.deleteDirectory(a(paramMaterialData));
        }
        FileUtils.deleteFile(paramFile);
        return;
      }
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "noFile", paramMaterialData.res_version);
      return;
    }
    FileUtils.deleteFile(paramFile);
  }
  
  private void b(String paramString)
  {
    ThreadManagerV2.excute(new AdMaterialResManager.3(this, paramString), 64, null, true);
  }
  
  private boolean b(MaterialData paramMaterialData)
  {
    if (paramMaterialData == null) {
      return false;
    }
    if (paramMaterialData.bid_mask == 1) {
      return true;
    }
    JSONObject localJSONObject = paramMaterialData.toJson();
    Object localObject = new ResCheckStep(localJSONObject, new ResCheckStep.AdResCheckInfo(paramMaterialData.adid, paramMaterialData.ad_source, paramMaterialData.res_version), false, 1);
    boolean bool = SuperMaskStepUtil.a.a("[PRELOAD]", new SuperMaskStep[] { localObject });
    localObject = localJSONObject.optString("animFileName");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMaterialData.animFileName = ((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" : checkFinalResFile, id = ");
      localStringBuilder.append(paramMaterialData.id);
      localStringBuilder.append(" result = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" fileName = ");
      localStringBuilder.append((String)localObject);
      c(localStringBuilder.toString());
    }
    paramMaterialData.superMaskType = localJSONObject.optInt("superMaskType");
    return bool;
  }
  
  private static <T> boolean b(Collection<T> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  private void c(MaterialData paramMaterialData)
  {
    if (paramMaterialData.end_time <= NetConnInfoCenter.getServerTime()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download wifi : id = ");
      localStringBuilder.append(paramMaterialData.id);
      c(localStringBuilder.toString());
      a(jdField_a_of_type_JavaLangString, paramMaterialData, 2);
      return;
    }
    if ((AdDeviceInfoUtil.a() == 4) && (paramMaterialData.enable_4g == 1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download by 4G : id = ");
      localStringBuilder.append(paramMaterialData.adid);
      c(localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().postDelayed(new AdMaterialResManager.7(this, paramMaterialData), 10000L);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download fail , netType = ");
    localStringBuilder.append(AdDeviceInfoUtil.a());
    localStringBuilder.append(" enable_4g = ");
    localStringBuilder.append(paramMaterialData.enable_4g);
    c(localStringBuilder.toString());
  }
  
  private static void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[PRELOAD]");
    localStringBuilder.append(paramString);
    QLog.d("ReadInJoySuperMaskAd", 1, localStringBuilder.toString());
  }
  
  private void d(MaterialData paramMaterialData)
  {
    int i = paramMaterialData.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      e(paramMaterialData);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramMaterialData);
      if (paramMaterialData.getStatus() == 1001) {
        bool = true;
      }
    }
    else if ((paramMaterialData.getStatus() == 1001) || (paramMaterialData.getStatus() == 1002))
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" : persistOrReplaceToDB, id = ");
    localStringBuilder.append(paramMaterialData.id);
    localStringBuilder.append(" result = ");
    localStringBuilder.append(bool);
    c(localStringBuilder.toString());
  }
  
  private void e(MaterialData paramMaterialData)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(MaterialData.class, "id = ?", new String[] { paramMaterialData.id });
    if (localObject != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" : removeEntityIfExistsInDB, id = ");
      ((StringBuilder)localObject).append(paramMaterialData.id);
      ((StringBuilder)localObject).append(" result = ");
      ((StringBuilder)localObject).append(bool);
      c(((StringBuilder)localObject).toString());
    }
  }
  
  private void f(MaterialData paramMaterialData)
  {
    paramMaterialData.setStatus(1001);
    int i = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(MaterialData.class.getSimpleName(), "id=? ", new String[] { paramMaterialData.id });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" : deleteToDB, id = ");
    localStringBuilder.append(paramMaterialData.id);
    localStringBuilder.append(" result = ");
    localStringBuilder.append(i);
    c(localStringBuilder.toString());
  }
  
  private void g(MaterialData paramMaterialData)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" : updateToDB , id = ");
    localStringBuilder.append(paramMaterialData.id);
    localStringBuilder.append("result = ");
    localStringBuilder.append(bool);
    c(localStringBuilder.toString());
  }
  
  public MaterialData a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "id=?", new String[] { paramString }, null, null, null, null);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = (Entity)paramString.get(0);
      if ((paramString instanceof MaterialData)) {
        return (MaterialData)paramString;
      }
    }
    return null;
  }
  
  public ConcurrentHashMap<String, MaterialData> a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (b(localList)) {
      return localConcurrentHashMap;
    }
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = (Entity)localList.get(i);
      if ((localObject instanceof MaterialData))
      {
        localObject = (MaterialData)localObject;
        localConcurrentHashMap.put(((MaterialData)localObject).id, localObject);
      }
      i += 1;
    }
    return localConcurrentHashMap;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver != null)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadNetInfoHandler = new NetInfoHandler(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadNetInfoHandler);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(MaterialData paramMaterialData)
  {
    if (paramMaterialData != null) {
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "startDownload", paramMaterialData.res_version);
    }
  }
  
  public void a(DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.8(this, paramDownloadTask, paramMaterialData, paramFile));
      return;
    }
    b(paramDownloadTask, paramMaterialData, paramFile);
  }
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    Object localObject1 = paramBaseResData.id;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downloadGuide: id = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("AdMaterialResManager", 2, ((StringBuilder)localObject2).toString());
    localObject2 = a(paramString, (String)localObject1);
    if (ReadInJoySkinUtils.a(new File((String)localObject2)))
    {
      QLog.d("readinjoy", 2, "isAnimationPackageValid");
      return true;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append((String)localObject1);
    if (((HashMap)localObject3).get(((StringBuilder)localObject4).toString()) != null)
    {
      QLog.d("readinjoy", 2, "mDownloadingRes _");
      return false;
    }
    if (!(paramBaseResData instanceof MaterialData)) {
      FileUtils.deleteDirectory((String)localObject2);
    }
    localObject3 = this.jdField_a_of_type_JavaUtilHashMap;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((HashMap)localObject3).put(((StringBuilder)localObject4).toString(), paramBaseResData.url);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(".zip");
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject4 = new File((String)localObject2);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("resId", (String)localObject1);
    ((Bundle)localObject3).putString("prefix", paramString);
    localObject1 = new DownloadTask(paramBaseResData.url, (File)localObject4);
    ((DownloadTask)localObject1).b = paramInt;
    ((DownloadTask)localObject1).d = 60L;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.startDownload((DownloadTask)localObject1, a(paramString, paramBaseResData, (String)localObject2), (Bundle)localObject3);
    QLog.d("readinjoy", 2, "startDownload");
    return false;
  }
  
  public void b()
  {
    a(true);
  }
  
  public void b(String paramString, BaseResData paramBaseResData) {}
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void c()
  {
    a(false);
  }
  
  public void d()
  {
    a(false);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver);
    }
    NetInfoHandler localNetInfoHandler = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadNetInfoHandler;
    if (localNetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(localNetInfoHandler);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager
 * JD-Core Version:    0.7.0.1
 */