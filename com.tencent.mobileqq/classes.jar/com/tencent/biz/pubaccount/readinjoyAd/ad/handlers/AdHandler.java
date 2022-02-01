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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.lang.ref.SoftReference;
import java.util.List;

public class AdHandler
  extends AdBaseHandler
{
  private static ExposureSupplementManager.ExposureSupplementUtilManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementManager$ExposureSupplementUtilManager = new ExposureSupplementManager.ExposureSupplementUtilManager();
  private float jdField_a_of_type_Float = DeviceInfoUtil.e() * 500 / 160.0F;
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
  private AdHandler.ItemViewBuilder jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder = new AdHandler.ItemViewBuilder(this);
  protected ReadInJoyObserver a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = DeviceInfoUtil.e() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  
  public AdHandler()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new AdHandler.3(this);
  }
  
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
        this.jdField_b_of_type_Int = paramView.getMeasuredHeight();
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, View paramView)
  {
    Activity localActivity = a();
    int i = a();
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = a();
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i))
      {
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
        if (localIReadInJoyBaseAdapter != null) {
          localIReadInJoyBaseAdapter.notifyDataSetChanged();
        }
      }
      if (localIReadInJoyBaseAdapter != null)
      {
        localIReadInJoyBaseAdapter.a(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(localActivity, (AdvertisementInfo)paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i, false, null));
        long l;
        if (localIReadInJoyBaseAdapter.a() != null) {
          l = SystemClock.elapsedRealtime();
        } else {
          l = -2147483648L;
        }
        localIReadInJoyBaseAdapter.a(l);
      }
      Object localObject;
      if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if (!(paramView instanceof ViewGroup)) {
          return;
        }
        if (localIReadInJoyBaseAdapter != null) {
          localObject = localIReadInJoyBaseAdapter.a();
        } else {
          localObject = null;
        }
        if (((paramView instanceof IProteusItemView)) && (ReadinJoyActionUtil.a(paramAbsBaseArticleInfo, ((IProteusItemView)paramView).a().getVirtualView(), (Activity)localActivity, i, (IVideoPlayManager)localObject, localAdvertisementInfo))) {
          return;
        }
      }
      if ((((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mFeedType == 2))
      {
        boolean bool = ReadinJoyActionUtil.a(paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter);
        paramView = (Activity)localActivity;
        localObject = (AdvertisementInfo)paramAbsBaseArticleInfo;
        paramView = ReadinJoyActionUtil.a(paramView, (AdvertisementInfo)localObject, localIReadInJoyBaseAdapter, i, true, ReadInJoyAdSwitchUtil.b((AdvertisementInfo)localObject), new AdJumpParams(bool));
        if ((a() instanceof IReadInJoyListViewGroup)) {
          ReadinJoyActionUtil.a(a(), paramAbsBaseArticleInfo, a(), paramView);
        }
      }
      else if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo)) && (localIReadInJoyBaseAdapter != null) && (paramLong != -1L))
      {
        int j = localIReadInJoyBaseAdapter.getItemViewType((int)paramLong);
        if ((j != 39) && (j != 116) && (j != 66) && (j != 115))
        {
          ReadinJoyActionUtil.c(localActivity, (AdvertisementInfo)paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i, false, null);
        }
        else
        {
          paramView = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
          paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
          paramView.doAppADJump(localActivity, paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i, true, ReadInJoyAdSwitchUtil.b(paramAbsBaseArticleInfo));
        }
      }
      else
      {
        if (localIReadInJoyBaseAdapter == null) {
          return;
        }
        ReadinJoyActionUtil.a((Activity)localActivity, paramAbsBaseArticleInfo, localIReadInJoyBaseAdapter, i, null);
      }
      QZLog.i("AdHandler", 4, "AdHandler processAdClickEvent");
    }
  }
  
  private boolean b()
  {
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localIReadInJoyBaseAdapter != null)
    {
      bool1 = bool2;
      if (a().b() != null)
      {
        bool1 = bool2;
        if (a().b().size() > 0)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentWidgetListView != null) {
            if ((!ReadInJoyAdUtils.r((AbsBaseArticleInfo)a().b().get(0))) && (!ReadInJoyAdUtils.s((AbsBaseArticleInfo)a().b().get(0))))
            {
              bool1 = bool2;
              if (!ReadInJoyAdUtils.t((AbsBaseArticleInfo)a().b().get(0))) {}
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
  
  private void i()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(new AdHandler.2(this), 1000);
    }
  }
  
  private void j()
  {
    int i = a();
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)((IReadInJoyListViewGroup)a()).a();
    long l = System.currentTimeMillis();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(i)) && (localReadInJoyXListView != null) && (localReadInJoyXListView.getChildCount() > 0))
    {
      i = 0;
      while (i < localReadInJoyXListView.getChildCount())
      {
        View localView = localReadInJoyXListView.getChildAt(i);
        if ((localView.getTag(2131380884) instanceof IReadInJoyModel))
        {
          localView = localView.findViewById(2131362119);
          if ((localView instanceof ReadInJoyAdVideoGuide)) {
            ((ReadInJoyAdVideoGuide)localView).c();
          }
        }
        i += 1;
      }
    }
    ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", "refreshADVideoFeedsDownloadState", System.currentTimeMillis() - l);
  }
  
  private void k()
  {
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = a();
    a();
    if (localIReadInJoyBaseAdapter != null)
    {
      localIReadInJoyBaseAdapter.a(-2147483648L);
      localIReadInJoyBaseAdapter.a(null);
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)a(paramInt);
    if (localAbsBaseArticleInfo != null) {
      localAbsBaseArticleInfo.mResolvedFeedType = i;
    }
    paramViewGroup = null;
    AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(i)) {
      paramViewGroup = AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder, paramView, localAbsBaseArticleInfo, i, paramInt);
    } else if (((ICellFactory)QRoute.api(ICellFactory.class)).cellRebuildCompleted(i)) {
      paramViewGroup = AdHandler.ItemViewBuilder.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder, paramView, localAbsBaseArticleInfo, i, paramInt);
    }
    if ((a() != null) && (localAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)))
    {
      paramView = (AdvertisementInfo)localAbsBaseArticleInfo;
      ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).reportAnd1Px(paramView, a());
    }
    return paramViewGroup;
  }
  
  public Boolean a()
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = (RecommendADVideoFeedsManager)((IReadInJoyBaseAdapter)localObject1).b();
      if (localObject2 != null) {
        ((RecommendADVideoFeedsManager)localObject2).jdField_a_of_type_Boolean = true;
      }
      localObject2 = ((IReadInJoyBaseAdapter)localObject1).a();
      if ((localObject2 != null) && (((IVideoPlayManager)localObject2).a() != null))
      {
        VideoPlayParam localVideoPlayParam = ((IVideoPlayManager)localObject2).a();
        if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_b_of_type_Boolean))
        {
          ((IVideoPlayManager)localObject2).a(ReportConstants.VideoEndType.EXIT_SCENE);
          ((IVideoPlayManager)localObject2).a(11);
        }
      }
      localObject1 = ((IReadInJoyBaseAdapter)localObject1).a();
      if (localObject1 != null) {
        ((IExposureSupplementManager)localObject1).f();
      }
      if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(this.jdField_a_of_type_Int))
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneDaily");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneDaily");
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
      }
      if (56 == this.jdField_a_of_type_Int)
      {
        AdReqFreshManager.a().a("RIJAdRefreshSceneVideoTab");
        AdExposeFreshManager.a().a("RIJAdRefreshSceneVideoTab");
      }
      if (this.jdField_a_of_type_Int == 0) {
        AdSessionManager.a().a();
      }
    }
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
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setListView(new SoftReference(paramListView));
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).getReadInJoyAdapter(this);
    ExposureSupplementManager localExposureSupplementManager = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementManager$ExposureSupplementUtilManager.a(this.jdField_a_of_type_Int);
    paramListView = localExposureSupplementManager;
    if (localExposureSupplementManager == null)
    {
      paramListView = new ExposureSupplementManager(this.jdField_a_of_type_Int);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsExposureSupplementManager$ExposureSupplementUtilManager.a(this.jdField_a_of_type_Int, paramListView);
    }
    localIReadInJoyBaseAdapter.a(paramListView);
    ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).register(this.jdField_a_of_type_Int, localIReadInJoyBaseAdapter);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder);
    a(paramView);
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
    paramAdapterView = a((int)paramLong);
    if (((IArticleInfoHelper)QRoute.api(IArticleInfoHelper.class)).isBaseArticleInfo(paramAdapterView))
    {
      a((AbsBaseArticleInfo)paramAdapterView, paramLong, paramView);
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : onFeedsItemClick");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if (a() == null) {
        return;
      }
      ReadInJoySuperMaskAdUtil.a().a(paramInt);
    }
  }
  
  public boolean a(int paramInt)
  {
    AdHandler.ItemViewBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler$ItemViewBuilder);
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(paramInt);
  }
  
  public void b()
  {
    j();
    k();
    if (a() != null) {
      ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).doOnFeedsResume(a());
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean))
    {
      AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if (localAdvertisementInfo != null)
      {
        localAdvertisementInfo.adStrategyType = 0;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
      }
    }
    if (paramInt != 2) {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
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
  
  public void c()
  {
    ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).kanDianPopupWindowDismiss(a());
    ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).doOnFeedsPause(a(), a());
    i();
  }
  
  protected void c(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      float f = paramAbsListView.getFlingVelocityY();
      if ((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_b_of_type_Float))
      {
        if ((this.jdField_c_of_type_Int < paramInt) && (paramInt < paramAbsListView.getCount() - 1))
        {
          this.jdField_c_of_type_Int = paramInt;
          Object localObject1 = (ListAdapter)paramAbsListView.getAdapter();
          int i = paramInt + 1;
          Object localObject2 = ((ListAdapter)localObject1).getItem(i);
          if (((IArticleInfoHelper)QRoute.api(IArticleInfoHelper.class)).isBaseArticleInfo(localObject2))
          {
            if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) {
              return;
            }
            localObject2 = (AdvertisementInfo)localObject2;
            if (!ReadInJoyAdSwitchUtil.c((AdvertisementInfo)localObject2)) {
              return;
            }
            int j = ((ListAdapter)localObject1).getItemViewType(i);
            View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
            if (localView == null)
            {
              localObject1 = ((ListAdapter)localObject1).getView(i, null, paramAbsListView);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject1);
            }
            else
            {
              localObject1 = ((ListAdapter)localObject1).getView(i, localView, paramAbsListView);
            }
            localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
            if ((localView != null) && (localObject1 != null))
            {
              j = paramAbsListView.getRemainFlingDisY();
              if (j <= 0) {
                return;
              }
              int k = localView.getBottom() - paramAbsListView.getBottom() - paramAbsListView.getPaddingBottom() + this.jdField_b_of_type_Int;
              ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
              if (localLayoutParams != null) {
                i = localLayoutParams.width;
              } else {
                i = -1;
              }
              ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), i), 0);
              i = ((View)localObject1).getMeasuredHeight();
              if ((j > k) && (j < k + i / 1))
              {
                this.jdField_a_of_type_Boolean = true;
                localObject1 = new AdHandler.4(this, localView, paramAbsListView, j, i);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)localObject2);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adStrategyType = 1;
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
        this.jdField_c_of_type_Int = paramInt;
        return;
      }
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  public int d()
  {
    return 1;
  }
  
  public void e()
  {
    ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).unRegister(this.jdField_a_of_type_Int);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ((IBaseUiBridge)QRoute.api(IBaseUiBridge.class)).destroyDataFromFeeds(a());
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).close();
    AdMiniGameGuideManager.a.c();
  }
  
  public void g()
  {
    IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = a();
    if (localIReadInJoyBaseAdapter != null)
    {
      Object localObject = (RecommendADVideoFeedsManager)localIReadInJoyBaseAdapter.b();
      if (localObject != null) {
        ((RecommendADVideoFeedsManager)localObject).jdField_a_of_type_Boolean = false;
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
      try
      {
        if ((b()) && (!ReadInJoyAdUtils.r((AbsBaseArticleInfo)a().b().get(0))) && (!ReadInJoyAdUtils.s((AbsBaseArticleInfo)a().b().get(0))))
        {
          ReadInJoyLogicEngineEventDispatcher.a().a(null);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onAdTopBitmap error ");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.e("AdHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler
 * JD-Core Version:    0.7.0.1
 */