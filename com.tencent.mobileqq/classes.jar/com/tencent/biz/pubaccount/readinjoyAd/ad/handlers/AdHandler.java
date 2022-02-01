package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager.ExposureSupplementUtilManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IBaseUiBridge;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.api.IArticleInfoHelper;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.lang.ref.SoftReference;
import java.util.List;

public class AdHandler
  extends AdBaseHandler
{
  private static ExposureSupplementManager.ExposureSupplementUtilManager n = new ExposureSupplementManager.ExposureSupplementUtilManager();
  protected ReadInJoyObserver a = new AdHandler.3(this);
  private AdHandler.ItemViewBuilder b = new AdHandler.ItemViewBuilder(this);
  private int c;
  private int d = 0;
  private int e = -1;
  private boolean f = false;
  private boolean g = false;
  private float h = DeviceInfoUtil.J() * 500 / 160.0F;
  private float i = DeviceInfoUtil.J() * 1000 / 160.0F;
  private float j = 1.5F;
  private AdvertisementInfo k = null;
  private DecelerateInterpolator l = new DecelerateInterpolator(this.j);
  private SparseArray<View> m = new SparseArray(1);
  private ListView o;
  private SurpriseVideoHandler p;
  
  private void a(View paramView)
  {
    View localView = null;
    Object localObject = null;
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localObject;
      for (;;)
      {
        localView = paramView;
        if (!(localContext instanceof ContextWrapper)) {
          break;
        }
        if ((localContext instanceof Activity)) {
          paramView = (Activity)localContext;
        }
        localContext = ((ContextWrapper)localContext).getBaseContext();
      }
    }
    if ((localView != null) && (localView.getWindow() != null))
    {
      paramView = localView.getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.d = paramView.getMeasuredHeight();
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, View paramView)
  {
    Activity localActivity = c();
    int i1 = a();
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = b();
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i1))
      {
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
        if (localIReadInJoyBaseAdapter != null) {
          localIReadInJoyBaseAdapter.notifyDataSetChanged();
        }
      }
      if (localIReadInJoyBaseAdapter != null)
      {
        localIReadInJoyBaseAdapter.a(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(localActivity, (AdvertisementInfo)paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i1, false, null));
        long l1;
        if (localIReadInJoyBaseAdapter.g() != null) {
          l1 = SystemClock.elapsedRealtime();
        } else {
          l1 = -2147483648L;
        }
        localIReadInJoyBaseAdapter.a(l1);
      }
      Object localObject;
      if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if (!(paramView instanceof ViewGroup)) {
          return;
        }
        if (localIReadInJoyBaseAdapter != null) {
          localObject = localIReadInJoyBaseAdapter.e();
        } else {
          localObject = null;
        }
        if (((paramView instanceof IProteusItemView)) && (ReadinJoyActionUtil.a(paramAbsBaseArticleInfo, ((IProteusItemView)paramView).getContainer().getVirtualView(), (Activity)localActivity, i1, (IVideoPlayManager)localObject, localAdvertisementInfo))) {
          return;
        }
      }
      if ((((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mFeedType == 2))
      {
        boolean bool = ReadinJoyActionUtil.a(paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter);
        paramView = (Activity)localActivity;
        localObject = (AdvertisementInfo)paramAbsBaseArticleInfo;
        paramView = ReadinJoyActionUtil.a(paramView, (AdvertisementInfo)localObject, localIReadInJoyBaseAdapter, i1, true, ReadInJoyAdSwitchUtil.e((AdvertisementInfo)localObject), new AdJumpParams(bool));
        if ((d() instanceof IReadInJoyListViewGroup)) {
          ReadinJoyActionUtil.a(c(), paramAbsBaseArticleInfo, a(), paramView);
        }
      }
      else if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo)) && (localIReadInJoyBaseAdapter != null) && (paramLong != -1L))
      {
        int i2 = localIReadInJoyBaseAdapter.getItemViewType((int)paramLong);
        if ((i2 != 39) && (i2 != 116) && (i2 != 66) && (i2 != 115))
        {
          ReadinJoyActionUtil.d(localActivity, (AdvertisementInfo)paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i1, false, null);
        }
        else
        {
          paramView = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
          paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
          paramView.doAppADJump(localActivity, paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i1, true, ReadInJoyAdSwitchUtil.e(paramAbsBaseArticleInfo));
        }
      }
      else
      {
        if (localIReadInJoyBaseAdapter == null) {
          return;
        }
        ReadinJoyActionUtil.a((Activity)localActivity, paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i1, null);
      }
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
    }
  }
  
  private void t()
  {
    if (u()) {
      this.o.postDelayed(new AdHandler.2(this), 1000);
    }
  }
  
  private boolean u()
  {
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = b();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localIReadInJoyBaseAdapter != null)
    {
      bool1 = bool2;
      if (b().h() != null)
      {
        bool1 = bool2;
        if (b().h().size() > 0)
        {
          bool1 = bool2;
          if (this.o != null) {
            if ((!ReadInJoyAdUtils.t((AbsBaseArticleInfo)b().h().get(0))) && (!ReadInJoyAdUtils.u((AbsBaseArticleInfo)b().h().get(0))))
            {
              bool1 = bool2;
              if (!ReadInJoyAdUtils.v((AbsBaseArticleInfo)b().h().get(0))) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void v()
  {
    int i1 = a();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((IReadInJoyListViewGroup)d()).getListView();
    long l1 = System.currentTimeMillis();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i1)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i1 = 0;
      while (i1 < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i1);
        if ((localView.getTag(2131449867) instanceof IReadInJoyModel))
        {
          localView = localView.findViewById(2131427698);
          if ((localView instanceof ReadInJoyAdVideoGuide)) {
            ((ReadInJoyAdVideoGuide)localView).c();
          }
        }
        i1 += 1;
      }
    }
    ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l1);
  }
  
  private void w()
  {
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = b();
    a();
    if (localIReadInJoyBaseAdapter != null)
    {
      localIReadInJoyBaseAdapter.a(-2147483648L);
      localIReadInJoyBaseAdapter.a(null);
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = a(paramInt).intValue();
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)b(paramInt);
    if (localAbsBaseArticleInfo != null) {
      localAbsBaseArticleInfo.mResolvedFeedType = i1;
    }
    paramViewGroup = null;
    AdHandler.ItemViewBuilder.a(this.b);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(i1)) {
      paramViewGroup = AdHandler.ItemViewBuilder.a(this.b, paramView, localAbsBaseArticleInfo, i1, paramInt);
    } else if (((ICellFactory)QRoute.api(ICellFactory.class)).cellRebuildCompleted(i1)) {
      paramViewGroup = AdHandler.ItemViewBuilder.b(this.b, paramView, localAbsBaseArticleInfo, i1, paramInt);
    }
    if ((b() != null) && (localAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)))
    {
      paramView = (AdvertisementInfo)localAbsBaseArticleInfo;
      ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).reportAnd1Px(paramView, b());
    }
    return paramViewGroup;
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    a(paramAbsBaseArticleInfo, -1L, paramView);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    paramView = ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).getReadInJoyAdapter(this);
    if (((paramListView instanceof ReadInJoyXListView)) && (paramView != null)) {
      ((ReadInJoyXListView)paramListView).setRefreshPullDistanceListener(new AdHandler.1(this, paramView));
    }
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.c = a();
    this.o = paramListView;
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setListView(new SoftReference(paramListView));
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).getReadInJoyAdapter(this);
    ExposureSupplementManager localExposureSupplementManager = n.a(this.c);
    paramListView = localExposureSupplementManager;
    if (localExposureSupplementManager == null)
    {
      paramListView = new ExposureSupplementManager(this.c);
      n.a(this.c, paramListView);
    }
    localIReadInJoyBaseAdapter.a(paramListView);
    ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).register(this.c, localIReadInJoyBaseAdapter);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    AdHandler.ItemViewBuilder.a(this.b);
    a(paramView);
    this.p = new SurpriseVideoHandler();
    this.p.a(this.o.getContext());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    b(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramAbsListView, paramInt1 + paramInt2 - 1);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = b((int)paramLong);
    if (((IArticleInfoHelper)QRoute.api(IArticleInfoHelper.class)).isBaseArticleInfo(paramAdapterView))
    {
      a((AbsBaseArticleInfo)paramAdapterView, paramLong, paramView);
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : onFeedsItemClick");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt == this.c)
    {
      if (b() == null) {
        return;
      }
      ReadInJoySuperMaskAdUtil.a().a(paramInt);
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (this.f))
    {
      AdvertisementInfo localAdvertisementInfo = this.k;
      if (localAdvertisementInfo != null)
      {
        localAdvertisementInfo.adStrategyType = 0;
        this.k = null;
      }
    }
    if (paramInt != 2) {
      bool = false;
    }
    this.g = bool;
    if (this.f)
    {
      this.f = false;
      paramAbsListView.setInterpolator(null);
    }
    paramAbsListView = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (paramAbsListView != null)
    {
      paramAbsListView = (ReadInjoyADExposureManager)paramAbsListView.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
      if (paramAbsListView != null) {
        paramAbsListView.a(paramInt);
      }
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = b();
    if (localObject1 != null)
    {
      Object localObject2 = (RecommendADVideoFeedsManager)((IReadInJoyBaseAdapter)localObject1).p();
      if (localObject2 != null) {
        ((RecommendADVideoFeedsManager)localObject2).a = true;
      }
      localObject2 = ((IReadInJoyBaseAdapter)localObject1).e();
      if ((localObject2 != null) && (((IVideoPlayManager)localObject2).a() != null))
      {
        VideoPlayParam localVideoPlayParam = ((IVideoPlayManager)localObject2).a();
        if ((localVideoPlayParam != null) && (localVideoPlayParam.M))
        {
          ((IVideoPlayManager)localObject2).a(ReportConstants.VideoEndType.EXIT_SCENE);
          ((IVideoPlayManager)localObject2).a(11);
        }
      }
      localObject1 = ((IReadInJoyBaseAdapter)localObject1).o();
      if (localObject1 != null) {
        ((IExposureSupplementManager)localObject1).g();
      }
      if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(this.c))
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneDaily");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneDaily");
      }
      if (this.c == 0)
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
      }
      if (56 == this.c)
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneVideoTab");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneVideoTab");
      }
      if (this.c == 0) {
        AdSessionManager.a().d();
      }
    }
  }
  
  protected void c(AbsListView paramAbsListView, int paramInt)
  {
    if (this.g)
    {
      if (this.f) {
        return;
      }
      float f1 = paramAbsListView.getFlingVelocityY();
      if ((f1 >= this.h) && (f1 <= this.i))
      {
        if ((this.e < paramInt) && (paramInt < paramAbsListView.getCount() - 1))
        {
          this.e = paramInt;
          Object localObject1 = (ListAdapter)paramAbsListView.getAdapter();
          int i1 = paramInt + 1;
          Object localObject2 = ((ListAdapter)localObject1).getItem(i1);
          if (((IArticleInfoHelper)QRoute.api(IArticleInfoHelper.class)).isBaseArticleInfo(localObject2))
          {
            if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) {
              return;
            }
            localObject2 = (AdvertisementInfo)localObject2;
            if (!ReadInJoyAdSwitchUtil.f((AdvertisementInfo)localObject2)) {
              return;
            }
            int i2 = ((ListAdapter)localObject1).getItemViewType(i1);
            View localView = (View)this.m.get(i2);
            if (localView == null)
            {
              localObject1 = ((ListAdapter)localObject1).getView(i1, null, paramAbsListView);
              this.m.put(i2, localObject1);
            }
            else
            {
              localObject1 = ((ListAdapter)localObject1).getView(i1, localView, paramAbsListView);
            }
            localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
            if ((localView != null) && (localObject1 != null))
            {
              i2 = paramAbsListView.getRemainFlingDisY();
              if (i2 <= 0) {
                return;
              }
              int i3 = localView.getBottom() - paramAbsListView.getBottom() - paramAbsListView.getPaddingBottom() + this.d;
              ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
              if (localLayoutParams != null) {
                i1 = localLayoutParams.width;
              } else {
                i1 = -1;
              }
              ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), i1), 0);
              i1 = ((View)localObject1).getMeasuredHeight();
              if ((i2 > i3) && (i2 < i3 + i1 / 1))
              {
                this.f = true;
                localObject1 = new AdHandler.4(this, localView, paramAbsListView, i2, i1);
                this.k = ((AdvertisementInfo)localObject2);
                this.k.adStrategyType = 1;
                if (Build.VERSION.SDK_INT >= 16) {
                  paramAbsListView.postOnAnimation((Runnable)localObject1);
                } else {
                  paramAbsListView.post((Runnable)localObject1);
                }
              }
            }
          }
          else
          {
            return;
          }
        }
        this.e = paramInt;
        return;
      }
      this.e = paramInt;
    }
  }
  
  public boolean d(int paramInt)
  {
    AdHandler.ItemViewBuilder.a(this.b);
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(paramInt);
  }
  
  public void j() {}
  
  public void k()
  {
    v();
    w();
    if (b() != null) {
      ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).doOnFeedsResume(b());
    }
    this.p.b();
  }
  
  public void l()
  {
    ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).kanDianPopupWindowDismiss(b());
    ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).doOnFeedsPause(b(), c());
    t();
    this.p.a();
  }
  
  public void n()
  {
    ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).unRegister(this.c);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
    ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).destroyDataFromFeeds(b());
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).close();
    AdMiniGameGuideManager.a.c();
  }
  
  public Boolean p()
  {
    return null;
  }
  
  public void q()
  {
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = b();
    if (localIReadInJoyBaseAdapter != null)
    {
      Object localObject = (RecommendADVideoFeedsManager)localIReadInJoyBaseAdapter.p();
      if (localObject != null) {
        ((RecommendADVideoFeedsManager)localObject).a = false;
      }
      localObject = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
      if (localObject != null)
      {
        localObject = (ReadInjoyADExposureManager)((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
        if (localObject != null)
        {
          ((ReadInjoyADExposureManager)localObject).a(localIReadInJoyBaseAdapter, localIReadInJoyBaseAdapter.a());
          ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).checkAndReportAdExposure(localIReadInJoyBaseAdapter);
        }
      }
    }
  }
  
  public int s()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler
 * JD-Core Version:    0.7.0.1
 */