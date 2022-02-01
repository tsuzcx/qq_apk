package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.OnClickCloseListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJLiujinAdJumpService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;

public class VideoFeedsSoftAdBarDelegateForAd
  implements View.OnClickListener, VideoFeedsSoftAdBarDelegateBase
{
  private TextView A;
  private RelativeLayout B;
  private TextView C;
  private RelativeLayout D;
  private View E;
  private TextView F;
  private RelativeLayout G;
  private VideoFeedsSoftAdTest H;
  private TextView I;
  private TextView J;
  private RelativeLayout K;
  private RelativeLayout L;
  private Handler M = new VideoFeedsSoftAdBarDelegateForAd.3(this, Looper.getMainLooper());
  public boolean a = false;
  public boolean b;
  private HashMap<String, ADVideoAppDownloadData> c = new HashMap();
  private boolean d = false;
  private VideoInfo e;
  private VideoInfo f;
  private int g;
  private Activity h;
  private boolean i = false;
  private VideoItemHolder j;
  private Set<String> k;
  private Set<String> l;
  private VideoFeedsGameAdComBarConfigure m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private OnClickCloseListener q;
  private int r = -1;
  private Set<String> s;
  private double t = 0.0D;
  private View u;
  private ImageView v;
  private URLImageView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, AdClickPos paramAdClickPos, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramReportAction, paramInteger, false, paramAdClickPos, paramBoolean);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, AdClickPos paramAdClickPos, boolean paramBoolean2)
  {
    if (this.f != null)
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) == null) {
        return;
      }
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).setClickPos(paramInt2);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).setAdClickPos(paramAdClickPos);
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null) {
        ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.d = this.i;
      }
      ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f), 35, paramInt1, 5, paramBoolean1, paramBoolean2);
    }
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramReportAction, paramInteger, paramBoolean1, null, paramBoolean2);
  }
  
  private void a(TextView paramTextView)
  {
    String str = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.S;
    if (!TextUtils.isEmpty(str))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(str);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    boolean bool = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isVideoFeedsTiktokStyle();
    int i2 = 0;
    Object localObject;
    int i1;
    if ((!bool) && (paramVideoItemHolder != null) && (paramVideoItemHolder.aH != null))
    {
      localObject = paramVideoItemHolder.aH;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ViewGroup)localObject).setVisibility(i1);
    }
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.aG != null))
    {
      localObject = paramVideoItemHolder.aG;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((TextView)localObject).setVisibility(i1);
    }
    if ((bool) && (paramVideoItemHolder != null) && (paramVideoItemHolder.bY != null) && (paramVideoItemHolder.bY.findViewById(2131434955) != null))
    {
      localObject = paramVideoItemHolder.bY.findViewById(2131434955);
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((View)localObject).setVisibility(i1);
    }
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.aJ != null))
    {
      localObject = paramVideoItemHolder.aJ;
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((AbsReadInJoyNickNameTextView)localObject).setVisibility(i1);
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setFollowTextVisibility(paramVideoItemHolder, paramBoolean);
  }
  
  private void a(boolean paramBoolean)
  {
    ReportAction localReportAction = ReportAction.EXPOSE;
    Integer localInteger = Integer.valueOf(0);
    a(2, 0, localReportAction, localInteger, true, paramBoolean);
    a(2, 0, ReportAction.EXPOSE, localInteger, false, paramBoolean);
    if (!paramBoolean)
    {
      b(false);
      return;
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo == null) {
        return false;
      }
      if ((paramAdvertisementInfo.mAdvertisementSoftInfo.o == 0) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.R)) && (paramAdvertisementInfo.mAdvertisementSoftInfo.R.equals("1"))) {
        return true;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.N)) {
        return !TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.M);
      }
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo, double paramDouble, long paramLong)
  {
    double d1 = paramLong / 1000L;
    Double.isNaN(d1);
    d1 = d1 * paramDouble / 100.0D;
    if (this.o)
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.J))
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.J.equals("1")) {
          return paramDouble > Integer.valueOf(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.K).intValue();
        }
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.J.equals("2"))
        {
          int i1 = Integer.valueOf(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.L).intValue();
          return (d1 != 0.0D) && (d1 > i1);
        }
      }
      return false;
    }
    return paramDouble > this.g;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      if (paramBoolean)
      {
        NativeAdUtils.c(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.ak);
        return;
      }
      NativeAdUtils.c(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.aj);
    }
  }
  
  private void d(VideoInfo paramVideoInfo)
  {
    this.f = paramVideoInfo;
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      this.g = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.n;
      this.o = "1".equals(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.I);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.c = this.o;
      this.p = false;
    }
    if (this.H != null) {
      VideoFeedsSoftAdTest.a(this.f);
    }
  }
  
  private void g(VideoItemHolder paramVideoItemHolder)
  {
    if ((this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo == null) {
        return;
      }
      if (VideoFeedsSoftAdAms65.a(this.f))
      {
        k(paramVideoItemHolder);
        return;
      }
      if (VideoFeedsSoftAdAms184.a(this.f))
      {
        l(paramVideoItemHolder);
        return;
      }
      if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo))
      {
        this.H.b(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo);
        return;
      }
      j(paramVideoItemHolder);
    }
  }
  
  private void h(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.bX.setVisibility(0);
    String str1 = v();
    String str2 = w();
    paramVideoItemHolder.bR.setText(str2);
    VideoFeedsSoftAdBarController.a(paramVideoItemHolder.bQ, str1, AIOUtils.b(5.0F, this.h.getResources()), 22, 22, -1, this.h);
    paramVideoItemHolder.bX.setTag(paramVideoItemHolder);
    paramVideoItemHolder.bX.setOnClickListener(this);
    paramVideoItemHolder.bF.setTag(paramVideoItemHolder);
    paramVideoItemHolder.bF.setOnClickListener(this);
  }
  
  private void i(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.bX.setVisibility(0);
    paramVideoItemHolder.bX.setVisibility(0);
    String str = b();
    VideoFeedsSoftAdBarController.a(paramVideoItemHolder.bG, str, AIOUtils.b(6.0F, this.h.getResources()), 40, 40, -1, this.h);
    str = c();
    CharSequence localCharSequence = d();
    if ((paramVideoItemHolder.bO != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null))
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAdvertisementInfo: videoTitle = ");
      localStringBuilder.append(this.f.g);
      localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
      ((RIJDownloadView)paramVideoItemHolder.bO).setAdvertisementInfo(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f));
      ((RIJDownloadView)paramVideoItemHolder.bO).setDownloadScene(AdDownloadScene.SoftButton);
      ((RIJDownloadView)paramVideoItemHolder.bO).setActivity(new SoftReference(this.h));
      ((RIJDownloadView)paramVideoItemHolder.bO).setProgressStyle(RoundProgressStyle.VideoSoftAd);
      ((RIJDownloadView)paramVideoItemHolder.bO).setOnClickListener(this);
      ((RIJDownloadView)paramVideoItemHolder.bO).a(true);
    }
    paramVideoItemHolder.bH.setText(str);
    paramVideoItemHolder.bI.setText(localCharSequence);
    paramVideoItemHolder.bX.setTag(paramVideoItemHolder);
    paramVideoItemHolder.bX.setOnClickListener(this);
    paramVideoItemHolder.bJ.setTag(paramVideoItemHolder);
    paramVideoItemHolder.bJ.setOnClickListener(this);
    ((RIJDownloadView)paramVideoItemHolder.bO).setTag(paramVideoItemHolder);
    paramVideoItemHolder.bF.setTag(paramVideoItemHolder);
    paramVideoItemHolder.bF.setOnClickListener(this);
  }
  
  private void j(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject = d();
    VideoFeedsSoftAdBarController.a(this.w, b(), AIOUtils.b(12.0F, this.h.getResources()), 65, 65, -1, this.h);
    this.x.setText(c());
    this.y.setText((CharSequence)localObject);
    this.z.setText((CharSequence)localObject);
    this.C.setText(e());
    a(this.F);
    if ((paramVideoItemHolder.bN != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null))
    {
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAdvertisementInfo: videoTitle = ");
      localStringBuilder.append(this.f.g);
      ((IRIJAdLogService)localObject).d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdBtnTxt = e();
      ((RIJDownloadView)paramVideoItemHolder.bN).setAdvertisementInfo(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f));
      ((RIJDownloadView)paramVideoItemHolder.bN).setDownloadScene(AdDownloadScene.SoftButton);
      ((RIJDownloadView)paramVideoItemHolder.bN).setActivity(new SoftReference(this.h));
      ((RIJDownloadView)paramVideoItemHolder.bN).setProgressStyle(HorizontalProgressStyle.VideoCardStyleTikTok);
      ((RIJDownloadView)paramVideoItemHolder.bN).setOnClickListener(this);
      ((RIJDownloadView)paramVideoItemHolder.bN).a(true);
      ((RIJDownloadView)paramVideoItemHolder.bN).setTag(paramVideoItemHolder);
    }
    this.B.setOnClickListener(this);
    this.B.setTag(paramVideoItemHolder);
    this.v.setOnClickListener(this);
    this.v.setTag(paramVideoItemHolder);
    this.C.setOnClickListener(this);
    this.C.setTag(paramVideoItemHolder);
    if (f() == 0)
    {
      this.z.setVisibility(8);
      if ((!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v)) && (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u)))
      {
        this.A.setVisibility(8);
      }
      else if ((TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v)) && (TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u)))
      {
        this.A.setVisibility(8);
      }
      else
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(2.0F, this.h.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
        this.A.setVisibility(0);
        this.A.setBackgroundDrawable((Drawable)localObject);
      }
      this.y.setVisibility(0);
      this.C.setVisibility(0);
      this.z.setVisibility(8);
      if (paramVideoItemHolder.bN != null) {
        ((RIJDownloadView)paramVideoItemHolder.bN).setVisibility(8);
      }
    }
    else if (f() == 2)
    {
      this.z.setVisibility(0);
      this.C.setVisibility(0);
      this.y.setVisibility(8);
      this.A.setVisibility(8);
      if (paramVideoItemHolder.bN != null) {
        ((RIJDownloadView)paramVideoItemHolder.bN).setVisibility(8);
      }
    }
    else if (f() == 1)
    {
      this.z.setVisibility(0);
      this.C.setVisibility(8);
      this.y.setVisibility(8);
      this.A.setVisibility(8);
      if (paramVideoItemHolder.bN != null) {
        ((RIJDownloadView)paramVideoItemHolder.bN).setVisibility(0);
      }
    }
  }
  
  private void k(VideoItemHolder paramVideoItemHolder)
  {
    VideoFeedsSoftAdBarController.a(this.w, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdImg, AIOUtils.b(20.0F, this.h.getResources()), VideoFeedsSoftAdAms65.c(this.f, this.h), VideoFeedsSoftAdAms65.d(this.f, this.h), 0, this.h);
    this.x.setText(c());
    a(this.I);
    this.B.setOnClickListener(this);
    this.B.setTag(paramVideoItemHolder);
    this.v.setOnClickListener(this);
    this.v.setTag(paramVideoItemHolder);
  }
  
  private void l(VideoItemHolder paramVideoItemHolder)
  {
    VideoFeedsSoftAdBarController.a(this.w, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdImg, AIOUtils.b(10.0F, this.h.getResources()), VideoFeedsSoftAdAms184.c(this.f, this.h), VideoFeedsSoftAdAms184.d(this.f, this.h), -1, this.h);
    this.x.setText(c());
    a(this.J);
    CharSequence localCharSequence = d();
    this.z.setText(localCharSequence);
    this.B.setOnClickListener(this);
    this.B.setTag(paramVideoItemHolder);
    this.v.setOnClickListener(this);
    this.v.setTag(paramVideoItemHolder);
  }
  
  private void o()
  {
    if ((this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo == null) {
        return;
      }
      p();
      this.v = ((ImageView)this.u.findViewById(2131427622));
      this.w = ((URLImageView)this.u.findViewById(2131427630));
      this.x = ((TextView)this.u.findViewById(2131427636));
      this.y = ((TextView)this.u.findViewById(2131427632));
      this.z = ((TextView)this.u.findViewById(2131427626));
      this.A = ((TextView)this.u.findViewById(2131427634));
      this.B = ((RelativeLayout)this.u.findViewById(2131427629));
      this.C = ((TextView)this.u.findViewById(2131427620));
      this.D = ((RelativeLayout)this.u.findViewById(2131427618));
      this.E = this.u.findViewById(2131427624);
      this.F = ((TextView)this.u.findViewById(2131427862));
      this.G = ((RelativeLayout)this.u.findViewById(2131427631));
      if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo)) {
        this.H.a(this.u);
      }
      Object localObject;
      ViewGroup.LayoutParams localLayoutParams1;
      if (VideoFeedsSoftAdAms65.a(this.f))
      {
        this.I = ((TextView)this.u.findViewById(2131427864));
        this.K = ((RelativeLayout)this.u.findViewById(2131438097));
        localObject = this.B.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = VideoFeedsSoftAdAms65.a(this.f, this.h);
        ((ViewGroup.LayoutParams)localObject).height = VideoFeedsSoftAdAms65.b(this.f, this.h);
        localLayoutParams1 = this.w.getLayoutParams();
        localLayoutParams1.width = VideoFeedsSoftAdAms65.c(this.f, this.h);
        localLayoutParams1.height = VideoFeedsSoftAdAms65.d(this.f, this.h);
        this.w.setLayoutParams(localLayoutParams1);
        this.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      if (VideoFeedsSoftAdAms184.a(this.f))
      {
        this.J = ((TextView)this.u.findViewById(2131427863));
        this.L = ((RelativeLayout)this.u.findViewById(2131438096));
        localObject = this.B.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = VideoFeedsSoftAdAms184.a(this.f, this.h);
        ((ViewGroup.LayoutParams)localObject).height = VideoFeedsSoftAdAms184.b(this.f, this.h);
        localLayoutParams1 = this.w.getLayoutParams();
        localLayoutParams1.width = VideoFeedsSoftAdAms184.c(this.f, this.h);
        localLayoutParams1.height = VideoFeedsSoftAdAms184.d(this.f, this.h);
        ViewGroup.LayoutParams localLayoutParams2 = this.L.getLayoutParams();
        localLayoutParams2.width = VideoFeedsSoftAdAms184.c(this.f, this.h);
        this.L.setLayoutParams(localLayoutParams2);
        this.w.setLayoutParams(localLayoutParams1);
        this.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      this.j.bN = ((FrameLayout)this.u.findViewById(2131427687));
      if (this.C != null)
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(19.0F, this.h.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FF12B7F5"));
        this.C.setBackgroundDrawable((Drawable)localObject);
      }
    }
  }
  
  private void p()
  {
    Object localObject = this.u;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (VideoFeedsSoftAdAms65.a(this.f))
    {
      if (this.j.bU == null)
      {
        localObject = (ViewStub)this.j.bS.findViewById(2131449716);
        this.j.bU = ((ViewGroup)((ViewStub)localObject).inflate());
      }
      this.u = this.j.bU;
      return;
    }
    if (VideoFeedsSoftAdAms184.a(this.f))
    {
      if (this.j.bV == null)
      {
        localObject = (ViewStub)this.j.bS.findViewById(2131449715);
        this.j.bV = ((ViewGroup)((ViewStub)localObject).inflate());
      }
      this.u = this.j.bV;
      return;
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo))
    {
      if (this.j.bW == null)
      {
        localObject = (ViewStub)this.j.bS.findViewById(2131449719);
        this.j.bW = ((ViewGroup)((ViewStub)localObject).inflate());
      }
      this.u = this.j.bW;
      return;
    }
    if (this.j.bT == null)
    {
      localObject = (ViewStub)this.j.bS.findViewById(2131449717);
      this.j.bT = ((ViewGroup)((ViewStub)localObject).inflate());
    }
    this.u = this.j.bT;
  }
  
  private int q()
  {
    if (VideoFeedsSoftAdAms65.a(this.f)) {
      return VideoFeedsSoftAdAms65.a(this.f, this.h);
    }
    if (VideoFeedsSoftAdAms184.a(this.f)) {
      return VideoFeedsSoftAdAms184.a(this.f, this.h);
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo)) {
      return AIOUtils.b(220.0F, this.h.getResources());
    }
    return AIOUtils.b(220.0F, this.h.getResources());
  }
  
  private int r()
  {
    if (VideoFeedsSoftAdAms65.a(this.f)) {
      return VideoFeedsSoftAdAms65.b(this.f, this.h);
    }
    if (VideoFeedsSoftAdAms184.a(this.f)) {
      return VideoFeedsSoftAdAms184.b(this.f, this.h);
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo)) {
      return AIOUtils.b(178.0F, this.h.getResources());
    }
    return AIOUtils.b(123.0F, this.h.getResources());
  }
  
  @RequiresApi(api=16)
  private void s()
  {
    if (this.u == null) {
      return;
    }
    GradientDrawable localGradientDrawable;
    float f1;
    if (VideoFeedsSoftAdAms65.a(this.f))
    {
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(10.0F, this.h.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#7F292A2F"));
      this.D.setBackgroundDrawable(localGradientDrawable);
      localGradientDrawable = new GradientDrawable();
      if (VideoFeedsSoftAdAms65.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo) == 2)
      {
        localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
        this.x.setTextColor(-16777216);
      }
      else if (VideoFeedsSoftAdAms65.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo) == 0)
      {
        localGradientDrawable.setColor(Color.parseColor("#7F292A2F"));
      }
      f1 = AIOUtils.b(10.0F, this.h.getResources());
      localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 });
      this.x.setBackgroundDrawable(localGradientDrawable);
      if (this.K != null)
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColors(new int[] { Color.argb(102, 0, 0, 0), Color.argb(0, 0, 0, 0) });
        localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
        this.K.setBackgroundDrawable(localGradientDrawable);
      }
      return;
    }
    if (VideoFeedsSoftAdAms184.a(this.f))
    {
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(10.5F, this.h.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
      this.D.setBackgroundDrawable(localGradientDrawable);
      if (this.L != null)
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColors(new int[] { Color.argb(102, 0, 0, 0), Color.argb(0, 0, 0, 0) });
        f1 = AIOUtils.b(10.0F, this.h.getResources());
        localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
        this.L.setBackgroundDrawable(localGradientDrawable);
      }
      return;
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo))
    {
      this.H.a();
      return;
    }
    if ((this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.M != null)) {}
    try
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.M.equals("white"))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(10.5F, this.h.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#FFFFFFFF"));
        this.D.setBackgroundDrawable(localGradientDrawable);
      }
      else
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(10.5F, this.h.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#7F292A2F"));
        this.D.setBackgroundDrawable(localGradientDrawable);
        this.x.setTextColor(Color.parseColor("#FFFFFF"));
        if (this.z != null) {
          this.z.setTextColor(Color.parseColor("#FFFFFF"));
        }
      }
      int i1 = AIOUtils.b(12.0F, this.h.getResources());
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      f1 = i1;
      localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, f1, f1, 0.0F, 0.0F, f1, f1 });
      localGradientDrawable.setColor(Color.parseColor("#33000000"));
      this.F.setBackgroundDrawable(localGradientDrawable);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label835:
      break label835;
    }
    QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "smallCardShowTime Format error");
  }
  
  private void t()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((VideoInfo)localObject).b;
      if (this.f.b != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f.b);
        ((StringBuilder)localObject).append("_B");
        localObject = ((StringBuilder)localObject).toString();
      }
      Set localSet = this.s;
      if ((localSet != null) && (!localSet.contains(localObject)))
      {
        this.s.add(localObject);
        if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo))
        {
          this.H.a(true);
          return;
        }
        a(true);
      }
    }
  }
  
  private Integer u()
  {
    AdvertisementInfo localAdvertisementInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f);
    Integer localInteger = Integer.valueOf(-1);
    if (localAdvertisementInfo == null)
    {
      QLog.e("VideoFeedsSoftAdBarDelegateForAd", 1, "videoSoftAd jump error, advertisementInfo is null");
      return localInteger;
    }
    if (((IRIJLiujinAdJumpService)QRoute.api(IRIJLiujinAdJumpService.class)).isFromLiuJin(localAdvertisementInfo)) {
      localInteger = ((IRIJLiujinAdJumpService)QRoute.api(IRIJLiujinAdJumpService.class)).doJumpAction(localAdvertisementInfo, this.h);
    }
    if (localInteger.intValue() != -1) {
      return localInteger;
    }
    return ReadInJoyAdJumpUtils.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f), this.h);
  }
  
  private String v()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.P)) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.P;
      }
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.o == 0) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdCorporateLogo;
      }
      return b();
    }
    return null;
  }
  
  private String w()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.Q)) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.Q;
      }
      return c();
    }
    return "";
  }
  
  private CharSequence x()
  {
    boolean bool = TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v);
    Object localObject1 = "";
    if (bool)
    {
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u;
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u);
    String str1 = ((StringBuilder)localObject2).toString();
    if (!TextUtils.isEmpty(str1.trim()))
    {
      localObject2 = new SpannableStringBuilder(str1);
      bool = TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v);
      float f1 = 13.0F;
      int i1;
      int i2;
      if (!bool)
      {
        localObject1 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v;
        if (str1.contains((CharSequence)localObject1))
        {
          i1 = str1.indexOf((String)localObject1);
          i2 = ((String)localObject1).length() + i1;
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i1, i2, 33);
          ((SpannableStringBuilder)localObject2).setSpan(new AbsoluteSizeSpan(AIOUtils.b(13.0F, this.h.getResources())), i1, i2, 33);
          ((SpannableStringBuilder)localObject2).setSpan(new VideoFeedsSoftAdBarDelegateForAd.MarginSpan(AIOUtils.b(4.0F, this.h.getResources())), i2, i2 + 1, 33);
        }
      }
      String str2 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = localObject2;
        if (str1.contains(str2))
        {
          i1 = str1.indexOf(str2);
          i2 = str2.length() + i1;
          if (!i()) {
            ((SpannableStringBuilder)localObject2).setSpan(new StrikethroughSpan(), i1, i2, 33);
          } else {
            ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i1, i2, 33);
          }
          ((SpannableStringBuilder)localObject2).setSpan(new StrikethroughSpan(), i1, i2, 33);
          if (!i()) {
            f1 = 11.0F;
          }
          ((SpannableStringBuilder)localObject2).setSpan(new AbsoluteSizeSpan(AIOUtils.b(f1, this.h.getResources())), i1, i2, 33);
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  public void a(double paramDouble)
  {
    this.t = paramDouble;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.h = paramActivity;
    this.k = new HashSet();
    this.l = new HashSet();
    this.s = new HashSet();
    this.m = new VideoFeedsGameAdComBarConfigure(paramQQAppInterface);
    this.H = new VideoFeedsSoftAdTest(paramActivity, this);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.i = false;
    this.n = false;
    d(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    this.d = false;
    this.j = paramVideoItemHolder;
    if (paramVideoItemHolder.bX != null) {
      paramVideoItemHolder.bX.setTag(2131449867, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo);
    }
    f(paramVideoItemHolder);
    if (!this.k.contains(paramVideoInfo.b))
    {
      this.k.add(paramVideoInfo.b);
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (!((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).isKolSoftAd())) {
        this.m.a();
      }
      SoftAdExpoStatManager.a().a(paramVideoItemHolder.getAdapterPosition());
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)) {
        SoftAdExpoStatManager.a().a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.ad);
      }
      a(false);
    }
  }
  
  @RequiresApi(api=16)
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if (this.b) {
      return;
    }
    o();
    s();
    this.u.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.u.getLayoutParams();
    localLayoutParams.width = q();
    localLayoutParams.height = r();
    this.u.setLayoutParams(localLayoutParams);
    int i1;
    int i2;
    if ((paramVideoItemHolder.bX != null) && (paramVideoItemHolder.bX.getVisibility() == 0))
    {
      this.b = true;
      g(paramVideoItemHolder);
      localLayoutParams = this.D.getLayoutParams();
      i1 = paramVideoItemHolder.bF.getWidth();
      localLayoutParams.width = i1;
      localLayoutParams.height = 1;
      this.D.setLayoutParams(localLayoutParams);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(600L);
      this.u.setVisibility(0);
      i2 = q();
      int i3 = r();
      paramVideoItemHolder.bP.setVisibility(8);
      a(paramVideoItemHolder, false);
      localValueAnimator.addUpdateListener(new VideoFeedsSoftAdBarDelegateForAd.1(this, i2, i1, localLayoutParams, i3));
      localValueAnimator.addListener(new VideoFeedsSoftAdBarDelegateForAd.2(this, paramVideoItemHolder));
      localValueAnimator.start();
      i1 = 10;
    }
    try
    {
      i2 = Integer.parseInt(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.O);
      i1 = i2;
    }
    catch (Exception paramVideoItemHolder)
    {
      label257:
      break label257;
    }
    QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "big_card_show_time Format error");
    this.M.sendEmptyMessageDelayed(1, i1 * 1000);
    t();
  }
  
  public boolean a()
  {
    boolean bool;
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mSoftAdType == 2)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q == 2))
    {
      String str1 = c();
      String str2 = b();
      return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
    }
    return bool;
  }
  
  public boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.bX != null) && (paramVideoItemHolder.bX.getVisibility() == 0) && (!this.p) && (a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f))))
    {
      if (QLog.isColorLevel())
      {
        paramVideoItemHolder = new StringBuilder();
        paramVideoItemHolder.append("进度判断 video_percent=");
        paramVideoItemHolder.append(paramDouble);
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, paramVideoItemHolder.toString());
      }
      return a(paramVideoInfo, paramDouble, paramLong);
    }
    return false;
  }
  
  public String b()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.o == 0)
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdProductType == 12) {
          return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdCorporateLogo;
        }
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdImg;
      }
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.f;
    }
    return null;
  }
  
  public void b(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder.bX == null) && (((IVideoHolderHelper)QRoute.api(IVideoHolderHelper.class)).isShortVideoItemHolder(paramVideoItemHolder)))
    {
      paramVideoItemHolder.bX = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramVideoItemHolder.aZ.findViewById(2131449552)).inflate()).findViewById(2131449714)).inflate());
      paramVideoItemHolder.bF = ((LinearLayout)paramVideoItemHolder.bX.findViewById(2131449558));
      paramVideoItemHolder.bP = ((LinearLayout)paramVideoItemHolder.bX.findViewById(2131449560));
      paramVideoItemHolder.bQ = ((URLImageView)paramVideoItemHolder.bX.findViewById(2131434893));
      paramVideoItemHolder.bR = ((TextView)paramVideoItemHolder.bX.findViewById(2131427637));
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(8.0F, this.h.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
      paramVideoItemHolder.bM = ((LinearLayout)paramVideoItemHolder.bX.findViewById(2131449561));
      paramVideoItemHolder.bM.setBackgroundDrawable(localGradientDrawable);
      paramVideoItemHolder.bM.setVisibility(0);
      paramVideoItemHolder.bG = ((URLImageView)paramVideoItemHolder.bX.findViewById(2131435003));
      paramVideoItemHolder.bH = ((TextView)paramVideoItemHolder.bX.findViewById(2131427638));
      paramVideoItemHolder.bI = ((TextView)paramVideoItemHolder.bX.findViewById(2131427635));
      paramVideoItemHolder.bL = ((TextView)paramVideoItemHolder.bX.findViewById(2131427633));
      paramVideoItemHolder.bJ = ((ImageView)paramVideoItemHolder.bX.findViewById(2131427623));
      paramVideoItemHolder.bK = ((ViewGroup)paramVideoItemHolder.bX.findViewById(2131427628));
      paramVideoItemHolder.bO = ((FrameLayout)paramVideoItemHolder.bX.findViewById(2131427689));
      ((RIJDownloadView)paramVideoItemHolder.bO).setVisibility(8);
    }
    d(paramVideoItemHolder);
  }
  
  public boolean b(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {
      return true;
    }
    if (this.k.contains(paramVideoInfo.b)) {
      return true;
    }
    if (ReadInJoyAdUtils.a(this.m)) {
      return false;
    }
    return this.l.contains(paramVideoInfo.b) ^ true;
  }
  
  public String c()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.o == 0)
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdProductType == 12) {
          return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdCorporateImageName;
        }
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q == 0)
        {
          if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdDesc)) {
            return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdDesc;
          }
          return HardCodeUtil.a(2131913361);
        }
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdTxt;
      }
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.h;
    }
    return "";
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.e = paramVideoInfo;
  }
  
  public void c(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder.bX != null)
    {
      if (a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f)))
      {
        h(paramVideoItemHolder);
        return;
      }
      i(paramVideoItemHolder);
    }
  }
  
  public CharSequence d()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      Object localObject2;
      Object localObject1;
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q != 1) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdProductType != 12))
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q == 0)
        {
          localObject2 = x();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "不容错过的热门商品";
          }
          return localObject1;
        }
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q == 2)
        {
          if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.o != 0) {
            localObject1 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.i;
          } else {
            localObject1 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdDesc;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = "点击查看详情";
          }
          return localObject2;
        }
      }
      else
      {
        localObject2 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.i;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "不容错过的热门应用";
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public void d(VideoItemHolder paramVideoItemHolder)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramVideoItemHolder.bF.getLayoutParams();
    paramVideoItemHolder.bF.setVisibility(0);
    if (a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f)))
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(6.0F, this.h.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
      paramVideoItemHolder.bF.setBackgroundDrawable(localGradientDrawable);
      paramVideoItemHolder.bF.setLayoutParams(localLayoutParams);
      paramVideoItemHolder.bM.setVisibility(8);
      paramVideoItemHolder.bP.setVisibility(0);
      localLayoutParams.height = AIOUtils.b(27.0F, this.h.getResources());
      localLayoutParams.width = -2;
      return;
    }
    paramVideoItemHolder.bM.setVisibility(0);
    paramVideoItemHolder.bP.setVisibility(8);
    localLayoutParams.height = AIOUtils.b(48.5F, this.h.getResources());
    localLayoutParams.width = AIOUtils.b(250.0F, this.h.getResources());
    e(paramVideoItemHolder);
  }
  
  public String e()
  {
    VideoInfo localVideoInfo = this.f;
    String str = "立即查看";
    if ((localVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.W)) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.W;
      }
    }
    else
    {
      if (f() == 0) {
        return "立刻购买";
      }
      if (f() == 2) {
        return "立即查看";
      }
      if (f() == 1) {
        str = "立即下载";
      }
    }
    return str;
  }
  
  public void e(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject = (LinearLayout.LayoutParams)paramVideoItemHolder.bM.getLayoutParams();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(6.0F, this.h.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
    ((LinearLayout.LayoutParams)localObject).width = AIOUtils.b(250.0F, this.h.getResources());
    paramVideoItemHolder.bM.setBackgroundDrawable(localGradientDrawable);
    paramVideoItemHolder.bM.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramVideoItemHolder.bG.setVisibility(0);
    if (f() == 0)
    {
      if ((!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v)) && (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u)))
      {
        paramVideoItemHolder.bL.setVisibility(8);
      }
      else if ((TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.v)) && (TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.u)))
      {
        paramVideoItemHolder.bL.setVisibility(8);
      }
      else
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(2.0F, this.h.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
        paramVideoItemHolder.bL.setVisibility(0);
        paramVideoItemHolder.bL.setBackgroundDrawable((Drawable)localObject);
      }
      ((RIJDownloadView)paramVideoItemHolder.bO).setVisibility(8);
      return;
    }
    if (f() == 2)
    {
      ((RIJDownloadView)paramVideoItemHolder.bO).setVisibility(8);
      return;
    }
    if (f() == 1) {
      ((RIJDownloadView)paramVideoItemHolder.bO).setVisibility(0);
    }
  }
  
  public int f()
  {
    if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdProductType != 12)
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q == 1) {
        return 1;
      }
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.q;
    }
    return 1;
  }
  
  public void f(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.bF.setVisibility(0);
  }
  
  public void g()
  {
    this.t = 0.0D;
  }
  
  public void h()
  {
    if (this.j.bX != null)
    {
      if (this.j.bF == null) {
        return;
      }
      this.j.bF.setVisibility(8);
      this.u.setVisibility(8);
      a(this.j, true);
      this.M.removeCallbacksAndMessages(null);
      VideoFeedsSoftAdTest localVideoFeedsSoftAdTest = this.H;
      if (localVideoFeedsSoftAdTest != null) {
        localVideoFeedsSoftAdTest.c();
      }
    }
  }
  
  public boolean i()
  {
    return this.o;
  }
  
  public void j()
  {
    VideoItemHolder localVideoItemHolder = this.j;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bN != null)) {
      ((RIJDownloadView)this.j.bN).a();
    }
    localVideoItemHolder = this.j;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bO != null)) {
      ((RIJDownloadView)this.j.bO).a();
    }
  }
  
  public void k()
  {
    VideoItemHolder localVideoItemHolder = this.j;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bN != null)) {
      ((RIJDownloadView)this.j.bN).b();
    }
    localVideoItemHolder = this.j;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.bO != null)) {
      ((RIJDownloadView)this.j.bO).b();
    }
  }
  
  public void l()
  {
    this.p = false;
    this.d = false;
    this.h = null;
    Handler localHandler = this.M;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void m()
  {
    View localView = this.u;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void n()
  {
    this.p = true;
    this.u.setVisibility(8);
    a(this.j, true);
    this.b = false;
    this.j.bP.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramView.getTag();
    if (localVideoItemHolder == null) {
      return;
    }
    this.d = true;
    if (paramView.getId() != 2131427622) {
      b(true);
    }
    switch (paramView.getId())
    {
    default: 
    case 2131449558: 
      if ((this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null) && (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo)))
      {
        a(localVideoItemHolder);
        a(1, 2, ReportAction.CLICK, Integer.valueOf(0), AdClickPos.SoftAdComponent, false);
        return;
      }
      paramView = u();
      a(1, 2, ReportAction.CLICK, paramView, AdClickPos.SoftAdComponent, false);
      return;
    case 2131427689: 
      if ((f() == 1) && (localVideoItemHolder.bO != null) && (this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
      {
        if (RIJAdDownloadUtil.a.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.y))
        {
          ((RIJDownloadView)localVideoItemHolder.bO).a(AdClickPos.SoftAdClickBtn, 8);
          return;
        }
        paramView = u();
        a(1, 1, ReportAction.CLICK, paramView, AdClickPos.SoftAdClickBtn, false);
        return;
      }
      break;
    case 2131427629: 
      paramView = u();
      a(1, 0, ReportAction.CLICK, paramView, AdClickPos.SoftAdComponent, true);
      return;
    case 2131427623: 
      this.a = true;
      localVideoItemHolder.bF.setVisibility(8);
      this.p = true;
      a(1, 3, ReportAction.CLOSE, Integer.valueOf(0), AdClickPos.SoftAdClose, false);
      return;
    case 2131427622: 
      paramView = this.q;
      if (paramView != null) {
        paramView.a();
      }
      n();
      a(1, 3, ReportAction.CLOSE, Integer.valueOf(0), AdClickPos.SoftAdClose, true);
      return;
    case 2131427620: 
      paramView = u();
      a(1, 1, ReportAction.CLICK, paramView, AdClickPos.SoftAdClickBtn, true);
    case 2131427687: 
      if ((f() == 1) && (localVideoItemHolder.bN != null) && (this.f != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null))
      {
        if (RIJAdDownloadUtil.a.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo.y))
        {
          ((RIJDownloadView)localVideoItemHolder.bN).a(AdClickPos.SoftAdClickBtn, 8);
          return;
        }
        paramView = u();
        a(1, 1, ReportAction.CLICK, paramView, AdClickPos.SoftAdClickBtn, true);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd
 * JD-Core Version:    0.7.0.1
 */