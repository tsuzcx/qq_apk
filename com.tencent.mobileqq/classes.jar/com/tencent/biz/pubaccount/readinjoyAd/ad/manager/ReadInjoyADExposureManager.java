package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData.Builder;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapterUtil;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
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
  public static HashMap<String, Long> a;
  public static HashSet<String> a;
  public static ConcurrentHashMap<String, AdvertisementInfo> a;
  public static HashMap<String, Long> b;
  public static HashSet<String> b;
  private int jdField_a_of_type_Int = -1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ReadInjoyADExposureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private int a(BaseArticleInfo paramBaseArticleInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return 4;
    }
    if (RIJFeedsType.a(paramBaseArticleInfo)) {
      return 11;
    }
    return 3;
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashSet.clear();
    ReadInjoyADVideoC2sManger.a();
  }
  
  private void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    int i = a(paramBaseArticleInfo, paramAdvertisementInfo);
    paramBaseArticleInfo = new HashMap();
    paramBaseArticleInfo.put("ad_strategy_type", Integer.valueOf(paramAdvertisementInfo.adStrategyType));
    NativeAdUtils.a(new AdReportData().a(paramActivity).a(2).b(i).a(paramAdvertisementInfo).e(new JSONObject()).d(NativeAdUtils.a(paramBaseArticleInfo)).a(Integer.valueOf(2)).b(true));
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramReadInJoyBaseAdapter == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if (!jdField_b_of_type_JavaUtilHashSet.contains(paramAdvertisementInfo.mAdTraceId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : has already checked!, traceId=" + paramAdvertisementInfo.mAdTraceId);
    return;
    Object localObject = (ReadInJoyXListView)paramReadInJoyBaseAdapter.a();
    boolean bool;
    if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2)) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible=" + bool + ", traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      if (!bool) {
        break;
      }
      if (!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId))
      {
        jdField_b_of_type_JavaUtilHashMap.put(paramAdvertisementInfo.mAdTraceId, Long.valueOf(paramReadInJoyBaseAdapter.jdField_b_of_type_Long));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible startTime");
        return;
        localObject = ((ReadInJoyXListView)localObject).getChildAt(paramInt3 - paramInt1);
        Rect localRect = new Rect();
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.height() <= 0) {
          break label324;
        }
        bool = true;
        continue;
      }
      if ((!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId)) || (paramReadInJoyBaseAdapter.jdField_b_of_type_Long - ((Long)jdField_b_of_type_JavaUtilHashMap.get(paramAdvertisementInfo.mAdTraceId)).longValue() < 500L)) {
        break;
      }
      PreloadService.b(1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : preloadWebview ! traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      jdField_b_of_type_JavaUtilHashSet.add(paramAdvertisementInfo.mAdTraceId);
      jdField_b_of_type_JavaUtilHashMap.remove(paramAdvertisementInfo.mAdTraceId);
      return;
      label324:
      bool = false;
    }
  }
  
  private void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Activity paramActivity, double paramDouble, int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_double_image");
    if (!(localViewBase instanceof ReadInjoyDoubleImageView)) {
      return;
    }
    ReadInjoyDoubleImageView localReadInjoyDoubleImageView = (ReadInjoyDoubleImageView)localViewBase;
    int i;
    if (ReadInJoyAdUtils.c(paramAdvertisementInfo))
    {
      boolean bool = false;
      if (paramInt2 < 4) {
        bool = true;
      }
      paramInt1 = paramReadInJoyBaseAdapter.a().getPaddingTop();
      paramInt2 = paramView.getTop() + localViewBase.getNativeView().getTop();
      i = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
      int j = localViewBase.getNativeView().getHeight();
      int k = AIOUtils.a(50.0F, paramActivity.getResources());
      localReadInjoyDoubleImageView.a(localViewBase.getNativeView().getHeight(), i, i - paramInt2 - j - k, paramInt2 - paramInt1, bool);
      return;
    }
    if (ReadInJoyAdUtils.f(paramAdvertisementInfo))
    {
      paramInt1 = paramView.getTop() + localViewBase.getNativeView().getTop();
      paramInt2 = paramView.getLeft();
      i = localViewBase.getNativeView().getLeft();
      paramReadInJoyBaseAdapter = new int[2];
      paramView.getLocationOnScreen(paramReadInJoyBaseAdapter);
      if (paramReadInJoyBaseAdapter[1] != 0) {
        paramInt1 = paramReadInJoyBaseAdapter[1];
      }
      localReadInjoyDoubleImageView.a(i + paramInt2, paramInt1, this.jdField_a_of_type_Int, paramDouble);
      return;
    }
    localReadInjoyDoubleImageView.a();
  }
  
  private void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mFeedType == 38) || (ReadInJoyAdUtils.m(paramBaseArticleInfo))) {}
    try
    {
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a().getChildAt(paramInt3 - paramInt2);
      if ((paramReadInJoyBaseAdapter instanceof ProteusItemView))
      {
        QLog.d("ReadInjoyADExposureManager", 2, new Object[] { "report smallGame : reportMiniGame ", Integer.valueOf(paramInt3 - paramInt1) });
        a(paramActivity, paramReadInJoyBaseAdapter, paramBaseArticleInfo, paramInt3 - paramInt1);
      }
      return;
    }
    catch (Exception paramReadInJoyBaseAdapter)
    {
      QLog.e("ReadInjoyADExposureManager", 2, "report smallGame : error " + paramReadInJoyBaseAdapter.getMessage());
    }
  }
  
  private void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_brand_optimization");
    if ((localViewBase instanceof ReadInJoyAdBrandOptimizationView))
    {
      ReadInJoyAdBrandOptimizationView localReadInJoyAdBrandOptimizationView = (ReadInJoyAdBrandOptimizationView)localViewBase;
      if (localViewBase.getNativeView() != null)
      {
        int i = paramView.getTop();
        if (localViewBase.getNativeView().getTop() + i <= AIOUtils.a(120.0F, paramView.getResources()) + paramReadInJoyBaseAdapter.a().getPaddingTop()) {
          localReadInJoyAdBrandOptimizationView.b();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, double paramDouble, List<BaseArticleInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((!paramBoolean) && (paramInt3 > 0))
    {
      i = paramInt3 - 10;
      if (i >= 0) {
        break label331;
      }
      i = 0;
    }
    label331:
    for (;;)
    {
      int j = paramInt3 - 1;
      if (j > i)
      {
        if ((j < paramInt2) || (j - paramInt2 >= paramList.size())) {}
        for (;;)
        {
          j -= 1;
          break;
          Object localObject = (BaseArticleInfo)paramList.get(j - paramInt2);
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))
          {
            localObject = (AdvertisementInfo)localObject;
            AdvertisementExtInfo localAdvertisementExtInfo = ((AdvertisementInfo)localObject).mAdvertisementExtInfo;
            int k = paramInt3 - j;
            double d = Math.abs(paramDouble) * 100.0D;
            if ((localAdvertisementExtInfo != null) && (localAdvertisementExtInfo.a()) && (k == localAdvertisementExtInfo.c) && (!localAdvertisementExtInfo.jdField_a_of_type_Boolean) && (d < localAdvertisementExtInfo.jdField_a_of_type_Int) && (((AdvertisementInfo)localObject).hasAddExposure) && (ReadInJoyAdUtils.d((AdvertisementInfo)localObject)))
            {
              localAdvertisementExtInfo.jdField_a_of_type_Boolean = true;
              AdRequestData localAdRequestData = new AdRequestData();
              localAdRequestData.jdField_a_of_type_Int = ((AdvertisementInfo)localObject).mAdMaterialId;
              localAdRequestData.b = 1;
              localAdRequestData.c = ((AdvertisementInfo)localObject).mAdKdPos;
              localAdRequestData.jdField_a_of_type_Long = ((AdvertisementInfo)localObject).mAdPosID;
              localAdRequestData.jdField_a_of_type_Boolean = true;
              if (QLog.isColorLevel()) {
                QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 符合规则触发请求 distance=" + k + ",scrollSpeed=" + d + ",adExtInfo=" + localAdvertisementExtInfo.toString() + "|" + localAdRequestData.toString());
              }
              ThreadManager.executeOnSubThread(new ReadInjoyADExposureManager.1(this, paramInt1, localAdRequestData));
            }
          }
        }
      }
      return;
    }
  }
  
  private void b()
  {
    jdField_b_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localAdvertisementInfo != null) && (ReadInJoyAdUtils.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i = a(localAdvertisementInfo, localAdvertisementInfo);
          NativeAdUtils.a(new AdReportData().a(paramActivity).a(81).b(i).a(localAdvertisementInfo));
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str);
          }
        }
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Object localObject = new HashSet();
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mChannelID == paramInt) && (ReadInJoyAdUtils.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i = a(localAdvertisementInfo, localAdvertisementInfo);
          NativeAdUtils.a(new AdReportData().a(paramContext).a(81).b(i).a(localAdvertisementInfo));
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str + " mChannelID = " + paramInt);
          }
          ((HashSet)localObject).add(str);
        }
      }
      paramContext = ((HashSet)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (String)paramContext.next();
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
      }
    }
  }
  
  public void a(Context paramContext, View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (ReadInJoyAdUtils.m(paramBaseArticleInfo))
        {
          paramView = paramBaseArticleInfo;
          if (ReadInJoyAdUtils.k(paramBaseArticleInfo))
          {
            paramView = paramBaseArticleInfo;
            if (paramBaseArticleInfo.mFeedType != 39) {
              paramView = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
            }
          }
          if (jdField_a_of_type_JavaUtilHashSet.contains(paramView.innerUniqueID)) {
            break;
          }
          jdField_a_of_type_JavaUtilHashSet.add(paramView.innerUniqueID);
          NativeAdUtils.a(paramContext, paramView, paramInt, 2);
          return;
        }
        if (paramBaseArticleInfo.mFeedType != 38) {
          break;
        }
        String str2 = paramBaseArticleInfo.mSmallMiniGameInfo.b + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.a(0);
        String str3 = paramBaseArticleInfo.mSmallMiniGameInfo.b + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.a(1);
        String str4 = paramBaseArticleInfo.mSmallMiniGameInfo.b + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.a(2);
        str1 = paramBaseArticleInfo.mSmallMiniGameInfo.b;
        if (!jdField_a_of_type_JavaUtilHashSet.contains(str1))
        {
          jdField_a_of_type_JavaUtilHashSet.add(str1);
          AdReportExtData.Builder localBuilder = new AdReportExtData.Builder().a(501L).b(50101L).c(5010102L).d(6L).i(String.valueOf(paramInt)).b(paramBaseArticleInfo.mSmallMiniGameInfo.c);
          if (paramBaseArticleInfo.mSmallMiniGameInfo.a())
          {
            str1 = "3";
            NativeAdUtils.a(paramContext, localBuilder.h(str1).a());
          }
        }
        else
        {
          if (!paramBaseArticleInfo.mSmallMiniGameInfo.a()) {
            break;
          }
          int i = ((View)paramView.getParent()).getHeight() - 200;
          int j = paramView.getTop();
          int k = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container1").getNativeView().getTop();
          int m = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container2").getNativeView().getTop();
          if ((i - j > ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container3").getNativeView().getTop()) && (!jdField_a_of_type_JavaUtilHashSet.contains(str4)))
          {
            jdField_a_of_type_JavaUtilHashSet.add(str4);
            NativeAdUtils.a(paramContext, paramBaseArticleInfo, paramInt, 2, 2);
          }
          if ((i - j > m) && (!jdField_a_of_type_JavaUtilHashSet.contains(str3)))
          {
            jdField_a_of_type_JavaUtilHashSet.add(str3);
            NativeAdUtils.a(paramContext, paramBaseArticleInfo, paramInt, 1, 2);
          }
          if ((i - j <= k) || (jdField_a_of_type_JavaUtilHashSet.contains(str2))) {
            break;
          }
          jdField_a_of_type_JavaUtilHashSet.add(str2);
          NativeAdUtils.a(paramContext, paramBaseArticleInfo, paramInt, 0, 2);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ReadInjoyADExposureManager", 2, "reportMiniGame error" + paramContext.getMessage());
        return;
      }
      String str1 = "2";
    }
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    if ((paramReadInJoyBaseAdapter == null) || (paramActivity == null)) {}
    Object localObject1;
    List localList;
    int k;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramReadInJoyBaseAdapter.a();
      localList = paramReadInJoyBaseAdapter.a();
      k = paramReadInJoyBaseAdapter.a();
    } while ((localObject1 == null) || (localList == null) || (!ReadInJoyAdUtils.a(k)) || (k == 56));
    for (;;)
    {
      Object localObject2;
      int m;
      int n;
      int i;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("checkADScrollAction 向下滑动=");
          if (paramBoolean) {
            break label333;
          }
          bool = true;
          QLog.d("ReadInjoyADExposureManager", 2, bool);
        }
        m = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
        n = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
        int j = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
        i = j;
        if (i < n) {
          break label308;
        }
        if ((i < m) || (i - m >= localList.size())) {
          break label324;
        }
        int i1 = i - m;
        localObject1 = (BaseArticleInfo)localList.get(i1);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label324;
        }
        localObject1 = (AdvertisementInfo)localObject1;
        int i2 = ReadInJoyBaseAdapterUtil.a.a((ArticleInfo)localObject1, 0);
        localObject2 = paramReadInJoyBaseAdapter.a().getChildAt(i - n);
        if ((i2 == 39) && ((localObject2 instanceof ProteusItemView))) {
          a(paramReadInJoyBaseAdapter, paramActivity, paramDouble, j, i1, (AdvertisementInfo)localObject1, (View)localObject2);
        }
      }
      catch (Exception paramReadInJoyBaseAdapter)
      {
        QLog.e("ReadInjoyADExposureManager", 1, "checkADScrollAction 出现异常:" + paramReadInJoyBaseAdapter.getMessage());
        return;
      }
      if ((ReadInJoyAdUtils.g((AdvertisementInfo)localObject1)) && ((localObject2 instanceof ProteusItemView)))
      {
        a(paramReadInJoyBaseAdapter, (View)localObject2);
        break label324;
        label308:
        a(paramBoolean, paramDouble, localList, k, m, n);
        return;
      }
      label324:
      i -= 1;
      continue;
      label333:
      boolean bool = false;
    }
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramReadInJoyBaseAdapter == null) || (paramActivity == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramReadInJoyBaseAdapter.a();
      paramActivity = paramReadInJoyBaseAdapter.a();
    } while ((localObject1 == null) || (paramActivity == null));
    int i = paramReadInJoyBaseAdapter.a();
    for (;;)
    {
      int i2;
      try
      {
        if ((!ReadInJoyAdUtils.a(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label413;
          }
          paramBoolean = bool;
          QLog.d("ReadInjoyADExposureManager", 2, paramBoolean);
        }
        int k = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
        int m = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
        i = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
        if (i < m) {
          break;
        }
        if ((i < k) || (i - k >= paramActivity.size())) {
          break label404;
        }
        Object localObject2 = (BaseArticleInfo)paramActivity.get(i - k);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
          break label404;
        }
        localObject1 = (AdvertisementInfo)localObject2;
        j = ReadInJoyBaseAdapterUtil.a.a((ArticleInfo)localObject1, 0);
        localObject1 = paramReadInJoyBaseAdapter.a().getChildAt(i - m);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label404;
        }
        Object localObject3 = ((ProteusItemView)localObject1).a().getVirtualView();
        if ((!ReadInJoyAdUtils.f((AdvertisementInfo)localObject2)) || (j != 39)) {
          break label404;
        }
        localObject3 = ((ViewBase)localObject3).findViewBaseByName("id_article_double_image");
        if ((localObject3 == null) || (!(localObject3 instanceof ReadInjoyDoubleImageView))) {
          break label404;
        }
        localObject2 = (ReadInjoyDoubleImageView)localObject3;
        j = ((View)localObject1).getTop();
        i2 = ((ViewBase)localObject3).getNativeView().getTop();
        int n = ((View)localObject1).getLeft();
        int i1 = ((ViewBase)localObject3).getNativeView().getLeft();
        localObject3 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject3);
        if (localObject3[1] == 0) {
          break label391;
        }
        j = localObject3[1];
        ((ReadInjoyDoubleImageView)localObject2).a(i1 + n, j, this.jdField_a_of_type_Int, 1.0D);
      }
      catch (Exception paramReadInJoyBaseAdapter) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramReadInJoyBaseAdapter.getMessage());
      return;
      label391:
      int j = j + i2 + paramInt;
      continue;
      label404:
      i -= 1;
      continue;
      label413:
      paramBoolean = false;
    }
  }
  
  public boolean a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Activity paramActivity)
  {
    if ((paramReadInJoyBaseAdapter == null) || (paramActivity == null)) {
      return false;
    }
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramReadInJoyBaseAdapter.a();
    List localList = paramReadInJoyBaseAdapter.a();
    int i = paramReadInJoyBaseAdapter.a();
    if ((localReadInJoyXListView == null) || (localList == null)) {
      return false;
    }
    if ((ReadInJoyAdUtils.a(i)) && (System.currentTimeMillis() - paramReadInJoyBaseAdapter.jdField_b_of_type_Long > ReadInJoyHelper.D(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramReadInJoyBaseAdapter.jdField_b_of_type_Long = System.currentTimeMillis();
      paramReadInJoyBaseAdapter.jdField_a_of_type_JavaUtilHashSet.clear();
      paramReadInJoyBaseAdapter.jdField_b_of_type_JavaUtilHashSet.clear();
      int i4 = localReadInJoyXListView.getHeaderViewsCount();
      int i1 = localReadInJoyXListView.getFirstVisiblePosition();
      int i5 = localReadInJoyXListView.getLastVisiblePosition();
      int m = i1;
      Object localObject1;
      if (m <= i5)
      {
        if ((m < i4) || (m - i4 >= localList.size())) {}
        Object localObject2;
        label279:
        int j;
        int k;
        int n;
        int i2;
        label407:
        do
        {
          do
          {
            m += 1;
            break;
            localObject2 = (BaseArticleInfo)localList.get(m - i4);
            a(paramReadInJoyBaseAdapter, paramActivity, i4, i1, m, (BaseArticleInfo)localObject2);
          } while (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2));
          localObject1 = null;
          if ((localObject2 instanceof AdvertisementInfo)) {
            localObject1 = (AdvertisementInfo)localObject2;
          }
          if (localObject1 == null) {
            return false;
          }
          if (ReadInJoyAdSwitchUtil.e((AdvertisementInfo)localObject1)) {
            a((AdvertisementInfo)localObject1, i1, i5, m, paramReadInJoyBaseAdapter);
          }
          for (;;)
          {
            if (!jdField_a_of_type_JavaUtilHashSet.contains(((AdvertisementInfo)localObject1).mAdTraceId)) {
              break label279;
            }
            ((AdvertisementInfo)localObject1).hasAddExposure = true;
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess enableCheckWebProcess : false.");
            }
          }
          i = 0;
          j = 0;
          k = 0;
          if ((m <= i1) || (m >= i5)) {
            break label506;
          }
          n = 1;
          i2 = 1;
          int i3 = 1;
          i = i3;
          j = i2;
          k = n;
          if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            i = i3;
            j = i2;
            k = n;
            if (QLog.isColorLevel())
            {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId);
              k = n;
              j = i2;
              i = i3;
            }
          }
          if (j != 0)
          {
            AdReqFreshManager.a().a(Long.valueOf(((AdvertisementInfo)localObject1).mAdAid));
            AdExposeFreshManager.a().a(((AdvertisementInfo)localObject1).scene, (AdvertisementInfo)localObject1);
          }
          if (i != 0) {
            a(paramActivity, (BaseArticleInfo)localObject2, (AdvertisementInfo)localObject1);
          }
        } while (k == 0);
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)) {
          jdField_a_of_type_JavaUtilHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, Long.valueOf(paramReadInJoyBaseAdapter.jdField_b_of_type_Long));
        }
        for (;;)
        {
          paramReadInJoyBaseAdapter.jdField_a_of_type_JavaUtilHashSet.add(((AdvertisementInfo)localObject1).mAdTraceId);
          break;
          label506:
          View localView = localReadInJoyXListView.getChildAt(m - i1);
          i2 = localView.getHeight();
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          n = localRect.height();
          if (n > i2 >> 1) {
            i = 1;
          }
          if (n > AdReqFreshManager.a().a() * i2 / 100.0F) {
            j = 1;
          }
          if (n > i2 * 0.01F) {
            k = 1;
          }
          if ((n > 0) && (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId + " visibleHeight = " + n);
            }
          }
          n = i;
          i = k;
          k = n;
          break label407;
          if (paramReadInJoyBaseAdapter.jdField_b_of_type_Long - ((Long)jdField_a_of_type_JavaUtilHashMap.get(((AdvertisementInfo)localObject1).mAdTraceId)).longValue() > 1000L)
          {
            if (ReadInJoyAdUtils.a((int)((AdvertisementInfo)localObject1).mChannelID))
            {
              i = a((BaseArticleInfo)localObject2, (AdvertisementInfo)localObject1);
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("ad_strategy_type", Integer.valueOf(((AdvertisementInfo)localObject1).adStrategyType));
              NativeAdUtils.a(new AdReportData().a(paramActivity).a(2).b(i).a(Integer.valueOf(1)).a((AdvertisementInfo)localObject1).e(new JSONObject()).d(NativeAdUtils.a((HashMap)localObject2)));
              if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
              {
                jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((AdvertisementInfo)localObject1).mAdTraceId);
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport remove " + ((AdvertisementInfo)localObject1).mAdTraceId);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure i = " + m + " headerCount = " + i4 + " firstPos = " + i1 + " lastPos = " + i5 + " adInfo = " + ((AdvertisementInfo)localObject1).toSString());
              }
            }
            ((AdvertisementInfo)localObject1).hasAddExposure = true;
            jdField_a_of_type_JavaUtilHashSet.add(((AdvertisementInfo)localObject1).mAdTraceId);
            jdField_a_of_type_JavaUtilHashMap.remove(((AdvertisementInfo)localObject1).mAdTraceId);
          }
        }
      }
      paramActivity = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (String)paramActivity.next();
        if (!paramReadInJoyBaseAdapter.jdField_a_of_type_JavaUtilHashSet.contains(localObject1)) {
          paramReadInJoyBaseAdapter.jdField_b_of_type_JavaUtilHashSet.add(localObject1);
        }
      }
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (paramReadInJoyBaseAdapter.hasNext())
      {
        paramActivity = (String)paramReadInJoyBaseAdapter.next();
        jdField_a_of_type_JavaUtilHashMap.remove(paramActivity);
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager
 * JD-Core Version:    0.7.0.1
 */