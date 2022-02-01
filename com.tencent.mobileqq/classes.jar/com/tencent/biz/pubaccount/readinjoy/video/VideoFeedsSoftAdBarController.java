package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsSoftAdBarController
  implements View.OnClickListener, IVideoFeedsSoftAdBarController
{
  private final int a;
  private Activity b;
  private boolean c;
  private VideoInfo d;
  private VideoItemHolder e;
  private VideoInfo f;
  private VideoFeedsSoftAdBarDelegateBase g;
  private VideoFeedsSoftAdBarDelegateForAd h;
  private VideoFeedsSoftAdBarDelegateForNormal i;
  private int j = 0;
  
  public VideoFeedsSoftAdBarController(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.a = AIOUtils.b(2.0F, paramActivity.getResources());
    this.b = paramActivity;
    this.h = new VideoFeedsSoftAdBarDelegateForAd();
    this.h.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.i = new VideoFeedsSoftAdBarDelegateForNormal();
    this.i.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  public static void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (paramInt4 != -1) {
        localURLDrawableOptions.mUseMemoryCache = false;
      }
      localURLDrawableOptions.mRequestWidth = AIOUtils.b(paramInt2, paramActivity.getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.b(paramInt3, paramActivity.getResources());
      paramActivity = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramInt4 == 0)
      {
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 1 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else if (paramInt4 == 1)
      {
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 3 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else
      {
        paramActivity.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      paramURLImageView.setImageDrawable(paramActivity);
      return;
    }
    catch (Exception paramURLImageView)
    {
      label230:
      break label230;
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = new StringBuilder();
      paramURLImageView.append("后台下发的url格式有问题：");
      paramURLImageView.append(paramString);
      QLog.d("VideoFeedsSoftAdBarController", 2, paramURLImageView.toString());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSamleGameShuntBar");
    }
    this.c = true;
    this.e = paramVideoItemHolder;
    for (;;)
    {
      try
      {
        if ((paramVideoItemHolder.bE == null) && (((IVideoHolderHelper)QRoute.api(IVideoHolderHelper.class)).isShortVideoItemHolder(paramVideoItemHolder)))
        {
          paramVideoItemHolder.bE = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramVideoItemHolder.aZ.findViewById(2131449552)).inflate()).findViewById(2131449713)).inflate());
          int k = AIOUtils.b(4.0F, this.b.getResources());
          paramVideoItemHolder.bE.setPadding(k, k, k, k);
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(3.0F, this.b.getResources()));
          ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
          paramVideoItemHolder.bE.setBackgroundDrawable((Drawable)localObject);
          paramVideoItemHolder.bu = ((URLImageView)paramVideoItemHolder.bE.findViewById(2131434998));
          paramVideoItemHolder.bv = ((TextView)paramVideoItemHolder.bE.findViewById(2131435006));
          paramVideoItemHolder.bx = ((TextView)paramVideoItemHolder.bE.findViewById(2131435005));
          paramVideoItemHolder.bw = paramVideoItemHolder.bE.findViewById(2131437472);
          paramVideoItemHolder.by = paramVideoItemHolder.bE.findViewById(2131435004);
          paramVideoItemHolder.bz = ((FrameLayout)paramVideoItemHolder.bE.findViewById(2131434995));
          paramVideoItemHolder.bA = paramVideoItemHolder.bE.findViewById(2131434997);
          paramVideoItemHolder.bC = ((TextView)paramVideoItemHolder.bE.findViewById(2131433962));
          paramVideoItemHolder.bB = paramVideoItemHolder.bE.findViewById(2131433980);
          paramVideoItemHolder.bD = ((FrameLayout)paramVideoItemHolder.bE.findViewById(2131427747));
        }
        if ((paramVideoItemHolder.bE != null) && (paramVideoItemHolder.bu != null) && (paramVideoItemHolder.bv != null) && (paramVideoItemHolder.bx != null) && (paramVideoItemHolder.bz != null) && (paramVideoItemHolder.by != null))
        {
          paramVideoItemHolder.bE.setVisibility(0);
          localObject = f();
          String str = "";
          if (localObject == null) {
            break label682;
          }
          localObject = f().b();
          a(paramVideoItemHolder.bu, (String)localObject, this.a, 18, 18, -1, this.b);
          if ((f() == null) || (f().c() == null)) {
            break label690;
          }
          localObject = f().c();
          paramVideoItemHolder.bv.setText((CharSequence)localObject);
          paramVideoItemHolder.bv.setVisibility(0);
          paramVideoItemHolder.bu.setVisibility(0);
          localObject = str;
          if (f() != null) {
            localObject = f().d();
          }
          paramVideoItemHolder.bD.setTag(paramVideoItemHolder);
          paramVideoItemHolder.bD.setOnClickListener(this);
          paramVideoItemHolder.bx.setText((CharSequence)localObject);
          paramVideoItemHolder.bE.setTag(paramVideoItemHolder);
          paramVideoItemHolder.bE.setOnClickListener(this);
          paramVideoItemHolder.bz.setTag(paramVideoItemHolder);
          paramVideoItemHolder.bz.setOnClickListener(this);
          paramVideoItemHolder.by.setTag(paramVideoItemHolder);
          paramVideoItemHolder.by.setOnClickListener(this);
          ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideUpAnim(paramVideoItemHolder.bE, 200);
          if ((f() != null) && (!TextUtils.isEmpty(f().e())) && (paramVideoItemHolder.bC != null)) {
            paramVideoItemHolder.bC.setText(f().e());
          }
          if (f() != null)
          {
            f().a(paramVideoInfo, paramVideoItemHolder);
            return;
          }
        }
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoItemHolder = new StringBuilder();
        paramVideoItemHolder.append("show shunt bar error:");
        paramVideoItemHolder.append(paramVideoInfo.getMessage());
        QLog.e("VideoFeedsSoftAdBarController", 2, paramVideoItemHolder.toString());
      }
      return;
      label682:
      Object localObject = "";
      continue;
      label690:
      localObject = "";
    }
  }
  
  private void b(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSoftAdShuntBar");
    }
    this.c = true;
    this.e = paramVideoItemHolder;
    try
    {
      this.h.b(paramVideoItemHolder);
      this.h.c(paramVideoItemHolder);
      if (paramVideoItemHolder.bX != null)
      {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideUpAnim(paramVideoItemHolder.bX, 200);
        if (f() != null)
        {
          f().a(paramVideoInfo, paramVideoItemHolder);
          return;
        }
      }
    }
    catch (Throwable paramVideoInfo)
    {
      paramVideoItemHolder = new StringBuilder();
      paramVideoItemHolder.append("后台下发的url格式有问题：");
      paramVideoItemHolder.append(paramVideoInfo.getMessage());
      QLog.d("VideoFeedsSoftAdBarController", 2, paramVideoItemHolder.toString());
    }
  }
  
  private void b(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.bE != null) && (paramVideoItemHolder.bE.getVisibility() == 0))
    {
      if ((this.c) && (f() != null) && (f().a(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong))) {
        this.i.a(this.a);
      }
      return;
    }
    if ((paramVideoInfo != null) && (f() != null) && (f().a()) && (f().b(paramVideoInfo))) {
      a(paramVideoInfo, paramVideoItemHolder);
    }
  }
  
  private void c(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.bX == null) || (paramVideoItemHolder.bX.getVisibility() != 0) || ((this.c) && (f() != null) && (f().a(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong)))) {}
    try
    {
      this.h.a(paramVideoItemHolder);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      label57:
      double d1;
      int m;
      int k;
      break label57;
    }
    this.h.m();
    QLog.d("VideoFeedsSoftAdBarController", 2, "big Card show error");
    return;
    if ((paramVideoInfo != null) && (f() != null) && (f().a()) && (f().b(paramVideoInfo)))
    {
      d1 = paramLong / 1000L;
      Double.isNaN(d1);
      paramDouble = d1 * paramDouble / 100.0D;
      m = 0;
      k = m;
      if (paramVideoInfo != null)
      {
        k = m;
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null)
        {
          k = m;
          if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)
          {
            k = m;
            if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.V == null) {}
          }
        }
      }
    }
    try
    {
      k = Integer.valueOf(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.V).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label252:
      break label252;
    }
    QLog.d("VideoFeedsSoftAdBarController", 2, "smallCardShowTime Format error");
    k = m;
    if ((paramDouble != 0.0D) && (paramDouble > k)) {
      b(paramVideoInfo, paramVideoItemHolder);
    }
  }
  
  private void e()
  {
    if (this.e.bE == null) {
      return;
    }
    Object localObject = this.e.bE.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.b(26.0F, this.b.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.e.bE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.e.bx.setVisibility(8);
    this.e.by.setVisibility(8);
    this.e.bz.setVisibility(8);
    this.e.bA.setVisibility(8);
    localObject = this.e.bu.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = AIOUtils.b(18.0F, this.b.getResources());
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.b(18.0F, this.b.getResources());
    this.e.bu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.e.bw.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.e.bw.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.e.bx.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(1.0F, this.b.getResources());
    this.e.bx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.e.bC.setVisibility(8);
    this.e.bB.setVisibility(8);
  }
  
  private VideoFeedsSoftAdBarDelegateBase f()
  {
    VideoFeedsSoftAdBarDelegateBase localVideoFeedsSoftAdBarDelegateBase = this.g;
    if (localVideoFeedsSoftAdBarDelegateBase != null) {
      return localVideoFeedsSoftAdBarDelegateBase;
    }
    if ((this.f.aK != null) && (this.i.b(this.f))) {
      this.g = this.i;
    } else if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mAdvertisementSoftInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.f).mSoftAdType == 2)) {
      this.g = this.h;
    }
    localVideoFeedsSoftAdBarDelegateBase = this.g;
    if (localVideoFeedsSoftAdBarDelegateBase != null) {
      localVideoFeedsSoftAdBarDelegateBase.a(this.f);
    }
    return this.g;
  }
  
  public void a()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).j();
    }
    localObject = this.i;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).h();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.d = paramVideoInfo;
    Object localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).c(paramVideoInfo);
    }
    localObject = this.i;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).c(paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if (paramVideoItemHolder.af.getVisibility() == 0) {
      return;
    }
    if ((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.b))) {
      return;
    }
    if (paramVideoInfo == null) {
      return;
    }
    try
    {
      if (d() == 3)
      {
        b(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
        return;
      }
      c(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      label59:
      break label59;
    }
    QLog.d("VideoFeedsSoftAdBarController", 2, "tryToShowShuntBar error");
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.bX != null))
    {
      paramVideoItemHolder.bX.setVisibility(8);
      if ((f() instanceof VideoFeedsSoftAdBarDelegateForAd)) {
        ((VideoFeedsSoftAdBarDelegateForAd)f()).a = false;
      }
      try
      {
        this.h.h();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("reset ex:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("VideoFeedsSoftAdBarController", 2, localStringBuilder2.toString());
      }
    }
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.bE != null))
    {
      paramVideoItemHolder.bE.setVisibility(8);
      if ((f() instanceof VideoFeedsSoftAdBarDelegateForAd)) {
        ((VideoFeedsSoftAdBarDelegateForAd)f()).a = false;
      }
      try
      {
        e();
        return;
      }
      catch (Exception paramVideoItemHolder)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("reset ex:");
        localStringBuilder1.append(paramVideoItemHolder.getMessage());
        QLog.d("VideoFeedsSoftAdBarController", 2, localStringBuilder1.toString());
      }
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder1, VideoItemHolder paramVideoItemHolder2)
  {
    this.c = false;
    VideoFeedsSoftAdBarDelegateForNormal localVideoFeedsSoftAdBarDelegateForNormal = this.i;
    localVideoFeedsSoftAdBarDelegateForNormal.e = false;
    if (localVideoFeedsSoftAdBarDelegateForNormal.d != null)
    {
      this.i.d.removeAllUpdateListeners();
      this.i.d.cancel();
      this.i.d = null;
    }
    this.h.b = false;
    a(paramVideoItemHolder1);
    paramVideoItemHolder1 = this.g;
    if (paramVideoItemHolder1 != null) {
      paramVideoItemHolder1.g();
    }
    this.f = paramVideoItemHolder2.az.c;
    this.g = null;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {
      return;
    }
    if ((f() != null) && (paramVideoItemHolder != null))
    {
      VideoFeedsSoftAdBarDelegateBase localVideoFeedsSoftAdBarDelegateBase = f();
      double d1 = paramLong;
      Double.isNaN(d1);
      localVideoFeedsSoftAdBarDelegateBase.a((d1 * paramDouble));
      if (((f() instanceof VideoFeedsSoftAdBarDelegateForAd)) && (((VideoFeedsSoftAdBarDelegateForAd)f()).a)) {
        return;
      }
      a(paramVideoItemHolder.az.c, paramVideoItemHolder, paramDouble, paramLong);
    }
  }
  
  public void a(Object paramObject)
  {
    a((VideoInfo)paramObject);
  }
  
  public void b()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).k();
    }
    localObject = this.i;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).i();
    }
  }
  
  public void c()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).l();
    }
    localObject = this.i;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).j();
    }
  }
  
  public int d()
  {
    if (f() != null) {
      return f().f();
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if (f() != null) {
      f().onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController
 * JD-Core Version:    0.7.0.1
 */