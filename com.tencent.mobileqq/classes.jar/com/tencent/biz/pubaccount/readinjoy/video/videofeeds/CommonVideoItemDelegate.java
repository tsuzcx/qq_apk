package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/CommonVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemDelegate;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "innerConfigMenuBtns", "", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "onDianZanClick", "onMenuDataChanged", "info", "onScreenOrientationChanged", "isFullScreen", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setContentUIVisibility", "visible", "setFooterDiversionVisibility", "setFooterVisibility", "setHeaderDiversionVisibility", "setHeaderVisibility", "updateCommentUI", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class CommonVideoItemDelegate
  extends BaseVideoItemDelegate
{
  private final VideoItemHolder a;
  
  public CommonVideoItemDelegate(@NotNull VideoItemHolder paramVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((BaseVideoItemHolder)paramVideoItemHolder, paramVideoFeedsRecommendPresenter, paramVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = paramVideoItemHolder;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843311;
    }
    return 2130843208;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.b == 0) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.c))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)"");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.u.setText((CharSequence)"");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getPaint();
        if (localObject != null) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.u.getPaint();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.fullTitleTextView.paint");
      ((TextPaint)localObject).setFakeBoldText(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, paramVideoInfo);
      a(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.q != null)
      {
        paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.q;
        if (paramVideoInfo != null) {
          paramVideoInfo.setVisibility(8);
        }
      }
      return;
      VideoFeedsHelper.a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v);
      VideoFeedsHelper.a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.u);
    }
  }
  
  protected final void a(@NotNull VideoItemHolder paramVideoItemHolder, @NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoItemHolder.jdField_p_of_type_AndroidViewView != null)
    {
      localObject = paramVideoItemHolder.jdField_p_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.jdField_p_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setTag(paramVideoItemHolder);
      }
    }
    Object localObject = paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    }
    if (paramVideoItemHolder.n != null)
    {
      localObject = paramVideoItemHolder.n;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.n;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.n;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramVideoItemHolder);
      }
    }
    if (paramVideoItemHolder.o != null)
    {
      localObject = paramVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramVideoItemHolder);
      }
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    }
    paramVideoItemHolder = paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (paramVideoItemHolder != null) {
      paramVideoItemHolder.setVisibility(0);
    }
    b(paramVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_p_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.a(paramBoolean);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b())) {
        break label50;
      }
      localViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_p_of_type_AndroidViewViewGroup;
      if (localViewGroup != null) {
        localViewGroup.setVisibility(0);
      }
    }
    label50:
    do
    {
      return;
      localViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_p_of_type_AndroidViewViewGroup;
    } while (localViewGroup == null);
    localViewGroup.setVisibility(8);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    c(paramVideoInfo);
    VideoFeedsAccessibilityHelper.a((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w, paramVideoInfo.e);
    ImageView localImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(a(paramVideoInfo.r)));
    }
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.x, paramVideoInfo.v, "赞");
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.y, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.j != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.a;
      if (localObject != null)
      {
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).a == 0)) {}
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.a;
        if (localObject != null)
        {
          localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
          if ((localObject != null) && (((VideoInfo)localObject).a() == true)) {
            break label86;
          }
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    label86:
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.j;
      } while (localObject == null);
      ((ViewGroup)localObject).setVisibility(0);
      return;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.j;
    } while (localObject == null);
    ((ViewGroup)localObject).setVisibility(8);
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.e > 0)
    {
      TextView localTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w, paramVideoInfo.e, "评论");
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.k;
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageResource(2130843309);
      }
    }
    do
    {
      return;
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.k;
    } while (paramVideoInfo == null);
    paramVideoInfo.setImageResource(2130843310);
  }
  
  public void c(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.r != null)
    {
      localViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.r;
      if (localViewGroup != null) {
        if (!paramBoolean) {
          break label34;
        }
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.x;
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.a;
    if (localObject2 != null)
    {
      localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject2).a;
      if (localObject2 == null) {}
    }
    for (int i = ((VideoInfo)localObject2).v;; i = 0)
    {
      VideoFeedsHelper.b((TextView)localObject1, i, "赞");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a == null)
      {
        localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject1).setDuration(200L);
        ((ScaleAnimation)localObject1).setRepeatCount(1);
        ((ScaleAnimation)localObject1).setRepeatMode(2);
        ((ScaleAnimation)localObject1).setInterpolator((Interpolator)new DecelerateInterpolator());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a = ((Animation)localObject1);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a.setAnimationListener((Animation.AnimationListener)new CommonVideoItemDelegate.onDianZanClick.1(this));
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).startAnimation(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a);
      }
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.s != null)
    {
      localViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.s;
      if (localViewGroup != null) {
        if (!paramBoolean) {
          break label34;
        }
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    if (paramBoolean)
    {
      localTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      a(false);
      b(false);
      l(false);
      return;
    }
    TextView localTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.v;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    a(true);
    b(true);
    l(true);
  }
  
  public void l(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.a;
      if (localObject != null)
      {
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).a() == true)) {
          break label58;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    label58:
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
      } while (localObject == null);
      ((ViewGroup)localObject).setVisibility(0);
      return;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
    } while (localObject == null);
    ((ViewGroup)localObject).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.CommonVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */