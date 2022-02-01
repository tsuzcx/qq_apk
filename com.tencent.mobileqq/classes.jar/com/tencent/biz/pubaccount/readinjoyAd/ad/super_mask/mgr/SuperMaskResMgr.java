package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr;", "", "()V", "TAG", "", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "lock", "getLock", "()Ljava/lang/Object;", "reqResList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "addNewRes", "", "data", "doInit", "findResDataFromLocal", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr$SuperMaskJson;", "adId", "adSource", "getLocalResList", "getReqLocalResList", "initLocalRes", "log", "msg", "removeInvalidRes", "SuperMaskJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskResMgr
{
  public static final SuperMaskResMgr a;
  @NotNull
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, MaterialData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr = new SuperMaskResMgr();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final void a(String paramString) {}
  
  private final ConcurrentHashMap<String, MaterialData> b()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = System.currentTimeMillis();
    Object localObject1 = AdMaterialResManager.a(RIJQQAppInterfaceUtil.a());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AdMaterialResManager.get…InterfaceUtil.getQQApp())");
    localObject1 = ((AdMaterialResManager)localObject1).a();
    if (((ConcurrentHashMap)localObject1).size() <= 0)
    {
      a("getLocalResList time cost : " + (System.currentTimeMillis() - l2));
      return localConcurrentHashMap;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "allDBData");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((Map.Entry)localObject2).getValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.value");
      if (SuperMaskExtKt.a((MaterialData)localObject3)) {
        if ((!TextUtils.isEmpty((CharSequence)((MaterialData)((Map.Entry)localObject2).getValue()).adid)) && (((MaterialData)((Map.Entry)localObject2).getValue()).end_time > l1))
        {
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getLocalResList : 符合条件 = " + ((MaterialData)((Map.Entry)localObject2).getValue()).id);
          localObject3 = (Map)localConcurrentHashMap;
          String str = ((MaterialData)((Map.Entry)localObject2).getValue()).adid;
          Intrinsics.checkExpressionValueIsNotNull(str, "it.value.adid");
          localObject2 = ((Map.Entry)localObject2).getValue();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.value");
          ((Map)localObject3).put(str, localObject2);
        }
      }
      for (;;)
      {
        break;
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getLocalResList：不符合条件,id:" + ((MaterialData)((Map.Entry)localObject2).getValue()).id + ",end_time:" + ((MaterialData)((Map.Entry)localObject2).getValue()).end_time + ",currentTime:" + l1);
        continue;
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getLocalResList,文件不存在，id:" + (String)((Map.Entry)localObject2).getKey());
      }
    }
    a("getLocalResList time cost : " + (System.currentTimeMillis() - l2));
    return localConcurrentHashMap;
  }
  
  private final void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.b();
      jdField_a_of_type_Boolean = true;
      QLog.d("ReadInJoySuperMaskAd", 1, "SuperMaskResMgr init finish");
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  @Nullable
  public final SuperMaskResMgr.SuperMaskJson a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return null;
      paramString1 = AdMaterialResManager.a(RIJQQAppInterfaceUtil.a()).a(paramString2 + "_" + paramString1);
      if (SuperMaskExtKt.c(paramString1)) {
        SuperMaskExtKt.a(paramString1);
      }
    } while (paramString1 == null);
    return new SuperMaskResMgr.SuperMaskJson(paramString1.toJson());
  }
  
  @NotNull
  public final ConcurrentHashMap<String, MaterialData> a()
  {
    if (jdField_a_of_type_Boolean) {}
    int i;
    for (ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;; localConcurrentHashMap = b())
    {
      i = AdMaterialResManager.b();
      if ((!localConcurrentHashMap.isEmpty()) && (localConcurrentHashMap.size() > i)) {
        break;
      }
      localObject1 = localConcurrentHashMap;
      return localObject1;
    }
    long l = NetConnInfoCenter.getServerTime();
    Object localObject3 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2 = ((Map)localConcurrentHashMap).entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        try
        {
          if (new File(AdMaterialResManager.a(((MaterialData)localEntry.getValue()).ad_source, ((MaterialData)localEntry.getValue()).adid, ((MaterialData)localEntry.getValue()).res_version)).exists()) {
            if (((MaterialData)localEntry.getValue()).start_time < l)
            {
              ((ArrayList)localObject3).add(localEntry.getValue());
              jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getReqLocalResList,startedResList.add:" + ((MaterialData)localEntry.getValue()).id);
            }
            else
            {
              ((ArrayList)localObject1).add(localEntry.getValue());
              jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getReqLocalResList,notStartResList.add:" + ((MaterialData)localEntry.getValue()).id);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getReqLocalResList，异常：" + QLog.getStackTraceString(localThrowable));
        }
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskResMgr.a("getReqLocalResList，文件不存在：" + ((MaterialData)localThrowable.getValue()).id);
      }
      else
      {
        localObject2 = new ConcurrentHashMap();
        Object localObject4 = (List)localObject3;
        if (((List)localObject4).size() > 1) {
          CollectionsKt.sortWith((List)localObject4, (Comparator)new SuperMaskResMgr.getReqLocalResList..inlined.sortByDescending.1());
        }
        localObject3 = ((ArrayList)localObject3).iterator();
        Map localMap;
        for (;;)
        {
          Object localObject5;
          if (((Iterator)localObject3).hasNext())
          {
            localObject5 = (MaterialData)((Iterator)localObject3).next();
            if (((ConcurrentHashMap)localObject2).size() < i) {}
          }
          else
          {
            if (((ConcurrentHashMap)localObject2).size() < i) {
              break;
            }
            a("getReqLocalResList,已经开始投放的素材已经填充满了maxReqCount:" + i);
            return localObject2;
          }
          localObject4 = (MaterialData)localConcurrentHashMap.get(((MaterialData)localObject5).adid);
          if (localObject4 != null)
          {
            localMap = (Map)localObject2;
            localObject5 = ((MaterialData)localObject5).adid;
            Intrinsics.checkExpressionValueIsNotNull(localObject5, "value.adid");
            localMap.put(localObject5, localObject4);
            a("getReqLocalResList,添加已开始投放广告：" + ((MaterialData)localObject4).id);
          }
          else
          {
            a("getReqLocalResList,result里已开始投放广告为空，adid：" + ((MaterialData)localObject5).adid);
          }
        }
        CollectionsKt.sortWith((List)localObject1, ComparisonsKt.compareBy(new Function1[] { (Function1)SuperMaskResMgr.getReqLocalResList.3.INSTANCE, (Function1)SuperMaskResMgr.getReqLocalResList.4.INSTANCE }));
        localObject3 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (MaterialData)((Iterator)localObject3).next();
          localObject1 = localObject2;
          if (((ConcurrentHashMap)localObject2).size() >= i) {
            break;
          }
          localObject1 = (MaterialData)localConcurrentHashMap.get(((MaterialData)localObject4).adid);
          if (localObject1 != null)
          {
            localMap = (Map)localObject2;
            localObject4 = ((MaterialData)localObject4).adid;
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "value.adid");
            localMap.put(localObject4, localObject1);
            a("getReqLocalResList,添加未投放广告：" + ((MaterialData)localObject1).id);
          }
          else
          {
            a("getReqLocalResList,result里未投放广告为空，adid：" + ((MaterialData)localObject4).adid);
          }
        }
      }
    }
  }
  
  public final void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      ThreadManagerV2.post((Runnable)SuperMaskResMgr.initLocalRes.1.a, 10, null, true);
      return;
    }
    b();
  }
  
  public final void a(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof MaterialData)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (MaterialData)paramObject;
      if ((paramObject != null) && (SuperMaskExtKt.a(paramObject)) && (!TextUtils.isEmpty((CharSequence)paramObject.adid)))
      {
        SuperMaskExtKt.a(paramObject, new ConcurrentHashMap());
        Map localMap = (Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        String str = paramObject.adid;
        Intrinsics.checkExpressionValueIsNotNull(str, "it.adid");
        localMap.put(str, paramObject);
      }
      return;
    }
  }
  
  public final void b(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof MaterialData)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (MaterialData)paramObject;
      if ((paramObject != null) && (!TextUtils.isEmpty((CharSequence)paramObject.adid))) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramObject.adid);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr
 * JD-Core Version:    0.7.0.1
 */