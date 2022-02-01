package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoPendantUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdStrategyReportData;
import com.tencent.mobileqq.kandian.biz.ad.report.VideoAdTimeReportData;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsHardAdBarManager
  implements IVideoFeedsHardAdBarManager
{
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private ADVideoFeedsGuideManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager;
  public GdtHandler.Params a;
  private IADVideoAppDownloadManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager;
  private IVideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private boolean h = false;
  
  public VideoFeedsHardAdBarManager(Context paramContext, boolean paramBoolean, Activity paramActivity, IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsHardAdBarManager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.h = paramBoolean;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter = paramIVideoFeedsAdapter;
  }
  
  private VideoAdInfo a(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder == null) {
      return null;
    }
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam == null) {
      return null;
    }
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a == null) {
      return null;
    }
    return paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo;
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if ((paramIVideoFeedsPlayManager != null) && (paramIVideoFeedsPlayManager.d())) {
      paramIVideoFeedsPlayManager.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(paramView, paramInt, paramVideoInfo);
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if ((paramVideoInfo.r) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof ADVideoItemHolder))) {
      a(paramView, (int)paramIVideoFeedsPlayManager.a(), paramVideoInfo, paramIVideoFeedsPlayManager);
    }
  }
  
  private void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367919: 
      h(paramVideoInfo, paramAdvertisementInfo, paramIVideoFeedsPlayManager);
      return;
    case 2131367910: 
      i(paramVideoInfo, paramAdvertisementInfo, paramIVideoFeedsPlayManager);
      return;
    case 2131367907: 
      g(paramVideoInfo, paramAdvertisementInfo, paramIVideoFeedsPlayManager);
      return;
    case 2131367900: 
      paramView = this.jdField_a_of_type_AndroidOsHandler;
      paramView.sendMessage(paramView.obtainMessage(7, Boolean.valueOf(false)));
      this.jdField_a_of_type_Boolean = true;
      return;
    case 2131367897: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 37, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 37);
      return;
    case 2131367895: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 34, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 34);
      return;
    case 2131367894: 
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 18);
      return;
    case 2131365869: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 2003, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131365865: 
    case 2131367896: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 35, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 35);
      return;
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 18, paramIVideoFeedsPlayManager);
    paramView = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramBaseItemHolder = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramView).a(paramBaseItemHolder).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).c(1000));
  }
  
  private void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    if (paramVideoInfo.r)
    {
      int i;
      if (paramAdvertisementInfo != null) {
        i = paramAdvertisementInfo.clickPos;
      } else {
        i = 1000;
      }
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) && (ReadInJoyAdSwitchUtil.d(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo)))
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager.a(paramVideoInfo);
        int j = 0;
        if (bool)
        {
          paramADVideoItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
          if (paramInt == 21)
          {
            ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramADVideoItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).c(i));
            return;
          }
          a(paramVideoInfo, i, paramADVideoItemHolder, false);
          return;
        }
        paramView.setVisibility(0);
        paramADVideoItemHolder.jdField_a_of_type_Boolean = true;
        if (paramVarArgs != null)
        {
          paramInt = j;
          while (paramInt < paramVarArgs.length)
          {
            paramVarArgs[paramInt].setVisibility(8);
            paramInt += 1;
          }
        }
        if (paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
          paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager.d();
        paramADVideoItemHolder.jdField_a_of_type_Boolean = true;
        AdVideoButtonUIUtils.a(paramADVideoItemHolder);
      }
    }
  }
  
  private void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", "clickDownloadBtn click");
      if (paramInt == 21)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(38);
        }
        paramADVideoItemHolder = new AdJumpParams();
        paramADVideoItemHolder.c = true;
        paramADVideoItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramADVideoItemHolder);
        paramAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramADVideoItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG).c(38));
        return;
      }
      paramInt = 8;
      if (this.d) {
        paramInt = 13;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoItemHolder = new AdJumpParams();
      paramADVideoItemHolder.c = true;
      a(paramVideoInfo, paramInt, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramADVideoItemHolder), false);
    }
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.r) {
      a(paramVideoInfo, 0, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null), false);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 10, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 10, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), true);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      paramBaseItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
      AdVideoButtonUIUtils.c(paramBaseItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, -1, paramBaseItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, new View[0]);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      int i = 13;
      if (bool)
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
        if (!this.d) {
          i = 8;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(i);
        }
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).b(Integer.valueOf(21)).a(paramAdvertisementInfo));
        return;
      }
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
      if (!this.d) {
        i = 8;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, i, paramIVideoFeedsPlayManager);
      paramBaseItemHolder = new View[1];
      paramBaseItemHolder[0] = localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (a(paramVideoInfo)) {
        paramBaseItemHolder = new View[0];
      }
      AdVideoButtonUIUtils.c(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      a(localADVideoItemHolder, paramVideoInfo, paramAdvertisementInfo, -1, paramBaseItemHolder, new View[0]);
    }
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, AdvertisementInfo paramAdvertisementInfo, int paramInt, JSONObject paramJSONObject)
  {
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(paramInt).a(paramAdvertisementInfo).a(a(paramVideoItemHolder)).e(paramJSONObject).a(Integer.valueOf(1)));
  }
  
  private boolean a(ADVideoItemHolder paramADVideoItemHolder)
  {
    return ((paramADVideoItemHolder.jdField_a_of_type_Int == 5) || (paramADVideoItemHolder.jdField_a_of_type_Int == 7)) && (!this.f) && (!this.jdField_a_of_type_Boolean) && (ReadInJoyAdSwitchUtil.b(paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo)) && (this.jdField_a_of_type_AndroidOsHandler != null) && ((!paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.e()) || (ReadInJoyAdUtils.b(paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a))) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.b);
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    boolean bool2 = false;
    if (paramVideoAdInfo == null) {
      return false;
    }
    paramVideoAdInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url))
    {
      bool1 = bool2;
      if (ReadInJoyAdSwitchUtil.d(paramVideoAdInfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(VideoInfo paramVideoInfo)
  {
    return ReadInJoyAdUtils.a(paramVideoInfo);
  }
  
  private void b(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null))
    {
      Object localObject = paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo;
      int i = ReadInJoyAdSwitchUtil.d(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo((VideoAdInfo)localObject));
      if (i == 1)
      {
        paramADVideoItemHolder = paramADVideoItemHolder.jdField_a_of_type_AndroidViewView;
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      else if (i == 2)
      {
        localObject = paramADVideoItemHolder.jdField_b_of_type_AndroidViewView;
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.weight = 0.0F;
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
        paramADVideoItemHolder = paramADVideoItemHolder.jdField_c_of_type_AndroidViewView;
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.r)
    {
      if (this.g)
      {
        this.g = false;
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 1, paramIVideoFeedsPlayManager);
        a(paramVideoInfo, 1, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), false);
        return;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 4, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 4, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(38);
        }
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).b(Integer.valueOf(21)).a(paramAdvertisementInfo));
      }
      else
      {
        ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
        paramBaseItemHolder = new View[2];
        paramBaseItemHolder[0] = localADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        paramBaseItemHolder[1] = localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        if (a(paramVideoInfo))
        {
          paramBaseItemHolder = new View[1];
          paramBaseItemHolder[0] = localADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        }
        AdVideoButtonUIUtils.c(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
        a(localADVideoItemHolder, paramVideoInfo, paramAdvertisementInfo, 21, paramBaseItemHolder, new View[0]);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)) {
        ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, true);
      }
    }
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramBaseItemHolder != null) && (paramVideoInfo != null))
    {
      if (paramAdvertisementInfo == null) {
        return;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
      paramBaseItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramBaseItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).c(paramInt));
    }
  }
  
  private boolean b(ADVideoItemHolder paramADVideoItemHolder)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = bool1;
    if (paramADVideoItemHolder != null)
    {
      bool2 = bool1;
      if (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
      {
        if (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a == null) {
          return true;
        }
        paramADVideoItemHolder = paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a;
        bool1 = bool3;
        if (paramADVideoItemHolder.r)
        {
          paramADVideoItemHolder = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
          bool1 = bool3;
          if (paramADVideoItemHolder != null)
          {
            bool1 = bool3;
            if (!paramADVideoItemHolder.mShowAdButton) {
              bool1 = false;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          paramADVideoItemHolder = new StringBuilder();
          paramADVideoItemHolder.append("showButton = ");
          paramADVideoItemHolder.append(bool1);
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", 2, paramADVideoItemHolder.toString());
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 3, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 3, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 2, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 2, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 2, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 2, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 1000, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 17, paramIVideoFeedsPlayManager);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo))
    {
      a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(17);
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).b(Integer.valueOf(21)).a(paramAdvertisementInfo).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.f();
    paramIVideoFeedsPlayManager = null;
    if (paramAdvertisementInfo != null) {
      paramIVideoFeedsPlayManager = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, 17, paramIVideoFeedsPlayManager, true);
  }
  
  private void h(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 16, paramIVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.f();
    a(paramVideoInfo, 16, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null), true);
  }
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 15, paramIVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.f();
    a(paramVideoInfo, 15, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null), true);
  }
  
  @Nullable
  public AdvertisementInfo a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramVideoInfo.r)
    {
      paramVideoInfo = ReadInJoyVideoFeedsAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ((GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, null, 3, paramBoolean, null));
      long l;
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {
        l = SystemClock.elapsedRealtime();
      } else {
        l = -2147483648L;
      }
      this.jdField_a_of_type_Long = l;
      return paramVideoInfo;
    }
    return null;
  }
  
  public AdvertisementInfo a(Object paramObject, boolean paramBoolean)
  {
    return a((VideoInfo)paramObject, paramBoolean);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().d()) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof ADVideoItemHolder))) {
      a(true, (ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a());
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof ADVideoItemHolder))
    {
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a();
      int i = ReadInJoyAdUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.v, false);
      Object localObject;
      if (((localADVideoItemHolder.jdField_a_of_type_Int == 5) || (localADVideoItemHolder.jdField_a_of_type_Int == 7)) && (paramLong >= i) && (!this.d))
      {
        localObject = this.jdField_a_of_type_AndroidOsHandler;
        if (localObject != null)
        {
          ((Handler)localObject).sendEmptyMessage(6);
          this.d = true;
          if (AdVideoPendantUIUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
          }
        }
      }
      if (a(localADVideoItemHolder))
      {
        int j = ReadInJoyAdUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.v, true);
        i = j;
        if (j < 0) {
          i = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyADGuideCardShowTime() * 1000;
        }
        j = i;
        if (a(localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a))
        {
          j = i;
          if (localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null) {
            j = 3000;
          }
        }
        if ((paramLong >= j) || (a(localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a)))
        {
          if (localADVideoItemHolder.d.getVisibility() == 0) {
            localADVideoItemHolder.d.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
          if ((localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a() != null))
          {
            localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("show card with currentState = ");
            localStringBuilder.append(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a().jdField_a_of_type_Int);
            ((IRIJAdLogService)localObject).d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
          }
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof BaseVideoItemHolder))
    {
      this.d = false;
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof ADVideoItemHolder))
    {
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a();
      Object localObject1 = localADVideoItemHolder.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = paramMessage.obj;
      paramMessage = localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo;
      AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramMessage);
      if (localObject2 != null)
      {
        this.f = true;
        if (localADVideoItemHolder.h != null) {
          localADVideoItemHolder.h.setVisibility(8);
        }
        if (ReadInJoyAdSwitchUtil.d(paramMessage))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager;
          if (localObject2 != null) {
            ((IADVideoAppDownloadManager)localObject2).a();
          }
        }
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator(localADVideoItemHolder.l, 250, 8, Utils.dp2px(200.0D));
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(ReportAction.CLOSE).a(1).b(21).b(Integer.valueOf(0)).a(localAdvertisementInfo).a(paramMessage).c(39));
        return;
      }
      if (this.b) {
        return;
      }
      localADVideoItemHolder = (ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a();
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
      if (!this.h) {
        AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      if (((ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a()).h != null)
      {
        a((ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a());
        ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a()).h.setVisibility(0);
      }
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator(((ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a()).l, 250, 0, 250, Utils.dp2px(200.0D));
      if (ReadInJoyAdSwitchUtil.d(paramMessage))
      {
        localObject1 = ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        if (localObject1 != null) {
          ((RIJDownloadView)localObject1).a(true);
        }
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(21).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG).a(localAdvertisementInfo).a(paramMessage));
    }
  }
  
  public void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    boolean bool;
    if ((paramView.getId() != 2131362106) && (paramView.getId() != 2131362108)) {
      bool = false;
    } else {
      bool = true;
    }
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo, bool);
    ADVideoItemHolder localADVideoItemHolder;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131368096: 
      e(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131365870: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 2004, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 2004);
      break;
    case 2131365869: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 2003, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 2003);
      break;
    case 2131365867: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4002, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4002);
      break;
    case 2131365866: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4001, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4001);
      break;
    case 2131365864: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4000, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4000);
      break;
    case 2131365862: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4007, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4007);
      break;
    case 2131362142: 
      f(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131362139: 
      b(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131362137: 
      a(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131362135: 
      c(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131362133: 
      d(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131362126: 
      a(paramView, paramVideoInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131362114: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 13, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      break;
    case 2131362111: 
      a(paramVideoInfo, localAdvertisementInfo);
      break;
    case 2131362108: 
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(localAdvertisementInfo)) && (RIJAdDownloadExKt.a(localAdvertisementInfo)))
      {
        localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
        localADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(38);
        localADVideoItemHolder.jdField_a_of_type_Boolean = true;
      }
      else
      {
        b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      }
      break;
    case 2131362106: 
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(localAdvertisementInfo)) && (!a(paramVideoInfo)) && (RIJAdDownloadExKt.a(localAdvertisementInfo)))
      {
        int i = 8;
        if (this.d) {
          i = 13;
        }
        localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
        localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i);
        localADVideoItemHolder.jdField_a_of_type_Boolean = true;
      }
      else
      {
        a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      }
      break;
    case 2131362103: 
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
    }
    a(paramView, paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
  }
  
  public void a(View paramView, BaseItemHolder paramBaseItemHolder, Object paramObject1, Object paramObject2)
  {
    a(paramView, paramBaseItemHolder, (VideoInfo)paramObject1, (IVideoFeedsPlayManager)paramObject2);
  }
  
  public void a(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null))
    {
      Object localObject = paramADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo;
      int i = ReadInJoyAdSwitchUtil.d(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo((VideoAdInfo)localObject));
      if (i == 1)
      {
        paramADVideoItemHolder = paramADVideoItemHolder.i;
        if (paramADVideoItemHolder != null)
        {
          localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
            paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
      else if (i == 2)
      {
        localObject = paramADVideoItemHolder.j;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramADVideoItemHolder = paramADVideoItemHolder.k;
        if (paramADVideoItemHolder != null)
        {
          localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
            paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
  }
  
  public void a(IADVideoAppDownloadManager paramIADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager = paramIADVideoAppDownloadManager;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo == null) {
        return;
      }
      Object localObject1 = Aladdin.getConfig(447).getString("fling_right_to_left", "0");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fling_right_to_left = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ReadInJoyAdLog.a("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (((String)localObject1).equals("0")) {
          return;
        }
        localObject1 = a(paramVideoInfo, false);
        ((AdvertisementInfo)localObject1).setClickPos(49);
        localObject2 = new AdJumpParams();
        ((AdJumpParams)localObject2).c = true;
        a(paramVideoInfo, 49, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, (AdJumpParams)localObject2), false);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    ActionEntity localActionEntity;
    if (paramBoolean) {
      localActionEntity = ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG;
    } else {
      localActionEntity = ActionEntity.Default;
    }
    AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
    int i;
    if (paramVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity)) {
      i = 10;
    } else {
      i = 5;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(i).b(paramInteger).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).c(paramInt).a(localActionEntity));
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramBaseItemHolder != null) && (paramVideoInfo != null))
    {
      if (paramAdvertisementInfo == null) {
        return;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
      paramBaseItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramBaseItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).c(paramInt).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, VideoItemHolder paramVideoItemHolder)
  {
    boolean bool3 = paramVideoItemHolder instanceof ADVideoItemHolder;
    if (!bool3) {
      return;
    }
    paramVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
    if ((paramBoolean) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)) {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.c();
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
    {
      bool1 = bool2;
      if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a != null)
      {
        bool1 = bool2;
        if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null) {
          bool1 = ReadInJoyAdSwitchUtil.d(paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
        }
      }
    }
    if ((paramVideoItemHolder.jdField_a_of_type_Boolean) && (bool1))
    {
      AdVideoButtonUIUtils.b(paramVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
      if (!this.h) {
        AdVideoButtonUIUtils.c(paramVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      if (a(paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a))
      {
        AdVideoButtonUIUtils.a(paramVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
        return;
      }
      AdVideoButtonUIUtils.a(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      return;
    }
    if (paramVideoItemHolder.d.getVisibility() == 8) {
      AdVideoButtonUIUtils.a(paramVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if ((paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null)) {
      if (a(paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a))
      {
        AdVideoButtonUIUtils.b(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
        AdVideoButtonUIUtils.a(paramVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
      }
      else if (b(paramVideoItemHolder))
      {
        AdVideoButtonUIUtils.b(paramVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
        AdVideoButtonUIUtils.a(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
        if (bool3) {
          AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoItemHolder);
        }
        AdVideoButtonUIUtils.a(paramBoolean, paramVideoItemHolder);
      }
      else
      {
        AdVideoButtonUIUtils.b(paramVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
        AdVideoButtonUIUtils.b(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      }
    }
    b(paramVideoItemHolder);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().d()) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof ADVideoItemHolder))) {
      AdVideoPendantUIUtils.a(true, (ADVideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(), this.h, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.e = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4, null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public void d()
  {
    int j = 0;
    this.e = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() instanceof VideoItemHolder))
    {
      VideoItemHolder localVideoItemHolder = (VideoItemHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a();
      if ((localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a != null) && (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.r) && (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null))
      {
        Object localObject = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.h;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
          localObject = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
          int i = 5;
          if (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.b(this.jdField_a_of_type_AndroidAppActivity)) {
            i = 10;
          }
          JSONObject localJSONObject1 = new JSONObject();
          JSONObject localJSONObject2 = new JSONObject();
          VideoAdTimeReportData localVideoAdTimeReportData = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportVideoAdTimeReportData;
          if ((VideoAdStrategyManager.jdField_a_of_type_Int == 1) && (localVideoAdTimeReportData != null)) {
            try
            {
              localJSONObject2.put("slot", localVideoAdTimeReportData.jdField_a_of_type_Int);
              localJSONObject2.put("stratege_time_b", localVideoAdTimeReportData.c);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          } else {
            try
            {
              if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() != null) {
                j = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().getHeaderViewsCount();
              }
              localJSONObject2.put("slot", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a().getAdapterPosition() - j);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
          try
          {
            VideoAdStrategyReportData localVideoAdStrategyReportData = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdStrategyReportData;
            localJSONObject2.put("last_ad_time", localVideoAdStrategyReportData.jdField_a_of_type_Long);
            localJSONObject2.put("last_ad_distance", localVideoAdStrategyReportData.jdField_a_of_type_Int);
            localJSONObject2.put("last_ad_distance_vv", localVideoAdStrategyReportData.b);
            localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("exposure_info_report = ");
          localStringBuilder.append(localJSONObject2.toString());
          localIRIJAdLogService.d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", localStringBuilder.toString());
          a(localVideoItemHolder, (AdvertisementInfo)localObject, i, localJSONObject1);
          AdReqFreshManager.a().a(Long.valueOf(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.e));
          AdExposeFreshManager.a().a("RIJAdRefreshSceneFloatVideo", localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a);
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager
 * JD-Core Version:    0.7.0.1
 */