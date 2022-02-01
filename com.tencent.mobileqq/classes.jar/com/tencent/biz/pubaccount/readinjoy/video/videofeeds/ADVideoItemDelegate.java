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
  private ADVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
  private boolean jdField_a_of_type_Boolean;
  
  public ADVideoItemDelegate(ADVideoItemHolder paramADVideoItemHolder, IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    super(paramADVideoItemHolder, paramIVideoFeedsRecommendPresenter, paramIVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = paramADVideoItemHolder;
    this.jdField_a_of_type_Boolean = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isVideoFeedsTiktokStyle();
    if ((paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup != null) && (((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).isFullScreenDisplay(paramIVideoFeedsAdapter.a())))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramADVideoItemHolder.jdField_d_of_type_Int = AIOUtils.b(50.0F, paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup.getResources());
        return;
      }
      if (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1) {
        paramADVideoItemHolder.jdField_d_of_type_Int = AIOUtils.b(41.5F, paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup.getResources());
      }
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!paramVideoInfo.a.d) && (ReadInJoyAdSwitchUtil.g(paramVideoInfo.a)) && (ReadInJoyAdUtils.a(paramVideoInfo.a));
  }
  
  private void l(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = AIOUtils.b(0.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (AIOUtils.b(15.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().getResources()) - 20);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.setLayoutParams(localMarginLayoutParams);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843259;
    }
    return 2130843262;
  }
  
  public void a()
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b();
    boolean bool2 = true;
    boolean bool1 = true;
    if ((localVideoFeedsHardAdBarManager != null) && (localVideoFeedsHardAdBarManager.a()) && (!localVideoFeedsHardAdBarManager.c()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView.getVisibility() != 0) {
        bool1 = false;
      }
      localVideoFeedsHardAdBarManager.c(bool1);
      b(bool1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    b(bool1);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(paramInt1, paramInt2);
    if (paramBoolean) {
      f();
    }
  }
  
  public void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo)
  {
    if (paramADVideoItemHolder == null) {
      return;
    }
    if (a(paramVideoInfo))
    {
      paramADVideoItemHolder = paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b() == 0) && (paramADVideoItemHolder != null) && (paramADVideoItemHolder.getLayoutParams() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.d(paramADVideoItemHolder.getLayoutParams().height);
      }
    }
    else
    {
      paramADVideoItemHolder = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b() == 0) && (paramADVideoItemHolder != null) && (paramADVideoItemHolder.getLayoutParams() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.d(paramADVideoItemHolder.getLayoutParams().height);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    Object localObject1 = (VideoFeedsHardAdBarManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b();
    if (localObject1 != null) {
      ((VideoFeedsHardAdBarManager)localObject1).a(false);
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
      localObject2 = new GestureDetector(new ADVideoItemDelegate.1(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ADVideoItemDelegate.2(this, (GestureDetector)localObject2));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    ((VideoFeedsHardAdBarManager)localObject1).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
    AdVideoPendantUIUtils.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    else if (paramVideoInfo.a() != null)
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject1);
      paramVideoInfo.setDecodeHandler(URLDrawableDecodeHandler.v);
      paramVideoInfo.setAlpha(80);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.j);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton.a());
      return;
    }
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.p);
  }
  
  public void a(boolean paramBoolean)
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b();
    b(false);
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      localVideoFeedsHardAdBarManager.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
      AdVideoPendantUIUtils.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b.setProgress(0);
      }
    }
  }
  
  public void a_(VideoInfo paramVideoInfo)
  {
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.w, paramVideoInfo.e, "评论");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.k.setImageResource(2130843258);
    if ((this.jdField_a_of_type_Boolean) && (AdVideoButtonUIUtils.b()))
    {
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.k);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.w.setTextColor(Color.parseColor("#C6C6C6"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.y.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void b()
  {
    ADVideoItemHolder localADVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if ((localADVideoItemHolder != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a != null))
    {
      if (TextUtils.isEmpty(ADVideoAppDownloadData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.a))) {
        return;
      }
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    Object localObject = (VideoFeedsHardAdBarManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b();
    ((VideoFeedsHardAdBarManager)localObject).a(false);
    ((VideoFeedsHardAdBarManager)localObject).d(false);
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetIReadInJoyHeadImageView.a());
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, paramVideoInfo);
    AdVideoRefreshMenuUIUtils.a.a((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(), paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter, this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int != 4) && (paramVideoInfo.r))
    {
      AdVideoRefreshMenuUIUtils.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, new ADVideoItemDelegate.3(this, paramVideoInfo, (VideoFeedsHardAdBarManager)localObject));
      ((VideoFeedsHardAdBarManager)localObject).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
      AdVideoPendantUIUtils.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      AdVideoRefreshMenuUIUtils.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter, this.jdField_a_of_type_Boolean, new ADVideoItemDelegate.4(this, (VideoFeedsHardAdBarManager)localObject));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b();
    ADVideoItemHolder localADVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if ((localObject == localADVideoItemHolder) && (localADVideoItemHolder.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()))
    {
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.j);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
    }
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, paramVideoInfo);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null)
    {
      boolean bool;
      if (!paramBoolean)
      {
        if (!localVideoFeedsHardAdBarManager.a()) {
          AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b);
        } else {
          AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b);
        }
        if (this.jdField_a_of_type_Boolean) {
          AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.p);
        }
        if ((localVideoFeedsHardAdBarManager.a()) && (!localVideoFeedsHardAdBarManager.c()))
        {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView.getVisibility() == 8) && (!localVideoFeedsHardAdBarManager.b()))
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView != null)
            {
              localVideoFeedsHardAdBarManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView.setVisibility(0);
            }
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (localVideoFeedsHardAdBarManager.b()) {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8)
            {
              bool = true;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
            }
            else
            {
              bool = paramBoolean;
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
                bool = paramBoolean;
              }
            }
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.getVisibility() == 8) && (!localVideoFeedsHardAdBarManager.b())) {
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
            bool = paramBoolean;
          }
        }
      }
      else
      {
        AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b);
        AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.p);
        if ((localVideoFeedsHardAdBarManager.a()) && (!localVideoFeedsHardAdBarManager.c()))
        {
          bool = paramBoolean;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView.getVisibility() == 0)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView.setVisibility(8);
            }
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView, 8);
            bool = paramBoolean;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
            ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithObjectAnimator(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView, 8);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
            bool = paramBoolean;
          }
        }
      }
      super.b(bool);
      if (!this.jdField_a_of_type_Boolean)
      {
        if ((!bool) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Boolean) && (!localVideoFeedsHardAdBarManager.a()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b.setVisibility(4);
      }
    }
    else
    {
      super.b(paramBoolean);
      if (!this.jdField_a_of_type_Boolean)
      {
        if ((!paramBoolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Boolean) && (!localVideoFeedsHardAdBarManager.a()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b.setVisibility(4);
      }
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    super.c(paramVideoInfo);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean)
  {
    VideoFeedsHardAdBarManager localVideoFeedsHardAdBarManager = (VideoFeedsHardAdBarManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.b();
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
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).calculateCommentViewGroupHeight(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()));
        l(true);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b);
      }
    }
    else if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      l(false);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b);
      }
    }
    else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */