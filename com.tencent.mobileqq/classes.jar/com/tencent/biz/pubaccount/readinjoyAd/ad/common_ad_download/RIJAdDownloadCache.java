package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.DownloadPercent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/RIJAdDownloadCache;", "", "()V", "downloadCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "reportPercent_1", "Ljava/util/concurrent/CopyOnWriteArraySet;", "reportPercent_10", "reportPercent_25", "reportPercent_50", "reportPercent_75", "reportPercent_90", "viewCache", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "addDownloadCache", "", "data", "addReportCache", "packageName", "percent", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/DownloadPercent;", "addViewCache", "view", "getDownloadCache", "hasReportCache", "", "onDestroy", "removeReportCache", "removeViewCache", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadCache
{
  public static final RIJAdDownloadCache a;
  private static final ConcurrentHashMap<String, ADVideoAppDownloadData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static final CopyOnWriteArraySet<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private static final ConcurrentHashMap<Integer, WeakReference<RIJDownloadView>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static final CopyOnWriteArraySet<String> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private static final CopyOnWriteArraySet<String> c = new CopyOnWriteArraySet();
  private static final CopyOnWriteArraySet<String> d = new CopyOnWriteArraySet();
  private static final CopyOnWriteArraySet<String> e = new CopyOnWriteArraySet();
  private static final CopyOnWriteArraySet<String> f = new CopyOnWriteArraySet();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadRIJAdDownloadCache = new RIJAdDownloadCache();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  @Nullable
  public final ADVideoAppDownloadData a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return null;
    }
    return (ADVideoAppDownloadData)((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (ADVideoAppDownloadData)((Map.Entry)localObject1).getValue();
      if (localObject2 != null)
      {
        localObject2 = RIJAdDownloadExKt.a((ADVideoAppDownloadData)localObject2);
        if (localObject2 != null) {
          ((IDownloadEngine)localObject2).b(null, (ADVideoAppDownloadData)((Map.Entry)localObject1).getValue());
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    localIterator = ((Map)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (WeakReference)((Map.Entry)localIterator.next()).getValue();
      if (localObject1 != null)
      {
        localObject1 = (RIJDownloadView)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          WadlProxyServiceUtil.a().b((WadlProxyServiceCallBackInterface)localObject1);
          DownloadManagerV2.a().b((DownloadListener)localObject1);
        }
      }
    }
  }
  
  public final void a(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView = (WeakReference)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramRIJDownloadView.hashCode()), new WeakReference(paramRIJDownloadView));
    }
  }
  
  public final void a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null)
    {
      Map localMap = (Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      String str = paramADVideoAppDownloadData.d;
      Intrinsics.checkExpressionValueIsNotNull(str, "data.mPackageName");
      localMap.put(str, paramADVideoAppDownloadData);
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
      jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
      c.remove(paramString);
      d.remove(paramString);
      e.remove(paramString);
      f.remove(paramString);
    }
  }
  
  public final void a(@Nullable String paramString, @NotNull DownloadPercent paramDownloadPercent)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadPercent, "percent");
    if (paramString != null)
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return;
      }
      switch (RIJAdDownloadCache.WhenMappings.a[paramDownloadPercent.ordinal()])
      {
      default: 
        return;
      case 6: 
        f.add(paramString);
        return;
      case 5: 
        e.add(paramString);
        return;
      case 4: 
        d.add(paramString);
        return;
      case 3: 
        c.add(paramString);
        return;
      case 2: 
        jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
    }
  }
  
  public final boolean a(@Nullable String paramString, @NotNull DownloadPercent paramDownloadPercent)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadPercent, "percent");
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    switch (RIJAdDownloadCache.WhenMappings.b[paramDownloadPercent.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 6: 
      return f.contains(paramString);
    case 5: 
      return e.contains(paramString);
    case 4: 
      return d.contains(paramString);
    case 3: 
      return c.contains(paramString);
    case 2: 
      return jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString);
    }
    return jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString);
  }
  
  public final void b(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView = (WeakReference)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramRIJDownloadView.hashCode()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache
 * JD-Core Version:    0.7.0.1
 */