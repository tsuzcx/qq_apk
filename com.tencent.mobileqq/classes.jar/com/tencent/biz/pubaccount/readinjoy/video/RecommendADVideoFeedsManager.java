package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAdVideoCompleteGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendADVideoFeedsManager
  implements VideoPlayManager.OnPlayStateListener, VideoUIManager.OnUIChangeListener
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  private VideoPlayManager.VideoPlayParam b = null;
  
  public RecommendADVideoFeedsManager(Activity paramActivity, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, VideoPlayManager paramVideoPlayManager, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new RecommendADVideoFeedsManager.1(this, Looper.getMainLooper());
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    if (((paramProteusItemView instanceof ReadInJoyAdVideoCompleteGuide)) && (paramProteusItemView.getNativeView() != null)) {
      ((ReadInJoyAdVideoGuide)((ReadInJoyAdVideoCompleteGuide)paramProteusItemView).getNativeView()).setVisibility(8);
    }
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    int i;
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131381651);
        if (((localObject instanceof ReadInJoyModelImpl)) && (((ReadInJoyModelImpl)localObject).a() == paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((localView instanceof ProteusItemView))) {
          a((ProteusItemView)localView);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, ProteusItemView paramProteusItemView)
  {
    Object localObject1 = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
    AdvertisementInfo localAdvertisementInfo;
    String str3;
    String str4;
    Object localObject2;
    if (((localObject1 instanceof ReadInJoyAdVideoCompleteGuide)) && (((ViewBase)localObject1).getNativeView() != null))
    {
      localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((ReadInJoyAdVideoCompleteGuide)localObject1).getNativeView();
      localAdvertisementInfo = (AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      localObject1 = "";
      str3 = "";
      str4 = "";
      localObject2 = str3;
    }
    try
    {
      String str2 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
      localObject3 = str4;
      String str1 = str3;
      localObject2 = str3;
      localObject1 = str2;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
      {
        localObject2 = str3;
        localObject1 = str2;
        JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
        localObject3 = str4;
        str1 = str3;
        if (localJSONArray != null)
        {
          localObject3 = str4;
          str1 = str3;
          localObject2 = str3;
          localObject1 = str2;
          if (localJSONArray.length() > 0)
          {
            localObject2 = str3;
            localObject1 = str2;
            localObject3 = localJSONArray.getJSONObject(0);
            localObject2 = str3;
            localObject1 = str2;
            str1 = ((JSONObject)localObject3).optString("thirdIcon");
            localObject2 = str1;
            localObject1 = str2;
            localObject3 = ((JSONObject)localObject3).optString("thirdName");
          }
        }
      }
      localObject1 = str2;
      localObject2 = str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RecommendADVideoFeedsManager", 1, "showGuideView, e=" + localJSONException.getMessage());
        Object localObject3 = "";
      }
    }
    localReadInJoyAdVideoGuide.setBtnInfo(localAdvertisementInfo.mAdBtnTxt);
    localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, (String)localObject2, (String)localObject3, (String)localObject1, ReadInJoyAdUtils.b(localAdvertisementInfo), localAdvertisementInfo);
    localReadInJoyAdVideoGuide.setAdGuideClickListener(new RecommendADVideoFeedsManager.3(this, localAdvertisementInfo, paramVideoPlayParam));
    localReadInJoyAdVideoGuide.setVisibility(0);
    paramVideoPlayParam = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_icon");
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.getNativeView() != null)) {
      paramVideoPlayParam.getNativeView().setVisibility(8);
    }
    paramVideoPlayParam = paramProteusItemView.a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.getNativeView() != null)) {
      paramVideoPlayParam.getNativeView().setVisibility(8);
    }
    localReadInJoyAdVideoGuide.b();
    localAdvertisementInfo.isShowingGuide = true;
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, ProteusItemView paramProteusItemView, Context paramContext)
  {
    if (paramVideoPlayParam == null) {}
    do
    {
      return;
      paramProteusItemView = paramProteusItemView.a();
    } while ((paramProteusItemView == null) || (paramProteusItemView.findViewById("id_top_left_mask") == null));
    paramVideoPlayParam.o = DisplayUtil.a(paramContext, 8.0F);
    paramVideoPlayParam.p = DisplayUtil.a(paramContext, 8.0F);
    paramVideoPlayParam.q = DisplayUtil.a(paramContext, 8.0F);
    paramVideoPlayParam.r = DisplayUtil.a(paramContext, 8.0F);
  }
  
  private void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    AdVideo185UIStateUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager);
    int i;
    if (paramVideoPlayParam != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramVideoPlayParam.jdField_a_of_type_Int), Integer.valueOf(7));
      if (QLog.isColorLevel()) {
        QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        Object localObject = localView.getTag(2131381651);
        if ((!(localObject instanceof ReadInJoyModelImpl)) || (((ReadInJoyModelImpl)localObject).a() != paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
          break label175;
        }
        localObject = (AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        if ((localView instanceof ProteusItemView)) {
          a(paramVideoPlayParam, (ProteusItemView)localView);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
      return;
      label175:
      i += 1;
    }
  }
  
  private void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    int i;
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
      i = 0;
    }
    for (;;)
    {
      View localView;
      Object localObject;
      boolean bool;
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        localObject = localView.getTag(2131381651);
        if ((!(localObject instanceof ReadInJoyModelImpl)) || (((ReadInJoyModelImpl)localObject).a() != paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(localView instanceof ProteusItemView))) {
          break label151;
        }
        localObject = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
      }
      else
      {
        return;
      }
      new Handler(Looper.getMainLooper()).postDelayed(new RecommendADVideoFeedsManager.2(this, (ViewBase)localObject, bool, localView), 300L);
      return;
      label151:
      i += 1;
    }
  }
  
  public VideoPlayManager.VideoPlayParam a(AdvertisementInfo paramAdvertisementInfo, View paramView, ReadInJoyModelImpl paramReadInJoyModelImpl)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (paramReadInJoyModelImpl == null)) {}
    while ((paramReadInJoyModelImpl.a() != 6) && (paramReadInJoyModelImpl.a() != 66) && (paramReadInJoyModelImpl.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    VideoPlayManager.VideoPlayParam localVideoPlayParam = ReadInJoyBaseAdapter.a(paramAdvertisementInfo);
    ViewBase localViewBase = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (localViewBase != null)
    {
      localVideoPlayParam.jdField_a_of_type_AndroidViewView = localViewBase.getNativeView();
      if (localViewBase.getNativeView() != null) {
        localVideoPlayParam.l = localViewBase.getNativeView().getWidth();
      }
    }
    localVideoPlayParam.jdField_a_of_type_Int = paramReadInJoyModelImpl.b;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    localVideoPlayParam.b = true;
    localVideoPlayParam.n = 1;
    a(localVideoPlayParam, paramView, this.jdField_a_of_type_AndroidAppActivity);
    return localVideoPlayParam;
  }
  
  public VideoPlayManager.VideoPlayParam a(boolean paramBoolean)
  {
    int i = 0;
    ReadInJoyModelImpl localReadInJoyModelImpl;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localReadInJoyModelImpl = (ReadInJoyModelImpl)((View)localObject1).getTag(2131381651);
        localObject2 = localReadInJoyModelImpl.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localReadInJoyModelImpl.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localReadInJoyModelImpl.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localReadInJoyModelImpl.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!ReadInJoyAdSwitchUtil.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localReadInJoyModelImpl);; localObject1 = null)
    {
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnCreate");
    }
    VideoUIManager localVideoUIManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    if (localVideoUIManager != null) {
      localVideoUIManager.b(this);
    }
  }
  
  public void a(Context paramContext, int paramInt1, AdvertisementInfo paramAdvertisementInfo, int paramInt2)
  {
    if (((paramInt1 == 15) || (paramInt1 == 16) || (paramInt1 == 17) || (paramInt1 == 1000)) && (paramAdvertisementInfo.mAdProductType == 6) && (ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2086, paramAdvertisementInfo)))
    {
      paramInt2 = (int)paramAdvertisementInfo.mChannelID;
      paramAdvertisementInfo.setClickPos(paramInt1);
      ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, paramInt2, 11, Integer.valueOf(6));
      if (paramInt2 == 0)
      {
        ReadInJoyLogicEngine.a().a(paramAdvertisementInfo.mArticleID, System.currentTimeMillis());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
        }
      }
    }
    do
    {
      return;
      if ((paramInt1 == 17) && (ReadInJoyAdUtils.b(paramAdvertisementInfo)))
      {
        ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo.mPopFormH5Url, paramAdvertisementInfo.mAdRl, paramAdvertisementInfo.mAdTraceId);
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(42).b(Integer.valueOf(5)).b(3).a(paramAdvertisementInfo));
        return;
      }
      if ((paramInt1 != 21) && (paramAdvertisementInfo.mImaxShowAdType == 1001))
      {
        ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
        ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, 0, 29, Integer.valueOf(23));
        return;
      }
      NativeAdUtils.a(new AdReportData().a(paramContext).a(1).b(3).b(Integer.valueOf(0)).a(paramAdvertisementInfo).c(paramInt1));
      if (paramInt1 != 21) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt2));
      paramAdvertisementInfo.isShowingGuide = false;
      paramAdvertisementInfo.isClickReplay = true;
      paramContext = a(false);
    } while (paramContext == null);
    a(null, paramContext);
    return;
    boolean bool4 = false;
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramAdvertisementInfo.mAdExt);
        String str = paramContext.optString("pkg_name");
        paramContext.optString("appid");
        bool1 = PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, str);
        bool2 = bool4;
        bool3 = bool1;
        QLog.e("RecommendADVideoFeedsManager", 1, "handleAdGuideClick, e=" + paramContext.getMessage());
      }
      catch (JSONException paramContext)
      {
        try
        {
          if (!TextUtils.isEmpty(str))
          {
            bool2 = ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, str);
            bool3 = bool1;
          }
          if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || ((!bool3) && (!bool2))) {
            break label501;
          }
          paramContext = null;
          if (!bool3) {
            paramContext = new AdJumpParams(false);
          }
          ReadInJoyAdUtils.a(paramAdvertisementInfo, paramInt1, null);
          ReadinJoyActionUtil.d(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, this.jdField_a_of_type_Int, false, paramContext);
          ReadInJoyLogicEngine.a().a(paramAdvertisementInfo.mArticleID, System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
          return;
        }
        catch (JSONException paramContext)
        {
          boolean bool1;
          boolean bool2;
          boolean bool3;
          break label461;
        }
        paramContext = paramContext;
        bool1 = false;
      }
      label461:
      bool2 = bool4;
      bool3 = bool1;
      continue;
      label501:
      ReadInJoyAdUtils.a(paramAdvertisementInfo, paramInt1, null);
      ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_Int, false, null);
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    AdVideo185UIStateUtil.a.a(paramVideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager, this);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramVideoPlayParam2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.b = paramVideoPlayParam2;
    VideoVolumeControl.a().b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramVideoPlayParam2);
    if ((paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramVideoPlayParam2.d);
      ((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramVideoPlayParam2.c + " playParams = " + paramVideoPlayParam2.toString());
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramVideoPlayParam + " videoPlayerWrapper = " + paramVideoPlayerWrapper + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7) {
      b(paramVideoPlayParam);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        c(paramVideoPlayParam);
      }
      return;
      a(paramVideoPlayParam);
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this);
  }
  
  public boolean a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_AndroidViewView;
      } while (paramVideoPlayParam == null);
      int i = paramVideoPlayParam.getHeight();
      Rect localRect = new Rect();
      paramVideoPlayParam.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) && (d <= 0.800000011920929D));
    return true;
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
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(this);
    VideoUIManager localVideoUIManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    if (localVideoUIManager != null) {
      localVideoUIManager.c(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager
 * JD-Core Version:    0.7.0.1
 */