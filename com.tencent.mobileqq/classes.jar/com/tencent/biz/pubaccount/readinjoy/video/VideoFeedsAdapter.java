package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatus;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.IAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.MsgLayoutHelper;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.FooterItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.TiktokVideoItemDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.TiktokVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.KandianPopupWindowForAd;
import com.tencent.widget.PopupMenuDialog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsAdapter
  extends RecyclerView.Adapter<BaseItemHolder>
  implements View.OnClickListener, View.OnLongClickListener, ReadInJoyUserInfoModule.RefreshUserInfoCallBack, VideoFeedsGestureLayout.CustomClickListener, VideoFeedsRecommendManager.Listener, IAdapter
{
  private static boolean jdField_d_of_type_Boolean = false;
  public int a;
  public long a;
  public Activity a;
  private Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  public Drawable a;
  public Handler a;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  public Animation a;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private RIJVideoRewardCoinManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager;
  public VideoBrightnessController a;
  public VideoColumnBannerManager a;
  public VideoFeedsAdapter.AdapterEventListener a;
  public VideoFeedsCommentManager a;
  public VideoFeedsHardAdBarManager a;
  public VideoFeedsLikeAnimateManager a;
  public VideoFeedsPlayManager a;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager;
  private VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter;
  public VideoFeedsRecyclerView.ListEventListener a;
  public VideoFeedsRecyclerView a;
  private VideoFeedsReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public BaseVideoItemHolder a;
  FooterItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsFooterItemHolder;
  private VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
  public NegativeHelper a;
  private ADVideoFeedsGuideManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager;
  private VideoAdExposureManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new VideoFeedsAdapter.12(this);
  public KandianPopupWindowForAd a;
  public PopupMenuDialog a;
  private String jdField_a_of_type_JavaLangString;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  public int b;
  private long b;
  public Drawable b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private final boolean m;
  private boolean n = false;
  private boolean o = true;
  
  VideoFeedsAdapter(Context paramContext, Activity paramActivity, Bundle paramBundle, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsAdapter.3(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView$ListEventListener = new VideoFeedsAdapter.4(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView$ListEventListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController = new VideoBrightnessController(paramActivity);
    jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = new KandianPopupWindowForAd(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    setHasStableIds(true);
    registerAdapterDataObserver(new VideoFeedsAdapter.ActionInspector(this, null));
    this.jdField_b_of_type_Boolean = SimpleUIUtil.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper = new NegativeHelper(paramActivity, this);
    this.m = ReadInJoyHelper.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter = paramVideoFeedsRecommendPresenter.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager = new VideoFeedsHardAdBarManager(paramContext, this.m, paramActivity, this);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return HardCodeUtil.a(2131716074);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131716071);
    }
    return null;
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof VideoItemHolder))
      {
        localImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e()) {
          break label83;
        }
      }
    }
    label83:
    for (String str = "click_pause";; str = "click_play")
    {
      VideoFeedsHelper.a(localImageView, paramVideoInfo, str);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.a();
      if (paramView.getId() == 2131366410) {
        PlayFeedbackHelper.b(paramVideoInfo.g, 2);
      }
      return;
    }
  }
  
  private void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(paramView, paramVideoInfo);
      return;
      i(paramVideoInfo);
      return;
      a(paramBaseItemHolder);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.j == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "0X8009F42");
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    AdvertisementInfo localAdvertisementInfo = NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {}
    for (int i1 = 10;; i1 = 5)
    {
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(i1).b(paramInteger).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).c(paramInt));
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, BaseItemHolder paramBaseItemHolder, boolean paramBoolean)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramBaseItemHolder instanceof ADVideoItemHolder)))
    {
      AdVideoButtonUIUtils.a((ADVideoItemHolder)paramBaseItemHolder, "暂不支持biu");
      return;
    }
    RIJUserLevelModule.a().a(this.jdField_a_of_type_AndroidAppActivity, 2, new VideoFeedsAdapter.6(this, paramVideoInfo, paramBaseItemHolder, paramBoolean));
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    b(paramVideoInfo, paramBoolean2);
    Object localObject1;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = new VideoR5.Builder((String)localObject1, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((VideoR5.Builder)localObject1).g(paramBoolean1).h(paramBoolean2).b(this.m);
      if (!jdField_d_of_type_Boolean)
      {
        ((VideoR5.Builder)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.s).a(-1).a(paramVideoInfo.w).M(0);
        localObject2 = new ReportInfo.VideoExtraRepoerData();
        ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        VideoReporter.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (ReportInfo.VideoExtraRepoerData)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      localObject1 = ((VideoR5.Builder)localObject1).a().a();
      if (!jdField_d_of_type_Boolean) {
        break label303;
      }
      localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label296;
      }
    }
    label296:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, str, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label303:
    Object localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, str, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  @RequiresApi(api=16)
  private void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView, 8, 0);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new VideoFeedsAdapter.1(this, paramVideoPlayParam));
  }
  
  private void a(VideoFeedsUGView paramVideoFeedsUGView, boolean paramBoolean)
  {
    if (paramVideoFeedsUGView != null) {
      paramVideoFeedsUGView.setActive(paramBoolean);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder)
  {
    if ((paramBaseItemHolder.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b())) {
      VideoFeedsHelper.a(((VideoItemHolder)paramBaseItemHolder).d, 8, 200);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b();
    }
  }
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam2 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam1 = localVideoPlayParam2;
    if (localVideoPlayParam2 == null)
    {
      localVideoPlayParam1 = new VideoFeedsPlayManager.VideoPlayParam();
      localVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
      localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localVideoPlayParam1.jdField_a_of_type_Int = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramBaseVideoItemHolder.jdField_d_of_type_Int);
    localVideoPlayParam1.jdField_a_of_type_AndroidViewViewGroup = paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewViewGroup;
    localVideoPlayParam1.jdField_b_of_type_Int = paramBaseVideoItemHolder.jdField_c_of_type_Int;
    localVideoPlayParam1.jdField_a_of_type_Boolean = false;
    localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramBaseVideoItemHolder.jdField_c_of_type_Int);
    localVideoPlayParam1.jdField_a_of_type_Long = 0L;
    localVideoPlayParam1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label173;
      }
      localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", 10);
    }
    for (;;)
    {
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.jdField_a_of_type_Boolean = true;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = localVideoPlayParam1;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.a(this, paramBaseVideoItemHolder);
      return;
      label173:
      localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", 5);
    }
  }
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = paramLong;
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.t = ReadInJoyUtils.a(paramInt, paramBaseVideoItemHolder.jdField_c_of_type_Int, false);
      }
      if ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null)) {
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(FooterItemHolder paramFooterItemHolder)
  {
    if (this.jdField_d_of_type_Int == 1)
    {
      paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_d_of_type_Int != 3);
    if (paramFooterItemHolder.jdField_a_of_type_Int == 6)
    {
      paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && ((paramVideoItemHolder instanceof ADVideoItemHolder)))
    {
      AdVideoButtonUIUtils.a((ADVideoItemHolder)paramVideoItemHolder, "作者设置暂不可评论");
      return;
    }
    c(paramVideoItemHolder, paramVideoInfo);
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i3 = paramList.indexOf(paramVideoInfo);
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((i3 >= 0) && ((paramList instanceof VideoItemHolder)) && (((VideoItemHolder)paramList).jdField_b_of_type_Int == i3))
      {
        ((VideoItemHolder)paramList).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.b(paramVideoInfo);
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof VideoItemHolder))
      {
        int i3 = ((VideoItemHolder)localViewHolder).jdField_b_of_type_Int;
        if (i3 < paramList.size())
        {
          VideoInfo localVideoInfo = (VideoInfo)paramList.get(i3);
          if (paramString.equals(localVideoInfo.j)) {
            ((VideoItemHolder)localViewHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.b(localVideoInfo);
          }
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.j != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.j.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.q) {
          bool1 = true;
        }
        paramVideoInfo.q = true;
      }
    }
    return bool1;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramView.getTag();
    if (localVideoItemHolder != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder) {}
    while ((!this.o) || (localVideoItemHolder == null) || (localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localVideoItemHolder instanceof BaseVideoItemHolder)) || (TextUtils.isEmpty(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      return;
    }
    Object localObject = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label108:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).r)
    {
      bool = true;
      ((VideoInfo)localObject).r = true;
      if (!bool) {
        break label516;
      }
      i1 = ((VideoInfo)localObject).v + 1;
      ((VideoInfo)localObject).v = i1;
      localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener.a((VideoInfo)localObject, ((VideoInfo)localObject).r);
        }
        j((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(3, (VideoInfo)localObject, 0L);
      }
      VideoFeedsHelper.a(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, (VideoInfo)localObject, "click_like", "double");
      VideoReport.reportEvent("clck", localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, null);
      localJSONObject = new JSONObject();
      if ((localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label526;
      }
      paramView = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label261:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager == null) {
        break label531;
      }
      paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager.a();
      label308:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label536;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label350:
      localJSONObject.put("common_data", localObject);
      if (!this.m) {
        break label544;
      }
      paramInt1 = 1;
      label370:
      localJSONObject.put("interact_button_style", paramInt1);
    }
    catch (Exception localException)
    {
      label380:
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      label391:
      String str2;
      String str1;
      label516:
      label526:
      label531:
      label536:
      label544:
      label557:
      break label380;
    }
    if (jdField_d_of_type_Boolean)
    {
      localObject = "0X80097F5";
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      if (TextUtils.isEmpty(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        break label557;
      }
    }
    for (str1 = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; str1 = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, VideoReporter.a(paramView, localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
      return;
      bool = false;
      break;
      i1 = ((VideoInfo)localObject).v;
      break label108;
      paramView = null;
      break label261;
      paramInt1 = 0;
      break label308;
      localObject = "";
      break label350;
      paramInt1 = 0;
      break label370;
      localObject = "0X80091AA";
      break label391;
    }
  }
  
  private void b(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(paramVideoInfo, false);
    switch (paramView.getId())
    {
    default: 
    case 2131367342: 
    case 2131372510: 
    case 2131367366: 
    case 2131364828: 
    case 2131367653: 
    case 2131368339: 
    case 2131365123: 
    case 2131367371: 
    case 2131367372: 
    case 2131367350: 
    case 2131381358: 
    case 2131368168: 
    case 2131361856: 
      do
      {
        do
        {
          do
          {
            return;
            a(paramVideoInfo, paramBaseItemHolder, false);
            return;
          } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener == null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener.e();
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        h(paramVideoInfo);
        return;
        a(paramView);
        return;
        b((VideoItemHolder)paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
        return;
        a((VideoItemHolder)paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
        return;
        RIJUserLevelModule.a().a(this.jdField_a_of_type_AndroidAppActivity, 3, new VideoFeedsAdapter.5(this, paramBaseItemHolder, paramVideoInfo));
        return;
        b(paramBaseItemHolder, paramVideoInfo);
        return;
        b((VideoItemHolder)paramBaseItemHolder, paramVideoInfo);
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      return;
    case 2131367361: 
      f(paramVideoInfo);
      return;
    }
    g(paramVideoInfo);
  }
  
  private void b(VideoInfo paramVideoInfo, BaseItemHolder paramBaseItemHolder, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBaseItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)paramBaseItemHolder).l, paramVideoInfo, "click_biu");
    }
    if (BiuBehaviour.a() == 1) {}
    for (;;)
    {
      a(paramVideoInfo, paramBoolean, bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(2, paramVideoInfo, 0L);
      }
      return;
      bool = false;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        localIntent.putExtra("feedsType", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.g);
      localIntent.putExtra("biu_src", 2);
      localIntent.putExtra("arg_from_type", 8);
      localIntent.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localIntent.putExtra("fast_biu_type", paramBoolean);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 102);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
    }
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    if (((paramBaseItemHolder instanceof ShortVideoItemHolder)) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
      paramBaseItemHolder = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).i(paramVideoInfo.g).M(0).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramBaseItemHolder.a(), false);
    }
  }
  
  private void b(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null))
    {
      VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      if ((!localVideoPlayerWrapper.a()) && (!localVideoPlayerWrapper.b()) && (!localVideoPlayerWrapper.c()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int == paramBaseVideoItemHolder.jdField_c_of_type_Int - 1) && (ReadInJoyHelper.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (VideoPreloadStrategyConoller.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
      }
    }
  }
  
  private void b(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(false, paramVideoItemHolder);
    a(paramVideoItemHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(paramVideoInfo, 21, Integer.valueOf(0));
  }
  
  private void b(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      ReadInJoyAdUtils.a(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
      return;
    }
    d(paramVideoItemHolder, paramVideoInfo);
  }
  
  private void c(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    int i1 = 0;
    boolean bool;
    label32:
    ImageView localImageView;
    if (!paramVideoInfo.r)
    {
      bool = true;
      paramVideoInfo.r = bool;
      if (!paramVideoInfo.r) {
        break label177;
      }
      i1 = paramVideoInfo.v + 1;
      paramVideoInfo.v = i1;
      if ((paramBaseItemHolder instanceof VideoItemHolder))
      {
        ((VideoItemHolder)paramBaseItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.d();
        localImageView = ((VideoItemHolder)paramBaseItemHolder).jdField_m_of_type_AndroidWidgetImageView;
        if (!paramVideoInfo.r) {
          break label194;
        }
      }
    }
    label177:
    label194:
    for (paramBaseItemHolder = "click_like";; paramBaseItemHolder = "cancel_like")
    {
      VideoFeedsHelper.a(localImageView, paramVideoInfo, paramBaseItemHolder);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager != null) && (paramVideoInfo.r)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager.a((float)(DeviceInfoUtil.i() / 2L), (float)(DeviceInfoUtil.j() / 2L));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(3, paramVideoInfo, 0L);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener != null) && (!paramVideoInfo.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener.a(paramVideoInfo, paramVideoInfo.r);
      }
      j(paramVideoInfo);
      return;
      bool = false;
      break;
      if (paramVideoInfo.v <= 0) {
        break label32;
      }
      i1 = paramVideoInfo.v - 1;
      break label32;
    }
  }
  
  private void c(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if ((paramBaseVideoItemHolder != null) && ((paramBaseVideoItemHolder.jdField_a_of_type_Boolean) || ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b() != 0))))
    {
      paramBaseVideoItemHolder.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramBaseVideoItemHolder);
    }
  }
  
  private void c(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsHelper.a(paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup, paramVideoInfo, "click_comment");
    JSONObject localJSONObject = new JSONObject();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.w == null) {
          continue;
        }
        paramVideoItemHolder = paramVideoInfo.w;
        localJSONObject.put("video_report_info", paramVideoItemHolder);
        localJSONObject.put("video_type", 0);
        if (!this.m) {
          continue;
        }
        i1 = 1;
        localJSONObject.put("interact_button_style", i1);
      }
      catch (JSONException paramVideoItemHolder)
      {
        int i1;
        paramVideoItemHolder.printStackTrace();
        continue;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", VideoReporter.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      }
      if (!jdField_d_of_type_Boolean) {
        continue;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", VideoReporter.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      paramVideoItemHolder = "";
      continue;
      i1 = 0;
    }
  }
  
  private void d(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    long l2 = -1L;
    VideoFeedsHelper.a(paramVideoItemHolder.p, paramVideoInfo, "click_write_comment");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.g();
    String str1;
    label49:
    long l1;
    if (jdField_d_of_type_Boolean)
    {
      str1 = "0X800948A";
      if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) {
        break label241;
      }
      paramVideoItemHolder = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      Object localObject = new VideoR5.Builder(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
      if (paramVideoItemHolder == null) {
        break label246;
      }
      l1 = paramVideoItemHolder.a(paramVideoItemHolder.h());
      label84:
      localObject = ((VideoR5.Builder)localObject).d(l1);
      if (paramVideoItemHolder == null) {
        break label253;
      }
      l1 = paramVideoItemHolder.a();
      label101:
      localObject = ((VideoR5.Builder)localObject).a(l1);
      l1 = l2;
      if (paramVideoItemHolder != null) {
        l1 = paramVideoItemHolder.b();
      }
      localObject = ((VideoR5.Builder)localObject).c(l1).a(409409).a(paramVideoInfo.w).u(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label260;
      }
      paramVideoItemHolder = paramVideoInfo.g;
      label197:
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, str1, str1, 0, 0, "", "", paramVideoItemHolder, (String)localObject, false);
      if (!ReadInJoyHelper.l(ReadInJoyUtils.a())) {
        break label267;
      }
    }
    label241:
    label246:
    label253:
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager == null)
    {
      return;
      str1 = "0X8009485";
      break;
      paramVideoItemHolder = null;
      break label49;
      l1 = -1L;
      break label84;
      l1 = -1L;
      break label101;
      paramVideoItemHolder = "0";
      break label197;
    }
    label260:
    label267:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(4, paramVideoInfo, 0L);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(false, null);
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.o) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "只能投一次哦", 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(paramVideoInfo, "0X800B2EB");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager.a(paramVideoInfo);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate instanceof ShortVideoItemDelegate))) {
      ((ShortVideoItemDelegate)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate).e();
    }
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    String str2;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    String str1;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo != null)
    {
      str2 = new VideoR5.Builder("", paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).i(paramVideoInfo.g).a().a();
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label109;
      }
      str1 = "1";
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label116;
      }
    }
    label109:
    label116:
    for (paramVideoInfo = "";; paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X800B4D0", "0X800B4D0", 0, 0, str1, paramVideoInfo, "", str2, false);
      return;
      str1 = "2";
      break;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.13(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.a()) {}
      for (long l1 = System.currentTimeMillis();; l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.a())
      {
        l1 = Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(), l1);
        l1 = 3000L - (System.currentTimeMillis() - l1);
        if (l1 <= 0L) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate == null));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.h(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.b();
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.q) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + paramVideoInfo.j + ", isFollowed=" + paramVideoInfo.q + ", pname=" + paramVideoInfo.k);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton, paramVideoInfo, "click_follow");
    }
    String str2 = new VideoR5.Builder(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.w).M(0).a().a();
    if (jdField_d_of_type_Boolean)
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str3 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (str1 = paramVideoInfo.g;; str1 = "0")
      {
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, "0X800929B", "0X800929B", 0, 0, "", "", str1, str2, false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(paramVideoInfo, "0X800B1A7", true, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(paramVideoInfo, "0X800B1A6", false, true);
        b(paramVideoInfo);
        return;
      }
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str3 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (String str1 = paramVideoInfo.g;; str1 = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, "0X80078FD", "0X80078FD", 0, 0, "", "", str1, str2, false);
      break;
    }
  }
  
  private void i()
  {
    if (this.j)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 50L);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
  }
  
  private void i(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (paramVideoInfo == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
    } while (TextUtils.isEmpty(paramVideoInfo.g));
    PlayFeedbackHelper.a(this.jdField_a_of_type_AndroidAppActivity, FeedsChannelDataHelper.a(paramVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 2, 0);
    PlayFeedbackHelper.a(paramVideoInfo.g, 2, 0);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
  }
  
  private void j(VideoInfo paramVideoInfo)
  {
    int i2 = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (!paramVideoInfo.r) {
        break label284;
      }
      i1 = 0;
      localJSONObject.put("type", i1);
      if (paramVideoInfo.w == null) {
        break label289;
      }
      str1 = paramVideoInfo.w;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.r) {
        break label103;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager == null) {
        break label337;
      }
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        label103:
        String str2;
        label132:
        label162:
        label183:
        label206:
        IPublicAccountReportUtils localIPublicAccountReportUtils;
        String str4;
        String str3;
        label284:
        label289:
        label305:
        label310:
        label318:
        label324:
        continue;
        int i1 = 0;
      }
    }
    localJSONObject.put("style", i1);
    localJSONObject.put("algorithm_id", paramVideoInfo.f);
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar != null)
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      localJSONObject.put("common_data", str1);
      localJSONObject.put("video_type", 0);
      if (!this.m) {
        break label305;
      }
      i1 = i2;
      localJSONObject.put("interact_button_style", i1);
      if (!jdField_d_of_type_Boolean) {
        break label310;
      }
      str1 = "0X800929C";
      if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label318;
      }
      str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str4 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label324;
      }
    }
    for (str3 = paramVideoInfo.g;; str3 = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str4, str1, str1, 0, 0, "0", "0", str3, VideoReporter.a(str2, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      i1 = 1;
      break;
      str1 = "";
      break label60;
      str1 = "";
      break label132;
      i1 = 0;
      break label162;
      str1 = "0X80091A9";
      break label183;
      str2 = null;
      break label206;
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton.a(), 8, 600);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new VideoPreloadReportData(VideoPreloadReportData.jdField_c_of_type_Int, VideoPreloadReportData.g);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new VideoFeedsAdapter.11(this));
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleNotNetWorkChange mIsActivityOnResume = " + this.jdField_e_of_type_Boolean);
    }
    if (!this.jdField_e_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(false);
  }
  
  public Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
      if (localBitmap == null) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
  }
  
  public VideoInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.g)) {
            break;
          }
        } while (localVideoInfo.jdField_c_of_type_JavaUtilArrayList == null);
        localObject = localVideoInfo.jdField_c_of_type_JavaUtilArrayList.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.g));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public BaseItemHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramViewGroup.getContext());
    Object localObject3;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject3 = null;
      paramViewGroup = null;
      localObject1 = null;
      if (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate = ((IVideoFeedsItemUIDelegate)localObject3);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate = new VideoFeedsVideoUIDelegate(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.h);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = VideoFeedsResourceLoader.a(2131560454, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (ShortVideoItemHolder)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new ShortVideoItemHolder((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new ShortVideoItemDelegate((ShortVideoItemHolder)paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter, this);
        try
        {
          paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
          if ((LiuHaiUtils.b()) && (paramInt > 0) && (((ShortVideoItemHolder)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((ShortVideoItemHolder)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
            ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), paramInt + ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
          }
          localObject1 = null;
        }
        catch (Exception localException1)
        {
          localView = null;
        }
      }
      break;
      View localView = VideoFeedsResourceLoader.a(2131560470, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (ShortVideoItemHolder)localView.getTag();
      if (paramViewGroup == null) {
        paramViewGroup = new TiktokVideoItemHolder(localView);
      }
      for (;;)
      {
        for (;;)
        {
          localObject3 = new TiktokVideoItemDelegate((TiktokVideoItemHolder)paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter, this);
          try
          {
            paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
            if ((LiuHaiUtils.b()) && (paramInt > 0) && (((ShortVideoItemHolder)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
            {
              localView = (View)((ShortVideoItemHolder)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
              localView.setPadding(localView.getPaddingLeft(), paramInt + localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
            }
            localView = null;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            localObject2 = null;
          }
        }
        break;
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560438, paramViewGroup, false);
        if (!this.m) {
          ((LayoutInflater)localObject2).inflate(2131560481, (ViewGroup)paramViewGroup.findViewById(2131365127), true);
        }
        ((LayoutInflater)localObject2).inflate(2131560476, (ViewGroup)paramViewGroup.findViewById(2131365125), true);
        ((LayoutInflater)localObject2).inflate(2131560478, (ViewGroup)paramViewGroup.findViewById(2131365123), true);
        paramViewGroup = new ADVideoItemHolder(paramViewGroup, paramInt);
        localObject3 = new ADVideoItemDelegate((ADVideoItemHolder)paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter, this);
        Object localObject2 = null;
        break;
        localObject3 = VideoFeedsResourceLoader.a(2131560450, true, new ViewGroup.LayoutParams(-1, -1));
        localObject2 = (FooterItemHolder)((View)localObject3).getTag();
        paramViewGroup = (ViewGroup)localObject2;
        if (localObject2 == null) {
          paramViewGroup = new FooterItemHolder((View)localObject3, paramInt);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsFooterItemHolder = paramViewGroup;
        localObject3 = null;
        localObject2 = paramViewGroup;
        paramViewGroup = null;
        break;
        return localObject2;
      }
    }
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof FooterItemHolder)) {
      a((FooterItemHolder)localViewHolder);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.c()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.o) {
        continue;
      }
      paramView = (BaseVideoItemHolder)paramView.getTag();
      if (paramView != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.c();
      VideoFeedsHelper.a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, "click_contentid");
      VideoReport.reportEvent("clck", paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, null);
      JSONObject localJSONObject;
      switch (paramView.jdField_a_of_type_Int)
      {
      case 3: 
      case 4: 
      case 6: 
      default: 
      case 2: 
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
          continue;
        }
        localJSONObject = new JSONObject();
      case 5: 
      case 7: 
        try
        {
          localJSONObject.put("channel_id", 409409);
          label249:
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label346:
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
            return;
          }
          catch (JSONException localJSONException1)
          {
            break label346;
          }
        }
        catch (JSONException localJSONException2)
        {
          break label249;
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (VideoItemHolder)paramView.getTag();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.n);
        paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a(1);
        this.n = false;
        return;
      } while (paramView.d.getVisibility() != 0);
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.n = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    RIJUserLevelModule.a().a(this.jdField_a_of_type_AndroidAppActivity, 3, new VideoFeedsAdapter.7(this, paramView, paramInt1, paramInt2));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).j, paramVideoInfo, "click_puin");
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {}
    for (Object localObject = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; localObject = null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) && (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.h();
      }
      if (!paramVideoInfo.jdField_c_of_type_Boolean) {
        break;
      }
      paramAdvertisementInfo = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(paramVideoInfo, 0, paramAdvertisementInfo);
      return;
    }
    if ((paramVideoInfo.x != null) && (!paramVideoInfo.x.equals("")))
    {
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.x);
      return;
    }
    String str;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ShortVideoItemHolder)) && (((ShortVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus.d)))
    {
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus.d);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.b(paramVideoInfo, "0X800B17E");
      paramAdvertisementInfo = new VideoR5.Builder((String)localObject, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).M(0).a().a();
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label410;
      }
    }
    label410:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, str, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramAdvertisementInfo, false);
      return;
      if (paramVideoInfo.m)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onClick: video unowned");
        break;
      }
      if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (TextUtils.isEmpty(paramVideoInfo.j)) {
          break;
        }
        a(paramVideoInfo, true);
        break;
      }
      if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.j.equals("16888"))) {
        break;
      }
      a(paramVideoInfo, false);
      break;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(paramVideoInfo, paramString);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramVideoInfo = VideoFeedsHelper.a(paramVideoInfo, paramBoolean, false);
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo);
  }
  
  public void a(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager = paramRIJVideoRewardCoinManager;
  }
  
  public void a(VideoColumnBannerManager paramVideoColumnBannerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager = paramVideoColumnBannerManager;
  }
  
  public void a(VideoFeedsAdapter.AdapterEventListener paramAdapterEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener = paramAdapterEventListener;
  }
  
  public void a(VideoFeedsCommentManager paramVideoFeedsCommentManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager = paramVideoFeedsCommentManager;
  }
  
  public void a(VideoFeedsLikeAnimateManager paramVideoFeedsLikeAnimateManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager = paramVideoFeedsLikeAnimateManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    l();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new VideoFeedsAdapter.9(this));
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoInfo)paramList.next()).a();
      }
    }
    int i2 = paramVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramVideoFeedsRecyclerView.getChildViewHolder(paramVideoFeedsRecyclerView.getChildAt(i1));
      if ((paramList instanceof VideoItemHolder)) {
        ((VideoItemHolder)paramList).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a();
      }
      i1 += 1;
    }
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, int paramInt)
  {
    paramBaseItemHolder.jdField_b_of_type_Int = paramInt;
    paramBaseItemHolder.jdField_c_of_type_Int = paramInt;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramBaseItemHolder, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseItemHolder, paramInt, getItemId(paramInt));
      return;
      a(paramBaseItemHolder, null);
    }
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    int i1 = paramBaseItemHolder.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((FooterItemHolder)paramBaseItemHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsFooterItemHolder = ((FooterItemHolder)paramBaseItemHolder);
      return;
    }
    paramBaseItemHolder = (BaseVideoItemHolder)paramBaseItemHolder;
    c(paramBaseItemHolder);
    a(paramBaseItemHolder, paramVideoInfo);
    VideoFeedsDiversionHandler.a.a(paramBaseItemHolder);
    TraceCompat.beginSection("refreshMenuUI");
    paramBaseItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a_(paramVideoInfo);
    TraceCompat.endSection();
    TraceCompat.beginSection("refreshContentUI");
    paramBaseItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a(paramVideoInfo, this.f);
    if (!TextUtils.isEmpty(paramVideoInfo.j)) {}
    try
    {
      long l1 = Long.parseLong(paramVideoInfo.j);
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(l1, null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isReadlTimeRead())) {
        ReadInJoyUserInfoModule.a(l1, this, true);
      }
      TraceCompat.endSection();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onBindViewHolder: ", localException);
        }
      }
    }
    if ((this.j) && (paramBaseItemHolder == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder)) {
      paramBaseItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.g(this.j);
    }
    b(paramBaseItemHolder);
    VideoReport.setElementExposePolicy(paramBaseItemHolder.itemView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramBaseItemHolder.itemView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramBaseItemHolder.itemView, "card");
    VideoReport.setElementReuseIdentifier(paramBaseItemHolder.itemView, paramVideoInfo.g);
    VideoReport.setElementExposureMinRate(paramBaseItemHolder.itemView, 0.1D);
  }
  
  public void a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(ReportConstants.VideoEndType.SLIDE_LEAVE);
    int i1;
    label128:
    boolean bool1;
    label149:
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null)
    {
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = paramBaseVideoItemHolder;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_Int == 0))
      {
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label286;
      }
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = null;
      bool1 = bool2;
      if (this.i)
      {
        if (!a(paramBaseVideoItemHolder)) {
          break label305;
        }
        bool1 = bool2;
      }
      this.i = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidOsBundle.putBoolean("is_auto_play", bool1);
      if (!bool1) {
        break label325;
      }
      if ((!ReadInJoyHelper.g(this.jdField_c_of_type_Int)) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_c_of_type_Boolean) || (Build.VERSION.SDK_INT < 16)) {
        break label310;
      }
      a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    }
    for (;;)
    {
      a(paramBaseVideoItemHolder, bool1, l1 - l2, i1);
      if (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label286:
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString = null;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_c_of_type_Boolean = false;
      break label128;
      label305:
      bool1 = false;
      break label149;
      label310:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, false);
      continue;
      label325:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    }
  }
  
  public void a(TiktokVideoItemHolder paramTiktokVideoItemHolder)
  {
    long l2 = -1L;
    Object localObject;
    if (paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      localObject = paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) {
        break label133;
      }
      paramTiktokVideoItemHolder = paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      label36:
      localObject = new VideoR5.Builder((VideoInfo)localObject);
      if (paramTiktokVideoItemHolder == null) {
        break label138;
      }
    }
    label133:
    label138:
    for (long l1 = paramTiktokVideoItemHolder.a();; l1 = -1L)
    {
      localObject = ((VideoR5.Builder)localObject).a(l1);
      l1 = l2;
      if (paramTiktokVideoItemHolder != null) {
        l1 = paramTiktokVideoItemHolder.b();
      }
      paramTiktokVideoItemHolder = ((VideoR5.Builder)localObject).c(l1).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B28A", "0X800B28A", 0, 0, "3", "", "", paramTiktokVideoItemHolder.a(), false);
      return;
      localObject = null;
      break;
      paramTiktokVideoItemHolder = null;
      break label36;
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    if (StudyModeManager.a()) {}
    do
    {
      do
      {
        return;
        if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
        if (paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
      } while ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null) && (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null));
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo != null) && ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int == 2))) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
    } while ((paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView == null) || (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null) || ((paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int != 1) && (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int != 2)));
    paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
  }
  
  public void a(ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a = paramADVideoAppDownloadManager;
  }
  
  public void a(ADVideoFeedsGuideManager paramADVideoFeedsGuideManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager = paramADVideoFeedsGuideManager;
  }
  
  public void a(VideoAdExposureManager paramVideoAdExposureManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager = paramVideoAdExposureManager;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.jdField_a_of_type_Boolean = false;
    boolean bool1 = bool2;
    Bundle localBundle;
    int i2;
    if (paramBaseVideoItemHolder.jdField_c_of_type_Int == this.jdField_e_of_type_Int)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        bool1 = bool2;
        if (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
        {
          bool1 = bool2;
          if (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
            if (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)) {
              break label138;
            }
            i1 = 1;
            if ((i1 == 0) && (!this.h)) {
              break label143;
            }
          }
        }
      }
    }
    label138:
    label143:
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())) {
        break label148;
      }
      bool1 = false;
      return bool1;
      i1 = 0;
      break;
    }
    label148:
    if (i2 == 27)
    {
      if (Aladdin.getConfig(271).getIntegerFromString("auto_play", 1) == 1)
      {
        paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
        bool1 = bool3;
        if (i1 == 0) {
          bool1 = true;
        }
        paramBaseVideoItemHolder.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
      if (i1 == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramBaseVideoItemHolder.jdField_a_of_type_Boolean = bool1;
        return false;
      }
    }
    if (i1 != 0)
    {
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.jdField_a_of_type_Boolean = false;
      return true;
    }
    i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
    paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
    if (((2 != i2) && (6 != i2) && (5 != i2)) || (3 != i1))
    {
      bool1 = true;
      label275:
      paramBaseVideoItemHolder.jdField_a_of_type_Boolean = bool1;
      if ((33 != i2) && (1 != i2) && (12 != i2) && (11 != i2)) {
        break label322;
      }
    }
    label322:
    for (i1 = 1;; i1 = 0)
    {
      bool1 = bool2;
      if (i1 == 0) {
        break;
      }
      return false;
      bool1 = false;
      break label275;
    }
  }
  
  public VideoInfo b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (localVideoInfo.jdField_c_of_type_JavaUtilArrayList == null);
        localObject = localVideoInfo.jdField_c_of_type_JavaUtilArrayList.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      ExposureSupplementUtil.c(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    String str = paramVideoInfo.j;
    boolean bool1 = paramVideoInfo.jdField_b_of_type_Boolean;
    Object localObject1 = paramVideoInfo.p;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + str);
    }
    if ((str == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, bool1, (String)localObject1, false);
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    bool1 = false;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (VideoInfo)((Iterator)localObject1).next();
      boolean bool2 = bool1 | a((VideoInfo)localObject2, str);
      bool1 = bool2;
      if (((VideoInfo)localObject2).jdField_c_of_type_JavaUtilArrayList != null)
      {
        localObject2 = ((VideoInfo)localObject2).jdField_c_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          bool1 = bool2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          bool2 = a((VideoInfo)((Iterator)localObject2).next(), str) | bool2;
        }
      }
    }
    if (bool1) {
      b(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() isDataChanged=" + bool1);
    }
    ReadInJoyLogicEngine.a().a().a(409409L, paramVideoInfo.g, paramVideoInfo.j, 2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_FOLLOW, 0, 0, 0));
  }
  
  public void b(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void c()
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildAt(i1));
      if (((localObject instanceof VideoItemHolder)) && (((VideoItemHolder)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int + 1))
      {
        localObject = ((VideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if ((localObject != null) && ((((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_Boolean) || ((((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (!((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a()))))
        {
          ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((VideoFeedsPlayManager.VideoPlayParam)localObject);
        }
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.d();
    }
  }
  
  void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    this.jdField_e_of_type_Boolean = true;
    ReadinJoyActionUtil.a(this);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate instanceof ADVideoItemDelegate))) {
      ((ADVideoItemDelegate)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    ExposureSupplementUtil.d();
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramVideoInfo)))
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramVideoInfo);
      f();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = null;
      notifyItemRemoved(i1);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController = null;
    }
    ExposureSupplementUtil.e();
    DownloadManagerV2.a().b(VideoFeedsUGView.a);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
    }
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.b(paramVideoInfo);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, paramVideoInfo.w);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.k) && (paramBoolean) && (this.l))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof VideoItemHolder)) {
        a((VideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
      }
      this.l = false;
    }
    this.k = paramBoolean;
  }
  
  public void f(boolean paramBoolean) {}
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).hashCode();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsFooterItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsFooterItemHolder.itemView != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsFooterItemHolder.itemView.hashCode();
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localVideoInfo.jdField_c_of_type_Boolean)
      {
        if (localVideoInfo.i == 1) {
          return 7;
        }
      }
      else
      {
        if (this.m) {
          return 8;
        }
        return 2;
      }
    }
    return 6;
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    Object localObject = null;
    if ((localBaseItemHolder instanceof VideoItemHolder))
    {
      VideoInfo localVideoInfo = ((VideoItemHolder)localBaseItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {
          break label72;
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label72:
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(paramView, localBaseItemHolder, localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        b(paramView, localBaseItemHolder, localObject);
        a(paramView, localBaseItemHolder, localObject);
      }
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      VideoFeedsHelper.a(new VideoFeedsAdapter.10(this, paramString));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    Object localObject = null;
    if ((localBaseItemHolder instanceof VideoItemHolder))
    {
      VideoInfo localVideoInfo = ((VideoItemHolder)localBaseItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) {}
      }
      else
      {
        return false;
      }
    }
    if (localObject == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    a(localObject, localBaseItemHolder, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */