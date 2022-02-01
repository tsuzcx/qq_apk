package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoPendantUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoRefreshMenuUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.CommonVideoItemDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

public class ADVideoItemDelegate
  extends CommonVideoItemDelegate
{
  private ADVideoItemHolder a;
  private boolean e;
  
  public ADVideoItemDelegate(ADVideoItemHolder paramADVideoItemHolder, IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    super(paramADVideoItemHolder, paramIVideoFeedsRecommendPresenter, paramIVideoFeedsAdapter);
    this.a = paramADVideoItemHolder;
    this.e = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isVideoFeedsTiktokStyle();
    if ((paramADVideoItemHolder.aN != null) && (((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).isFullScreenDisplay(paramIVideoFeedsAdapter.j())))
    {
      if (this.e)
      {
        paramADVideoItemHolder.aD = AIOUtils.b(50.0F, paramADVideoItemHolder.aN.getResources());
        return;
      }
      if (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1) {
        paramADVideoItemHolder.aD = AIOUtils.b(41.5F, paramADVideoItemHolder.aN.getResources());
      }
    }
  }
  
  private boolean d(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.as != null) && (!paramVideoInfo.as.an) && (ReadInJoyAdSwitchUtil.g(paramVideoInfo.as)) && (ReadInJoyAdUtils.b(paramVideoInfo.as));
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.ap.getLayoutParams();
      localMarginLayoutParams.bottomMargin = AIOUtils.b(0.0F, this.b.v().getResources());
      this.a.ap.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.ap.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (AIOUtils.b(15.0F, this.b.v().getResources()) - 20);
    this.a.ap.setLayoutParams(localMarginLayoutParams);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130844213;
    }
    return 2130844216;
  }
  
  public void a()
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.c.k();
    boolean bool2 = true;
    boolean bool1 = true;
    if ((localVideoFeedsHardAdBarManager != null) && (localVideoFeedsHardAdBarManager.e()) && (!localVideoFeedsHardAdBarManager.g()))
    {
      if (this.a.y.getVisibility() != 0) {
        bool1 = false;
      }
      localVideoFeedsHardAdBarManager.c(bool1);
      c(bool1);
      return;
    }
    if (this.a.af.getVisibility() == 8) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    c(bool1);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.c.a(paramInt1, paramInt2);
    if (paramBoolean) {
      f();
    }
  }
  
  public void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo)
  {
    if (paramADVideoItemHolder == null) {
      return;
    }
    if (d(paramVideoInfo))
    {
      paramADVideoItemHolder = paramADVideoItemHolder.aN;
      if ((this.c.m() == 0) && (paramADVideoItemHolder != null) && (paramADVideoItemHolder.getLayoutParams() != null)) {
        this.c.d(paramADVideoItemHolder.getLayoutParams().height);
      }
    }
    else
    {
      paramADVideoItemHolder = paramADVideoItemHolder.U;
      if ((this.c.m() == 0) && (paramADVideoItemHolder != null) && (paramADVideoItemHolder.getLayoutParams() != null)) {
        this.c.d(paramADVideoItemHolder.getLayoutParams().height);
      }
    }
    if (this.c.l() == 0) {
      this.c.c(this.b.r());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    Object localObject1 = (VideoFeedsHardAdBarManager)this.c.k();
    if (localObject1 != null) {
      ((VideoFeedsHardAdBarManager)localObject1).a(false);
    }
    Object localObject2;
    if (this.a.h != null)
    {
      this.a.h.setTag(this.a);
      localObject2 = new GestureDetector(new ADVideoItemDelegate.1(this));
      this.a.h.setOnTouchListener(new ADVideoItemDelegate.2(this, (GestureDetector)localObject2));
    }
    this.a.aj.setProgress(0);
    this.a.ai.setProgress(0);
    ((VideoFeedsHardAdBarManager)localObject1).a(false, this.a);
    AdVideoPendantUIUtils.a(false, this.a, this.e, this.c);
    if (paramVideoInfo.a(this.b.v()))
    {
      this.a.t.setImageDrawable(null);
    }
    else if (paramVideoInfo.t() != null)
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.t(), (URLDrawable.URLDrawableOptions)localObject1);
      paramVideoInfo.setDecodeHandler(URLDrawableDecodeHandler.w);
      paramVideoInfo.setAlpha(80);
      this.a.t.setImageDrawable(paramVideoInfo);
    }
    if (this.e)
    {
      AdVideoButtonUIUtils.a(this.a.aH);
      AdVideoButtonUIUtils.a(this.a.aN);
      this.a.P.setHeadImgByUin(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      AdVideoButtonUIUtils.b(this.a.aL.getView());
      return;
    }
    AdVideoButtonUIUtils.b(this.a.aN);
    AdVideoButtonUIUtils.b(this.a.aM);
  }
  
  public void a_(VideoInfo paramVideoInfo)
  {
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.a.aQ, paramVideoInfo.p, "评论");
    this.a.aP.setImageResource(2130844212);
    if ((this.e) && (AdVideoButtonUIUtils.b()))
    {
      AdVideoButtonUIUtils.a(this.a.aP);
      AdVideoButtonUIUtils.a(this.a.aR);
      this.a.aQ.setTextColor(Color.parseColor("#C6C6C6"));
      this.a.aU.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void b()
  {
    ADVideoItemHolder localADVideoItemHolder = this.a;
    if ((localADVideoItemHolder != null) && (localADVideoItemHolder.az != null) && (this.a.az.c != null))
    {
      if (TextUtils.isEmpty(ADVideoAppDownloadData.a(this.a.az.c.as))) {
        return;
      }
      AdVideoButtonUIUtils.a(this.b.v(), this.a);
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    Object localObject = (VideoFeedsHardAdBarManager)this.c.k();
    ((VideoFeedsHardAdBarManager)localObject).a(false);
    ((VideoFeedsHardAdBarManager)localObject).d(false);
    AdVideoButtonUIUtils.a(this.a.aK.getView());
    a(this.a, paramVideoInfo);
    AdVideoRefreshMenuUIUtils.a.a((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), this.b.v(), this.c.n(), paramVideoInfo, this.a, this.c, this.e);
    if ((this.a.X != 4) && (paramVideoInfo.aq))
    {
      AdVideoRefreshMenuUIUtils.a.a(this.b.v(), paramVideoInfo, this.a, new ADVideoItemDelegate.3(this, paramVideoInfo, (VideoFeedsHardAdBarManager)localObject));
      ((VideoFeedsHardAdBarManager)localObject).a(false, this.a);
      AdVideoPendantUIUtils.a(false, this.a, this.e, this.c);
      AdVideoRefreshMenuUIUtils.a.a(this.b.v(), paramVideoInfo, this.a, this.c, this.e, new ADVideoItemDelegate.4(this, (VideoFeedsHardAdBarManager)localObject));
    }
    localObject = this.b.u();
    ADVideoItemHolder localADVideoItemHolder = this.a;
    if ((localObject == localADVideoItemHolder) && (localADVideoItemHolder.X == 4) && (this.b.e()))
    {
      AdVideoButtonUIUtils.b(this.a.aH);
      AdVideoButtonUIUtils.b(this.a.aN);
    }
    AdVideoButtonUIUtils.b(this.a.at);
    if (this.e) {
      a(this.a, paramVideoInfo);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.c.k();
    c(false);
    if (((this.a.X == 5) || (this.a.X == 7)) && (!paramBoolean))
    {
      localVideoFeedsHardAdBarManager.a(false, this.a);
      AdVideoPendantUIUtils.a(false, this.a, this.e, this.c);
      if (this.a.aj != null) {
        this.a.aj.setProgress(0);
      }
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    super.c(paramVideoInfo);
  }
  
  public void c(boolean paramBoolean)
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.c.k();
    if (this.a.h != null)
    {
      boolean bool;
      if (!paramBoolean)
      {
        if (!localVideoFeedsHardAdBarManager.e()) {
          AdVideoButtonUIUtils.a(this.a.aj);
        } else {
          AdVideoButtonUIUtils.b(this.a.aj);
        }
        if (this.e) {
          AdVideoButtonUIUtils.a(this.a.aM);
        }
        if ((localVideoFeedsHardAdBarManager.e()) && (!localVideoFeedsHardAdBarManager.g()))
        {
          if ((this.a.y.getVisibility() == 8) && (!localVideoFeedsHardAdBarManager.f()))
          {
            if (this.a.u != null)
            {
              localVideoFeedsHardAdBarManager.a(this.a);
              this.a.u.setVisibility(0);
            }
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.a.y, 0);
          }
          bool = paramBoolean;
          if (localVideoFeedsHardAdBarManager.f()) {
            if (this.a.af.getVisibility() == 8)
            {
              bool = true;
              this.a.af.setVisibility(0);
            }
            else
            {
              bool = paramBoolean;
              if (this.a.af.getVisibility() == 0)
              {
                this.a.af.setVisibility(8);
                bool = paramBoolean;
              }
            }
          }
        }
        else
        {
          if ((this.a.h.getVisibility() == 8) && (!localVideoFeedsHardAdBarManager.f())) {
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.a.h, 0);
          }
          bool = paramBoolean;
          if (this.a.af.getVisibility() == 0)
          {
            this.a.af.setVisibility(8);
            bool = paramBoolean;
          }
        }
      }
      else
      {
        AdVideoButtonUIUtils.b(this.a.aj);
        AdVideoButtonUIUtils.b(this.a.aM);
        if ((localVideoFeedsHardAdBarManager.e()) && (!localVideoFeedsHardAdBarManager.g()))
        {
          bool = paramBoolean;
          if (this.a.y.getVisibility() == 0)
          {
            if (this.a.u != null) {
              this.a.u.setVisibility(8);
            }
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.a.y, 8);
            bool = paramBoolean;
          }
        }
        else
        {
          if (this.a.h.getVisibility() == 0) {
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.a.h, 8);
          }
          bool = paramBoolean;
          if (this.a.af.getVisibility() == 8)
          {
            this.a.af.setVisibility(0);
            bool = paramBoolean;
          }
        }
      }
      super.c(bool);
      if (!this.e)
      {
        if ((!bool) && (!this.a.g) && (!localVideoFeedsHardAdBarManager.e()))
        {
          this.a.aj.setVisibility(0);
          return;
        }
        this.a.aj.setVisibility(4);
      }
    }
    else
    {
      super.c(paramBoolean);
      if (!this.e)
      {
        if ((!paramBoolean) && (!this.a.g) && (!localVideoFeedsHardAdBarManager.e()))
        {
          this.a.aj.setVisibility(0);
          return;
        }
        this.a.aj.setVisibility(4);
      }
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean)
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.c.k();
    if (paramBoolean)
    {
      localVideoFeedsHardAdBarManager.b(true);
      localVideoFeedsHardAdBarManager.a(true);
    }
    else
    {
      localVideoFeedsHardAdBarManager.b(false);
      localVideoFeedsHardAdBarManager.a(false);
    }
    if (paramBoolean)
    {
      if (!this.a.az.c.a(this.b.v()))
      {
        this.a.aa.setPadding(0, 0, 0, ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).calculateCommentViewGroupHeight(this.b.v()));
        m(true);
      }
      if (this.a.af.getVisibility() == 0) {
        this.a.af.setVisibility(8);
      }
      if (this.a.h != null)
      {
        this.a.h.setVisibility(8);
        AdVideoButtonUIUtils.b(this.a.aj);
      }
    }
    else if (!this.a.az.c.a(this.b.v()))
    {
      this.a.aa.setPadding(0, 0, 0, 0);
      m(false);
      if ((this.a.af != null) && (this.a.af.getVisibility() == 8) && (this.a.h != null))
      {
        this.a.h.setVisibility(0);
        AdVideoButtonUIUtils.a(this.a.aj);
      }
    }
    else if ((this.a.af != null) && (this.a.af.getVisibility() == 8) && (this.a.h != null))
    {
      this.a.h.setVisibility(0);
      AdVideoButtonUIUtils.a(this.a.aj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */