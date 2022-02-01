package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
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
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr;", "", "()V", "TAG", "", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "lock", "getLock", "()Ljava/lang/Object;", "reqResList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "addNewRes", "", "data", "doInit", "findResDataFromLocal", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr$SuperMaskJson;", "adId", "adSource", "getLocalResList", "getReqLocalResList", "result", "initLocalRes", "log", "msg", "removeInvalidRes", "SuperMaskJson", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskResMgr
{
  public static final SuperMaskResMgr a = new SuperMaskResMgr();
  private static volatile boolean b;
  private static ConcurrentHashMap<String, MaterialData> c = new ConcurrentHashMap();
  @NotNull
  private static final Object d = new Object();
  
  private final ConcurrentHashMap<String, MaterialData> a(ConcurrentHashMap<String, MaterialData> paramConcurrentHashMap)
  {
    Object localObject1 = QRoute.api(IRIJSuperMaskService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IRIJSuperMaskService::class.java)");
    int i = ((IRIJSuperMaskService)localObject1).getMaxReqCount();
    if (paramConcurrentHashMap.isEmpty()) {
      return paramConcurrentHashMap;
    }
    long l = NetConnInfoCenter.getServerTime();
    Object localObject3 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject2 = ((Map)paramConcurrentHashMap).entrySet().iterator();
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      try
      {
        if (new File(((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).obtainResPath(((MaterialData)localEntry.getValue()).ad_source, ((MaterialData)localEntry.getValue()).adid, ((MaterialData)localEntry.getValue()).res_version)).exists())
        {
          if (((MaterialData)localEntry.getValue()).start_time < l)
          {
            ((ArrayList)localObject3).add(localEntry.getValue());
            localObject5 = a;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("getReqLocalResList,startedResList.add:");
            ((StringBuilder)localObject6).append(((MaterialData)localEntry.getValue()).id);
            ((SuperMaskResMgr)localObject5).a(((StringBuilder)localObject6).toString());
          }
          else
          {
            ((ArrayList)localObject1).add(localEntry.getValue());
            localObject5 = a;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("getReqLocalResList,notStartResList.add:");
            ((StringBuilder)localObject6).append(((MaterialData)localEntry.getValue()).id);
            ((SuperMaskResMgr)localObject5).a(((StringBuilder)localObject6).toString());
          }
        }
        else
        {
          localObject5 = a;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("getReqLocalResList，文件不存在：");
          ((StringBuilder)localObject6).append(((MaterialData)localEntry.getValue()).id);
          ((SuperMaskResMgr)localObject5).a(((StringBuilder)localObject6).toString());
        }
      }
      catch (Throwable localThrowable)
      {
        localObject5 = a;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("getReqLocalResList，异常：");
        ((StringBuilder)localObject6).append(QLog.getStackTraceString(localThrowable));
        ((SuperMaskResMgr)localObject5).a(((StringBuilder)localObject6).toString());
      }
    }
    localObject2 = new ConcurrentHashMap();
    Object localObject4 = (List)localObject3;
    if (((List)localObject4).size() > 1) {
      CollectionsKt.sortWith((List)localObject4, (Comparator)new SuperMaskResMgr.getReqLocalResList..inlined.sortByDescending.1());
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (MaterialData)((Iterator)localObject3).next();
      if (((ConcurrentHashMap)localObject2).size() >= i) {
        break;
      }
      localObject4 = (MaterialData)paramConcurrentHashMap.get(((MaterialData)localObject5).adid);
      if (localObject4 != null)
      {
        localObject6 = (Map)localObject2;
        localObject5 = ((MaterialData)localObject5).adid;
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "value.adid");
        ((Map)localObject6).put(localObject5, localObject4);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("getReqLocalResList,添加已开始投放广告：");
        ((StringBuilder)localObject5).append(((MaterialData)localObject4).id);
        a(((StringBuilder)localObject5).toString());
      }
      else
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getReqLocalResList,result里已开始投放广告为空，adid：");
        ((StringBuilder)localObject4).append(((MaterialData)localObject5).adid);
        a(((StringBuilder)localObject4).toString());
      }
    }
    if (((ConcurrentHashMap)localObject2).size() >= i)
    {
      paramConcurrentHashMap = new StringBuilder();
      paramConcurrentHashMap.append("getReqLocalResList,已经开始投放的素材已经填充满了maxReqCount:");
      paramConcurrentHashMap.append(i);
      a(paramConcurrentHashMap.toString());
      return localObject2;
    }
    CollectionsKt.sortWith((List)localObject1, ComparisonsKt.compareBy(new Function1[] { (Function1)SuperMaskResMgr.getReqLocalResList.5.INSTANCE, (Function1)SuperMaskResMgr.getReqLocalResList.6.INSTANCE }));
    localObject3 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "Calendar.getInstance()");
    ((Calendar)localObject3).set(((Calendar)localObject3).get(1), ((Calendar)localObject3).get(2), ((Calendar)localObject3).get(5), 23, 59, 59);
    localObject3 = ((Calendar)localObject3).getTime();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "calendar.time");
    l = ((Date)localObject3).getTime() / 1000;
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (MaterialData)((Iterator)localObject1).next();
      if (((ConcurrentHashMap)localObject2).size() >= i) {
        return localObject2;
      }
      if (((MaterialData)localObject4).start_time < l)
      {
        localObject3 = (MaterialData)paramConcurrentHashMap.get(((MaterialData)localObject4).adid);
        if (localObject3 != null)
        {
          localObject5 = (Map)localObject2;
          localObject4 = ((MaterialData)localObject4).adid;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "value.adid");
          ((Map)localObject5).put(localObject4, localObject3);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getReqLocalResList,添加未投放广告：");
          ((StringBuilder)localObject4).append(((MaterialData)localObject3).id);
          a(((StringBuilder)localObject4).toString());
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getReqLocalResList,result里未投放广告为空，adid：");
          ((StringBuilder)localObject3).append(((MaterialData)localObject4).adid);
          a(((StringBuilder)localObject3).toString());
        }
      }
    }
    return localObject2;
  }
  
  private final void a(String paramString) {}
  
  private final void c()
  {
    synchronized (d)
    {
      boolean bool = b;
      if (bool) {
        return;
      }
      c = a.d();
      b = true;
      QLog.d("ReadInJoySuperMaskAd", 1, "SuperMaskResMgr init finish");
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  private final ConcurrentHashMap<String, MaterialData> d()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = System.currentTimeMillis();
    Object localObject1 = ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getAllDBData(((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime());
    if (((ConcurrentHashMap)localObject1).size() <= 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getLocalResList time cost : ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l2);
      a(((StringBuilder)localObject1).toString());
      return localConcurrentHashMap;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "allDBData");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((Map.Entry)localObject2).getValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.value");
      Object localObject4;
      if (SuperMaskExtKt.a((MaterialData)localObject3))
      {
        if ((!TextUtils.isEmpty((CharSequence)((MaterialData)((Map.Entry)localObject2).getValue()).adid)) && (((MaterialData)((Map.Entry)localObject2).getValue()).end_time > l1))
        {
          localObject3 = a;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getLocalResList : 符合条件 = ");
          ((StringBuilder)localObject4).append(((MaterialData)((Map.Entry)localObject2).getValue()).id);
          ((SuperMaskResMgr)localObject3).a(((StringBuilder)localObject4).toString());
          localObject3 = (Map)localConcurrentHashMap;
          localObject4 = ((MaterialData)((Map.Entry)localObject2).getValue()).adid;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.value.adid");
          localObject2 = ((Map.Entry)localObject2).getValue();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.value");
          ((Map)localObject3).put(localObject4, localObject2);
        }
        else
        {
          localObject3 = a;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getLocalResList：不符合条件,id:");
          ((StringBuilder)localObject4).append(((MaterialData)((Map.Entry)localObject2).getValue()).id);
          ((StringBuilder)localObject4).append(",end_time:");
          ((StringBuilder)localObject4).append(((MaterialData)((Map.Entry)localObject2).getValue()).end_time);
          ((StringBuilder)localObject4).append(",currentTime:");
          ((StringBuilder)localObject4).append(l1);
          ((SuperMaskResMgr)localObject3).a(((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        localObject3 = a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getLocalResList,文件不存在，id:");
        ((StringBuilder)localObject4).append((String)((Map.Entry)localObject2).getKey());
        ((SuperMaskResMgr)localObject3).a(((StringBuilder)localObject4).toString());
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getLocalResList time cost : ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - l2);
    a(((StringBuilder)localObject1).toString());
    return localConcurrentHashMap;
  }
  
  @Nullable
  public final SuperMaskResMgr.SuperMaskJson a(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      localObject1 = (IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class);
      AppRuntime localAppRuntime = ((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      paramString1 = ((IRIJSuperMaskService)localObject1).findDataById(localAppRuntime, localStringBuilder.toString());
      if (SuperMaskExtKt.d(paramString1)) {
        SuperMaskExtKt.c(paramString1);
      }
      localObject1 = localObject2;
      if (paramString1 != null) {
        localObject1 = new SuperMaskResMgr.SuperMaskJson(paramString1.toJson());
      }
    }
    return localObject1;
  }
  
  public final void a()
  {
    if (b) {
      return;
    }
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      ThreadManagerV2.post((Runnable)SuperMaskResMgr.initLocalRes.1.a, 10, null, true);
      return;
    }
    c();
  }
  
  public final void a(@Nullable Object paramObject)
  {
    Object localObject = paramObject;
    if (!(paramObject instanceof MaterialData)) {
      localObject = null;
    }
    paramObject = (MaterialData)localObject;
    if ((paramObject != null) && (SuperMaskExtKt.a(paramObject)) && (!TextUtils.isEmpty((CharSequence)paramObject.adid)))
    {
      SuperMaskExtKt.a(paramObject, new ConcurrentHashMap());
      localObject = (Map)c;
      String str = paramObject.adid;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.adid");
      ((Map)localObject).put(str, paramObject);
    }
  }
  
  @NotNull
  public final ConcurrentHashMap<String, MaterialData> b()
  {
    if (b) {
      localObject1 = c;
    } else {
      localObject1 = d();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject2 = new ConcurrentHashMap();
    Object localObject1 = (Map)localObject1;
    Object localObject3 = ((Map)localObject1).entrySet().iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      Map localMap;
      String str;
      if (((MaterialData)((Map.Entry)localObject4).getValue()).bid_mask == 1)
      {
        localMap = (Map)localObject2;
        str = ((MaterialData)((Map.Entry)localObject4).getValue()).adid;
        Intrinsics.checkExpressionValueIsNotNull(str, "it.value.adid");
        localMap.put(str, ((Map.Entry)localObject4).getValue());
      }
      else
      {
        localMap = (Map)localConcurrentHashMap;
        str = ((MaterialData)((Map.Entry)localObject4).getValue()).adid;
        Intrinsics.checkExpressionValueIsNotNull(str, "it.value.adid");
        localMap.put(str, ((Map.Entry)localObject4).getValue());
      }
    }
    localConcurrentHashMap = a(localConcurrentHashMap);
    a((ConcurrentHashMap)localObject2);
    localObject2 = QRoute.api(IRIJSuperMaskService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(IRIJSuperMaskService::class.java)");
    int i = ((IRIJSuperMaskService)localObject2).getMaxReqCount();
    if (localConcurrentHashMap.size() >= i) {
      return localConcurrentHashMap;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localConcurrentHashMap.size() >= i) {
        return localConcurrentHashMap;
      }
      localObject3 = (Map)localConcurrentHashMap;
      localObject4 = ((MaterialData)((Map.Entry)localObject2).getValue()).adid;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.value.adid");
      ((Map)localObject3).put(localObject4, ((Map.Entry)localObject2).getValue());
    }
    return localConcurrentHashMap;
  }
  
  public final void b(@Nullable Object paramObject)
  {
    Object localObject = paramObject;
    if (!(paramObject instanceof MaterialData)) {
      localObject = null;
    }
    paramObject = (MaterialData)localObject;
    if ((paramObject != null) && (!TextUtils.isEmpty((CharSequence)paramObject.adid))) {
      c.remove(paramObject.adid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr
 * JD-Core Version:    0.7.0.1
 */