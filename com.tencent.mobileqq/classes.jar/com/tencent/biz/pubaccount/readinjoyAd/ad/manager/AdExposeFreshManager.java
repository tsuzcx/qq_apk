package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager.CacheAd;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class AdExposeFreshManager
{
  private static volatile AdExposeFreshManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdExposeFreshManager;
  private static final Map<String, List<AdExposeFreshManager.CacheAd>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static final Map<String, List<AdExposeFreshManager.CacheAd>> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static final Map<Long, Long> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  private AdExposeFreshManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(408);
    this.jdField_a_of_type_Long = (localAladdinConfig.getIntegerFromString("cache_over_time", 300) * 1000L);
    this.jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("cache_max_size", 5);
    if (localAladdinConfig.getIntegerFromString("cache_float_video", 1) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_b_of_type_Long = (localAladdinConfig.getIntegerFromString("cache_fv_over_time", 300) * 1000L);
      this.jdField_b_of_type_Int = localAladdinConfig.getIntegerFromString("cache_fv_max_size", 5);
      if (localAladdinConfig.getIntegerFromString("req_refresh_swith", 1) != 1) {
        break label131;
      }
      bool1 = true;
      label102:
      this.jdField_b_of_type_Boolean = bool1;
      if (localAladdinConfig.getIntegerFromString("expose_func_switch", 1) != 1) {
        break label136;
      }
    }
    label131:
    label136:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label102;
    }
  }
  
  private int a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ("RIJAdRefreshSceneFloatVideo".equals(paramString)) {
        return this.jdField_b_of_type_Int;
      }
      return this.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  private long a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ("RIJAdRefreshSceneFloatVideo".equals(paramString)) {
        return this.jdField_b_of_type_Long;
      }
      return this.jdField_a_of_type_Long;
    }
    return this.jdField_a_of_type_Long;
  }
  
  private AdExposeFreshManager.CacheAd a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      c("replace", "功能已关闭");
      return null;
    }
    if ((TextUtils.isEmpty(paramString)) || (paramCacheAd == null) || (!paramCacheAd.a()))
    {
      c("replace", "数据无效");
      return null;
    }
    if (!a(paramCacheAd))
    {
      c("replace", "非AMS竞价广告 adId:" + paramCacheAd.jdField_b_of_type_Long);
      return null;
    }
    if (!a(paramString, paramCacheAd))
    {
      c("replace", "不存在于receiveQueue adId:" + paramCacheAd.jdField_b_of_type_Long);
      if (!b(paramString, paramCacheAd))
      {
        c("replace", "广告未曝光，无需替换 adId:" + paramCacheAd.jdField_b_of_type_Long);
        return null;
      }
      c("replace", "广告已曝光，需要替换 adId:" + paramCacheAd.jdField_b_of_type_Long);
    }
    for (;;)
    {
      localObject = a(paramString, (List)jdField_b_of_type_JavaUtilMap.get(paramString));
      b(paramString, "enter");
      jdField_b_of_type_JavaUtilMap.put(paramString, localObject);
      if (!((List)localObject).isEmpty()) {
        break;
      }
      c("replace", "unexposedQueue为空, scene:" + paramString);
      return null;
      c("replace", "存在于receiveQueue，需要替换 adId:" + paramCacheAd.jdField_b_of_type_Long);
    }
    c("replace", "开始替换逻辑，adId：" + paramCacheAd.jdField_b_of_type_Long);
    Object localObject = a(paramString, paramCacheAd, (List)localObject);
    if ((localObject == null) || (!((AdExposeFreshManager.CacheAd)localObject).a()))
    {
      c("replace", "样式适配失败");
      return null;
    }
    a(paramString, paramCacheAd, (AdExposeFreshManager.CacheAd)localObject);
    b("替换成功，adId：" + ((AdExposeFreshManager.CacheAd)localObject).jdField_b_of_type_Long);
    b(paramString, "success");
    return localObject;
  }
  
  private static AdExposeFreshManager.CacheAd a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd, List<AdExposeFreshManager.CacheAd> paramList)
  {
    if (!"RIJAdRefreshSceneNativeArticle".equals(paramString))
    {
      c("matchAdStyle", "skip, scene:" + paramString);
      paramString = (AdExposeFreshManager.CacheAd)paramList.remove(0);
      c("matchAdStyle", "matchAdStyle success,adId:" + paramString.jdField_b_of_type_Long + ", unexposed cache size:" + paramList.size());
      return paramString;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject = null;
    int i;
    int j;
    do
    {
      paramString = localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (AdExposeFreshManager.CacheAd)localIterator.next();
      i = paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adPosType;
      j = paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId;
      c("matchAdStyle", "newAdPosType:" + i + ", oldMaterialId:" + j);
      if (i != 1) {
        break label266;
      }
    } while ((j != 65) && (j != 185));
    label193:
    if (paramString != null)
    {
      boolean bool = paramList.remove(paramString);
      c("matchAdStyle", "文章详情页，从unexposedCache移除适配成功的ad，result：" + bool);
    }
    paramList = new StringBuilder().append("文章详情页, 结果：");
    if (paramString == null) {}
    for (paramCacheAd = "失败";; paramCacheAd = "adId: " + paramString.jdField_b_of_type_Long)
    {
      c("matchAdStyle", paramCacheAd);
      return paramString;
      label266:
      if (i == 2)
      {
        if ((j != 65) && (j != 184) && (j != 194)) {
          break;
        }
        break label193;
      }
      if ((j != 65) && (j != 184) && (j != 185)) {
        break;
      }
      break label193;
    }
  }
  
  public static AdExposeFreshManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdExposeFreshManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdExposeFreshManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdExposeFreshManager = new AdExposeFreshManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdManagerAdExposeFreshManager;
    }
    finally {}
  }
  
  private List<AdExposeFreshManager.CacheAd> a(String paramString, List<AdExposeFreshManager.CacheAd> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      c("removeInvalidAd", "cacheAds is empty");
      return Collections.synchronizedList(new ArrayList());
    }
    long l = System.currentTimeMillis();
    Object localObject1 = Collections.synchronizedList(new ArrayList());
    paramList = paramList.iterator();
    int i = 0;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (AdExposeFreshManager.CacheAd)paramList.next();
      if (((List)localObject1).contains(localObject2))
      {
        j = ((List)localObject1).indexOf(localObject2);
        if (((AdExposeFreshManager.CacheAd)((List)localObject1).get(j)).jdField_a_of_type_Long < ((AdExposeFreshManager.CacheAd)localObject2).jdField_a_of_type_Long) {
          ((List)localObject1).set(j, localObject2);
        }
        c("removeInvalidAd", "去重，adId：" + ((AdExposeFreshManager.CacheAd)localObject2).jdField_b_of_type_Long);
      }
      else if (l - ((AdExposeFreshManager.CacheAd)localObject2).jdField_a_of_type_Long > a(paramString))
      {
        c("removeInvalidAd", "移除过期广告，adId：" + ((AdExposeFreshManager.CacheAd)localObject2).jdField_b_of_type_Long);
        i += 1;
      }
      else
      {
        ((List)localObject1).add(localObject2);
      }
    }
    Collections.sort((List)localObject1, new AdExposeFreshManager.1(this));
    int j = 0;
    if (((List)localObject1).size() > a(paramString))
    {
      j = ((List)localObject1).size();
      int k = a(paramString);
      paramList = new StringBuilder("removeInvalidAd，当前按时间排序后的列表：");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AdExposeFreshManager.CacheAd localCacheAd = (AdExposeFreshManager.CacheAd)((Iterator)localObject2).next();
        paramList.append("adId:").append(localCacheAd.jdField_b_of_type_Long).append("，cacheTime:").append(localCacheAd.jdField_a_of_type_Long).append("\n");
      }
      c("removeInvalidAd", paramList.toString());
      c("removeInvalidAd", "按时间排序后移除超过最大size的广告，当前size：" + ((List)localObject1).size() + "，配置size：" + a(paramString));
      paramList = ((List)localObject1).subList(0, a(paramString));
      j -= k;
    }
    for (;;)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("ad_count_time", i + "");
      ((Map)localObject1).put("ad_count_size", j + "");
      a(paramString, "filter", (Map)localObject1);
      Collections.sort(paramList, new AdExposeFreshManager.2(this));
      return paramList;
      paramList = (List<AdExposeFreshManager.CacheAd>)localObject1;
    }
  }
  
  private static void a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd1, AdExposeFreshManager.CacheAd paramCacheAd2)
  {
    try
    {
      if ("RIJAdRefreshSceneFloatVideo".equals(paramString))
      {
        paramString = paramCacheAd1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
        paramCacheAd2 = paramCacheAd2.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
        paramCacheAd2.jdField_b_of_type_Int = paramString.jdField_b_of_type_Int;
        if (!TextUtils.isEmpty(paramString.v))
        {
          JSONObject localJSONObject = new JSONObject(paramString.v);
          paramCacheAd1 = paramCacheAd2.v;
          paramString = paramCacheAd1;
          if (TextUtils.isEmpty(paramCacheAd1)) {
            paramString = "{}";
          }
          paramString = new JSONObject(paramString);
          paramString.putOpt("strategy", localJSONObject.opt("strategy"));
          paramString.putOpt("ad_first_pos", localJSONObject.opt("ad_first_pos"));
          paramString.putOpt("ad_protect_interval", localJSONObject.opt("ad_protect_interval"));
          paramString.putOpt("ad_first_time", localJSONObject.opt("ad_first_time"));
          paramString.putOpt("ad_interval_time", localJSONObject.opt("ad_interval_time"));
          paramString.putOpt("ad_pre_req", localJSONObject.opt("ad_pre_req"));
          paramString.putOpt("ad_protect_gap", localJSONObject.opt("ad_protect_gap"));
          paramString.putOpt("first_stay_time", localJSONObject.opt("first_stay_time"));
          paramCacheAd2.v = paramString.toString();
        }
        c("wrapData", "数据适配完成");
        return;
      }
      paramString = paramCacheAd1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      paramCacheAd1 = paramCacheAd2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      paramCacheAd1.mAdKdPos = paramString.mAdKdPos;
      if (paramString.mAdvertisementExtInfo != null)
      {
        if (paramCacheAd1.mAdvertisementExtInfo == null) {
          paramCacheAd1.mAdvertisementExtInfo = new AdvertisementExtInfo(null);
        }
        paramCacheAd1.mAdvertisementExtInfo.f = paramString.mAdvertisementExtInfo.f;
        paramCacheAd1.mAdvertisementExtInfo.g = paramString.mAdvertisementExtInfo.g;
        paramCacheAd1.mAdvertisementExtInfo.h = paramString.mAdvertisementExtInfo.h;
        paramCacheAd1.mAdvertisementExtInfo.e = paramString.mAdvertisementExtInfo.e;
        paramCacheAd1.mAdvertisementExtInfo.c = paramString.mAdvertisementExtInfo.c;
      }
      c("wrapData", "数据适配完成");
      return;
    }
    catch (Throwable paramString)
    {
      c("wrapData", "数据适配异常" + paramString.getMessage());
    }
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("cache_over_time", a(paramString1) / 1000L + "");
        localHashMap.put("cache_max_size", a(paramString1) + "");
        List localList = (List)jdField_b_of_type_JavaUtilMap.get(paramString1);
        if ((localList == null) || (localList.isEmpty())) {
          break label334;
        }
        i = localList.size();
        localHashMap.put("cache_ad_count", i + "");
        localHashMap.put("scene_str", paramString1);
        localHashMap.put("action", paramString2);
        if ((paramMap != null) && (!paramMap.isEmpty()))
        {
          paramString1 = paramMap.entrySet().iterator();
          if (paramString1.hasNext())
          {
            paramString2 = (Map.Entry)paramString1.next();
            if ((TextUtils.isEmpty((CharSequence)paramString2.getKey())) || (TextUtils.isEmpty((CharSequence)paramString2.getValue()))) {
              continue;
            }
            localHashMap.put(paramString2.getKey(), paramString2.getValue());
            continue;
          }
        }
        StatisticCollector.getInstance(RIJQQAppInterfaceUtil.a().getApplication()).collectPerformance("000000EYXY3ATYB3", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actKandianAdExpose", true, 0L, 0L, localHashMap, null);
      }
      catch (Throwable paramString1)
      {
        c("report", "灯塔技术上报异常：" + paramString1.getMessage());
        return;
      }
      c("report", "灯塔技术上报：success");
      return;
      label334:
      int i = 0;
    }
  }
  
  private static boolean a(AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      if (paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) {
        if ((paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j != 32) || (paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isContract == 1)) {}
      }
    }
    do
    {
      return true;
      return false;
      return false;
      if (paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break;
      }
    } while ((paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.o == 32) && (paramCacheAd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.u != 1));
    return false;
    return false;
  }
  
  private boolean a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((paramCacheAd == null) || (!paramCacheAd.a())) {
      return false;
    }
    paramString = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return false;
    }
    return paramString.contains(paramCacheAd);
  }
  
  private static void b(String paramString) {}
  
  private void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  private boolean b(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (TextUtils.isEmpty(paramString))
    {
      c("isExposed", "scene is empty");
      return false;
    }
    if (paramCacheAd == null)
    {
      c("isExposed", "cacheAd is null");
      return false;
    }
    if (!jdField_c_of_type_JavaUtilMap.containsKey(Long.valueOf(paramCacheAd.jdField_b_of_type_Long)))
    {
      c("isExposed", "cacheAd no exposed cache");
      return false;
    }
    paramCacheAd = (Long)jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramCacheAd.jdField_b_of_type_Long));
    if (paramCacheAd == null)
    {
      c("isExposed", "cacheAd no exposed cache");
      return false;
    }
    if (System.currentTimeMillis() - paramCacheAd.longValue() > a(paramString))
    {
      c("isExposed", "cacheAd exposed cache invalid");
      return false;
    }
    return true;
  }
  
  private static void c(String paramString1, String paramString2)
  {
    QLog.d("AdExposeFreshManager", 1, paramString1 + ", t_" + Thread.currentThread().getId() + ", " + paramString2);
  }
  
  private void d(String paramString, Set<AdExposeFreshManager.CacheAd> paramSet)
  {
    if (TextUtils.isEmpty(paramString))
    {
      c("addReceiveAds", "scene is empty");
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      c("addReceiveAds", "advertisementInfos is empty");
      return;
    }
    List localList1 = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localList1 == null) {
      localList1 = Collections.synchronizedList(new ArrayList());
    }
    for (;;)
    {
      List localList2 = (List)jdField_b_of_type_JavaUtilMap.get(paramString);
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        AdExposeFreshManager.CacheAd localCacheAd = (AdExposeFreshManager.CacheAd)paramSet.next();
        if (!a(localCacheAd))
        {
          c("addReceiveAds", "not ams bidding ad:" + localCacheAd.jdField_b_of_type_Long);
        }
        else
        {
          c("addReceiveAds", "广告回包处理，添加到receiveQueue，adId：" + localCacheAd.jdField_b_of_type_Long);
          localList1.add(localCacheAd);
          if ((localList2 != null) && (!localList2.isEmpty()) && (localList2.contains(localCacheAd)))
          {
            boolean bool = localList2.remove(localCacheAd);
            c("addReceiveAds", "广告回包处理，从该场景的unexposedCache也存在该广告，adId：" + localCacheAd.jdField_b_of_type_Long + ", 移除结果:" + bool);
          }
        }
      }
      jdField_a_of_type_JavaUtilMap.put(paramString, localList1);
      return;
    }
  }
  
  public VideoInfo a(String paramString, VideoInfo paramVideoInfo)
  {
    paramString = a(paramString, new AdExposeFreshManager.CacheAd(paramVideoInfo));
    if ((paramString == null) || (!paramString.a())) {
      return paramVideoInfo;
    }
    return paramString.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public AdvertisementInfo a(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    paramString = a(paramString, new AdExposeFreshManager.CacheAd(paramAdvertisementInfo));
    if ((paramString == null) || (!paramString.a())) {
      return paramAdvertisementInfo;
    }
    return paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  }
  
  public AdData a(String paramString, AdData paramAdData)
  {
    paramString = a(paramString, new AdExposeFreshManager.CacheAd(paramAdData));
    if ((paramString == null) || (!paramString.a())) {
      return paramAdData;
    }
    return paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      c("exitScene", "scene is empty");
      return;
    }
    c("exitScene", "scene:" + paramString);
    Object localObject1 = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    jdField_a_of_type_JavaUtilMap.remove(paramString);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      c("exitScene", "receiveCache is empty");
      return;
    }
    List localList = (List)jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((localList == null) || (paramString.isEmpty())) {
      localList = Collections.synchronizedList(new ArrayList());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AdExposeFreshManager.CacheAd)((Iterator)localObject1).next();
      if (localList.contains(localObject2))
      {
        localList.set(localList.indexOf(localObject2), localObject2);
      }
      else
      {
        c("exitScene", "添加到unexposedQueue，adId：" + ((AdExposeFreshManager.CacheAd)localObject2).jdField_b_of_type_Long);
        localList.add(localObject2);
      }
    }
    localList = a(paramString, localList);
    localObject1 = new StringBuilder("当前unexposedCache：");
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((AdExposeFreshManager.CacheAd)((Iterator)localObject2).next()).jdField_b_of_type_Long).append(" , ");
    }
    b(((StringBuilder)localObject1).toString());
    jdField_b_of_type_JavaUtilMap.put(paramString, localList);
  }
  
  public void a(String paramString, VideoInfo paramVideoInfo)
  {
    a(paramString, new AdExposeFreshManager.CacheAd(paramVideoInfo));
  }
  
  public void a(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    a(paramString, new AdExposeFreshManager.CacheAd(paramAdvertisementInfo));
  }
  
  public void a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramCacheAd == null)
    {
      c("handleExposedAd", "adId is null");
      return;
    }
    if (!a(paramCacheAd))
    {
      c("handleExposedAd", "not ams bidding Ad");
      return;
    }
    paramString = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      c("handleExposedAd", "已曝光，从receiveQueue移除：" + paramCacheAd.jdField_b_of_type_Long);
      paramString.remove(paramCacheAd);
    }
    paramString = jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      List localList = (List)jdField_b_of_type_JavaUtilMap.get(str);
      if (localList == null)
      {
        c("handleExposedAd", "unexposedCache is null, scene:" + str);
      }
      else
      {
        c("handleExposedAd", "已曝光，从unexposedeQueue移除：" + paramCacheAd.jdField_b_of_type_Long);
        localList.remove(paramCacheAd);
      }
    }
    jdField_c_of_type_JavaUtilMap.put(Long.valueOf(paramCacheAd.jdField_b_of_type_Long), Long.valueOf(System.currentTimeMillis()));
    c("handleExposedAd", "添加到已曝光队列，adId：" + paramCacheAd.jdField_b_of_type_Long);
  }
  
  public void a(String paramString, Set<VideoInfo> paramSet)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(new AdExposeFreshManager.CacheAd((VideoInfo)paramSet.next()));
    }
    d(paramString, localHashSet);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (!jdField_c_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return false;
    }
    Long localLong = (Long)jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localLong == null) {
      return false;
    }
    if (System.currentTimeMillis() - localLong.longValue() > this.jdField_a_of_type_Long)
    {
      c("isExposed", "广告曝光记录已超时：" + paramLong);
      return false;
    }
    return true;
  }
  
  public void b(String paramString, Set<AdData> paramSet)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(new AdExposeFreshManager.CacheAd((AdData)paramSet.next()));
    }
    d(paramString, localHashSet);
  }
  
  public void c(String paramString, Set<AdvertisementInfo> paramSet)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(new AdExposeFreshManager.CacheAd((AdvertisementInfo)paramSet.next()));
    }
    d(paramString, localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager
 * JD-Core Version:    0.7.0.1
 */