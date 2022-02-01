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
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5Builder;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class VideoFeedsSoftAdBarDelegateForNormal
  implements VideoFeedsSoftAdBarDelegateBase
{
  public static final String a = "VideoFeedsSoftAdBarDelegateForNormal";
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = 2147483647;
  public ValueAnimator a;
  Activity jdField_a_of_type_AndroidAppActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private VideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private VideoInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  
  private void a(Context paramContext, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramContext != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo != null))
    {
      a(paramContext, paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, 1);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.k, 2103, null);
      ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
      localVideoExtraRepoerData.e = (paramVideoInfo.c() * 1000);
      double d1 = localVideoExtraRepoerData.e;
      double d2 = this.jdField_a_of_type_Double;
      Double.isNaN(d1);
      localVideoExtraRepoerData.d = ((int)(d1 * d2));
      localVideoExtraRepoerData.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      paramContext = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (paramContext != null) {
        paramContext = paramContext.g;
      } else {
        paramContext = "";
      }
      ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoUserOperationByOidbOfVideoFeeds(paramVideoInfo, i, 25, -1, localVideoExtraRepoerData, paramContext);
    }
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, int paramInt)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo != null) && (this.jdField_a_of_type_JavaUtilSet != null) && (paramVideoItemHolder != null))
    {
      String str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.j;
      long l1;
      long l2;
      if (paramInt == 1)
      {
        if (this.jdField_b_of_type_Boolean) {
          l1 = 5040504L;
        } else {
          l1 = 5040502L;
        }
        l2 = 3L;
      }
      else
      {
        l2 = 6L;
        if (this.jdField_b_of_type_Boolean)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramVideoInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("_B");
          localObject = ((StringBuilder)localObject).toString();
          if (this.jdField_a_of_type_JavaUtilSet.contains(localObject)) {
            return;
          }
          l1 = 5040503L;
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            return;
          }
          l1 = 5040501L;
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
        }
      }
      paramVideoInfo = new AdReportExtData.Builder().a(504L).b(50405L).c(l1).d(str).d(l2).a(paramVideoInfo.g).b(paramVideoInfo.c).i(String.valueOf(paramVideoItemHolder.jdField_b_of_type_Int)).c(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.o).g(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.k).a();
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameAd(paramContext, paramVideoInfo);
    }
  }
  
  private void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (paramInt3 != -1) {
        ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
      }
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      float f = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(f, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(f, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight, paramInt1));
      if (paramInt3 == 0)
      {
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      else if (paramInt3 == 1)
      {
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      else
      {
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.i);
      }
      paramURLImageView.setImageDrawable(localURLDrawable);
      return;
    }
    catch (Exception paramURLImageView)
    {
      Object localObject;
      label186:
      break label186;
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("后台下发的url格式有问题：");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(paramURLImageView, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean b()
  {
    return (this.c) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    VideoInfo localVideoInfo = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    return (localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.o));
  }
  
  public int a()
  {
    VideoInfo localVideoInfo = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if ((localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.e)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "soft ad small game");
      return 3;
    }
    return 0;
  }
  
  public CharSequence a()
  {
    if (a() == 3) {
      return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getFormatNum(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_Int, "人在玩");
    }
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    if ((a() == 3) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo != null)) {
      return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.l;
    }
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.d;
    }
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.c;
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v.getVisibility() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v.getLayoutParams();
      int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v.getMeasuredWidth();
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v.getMeasuredHeight();
      ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.g.getLayoutParams();
      int k = localLayoutParams1.width;
      int m = localLayoutParams1.height;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      int n = AIOUtils.b(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i1 = AIOUtils.b(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i2 = AIOUtils.b(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      int i3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.getMeasuredWidth();
      int i4 = AIOUtils.b(115.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoFeedsSoftAdBarDelegateForNormal.1(this, localLayoutParams, i, i1 - i, j, n - j, localLayoutParams1, k, i2 - m, m, localLayoutParams2, i3, i4 - i3));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new VideoFeedsSoftAdBarDelegateForNormal.2(this, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v.setTag(2131362698, this.jdField_a_of_type_AndroidAnimationValueAnimator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    boolean bool;
    if ((!TextUtils.isEmpty(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_total_area"))) && (!"1".equals(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_total_area")))) {
      bool = false;
    } else {
      bool = true;
    }
    this.c = bool;
    this.jdField_a_of_type_Int = ParseUtil.a(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_kd_max"), 2147483647);
    this.jdField_b_of_type_Int = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getTodayShowCountForSoftAd(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramActivity = new StringBuilder();
      paramActivity.append("onCreate() mConfigIsOpen = ");
      paramActivity.append(this.c);
      paramActivity.append(", mConfigMaxShowCount = ");
      paramActivity.append(this.jdField_a_of_type_Int);
      paramActivity.append(", mTodayShowCount = ");
      paramActivity.append(this.jdField_b_of_type_Int);
      QLog.d(paramQQAppInterface, 2, paramActivity.toString());
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_b_of_type_Int += 1;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, paramVideoItemHolder, 2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = paramVideoItemHolder;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.J.setVisibility(0);
    paramVideoItemHolder.u.setVisibility(0);
    if ((a() == 3) && (paramVideoItemHolder.w != null) && (paramVideoItemHolder.K != null))
    {
      paramVideoItemHolder.w.setVisibility(0);
      paramVideoItemHolder.K.setVisibility(0);
      paramVideoItemHolder.u.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, paramVideoItemHolder, 2);
  }
  
  public boolean a()
  {
    return ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null)) || (c());
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return b();
  }
  
  public boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    int i = Aladdin.getConfig(318).getIntegerFromString("small_game_change_bigger_position", 30);
    if ((paramVideoItemHolder.v != null) && (paramVideoItemHolder.v.getVisibility() == 0) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null))
    {
      if (a() != 3) {
        i = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int;
      }
      if (paramDouble > i) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    if (a() == 3) {
      return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.o;
    }
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.c != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.c);
    }
    localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.d != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.d);
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public void b(VideoItemHolder paramVideoItemHolder) {}
  
  public String c()
  {
    if ((a() == 3) && (c())) {
      return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo.n;
    }
    return "";
  }
  
  public void c()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.c != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.c);
    }
    localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.d != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.d);
    }
  }
  
  public void c(VideoItemHolder paramVideoItemHolder) {}
  
  public void d()
  {
    if (this.jdField_b_of_type_Int != 0) {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).updateTodayShowCountForSoftAd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() mTodayShowCount = ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131368147) && (i != 2131380598)) {
      return;
    }
    if (a() == 3) {
      a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).resolveUrlJumpInfo(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    paramView = ((IVideoR5BuilderFactory)QRoute.api(IVideoR5BuilderFactory.class)).create("", "", this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g).a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g).a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.j, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal
 * JD-Core Version:    0.7.0.1
 */