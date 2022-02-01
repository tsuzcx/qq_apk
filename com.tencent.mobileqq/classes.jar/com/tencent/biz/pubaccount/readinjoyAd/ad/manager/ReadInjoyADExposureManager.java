package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData.Builder;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdExpandCardPic;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class ReadInjoyADExposureManager
  implements Manager
{
  public static HashMap<String, Long> a = new HashMap();
  public static HashSet<String> b = new HashSet();
  public static ConcurrentHashMap<String, AdvertisementInfo> c = new ConcurrentHashMap();
  public static HashMap<String, Long> d = new HashMap();
  public static HashSet<String> e = new HashSet();
  private QQAppInterface f;
  private int g = -1;
  
  public ReadInjoyADExposureManager(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
    b();
  }
  
  private int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return 4;
    }
    if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAbsBaseArticleInfo)) {
      return 11;
    }
    return 3;
  }
  
  private void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    int i = a(paramAbsBaseArticleInfo, paramAdvertisementInfo);
    paramAbsBaseArticleInfo = new HashMap();
    paramAbsBaseArticleInfo.put("ad_strategy_type", Integer.valueOf(paramAdvertisementInfo.adStrategyType));
    if ((paramAdvertisementInfo.mAdvertisementExtInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo.l == 1035)) {
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).reportExposeLoose();
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(2).b(i).a(paramAdvertisementInfo).e(new JSONObject()).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAbsBaseArticleInfo)).a(Integer.valueOf(2)).b(true));
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if (paramIReadInJoyBaseAdapter != null)
    {
      if (paramAdvertisementInfo == null) {
        return;
      }
      if (e.contains(paramAdvertisementInfo.mAdTraceId))
      {
        if (QLog.isColorLevel())
        {
          paramIReadInJoyBaseAdapter = new StringBuilder();
          paramIReadInJoyBaseAdapter.append("checkWebProcess : has already checked!, traceId=");
          paramIReadInJoyBaseAdapter.append(paramAdvertisementInfo.mAdTraceId);
          QLog.d("ReadInjoyADExposureManager", 2, paramIReadInJoyBaseAdapter.toString());
        }
        return;
      }
      Object localObject = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
      boolean bool = false;
      if ((paramInt3 <= paramInt1) || (paramInt3 >= paramInt2))
      {
        localObject = ((ReadInJoyXListView)localObject).getChildAt(paramInt3 - paramInt1);
        Rect localRect = new Rect();
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.height() <= 0) {}
      }
      else
      {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkWebProcess adVisible=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", traceId=");
        ((StringBuilder)localObject).append(paramAdvertisementInfo.mAdTraceId);
        QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        if (!d.containsKey(paramAdvertisementInfo.mAdTraceId))
        {
          d.put(paramAdvertisementInfo.mAdTraceId, Long.valueOf(paramIReadInJoyBaseAdapter.m()));
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible startTime");
          }
        }
        else if ((d.containsKey(paramAdvertisementInfo.mAdTraceId)) && (paramIReadInJoyBaseAdapter.m() - ((Long)d.get(paramAdvertisementInfo.mAdTraceId)).longValue() >= 500L))
        {
          PreloadService.b(1);
          if (QLog.isColorLevel())
          {
            paramIReadInJoyBaseAdapter = new StringBuilder();
            paramIReadInJoyBaseAdapter.append("checkWebProcess : preloadWebview ! traceId=");
            paramIReadInJoyBaseAdapter.append(paramAdvertisementInfo.mAdTraceId);
            QLog.d("ReadInjoyADExposureManager", 2, paramIReadInJoyBaseAdapter.toString());
          }
          e.add(paramAdvertisementInfo.mAdTraceId);
          d.remove(paramAdvertisementInfo.mAdTraceId);
        }
      }
    }
  }
  
  private void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, double paramDouble, int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, View paramView)
  {
    ViewBase localViewBase = ((IProteusItemView)paramView).getContainer().getVirtualView().findViewBaseByName("id_article_double_image");
    if (!(localViewBase instanceof ReadInjoyDoubleImageView)) {
      return;
    }
    ReadInjoyDoubleImageView localReadInjoyDoubleImageView = (ReadInjoyDoubleImageView)localViewBase;
    int i;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdInteractType(paramAdvertisementInfo))
    {
      boolean bool;
      if (paramInt2 < 4) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt1 = paramIReadInJoyBaseAdapter.d().getPaddingTop();
      paramInt2 = paramView.getTop() + localViewBase.getNativeView().getTop();
      i = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
      int j = localViewBase.getNativeView().getHeight();
      int k = AIOUtils.b(50.0F, paramActivity.getResources());
      localReadInjoyDoubleImageView.a(localViewBase.getNativeView().getHeight(), i, i - paramInt2 - j - k, paramInt2 - paramInt1, bool);
      return;
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType(paramAdvertisementInfo))
    {
      paramInt1 = paramView.getTop() + localViewBase.getNativeView().getTop();
      paramInt2 = paramView.getLeft();
      i = localViewBase.getNativeView().getLeft();
      paramIReadInJoyBaseAdapter = new int[2];
      paramView.getLocationOnScreen(paramIReadInJoyBaseAdapter);
      if (paramIReadInJoyBaseAdapter[1] != 0) {
        paramInt1 = paramIReadInJoyBaseAdapter[1];
      }
      localReadInjoyDoubleImageView.a(paramInt2 + i, paramInt1, this.g, paramDouble);
      return;
    }
    localReadInjoyDoubleImageView.a();
  }
  
  private void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mFeedType == 38) || (ReadInJoyAdUtils.n(paramAbsBaseArticleInfo))) {
      try
      {
        paramIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter.d().getChildAt(paramInt3 - paramInt2);
        if ((paramIReadInJoyBaseAdapter instanceof IProteusItemView))
        {
          paramInt1 = paramInt3 - paramInt1;
          QLog.d("ReadInjoyADExposureManager", 2, new Object[] { "report smallGame : reportMiniGame ", Integer.valueOf(paramInt1) });
          a(paramActivity, paramIReadInJoyBaseAdapter, paramAbsBaseArticleInfo, paramInt1);
          return;
        }
      }
      catch (Exception paramIReadInJoyBaseAdapter)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("report smallGame : error ");
        paramActivity.append(paramIReadInJoyBaseAdapter.getMessage());
        QLog.e("ReadInjoyADExposureManager", 2, paramActivity.toString());
      }
    }
  }
  
  private void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, View paramView)
  {
    ViewBase localViewBase = ((IProteusItemView)paramView).getContainer().getVirtualView().findViewBaseByName("id_article_brand_optimization");
    if ((localViewBase instanceof ReadInJoyAdBrandOptimizationView))
    {
      ReadInJoyAdBrandOptimizationView localReadInJoyAdBrandOptimizationView = (ReadInJoyAdBrandOptimizationView)localViewBase;
      if ((localViewBase.getNativeView() != null) && (paramView.getTop() + localViewBase.getNativeView().getTop() <= AIOUtils.b(120.0F, paramView.getResources()) + paramIReadInJoyBaseAdapter.d().getPaddingTop())) {
        localReadInJoyAdBrandOptimizationView.b();
      }
    }
  }
  
  private void a(boolean paramBoolean, double paramDouble, List<AbsBaseArticleInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!paramBoolean) && (paramInt3 > 0))
    {
      int j = paramInt3 - 10;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = paramInt3 - 1;
      while (j > i)
      {
        if (j >= paramInt2)
        {
          int k = j - paramInt2;
          if (k < paramList.size())
          {
            Object localObject1 = (AbsBaseArticleInfo)paramList.get(k);
            if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject1))
            {
              Object localObject2 = (AdvertisementInfo)localObject1;
              localObject1 = ((AdvertisementInfo)localObject2).mAdvertisementExtInfo;
              k = paramInt3 - j;
              double d1 = Math.abs(paramDouble) * 100.0D;
              if ((localObject1 != null) && (((AdvertisementExtInfo)localObject1).a()) && (k == ((AdvertisementExtInfo)localObject1).d) && (!((AdvertisementExtInfo)localObject1).j) && (d1 < ((AdvertisementExtInfo)localObject1).b) && (((AdvertisementInfo)localObject2).hasAddExposure) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isRepeatedValid((AdvertisementInfo)localObject2)))
              {
                ((AdvertisementExtInfo)localObject1).j = true;
                AdRequestData localAdRequestData = new AdRequestData();
                localAdRequestData.a = ((AdvertisementInfo)localObject2).mAdMaterialId;
                localAdRequestData.b = 1;
                localAdRequestData.c = ((AdvertisementInfo)localObject2).mAdKdPos;
                localAdRequestData.d = ((AdvertisementInfo)localObject2).mAdPosID;
                localAdRequestData.e = true;
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("checkADScrollAction 符合规则触发请求 distance=");
                  ((StringBuilder)localObject2).append(k);
                  ((StringBuilder)localObject2).append(",scrollSpeed=");
                  ((StringBuilder)localObject2).append(d1);
                  ((StringBuilder)localObject2).append(",adExtInfo=");
                  ((StringBuilder)localObject2).append(((AdvertisementExtInfo)localObject1).toString());
                  ((StringBuilder)localObject2).append("|");
                  ((StringBuilder)localObject2).append(localAdRequestData.toString());
                  QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
                }
                ThreadManager.executeOnSubThread(new ReadInjoyADExposureManager.1(this, paramInt1, localAdRequestData));
                break label380;
              }
            }
          }
        }
        label380:
        j -= 1;
      }
    }
  }
  
  private void b()
  {
    a.clear();
    b.clear();
    ReadInjoyADVideoC2sManger.a();
  }
  
  private void b(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, View paramView)
  {
    Object localObject1 = (IProteusItemView)paramView;
    if (((IProteusItemView)localObject1).getContainer() == null) {
      return;
    }
    Object localObject2 = ((IProteusItemView)localObject1).getContainer().getVirtualView().findViewBaseByName("id_ad_expand_view");
    if ((localObject2 instanceof ReadInJoyAdExpandCardPic)) {
      try
      {
        localObject1 = (ReadInJoyAdExpandCardPic)localObject2;
        if (((ViewBase)localObject2).getNativeView() != null)
        {
          int i = ((ViewBase)localObject2).getNativeView().getHeight();
          Rect localRect = new Rect();
          ((ViewBase)localObject2).getNativeView().getGlobalVisibleRect(localRect);
          float f1 = localRect.height() / i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ReadInjoyADExposureManager.updateAdExpandCardView ");
          ((StringBuilder)localObject2).append(f1);
          ReadInJoyAdLog.a("ReadInjoyADExposureManager", ((StringBuilder)localObject2).toString());
          i = paramView.getTop();
          paramView = new StringBuilder();
          paramView.append("ReadInjoyADExposureManager.updateAdExpandCardView top:  ");
          paramView.append(i);
          paramView.append("  ltop:");
          paramView.append(paramIReadInJoyBaseAdapter.d().getTop());
          paramView.append("height:");
          paramView.append(paramIReadInJoyBaseAdapter.d().getHeight());
          paramView.append("");
          ReadInJoyAdLog.a("ReadInjoyADExposureManager", paramView.toString());
          paramView = new StringBuilder();
          paramView.append("ReadInjoyADExposureManager.updateAdExpandCardViewtop2:  ");
          paramView.append(i);
          paramView.append("  ");
          ReadInJoyAdLog.a("ReadInjoyADExposureManager", paramView.toString());
          if (i <= paramIReadInJoyBaseAdapter.d().getPaddingTop())
          {
            ((ReadInJoyAdExpandCardPic)localObject1).a(paramIReadInJoyBaseAdapter.d().getPaddingTop() - i);
            return;
          }
        }
      }
      catch (Exception paramIReadInJoyBaseAdapter)
      {
        paramView = new StringBuilder();
        paramView.append("updateAdExpandCardView error");
        paramView.append(paramIReadInJoyBaseAdapter.getMessage());
        ReadInJoyAdLog.b("ReadInjoyADExposureManager", paramView.toString());
      }
    }
  }
  
  private void c()
  {
    d.clear();
    e.clear();
  }
  
  public int a(AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if (paramIReadInJoyBaseAdapter == null) {
      return 0;
    }
    List localList = paramIReadInJoyBaseAdapter.b();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
    int k = localReadInJoyXListView.getHeaderViewsCount();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int m = localReadInJoyXListView.getLastVisiblePosition();
    int i = j;
    while (i <= m)
    {
      if (i >= k)
      {
        int n = i - k;
        if (n < localList.size())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localList.get(n);
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
          {
            paramIReadInJoyBaseAdapter = null;
            if ((localAbsBaseArticleInfo instanceof AdvertisementInfo)) {
              paramIReadInJoyBaseAdapter = (AdvertisementInfo)localAbsBaseArticleInfo;
            }
            if ((paramIReadInJoyBaseAdapter != null) && (paramIReadInJoyBaseAdapter.mAdTraceId.equals(paramAdvertisementInfo.mAdTraceId)))
            {
              paramAdvertisementInfo = localReadInJoyXListView.getChildAt(i - j);
              i = paramAdvertisementInfo.getHeight();
              paramIReadInJoyBaseAdapter = new Rect();
              paramAdvertisementInfo.getGlobalVisibleRect(paramIReadInJoyBaseAdapter);
              return paramIReadInJoyBaseAdapter.height() * 100 / i;
            }
          }
        }
      }
      i += 1;
    }
    return 0;
  }
  
  public long a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (a.containsKey(paramAdvertisementInfo.mAdTraceId)) {
      return System.currentTimeMillis() - ((Long)a.get(paramAdvertisementInfo.mAdTraceId)).longValue();
    }
    if (b.contains(paramAdvertisementInfo.mAdTraceId)) {
      return 1000L;
    }
    return 0L;
  }
  
  public void a()
  {
    a.clear();
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject1 = c;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = c.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = (AdvertisementInfo)c.get(str);
        if ((localObject2 != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AdvertisementInfo)localObject2).mChannelID)))
        {
          int i = a((AbsBaseArticleInfo)localObject2, (AdvertisementInfo)localObject2);
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(81).b(i).a((AdvertisementInfo)localObject2));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkAndReportAdExposure invalidADExposureReport report ");
            ((StringBuilder)localObject2).append(str);
            QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      c.clear();
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    Object localObject1 = c;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = new HashSet();
      Iterator localIterator = c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = (AdvertisementInfo)c.get(str);
        if ((localObject2 != null) && (((AdvertisementInfo)localObject2).mChannelID == paramInt) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AdvertisementInfo)localObject2).mChannelID)))
        {
          int i = a((AbsBaseArticleInfo)localObject2, (AdvertisementInfo)localObject2);
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(81).b(i).a((AdvertisementInfo)localObject2));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkAndReportAdExposure invalidADExposureReport report ");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(" mChannelID = ");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
          }
          ((HashSet)localObject1).add(str);
        }
      }
      paramContext = ((HashSet)localObject1).iterator();
      while (paramContext.hasNext())
      {
        localObject1 = (String)paramContext.next();
        c.remove(localObject1);
      }
    }
  }
  
  public void a(Context paramContext, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameArticleCard(paramAbsBaseArticleInfo))
        {
          if ((!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo)) || (paramAbsBaseArticleInfo.mFeedType == 39)) {
            break label687;
          }
          paramView = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
          if (!b.contains(paramView.innerUniqueID))
          {
            b.add(paramView.innerUniqueID);
            ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromArticle(paramContext, paramView, paramInt, 2);
          }
        }
        else if (paramAbsBaseArticleInfo.mFeedType == 38)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSmallMiniGameInfo.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSmallMiniGameInfo.a(0));
          String str1 = ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSmallMiniGameInfo.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSmallMiniGameInfo.a(1));
          String str2 = ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSmallMiniGameInfo.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSmallMiniGameInfo.a(2));
          String str3 = ((StringBuilder)localObject).toString();
          localObject = paramAbsBaseArticleInfo.mSmallMiniGameInfo.b;
          if (!b.contains(localObject))
          {
            b.add(localObject);
            AdReportExtData.Builder localBuilder = new AdReportExtData.Builder().a(501L).b(50101L).c(5010102L).d(6L).i(String.valueOf(paramInt)).b(paramAbsBaseArticleInfo.mSmallMiniGameInfo.c);
            if (!paramAbsBaseArticleInfo.mSmallMiniGameInfo.a()) {
              break label692;
            }
            localObject = "3";
            localObject = localBuilder.h((String)localObject).a();
            ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameAd(paramContext, (AdReportExtData)localObject);
          }
          if (paramAbsBaseArticleInfo.mSmallMiniGameInfo.a())
          {
            int m = ((View)paramView.getParent()).getHeight();
            int n = paramView.getTop();
            int i = ((IProteusItemView)paramView).getContainer().getVirtualView().findViewBaseByName("id_game_container1").getNativeView().getTop();
            int j = ((IProteusItemView)paramView).getContainer().getVirtualView().findViewBaseByName("id_game_container2").getNativeView().getTop();
            int k = ((IProteusItemView)paramView).getContainer().getVirtualView().findViewBaseByName("id_game_container3").getNativeView().getTop();
            m = m - 200 - n;
            if ((m > k) && (!b.contains(str3)))
            {
              b.add(str3);
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(paramContext, paramAbsBaseArticleInfo, paramInt, 2, 2);
            }
            if ((m > j) && (!b.contains(str2)))
            {
              b.add(str2);
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(paramContext, paramAbsBaseArticleInfo, paramInt, 1, 2);
            }
            if ((m > i) && (!b.contains(str1)))
            {
              b.add(str1);
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(paramContext, paramAbsBaseArticleInfo, paramInt, 0, 2);
              return;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        paramView = new StringBuilder();
        paramView.append("reportMiniGame error");
        paramView.append(paramContext.getMessage());
        QLog.e("ReadInjoyADExposureManager", 2, paramView.toString());
      }
      return;
      label687:
      paramView = paramAbsBaseArticleInfo;
      continue;
      label692:
      Object localObject = "2";
    }
  }
  
  public void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    Object localObject1;
    List localList;
    int n;
    if (paramIReadInJoyBaseAdapter != null)
    {
      if (paramActivity == null) {
        return;
      }
      localObject1 = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
      localList = paramIReadInJoyBaseAdapter.b();
      n = paramIReadInJoyBaseAdapter.c();
      if (localObject1 != null)
      {
        if (localList == null) {
          return;
        }
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(n)) {
          if (n == 56) {
            return;
          }
        }
      }
    }
    for (;;)
    {
      int k;
      try
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkADScrollAction 向下滑动=");
          if (paramBoolean) {
            break label414;
          }
          bool = true;
          ((StringBuilder)localObject2).append(bool);
          QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
        }
        int i = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
        int j = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
        int m = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
        k = m;
        if (k >= j)
        {
          if (k < i) {
            break label423;
          }
          int i1 = k - i;
          if (i1 >= localList.size()) {
            break label423;
          }
          localObject1 = (AbsBaseArticleInfo)localList.get(i1);
          if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject1)) {
            break label423;
          }
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
          int i2 = ((IReadInJoyBaseAdapterUtil)QRoute.api(IReadInJoyBaseAdapterUtil.class)).getBaseItemViewType(localAdvertisementInfo, 0);
          localObject1 = paramIReadInJoyBaseAdapter.d().getChildAt(k - j);
          if ((i2 == 39) && ((localObject1 instanceof IProteusItemView)))
          {
            a(paramIReadInJoyBaseAdapter, paramActivity, paramDouble, m, i1, localAdvertisementInfo, (View)localObject1);
            break label423;
          }
          if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isBrandOptimizationAdType(localAdvertisementInfo)) {
            break label420;
          }
          localObject2 = localObject1;
          if ((localObject2 instanceof IProteusItemView))
          {
            a(paramIReadInJoyBaseAdapter, (View)localObject2);
            break label423;
          }
          if ((!ReadInJoyAdUtils.v(localAdvertisementInfo)) || (!(localObject1 instanceof IProteusItemView))) {
            break label423;
          }
          b(paramIReadInJoyBaseAdapter, (View)localObject1);
          break label423;
        }
        a(paramBoolean, paramDouble, localList, n, i, j);
        return;
      }
      catch (Exception paramIReadInJoyBaseAdapter)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("checkADScrollAction 出现异常:");
        paramActivity.append(paramIReadInJoyBaseAdapter.getMessage());
        QLog.e("ReadInjoyADExposureManager", 1, paramActivity.toString());
      }
      return;
      label414:
      boolean bool = false;
      continue;
      label420:
      continue;
      label423:
      k -= 1;
    }
  }
  
  public void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    Object localObject1;
    int i;
    if ((paramIReadInJoyBaseAdapter != null) && (paramActivity != null))
    {
      localObject1 = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
      paramActivity = paramIReadInJoyBaseAdapter.b();
      if ((localObject1 != null) && (paramActivity != null)) {
        i = paramIReadInJoyBaseAdapter.c();
      }
    }
    for (;;)
    {
      try
      {
        if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i)) && (i != 56))
        {
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkADPullRefreshAction 向下滑动=");
            if (paramBoolean) {
              break label486;
            }
            paramBoolean = true;
            ((StringBuilder)localObject2).append(paramBoolean);
            QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
          }
          int k = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
          int m = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
          i = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
          if (i >= m)
          {
            if (i >= k)
            {
              int j = i - k;
              if (j < paramActivity.size())
              {
                localObject2 = (AbsBaseArticleInfo)paramActivity.get(j);
                if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2))
                {
                  localObject1 = (AdvertisementInfo)localObject2;
                  j = ((IReadInJoyBaseAdapterUtil)QRoute.api(IReadInJoyBaseAdapterUtil.class)).getBaseItemViewType((AbsBaseArticleInfo)localObject1, 0);
                  localObject1 = paramIReadInJoyBaseAdapter.d().getChildAt(i - m);
                  if ((localObject1 instanceof IProteusItemView))
                  {
                    Object localObject3 = ((IProteusItemView)localObject1).getContainer().getVirtualView();
                    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType((AdvertisementInfo)localObject2)) && (j == 39))
                    {
                      localObject3 = ((ViewBase)localObject3).findViewBaseByName("id_article_double_image");
                      if ((localObject3 != null) && ((localObject3 instanceof ReadInjoyDoubleImageView)))
                      {
                        localObject2 = (ReadInjoyDoubleImageView)localObject3;
                        j = ((View)localObject1).getTop();
                        int i2 = ((ViewBase)localObject3).getNativeView().getTop();
                        int n = ((View)localObject1).getLeft();
                        int i1 = ((ViewBase)localObject3).getNativeView().getLeft();
                        localObject3 = new int[2];
                        ((View)localObject1).getLocationOnScreen((int[])localObject3);
                        if (localObject3[1] != 0) {
                          j = localObject3[1];
                        } else {
                          j = j + i2 + paramInt;
                        }
                        try
                        {
                          ((ReadInjoyDoubleImageView)localObject2).a(n + i1, j, this.g, 1.0D);
                        }
                        catch (Exception paramIReadInJoyBaseAdapter)
                        {
                          continue;
                        }
                      }
                    }
                  }
                }
              }
            }
            i -= 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramIReadInJoyBaseAdapter)
      {
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("checkADPullRefreshAction 出现异常:");
          paramActivity.append(paramIReadInJoyBaseAdapter.getMessage());
          QLog.d("ReadInjoyADExposureManager", 2, paramActivity.toString());
        }
        return;
      }
      return;
      return;
      label486:
      paramBoolean = false;
    }
  }
  
  public boolean a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity)
  {
    return a(paramIReadInJoyBaseAdapter, paramActivity, false);
  }
  
  public boolean a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramActivity != null))
    {
      ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
      List localList = paramIReadInJoyBaseAdapter.b();
      int i = paramIReadInJoyBaseAdapter.c();
      if ((localReadInJoyXListView != null) && (localList != null))
      {
        if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i)) && ((!paramBoolean) || (System.currentTimeMillis() - paramIReadInJoyBaseAdapter.m() > ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getKandianConfigAdExposureThreshold(this.f))))
        {
          paramIReadInJoyBaseAdapter.b(System.currentTimeMillis());
          paramIReadInJoyBaseAdapter.n();
          int i2 = localReadInJoyXListView.getHeaderViewsCount();
          int n = localReadInJoyXListView.getFirstVisiblePosition();
          int i3 = localReadInJoyXListView.getLastVisiblePosition();
          i = n;
          while (i <= i3)
          {
            if (i >= i2)
            {
              int j = i - i2;
              if (j < localList.size())
              {
                Object localObject1 = (AbsBaseArticleInfo)localList.get(j);
                a(paramIReadInJoyBaseAdapter, paramActivity, i2, n, i, (AbsBaseArticleInfo)localObject1);
                if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject1))
                {
                  AdvertisementInfo localAdvertisementInfo;
                  if ((localObject1 instanceof AdvertisementInfo)) {
                    localAdvertisementInfo = (AdvertisementInfo)localObject1;
                  } else {
                    localAdvertisementInfo = null;
                  }
                  if (localAdvertisementInfo == null) {
                    return false;
                  }
                  if (ReadInJoyAdSwitchUtil.j(localAdvertisementInfo)) {
                    a(localAdvertisementInfo, n, i3, i, paramIReadInJoyBaseAdapter);
                  } else if (QLog.isColorLevel()) {
                    QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess enableCheckWebProcess : false.");
                  }
                  if (b.contains(localAdvertisementInfo.mAdTraceId))
                  {
                    localAdvertisementInfo.hasAddExposure = true;
                  }
                  else
                  {
                    j = 1;
                    int i1 = i;
                    Object localObject2;
                    int k;
                    int m;
                    if ((i1 > n) && (i1 < i3))
                    {
                      if (!c.containsKey(localAdvertisementInfo.mAdTraceId))
                      {
                        c.put(localAdvertisementInfo.mAdTraceId, localAdvertisementInfo);
                        if (QLog.isColorLevel())
                        {
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("checkAndReportAdExposure invalidADExposureReport add ");
                          ((StringBuilder)localObject2).append(localAdvertisementInfo.mAdTraceId);
                          QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
                        }
                      }
                      k = 1;
                      m = 1;
                    }
                    else
                    {
                      localObject2 = localReadInJoyXListView.getChildAt(i1 - n);
                      k = ((View)localObject2).getHeight();
                      Rect localRect = new Rect();
                      ((View)localObject2).getGlobalVisibleRect(localRect);
                      int i4 = localRect.height();
                      if (i4 > k >> 1) {
                        j = 1;
                      } else {
                        j = 0;
                      }
                      float f1 = i4;
                      int i5 = AdReqFreshManager.a().b();
                      m = j;
                      if (f1 > k * i5 / 100.0F) {
                        j = 1;
                      } else {
                        j = 0;
                      }
                      if (f1 > k * 0.01F) {
                        k = 1;
                      } else {
                        k = 0;
                      }
                      if ((i4 > 0) && (!c.containsKey(localAdvertisementInfo.mAdTraceId)))
                      {
                        c.put(localAdvertisementInfo.mAdTraceId, localAdvertisementInfo);
                        if (QLog.isColorLevel())
                        {
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("checkAndReportAdExposure invalidADExposureReport add ");
                          ((StringBuilder)localObject2).append(localAdvertisementInfo.mAdTraceId);
                          ((StringBuilder)localObject2).append(" visibleHeight = ");
                          ((StringBuilder)localObject2).append(i4);
                          QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject2).toString());
                        }
                      }
                    }
                    if (j != 0)
                    {
                      AdReqFreshManager.a().a(Long.valueOf(localAdvertisementInfo.mAdAid));
                      AdExposeFreshManager.a().b(localAdvertisementInfo.scene, localAdvertisementInfo);
                    }
                    if (k != 0) {
                      a(paramActivity, (AbsBaseArticleInfo)localObject1, localAdvertisementInfo);
                    }
                    if (m == 0) {
                      break label1154;
                    }
                    if (!a.containsKey(localAdvertisementInfo.mAdTraceId))
                    {
                      a.put(localAdvertisementInfo.mAdTraceId, Long.valueOf(paramIReadInJoyBaseAdapter.m()));
                    }
                    else if (paramIReadInJoyBaseAdapter.m() - ((Long)a.get(localAdvertisementInfo.mAdTraceId)).longValue() > 1000L)
                    {
                      if (ReadInJoyAdUtils.a((int)localAdvertisementInfo.mChannelID))
                      {
                        j = a((AbsBaseArticleInfo)localObject1, localAdvertisementInfo);
                        localObject1 = new HashMap();
                        ((HashMap)localObject1).put("ad_strategy_type", Integer.valueOf(localAdvertisementInfo.adStrategyType));
                        if ((localAdvertisementInfo.mAdvertisementExtInfo != null) && (localAdvertisementInfo.mAdvertisementExtInfo.l == 1035)) {
                          ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).reportExposeStrict();
                        }
                        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(2).b(j).a(Integer.valueOf(1)).a(localAdvertisementInfo).e(new JSONObject()).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson((HashMap)localObject1)));
                        if (c.containsKey(localAdvertisementInfo.mAdTraceId))
                        {
                          c.remove(localAdvertisementInfo.mAdTraceId);
                          if (QLog.isColorLevel())
                          {
                            localObject1 = new StringBuilder();
                            ((StringBuilder)localObject1).append("checkAndReportAdExposure invalidADExposureReport remove ");
                            ((StringBuilder)localObject1).append(localAdvertisementInfo.mAdTraceId);
                            QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject1).toString());
                          }
                        }
                        if (QLog.isColorLevel())
                        {
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append("checkAndReportAdExposure i = ");
                          ((StringBuilder)localObject1).append(i1);
                          ((StringBuilder)localObject1).append(" headerCount = ");
                          ((StringBuilder)localObject1).append(i2);
                          ((StringBuilder)localObject1).append(" firstPos = ");
                          ((StringBuilder)localObject1).append(n);
                          ((StringBuilder)localObject1).append(" lastPos = ");
                          ((StringBuilder)localObject1).append(i3);
                          ((StringBuilder)localObject1).append(" adInfo = ");
                          ((StringBuilder)localObject1).append(localAdvertisementInfo.toSString());
                          QLog.d("ReadInjoyADExposureManager", 2, ((StringBuilder)localObject1).toString());
                        }
                      }
                      localAdvertisementInfo.hasAddExposure = true;
                      b.add(localAdvertisementInfo.mAdTraceId);
                      a.remove(localAdvertisementInfo.mAdTraceId);
                    }
                    paramIReadInJoyBaseAdapter.a(localAdvertisementInfo.mAdTraceId);
                    break label1154;
                  }
                }
              }
            }
            label1154:
            i += 1;
          }
          paramIReadInJoyBaseAdapter.a(a);
          return true;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public void onDestroy()
  {
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager
 * JD-Core Version:    0.7.0.1
 */