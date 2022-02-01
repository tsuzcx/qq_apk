package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static volatile AdExposeFreshManager a;
  private static final Map<String, List<AdExposeFreshManager.CacheAd>> i = new ConcurrentHashMap();
  private static final Map<String, List<AdExposeFreshManager.CacheAd>> j = new ConcurrentHashMap();
  private static final Map<Long, Long> k = new ConcurrentHashMap();
  private long b;
  private int c;
  private boolean d;
  private long e;
  private int f;
  private boolean g;
  private boolean h;
  
  private AdExposeFreshManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(408);
    this.b = (localAladdinConfig.getIntegerFromString("cache_over_time", 300) * 1000L);
    this.c = localAladdinConfig.getIntegerFromString("cache_max_size", 5);
    boolean bool2 = true;
    boolean bool1;
    if (localAladdinConfig.getIntegerFromString("cache_float_video", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    this.e = (localAladdinConfig.getIntegerFromString("cache_fv_over_time", 300) * 1000L);
    this.f = localAladdinConfig.getIntegerFromString("cache_fv_max_size", 5);
    if (localAladdinConfig.getIntegerFromString("req_refresh_swith", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    if (localAladdinConfig.getIntegerFromString("expose_func_switch", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.h = bool1;
  }
  
  /* Error */
  private static AdExposeFreshManager.CacheAd a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd, List<AdExposeFreshManager.CacheAd> paramList)
  {
    // Byte code:
    //   0: ldc 82
    //   2: aload_0
    //   3: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +97 -> 103
    //   9: new 90	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 93
    //   20: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: aload_0
    //   26: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 99
    //   32: aload_1
    //   33: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 106	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_2
    //   40: iconst_0
    //   41: invokeinterface 112 2 0
    //   46: checkcast 114	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager$CacheAd
    //   49: astore_0
    //   50: new 90	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 116
    //   61: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: aload_0
    //   67: getfield 117	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager$CacheAd:b	J
    //   70: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: ldc 122
    //   77: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload_2
    //   83: invokeinterface 126 1 0
    //   88: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 99
    //   94: aload_1
    //   95: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 106	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: areturn
    //   103: aload_2
    //   104: invokeinterface 133 1 0
    //   109: astore 7
    //   111: aconst_null
    //   112: astore 6
    //   114: aload 6
    //   116: astore_0
    //   117: aload 7
    //   119: invokeinterface 139 1 0
    //   124: ifeq +158 -> 282
    //   127: aload 7
    //   129: invokeinterface 143 1 0
    //   134: checkcast 114	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager$CacheAd
    //   137: astore_0
    //   138: aload_1
    //   139: getfield 146	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager$CacheAd:d	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   142: getfield 151	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:adPosType	I
    //   145: istore_3
    //   146: aload_0
    //   147: getfield 146	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager$CacheAd:d	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   150: getfield 154	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdMaterialId	I
    //   153: istore 4
    //   155: new 90	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   162: astore 8
    //   164: aload 8
    //   166: ldc 156
    //   168: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 8
    //   174: iload_3
    //   175: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 8
    //   181: ldc 158
    //   183: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 8
    //   189: iload 4
    //   191: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 99
    //   197: aload 8
    //   199: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 106	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: iload_3
    //   206: iconst_1
    //   207: if_icmpne +21 -> 228
    //   210: iload 4
    //   212: bipush 65
    //   214: if_icmpeq +68 -> 282
    //   217: iload 4
    //   219: sipush 185
    //   222: if_icmpne -108 -> 114
    //   225: goto +57 -> 282
    //   228: iload_3
    //   229: iconst_2
    //   230: if_icmpne +29 -> 259
    //   233: iload 4
    //   235: bipush 65
    //   237: if_icmpeq +45 -> 282
    //   240: iload 4
    //   242: sipush 184
    //   245: if_icmpeq +37 -> 282
    //   248: iload 4
    //   250: sipush 194
    //   253: if_icmpne -139 -> 114
    //   256: goto +26 -> 282
    //   259: iload 4
    //   261: bipush 65
    //   263: if_icmpeq +19 -> 282
    //   266: iload 4
    //   268: sipush 184
    //   271: if_icmpeq +11 -> 282
    //   274: iload 4
    //   276: sipush 185
    //   279: if_icmpne -165 -> 114
    //   282: aload_0
    //   283: ifnull +43 -> 326
    //   286: aload_2
    //   287: aload_0
    //   288: invokeinterface 160 2 0
    //   293: istore 5
    //   295: new 90	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   302: astore_1
    //   303: aload_1
    //   304: ldc 162
    //   306: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_1
    //   311: iload 5
    //   313: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc 99
    //   319: aload_1
    //   320: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 106	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: new 90	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   333: astore_2
    //   334: aload_2
    //   335: ldc 167
    //   337: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_0
    //   342: ifnonnull +9 -> 351
    //   345: ldc 169
    //   347: astore_1
    //   348: goto +32 -> 380
    //   351: new 90	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   358: astore_1
    //   359: aload_1
    //   360: ldc 171
    //   362: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: aload_0
    //   368: getfield 117	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager$CacheAd:b	J
    //   371: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: astore_1
    //   380: aload_2
    //   381: aload_1
    //   382: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: ldc 99
    //   388: aload_2
    //   389: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 106	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramString	String
    //   0	397	1	paramCacheAd	AdExposeFreshManager.CacheAd
    //   0	397	2	paramList	List<AdExposeFreshManager.CacheAd>
    //   145	86	3	m	int
    //   153	127	4	n	int
    //   293	19	5	bool	boolean
    //   112	3	6	localObject	Object
    //   109	19	7	localIterator	Iterator
    //   162	36	8	localStringBuilder	StringBuilder
  }
  
  public static AdExposeFreshManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AdExposeFreshManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private List<AdExposeFreshManager.CacheAd> a(String paramString, List<AdExposeFreshManager.CacheAd> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      long l = System.currentTimeMillis();
      Object localObject1 = Collections.synchronizedList(new ArrayList());
      paramList = paramList.iterator();
      int m = 0;
      int n;
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject2 = (AdExposeFreshManager.CacheAd)paramList.next();
        if (((List)localObject1).contains(localObject2))
        {
          n = ((List)localObject1).indexOf(localObject2);
          if (((AdExposeFreshManager.CacheAd)((List)localObject1).get(n)).a < ((AdExposeFreshManager.CacheAd)localObject2).a) {
            ((List)localObject1).set(n, localObject2);
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("去重，adId：");
          ((StringBuilder)localObject3).append(((AdExposeFreshManager.CacheAd)localObject2).b);
          c("removeInvalidAd", ((StringBuilder)localObject3).toString());
        }
        else if (l - ((AdExposeFreshManager.CacheAd)localObject2).a > b(paramString))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("移除过期广告，adId：");
          ((StringBuilder)localObject3).append(((AdExposeFreshManager.CacheAd)localObject2).b);
          c("removeInvalidAd", ((StringBuilder)localObject3).toString());
          m += 1;
        }
        else
        {
          ((List)localObject1).add(localObject2);
        }
      }
      Collections.sort((List)localObject1, new AdExposeFreshManager.1(this));
      if (((List)localObject1).size() > c(paramString))
      {
        n = ((List)localObject1).size() - c(paramString);
        paramList = new StringBuilder("removeInvalidAd，当前按时间排序后的列表：");
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AdExposeFreshManager.CacheAd)((Iterator)localObject2).next();
          paramList.append("adId:");
          paramList.append(((AdExposeFreshManager.CacheAd)localObject3).b);
          paramList.append("，cacheTime:");
          paramList.append(((AdExposeFreshManager.CacheAd)localObject3).a);
          paramList.append("\n");
        }
        c("removeInvalidAd", paramList.toString());
        paramList = new StringBuilder();
        paramList.append("按时间排序后移除超过最大size的广告，当前size：");
        paramList.append(((List)localObject1).size());
        paramList.append("，配置size：");
        paramList.append(c(paramString));
        c("removeInvalidAd", paramList.toString());
        paramList = ((List)localObject1).subList(0, c(paramString));
      }
      else
      {
        n = 0;
        paramList = (List<AdExposeFreshManager.CacheAd>)localObject1;
      }
      localObject1 = new HashMap();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ad_count_time", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ad_count_size", ((StringBuilder)localObject2).toString());
      a(paramString, "filter", (Map)localObject1);
      Collections.sort(paramList, new AdExposeFreshManager.2(this));
      return paramList;
    }
    c("removeInvalidAd", "cacheAds is empty");
    return Collections.synchronizedList(new ArrayList());
  }
  
  private static void a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd1, AdExposeFreshManager.CacheAd paramCacheAd2)
  {
    try
    {
      boolean bool = "RIJAdRefreshSceneFloatVideo".equals(paramString);
      if (bool)
      {
        paramString = paramCacheAd1.e.as;
        paramCacheAd2 = paramCacheAd2.e.as;
        paramCacheAd2.e = paramString.e;
        if (!TextUtils.isEmpty(paramString.R))
        {
          JSONObject localJSONObject = new JSONObject(paramString.R);
          paramCacheAd1 = paramCacheAd2.R;
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
          paramCacheAd2.R = paramString.toString();
        }
        c("wrapData", "数据适配完成");
        return;
      }
      paramString = paramCacheAd1.d;
      paramCacheAd1 = paramCacheAd2.d;
      paramCacheAd1.mAdKdPos = paramString.mAdKdPos;
      if (paramString.mAdvertisementExtInfo != null)
      {
        if (paramCacheAd1.mAdvertisementExtInfo == null) {
          paramCacheAd1.mAdvertisementExtInfo = new AdvertisementExtInfo(null);
        }
        paramCacheAd1.mAdvertisementExtInfo.g = paramString.mAdvertisementExtInfo.g;
        paramCacheAd1.mAdvertisementExtInfo.h = paramString.mAdvertisementExtInfo.h;
        paramCacheAd1.mAdvertisementExtInfo.i = paramString.mAdvertisementExtInfo.i;
        paramCacheAd1.mAdvertisementExtInfo.f = paramString.mAdvertisementExtInfo.f;
        paramCacheAd1.mAdvertisementExtInfo.d = paramString.mAdvertisementExtInfo.d;
      }
      c("wrapData", "数据适配完成");
      return;
    }
    catch (Throwable paramString)
    {
      paramCacheAd1 = new StringBuilder();
      paramCacheAd1.append("数据适配异常");
      paramCacheAd1.append(paramString.getMessage());
      c("wrapData", paramCacheAd1.toString());
    }
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b(paramString1) / 1000L);
      ((StringBuilder)localObject).append("");
      localHashMap.put("cache_over_time", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c(paramString1));
      ((StringBuilder)localObject).append("");
      localHashMap.put("cache_max_size", ((StringBuilder)localObject).toString());
      int n = 0;
      localObject = (List)j.get(paramString1);
      int m = n;
      if (localObject != null)
      {
        m = n;
        if (!((List)localObject).isEmpty()) {
          m = ((List)localObject).size();
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("");
      localHashMap.put("cache_ad_count", ((StringBuilder)localObject).toString());
      localHashMap.put("scene_str", paramString1);
      localHashMap.put("action", paramString2);
      if ((paramMap != null) && (!paramMap.isEmpty()))
      {
        paramString1 = paramMap.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (Map.Entry)paramString1.next();
          if ((!TextUtils.isEmpty((CharSequence)paramString2.getKey())) && (!TextUtils.isEmpty((CharSequence)paramString2.getValue()))) {
            localHashMap.put(paramString2.getKey(), paramString2.getValue());
          }
        }
      }
      StatisticCollector.getInstance(((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime().getApplication()).collectPerformance("000000EYXY3ATYB3", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actKandianAdExpose", true, 0L, 0L, localHashMap, null);
      c("report", "灯塔技术上报：success");
      return;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("灯塔技术上报异常：");
      paramString2.append(paramString1.getMessage());
      c("report", paramString2.toString());
    }
  }
  
  private static boolean a(AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (paramCacheAd.d != null)
    {
      if (paramCacheAd.d.mAdvertisementExtInfo != null) {
        return (paramCacheAd.d.mAdvertisementExtInfo.o == 32) && (paramCacheAd.d.isContract != 1);
      }
      return false;
    }
    if (paramCacheAd.e != null) {
      return (paramCacheAd.e.as.ae == 32) && (paramCacheAd.e.as.aA != 1);
    }
    return false;
  }
  
  private long b(String paramString)
  {
    if (this.d)
    {
      if ("RIJAdRefreshSceneFloatVideo".equals(paramString)) {
        return this.e;
      }
      return this.b;
    }
    return this.b;
  }
  
  private AdExposeFreshManager.CacheAd b(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (!this.h)
    {
      c("replace", "功能已关闭");
      return null;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramCacheAd != null) && (paramCacheAd.a()))
    {
      if (!a(paramCacheAd))
      {
        paramString = new StringBuilder();
        paramString.append("非AMS竞价广告 adId:");
        paramString.append(paramCacheAd.b);
        c("replace", paramString.toString());
        return null;
      }
      if (!c(paramString, paramCacheAd))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("不存在于receiveQueue adId:");
        ((StringBuilder)localObject).append(paramCacheAd.b);
        c("replace", ((StringBuilder)localObject).toString());
        if (!d(paramString, paramCacheAd))
        {
          paramString = new StringBuilder();
          paramString.append("广告未曝光，无需替换 adId:");
          paramString.append(paramCacheAd.b);
          c("replace", paramString.toString());
          return null;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("广告已曝光，需要替换 adId:");
        ((StringBuilder)localObject).append(paramCacheAd.b);
        c("replace", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("存在于receiveQueue，需要替换 adId:");
        ((StringBuilder)localObject).append(paramCacheAd.b);
        c("replace", ((StringBuilder)localObject).toString());
      }
      Object localObject = a(paramString, (List)j.get(paramString));
      b(paramString, "enter");
      j.put(paramString, localObject);
      if (((List)localObject).isEmpty())
      {
        paramCacheAd = new StringBuilder();
        paramCacheAd.append("unexposedQueue为空, scene:");
        paramCacheAd.append(paramString);
        c("replace", paramCacheAd.toString());
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("开始替换逻辑，adId：");
      localStringBuilder.append(paramCacheAd.b);
      c("replace", localStringBuilder.toString());
      localObject = a(paramString, paramCacheAd, (List)localObject);
      if ((localObject != null) && (((AdExposeFreshManager.CacheAd)localObject).a()))
      {
        a(paramString, paramCacheAd, (AdExposeFreshManager.CacheAd)localObject);
        paramCacheAd = new StringBuilder();
        paramCacheAd.append("替换成功，adId：");
        paramCacheAd.append(((AdExposeFreshManager.CacheAd)localObject).b);
        d(paramCacheAd.toString());
        b(paramString, "success");
        return localObject;
      }
      c("replace", "样式适配失败");
      return null;
    }
    c("replace", "数据无效");
    return null;
  }
  
  private void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  private int c(String paramString)
  {
    if (this.d)
    {
      if ("RIJAdRefreshSceneFloatVideo".equals(paramString)) {
        return this.f;
      }
      return this.c;
    }
    return this.c;
  }
  
  private static void c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", t_");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString2);
    QLog.d("AdExposeFreshManager", 1, localStringBuilder.toString());
  }
  
  private boolean c(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramCacheAd != null)
    {
      if (!paramCacheAd.a()) {
        return false;
      }
      paramString = (List)i.get(paramString);
      if (paramString != null)
      {
        if (paramString.isEmpty()) {
          return false;
        }
        return paramString.contains(paramCacheAd);
      }
    }
    return false;
  }
  
  private static void d(String paramString) {}
  
  private void d(String paramString, Set<AdExposeFreshManager.CacheAd> paramSet)
  {
    if (TextUtils.isEmpty(paramString))
    {
      c("addReceiveAds", "scene is empty");
      return;
    }
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      List localList2 = (List)i.get(paramString);
      List localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
      localList2 = (List)j.get(paramString);
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        AdExposeFreshManager.CacheAd localCacheAd = (AdExposeFreshManager.CacheAd)paramSet.next();
        StringBuilder localStringBuilder;
        if (!a(localCacheAd))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("not ams bidding ad:");
          localStringBuilder.append(localCacheAd.b);
          c("addReceiveAds", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("广告回包处理，添加到receiveQueue，adId：");
          localStringBuilder.append(localCacheAd.b);
          c("addReceiveAds", localStringBuilder.toString());
          localList1.add(localCacheAd);
          if ((localList2 != null) && (!localList2.isEmpty()) && (localList2.contains(localCacheAd)))
          {
            boolean bool = localList2.remove(localCacheAd);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("广告回包处理，从该场景的unexposedCache也存在该广告，adId：");
            localStringBuilder.append(localCacheAd.b);
            localStringBuilder.append(", 移除结果:");
            localStringBuilder.append(bool);
            c("addReceiveAds", localStringBuilder.toString());
          }
        }
      }
      i.put(paramString, localList1);
      return;
    }
    c("addReceiveAds", "advertisementInfos is empty");
  }
  
  private boolean d(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
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
    if (!k.containsKey(Long.valueOf(paramCacheAd.b)))
    {
      c("isExposed", "cacheAd no exposed cache");
      return false;
    }
    paramCacheAd = (Long)k.get(Long.valueOf(paramCacheAd.b));
    if (paramCacheAd == null)
    {
      c("isExposed", "cacheAd no exposed cache");
      return false;
    }
    if (System.currentTimeMillis() - paramCacheAd.longValue() > b(paramString))
    {
      c("isExposed", "cacheAd exposed cache invalid");
      return false;
    }
    return true;
  }
  
  public AdvertisementInfo a(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramAdvertisementInfo;
    }
    paramString = b(paramString, new AdExposeFreshManager.CacheAd(paramAdvertisementInfo));
    if (paramString != null)
    {
      if (!paramString.a()) {
        return paramAdvertisementInfo;
      }
      return paramString.d;
    }
    return paramAdvertisementInfo;
  }
  
  public AdData a(String paramString, AdData paramAdData)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramAdData;
    }
    paramString = b(paramString, new AdExposeFreshManager.CacheAd(paramAdData));
    if (paramString != null)
    {
      if (!paramString.a()) {
        return paramAdData;
      }
      return paramString.f;
    }
    return paramAdData;
  }
  
  public VideoInfo a(String paramString, VideoInfo paramVideoInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramVideoInfo;
    }
    paramString = b(paramString, new AdExposeFreshManager.CacheAd(paramVideoInfo));
    if (paramString != null)
    {
      if (!paramString.a()) {
        return paramVideoInfo;
      }
      return paramString.e;
    }
    return paramVideoInfo;
  }
  
  public void a(String paramString)
  {
    if (!this.h) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      c("exitScene", "scene is empty");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("scene:");
    ((StringBuilder)localObject1).append(paramString);
    c("exitScene", ((StringBuilder)localObject1).toString());
    Object localObject2 = (List)i.get(paramString);
    i.remove(paramString);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject1 = (List)j.get(paramString);
      if ((localObject1 == null) || (paramString.isEmpty())) {
        localObject1 = Collections.synchronizedList(new ArrayList());
      }
      try
      {
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AdExposeFreshManager.CacheAd)((Iterator)localObject2).next();
          if (((List)localObject1).contains(localObject3))
          {
            ((List)localObject1).set(((List)localObject1).indexOf(localObject3), localObject3);
          }
          else
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("添加到unexposedQueue，adId：");
            localStringBuilder2.append(((AdExposeFreshManager.CacheAd)localObject3).b);
            c("exitScene", localStringBuilder2.toString());
            ((List)localObject1).add(localObject3);
          }
        }
        StringBuilder localStringBuilder1;
        c("exitScene", "receiveCache is empty");
      }
      catch (Exception localException)
      {
        c("exitScene", QLog.getStackTraceString(localException));
        localObject1 = a(paramString, (List)localObject1);
        localStringBuilder1 = new StringBuilder("当前unexposedCache：");
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localStringBuilder1.append(((AdExposeFreshManager.CacheAd)((Iterator)localObject3).next()).b);
          localStringBuilder1.append(" , ");
        }
        d(localStringBuilder1.toString());
        j.put(paramString, localObject1);
        return;
      }
    }
  }
  
  public void a(String paramString, AdExposeFreshManager.CacheAd paramCacheAd)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!this.h) {
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
    paramString = (List)i.get(paramString);
    Object localObject1;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("已曝光，从receiveQueue移除：");
      ((StringBuilder)localObject1).append(paramCacheAd.b);
      c("handleExposedAd", ((StringBuilder)localObject1).toString());
      paramString.remove(paramCacheAd);
    }
    paramString = j.keySet().iterator();
    while (paramString.hasNext())
    {
      localObject1 = (String)paramString.next();
      Object localObject2 = (List)j.get(localObject1);
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unexposedCache is null, scene:");
        ((StringBuilder)localObject2).append((String)localObject1);
        c("handleExposedAd", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("已曝光，从unexposedeQueue移除：");
        ((StringBuilder)localObject1).append(paramCacheAd.b);
        c("handleExposedAd", ((StringBuilder)localObject1).toString());
        ((List)localObject2).remove(paramCacheAd);
      }
    }
    k.put(Long.valueOf(paramCacheAd.b), Long.valueOf(System.currentTimeMillis()));
    paramString = new StringBuilder();
    paramString.append("添加到已曝光队列，adId：");
    paramString.append(paramCacheAd.b);
    c("handleExposedAd", paramString.toString());
  }
  
  public void a(String paramString, Set<VideoInfo> paramSet)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!this.h) {
      return;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(new AdExposeFreshManager.CacheAd((VideoInfo)paramSet.next()));
    }
    d(paramString, localHashSet);
  }
  
  public boolean a(long paramLong)
  {
    if (!k.containsKey(Long.valueOf(paramLong))) {
      return false;
    }
    Object localObject = (Long)k.get(Long.valueOf(paramLong));
    if (localObject == null) {
      return false;
    }
    if (System.currentTimeMillis() - ((Long)localObject).longValue() > this.b)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("广告曝光记录已超时：");
      ((StringBuilder)localObject).append(paramLong);
      c("isExposed", ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public void b(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, new AdExposeFreshManager.CacheAd(paramAdvertisementInfo));
  }
  
  public void b(String paramString, VideoInfo paramVideoInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, new AdExposeFreshManager.CacheAd(paramVideoInfo));
  }
  
  public void b(String paramString, Set<AdData> paramSet)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!this.h) {
      return;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(new AdExposeFreshManager.CacheAd((AdData)paramSet.next()));
    }
    d(paramString, localHashSet);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c(String paramString, Set<AdvertisementInfo> paramSet)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!this.h) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager
 * JD-Core Version:    0.7.0.1
 */