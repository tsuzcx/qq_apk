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
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoPendantUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class VideoFeedsHardAdBarManager
{
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  public ADVideoAppDownloadManager a;
  private ADVideoFeedsGuideManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager;
  public GdtHandler.Params a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private boolean h = false;
  
  public VideoFeedsHardAdBarManager(Context paramContext, boolean paramBoolean, Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsHardAdBarManager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.h = paramBoolean;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
  }
  
  private VideoAdInfo a(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder == null) {}
    while ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a == null)) {
      return null;
    }
    return paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if ((paramVideoFeedsPlayManager != null) && (paramVideoFeedsPlayManager.d())) {
      paramVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if ((paramVideoInfo.c) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ADVideoItemHolder))) {
      a(paramView, (int)paramVideoFeedsPlayManager.a(), paramVideoInfo, paramVideoFeedsPlayManager);
    }
  }
  
  private void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368147: 
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, Boolean.valueOf(false)));
      this.jdField_a_of_type_Boolean = true;
      return;
    case 2131368157: 
      i(paramVideoInfo, paramAdvertisementInfo, paramVideoFeedsPlayManager);
      return;
    case 2131368166: 
      h(paramVideoInfo, paramAdvertisementInfo, paramVideoFeedsPlayManager);
      return;
    case 2131368154: 
      g(paramVideoInfo, paramAdvertisementInfo, paramVideoFeedsPlayManager);
      return;
    case 2131368144: 
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 37, paramVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 37);
      return;
    case 2131368142: 
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 34, paramVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 34);
      return;
    case 2131366035: 
    case 2131368143: 
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 35, paramVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 35);
      return;
    case 2131366039: 
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 2003, paramVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131362092: 
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 18, paramVideoFeedsPlayManager);
      paramView = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      paramBaseItemHolder = NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramView).a(paramBaseItemHolder).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(1000));
      return;
    }
    a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 18);
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = NativeAdUtils.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.c) {
      a(paramVideoInfo, 0, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoInfo.c)
    {
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 10, paramVideoFeedsPlayManager);
      a(paramVideoInfo, 10, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    if (paramVideoInfo.c) {
      if (paramAdvertisementInfo == null) {
        break label200;
      }
    }
    label200:
    for (int i = paramAdvertisementInfo.clickPos;; i = 1000)
    {
      if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (ReadInJoyAdSwitchUtil.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
          break label121;
        }
        paramADVideoItemHolder = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
        if (paramInt == 21) {
          NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramADVideoItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(i));
        }
      }
      else
      {
        return;
      }
      a(paramVideoInfo, i, paramADVideoItemHolder);
      return;
      label121:
      paramView.setVisibility(0);
      paramADVideoItemHolder.jdField_a_of_type_Boolean = true;
      if (paramVarArgs != null)
      {
        paramInt = 0;
        while (paramInt < paramVarArgs.length)
        {
          paramVarArgs[paramInt].setVisibility(8);
          paramInt += 1;
        }
      }
      if (paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) {
        paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.d();
      paramADVideoItemHolder.jdField_a_of_type_Boolean = true;
      AdVideoButtonUIUtils.a(paramADVideoItemHolder);
      return;
    }
  }
  
  private void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    if (paramVideoInfo.c)
    {
      ReadInJoyAdLog.a("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", "clickDownloadBtn click");
      if (paramInt == 21)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(38);
        }
        paramADVideoItemHolder = new AdJumpParams();
        paramADVideoItemHolder.c = true;
        paramADVideoItemHolder = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramADVideoItemHolder);
        paramAdvertisementInfo = NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramADVideoItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(38));
      }
    }
    else
    {
      return;
    }
    if (this.d) {}
    for (paramInt = 13;; paramInt = 8)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoItemHolder = new AdJumpParams();
      paramADVideoItemHolder.c = true;
      a(paramVideoInfo, paramInt, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramADVideoItemHolder));
      return;
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
  
  private void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
      {
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).b(Integer.valueOf(5)).a(paramAdvertisementInfo));
      }
    }
    else {
      return;
    }
    ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
    int i = 8;
    if (this.d) {
      i = 13;
    }
    ReadInJoyAdUtils.a(paramAdvertisementInfo, i, paramVideoFeedsPlayManager);
    paramBaseItemHolder = new View[1];
    paramBaseItemHolder[0] = localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (a(paramVideoInfo)) {
      paramBaseItemHolder = new View[0];
    }
    AdVideoButtonUIUtils.c(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
    a(localADVideoItemHolder, paramVideoInfo, paramAdvertisementInfo, -1, paramBaseItemHolder, new View[0]);
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, AdvertisementInfo paramAdvertisementInfo, int paramInt, JSONObject paramJSONObject)
  {
    NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(paramInt).a(paramAdvertisementInfo).a(a(paramVideoItemHolder)).e(paramJSONObject).a(Integer.valueOf(2)).b(true));
    NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(paramInt).a(paramAdvertisementInfo).a(a(paramVideoItemHolder)).e(paramJSONObject).a(Integer.valueOf(1)));
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return false;
      paramVideoAdInfo = NativeAdUtils.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!ReadInJoyAdSwitchUtil.d(paramVideoAdInfo)));
    return true;
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return ReadInJoyAdUtils.a(paramVideoInfo);
  }
  
  private boolean a(ADVideoItemHolder paramADVideoItemHolder)
  {
    int i = paramADVideoItemHolder.jdField_a_of_type_Int;
    VideoFeedsAdapter localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
    if (i != 5)
    {
      i = paramADVideoItemHolder.jdField_a_of_type_Int;
      localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
      if (i != 7) {}
    }
    else if ((!this.f) && (!this.jdField_a_of_type_Boolean) && (ReadInJoyAdSwitchUtil.b(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (this.jdField_a_of_type_AndroidOsHandler != null) && ((!paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.e()) || (ReadInJoyAdUtils.b(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a))) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.b))
    {
      return true;
    }
    return false;
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoInfo.c)
    {
      if (this.g)
      {
        this.g = false;
        ReadInJoyAdUtils.a(paramAdvertisementInfo, 1, paramVideoFeedsPlayManager);
        a(paramVideoInfo, 1, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
      }
    }
    else {
      return;
    }
    ReadInJoyAdUtils.a(paramAdvertisementInfo, 4, paramVideoFeedsPlayManager);
    a(paramVideoInfo, 4, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
  }
  
  private void b(ADVideoItemHolder paramADVideoItemHolder)
  {
    int i;
    Object localObject;
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i = ReadInJoyAdSwitchUtil.d(NativeAdUtils.a(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i != 1) {
        break label84;
      }
      paramADVideoItemHolder = paramADVideoItemHolder.jdField_a_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i != 2);
      localObject = paramADVideoItemHolder.jdField_b_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramADVideoItemHolder = paramADVideoItemHolder.jdField_c_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      if (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
        break label100;
      }
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).b(Integer.valueOf(5)).a(paramAdvertisementInfo));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)) {
        ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, true);
      }
      return;
      label100:
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
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramBaseItemHolder == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {
      return;
    }
    paramAdvertisementInfo.setClickPos(paramInt);
    paramBaseItemHolder = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramBaseItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(paramInt));
  }
  
  private boolean b(ADVideoItemHolder paramADVideoItemHolder)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramADVideoItemHolder != null)
    {
      bool2 = bool1;
      if (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
      {
        if (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      paramADVideoItemHolder = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a;
      bool1 = bool3;
      if (paramADVideoItemHolder.c)
      {
        paramADVideoItemHolder = NativeAdUtils.a(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
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
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoInfo.c)
    {
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 3, paramVideoFeedsPlayManager);
      a(paramVideoInfo, 3, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoInfo.c)
    {
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 2, paramVideoFeedsPlayManager);
      a(paramVideoInfo, 2, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoInfo.c)
    {
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 2, paramVideoFeedsPlayManager);
      a(paramVideoInfo, 2, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoInfo.c)
    {
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 1000, paramVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
    }
  }
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    Object localObject = null;
    ReadInJoyAdUtils.a(paramAdvertisementInfo, 17, paramVideoFeedsPlayManager);
    if (a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
    {
      a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(42).b(5).b(Integer.valueOf(5)).a(paramAdvertisementInfo));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.f();
    paramVideoFeedsPlayManager = localObject;
    if (paramAdvertisementInfo != null) {
      paramVideoFeedsPlayManager = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, 17, paramVideoFeedsPlayManager);
  }
  
  private void h(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    ReadInJoyAdUtils.a(paramAdvertisementInfo, 16, paramVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.f();
    a(paramVideoInfo, 16, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
  }
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    ReadInJoyAdUtils.a(paramAdvertisementInfo, 15, paramVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.f();
    a(paramVideoInfo, 15, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null));
  }
  
  @Nullable
  public AdvertisementInfo a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramVideoInfo.c)
    {
      paramVideoInfo = ReadInJoyVideoFeedsAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, null, 3, paramBoolean, null);
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        this.jdField_a_of_type_Long = l;
        return paramVideoInfo;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ADVideoItemHolder))) {
      return;
    }
    a(true, (ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ADVideoItemHolder))
    {
      localADVideoItemHolder = (ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      i = ReadInJoyAdUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v, false);
      j = localADVideoItemHolder.jdField_a_of_type_Int;
      localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
      if (j != 5)
      {
        j = localADVideoItemHolder.jdField_a_of_type_Int;
        localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
        if (j != 7) {}
      }
      else if ((paramLong >= i) && (!this.d) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        this.d = true;
        if (AdVideoPendantUIUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        }
      }
      if (a(localADVideoItemHolder))
      {
        j = ReadInJoyAdUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v, true);
        i = j;
        if (j < 0) {
          i = PublicAccountConfigUtilImpl.readInJoyADGuideCardShowTime * 1000;
        }
        j = i;
        if (a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a))
        {
          j = i;
          if (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
            j = 3000;
          }
        }
        if ((paramLong >= j) || (a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a)))
        {
          if (localADVideoItemHolder.d.getVisibility() == 0) {
            localADVideoItemHolder.d.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
          if ((localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a() != null)) {
            ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "show card with currentState = " + localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a().jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    while (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof BaseVideoItemHolder))
    {
      ADVideoItemHolder localADVideoItemHolder;
      int i;
      int j;
      VideoFeedsAdapter localVideoFeedsAdapter;
      return;
    }
    this.d = false;
  }
  
  public void a(Message paramMessage)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ADVideoItemHolder))
    {
      localADVideoItemHolder = (ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      localObject1 = localADVideoItemHolder.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        break label36;
      }
    }
    label36:
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      return;
      Object localObject2 = paramMessage.obj;
      paramMessage = localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      localAdvertisementInfo = NativeAdUtils.a(paramMessage);
      if (localObject2 != null)
      {
        this.f = true;
        if (localADVideoItemHolder.h != null) {
          localADVideoItemHolder.h.setVisibility(8);
        }
        if ((ReadInJoyAdSwitchUtil.d(paramMessage)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a();
        }
        VideoFeedsHelper.a(localADVideoItemHolder.l, 250, 8, Utils.dp2px(200.0D));
        VideoFeedsHelper.a((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(ReportAction.CLOSE).a(1).b(21).b(Integer.valueOf(0)).a(localAdvertisementInfo).a(paramMessage).c(39));
        return;
      }
    } while (this.b);
    ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    VideoFeedsHelper.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (!this.h) {
      AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if (((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).h != null)
    {
      a((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
      ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).h.setVisibility(0);
    }
    VideoFeedsHelper.a(((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).l, 250, 0, 250, Utils.dp2px(200.0D));
    if (ReadInJoyAdSwitchUtil.d(paramMessage))
    {
      localObject1 = ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (localObject1 != null) {
        ((RIJDownloadView)localObject1).a(true);
      }
    }
    NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(2).b(21).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG).a(localAdvertisementInfo).a(paramMessage));
  }
  
  public void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    int i = 13;
    boolean bool;
    AdvertisementInfo localAdvertisementInfo;
    if ((paramView.getId() == 2131362078) || (paramView.getId() == 2131362080))
    {
      bool = true;
      localAdvertisementInfo = a(paramVideoInfo, bool);
    }
    switch (paramView.getId())
    {
    default: 
    case 2131362098: 
    case 2131362083: 
    case 2131362114: 
    case 2131368345: 
    case 2131362105: 
    case 2131362107: 
    case 2131362111: 
    case 2131362075: 
    case 2131362109: 
    case 2131362086: 
    case 2131368371: 
    case 2131366039: 
    case 2131366040: 
    case 2131366036: 
    case 2131366037: 
    case 2131366032: 
    case 2131366034: 
      for (;;)
      {
        a(paramView, paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        return;
        bool = false;
        break;
        a(paramView, paramVideoInfo, paramVideoFeedsPlayManager);
        continue;
        a(paramVideoInfo, localAdvertisementInfo);
        continue;
        f(paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        e(paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        d(paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        c(paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        b(paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        a(paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 13, paramVideoFeedsPlayManager);
        a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(paramVideoInfo, localAdvertisementInfo);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 2003, paramVideoFeedsPlayManager);
        a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 2003);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 2004, paramVideoFeedsPlayManager);
        a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 2004);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 4001, paramVideoFeedsPlayManager);
        b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4001);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 4002, paramVideoFeedsPlayManager);
        b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4002);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 4007, paramVideoFeedsPlayManager);
        b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4007);
        continue;
        ReadInJoyAdUtils.a(localAdvertisementInfo, 4000, paramVideoFeedsPlayManager);
        b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4000);
      }
    case 2131362078: 
      if ((AdvertisementInfo.isAppAdvertisementInfo(localAdvertisementInfo)) && (!a(paramVideoInfo)) && (RIJAdDownloadExKt.a(localAdvertisementInfo))) {
        if (!this.d) {
          break label621;
        }
      }
      break;
    }
    for (;;)
    {
      ((ADVideoItemHolder)paramBaseItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(i);
      ((ADVideoItemHolder)paramBaseItemHolder).jdField_a_of_type_Boolean = true;
      break;
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramVideoFeedsPlayManager);
      break;
      if ((AdvertisementInfo.isAppAdvertisementInfo(localAdvertisementInfo)) && (RIJAdDownloadExKt.a(localAdvertisementInfo)))
      {
        ((ADVideoItemHolder)paramBaseItemHolder).jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(38);
        ((ADVideoItemHolder)paramBaseItemHolder).jdField_a_of_type_Boolean = true;
        break;
      }
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      break;
      label621:
      i = 8;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    AdvertisementInfo localAdvertisementInfo = NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {}
    for (int i = 10;; i = 5)
    {
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(i).b(paramInteger).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(paramInt));
      return;
    }
  }
  
  public void a(ADVideoItemHolder paramADVideoItemHolder)
  {
    int i;
    Object localObject;
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null) && (paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i = ReadInJoyAdSwitchUtil.d(NativeAdUtils.a(paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i != 1) {
        break label88;
      }
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
    label88:
    do
    {
      do
      {
        do
        {
          return;
        } while (i != 2);
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
      } while (paramADVideoItemHolder == null);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramBaseItemHolder == null) || (paramVideoInfo == null) || (paramAdvertisementInfo == null)) {
      return;
    }
    paramAdvertisementInfo.setClickPos(paramInt);
    paramBaseItemHolder = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(21).b(paramBaseItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(paramInt));
  }
  
  public void a(boolean paramBoolean, VideoItemHolder paramVideoItemHolder)
  {
    if (!(paramVideoItemHolder instanceof ADVideoItemHolder)) {
      return;
    }
    ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
    if ((paramBoolean) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)) {
      localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.c();
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      bool1 = bool2;
      if (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null)
      {
        bool1 = bool2;
        if (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
          bool1 = ReadInJoyAdSwitchUtil.d(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        }
      }
    }
    if ((localADVideoItemHolder.jdField_a_of_type_Boolean) && (bool1))
    {
      AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
      if (!this.h) {
        AdVideoButtonUIUtils.c(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      }
      if (a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a))
      {
        AdVideoButtonUIUtils.a(localADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
        return;
      }
      AdVideoButtonUIUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      return;
    }
    if (localADVideoItemHolder.d.getVisibility() == 8) {
      AdVideoButtonUIUtils.a(localADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if ((localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      if (!a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a)) {
        break label252;
      }
      AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      AdVideoButtonUIUtils.a(localADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
    }
    for (;;)
    {
      b(localADVideoItemHolder);
      return;
      label252:
      if (b(localADVideoItemHolder))
      {
        AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
        AdVideoButtonUIUtils.a(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
        if ((paramVideoItemHolder instanceof ADVideoItemHolder)) {
          AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidAppActivity, (ADVideoItemHolder)paramVideoItemHolder);
        }
        AdVideoButtonUIUtils.a(paramBoolean, localADVideoItemHolder);
      }
      else
      {
        AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout);
        AdVideoButtonUIUtils.b(localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ADVideoItemHolder))) {
      return;
    }
    AdVideoPendantUIUtils.a(true, (ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder, this.h, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
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
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 49	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:e	Z
    //   7: aload_0
    //   8: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;
    //   11: getfield 112	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder	Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;
    //   14: instanceof 76
    //   17: ifeq +351 -> 368
    //   20: aload_0
    //   21: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;
    //   24: getfield 112	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder	Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;
    //   27: checkcast 76	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder
    //   30: astore_3
    //   31: aload_3
    //   32: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   35: ifnull +333 -> 368
    //   38: aload_3
    //   39: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   42: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   45: ifnull +323 -> 368
    //   48: aload_3
    //   49: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   52: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   55: getfield 109	com/tencent/biz/pubaccount/VideoInfo:c	Z
    //   58: ifeq +310 -> 368
    //   61: aload_3
    //   62: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   65: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   68: getfield 89	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   71: ifnull +297 -> 368
    //   74: aload_3
    //   75: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   78: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   81: getfield 89	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   84: getfield 616	com/tencent/biz/pubaccount/VideoAdInfo:h	Ljava/lang/String;
    //   87: astore 4
    //   89: aload_0
    //   90: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   93: aload 4
    //   95: invokeinterface 593 2 0
    //   100: ifne +268 -> 368
    //   103: aload_0
    //   104: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   107: aload 4
    //   109: invokeinterface 619 2 0
    //   114: pop
    //   115: aload_3
    //   116: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   119: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   122: getfield 89	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   125: invokestatic 168	com/tencent/biz/pubaccount/NativeAd/util/NativeAdUtils:a	(Lcom/tencent/biz/pubaccount/VideoAdInfo;)Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   128: astore 4
    //   130: iconst_5
    //   131: istore_1
    //   132: aload_3
    //   133: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   136: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   139: aload_0
    //   140: getfield 70	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   143: invokevirtual 561	com/tencent/biz/pubaccount/VideoInfo:a	(Landroid/app/Activity;)Z
    //   146: ifeq +6 -> 152
    //   149: bipush 10
    //   151: istore_1
    //   152: new 621	org/json/JSONObject
    //   155: dup
    //   156: invokespecial 622	org/json/JSONObject:<init>	()V
    //   159: astore 5
    //   161: new 621	org/json/JSONObject
    //   164: dup
    //   165: invokespecial 622	org/json/JSONObject:<init>	()V
    //   168: astore 6
    //   170: aload_3
    //   171: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   174: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   177: getfield 625	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataVideoAdTimeReportData	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/VideoAdTimeReportData;
    //   180: astore 7
    //   182: getstatic 628	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyManager:jdField_a_of_type_Int	I
    //   185: iconst_1
    //   186: if_icmpne +193 -> 379
    //   189: aload 7
    //   191: ifnull +188 -> 379
    //   194: aload 6
    //   196: ldc_w 630
    //   199: aload 7
    //   201: getfield 633	com/tencent/biz/pubaccount/readinjoyAd/ad/data/VideoAdTimeReportData:jdField_a_of_type_Int	I
    //   204: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 6
    //   210: ldc_w 639
    //   213: aload 7
    //   215: getfield 641	com/tencent/biz/pubaccount/readinjoyAd/ad/data/VideoAdTimeReportData:c	I
    //   218: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   221: pop
    //   222: aload_3
    //   223: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   226: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   229: getfield 644	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportData	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyReportData;
    //   232: astore 7
    //   234: aload 6
    //   236: ldc_w 646
    //   239: aload 7
    //   241: getfield 649	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyReportData:jdField_a_of_type_Long	J
    //   244: invokevirtual 652	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   247: pop
    //   248: aload 6
    //   250: ldc_w 654
    //   253: aload 7
    //   255: getfield 655	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyReportData:jdField_a_of_type_Int	I
    //   258: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   261: pop
    //   262: aload 6
    //   264: ldc_w 657
    //   267: aload 7
    //   269: getfield 659	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyReportData:b	I
    //   272: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   275: pop
    //   276: aload 5
    //   278: ldc_w 661
    //   281: aload 6
    //   283: invokevirtual 662	org/json/JSONObject:toString	()Ljava/lang/String;
    //   286: invokevirtual 665	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   289: pop
    //   290: ldc_w 256
    //   293: new 368	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 667
    //   303: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 6
    //   308: invokevirtual 662	org/json/JSONObject:toString	()Ljava/lang/String;
    //   311: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 263	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: aload_3
    //   322: aload 4
    //   324: iload_1
    //   325: aload 5
    //   327: invokespecial 669	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILorg/json/JSONObject;)V
    //   330: invokestatic 674	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdReqFreshManager:a	()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdReqFreshManager;
    //   333: aload_3
    //   334: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   337: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   340: getfield 89	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   343: getfield 676	com/tencent/biz/pubaccount/VideoAdInfo:e	J
    //   346: invokestatic 681	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   349: invokevirtual 684	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdReqFreshManager:a	(Ljava/lang/Long;)V
    //   352: invokestatic 689	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:a	()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager;
    //   355: ldc_w 691
    //   358: aload_3
    //   359: getfield 79	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   362: getfield 84	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   365: invokevirtual 694	com/tencent/biz/pubaccount/readinjoyAd/ad/manager/AdExposeFreshManager:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/VideoInfo;)V
    //   368: return
    //   369: astore 7
    //   371: aload 7
    //   373: invokevirtual 697	java/lang/Exception:printStackTrace	()V
    //   376: goto -154 -> 222
    //   379: aload_0
    //   380: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;
    //   383: getfield 700	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   386: ifnull +14 -> 400
    //   389: aload_0
    //   390: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;
    //   393: getfield 700	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
    //   396: invokevirtual 704	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:c	()I
    //   399: istore_2
    //   400: aload 6
    //   402: ldc_w 630
    //   405: aload_0
    //   406: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHardAdBarManager:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;
    //   409: getfield 112	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder	Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;
    //   412: invokevirtual 707	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:getAdapterPosition	()I
    //   415: iload_2
    //   416: isub
    //   417: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   420: pop
    //   421: goto -199 -> 222
    //   424: astore 7
    //   426: aload 7
    //   428: invokevirtual 708	org/json/JSONException:printStackTrace	()V
    //   431: goto -209 -> 222
    //   434: astore 7
    //   436: aload 7
    //   438: invokevirtual 697	java/lang/Exception:printStackTrace	()V
    //   441: goto -151 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	VideoFeedsHardAdBarManager
    //   131	194	1	i	int
    //   1	416	2	j	int
    //   30	329	3	localVideoItemHolder	VideoItemHolder
    //   87	236	4	localObject1	Object
    //   159	167	5	localJSONObject1	JSONObject
    //   168	233	6	localJSONObject2	JSONObject
    //   180	88	7	localObject2	Object
    //   369	3	7	localException1	java.lang.Exception
    //   424	3	7	localJSONException	org.json.JSONException
    //   434	3	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   194	222	369	java/lang/Exception
    //   379	400	424	org/json/JSONException
    //   400	421	424	org/json/JSONException
    //   222	290	434	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager
 * JD-Core Version:    0.7.0.1
 */