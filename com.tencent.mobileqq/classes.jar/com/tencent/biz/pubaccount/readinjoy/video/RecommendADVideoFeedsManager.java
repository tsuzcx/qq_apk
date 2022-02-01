package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyAdVideoCompleteGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendADVideoFeedsManager
  implements IRecommendADVideoFeedsManager, OnPlayStateListener, OnUIChangeListener
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecommendADVideoFeedsBubbleManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsBubbleManager;
  private IReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter;
  private ReadInJoyXListView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
  private IVideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  private VideoPlayParam b = null;
  
  public RecommendADVideoFeedsManager(Activity paramActivity, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, IVideoPlayManager paramIVideoPlayManager, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager = paramIVideoPlayManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new RecommendADVideoFeedsManager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsBubbleManager = new RecommendADVideoFeedsBubbleManager();
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, VideoPlayParam paramVideoPlayParam)
  {
    if ((ReadInJoyAdUtils.r(paramAdvertisementInfo)) && (paramVideoPlayParam.c == null))
    {
      paramVideoPlayParam.j = "";
      paramVideoPlayParam.f = 5;
      paramVideoPlayParam.c = paramAdvertisementInfo.mAdVideoUrl;
    }
  }
  
  private void a(IProteusItemView paramIProteusItemView)
  {
    paramIProteusItemView = paramIProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramIProteusItemView instanceof ReadInJoyAdVideoCompleteGuide)) && (paramIProteusItemView.getNativeView() != null)) {
      ((ReadInJoyAdVideoGuide)((ReadInJoyAdVideoCompleteGuide)paramIProteusItemView).getNativeView()).setVisibility(8);
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131380884);
        if (((localObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)localObject).a() == paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo) && ((localView instanceof IProteusItemView)))
        {
          a((IProteusItemView)localView);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, IProteusItemView paramIProteusItemView)
  {
    Object localObject2 = "";
    Object localObject1 = paramIProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((localObject1 instanceof ReadInJoyAdVideoCompleteGuide)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((ReadInJoyAdVideoCompleteGuide)localObject1).getNativeView();
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      try
      {
        Object localObject3 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
        try
        {
          if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
          {
            localObject1 = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
            if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
            {
              localObject2 = ((JSONArray)localObject1).getJSONObject(0);
              localObject1 = ((JSONObject)localObject2).optString("thirdIcon");
              try
              {
                String str = ((JSONObject)localObject2).optString("thirdName");
                localObject2 = localObject1;
                localObject1 = str;
              }
              catch (JSONException localJSONException2)
              {
                localObject2 = localObject3;
                localObject3 = localJSONException2;
                break label200;
              }
            }
          }
          localObject1 = "";
          Object localObject5 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject5;
        }
        catch (JSONException localJSONException3)
        {
          localObject1 = "";
          localObject2 = localObject3;
          localObject3 = localJSONException3;
        }
        localObject6 = new StringBuilder();
      }
      catch (JSONException localJSONException1)
      {
        localObject2 = "";
        localObject1 = localObject2;
      }
      label200:
      ((StringBuilder)localObject6).append("showGuideView, e=");
      ((StringBuilder)localObject6).append(localJSONException1.getMessage());
      QLog.e("RecommendADVideoFeedsManager", 1, ((StringBuilder)localObject6).toString());
      Object localObject6 = "";
      Object localObject4 = localObject2;
      localObject2 = localObject6;
      localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, (String)localObject1, (String)localObject2, localObject4, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(localAdvertisementInfo), localAdvertisementInfo);
      localReadInJoyAdVideoGuide.setAdGuideClickListener(new RecommendADVideoFeedsManager.3(this, localAdvertisementInfo, paramVideoPlayParam));
      localReadInJoyAdVideoGuide.setVisibility(0);
      paramVideoPlayParam = paramIProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((paramVideoPlayParam != null) && (paramVideoPlayParam.getNativeView() != null)) {
        paramVideoPlayParam.getNativeView().setVisibility(8);
      }
      paramVideoPlayParam = paramIProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramVideoPlayParam != null) && (paramVideoPlayParam.getNativeView() != null)) {
        paramVideoPlayParam.getNativeView().setVisibility(8);
      }
      localReadInJoyAdVideoGuide.b();
      localAdvertisementInfo.isShowingGuide = true;
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, IProteusItemView paramIProteusItemView, Context paramContext)
  {
    if (paramVideoPlayParam == null) {
      return;
    }
    paramIProteusItemView = paramIProteusItemView.a();
    if (paramIProteusItemView == null) {
      return;
    }
    if (paramIProteusItemView.findViewById("id_top_left_mask") != null)
    {
      paramVideoPlayParam.o = DisplayUtil.a(paramContext, 8.0F);
      paramVideoPlayParam.p = DisplayUtil.a(paramContext, 8.0F);
      paramVideoPlayParam.q = DisplayUtil.a(paramContext, 8.0F);
      paramVideoPlayParam.r = DisplayUtil.a(paramContext, 8.0F);
    }
  }
  
  private void b(VideoPlayParam paramVideoPlayParam)
  {
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).handleCompleteState(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager);
    if (paramVideoPlayParam != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramVideoPlayParam.jdField_a_of_type_Int), Integer.valueOf(7));
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("RecommendADVideoFeedsManager mListPositionPlayStateMap ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
        QLog.d("RecommendADVideoFeedsManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount())
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(i);
          Object localObject2 = ((View)localObject1).getTag(2131380884);
          if (((localObject2 instanceof IReadInJoyModel)) && (((IReadInJoyModel)localObject2).a() == paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo) && ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof AdvertisementInfo)))
          {
            localObject2 = (AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
            boolean bool = localObject1 instanceof IProteusItemView;
            if (bool) {
              a(paramVideoPlayParam, (IProteusItemView)localObject1);
            }
            if ((!bool) || (!ReadInJoyAdUtils.r((AbsBaseArticleInfo)localObject2)) || (((AdvertisementInfo)localObject2).isSmallCard)) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3001, 1000L);
            break;
          }
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void c(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131380884);
        if (((localObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)localObject).a() == paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo) && ((localView instanceof IProteusItemView)))
        {
          localObject = ((IProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
          boolean bool = NetworkState.isWifiConn();
          if (((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).isHideForAnimate)) {
            return;
          }
          new Handler(Looper.getMainLooper()).postDelayed(new RecommendADVideoFeedsManager.2(this, (ViewBase)localObject, bool, localView), 300L);
          return;
        }
        i += 1;
      }
    }
  }
  
  public VideoPlayParam a(AdvertisementInfo paramAdvertisementInfo, View paramView, IReadInJoyModel paramIReadInJoyModel)
  {
    ViewBase localViewBase = null;
    Object localObject = localViewBase;
    if (paramAdvertisementInfo != null)
    {
      localObject = localViewBase;
      if (paramView != null)
      {
        if (paramIReadInJoyModel == null) {
          return null;
        }
        if ((paramIReadInJoyModel.d() != 6) && (paramIReadInJoyModel.d() != 66) && (paramIReadInJoyModel.d() != 115))
        {
          localObject = localViewBase;
          if (paramIReadInJoyModel.d() != 148) {}
        }
        else
        {
          paramView = (IProteusItemView)paramView;
          localObject = ((IReadInJoyBaseAdapterUtil)QRoute.api(IReadInJoyBaseAdapterUtil.class)).innerCreateVideoPlayParam(paramAdvertisementInfo);
          localViewBase = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
          if (localViewBase != null)
          {
            ((VideoPlayParam)localObject).jdField_a_of_type_AndroidViewView = localViewBase.getNativeView();
            if (localViewBase.getNativeView() != null) {
              ((VideoPlayParam)localObject).l = localViewBase.getNativeView().getWidth();
            }
          }
          ((VideoPlayParam)localObject).jdField_a_of_type_Int = paramIReadInJoyModel.g();
          ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAdvertisementInfo;
          ((VideoPlayParam)localObject).b = true;
          ((VideoPlayParam)localObject).n = 1;
          a(paramAdvertisementInfo, (VideoPlayParam)localObject);
          a((VideoPlayParam)localObject, paramView, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
    }
    return localObject;
  }
  
  public VideoPlayParam a(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount())
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof IProteusItemView)))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)((View)localObject1).getTag(2131380884);
        Object localObject2 = localIReadInJoyModel.a();
        if (((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.d() == 6)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.d() == 66)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.d() == 115)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.d() == 148)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isADVideoAutoPlayFlag((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.a(), 1)))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("isADVideoAutoPlayFlag false, AdvertisementInfo = ");
              ((StringBuilder)localObject1).append(((AdvertisementInfo)localObject2).toSString());
              QLog.d("RecommendADVideoFeedsManager", 2, ((StringBuilder)localObject1).toString());
            }
            return null;
          }
          return a((AdvertisementInfo)localObject2, (View)localObject1, localIReadInJoyModel);
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnCreate");
    }
    IVideoUIManager localIVideoUIManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.a();
    if (localIVideoUIManager != null) {
      localIVideoUIManager.a(this);
    }
  }
  
  public void a(Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    if (((paramInt1 == 15) || (paramInt1 == 16) || (paramInt1 == 17) || (paramInt1 == 1000)) && (paramAdvertisementInfo.mAdProductType == 6) && (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startMiniApp(this.jdField_a_of_type_AndroidAppActivity, 2086, paramAdvertisementInfo)))
    {
      paramInt2 = (int)paramAdvertisementInfo.mChannelID;
      paramAdvertisementInfo.setClickPos(paramInt1);
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, paramInt2, 11, Integer.valueOf(6));
      if (paramInt2 == 0)
      {
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAdvertisementInfo.mArticleID, System.currentTimeMillis());
        paramContext = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter;
        if (paramContext != null) {
          paramContext.notifyDataSetChanged();
        }
      }
      return;
    }
    if ((paramInt1 == 17) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramAdvertisementInfo)))
    {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo.mPopFormH5Url, paramAdvertisementInfo.mAdRl, paramAdvertisementInfo.mAdTraceId);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(42).b(Integer.valueOf(5)).b(3).a(paramAdvertisementInfo));
      return;
    }
    if ((paramInt1 != 21) && (paramAdvertisementInfo.mImaxShowAdType == 1001))
    {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startImaxNativeLoadingPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, 0, 29, Integer.valueOf(23));
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(3).b(Integer.valueOf(0)).a(paramAdvertisementInfo).c(paramInt1));
    if (paramInt1 == 21)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt2));
      paramAdvertisementInfo.isShowingGuide = false;
      paramAdvertisementInfo.isClickReplay = true;
      paramContext = a(false);
      if (paramContext != null) {
        a(null, paramContext);
      }
    }
    else
    {
      Object localObject;
      try
      {
        paramContext = new JSONObject(paramAdvertisementInfo.mAdExt);
        localObject = paramContext.optString("pkg_name");
        paramContext.optString("appid");
        bool1 = PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject);
        bool2 = bool1;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label535;
          }
          bool2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgExistSyn(this.jdField_a_of_type_AndroidAppActivity, (String)localObject);
        }
        catch (JSONException paramContext) {}
        localObject = new StringBuilder();
      }
      catch (JSONException paramContext)
      {
        bool1 = false;
      }
      ((StringBuilder)localObject).append("handleAdGuideClick, e=");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("RecommendADVideoFeedsManager", 1, ((StringBuilder)localObject).toString());
      boolean bool2 = bool1;
      label535:
      boolean bool3 = false;
      boolean bool1 = bool2;
      bool2 = bool3;
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) && ((bool1) || (bool2)))
      {
        if (!bool1) {
          paramContext = new AdJumpParams(false);
        } else {
          paramContext = null;
        }
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, paramInt1, null);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).openAppFromGdtApi(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, this.jdField_a_of_type_Int, false, paramContext);
      }
      else
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, paramInt1, null);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).gotoAdvVideoCellPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter, this.jdField_a_of_type_Int, false, null);
      }
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAdvertisementInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(IVideoPlayManager paramIVideoPlayManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager = paramIVideoPlayManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.a(this);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).onProgressUpdate(paramVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager, this);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("RecommendADVideoFeedsManager onStateChange: videoPlayParam ");
      paramObject.append(paramVideoPlayParam);
      paramObject.append(" videoPlayerWrapper = ");
      paramObject.append(paramIVideoPlayerWrapper);
      paramObject.append(" oldState");
      paramObject.append(paramInt1);
      paramObject.append(" newState = ");
      paramObject.append(paramInt2);
      QLog.d("RecommendADVideoFeedsManager", 2, paramObject.toString());
    }
    if (paramInt2 == 7) {
      b(paramVideoPlayParam);
    } else {
      a(paramVideoPlayParam);
    }
    if (paramInt2 == 0) {
      c(paramVideoPlayParam);
    }
    if ((paramInt1 == 2) && (paramInt2 == 3)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsBubbleManager.a(paramVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    if ((paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).isSmallCard)) {
      return;
    }
    if (!NetworkState.isWifiConn()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramVideoPlayParam2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.b = paramVideoPlayParam2;
    ((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).startAudioPlay();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.a(2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.a(paramVideoPlayParam2);
    if ((paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).adbt = ((int)paramVideoPlayParam2.d);
      ((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel())
    {
      paramVideoPlayParam1 = new StringBuilder();
      paramVideoPlayParam1.append("playVideoForADVideo  vid: ");
      paramVideoPlayParam1.append(paramVideoPlayParam2.c);
      paramVideoPlayParam1.append(" playParams = ");
      paramVideoPlayParam1.append(paramVideoPlayParam2.toString());
      QLog.d("RecommendADVideoFeedsManager", 2, paramVideoPlayParam1.toString());
    }
  }
  
  public boolean a(VideoPlayParam paramVideoPlayParam)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoPlayParam != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        return false;
      }
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_AndroidViewView;
      if (paramVideoPlayParam == null) {
        return false;
      }
      int i = paramVideoPlayParam.getHeight();
      Rect localRect = new Rect();
      paramVideoPlayParam.getLocalVisibleRect(localRect);
      double d = localRect.height() * 1.0F / i;
      bool1 = bool2;
      if (d > 0.800000011920929D) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnResume");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnPause");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager destroy");
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(3001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.b(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.a();
    if (localObject != null) {
      ((IVideoUIManager)localObject).b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager
 * JD-Core Version:    0.7.0.1
 */