package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ExposureSupplementManager
  implements IExposureSupplementManager
{
  private static boolean jdField_a_of_type_Boolean = false;
  private static HashMap<String, Long> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<String, VideoAdInfo> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<String, VideoAdInfo> f = new HashMap();
  private static HashMap<String, Long> g = new HashMap();
  private int jdField_a_of_type_Int;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private HashMap<String, AdvertisementInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_b_of_type_Boolean = false;
  private HashSet<String> jdField_c_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_c_of_type_Boolean = true;
  private boolean jdField_d_of_type_Boolean = false;
  private HashMap<String, AdvertisementInfo> jdField_e_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_e_of_type_Boolean = false;
  
  public ExposureSupplementManager(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return 4;
    }
    if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAdvertisementInfo)) {
      return 11;
    }
    return 3;
  }
  
  private static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("stat_type", 1);
      localJSONObject2.put("percent", paramInt2);
      if (paramInt1 != 0) {
        localJSONObject2.put("duration", paramInt1);
      }
      localJSONObject1.put("statistics_data_report", ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).buildAppFuncExtInfo(paramContext, paramAdvertisementInfo, localJSONObject2).toString());
      return localJSONObject1;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public static void a(Activity paramActivity, float paramFloat, RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    if ((!paramBoolean) && (paramFloat < 1.0D)) {
      b(paramActivity, paramViewHolder);
    }
    if ((paramBoolean) && (paramFloat <= 0.5D))
    {
      a(paramActivity, paramViewHolder);
      return;
    }
    if ((!paramBoolean) && (paramFloat == 1.0D))
    {
      a(paramActivity, 50, true);
      a(paramViewHolder);
    }
  }
  
  private static void a(Activity paramActivity, int paramInt, VideoAdInfo paramVideoAdInfo)
  {
    if (!a()) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportVideoFeeds1px ,traceid =");
      localStringBuilder.append(paramVideoAdInfo.h);
      QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
    }
    if (paramVideoAdInfo.jdField_c_of_type_Boolean)
    {
      a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, 10, 0, paramInt);
      return;
    }
    a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, 5, 0, paramInt);
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    Iterator localIterator = jdField_c_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Long)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((Long)localObject).longValue() != 0L))
      {
        jdField_c_of_type_JavaUtilHashMap.put(str, Long.valueOf(0L));
        VideoAdInfo localVideoAdInfo = (VideoAdInfo)jdField_d_of_type_JavaUtilHashMap.get(str);
        if (localVideoAdInfo == null) {
          return;
        }
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoAdInfo);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportVideoFeeds size =");
          localStringBuilder.append(jdField_c_of_type_JavaUtilHashMap.size());
          localStringBuilder.append(",traceid =");
          localStringBuilder.append(str);
          QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
        }
        int i;
        if (localVideoAdInfo.jdField_c_of_type_Boolean)
        {
          if (paramBoolean) {
            i = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());
          } else {
            i = 0;
          }
          a(paramActivity, localVideoAdInfo, localAdvertisementInfo, 10, i, paramInt);
        }
        else
        {
          if (paramBoolean) {
            i = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());
          } else {
            i = 0;
          }
          a(paramActivity, localVideoAdInfo, localAdvertisementInfo, 5, i, paramInt);
        }
      }
    }
    jdField_d_of_type_JavaUtilHashMap.clear();
  }
  
  public static void a(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!a()) {
      return;
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      if ((paramViewHolder.a != null) && (paramViewHolder.a.a != null) && (paramViewHolder.a.a.r) && (paramViewHolder.a.a.a != null) && (!jdField_c_of_type_JavaUtilHashMap.containsKey(paramViewHolder.a.a.a.h)))
      {
        String str = paramViewHolder.a.a.a.h;
        paramViewHolder.a.a.a.jdField_c_of_type_Boolean = paramViewHolder.a.a.b(paramActivity);
        if (!jdField_c_of_type_JavaUtilHashMap.containsKey(str))
        {
          if (QLog.isColorLevel())
          {
            paramActivity = new StringBuilder();
            paramActivity.append("reportVideoFeeds add to collections , size=");
            paramActivity.append(jdField_c_of_type_JavaUtilHashMap.size());
            QLog.d("ExposureSupplementUtil", 2, paramActivity.toString());
          }
          jdField_c_of_type_JavaUtilHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
          jdField_d_of_type_JavaUtilHashMap.put(str, paramViewHolder.a.a.a);
        }
      }
    }
  }
  
  private void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a()) {
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(25).b(paramInt1).a(paramAdvertisementInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)));
  }
  
  private static void a(Activity paramActivity, VideoAdInfo paramVideoAdInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a()) {
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(25).b(paramInt1).a(paramAdvertisementInfo).a(paramVideoAdInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)));
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localLong != null)
      {
        if (localLong.longValue() == 0L) {
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportFeeds,channelID=");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append(",traceId");
          localStringBuilder.append(paramString);
          QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
        paramString = (AdvertisementInfo)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
        if (paramString == null) {
          return;
        }
        long l1 = System.currentTimeMillis();
        long l2 = localLong.longValue();
        a(paramActivity, paramString, a(paramString), (int)(l1 - l2), 50);
      }
    }
  }
  
  public static void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!a()) {
      return;
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      if ((paramViewHolder.a != null) && (paramViewHolder.a.a != null) && (paramViewHolder.a.a.r) && (paramViewHolder.a.a.a != null) && (g.containsKey(paramViewHolder.a.a.a.h)))
      {
        paramViewHolder = paramViewHolder.a.a.a.h;
        g.put(paramViewHolder, Long.valueOf(0L));
        f.remove(paramViewHolder);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeVideoFeeds1px and remove , trace_id=");
          localStringBuilder.append(paramViewHolder);
          QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = "1".equals(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("readinjjoy_ad_supplement_config"));
    if ((QLog.isColorLevel()) && (!bool) && (!jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      QLog.d("ExposureSupplementUtil", 2, "supplement report is close!");
      return bool;
    }
    jdField_a_of_type_Boolean = false;
    return bool;
  }
  
  public static void b(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!a()) {
      return;
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      if ((paramViewHolder.a != null) && (paramViewHolder.a.a != null) && (paramViewHolder.a.a.r) && (paramViewHolder.a.a.a != null) && (!g.containsKey(paramViewHolder.a.a.a.h)))
      {
        String str = paramViewHolder.a.a.a.h;
        paramViewHolder.a.a.a.jdField_c_of_type_Boolean = paramViewHolder.a.a.b(paramActivity);
        if (!g.containsKey(str))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("recordVideoFeeds1px and add trace_id=");
            localStringBuilder.append(str);
            QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
          }
          f.put(str, paramViewHolder.a.a.a);
          g.put(str, Long.valueOf(System.currentTimeMillis()));
          a(paramActivity, 1, paramViewHolder.a.a.a);
        }
      }
    }
  }
  
  public static void c(Activity paramActivity)
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnVideoPause reportVideoFeeds size =");
      ((StringBuilder)localObject1).append(jdField_c_of_type_JavaUtilHashMap.size());
      QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = jdField_c_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Long)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((Long)localObject2).longValue() != 0L))
      {
        jdField_c_of_type_JavaUtilHashMap.put(localObject3, Long.valueOf(0L));
        localObject3 = (VideoAdInfo)jdField_d_of_type_JavaUtilHashMap.get(localObject3);
        if (localObject3 == null) {
          return;
        }
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo((VideoAdInfo)localObject3);
        if (((VideoAdInfo)localObject3).jdField_c_of_type_Boolean) {
          a(paramActivity, (VideoAdInfo)localObject3, localAdvertisementInfo, 10, (int)(System.currentTimeMillis() - ((Long)localObject2).longValue()), 50);
        } else {
          a(paramActivity, (VideoAdInfo)localObject3, localAdvertisementInfo, 5, (int)(System.currentTimeMillis() - ((Long)localObject2).longValue()), 50);
        }
      }
    }
  }
  
  public static void d()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnVideoResume reportVideoFeeds size =");
      localStringBuilder.append(jdField_c_of_type_JavaUtilHashMap.size());
      QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
    }
  }
  
  public static void e()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_d_of_type_JavaUtilHashMap.clear();
    f.clear();
    g.clear();
  }
  
  public void a()
  {
    if (a())
    {
      if (!this.jdField_c_of_type_Boolean) {
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnFeedsResume , channelID=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" , size = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.size());
        ((StringBuilder)localObject).append(",this = ");
        ((StringBuilder)localObject).append(this);
        QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doOnFeedsResume , isDestroyFromFeeds channelID=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" , size = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.size());
          ((StringBuilder)localObject).append(",this = ");
          ((StringBuilder)localObject).append(this);
          QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (str.equals(localEntry.getKey()))
            {
              localEntry.setValue(Long.valueOf(System.currentTimeMillis()));
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("doOnFeedsResume , reset traceid=");
                localStringBuilder.append((String)localEntry.getKey());
                QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
              }
            }
          }
        }
        this.jdField_a_of_type_JavaUtilHashSet.clear();
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!this.jdField_c_of_type_JavaUtilHashSet.contains(((Map.Entry)localObject2).getKey())) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((Map.Entry)localObject2).getKey());
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
      {
        localObject2 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        if ((localObject2 != null) && (((Long)localObject2).longValue() != 0L))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Long.valueOf(0L));
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
          if (localAdvertisementInfo == null) {
            return;
          }
          long l1 = System.currentTimeMillis();
          long l2 = ((Long)localObject2).longValue();
          int j = a(localAdvertisementInfo);
          this.jdField_b_of_type_JavaUtilHashSet.add(localObject1);
          a(paramActivity, localAdvertisementInfo, j, (int)(l1 - l2), 50);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reportFeedsWhenRemove traceId=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      i += 1;
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if (!a()) {
        return;
      }
      String str = paramAdvertisementInfo.mAdTraceId;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        this.jdField_b_of_type_JavaUtilHashSet.remove(str);
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str, paramAdvertisementInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
      if (QLog.isColorLevel())
      {
        paramAdvertisementInfo = new StringBuilder();
        paramAdvertisementInfo.append("add traceId=");
        paramAdvertisementInfo.append(str);
        paramAdvertisementInfo.append(" , channelID=");
        paramAdvertisementInfo.append(this.jdField_a_of_type_Int);
        QLog.d("ExposureSupplementUtil", 2, paramAdvertisementInfo.toString());
      }
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    if (!a()) {
      return;
    }
    if (!this.jdField_e_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportAnd1Px: traceid=");
        localStringBuilder.append(paramAdvertisementInfo.mAdTraceId);
        QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
      }
      this.jdField_e_of_type_JavaUtilHashMap.put(paramAdvertisementInfo.mAdTraceId, paramAdvertisementInfo);
      a(paramActivity, paramAdvertisementInfo, a(paramAdvertisementInfo), 0, 1);
    }
  }
  
  public void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramActivity != null))
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.a();
      List localList = paramIReadInJoyBaseAdapter.a();
      int i = paramIReadInJoyBaseAdapter.a();
      if (localReadInJoyXListView != null)
      {
        if (localList == null) {
          return;
        }
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i))
        {
          c();
          int k = localReadInJoyXListView.getHeaderViewsCount();
          int j = localReadInJoyXListView.getFirstVisiblePosition();
          int m = localReadInJoyXListView.getLastVisiblePosition();
          i = j;
          while (i <= m)
          {
            if (i >= k)
            {
              int n = i - k;
              if (n < localList.size())
              {
                paramIReadInJoyBaseAdapter = (AbsBaseArticleInfo)localList.get(n);
                if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramIReadInJoyBaseAdapter)) {
                  a(localReadInJoyXListView, j, m, i, (AdvertisementInfo)paramIReadInJoyBaseAdapter, paramActivity);
                }
              }
            }
            i += 1;
          }
          a(paramActivity);
        }
      }
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, int paramInt1, int paramInt2, int paramInt3, AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    if (!a()) {
      return;
    }
    b(paramAdvertisementInfo);
    int i = 1;
    if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2))
    {
      paramInt1 = i;
    }
    else
    {
      paramReadInJoyXListView = paramReadInJoyXListView.getChildAt(paramInt3 - paramInt1);
      paramInt1 = paramReadInJoyXListView.getHeight();
      paramActivity = new Rect();
      paramReadInJoyXListView.getGlobalVisibleRect(paramActivity);
      if (paramActivity.height() > paramInt1 >> 1) {
        paramInt1 = i;
      } else {
        paramInt1 = 0;
      }
    }
    if (paramInt1 != 0) {
      a(paramAdvertisementInfo);
    }
  }
  
  public void a(Object paramObject, Activity paramActivity)
  {
    a((AdvertisementInfo)paramObject, paramActivity);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroyDataFromFeeds , channelID=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", size =");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.size());
      ((StringBuilder)localObject).append(",this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilHashSet.clear();
    this.jdField_e_of_type_JavaUtilHashMap.clear();
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!this.jdField_b_of_type_JavaUtilHashSet.contains(localEntry.getKey())) {
        this.jdField_a_of_type_JavaUtilHashSet.add(localEntry.getKey());
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(Activity paramActivity)
  {
    if (a())
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnFeedsPause , channelID=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", size =");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.size());
        ((StringBuilder)localObject).append(",this = ");
        ((StringBuilder)localObject).append(this);
        QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramActivity, (String)((Map.Entry)((Iterator)localObject).next()).getKey());
      }
    }
  }
  
  public void b(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_c_of_type_JavaUtilHashSet.add(paramAdvertisementInfo.mAdTraceId);
  }
  
  public void c()
  {
    if (!a()) {
      return;
    }
    this.jdField_c_of_type_JavaUtilHashSet.clear();
  }
  
  public void f()
  {
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager
 * JD-Core Version:    0.7.0.1
 */