package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticlePatchStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.MsgLayoutHelper;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADVideoC2sManger;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideo185UIStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils.OnPatchPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class VideoUIManager
  implements View.OnClickListener, OrientationDetector.OnOrientationChangedListener, VideoFeedsGestureLayout.CustomClickListener, VideoPlayManager.OnPlayStateListener, VideoPlayManager.VideoStatusListener, AbsListView.OnScrollListener
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoUIManager.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new VideoUIManager.7(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OrientationDetector jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector;
  private VideoBrightnessController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoFullPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoUIManager.CountDownCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback;
  private VideoUIManager.OnUIChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnUIChangeListener;
  private MsgLayoutHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView;
  private VideoViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  public ReadInJoyPatchAdUtils.OnPatchPlayListener a;
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  private ReadInJoyPatchAdView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
  private ReadInJoyVideoAdHighLightBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ArrayList<VideoUIManager.OnUIChangeListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<VideoUIManager.OnScreenChangeListener> jdField_a_of_type_JavaUtilList;
  private articlesummary.VideoDownloadBarInfo jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private int jdField_j_of_type_Int;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private int jdField_k_of_type_Int = 0;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private TextView l;
  private TextView m;
  
  public VideoUIManager(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper = new MsgLayoutHelper(this.jdField_a_of_type_AndroidWidgetFrameLayout, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController = new VideoFullPlayController(paramActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, new VideoUIManager.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector = new OrientationDetector(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController = new VideoBrightnessController(paramActivity);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new VideoUIManager.3(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131379458);
  }
  
  private void A()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  private void B()
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (!VideoFeedsHelper.d()) {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {}
    for (int n = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L);; n = 0)
    {
      ReadInjoyADVideoC2sManger.a(n, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager);
      if (this.jdField_b_of_type_AndroidWidgetSeekBar.isEnabled())
      {
        if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
        }
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(n);
      }
      if ((this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetSeekBar.isEnabled())) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(n, false));
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnUIChangeListener != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnUIChangeListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((VideoUIManager.OnUIChangeListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000);
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a()), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      }
      return;
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    l();
    A();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    O();
    H();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
    }
  }
  
  private void E()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
    {
      if (a()) {
        b(false);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.10(this));
      PlayFeedbackHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a()), 0, 0);
      PlayFeedbackHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a(), 0, 0);
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        localObject = new VideoR5.Builder(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID()).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009505", "0X8009505", 0, 0, "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(), "", (String)localObject, false);
      }
    }
  }
  
  private void H()
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    int n = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      n = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(n);
  }
  
  private void I()
  {
    int n = 0;
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
        n = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void J()
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      }
    }
    int n;
    label244:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo;
          n = i1;
          if (!this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.has()) {
            break label244;
          }
          n = i1;
          if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get() < 0) {
            break label244;
          }
          this.jdField_k_of_type_Int = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get();
          if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
            break;
          }
          this.jdField_k_of_type_Int = 0;
        } while (!QLog.isColorLevel());
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 1");
        return;
        n = i1;
        if (this.jdField_k_of_type_Int != 1) {
          break label244;
        }
        if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get() > 0)) {
          break;
        }
        this.jdField_k_of_type_Int = 0;
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 2");
      return;
      n = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get();
    } while (!QLog.isColorLevel());
    QLog.i("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mDownloadBarStyle:" + this.jdField_k_of_type_Int + ", appearTime:" + n);
  }
  
  private void K()
  {
    if (this.jdField_g_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(), mDownloadBarClicked, return");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L < this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get());
      if ((!c()) && (!b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
    return;
    h(1);
  }
  
  private void L()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365996)).inflate();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362888));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362889));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
    String str = a();
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject = new URL(str);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(a(this.jdField_a_of_type_AndroidAppActivity, false)).setImage((URL)localObject);
        localObject = b();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarPlaying(), iconUrl:" + str + "，iconText:" + (String)localObject);
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setBackgroundDrawable(a(this.jdField_a_of_type_AndroidAppActivity, false));
    }
  }
  
  private void M()
  {
    Object localObject;
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 1) {
        break label259;
      }
      if (RIJPBFieldUtils.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        localObject = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label342;
        }
        localObject = "0X8009BC5";
      }
    }
    for (;;)
    {
      VideoR5.Builder localBuilder = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localBuilder.a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localBuilder.a(RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localBuilder.a().a(), false);
      return;
      label259:
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 2) {
        break;
      }
      if ((RIJPBFieldUtils.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle))))
      {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        break;
      }
      if (!RIJPBFieldUtils.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        break;
      }
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      break;
      label342:
      if (this.jdField_k_of_type_Int == 2) {
        localObject = "0X8009BC7";
      }
    }
  }
  
  private void N()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365997)).inflate();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362888));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362889));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376924));
      this.l = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131366021));
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.l.setOnClickListener(this);
      int n = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843381);
      ((Drawable)localObject1).setBounds(0, 0, n, n);
      this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843286);
      ((Drawable)localObject1).setBounds(0, 0, n, n);
      this.l.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    Object localObject1 = a();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new URL((String)localObject1);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(a(this.jdField_a_of_type_AndroidAppActivity, true)).setImage((URL)localObject2);
        localObject2 = b();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarComplete(), iconUrl:" + (String)localObject1 + "，iconText:" + (String)localObject2);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        E();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setBackgroundDrawable(a(this.jdField_a_of_type_AndroidAppActivity, true));
    }
  }
  
  private void O()
  {
    i(1);
    i(2);
  }
  
  private void P()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
      return;
    }
    if ((VideoFeedsHelper.e()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl)))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl;
      for (;;)
      {
        try
        {
          if (((String)localObject1).endsWith("zip"))
          {
            localObject1 = ReadInJoyLottieDrawable.a((String)localObject1);
            ((ReadInJoyLottieDrawable)localObject1).setRepeatCount(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            ((ReadInJoyLottieDrawable)localObject1).playAnimation();
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        Object localObject2 = new URL(localException);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new EmptyDrawable(0, 50, 150);
        localURLDrawableOptions.mPlayGifImage = true;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private static Drawable a(Context paramContext, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = DisplayUtil.a(paramContext, 12.0F);
    }
    for (int n = DisplayUtil.a(paramContext, 60.0F);; n = DisplayUtil.a(paramContext, 28.0F))
    {
      return new RoundRectColorDrawable(-2565928, i1, n, n);
      i1 = DisplayUtil.a(paramContext, 6.0F);
    }
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (RIJPBFieldUtils.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url))) {
      return RIJPBFieldUtils.b(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconUrl(), null:");
    }
    return null;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.5(this, paramInt, paramString1, paramString2));
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setVisibility(0);
    if (VideoVolumeControl.a().c())
    {
      paramImageView.setImageResource(2130843267);
      paramImageView.setContentDescription(HardCodeUtil.a(2131716252));
      return;
    }
    paramImageView.setImageResource(2130843268);
    paramImageView.setContentDescription(HardCodeUtil.a(2131716257));
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (paramInt == 3)
    {
      if (a()) {
        b(false);
      }
      e();
      return;
    }
    e();
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(boolean paramBoolean, VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video.VideoUIManager", 2, "onScreenChange   isFullScreen:" + paramBoolean + "  enterPlayParam:" + paramVideoPlayParam1 + "   exitPlayParam:" + paramVideoPlayParam2);
    }
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController;
      int n = VideoPlayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView, paramVideoPlayParam1);
      this.jdField_c_of_type_Int = n;
      ((VideoFullPlayController)localObject).a(paramVideoPlayParam1, n);
      localObject = BaseApplicationImpl.getContext();
      if (paramBoolean) {
        break label180;
      }
      bool = true;
      label99:
      ColorNoteSmallScreenUtil.a((Context)localObject, 2, bool);
      t();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      VideoUIManager.OnScreenChangeListener localOnScreenChangeListener = (VideoUIManager.OnScreenChangeListener)((Iterator)localObject).next();
      if (localOnScreenChangeListener != null)
      {
        if (paramBoolean)
        {
          localOnScreenChangeListener.p();
          continue;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a();
          break;
          label180:
          bool = false;
          break label99;
        }
        localOnScreenChangeListener.a(paramVideoPlayParam1, paramVideoPlayParam2);
      }
    }
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (RIJPBFieldUtils.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text))) {
      return RIJPBFieldUtils.b(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1200L);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof VideoFeedsViewHolder)))
    {
      paramObject = (VideoFeedsViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
      if ((paramObject != null) && (paramObject.jdField_g_of_type_AndroidWidgetTextView != null) && (paramObject.jdField_a_of_type_Int == 0))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramObject.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
        }
      }
    }
    ReadInJoyPatchAdUtils.a(paramVideoPlayParam, this, false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841960));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841961));
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void d(View paramView)
  {
    if (a()) {
      b(false);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.8(this));
      return;
      i();
    }
  }
  
  private void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a().setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165357));
      E();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      if ((NetworkUtil.b(this.jdField_a_of_type_AndroidAppActivity)) && (!this.jdField_d_of_type_Boolean))
      {
        y();
        this.jdField_d_of_type_Boolean = true;
      }
      a(this.jdField_f_of_type_AndroidWidgetImageView);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_AndroidWidgetImageView != null)) {
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      J();
      P();
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt == 4)
          {
            E();
            return;
          }
        } while (paramInt != 5);
        if ((e()) && (c()))
        {
          e(2);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
          return;
        }
        if (!d()) {
          break;
        }
        A();
      } while (!NetworkUtil.b(this.jdField_a_of_type_AndroidAppActivity));
      y();
      return;
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    if (!g()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 91.0F);
      localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 28.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
    }
    for (localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);; localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F);
      localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 24.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.a();
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      VideoFeedsHelper.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843459));
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      } while (e());
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843457));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843458));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    } while (e());
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
  }
  
  private void e(View paramView)
  {
    int n = ((Integer)paramView.getTag()).intValue();
    switch (n)
    {
    default: 
      if (2 != n) {
        break;
      }
    }
    for (n = 1;; n = 0)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.9(this, n));
      return;
      if (!VideoAutoPlayController.a().a()) {
        VideoVolumeControl.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.f(true);
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e(true);
      break;
    }
  }
  
  private void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      A();
      e(3);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
      return;
      if (paramInt == 3) {
        e(3);
      }
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(104);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(104, 1500L);
  }
  
  private void f(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (e()) {
      e(1);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean) {
      e(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private boolean f()
  {
    boolean bool = true;
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (this.jdField_b_of_type_AndroidViewView == null) {
          break;
        }
      } while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
      return false;
      if (this.jdField_c_of_type_AndroidViewView == null) {
        break;
      }
    } while (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0);
    return false;
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843409);
    }
    if (paramInt == 0) {
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    for (;;)
    {
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(105);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(105, 1500L);
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
    }
  }
  
  private void g(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    if ((paramObject instanceof int[]))
    {
      paramVideoPlayParam = (int[])paramObject;
      a(1, VideoPlayUtils.a(paramVideoPlayParam[0], paramVideoPlayParam[1]), HardCodeUtil.a(2131716256));
    }
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void h(int paramInt)
  {
    if (f()) {}
    do
    {
      return;
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(): mDownloadBarClicked, just jump.");
    return;
    label56:
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        str = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label281;
        }
        str = "0X8009BC4";
      }
      break;
    }
    for (;;)
    {
      VideoR5.Builder localBuilder = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localBuilder.a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localBuilder.a(RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", str, str, 0, 0, "3", "", "", localBuilder.a().a(), false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(), barStyle:" + paramInt);
      return;
      L();
      break label56;
      N();
      break label56;
      label281:
      if (this.jdField_k_of_type_Int == 2) {
        str = "0X8009BC6";
      }
    }
  }
  
  private void h(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    boolean bool = true;
    if ((!ReadInJoyDisplayUtils.a(paramVideoPlayParam)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(paramVideoPlayParam);
      return;
    }
    if (this.jdField_k_of_type_Int == 2)
    {
      VideoAutoPlayController.jdField_c_of_type_Boolean = true;
      h(2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      label64:
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1) {
        break label150;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof VideoFeedsViewHolder))) {
        break label152;
      }
    }
    for (;;)
    {
      ReadInJoyPatchAdUtils.a(paramVideoPlayParam, this, bool, false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener);
      return;
      b(false);
      e();
      break label64;
      label150:
      break;
      label152:
      bool = false;
    }
  }
  
  private void i(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    } while (this.jdField_c_of_type_AndroidViewView == null);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void o()
  {
    VideoAutoPlayController.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.jdField_k_of_type_Int = 0;
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381401));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370840));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367857));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379487));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379432));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379517);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366079));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368729));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373250));
    this.m = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372644));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372581));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372582));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370003));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372643));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371075));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367659));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367656));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367658));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373577));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369140));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366081));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367657));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381569));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381568));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381566));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView = ((ReadInJoyPatchAdView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372783));
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar = ((ReadInJoyVideoAdHighLightBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368429));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362046));
    UIUtils.a(this.jdField_f_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    UIUtils.a(this.jdField_d_of_type_AndroidWidgetImageView, 20, 20, 20, 20);
    VideoVolumeControl.a().a(this.jdField_f_of_type_AndroidWidgetImageView);
    VideoVolumeControl.a().a(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener = new VideoUIManager.4(this);
    ReadInJoyPatchAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {}
    while (!(this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      return;
    }
    ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRadius(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.o, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.p, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.q, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.r);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRadius(0, 0, 0, 0);
    }
  }
  
  private void t()
  {
    if (a())
    {
      s();
      return;
    }
    r();
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167374));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int, true));
      VideoHandler.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        break label523;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716250));
      label221:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long);
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label568;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843459));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int);
      D();
      d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.n);
      t();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() != 1) {
        ReadInJoyPatchAdUtils.a(this);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.d();
      }
      AdVideo185UIStateUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
      AdVideo185UIStateUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
      AdVideo185UIStateUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount) + HardCodeUtil.a(2131716251));
      break;
      label523:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + HardCodeUtil.a(2131716254));
      break label221;
      label568:
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843379);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (CUKingCardHelper.a() == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716249));
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  }
  
  private void w()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
    B();
    l();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    String str1;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    String str2;
    if (localObject != null)
    {
      localObject = ((VideoPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        str1 = new VideoR5.Builder(null, ((BaseArticleInfo)localObject).getSubscribeUin(), ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), ((BaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str2 = ((BaseArticleInfo)localObject).getSubscribeUin();
        if (TextUtils.isEmpty(((BaseArticleInfo)localObject).getInnerUniqueID())) {
          break label130;
        }
      }
    }
    label130:
    for (localObject = ((BaseArticleInfo)localObject).getInnerUniqueID();; localObject = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      return;
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video.VideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
    return;
    String str;
    if (CUKingCardHelper.a() == 1) {
      str = HardCodeUtil.a(2131716253);
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int n = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      n = (n + (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getHeight() + n) - DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, str, n);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        str = HardCodeUtil.a(2131716248) + VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize);
      } else {
        str = HardCodeUtil.a(2131716247);
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  }
  
  public ReadInJoyAdVideoGuide a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  }
  
  public ReadInJoyPatchAdView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
  }
  
  public ReadInJoyVideoAdHighLightBar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.c();
    if (this.jdField_g_of_type_Boolean) {
      i(1);
    }
    if (a() != null)
    {
      BaseArticleInfo localBaseArticleInfo = a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (((ReadInJoyPatchAdUtils.c(localBaseArticleInfo)) || (ReadInJoyPatchAdUtils.d(localBaseArticleInfo))) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.b();
      }
      if (ReadInJoyPatchAdUtils.a(localBaseArticleInfo)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(a());
      }
      if ((ReadInJoyPatchAdUtils.b(localBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback.a(a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.c();
      }
    }
    AdVideo185UIStateUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
    AdVideo185UIStateUtil.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onOrientationChanged=> orientation=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(false);
      return;
    case 0: 
      b(0);
      return;
    case 8: 
      b(8);
      return;
    }
    b(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int n;
    do
    {
      do
      {
        return;
        n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        if ((n != 0) && (n != 1) && (n != 7) && (n != 2) && (n != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + VideoPlayUtils.a(n) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), null);
    c(true);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
    if ((paramBoolean) && (ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam))) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(false)) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      localWindow.setFlags(1024, 1024);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
      {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent());
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a();
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.b();
        localWindow.addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.jdField_g_of_type_Int + ", mOriginalHeight=" + this.jdField_h_of_type_Int + ", playState=" + VideoPlayUtils.a(n) + "，userClickEnter:" + paramBoolean);
      }
      w();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      x();
      return;
      if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (c())
    {
      l();
      return;
    }
    k();
  }
  
  public void a(View paramView, int paramInt)
  {
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
        } while (!c());
        l();
      } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d());
      this.jdField_f_of_type_Boolean = true;
      return;
    } while (!this.jdField_f_of_type_Boolean);
    k();
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoFullPlayController.OnFullPlayListener paramOnFullPlayListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(paramOnFullPlayListener);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, 8, 300);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (paramVideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != paramVideoPlayParam)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
      }
    }
    do
    {
      return;
      if (paramInt2 == 0)
      {
        a(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 1)
      {
        b(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 2)
      {
        c(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 3)
      {
        d(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 4)
      {
        e(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 5)
      {
        f(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 6)
      {
        g(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
    } while (paramInt2 != 7);
    h(paramVideoPlayParam, paramInt1, paramObject);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367857));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramVideoPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(paramVideoPlayManager);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void a(VideoUIManager.CountDownCallback paramCountDownCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback = paramCountDownCallback;
  }
  
  public void a(VideoUIManager.OnScreenChangeListener paramOnScreenChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramOnScreenChangeListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramOnScreenChangeListener);
    }
  }
  
  public void a(VideoUIManager.OnUIChangeListener paramOnUIChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnUIChangeListener = paramOnUIChangeListener;
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (a()) {}
    int i2;
    int i1;
    int n;
    do
    {
      do
      {
        return;
        i2 = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
        i1 = paramAbsListView.getFirstVisiblePosition() - i2;
        n = i1;
        if (i1 < 0) {
          n = 0;
        }
        i1 = paramAbsListView.getLastVisiblePosition() - i2;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == null));
      i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().jdField_a_of_type_Int;
    } while ((i2 < 0) || ((i2 >= n) && (i2 <= i1)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，firstVisblePosi:" + n + ",lastVisiblePosi:" + i1 + ",playingPosi:" + i2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，playParam:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(10);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(false);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.d();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramVideoPlayParam);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean))
    {
      a(false);
      this.jdField_c_of_type_Boolean = false;
    }
    p();
    u();
    v();
    g();
  }
  
  public void b(VideoUIManager.OnUIChangeListener paramOnUIChangeListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnUIChangeListener);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.b();
    c(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.b();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_j_of_type_Int, new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    l();
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_g_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a() instanceof VideoPlayManager.VideoPlayParam))) {
      a(false, (VideoPlayManager.VideoPlayParam)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
    }
    d(false);
    if (paramBoolean) {
      G();
    }
    f();
    g();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.c();
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetSeekBar == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null)) {
      return;
    }
    VideoVolumeControl.a().a(paramInt);
    paramInt = (int)(VideoVolumeControl.a().a() * this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int);
    if (c())
    {
      g(paramInt);
      return;
    }
    f(paramInt);
  }
  
  public void c(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof VideoHandler.PlayableItem))) {}
    do
    {
      VideoHandler.PlayableItem localPlayableItem;
      do
      {
        int n;
        do
        {
          do
          {
            do
            {
              return;
              n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
              localPlayableItem = (VideoHandler.PlayableItem)paramView.getTag();
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + VideoPlayUtils.a(n) + ", view id: " + VideoFeedsHelper.a(paramView));
              }
              if ((n != 7) || (!f())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
            return;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != null) {
              break;
            }
            if (!VideoAutoPlayController.a().a()) {
              VideoVolumeControl.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(localPlayableItem.a());
            paramView = localPlayableItem.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ((AdvertisementInfo)paramView).adbt = ((int)localPlayableItem.a().jdField_d_of_type_Long);
          ((AdvertisementInfo)paramView).adpa = 1;
          ((AdvertisementInfo)paramView).adpb = 2;
          NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)paramView).a(NativeAdUtils.a(((AdvertisementInfo)paramView).adbt, 0, ((AdvertisementInfo)paramView).getAdbf(), 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)paramView).videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, ((AdvertisementInfo)paramView).isClickReplay, false)));
          ((AdvertisementInfo)paramView).isClickReplay = false;
          return;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() != localPlayableItem.a().jdField_c_of_type_Long) {
            break;
          }
        } while (n == 1);
        if ((n != 5) || (!d())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
      return;
      if (c())
      {
        l();
        return;
      }
      k();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(localPlayableItem.a());
      paramView = localPlayableItem.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)paramView).a(NativeAdUtils.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)paramView).videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, ((AdvertisementInfo)paramView).isClickReplay, false)));
        ((AdvertisementInfo)paramView).isClickReplay = false;
        ((AdvertisementInfo)paramView).adbt = 0;
        ((AdvertisementInfo)paramView).adpa = 1;
        ((AdvertisementInfo)paramView).adpb = 2;
      }
    } while (VideoAutoPlayController.a().a());
    VideoVolumeControl.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
  }
  
  public void c(VideoUIManager.OnUIChangeListener paramOnUIChangeListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnUIChangeListener);
  }
  
  public boolean c()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {}
    while (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.c();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    o();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return;
    }
    float f1 = DeviceInfoUtil.b(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.l > 0) {
        f1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.l;
      }
    }
    float f2;
    for (;;)
    {
      f2 = f1 * ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a()) {
        break;
      }
      this.jdField_g_of_type_Int = ((int)f1);
      this.jdField_h_of_type_Int = ((int)f2);
      w();
      return;
      continue;
      f1 = ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int));
      return;
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
        ((RelativeLayout.LayoutParams)localObject).height = ((int)f2);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int n;
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getX() != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getX()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getX() != 0.0F)) {
        ViewHelper.g(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ArrayOfInt[0]);
      }
      n = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_f_of_type_Int;
    } while (n == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    ViewHelper.f(this.jdField_a_of_type_AndroidWidgetFrameLayout, n);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void i()
  {
    a(0, true);
  }
  
  public void j()
  {
    b(true);
  }
  
  public void k()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      return;
    }
    int n;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if (n != 5) {
        break label232;
      }
      e(1);
      label69:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.a();
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        UIUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      O();
      if (n != 5) {
        break label245;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.6(this));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      a(this.jdField_d_of_type_AndroidWidgetImageView);
      break;
      label232:
      if (n != 3) {
        break label69;
      }
      e(2);
      break label69;
      label245:
      if (n == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
    if ((a()) || (7 == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a())) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  public void m()
  {
    a(0, HardCodeUtil.a(2131716258), VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + HardCodeUtil.a(2131716255));
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector = null;
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + VideoPlayUtils.a(n) + ", view id: " + VideoFeedsHelper.a(paramView));
    }
    if (paramView.getId() == 2131367657) {
      d(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131372581)
      {
        e(paramView);
      }
      else if (paramView.getId() == 2131366410)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d())
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.f(true);
        }
        else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == 6) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null))
        {
          PlayFeedbackHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a(), 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
        }
      }
      else if (paramView.getId() == 2131367656)
      {
        j();
      }
      else
      {
        label221:
        Object localObject;
        if ((paramView.getId() == 2131381568) || (paramView.getId() == 2131381569))
        {
          boolean bool;
          VideoR5.Builder localBuilder;
          if (!VideoVolumeControl.a().c())
          {
            bool = true;
            VideoVolumeControl.a().a(bool, "user click audio btn", 1);
            if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
              continue;
            }
            localBuilder = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
            localBuilder.a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long);
            if (!bool) {
              break label371;
            }
          }
          label371:
          for (localObject = "1";; localObject = "0")
          {
            localBuilder.a("status", localObject);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", localBuilder.a().a(), false);
            break;
            bool = false;
            break label221;
          }
        }
        else if (paramView.getId() == 2131376924)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.a();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
          {
            localObject = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
            ((VideoR5.Builder)localObject).a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", ((VideoR5.Builder)localObject).a().a(), false);
            localObject = (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            ((AdvertisementInfo)localObject).videoReplayCount += 1;
          }
        }
        else if ((paramView.getId() == 2131366021) || (paramView.getId() == 2131366028))
        {
          M();
        }
        else if (paramView.getId() == 2131381440)
        {
          F();
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (((this.jdField_d_of_type_Int != -1) && (this.jdField_d_of_type_Int != paramInt1)) || ((this.jdField_e_of_type_Int != -1) && (this.jdField_e_of_type_Int != paramInt2))) {
      a(paramAbsListView);
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      a(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager
 * JD-Core Version:    0.7.0.1
 */