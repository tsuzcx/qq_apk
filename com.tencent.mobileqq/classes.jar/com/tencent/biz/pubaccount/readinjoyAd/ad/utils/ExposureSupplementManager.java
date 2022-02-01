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
  private static HashMap<String, Long> e = new HashMap();
  private static HashMap<String, VideoAdInfo> f = new HashMap();
  private static HashMap<String, VideoAdInfo> j = new HashMap();
  private static HashMap<String, Long> k = new HashMap();
  private static boolean l = false;
  private HashMap<String, Long> a = new HashMap();
  private HashSet<String> b = new HashSet();
  private HashSet<String> c = new HashSet();
  private HashMap<String, AdvertisementInfo> d = new HashMap();
  private ArrayList<String> g = new ArrayList();
  private HashSet<String> h = new HashSet();
  private HashMap<String, AdvertisementInfo> i = new HashMap();
  private int m;
  private boolean n = false;
  private boolean o = true;
  private boolean p = false;
  private boolean q = false;
  
  public ExposureSupplementManager(int paramInt)
  {
    this.m = paramInt;
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
    if (!f()) {
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
    if (!f()) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportVideoFeeds1px ,traceid =");
      localStringBuilder.append(paramVideoAdInfo.m);
      QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
    }
    if (paramVideoAdInfo.al)
    {
      a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, 10, 0, paramInt);
      return;
    }
    a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, 5, 0, paramInt);
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (!f()) {
      return;
    }
    Iterator localIterator = e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Long)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((Long)localObject).longValue() != 0L))
      {
        e.put(str, Long.valueOf(0L));
        VideoAdInfo localVideoAdInfo = (VideoAdInfo)f.get(str);
        if (localVideoAdInfo == null) {
          return;
        }
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoAdInfo);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportVideoFeeds size =");
          localStringBuilder.append(e.size());
          localStringBuilder.append(",traceid =");
          localStringBuilder.append(str);
          QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
        }
        int i1;
        if (localVideoAdInfo.al)
        {
          if (paramBoolean) {
            i1 = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());
          } else {
            i1 = 0;
          }
          a(paramActivity, localVideoAdInfo, localAdvertisementInfo, 10, i1, paramInt);
        }
        else
        {
          if (paramBoolean) {
            i1 = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());
          } else {
            i1 = 0;
          }
          a(paramActivity, localVideoAdInfo, localAdvertisementInfo, 5, i1, paramInt);
        }
      }
    }
    f.clear();
  }
  
  public static void a(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!f()) {
      return;
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      if ((paramViewHolder.az != null) && (paramViewHolder.az.c != null) && (paramViewHolder.az.c.aq) && (paramViewHolder.az.c.as != null) && (!e.containsKey(paramViewHolder.az.c.as.m)))
      {
        String str = paramViewHolder.az.c.as.m;
        paramViewHolder.az.c.as.al = paramViewHolder.az.c.e(paramActivity);
        if (!e.containsKey(str))
        {
          if (QLog.isColorLevel())
          {
            paramActivity = new StringBuilder();
            paramActivity.append("reportVideoFeeds add to collections , size=");
            paramActivity.append(e.size());
            QLog.d("ExposureSupplementUtil", 2, paramActivity.toString());
          }
          e.put(str, Long.valueOf(System.currentTimeMillis()));
          f.put(str, paramViewHolder.az.c.as);
        }
      }
    }
  }
  
  private void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!f()) {
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(25).b(paramInt1).a(paramAdvertisementInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)));
  }
  
  private static void a(Activity paramActivity, VideoAdInfo paramVideoAdInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!f()) {
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(25).b(paramInt1).a(paramAdvertisementInfo).a(paramVideoAdInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)));
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (!f()) {
      return;
    }
    if (this.a.containsKey(paramString))
    {
      Long localLong = (Long)this.a.get(paramString);
      if (localLong != null)
      {
        if (localLong.longValue() == 0L) {
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportFeeds,channelID=");
          localStringBuilder.append(this.m);
          localStringBuilder.append(",traceId");
          localStringBuilder.append(paramString);
          QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
        }
        this.a.put(paramString, Long.valueOf(0L));
        paramString = (AdvertisementInfo)this.d.get(paramString);
        if (paramString == null) {
          return;
        }
        long l1 = System.currentTimeMillis();
        long l2 = localLong.longValue();
        a(paramActivity, paramString, c(paramString), (int)(l1 - l2), 50);
      }
    }
  }
  
  public static void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!f()) {
      return;
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      if ((paramViewHolder.az != null) && (paramViewHolder.az.c != null) && (paramViewHolder.az.c.aq) && (paramViewHolder.az.c.as != null) && (k.containsKey(paramViewHolder.az.c.as.m)))
      {
        paramViewHolder = paramViewHolder.az.c.as.m;
        k.put(paramViewHolder, Long.valueOf(0L));
        j.remove(paramViewHolder);
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
  
  public static void b(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!f()) {
      return;
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      if ((paramViewHolder.az != null) && (paramViewHolder.az.c != null) && (paramViewHolder.az.c.aq) && (paramViewHolder.az.c.as != null) && (!k.containsKey(paramViewHolder.az.c.as.m)))
      {
        String str = paramViewHolder.az.c.as.m;
        paramViewHolder.az.c.as.al = paramViewHolder.az.c.e(paramActivity);
        if (!k.containsKey(str))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("recordVideoFeeds1px and add trace_id=");
            localStringBuilder.append(str);
            QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
          }
          j.put(str, paramViewHolder.az.c.as);
          k.put(str, Long.valueOf(System.currentTimeMillis()));
          a(paramActivity, 1, paramViewHolder.az.c.as);
        }
      }
    }
  }
  
  private static int c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return 4;
    }
    if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAdvertisementInfo)) {
      return 11;
    }
    return 3;
  }
  
  public static void c(Activity paramActivity)
  {
    if (!f()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnVideoPause reportVideoFeeds size =");
      ((StringBuilder)localObject1).append(e.size());
      QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = e.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Long)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((Long)localObject2).longValue() != 0L))
      {
        e.put(localObject3, Long.valueOf(0L));
        localObject3 = (VideoAdInfo)f.get(localObject3);
        if (localObject3 == null) {
          return;
        }
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo((VideoAdInfo)localObject3);
        if (((VideoAdInfo)localObject3).al) {
          a(paramActivity, (VideoAdInfo)localObject3, localAdvertisementInfo, 10, (int)(System.currentTimeMillis() - ((Long)localObject2).longValue()), 50);
        } else {
          a(paramActivity, (VideoAdInfo)localObject3, localAdvertisementInfo, 5, (int)(System.currentTimeMillis() - ((Long)localObject2).longValue()), 50);
        }
      }
    }
  }
  
  public static void d()
  {
    if (!f()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnVideoResume reportVideoFeeds size =");
      localStringBuilder.append(e.size());
      QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
    }
  }
  
  public static void e()
  {
    e.clear();
    f.clear();
    j.clear();
    k.clear();
  }
  
  public static boolean f()
  {
    boolean bool = "1".equals(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("readinjjoy_ad_supplement_config"));
    if ((QLog.isColorLevel()) && (!bool) && (!l))
    {
      l = true;
      QLog.d("ExposureSupplementUtil", 2, "supplement report is close!");
      return bool;
    }
    l = false;
    return bool;
  }
  
  public void a()
  {
    if (f())
    {
      if (!this.o) {
        return;
      }
      this.o = false;
      this.n = false;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnFeedsResume , channelID=");
        ((StringBuilder)localObject).append(this.m);
        ((StringBuilder)localObject).append(" , size = ");
        ((StringBuilder)localObject).append(this.a.size());
        ((StringBuilder)localObject).append(",this = ");
        ((StringBuilder)localObject).append(this);
        QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
      }
      if (this.q)
      {
        this.q = false;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doOnFeedsResume , isDestroyFromFeeds channelID=");
          ((StringBuilder)localObject).append(this.m);
          ((StringBuilder)localObject).append(" , size = ");
          ((StringBuilder)localObject).append(this.a.size());
          ((StringBuilder)localObject).append(",this = ");
          ((StringBuilder)localObject).append(this);
          QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Iterator localIterator = this.a.entrySet().iterator();
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
        this.b.clear();
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (!f()) {
      return;
    }
    if (this.a.isEmpty()) {
      return;
    }
    this.g.clear();
    Object localObject1 = this.a.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!this.h.contains(((Map.Entry)localObject2).getKey())) {
        this.g.add(((Map.Entry)localObject2).getKey());
      }
    }
    int i1 = 0;
    while (i1 < this.g.size())
    {
      localObject1 = (String)this.g.get(i1);
      if (this.a.containsKey(localObject1))
      {
        localObject2 = (Long)this.a.get(localObject1);
        if ((localObject2 != null) && (((Long)localObject2).longValue() != 0L))
        {
          this.a.put(localObject1, Long.valueOf(0L));
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.d.get(localObject1);
          if (localAdvertisementInfo == null) {
            return;
          }
          long l1 = System.currentTimeMillis();
          long l2 = ((Long)localObject2).longValue();
          int i2 = c(localAdvertisementInfo);
          this.c.add(localObject1);
          a(paramActivity, localAdvertisementInfo, i2, (int)(l1 - l2), 50);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reportFeedsWhenRemove traceId=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      i1 += 1;
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if (!f()) {
        return;
      }
      String str = paramAdvertisementInfo.mAdTraceId;
      if (this.a.containsKey(str))
      {
        this.c.remove(str);
        return;
      }
      this.d.put(str, paramAdvertisementInfo);
      this.a.put(str, Long.valueOf(System.currentTimeMillis()));
      if (QLog.isColorLevel())
      {
        paramAdvertisementInfo = new StringBuilder();
        paramAdvertisementInfo.append("add traceId=");
        paramAdvertisementInfo.append(str);
        paramAdvertisementInfo.append(" , channelID=");
        paramAdvertisementInfo.append(this.m);
        QLog.d("ExposureSupplementUtil", 2, paramAdvertisementInfo.toString());
      }
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    if (!f()) {
      return;
    }
    if (!this.i.containsKey(paramAdvertisementInfo.mAdTraceId))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportAnd1Px: traceid=");
        localStringBuilder.append(paramAdvertisementInfo.mAdTraceId);
        QLog.d("ExposureSupplementUtil", 2, localStringBuilder.toString());
      }
      this.i.put(paramAdvertisementInfo.mAdTraceId, paramAdvertisementInfo);
      a(paramActivity, paramAdvertisementInfo, c(paramAdvertisementInfo), 0, 1);
    }
  }
  
  public void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramActivity != null))
    {
      if (this.o) {
        return;
      }
      ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
      List localList = paramIReadInJoyBaseAdapter.b();
      int i1 = paramIReadInJoyBaseAdapter.c();
      if (localReadInJoyXListView != null)
      {
        if (localList == null) {
          return;
        }
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i1))
        {
          c();
          int i3 = localReadInJoyXListView.getHeaderViewsCount();
          int i2 = localReadInJoyXListView.getFirstVisiblePosition();
          int i4 = localReadInJoyXListView.getLastVisiblePosition();
          i1 = i2;
          while (i1 <= i4)
          {
            if (i1 >= i3)
            {
              int i5 = i1 - i3;
              if (i5 < localList.size())
              {
                paramIReadInJoyBaseAdapter = (AbsBaseArticleInfo)localList.get(i5);
                if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramIReadInJoyBaseAdapter)) {
                  a(localReadInJoyXListView, i2, i4, i1, (AdvertisementInfo)paramIReadInJoyBaseAdapter, paramActivity);
                }
              }
            }
            i1 += 1;
          }
          a(paramActivity);
        }
      }
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, int paramInt1, int paramInt2, int paramInt3, AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    if (!f()) {
      return;
    }
    b(paramAdvertisementInfo);
    int i1 = 1;
    if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2))
    {
      paramInt1 = i1;
    }
    else
    {
      paramReadInJoyXListView = paramReadInJoyXListView.getChildAt(paramInt3 - paramInt1);
      paramInt1 = paramReadInJoyXListView.getHeight();
      paramActivity = new Rect();
      paramReadInJoyXListView.getGlobalVisibleRect(paramActivity);
      if (paramActivity.height() > paramInt1 >> 1) {
        paramInt1 = i1;
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
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(", size =");
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append(",this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
    }
    this.q = true;
    this.g.clear();
    this.h.clear();
    this.i.clear();
    Object localObject = this.a.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!this.c.contains(localEntry.getKey())) {
        this.b.add(localEntry.getKey());
      }
    }
    this.a.clear();
    this.c.clear();
  }
  
  public void b(Activity paramActivity)
  {
    if (f())
    {
      if (this.n) {
        return;
      }
      this.n = true;
      this.o = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnFeedsPause , channelID=");
        ((StringBuilder)localObject).append(this.m);
        ((StringBuilder)localObject).append(", size =");
        ((StringBuilder)localObject).append(this.a.size());
        ((StringBuilder)localObject).append(",this = ");
        ((StringBuilder)localObject).append(this);
        QLog.d("ExposureSupplementUtil", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramActivity, (String)((Map.Entry)((Iterator)localObject).next()).getKey());
      }
    }
  }
  
  public void b(AdvertisementInfo paramAdvertisementInfo)
  {
    this.h.add(paramAdvertisementInfo.mAdTraceId);
  }
  
  public void c()
  {
    if (!f()) {
      return;
    }
    this.h.clear();
  }
  
  public void g()
  {
    this.p = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager
 * JD-Core Version:    0.7.0.1
 */