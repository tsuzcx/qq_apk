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
  QQAppInterface b;
  Activity c;
  public ValueAnimator d;
  public boolean e;
  private VideoInfo f;
  private VideoInfo g;
  private boolean h = false;
  private boolean i = true;
  private int j = 2147483647;
  private int k = 0;
  private Set<String> l;
  private VideoItemHolder m;
  private double n;
  
  private void a(Context paramContext, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramContext != null) && (paramVideoInfo.aK != null) && (paramVideoInfo.aK.i != null))
    {
      a(paramContext, paramVideoInfo, this.m, 1);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramVideoInfo.aK.i.n, 2103, null);
      ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
      localVideoExtraRepoerData.e = (paramVideoInfo.k() * 1000);
      double d1 = localVideoExtraRepoerData.e;
      double d2 = this.n;
      Double.isNaN(d1);
      localVideoExtraRepoerData.d = ((int)(d1 * d2));
      localVideoExtraRepoerData.b = this.c.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int i1 = this.c.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      paramContext = this.f;
      if (paramContext != null) {
        paramContext = paramContext.l;
      } else {
        paramContext = "";
      }
      ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoUserOperationByOidbOfVideoFeeds(paramVideoInfo, i1, 25, -1, localVideoExtraRepoerData, paramContext);
    }
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, int paramInt)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.aK != null) && (paramVideoInfo.aK.i != null) && (this.l != null) && (paramVideoItemHolder != null))
    {
      String str = paramVideoInfo.aK.i.m;
      long l1;
      long l2;
      if (paramInt == 1)
      {
        if (this.h) {
          l1 = 5040504L;
        } else {
          l1 = 5040502L;
        }
        l2 = 3L;
      }
      else
      {
        l2 = 6L;
        if (this.h)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramVideoInfo.b);
          ((StringBuilder)localObject).append("_B");
          localObject = ((StringBuilder)localObject).toString();
          if (this.l.contains(localObject)) {
            return;
          }
          l1 = 5040503L;
          this.l.add(localObject);
        }
        else
        {
          if (this.l.contains(paramVideoInfo.b)) {
            return;
          }
          l1 = 5040501L;
          this.l.add(paramVideoInfo.b);
        }
      }
      paramVideoInfo = new AdReportExtData.Builder().a(504L).b(50405L).c(l1).d(str).d(l2).a(paramVideoInfo.l).b(paramVideoInfo.g).i(String.valueOf(paramVideoItemHolder.Y)).c(paramVideoInfo.aK.i.r).g(paramVideoInfo.aK.i.n).a();
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
      float f1 = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(f1, this.c.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(f1, this.c.getResources());
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight, paramInt1));
      if (paramInt3 == 0)
      {
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else if (paramInt3 == 1)
      {
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else
      {
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
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
      paramURLImageView = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("后台下发的url格式有问题：");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(paramURLImageView, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean k()
  {
    return (this.i) && (this.k < this.j);
  }
  
  private boolean l()
  {
    VideoInfo localVideoInfo = this.g;
    return (localVideoInfo != null) && (localVideoInfo.aK != null) && (this.g.aK.i != null) && (!TextUtils.isEmpty(this.g.aK.i.r));
  }
  
  public void a(double paramDouble)
  {
    this.n = paramDouble;
  }
  
  public void a(int paramInt)
  {
    if (this.e) {
      return;
    }
    if ((this.m.bE != null) && (this.m.bE.getVisibility() == 0))
    {
      this.e = true;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.m.bE.getLayoutParams();
      int i1 = this.m.bE.getMeasuredWidth();
      int i2 = this.m.bE.getMeasuredHeight();
      ViewGroup.LayoutParams localLayoutParams1 = this.m.bu.getLayoutParams();
      int i3 = localLayoutParams1.width;
      int i4 = localLayoutParams1.height;
      this.d = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      int i5 = AIOUtils.b(41.0F, this.c.getResources());
      int i6 = AIOUtils.b(197.0F, this.c.getResources());
      int i7 = AIOUtils.b(33.0F, this.c.getResources());
      int i8 = this.m.bw.getMeasuredWidth();
      int i9 = AIOUtils.b(115.0F, this.c.getResources());
      ViewGroup.LayoutParams localLayoutParams2 = this.m.bw.getLayoutParams();
      this.d.addUpdateListener(new VideoFeedsSoftAdBarDelegateForNormal.1(this, localLayoutParams, i1, i6 - i1, i2, i5 - i2, localLayoutParams1, i3, i7 - i4, i4, localLayoutParams2, i8, i9 - i8));
      this.d.addListener(new VideoFeedsSoftAdBarDelegateForNormal.2(this, paramInt));
      this.m.bE.setTag(2131428370, this.d);
      this.d.setDuration(500L);
      this.d.start();
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.b = paramQQAppInterface;
    this.c = paramActivity;
    boolean bool;
    if ((!TextUtils.isEmpty(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_total_area"))) && (!"1".equals(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_total_area")))) {
      bool = false;
    } else {
      bool = true;
    }
    this.i = bool;
    this.j = ParseUtil.a(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("sp_key_ad_soft_kd_max"), 2147483647);
    this.k = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getTodayShowCountForSoftAd(paramQQAppInterface);
    this.l = new HashSet();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = a;
      paramActivity = new StringBuilder();
      paramActivity.append("onCreate() mConfigIsOpen = ");
      paramActivity.append(this.i);
      paramActivity.append(", mConfigMaxShowCount = ");
      paramActivity.append(this.j);
      paramActivity.append(", mTodayShowCount = ");
      paramActivity.append(this.k);
      QLog.d(paramQQAppInterface, 2, paramActivity.toString());
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.g = paramVideoInfo;
    this.h = false;
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    this.k += 1;
    a(this.c, this.g, paramVideoItemHolder, 2);
    this.m = paramVideoItemHolder;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.bx.setVisibility(0);
    paramVideoItemHolder.by.setVisibility(0);
    if ((f() == 3) && (paramVideoItemHolder.bB != null) && (paramVideoItemHolder.bC != null))
    {
      paramVideoItemHolder.bB.setVisibility(0);
      paramVideoItemHolder.bC.setVisibility(0);
      paramVideoItemHolder.by.setVisibility(8);
    }
    this.h = true;
    a(this.c, this.g, paramVideoItemHolder, 2);
  }
  
  public boolean a()
  {
    return ((this.g.aK != null) && (!TextUtils.isEmpty(this.g.aK.a)) && (this.g.aK.f != null)) || (l());
  }
  
  public boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    int i1 = Aladdin.getConfig(318).getIntegerFromString("small_game_change_bigger_position", 30);
    if ((paramVideoItemHolder.bE != null) && (paramVideoItemHolder.bE.getVisibility() == 0) && (this.g.aK != null))
    {
      if (f() != 3) {
        i1 = this.g.aK.e;
      }
      if (paramDouble > i1) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    if ((f() == 3) && (this.g.aK.i != null)) {
      return this.g.aK.i.o;
    }
    if (this.h) {
      return this.g.aK.d;
    }
    return this.g.aK.c;
  }
  
  public void b(VideoItemHolder paramVideoItemHolder) {}
  
  public boolean b(VideoInfo paramVideoInfo)
  {
    return k();
  }
  
  public String c()
  {
    if (f() == 3) {
      return this.g.aK.i.r;
    }
    return this.g.aK.a;
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.f = paramVideoInfo;
  }
  
  public void c(VideoItemHolder paramVideoItemHolder) {}
  
  public CharSequence d()
  {
    if (f() == 3) {
      return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getFormatNum(this.g.aK.h, "人在玩");
    }
    return this.g.aK.b;
  }
  
  public String e()
  {
    if ((f() == 3) && (l())) {
      return this.g.aK.i.q;
    }
    return "";
  }
  
  public int f()
  {
    VideoInfo localVideoInfo = this.g;
    if ((localVideoInfo != null) && (localVideoInfo.aK != null) && (!TextUtils.isEmpty(this.g.aK.g)))
    {
      QLog.d(a, 2, "soft ad small game");
      return 3;
    }
    return 0;
  }
  
  public void g()
  {
    this.n = 0.0D;
  }
  
  public void h()
  {
    VideoItemHolder localVideoItemHolder = this.m;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bN != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.m.bN);
    }
    localVideoItemHolder = this.m;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bO != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.m.bO);
    }
  }
  
  public void i()
  {
    VideoItemHolder localVideoItemHolder = this.m;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bN != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.m.bN);
    }
    localVideoItemHolder = this.m;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bO != null)) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadViewOnResume(this.m.bO);
    }
  }
  
  public void j()
  {
    if (this.k != 0) {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).updateTodayShowCountForSoftAd(this.b, this.k);
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() mTodayShowCount = ");
      localStringBuilder.append(this.k);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131435004) && (i1 != 2131449556)) {
      return;
    }
    if (f() == 3) {
      a(this.c, this.g);
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).resolveUrlJumpInfo(this.c, this.g.aK.f);
    paramView = ((IVideoR5BuilderFactory)QRoute.api(IVideoR5BuilderFactory.class)).create("", "", this.g.b, this.g.l).a(this.g.l).a(this.g.aK);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, this.g.q, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal
 * JD-Core Version:    0.7.0.1
 */