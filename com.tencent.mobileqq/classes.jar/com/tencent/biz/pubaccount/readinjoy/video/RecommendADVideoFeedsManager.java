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
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
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
  public boolean a;
  private Activity b;
  private IReadInJoyBaseAdapter c;
  private ReadInJoyXListView d;
  private int e = -1;
  private IVideoPlayManager f;
  private VideoPlayParam g = null;
  private VideoPlayParam h = null;
  private ConcurrentHashMap<Integer, Integer> i = new ConcurrentHashMap();
  private Handler j;
  private RecommendADVideoFeedsBubbleManager k;
  private boolean l = false;
  
  public RecommendADVideoFeedsManager(Activity paramActivity, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, IVideoPlayManager paramIVideoPlayManager, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.b = paramActivity;
    this.c = paramIReadInJoyBaseAdapter;
    this.f = paramIVideoPlayManager;
    this.d = paramReadInJoyXListView;
    this.e = paramInt;
    this.j = new RecommendADVideoFeedsManager.1(this, Looper.getMainLooper());
    this.k = new RecommendADVideoFeedsBubbleManager();
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, VideoPlayParam paramVideoPlayParam)
  {
    if ((ReadInJoyAdUtils.t(paramAdvertisementInfo)) && (paramVideoPlayParam.d == null))
    {
      paramVideoPlayParam.y = "";
      paramVideoPlayParam.x = 5;
      paramVideoPlayParam.d = paramAdvertisementInfo.mAdVideoUrl;
    }
  }
  
  private void a(IProteusItemView paramIProteusItemView)
  {
    paramIProteusItemView = paramIProteusItemView.getContainer().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramIProteusItemView instanceof ReadInJoyAdVideoCompleteGuide)) && (paramIProteusItemView.getNativeView() != null))
    {
      ((ReadInJoyAdVideoGuide)((ReadInJoyAdVideoCompleteGuide)paramIProteusItemView).getNativeView()).setVisibility(8);
      this.l = false;
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, IProteusItemView paramIProteusItemView)
  {
    Object localObject2 = "";
    Object localObject1 = paramIProteusItemView.getContainer().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((localObject1 instanceof ReadInJoyAdVideoCompleteGuide)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((ReadInJoyAdVideoCompleteGuide)localObject1).getNativeView();
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramVideoPlayParam.D;
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
      this.l = true;
      paramVideoPlayParam = paramIProteusItemView.getContainer().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((paramVideoPlayParam != null) && (paramVideoPlayParam.getNativeView() != null)) {
        paramVideoPlayParam.getNativeView().setVisibility(8);
      }
      paramVideoPlayParam = paramIProteusItemView.getContainer().getVirtualView().findViewBaseByName("id_large_video_duration");
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
    paramIProteusItemView = paramIProteusItemView.getTemplateBean();
    if (paramIProteusItemView == null) {
      return;
    }
    if (paramIProteusItemView.findViewById("id_top_left_mask") != null)
    {
      if ((paramVideoPlayParam != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(paramVideoPlayParam.D)))
      {
        paramVideoPlayParam.R = DisplayUtil.a(paramContext, 0.0F);
        paramVideoPlayParam.T = DisplayUtil.a(paramContext, 0.0F);
      }
      else
      {
        paramVideoPlayParam.R = DisplayUtil.a(paramContext, 8.0F);
        paramVideoPlayParam.T = DisplayUtil.a(paramContext, 8.0F);
      }
      paramVideoPlayParam.U = DisplayUtil.a(paramContext, 8.0F);
      paramVideoPlayParam.S = DisplayUtil.a(paramContext, 8.0F);
    }
  }
  
  private void b(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (this.d != null))
    {
      int m = 0;
      while (m < this.d.getChildCount())
      {
        View localView = this.d.getChildAt(m);
        Object localObject = localView.getTag(2131449867);
        if (((localObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)localObject).k() == paramVideoPlayParam.D) && ((localView instanceof IProteusItemView)))
        {
          a((IProteusItemView)localView);
          return;
        }
        m += 1;
      }
    }
  }
  
  private void c(VideoPlayParam paramVideoPlayParam)
  {
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).handleCompleteState(this.f);
    if (paramVideoPlayParam != null)
    {
      this.i.put(Integer.valueOf(paramVideoPlayParam.e), Integer.valueOf(7));
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("RecommendADVideoFeedsManager mListPositionPlayStateMap ");
        ((StringBuilder)localObject1).append(this.i.toString());
        QLog.d("RecommendADVideoFeedsManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.d != null)
      {
        int m = 0;
        while (m < this.d.getChildCount())
        {
          localObject1 = this.d.getChildAt(m);
          Object localObject2 = ((View)localObject1).getTag(2131449867);
          if ((localObject2 instanceof IReadInJoyModel))
          {
            localObject2 = (IReadInJoyModel)localObject2;
            if ((((IReadInJoyModel)localObject2).k() == paramVideoPlayParam.D) && ((paramVideoPlayParam.D instanceof AdvertisementInfo)))
            {
              AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramVideoPlayParam.D;
              boolean bool = localObject1 instanceof IProteusItemView;
              if (bool) {
                if (((IReadInJoyModel)localObject2).o() == 153)
                {
                  this.j.removeMessages(3001);
                  this.j.sendEmptyMessageDelayed(3001, 250L);
                }
                else
                {
                  a(paramVideoPlayParam, (IProteusItemView)localObject1);
                }
              }
              if ((!bool) || (!ReadInJoyAdUtils.t(localAdvertisementInfo)) || (localAdvertisementInfo.isSmallCard)) {
                break;
              }
              this.j.removeMessages(3001);
              this.j.sendEmptyMessageDelayed(3001, 1000L);
              break;
            }
          }
          m += 1;
        }
        this.c.notifyDataSetChanged();
      }
    }
  }
  
  private void d(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (this.d != null))
    {
      int m = 0;
      while (m < this.d.getChildCount())
      {
        View localView = this.d.getChildAt(m);
        Object localObject = localView.getTag(2131449867);
        if (((localObject instanceof IReadInJoyModel)) && (((IReadInJoyModel)localObject).k() == paramVideoPlayParam.D) && ((localView instanceof IProteusItemView)))
        {
          localObject = ((IProteusItemView)localView).getContainer().getVirtualView().findViewBaseByName("id_large_video_icon");
          boolean bool = NetworkState.isWifiConn();
          if (((paramVideoPlayParam.D instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramVideoPlayParam.D).isHideForAnimate)) {
            return;
          }
          new Handler(Looper.getMainLooper()).postDelayed(new RecommendADVideoFeedsManager.2(this, (ViewBase)localObject, bool, localView), 300L);
          return;
        }
        m += 1;
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
        if ((paramIReadInJoyModel.o() != 6) && (paramIReadInJoyModel.o() != 66) && (paramIReadInJoyModel.o() != 115) && (paramIReadInJoyModel.o() != 148) && (paramIReadInJoyModel.o() != 151) && (paramIReadInJoyModel.o() != 152))
        {
          localObject = localViewBase;
          if (paramIReadInJoyModel.o() != 153) {}
        }
        else
        {
          paramView = (IProteusItemView)paramView;
          localObject = ((IReadInJoyBaseAdapterUtil)QRoute.api(IReadInJoyBaseAdapterUtil.class)).innerCreateVideoPlayParam(paramAdvertisementInfo);
          localViewBase = paramView.getContainer().getVirtualView().findViewBaseByName("id_article_large_imge");
          if (localViewBase != null)
          {
            ((VideoPlayParam)localObject).h = localViewBase.getNativeView();
            if (localViewBase.getNativeView() != null) {
              ((VideoPlayParam)localObject).N = localViewBase.getNativeView().getWidth();
            }
          }
          ((VideoPlayParam)localObject).e = paramIReadInJoyModel.r();
          ((VideoPlayParam)localObject).D = paramAdvertisementInfo;
          ((VideoPlayParam)localObject).M = true;
          ((VideoPlayParam)localObject).P = 1;
          a(paramAdvertisementInfo, (VideoPlayParam)localObject);
          a((VideoPlayParam)localObject, paramView, this.b);
        }
      }
    }
    return localObject;
  }
  
  public VideoPlayParam a(boolean paramBoolean)
  {
    int m = 0;
    while (m < this.d.getChildCount())
    {
      Object localObject1 = this.d.getChildAt(m);
      if ((localObject1 != null) && ((localObject1 instanceof IProteusItemView)))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)((View)localObject1).getTag(2131449867);
        Object localObject2 = localIReadInJoyModel.k();
        if (((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 6)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 66)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 115)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 148)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 151)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 152)) || ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && (localIReadInJoyModel.o() == 153)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isADVideoAutoPlayFlag((AdvertisementInfo)localObject2, null, this.c.a(), 1)))
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
      m += 1;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnCreate");
    }
    IVideoUIManager localIVideoUIManager = this.f.d();
    if (localIVideoUIManager != null) {
      localIVideoUIManager.a(this);
    }
  }
  
  public void a(Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    a(null, paramContext, paramInt1, paramAdvertisementInfo, paramInt2);
  }
  
  public void a(View paramView, Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    if (((paramInt1 == 15) || (paramInt1 == 16) || (paramInt1 == 17) || (paramInt1 == 1000)) && (paramAdvertisementInfo.mAdProductType == 6) && (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startMiniApp(this.b, 2086, paramAdvertisementInfo)))
    {
      paramInt2 = (int)paramAdvertisementInfo.mChannelID;
      paramAdvertisementInfo.setClickPos(paramInt1);
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(this.b, paramAdvertisementInfo, paramInt2, 11, Integer.valueOf(6));
      if (paramInt2 == 0)
      {
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAdvertisementInfo.mArticleID, System.currentTimeMillis());
        paramView = this.c;
        if (paramView != null) {
          paramView.notifyDataSetChanged();
        }
      }
      return;
    }
    if ((paramInt1 == 17) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramAdvertisementInfo)))
    {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(this.b, paramAdvertisementInfo.mPopFormH5Url, paramAdvertisementInfo.mAdRl, paramAdvertisementInfo.mAdTraceId);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.b).a(42).b(Integer.valueOf(5)).b(3).a(paramAdvertisementInfo));
      return;
    }
    if ((paramInt1 != 21) && (paramAdvertisementInfo.mImaxShowAdType == 1001))
    {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startImaxNativeLoadingPage(this.b, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(this.b, paramAdvertisementInfo, 0, 29, Integer.valueOf(23));
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(3).b(Integer.valueOf(0)).a(paramAdvertisementInfo).c(paramInt1));
    if (paramInt1 == 21)
    {
      this.i.remove(Integer.valueOf(paramInt2));
      paramAdvertisementInfo.isShowingGuide = false;
      paramAdvertisementInfo.isClickReplay = true;
      paramView = a(false);
      if (paramView != null) {
        a(null, paramView);
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
        bool1 = PackageUtil.a(this.b, (String)localObject);
        bool2 = bool1;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label554;
          }
          bool2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgExistSyn(this.b, (String)localObject);
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
      label554:
      boolean bool3 = false;
      boolean bool1 = bool2;
      bool2 = bool3;
      paramContext = new AdJumpParams();
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(paramAdvertisementInfo)) && (paramView != null))
      {
        paramContext.e = new Rect();
        paramView.getGlobalVisibleRect(paramContext.e);
        paramContext.f = 0;
      }
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) && ((bool1) || (bool2)))
      {
        if (!bool1) {
          paramContext.a = false;
        }
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, paramInt1, null);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).openAppFromGdtApi(this.b, paramAdvertisementInfo, null, this.e, false, paramContext);
      }
      else
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, paramInt1, null);
        if (LiujinAdJump.isFromLiuJin(paramAdvertisementInfo)) {
          LiujinAdJump.doJumpAction(paramAdvertisementInfo, this.b, false);
        } else {
          ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).gotoAdvVideoCellPage(this.b, paramAdvertisementInfo, this.c, this.e, false, paramContext);
        }
      }
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAdvertisementInfo.mArticleID, System.currentTimeMillis());
      this.c.notifyDataSetChanged();
    }
  }
  
  public void a(IVideoPlayManager paramIVideoPlayManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.f = paramIVideoPlayManager;
    this.f.a(this);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).onProgressUpdate(paramVideoPlayParam, this.f, this);
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
      c(paramVideoPlayParam);
    } else {
      b(paramVideoPlayParam);
    }
    if (paramInt2 == 0) {
      d(paramVideoPlayParam);
    }
    if ((paramInt1 == 2) && (paramInt2 == 3)) {
      this.k.a(paramVideoPlayParam, this.d, this.f);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    if ((paramVideoPlayParam2.D != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam2.D)) && (((AdvertisementInfo)paramVideoPlayParam2.D).isSmallCard)) {
      return;
    }
    if (!NetworkState.isWifiConn()) {
      return;
    }
    this.i.put(Integer.valueOf(paramVideoPlayParam2.e), Integer.valueOf(0));
    this.h = paramVideoPlayParam2;
    ((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).startAudioPlay();
    paramVideoPlayParam1 = paramVideoPlayParam2.D;
    if (((paramVideoPlayParam1 instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramVideoPlayParam1).mAdvertisementExtInfo.l == 1035))
    {
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).resetShake();
      paramVideoPlayParam2.k = 1L;
    }
    this.f.a(2);
    this.f.a(paramVideoPlayParam2);
    if ((paramVideoPlayParam2.D != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam2.D)))
    {
      ((AdvertisementInfo)paramVideoPlayParam2.D).adbt = ((int)paramVideoPlayParam2.k);
      ((AdvertisementInfo)paramVideoPlayParam2.D).adpa = 1;
      ((AdvertisementInfo)paramVideoPlayParam2.D).adpb = 1;
    }
    if (QLog.isColorLevel())
    {
      paramVideoPlayParam1 = new StringBuilder();
      paramVideoPlayParam1.append("playVideoForADVideo  vid: ");
      paramVideoPlayParam1.append(paramVideoPlayParam2.d);
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
      if (this.a) {
        return false;
      }
      paramVideoPlayParam = paramVideoPlayParam.h;
      if (paramVideoPlayParam == null) {
        return false;
      }
      int m = paramVideoPlayParam.getHeight();
      Rect localRect = new Rect();
      paramVideoPlayParam.getLocalVisibleRect(localRect);
      double d1 = localRect.height() * 1.0F / m;
      bool1 = bool2;
      if (d1 > 0.800000011920929D) {
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
    Object localObject = this.j;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(3001);
      this.j = null;
    }
    this.f.b(this);
    localObject = this.f.d();
    if (localObject != null) {
      ((IVideoUIManager)localObject).b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager
 * JD-Core Version:    0.7.0.1
 */