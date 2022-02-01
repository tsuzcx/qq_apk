package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsFollowButton;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimateManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
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
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import cooperation.readinjoy.ReadInJoyHelper;

public class ADVideoItemDelegate
  extends CommonVideoItemDelegate
{
  private ADVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
  private boolean jdField_a_of_type_Boolean;
  
  public ADVideoItemDelegate(ADVideoItemHolder paramADVideoItemHolder, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super(paramADVideoItemHolder, paramVideoFeedsRecommendPresenter, paramVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = paramADVideoItemHolder;
    this.jdField_a_of_type_Boolean = ReadInJoyHelper.d();
    if ((paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup != null) && (VideoFeedsHelper.a(paramVideoFeedsAdapter.jdField_a_of_type_AndroidAppActivity)))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label60;
      }
      paramADVideoItemHolder.jdField_d_of_type_Int = AIOUtils.a(50.0F, paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup.getResources());
    }
    label60:
    while (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) != 1) {
      return;
    }
    paramADVideoItemHolder.jdField_d_of_type_Int = AIOUtils.a(41.5F, paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup.getResources());
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!paramVideoInfo.a.d) && (ReadInJoyAdSwitchUtil.g(paramVideoInfo.a)) && (ReadInJoyAdUtils.a(paramVideoInfo.a));
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (AIOUtils.a(15.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().getResources()) - 20);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.g.setLayoutParams(localMarginLayoutParams);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843347;
    }
    return 2130843350;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager.a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean = false;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
      localObject = new GestureDetector(new ADVideoItemDelegate.1(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ADVideoItemDelegate.2(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
    AdVideoPendantUIUtils.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    if (paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (this.jdField_a_of_type_Boolean)
    {
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.j);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().getLongAccountUin());
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton.a());
      return;
      if (paramVideoInfo.a() != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        paramVideoInfo.setDecodeHandler(URLDrawableDecodeHandler.x);
        paramVideoInfo.setAlpha(80);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      }
    }
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.p);
  }
  
  public void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo)
  {
    if (paramADVideoItemHolder == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramADVideoItemHolder = paramADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_Int != 0) || (paramADVideoItemHolder == null) || (paramADVideoItemHolder.getLayoutParams() == null)) {}
      }
      for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_Int = paramADVideoItemHolder.getLayoutParams().height; (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.b == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()).a() != null); this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_Int = paramADVideoItemHolder.getLayoutParams().height)
      {
        label53:
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.b = ((VideoFeedsPlayActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()).a().getMeasuredHeight();
        return;
        paramADVideoItemHolder = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_Int != 0) || (paramADVideoItemHolder == null) || (paramADVideoItemHolder.getLayoutParams() == null)) {
          break label53;
        }
      }
    }
  }
  
  public void a_(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.f = false;
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, paramVideoInfo);
    AdVideoRefreshMenuUIUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int != 4) && (paramVideoInfo.c))
    {
      AdVideoRefreshMenuUIUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, new ADVideoItemDelegate.3(this, paramVideoInfo));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
      AdVideoPendantUIUtils.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      AdVideoRefreshMenuUIUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_Boolean, new ADVideoItemDelegate.4(this));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b()))
    {
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.j);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup);
    }
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, paramVideoInfo);
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.f))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.c = bool1;
        j(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      j(bool1);
      return;
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.w, paramVideoInfo.e, "评论");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.k.setImageResource(2130843346);
    if ((this.jdField_a_of_type_Boolean) && (AdVideoButtonUIUtils.b()))
    {
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.k);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.w.setTextColor(Color.parseColor("#C6C6C6"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.y.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a == null) || (TextUtils.isEmpty(ADVideoAppDownloadData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.a)))) {
      return;
    }
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
  }
  
  public void e(boolean paramBoolean)
  {
    j(false);
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
      AdVideoPendantUIUtils.a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.b = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean = true;
      if (!paramBoolean) {
        break label164;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()));
        m(true);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      }
    }
    label164:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.b = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean = false;
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())) {
          break label263;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        m(false);
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView == null));
    label263:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
  }
  
  public void g(boolean paramBoolean) {}
  
  protected void j(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView != null) {
      if (!paramBoolean) {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean)
        {
          AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
          if (this.jdField_a_of_type_Boolean) {
            AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.p);
          }
          if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.f)) {
            break label293;
          }
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView.getVisibility() == 8) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.b))
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView != null)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView.setVisibility(0);
            }
            VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.b)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
              break label261;
            }
            bool = true;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          }
          label197:
          super.j(bool);
          if (!this.jdField_a_of_type_Boolean)
          {
            if ((!bool) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean)) {
              break label522;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
          }
        }
      }
    }
    label261:
    label293:
    do
    {
      return;
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      break;
      bool = paramBoolean;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        break label197;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      bool = paramBoolean;
      break label197;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.getVisibility() == 8) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.b)) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView, 0);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        break label197;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      bool = paramBoolean;
      break label197;
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.p);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.f))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView.getVisibility() != 0) {
          break label197;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_h_of_type_AndroidViewView.setVisibility(8);
        }
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_l_of_type_AndroidViewView, 8);
        bool = paramBoolean;
        break label197;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_AndroidViewView, 8);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
        break label197;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
      bool = paramBoolean;
      break label197;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      return;
      super.j(paramBoolean);
    } while (this.jdField_a_of_type_Boolean);
    label522:
    if ((paramBoolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsHardAdBarManager.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */