package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager;
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
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.util.CollectionUtil;
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
  
  public static AdMaterialResManager a(QQAppInterface paramQQAppInterface)
  {
    return (AdMaterialResManager)paramQQAppInterface.getManager(QQManagerFactory.READINJOY_AD_MATERIAL_MANAGER);
  }
  
  private String a(MaterialData paramMaterialData)
  {
    int i = paramMaterialData.res_version;
    String str1 = paramMaterialData.res_path;
    String str2 = File.separator + i;
    paramMaterialData = str1;
    if (str1 != null)
    {
      paramMaterialData = str1;
      if (str1.endsWith(str2))
      {
        paramMaterialData = str1.substring(0, str1.length() - str2.length());
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "getRootDirectory = " + paramMaterialData);
      }
    }
    return paramMaterialData;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str2 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/resource/");
    String str1 = str2;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      str1 = str2 + jdField_a_of_type_JavaLangString + "/";
    }
    return str1 + paramString1 + "_" + paramString2 + "/" + paramInt;
  }
  
  private List<MaterialData> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class);
    if (CollectionUtil.isEmpty((Collection)localObject)) {
      return new ArrayList();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("localData = [ ");
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject).next();
      if ((localEntity instanceof MaterialData))
      {
        localArrayList.add((MaterialData)localEntity);
        localStringBuilder.append(((MaterialData)localEntity).id).append(" , ");
      }
    }
    localStringBuilder.append(" ] ");
    return localArrayList;
  }
  
  private List<MaterialData> a(Set<MaterialData> paramSet, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)paramSet.next();
      if (localMaterialData != null) {
        if (localMaterialData.end_time < paramLong) {
          c("filterMaterialData , 过滤已过期的广告: " + localMaterialData.id);
        } else if (localMaterialData.start_time < paramLong) {
          localArrayList1.add(localMaterialData);
        } else {
          localArrayList2.add(localMaterialData);
        }
      }
    }
    int j = a();
    int i = localArrayList1.size() + localArrayList2.size();
    if (i <= j)
    {
      c("filterMaterialData , 有效的广告数(" + i + ") 不足maxCacheCount : " + j);
      localArrayList1.addAll(localArrayList2);
      return localArrayList1;
    }
    if (localArrayList1.size() < j)
    {
      Collections.sort(localArrayList2, new AdMaterialResManager.4(this));
      int k = localArrayList1.size();
      i = 0;
      while ((i < j - k) && (i < localArrayList2.size()))
      {
        localArrayList1.add(localArrayList2.get(i));
        i += 1;
      }
      return localArrayList1;
    }
    Collections.sort(localArrayList1, new AdMaterialResManager.5(this));
    i = j;
    while (i < localArrayList1.size())
    {
      paramSet = (MaterialData)localArrayList1.get(i);
      c("filterMaterialData , 删除超过最大数目的广告: " + paramSet.id + " start_time = " + paramSet.start_time);
      b(paramSet);
      i += 1;
    }
    return localArrayList1.subList(0, j);
  }
  
  private List<MaterialData> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      Object localObject = "uin=? and end_time>? and isReady=?";
      String[] arrayOfString = new String[3];
      arrayOfString[0] = str;
      arrayOfString[1] = String.valueOf(l);
      arrayOfString[2] = String.valueOf(0);
      if (paramBoolean)
      {
        localObject = "uin=? and end_time>? and isReady=? and enable_4g=?";
        arrayOfString = new String[4];
        arrayOfString[0] = str;
        arrayOfString[1] = String.valueOf(l);
        arrayOfString[2] = String.valueOf(0);
        arrayOfString[3] = String.valueOf(1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, (String)localObject, arrayOfString, null, null, null, null);
      return localObject;
    }
    catch (Exception localException)
    {
      c("getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
    }
    return localArrayList;
  }
  
  private Set<MaterialData> a(List<MaterialData> paramList1, List<MaterialData> paramList2)
  {
    if ((CollectionUtil.isEmpty(paramList1)) && (CollectionUtil.isEmpty(paramList2))) {
      return new HashSet();
    }
    if (CollectionUtil.isEmpty(paramList1)) {
      return new HashSet(paramList2);
    }
    if (CollectionUtil.isEmpty(paramList2)) {
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
    for (;;)
    {
      Object localObject;
      try
      {
        long l = NetConnInfoCenter.getServerTime();
        if ((paramList == null) || (paramList.size() <= 0))
        {
          c("checkAndRefresh, 网络回包为空");
          return;
        }
        localObject = a();
        paramList = a(a((List)localObject, paramList), l);
        if (CollectionUtil.isEmpty(paramList))
        {
          c("checkAndRefresh, 过滤后无有效广告");
          continue;
        }
        localIterator = ((List)localObject).iterator();
      }
      finally {}
      MaterialData localMaterialData1;
      while (localIterator.hasNext())
      {
        localMaterialData1 = (MaterialData)localIterator.next();
        if (!paramList.contains(localMaterialData1))
        {
          b(localMaterialData1);
          SuperMaskResMgr.a.b(localMaterialData1);
          c("checkAndRefresh, 删除被过滤掉的本地数据: " + localMaterialData1.id);
        }
      }
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        localMaterialData1 = (MaterialData)localIterator.next();
        if (((List)localObject).contains(localMaterialData1))
        {
          MaterialData localMaterialData2 = (MaterialData)((List)localObject).get(((List)localObject).indexOf(localMaterialData1));
          localMaterialData1.res_path = localMaterialData2.res_path;
          localMaterialData1.setStatus(localMaterialData2.getStatus());
          localMaterialData1.isReady = localMaterialData2.isReady;
          localMaterialData1.animFileName = localMaterialData2.animFileName;
          localMaterialData1.superMaskType = localMaterialData2.superMaskType;
          localMaterialData1.setId(localMaterialData2.getId());
          if (localMaterialData1.res_version != localMaterialData2.res_version)
          {
            c("checkAndRefresh, 删除旧版本资源: " + localMaterialData1.id);
            FileUtils.a(a(localMaterialData2));
            localMaterialData1.isReady = false;
            localMaterialData1.setStatus(1000);
          }
        }
        for (;;)
        {
          d(localMaterialData1);
          break;
          localMaterialData1.setStatus(1000);
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (MaterialData)paramList.next();
        if (a((MaterialData)localObject)) {
          c("checkAndRefresh, 跳过素材已下载且校验通过的广告: " + ((MaterialData)localObject).id);
        } else {
          c((MaterialData)localObject);
        }
      }
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
  
  public static int b()
  {
    return Aladdin.getConfig(398).getIntegerFromString("ad_max_req_count", 10);
  }
  
  private void b(MaterialData paramMaterialData)
  {
    SuperMaskResMgr.a.b(paramMaterialData);
    f(paramMaterialData);
    FileUtils.a(a(paramMaterialData));
  }
  
  private void b(DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile)
  {
    if ((paramDownloadTask == null) || (paramMaterialData == null))
    {
      FileUtils.a(paramFile);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(jdField_a_of_type_JavaLangString + "_" + paramMaterialData.id);
    if (paramDownloadTask.a != 0)
    {
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "downloadFail", paramMaterialData.res_version);
      FileUtils.a(paramFile);
      return;
    }
    SuperMaskReportMgr.a.a(paramMaterialData.adid, "downloadSuccess", paramMaterialData.res_version);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "noFile", paramMaterialData.res_version);
      return;
    }
    if (!a(paramMaterialData, paramFile))
    {
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "md5Fail", paramMaterialData.res_version);
      FileUtils.a(paramFile);
      return;
    }
    paramMaterialData.res_path = a(paramMaterialData.ad_source, paramMaterialData.adid, paramMaterialData.res_version);
    try
    {
      FileUtils.a(paramFile.getAbsolutePath(), paramMaterialData.res_path, false);
      SuperMaskReportMgr.a.a(paramMaterialData.adid, "zipSuccess", paramMaterialData.res_version);
      if (b(paramMaterialData))
      {
        paramMaterialData.isReady = true;
        paramMaterialData.setStatus(1001);
        SuperMaskReportMgr.a.a(paramMaterialData.adid, "AllSuccess", paramMaterialData.res_version);
        SuperMaskResMgr.a.a(paramMaterialData);
        g(paramMaterialData);
        FileUtils.a(paramFile);
        return;
      }
    }
    catch (IOException paramDownloadTask)
    {
      for (;;)
      {
        SuperMaskReportMgr.a.a(paramMaterialData.adid, "zipFail", paramMaterialData.res_version);
        paramDownloadTask.printStackTrace();
        continue;
        FileUtils.a(a(paramMaterialData));
      }
    }
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
    JSONObject localJSONObject = paramMaterialData.toJson();
    Object localObject = new ResCheckStep(localJSONObject, new ResCheckStep.AdResCheckInfo(paramMaterialData.adid, paramMaterialData.ad_source, paramMaterialData.res_version), false, 1);
    boolean bool = SuperMaskStepUtil.a.a("[PRELOAD]", new SuperMaskStep[] { localObject });
    localObject = localJSONObject.optString("animFileName");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMaterialData.animFileName = ((String)localObject);
      c(" : checkFinalResFile, id = " + paramMaterialData.id + " result = " + bool + " fileName = " + (String)localObject);
    }
    paramMaterialData.superMaskType = localJSONObject.optInt("superMaskType");
    return bool;
  }
  
  private void c(MaterialData paramMaterialData)
  {
    if (paramMaterialData.end_time <= NetConnInfoCenter.getServerTime()) {}
    while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    if (NetworkUtil.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()))
    {
      c("download wifi : id = " + paramMaterialData.id);
      a(jdField_a_of_type_JavaLangString, paramMaterialData, 2);
      return;
    }
    if ((AdDeviceInfoUtil.a() == 4) && (paramMaterialData.enable_4g == 1))
    {
      c("download by 4G : id = " + paramMaterialData.adid);
      ThreadManager.getSubThreadHandler().postDelayed(new AdMaterialResManager.6(this, paramMaterialData), 10000L);
      return;
    }
    c("download fail , netType = " + AdDeviceInfoUtil.a() + " enable_4g = " + paramMaterialData.enable_4g);
  }
  
  private static void c(String paramString)
  {
    QLog.d("ReadInJoySuperMaskAd", 1, "[PRELOAD]" + paramString);
  }
  
  private void d(MaterialData paramMaterialData)
  {
    boolean bool = false;
    if (paramMaterialData.getStatus() == 1000)
    {
      e(paramMaterialData);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramMaterialData);
      if (paramMaterialData.getStatus() != 1001) {}
    }
    for (bool = true;; bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData)) {
      do
      {
        c(" : persistOrReplaceToDB, id = " + paramMaterialData.id + " result = " + bool);
        return;
      } while ((paramMaterialData.getStatus() != 1001) && (paramMaterialData.getStatus() != 1002));
    }
  }
  
  private void e(MaterialData paramMaterialData)
  {
    Entity localEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(MaterialData.class, "id = ?", new String[] { paramMaterialData.id });
    if (localEntity != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localEntity);
      c(" : removeEntityIfExistsInDB, id = " + paramMaterialData.id + " result = " + bool);
    }
  }
  
  private void f(MaterialData paramMaterialData)
  {
    paramMaterialData.setStatus(1001);
    int i = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(MaterialData.class.getSimpleName(), "id=? ", new String[] { paramMaterialData.id });
    c(" : deleteToDB, id = " + paramMaterialData.id + " result = " + i);
  }
  
  private void g(MaterialData paramMaterialData)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData);
    c(" : updateToDB , id = " + paramMaterialData.id + "result = " + bool);
  }
  
  public MaterialData a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "id=?", new String[] { paramString }, null, null, null, null);
    paramString = localObject1;
    if (localObject2 != null)
    {
      paramString = localObject1;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = (Entity)((List)localObject2).get(0);
        paramString = localObject1;
        if ((localObject2 instanceof MaterialData)) {
          paramString = (MaterialData)localObject2;
        }
      }
    }
    return paramString;
  }
  
  public ConcurrentHashMap<String, MaterialData> a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (CollectionUtil.isEmpty(localList)) {
      return localConcurrentHashMap;
    }
    int i = 0;
    while (i < localList.size())
    {
      Entity localEntity = (Entity)localList.get(i);
      if ((localEntity instanceof MaterialData)) {
        localConcurrentHashMap.put(((MaterialData)localEntity).id, (MaterialData)localEntity);
      }
      i += 1;
    }
    return localConcurrentHashMap;
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
      ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.7(this, paramDownloadTask, paramMaterialData, paramFile));
      return;
    }
    b(paramDownloadTask, paramMaterialData, paramFile);
  }
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void b()
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
  
  public void b(String paramString, BaseResData paramBaseResData) {}
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void c()
  {
    a(true);
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    a(false);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadNetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadNetInfoHandler);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager
 * JD-Core Version:    0.7.0.1
 */