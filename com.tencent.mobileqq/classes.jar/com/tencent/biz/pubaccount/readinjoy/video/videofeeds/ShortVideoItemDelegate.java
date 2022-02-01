package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;
import com.tencent.biz.pubaccount.VideoInfo.SubscriptInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatus;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsFollowButton;
import com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimateManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsResourceLoader;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/CommonVideoItemDelegate;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/View$OnTouchListener;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "showBiuBtn", "", "getRewardCoinIconRes", "", "info", "Lcom/tencent/biz/pubaccount/VideoInfo;", "hideAutoSeekBarTimer", "", "innerAdjustLogoUI", "logoImageView", "Landroid/widget/ImageView;", "videoInfo", "isFullScreen", "innerAdjustSeekbarLayout", "isAlignBottom", "innerConfigLocationLayout", "innerConfigPlayCountTextView", "textView", "Landroid/widget/TextView;", "innerSetLogoImageView", "onAutoSeekBarTouch", "onCommentComponentVisiblityChanged", "visibility", "onMenuDataChanged", "onProgressChanged", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "onScreenOrientationChanged", "onStartTrackingTouch", "onStopTrackingTouch", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onVideoClick", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "refreshAvatorAndNickName", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "resetVideoAreaLayoutParams", "isCommentShowing", "setAccountVIcon", "setControllerVisibility", "showAutoSeekBarTimer", "updateFollowStateAndUI", "needAnim", "updateSubscript", "yourFollowTextHasShowed", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class ShortVideoItemDelegate
  extends CommonVideoItemDelegate
  implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener
{
  public static final ShortVideoItemDelegate.Companion a;
  private final ShortVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
  private final boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemDelegate$Companion = new ShortVideoItemDelegate.Companion(null);
  }
  
  public ShortVideoItemDelegate(@NotNull ShortVideoItemHolder paramShortVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((VideoItemHolder)paramShortVideoItemHolder, paramVideoFeedsRecommendPresenter, paramVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder = paramShortVideoItemHolder;
    this.jdField_a_of_type_Boolean = RIJAladdinUtils.b();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.l != null) && (VideoFeedsHelper.a(paramVideoFeedsRecommendPresenter.a())) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1))
    {
      paramShortVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      paramVideoFeedsRecommendPresenter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.l;
      if (paramVideoFeedsRecommendPresenter == null) {
        break label143;
      }
      paramVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter.getLayoutParams();
      if (paramVideoFeedsRecommendPresenter == null) {
        break label143;
      }
    }
    label143:
    for (int i = paramVideoFeedsRecommendPresenter.height;; i = 0)
    {
      paramShortVideoItemHolder.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setOnTouchListener((View.OnTouchListener)this);
      return;
    }
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if ((paramImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!VideoFeedsHelper.e()) || (TextUtils.isEmpty((CharSequence)paramVideoInfo.u)))
    {
      paramImageView.setVisibility(8);
      return;
    }
    Object localObject = paramVideoInfo.u;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.videoLogoUrl");
    if (StringsKt.endsWith$default((String)localObject, "zip", false, 2, null))
    {
      ReadInJoyLottieDrawable localReadInJoyLottieDrawable = ReadInJoyLottieDrawable.a(paramVideoInfo.u);
      Intrinsics.checkExpressionValueIsNotNull(localReadInJoyLottieDrawable, "mLottieDrawable");
      localReadInJoyLottieDrawable.setRepeatCount(0);
      paramImageView.setImageDrawable((Drawable)localReadInJoyLottieDrawable);
      if ((paramImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().d()))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
        if (localObject == null) {
          break label153;
        }
        localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject == null) {
          break label153;
        }
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
        if (localObject == paramVideoInfo) {
          localReadInJoyLottieDrawable.playAnimation();
        }
      }
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      return;
      label153:
      localObject = null;
      break;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(paramVideoInfo.u, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Activity localActivity2 = null;
    Activity localActivity1 = null;
    int[] arrayOfInt;
    if ((paramImageView != null) && (paramImageView.getVisibility() == 0))
    {
      arrayOfInt = paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_Int);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    Object localObject = paramImageView.getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).topMargin = arrayOfInt[0];
    ((FrameLayout.LayoutParams)localObject).rightMargin = arrayOfInt[1];
    if ((paramBoolean) || (paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())))
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
      if (paramVideoInfo != null) {}
      for (paramVideoInfo = paramVideoInfo.getResources();; paramVideoInfo = null)
      {
        ((FrameLayout.LayoutParams)localObject).width = AIOUtils.a(91.0F, paramVideoInfo);
        localActivity2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
        paramVideoInfo = localActivity1;
        if (localActivity2 != null) {
          paramVideoInfo = localActivity2.getResources();
        }
        ((FrameLayout.LayoutParams)localObject).height = AIOUtils.a(28.0F, paramVideoInfo);
        paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
    }
    paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
    if (paramVideoInfo != null) {}
    for (paramVideoInfo = paramVideoInfo.getResources();; paramVideoInfo = null)
    {
      ((FrameLayout.LayoutParams)localObject).width = AIOUtils.a(78.0F, paramVideoInfo);
      localActivity1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
      paramVideoInfo = localActivity2;
      if (localActivity1 != null) {
        paramVideoInfo = localActivity1.getResources();
      }
      ((FrameLayout.LayoutParams)localObject).height = AIOUtils.a(24.0F, paramVideoInfo);
      break;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.t > 0))
    {
      paramTextView.setText((CharSequence)VideoFeedsHelper.a(paramVideoInfo.t));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private final void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    TextView localTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e;
    if (localTextView != null) {
      if ((paramBoolean1) || (paramVideoInfo.q)) {
        break label117;
      }
    }
    label139:
    for (;;)
    {
      if ((i != 0) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo != null))
      {
        localTextView.setVisibility(0);
        localTextView.setText((CharSequence)paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_a_of_type_JavaLangString);
        localTextView.setTextColor(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_a_of_type_Int);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.b);
        localGradientDrawable.setCornerRadius(ViewUtils.a(4.0F));
        localTextView.setBackgroundDrawable((Drawable)localGradientDrawable);
      }
      for (;;)
      {
        return;
        label117:
        if ((paramBoolean1) && (!paramBoolean2)) {
          break label139;
        }
        i = 0;
        break;
        localTextView.setVisibility(8);
      }
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_Int > 0) && (paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_Int) == 2))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setPadding(0, 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setPadding(0, 0, 0, 0);
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    Object localObject = (ReadInJoyUserInfo)null;
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j)) {}
    for (;;)
    {
      try
      {
        paramVideoInfo = paramVideoInfo.j;
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.accountUin");
        paramVideoInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo), null);
        if ((paramVideoInfo == null) || (TextUtils.isEmpty((CharSequence)paramVideoInfo.smallIconUrl))) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setVisibility(0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().getWidth();
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.smallIconUrl, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setImageDrawable((Drawable)paramVideoInfo);
        return;
      }
      catch (Exception paramVideoInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoItemDelegate", 2, "setAccountVIcon: e=" + paramVideoInfo);
        }
      }
      paramVideoInfo = (VideoInfo)localObject;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setVisibility(8);
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
    if (localObject != null) {
      ((ReadInJoyHeadImageView)localObject).setImagePlaceHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
    if (localObject != null)
    {
      localObject = ((ReadInJoyNickNameTextView)localObject).getPaint();
      if (localObject != null) {
        ((TextPaint)localObject).setFakeBoldText(true);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
    if (localObject != null) {
      ((ReadInJoyNickNameTextView)localObject).setNickNameByUin(paramVideoInfo.j);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
    if (localObject != null) {
      ((ReadInJoyHeadImageView)localObject).setHeadImgByUin(paramVideoInfo.j);
    }
    VideoFeedsAccessibilityHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.k);
    VideoFeedsAccessibilityHelper.c((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.k);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setForeground((Drawable)null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setVisibility(0);
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j))
    {
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus.jdField_a_of_type_Int == 1))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().a(paramVideoInfo);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private final void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d();
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.h();
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString);
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean)
      {
        paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e();
        if (paramVideoInfo != null) {
          paramVideoInfo.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(2130841966));
        }
        paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setBackgroundResource(2130841964);
        }
        paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
        }
        paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
        }
      }
    }
    do
    {
      return;
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e();
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(2130841965));
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d();
      if (paramVideoInfo == null) {
        break;
      }
      paramVideoInfo.setBackgroundResource(0);
      break;
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d();
    } while (paramVideoInfo == null);
    paramVideoInfo.setVisibility(8);
  }
  
  private final void g()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e();
    if ((localViewGroup != null) && (localViewGroup.getVisibility() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemDelegate", 2, "onAutoSeekBarTouch: ");
    }
    f();
  }
  
  private final void m(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramBoolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g.getLayoutParams();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
      if (localObject3 != null) {
        localObject1 = ((Activity)localObject3).getResources();
      }
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.a(0.0F, (Resources)localObject1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g.getLayoutParams();
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    Object localObject3 = (ViewGroup.MarginLayoutParams)localObject1;
    Activity localActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
    localObject1 = localObject2;
    if (localActivity != null) {
      localObject1 = localActivity.getResources();
    }
    ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = (AIOUtils.a(15.0F, (Resources)localObject1) - 20);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g.setLayoutParams((ViewGroup.LayoutParams)localObject3);
  }
  
  protected int a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.o) {
      return 2130843335;
    }
    return 2130843337;
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
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "adapter.mCommentManager");
      if (((VideoFeedsCommentManager)localObject1).b())
      {
        paramBoolean = true;
        c(paramVideoInfo, paramBoolean);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.v;
        if (localObject1 != null)
        {
          localObject1 = ((TextView)localObject1).getPaint();
          if (localObject1 != null) {
            ((TextPaint)localObject1).setFakeBoldText(false);
          }
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
        if (!paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())) {
          break label478;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setVisibility(0);
        label122:
        m(false);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "adapter.mCommentManager");
        if ((((VideoFeedsCommentManager)localObject1).b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.c))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.c = false;
          f(true);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
          break label493;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a() == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a(new VideoFeedsAioGuideView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView));
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
        if (localObject1 != null) {
          ((VideoFeedsAioGuideView)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
        }
        label254:
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
        if (localObject1 == null) {
          break label533;
        }
        localObject1 = ((Activity)localObject1).getIntent();
        if (localObject1 == null) {
          break label533;
        }
        localObject1 = ((Intent)localObject1).getStringExtra("video_feeds_back_color");
        label283:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label538;
        }
        URLImageView localURLImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
        localObject1 = localDrawable;
        if (localObject2 != null)
        {
          localObject2 = ((Activity)localObject2).getIntent();
          localObject1 = localDrawable;
          if (localObject2 != null) {
            localObject1 = ((Intent)localObject2).getStringExtra("video_feeds_back_color");
          }
        }
        localURLImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor((String)localObject1)));
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
        if (localObject1 != null)
        {
          localObject1 = ((Activity)localObject1).getIntent();
          if (localObject1 != null) {
            ((Intent)localObject1).removeExtra("video_feeds_back_color");
          }
        }
      }
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager.b(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setVisibility(0);
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e();
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setThumb(VideoFeedsResourceLoader.a((Context)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), 2131167305));
      return;
      paramBoolean = false;
      break;
      label478:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setVisibility(8);
      break label122;
      label493:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a() == null) {
        break label254;
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
      if (localObject1 != null) {
        ((VideoFeedsAioGuideView)localObject1).c();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a((VideoFeedsAioGuideView)null);
      break label254;
      label533:
      localObject1 = null;
      break label283;
      label538:
      if (paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setImageDrawable(null);
      }
      else if (paramVideoInfo.a() != null)
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        localDrawable = (Drawable)new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.x);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "urlDrawable");
        ((URLDrawable)localObject1).setAlpha(35);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a().setImageDrawable((Drawable)localObject1);
      }
    }
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    b(true);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.j;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      e(paramVideoInfo);
      d(paramVideoInfo);
      b(paramVideoInfo, false);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).a();
        if (localObject != null) {
          ((View)localObject).setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).a();
        if (localObject != null) {
          ((View)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
        }
      }
    }
    l(true);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.l;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      a((VideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder, paramVideoInfo);
      if (RIJRewardTaskConfig.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.c().setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.c().setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.c().setVisibility(0);
      }
    }
    if (paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.h.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b()))
      {
        b(false);
        l(false);
      }
      if (paramVideoInfo.a())
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.m;
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(a(paramVideoInfo.r)));
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label479;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_n_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.q;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_n_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder, (View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b());
      f(paramVideoInfo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.h.setVisibility(0);
      break;
      label479:
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_n_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
    }
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.b(paramVideoInfo);
    e(paramVideoInfo);
    d(paramVideoInfo);
    VideoFeedsHelper.a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.v);
    VideoFeedsHelper.a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.u);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a((VideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder, paramVideoInfo);
    b(paramVideoInfo, true);
    a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager.a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder);
    TextView localTextView;
    int i;
    if (RIJRewardTaskConfig.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.d().setImageResource(a(paramVideoInfo));
      localTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g();
      i = paramVideoInfo.p;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
      if (localObject == null) {
        break label206;
      }
    }
    label206:
    for (Object localObject = ((Activity)localObject).getString(2131718597);; localObject = null)
    {
      VideoFeedsHelper.b(localTextView, i, (String)localObject);
      f(paramVideoInfo);
      return;
    }
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton == null) {
      return;
    }
    boolean bool2 = paramVideoInfo.q;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
    boolean bool1;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
    {
      bool1 = true;
      if ((!TextUtils.isEmpty((CharSequence)paramVideoInfo.j)) && (!Intrinsics.areEqual("16888", paramVideoInfo.j)) && (!paramVideoInfo.c) && (!paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()))) {
        break label159;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
      if (localObject != null)
      {
        localObject = ((IVideoFeedsFollowButton)localObject).a();
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 8, 0);
    }
    for (;;)
    {
      a(paramVideoInfo, paramBoolean, bool1);
      return;
      bool1 = false;
      break;
      label159:
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
      if (localObject != null) {
        ((IVideoFeedsFollowButton)localObject).a(paramVideoInfo, paramVideoInfo.q);
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidOsHandler != null) && (bool2))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).a();
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
            if (localObject != null)
            {
              long l = ((IVideoFeedsFollowButton)localObject).a();
              localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidOsHandler;
              if (localObject != null) {
                ((Handler)localObject).sendEmptyMessageDelayed(7, l);
              }
            }
            VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 0);
            continue;
          }
        }
      }
      if (bool2)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).a();
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 0, 0);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
        if (localObject != null)
        {
          localObject = ((IVideoFeedsFollowButton)localObject).a();
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView, 8, 0);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      j(bool);
      return;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setThumb(VideoFeedsResourceLoader.a((Context)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), 2131167305));
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e(), 8);
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a(), 0);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setThumb(VideoFeedsResourceLoader.a((Context)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), 2130841949));
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a(), 8);
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.i() == null)
    {
      ShortVideoItemHolder localShortVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.b();
      if (localObject1 == null) {
        break label210;
      }
      localObject1 = ((ViewStub)localObject1).inflate();
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localShortVideoItemHolder.c((ViewGroup)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p;
      if (localObject1 == null) {
        break label215;
      }
      localObject1 = (TextView)((ViewGroup)localObject1).findViewById(2131381364);
      label117:
      ((ShortVideoItemHolder)localObject2).f((TextView)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p;
      if (localObject1 == null) {
        break label220;
      }
    }
    label210:
    label215:
    label220:
    for (Object localObject1 = (TextView)((ViewGroup)localObject1).findViewById(2131381365);; localObject1 = null)
    {
      ((ShortVideoItemHolder)localObject2).g((TextView)localObject1);
      VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.e(), 0);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.i(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().a());
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.j(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().d());
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label117;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.clearAnimation();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()) == true)) {}
      }
      else
      {
        m(true);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.h.setVisibility(8);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
      if ((localObject != null) && (((VideoInfo)localObject).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()) == true)) {}
    }
    else
    {
      m(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.h.setVisibility(8);
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    boolean bool;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder) {
          break label170;
        }
        VideoFeedsCommentManager localVideoFeedsCommentManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
        Intrinsics.checkExpressionValueIsNotNull(localVideoFeedsCommentManager, "adapter.mCommentManager");
        if (!localVideoFeedsCommentManager.b()) {
          break label170;
        }
        bool = true;
        c((VideoInfo)localObject, bool);
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      m(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).b();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject != null)
        {
          localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
          if (localObject != null) {
            a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView, (VideoInfo)localObject, paramBoolean);
          }
        }
      }
      return;
      label170:
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.mCommentManager");
      if (!((VideoFeedsCommentManager)localObject).b()) {
        m(false);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject != null)
        {
          localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
          if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
            if (localObject != null) {
              ((VideoFeedsAioGuideView)localObject).a();
            }
          }
        }
      }
    }
  }
  
  protected void j(boolean paramBoolean)
  {
    super.j(paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p, 8, 200);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).translationY(20.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a() != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b()))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).a();
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a());
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b())
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p;
          if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
          {
            VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p, 0, 200);
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.p;
            if (localObject != null)
            {
              localObject = ((ViewGroup)localObject).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                  if (localObject != null) {
                    ((ViewPropertyAnimator)localObject).start();
                  }
                }
              }
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.g.animate().translationY(0.0F).setDuration(200L).start();
          }
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a() == null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.a();
    } while (localObject == null);
    ((VideoFeedsAioGuideView)localObject).b();
  }
  
  public void onProgressChanged(@Nullable SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().d();
    if (l > 0L)
    {
      paramInt = (int)(paramInt / 100.0D * l);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.i(), paramInt);
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.j(), l);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().b();
    }
  }
  
  public void onStartTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    VideoFeedsVideoUIDelegate localVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
    if (localVideoFeedsVideoUIDelegate != null) {
      localVideoFeedsVideoUIDelegate.onStartTrackingTouch(paramSeekBar);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().c();
  }
  
  public void onStopTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
    if (localObject != null) {
      ((VideoFeedsVideoUIDelegate)localObject).onStopTrackingTouch(paramSeekBar);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessageDelayed(8, 2000);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().d();
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public boolean onTouch(@Nullable View paramView, @Nullable MotionEvent paramMotionEvent)
  {
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label23;
      }
    }
    for (;;)
    {
      return false;
      paramView = null;
      break;
      label23:
      if (paramView.intValue() == 2131369128) {
        g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */