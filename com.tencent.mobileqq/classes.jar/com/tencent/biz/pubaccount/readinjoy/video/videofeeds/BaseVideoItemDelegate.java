package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsItemUIDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.CustomClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.MsgLayoutHelper;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZBitmapDrawable;
import com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.PopupMenuDialog;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/IVideoFeedsItemUIDelegate;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "isXgfileshow", "", "holder", "onCheckControllerVisibility", "", "visibility", "onCheckVolumeProgressVisibility", "onCommentComponentVisiblityChanged", "onGestureTouchEvent", "event", "", "onItemSizeChanged", "onNetworkStatusChanged", "isWifi", "onScreenOrientationChanged", "isFullScreen", "onShowAsFirstTime", "isScrollToTop", "isNeedShowTitle", "onSpeedRatioChanged", "drawableId", "onVideoClick", "onVisibilityChanged", "onVolumeChanged", "progress", "", "refreshContentUI", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "isNeedReloadTitle", "resetCoverViewLayoutParams", "resetItemLayoutParams", "resetVolumeProgressState", "isControllerVisibility", "setControllerVisibility", "showCurXGfileSizeTextView", "isKingCardUser", "tryLoadExtraCoverCache", "target", "Landroid/widget/ImageView;", "coverUrl", "Ljava/net/URL;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class BaseVideoItemDelegate
  implements IVideoFeedsItemUIDelegate
{
  public static final BaseVideoItemDelegate.Companion a;
  @JvmField
  @NotNull
  public final VideoFeedsAdapter a;
  @JvmField
  @NotNull
  public final VideoFeedsRecommendPresenter a;
  private final BaseVideoItemHolder a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemDelegate$Companion = new BaseVideoItemDelegate.Companion(null);
  }
  
  public BaseVideoItemDelegate(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = paramBaseVideoItemHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
  }
  
  private final boolean a(ImageView paramImageView, URL paramURL)
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 == null) {
        break label114;
      }
      j = ((Intent)localObject1).getIntExtra("item_width", 0);
      label39:
      if (localObject1 == null) {
        break label120;
      }
      i = ((Intent)localObject1).getIntExtra("item_height", 0);
      label53:
      if (localObject1 == null) {
        break label125;
      }
      j = ((Intent)localObject1).getIntExtra("item_image_width", j);
      label69:
      if (localObject1 == null) {
        break label131;
      }
    }
    label131:
    for (int i = ((Intent)localObject1).getIntExtra("item_image_height", i);; i = 0)
    {
      if ((j != 0) && (i != 0)) {
        break label136;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: width or height = 0");
      }
      return false;
      localObject1 = null;
      break;
      label114:
      j = 0;
      break label39;
      label120:
      i = 0;
      break label53;
      label125:
      j = 0;
      break label69;
    }
    label136:
    localObject1 = new ImageRequest();
    ((ImageRequest)localObject1).jdField_a_of_type_JavaNetURL = RIJPreParseData.a(paramURL.toString());
    ((ImageRequest)localObject1).jdField_a_of_type_Int = j;
    ((ImageRequest)localObject1).jdField_b_of_type_Int = i;
    CloseableBitmap localCloseableBitmap = ImageManager.a().a((ImageRequest)localObject1);
    localObject1 = localObject2;
    if (localCloseableBitmap != null) {
      localObject1 = localCloseableBitmap.a();
    }
    if (localObject1 != null)
    {
      paramURL = (Drawable)new ZBitmapDrawable(localCloseableBitmap.a());
      if (paramImageView != null) {
        paramImageView.setImageDrawable(paramURL);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: ImageManager hitCache");
      }
      return true;
    }
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = j;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
    paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject1);
    if ((paramURL != null) && (paramURL.getStatus() == 1))
    {
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramURL);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: urlDrawable hitCache");
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: missCache");
    }
    return false;
  }
  
  private final boolean a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    if (NetworkUtil.b((Context)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()))
    {
      long l;
      if (paramBaseVideoItemHolder != null)
      {
        Object localObject = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject != null)
        {
          localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
          if (localObject != null) {
            l = ((VideoInfo)localObject).jdField_b_of_type_Long;
          }
        }
      }
      while (l >= 0L) {
        if (((paramBaseVideoItemHolder instanceof VideoItemHolder)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(paramBaseVideoItemHolder)))
        {
          return true;
          l = 0L;
        }
        else
        {
          return false;
        }
      }
    }
    return false;
  }
  
  private final void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    int i = paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a());
    int j = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())[0];
    if (paramBoolean)
    {
      ((ViewGroup.LayoutParams)localObject).height = -1;
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.itemView;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoHolder.itemView");
      paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = i)
    {
      ((ViewGroup.LayoutParams)localObject).width = -1;
      break;
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = -1;
      if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_Int) != 2) {
        break;
      }
      localLayoutParams.height = -1;
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.height = i;
      break;
      i = -1;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        b((VideoInfo)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        c((VideoInfo)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b());
      }
    }
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
    if (localObject != null) {
      ((VideoFeedsVideoUIDelegate)localObject).a(false);
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100 * paramFloat));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.q.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView;
      if (paramFloat != 0.0F)
      {
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).removeMessages(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).sendEmptyMessageDelayed(0, 1500);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(100 * paramFloat));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      j(true);
    }
    while (paramInt != 2) {
      return;
    }
    j(false);
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_h_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_h_of_type_AndroidViewViewGroup.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    int i = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a())[0];
    int j = paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a());
    b(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject1 == null) {
        break label930;
      }
      localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseVideoItemDelegate", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject1 != null)
        {
          localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
          if (localObject1 != null) {
            ((VideoPlayerWrapper)localObject1).b(paramVideoInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_Int));
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject1 != null)
        {
          localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
          if (localObject1 != null)
          {
            localObject1 = ((VideoPlayerWrapper)localObject1).a();
            if (localObject1 != null) {
              ((IVideoView)localObject1).a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener((VideoFeedsGestureLayout.CustomClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController);
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setBackgroundDrawable(null);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    }
    Object localObject2 = paramVideoInfo.a();
    localObject1 = (ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b());
    if (localObject2 != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_Int != 0) || (!a((ImageView)localObject1, (URL)localObject2)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        }
      }
      label635:
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView, 0L);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.q, paramVideoInfo.a() * 1000);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int != 0)) {
        break label950;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      label719:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.f.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.f.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (paramVideoInfo != null) {
        paramVideoInfo.setAlpha(1.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.s.setVisibility(8);
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.r.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.t.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidViewView.setVisibility(8);
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
      if (paramVideoInfo != null) {
        paramVideoInfo.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
      if (paramVideoInfo != null) {
        paramVideoInfo.setTag(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
      }
      if (!PlayerHelper.a.a()) {
        break label965;
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(0);
      }
    }
    for (;;)
    {
      j(false);
      return;
      label930:
      localObject1 = null;
      break;
      if (localObject1 == null) {
        break label635;
      }
      ((ImageView)localObject1).setImageDrawable(null);
      break label635;
      label950:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      break label719;
      label965:
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
  
  protected final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    Activity localActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
    if (localActivity != null)
    {
      localObject1 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo; paramBoolean; localObject1 = null)
    {
      localObject1 = HardCodeUtil.a(2131716049);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
      Object localObject2 = paramBaseVideoItemHolder.g;
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      localObject2 = localActivity.getResources().getDrawable(2130843379);
      paramBaseVideoItemHolder.r.setText((CharSequence)localObject1);
      paramBaseVideoItemHolder.r.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      paramBaseVideoItemHolder.r.setCompoundDrawablePadding(AIOUtils.a(6.0F, localActivity.getResources()));
      paramBaseVideoItemHolder.r.setVisibility(0);
      paramBaseVideoItemHolder.r.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      paramBaseVideoItemHolder.r.setTag(paramBaseVideoItemHolder);
      if ((!paramBoolean) && (!TextUtils.isEmpty((CharSequence)CUKingCardHelper.a("kandian"))))
      {
        paramBaseVideoItemHolder.t.setVisibility(0);
        VideoFeedsHelper.a((Context)localActivity, paramBaseVideoItemHolder.t);
      }
      return;
    }
    if (localObject1 != null) {}
    for (long l = ((VideoInfo)localObject1).jdField_b_of_type_Long;; l = 0L)
    {
      localObject1 = VideoFeedsHelper.c(l);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…deoInfo?.XGFileSize ?: 0)");
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.c());
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int != 0) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject == null) {
        break;
      }
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject == null) || (((VideoInfo)localObject).jdField_a_of_type_Int != 0)) {
        break;
      }
      j(true);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    j(false);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).jdField_d_of_type_AndroidViewViewGroup;
      if ((localObject == null) || (((ViewGroup)localObject).getVisibility() != 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      k(bool);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.j;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        bool = true;
      }
      j(bool);
      return;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0)) {
          j(true);
        }
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder)) {
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.c());
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
        if (localObject != null) {
          ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
      if (localObject != null)
      {
        localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper;
        if (localObject != null) {
          ((MsgLayoutHelper)localObject).a();
        }
      }
      return;
      j(false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        b((VideoInfo)localObject, paramBoolean);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.e.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(2130841960));
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.mAdNegPopupMenu");
        if (((PopupMenuDialog)localObject).isShowing()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      j(false);
      if (LiuHaiUtils.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setPadding(LiuHaiUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()), 0, LiuHaiUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()), 0);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.e.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(2130841961));
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(0);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
  }
  
  public void h(boolean paramBoolean)
  {
    j(paramBoolean);
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.r.setVisibility(8);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.c()) && (!TextUtils.isEmpty((CharSequence)CUKingCardHelper.a("kandian")))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.t.setVisibility(8);
        }
      }
    }
    Object localObject2;
    do
    {
      return;
      if (VideoFeedsHelper.b())
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.c())
        {
          localObject1 = HardCodeUtil.a(2131716049);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
          localObject2 = HardCodeUtil.a(2131716005);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper.a(0, (String)localObject2, (String)localObject1, 2130843459);
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (localObject1 != null)
        {
          localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
          if (localObject1 == null) {}
        }
        for (long l = ((VideoInfo)localObject1).jdField_b_of_type_Long;; l = 0L)
        {
          localObject1 = VideoFeedsHelper.c(l);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…                    ?: 0)");
          break;
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
    } while (localObject2 == null);
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    if (localObject1 != null) {}
    for (localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; localObject1 = null)
    {
      ((VideoFeedsVideoUIDelegate)localObject2).a((VideoInfo)localObject1);
      return;
    }
  }
  
  protected void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup, 0);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      k(paramBoolean);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup, 8);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().f()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  protected final void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.q.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      VideoFeedsVideoUIDelegate localVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
      if (localVideoFeedsVideoUIDelegate != null) {
        localVideoFeedsVideoUIDelegate.a(true);
      }
      localVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate;
      if (localVideoFeedsVideoUIDelegate != null) {
        localVideoFeedsVideoUIDelegate.a();
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */