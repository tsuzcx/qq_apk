package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData.Builder;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashSet;
import java.util.Set;

public class VideoFeedsSoftAdBarDelegateForNormal
  implements VideoFeedsSoftAdBarController.VideoFeedsSoftAdBarDelegateBase
{
  public static final String a;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = 2147483647;
  public ValueAnimator a;
  Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = VideoFeedsSoftAdBarDelegateForNormal.class.getSimpleName();
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo)
  {
    ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData;
    int i;
    if ((paramVideoInfo != null) && (paramContext != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo != null))
    {
      a(paramContext, paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, 1);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.k, 2103, null);
      localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
      localVideoExtraRepoerData.e = (paramVideoInfo.a() * 1000);
      localVideoExtraRepoerData.d = ((int)(localVideoExtraRepoerData.e * this.jdField_a_of_type_Double));
      localVideoExtraRepoerData.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label163;
      }
    }
    label163:
    for (paramContext = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; paramContext = "")
    {
      VideoReporter.b(paramVideoInfo, i, 25, -1, localVideoExtraRepoerData, paramContext);
      return;
    }
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, int paramInt)
  {
    String str1;
    long l1;
    long l2;
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo != null) && (this.jdField_a_of_type_JavaUtilSet != null) && (paramVideoItemHolder != null))
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.j;
      if (paramInt != 1) {
        break label167;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label159;
      }
      l1 = 5040504L;
      l2 = 3L;
    }
    for (;;)
    {
      label67:
      NativeAdUtils.a(paramContext, new AdReportExtData.Builder().a(504L).b(50405L).c(l1).d(str1).d(l2).a(paramVideoInfo.g).b(paramVideoInfo.c).i(String.valueOf(paramVideoItemHolder.jdField_b_of_type_Int)).c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.o).g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.k).a());
      label159:
      label167:
      label237:
      do
      {
        String str2;
        do
        {
          return;
          l1 = 5040502L;
          break;
          l2 = 6L;
          if (!this.jdField_b_of_type_Boolean) {
            break label237;
          }
          str2 = paramVideoInfo.jdField_a_of_type_JavaLangString + "_B";
        } while (this.jdField_a_of_type_JavaUtilSet.contains(str2));
        l1 = 5040503L;
        this.jdField_a_of_type_JavaUtilSet.add(str2);
        break label67;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      l1 = 5040501L;
      this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
          localURLDrawableOptions.mRequestWidth = AIOUtils.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = AIOUtils.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
    }
  }
  
  private boolean b()
  {
    return (this.c) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.o));
  }
  
  public int a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.e)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "soft ad small game");
      return 3;
    }
    return 0;
  }
  
  public CharSequence a()
  {
    if (a() == 3) {
      return ReadInJoyAdUtils.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_Int, "人在玩");
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    if ((a() == 3) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo != null)) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.l;
    }
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.d;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v.getVisibility() != 0)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v.getLayoutParams();
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v.getMeasuredWidth();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.g.getLayoutParams();
    int k = localLayoutParams1.width;
    int m = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int n = AIOUtils.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i1 = AIOUtils.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = AIOUtils.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.getMeasuredWidth();
    int i4 = AIOUtils.a(115.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.getLayoutParams();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoFeedsSoftAdBarDelegateForNormal.1(this, localLayoutParams, i, i1 - i, j, n - j, localLayoutParams1, k, i2 - m, m, localLayoutParams2, i3, i4 - i3));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new VideoFeedsSoftAdBarDelegateForNormal.2(this, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v.setTag(2131362743, this.jdField_a_of_type_AndroidAnimationValueAnimator);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_b_of_type_Int += 1;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, paramVideoItemHolder, 2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = paramVideoItemHolder;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.I.setVisibility(0);
    paramVideoItemHolder.u.setVisibility(0);
    if ((a() == 3) && (paramVideoItemHolder.w != null) && (paramVideoItemHolder.J != null))
    {
      paramVideoItemHolder.w.setVisibility(0);
      paramVideoItemHolder.J.setVisibility(0);
      paramVideoItemHolder.u.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, paramVideoItemHolder, 2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((TextUtils.isEmpty(ReadInJoyHelper.a("sp_key_ad_soft_total_area"))) || ("1".equals(ReadInJoyHelper.a("sp_key_ad_soft_total_area")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.jdField_a_of_type_Int = ParseUtil.a(ReadInJoyHelper.a("sp_key_ad_soft_kd_max"), 2147483647);
      this.jdField_b_of_type_Int = VideoFeedsHelper.a(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate() mConfigIsOpen = " + this.c + ", mConfigMaxShowCount = " + this.jdField_a_of_type_Int + ", mTodayShowCount = " + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) || (c());
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return b();
  }
  
  public boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    int i = Aladdin.getConfig(318).getIntegerFromString("small_game_change_bigger_position", 30);
    if ((paramVideoItemHolder.v != null) && (paramVideoItemHolder.v.getVisibility() == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null))
    {
      if (a() == 3) {}
      while (paramDouble > i)
      {
        return true;
        i = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int;
      }
    }
    return false;
  }
  
  public String b()
  {
    if (a() == 3) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.o;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c.a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.d != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.d.a();
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void b(VideoItemHolder paramVideoItemHolder) {}
  
  public String c()
  {
    if ((a() == 3) && (c())) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataSmallMiniGameInfo.n;
    }
    return "";
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c.b();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.d != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.d.b();
    }
  }
  
  public void c(VideoItemHolder paramVideoItemHolder) {}
  
  public void d()
  {
    if (this.jdField_b_of_type_Int != 0) {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy() mTodayShowCount = " + this.jdField_b_of_type_Int);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (a() == 3) {
      a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    paramView = new VideoR5.Builder("", "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).i(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.j, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal
 * JD-Core Version:    0.7.0.1
 */