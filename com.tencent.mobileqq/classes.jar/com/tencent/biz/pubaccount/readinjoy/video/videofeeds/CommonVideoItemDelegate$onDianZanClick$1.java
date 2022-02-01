package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.AdapterEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/videofeeds/CommonVideoItemDelegate$onDianZanClick$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommonVideoItemDelegate$onDianZanClick$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() == CommonVideoItemDelegate.a(this.a)) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a != null)) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a.a(CommonVideoItemDelegate.a(this.a));
    }
  }
  
  public void onAnimationRepeat(@NotNull Animation paramAnimation)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    Object localObject;
    if (CommonVideoItemDelegate.a(this.a).a != null)
    {
      localObject = CommonVideoItemDelegate.a(this.a).a;
      if (localObject == null) {
        break label142;
      }
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
      if (localObject != null)
      {
        localObject = CommonVideoItemDelegate.a(this.a).a;
        if (localObject == null) {
          break label147;
        }
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
        if ((localObject == null) || (((VideoInfo)localObject).r != true)) {
          break label147;
        }
      }
    }
    for (;;)
    {
      if (CommonVideoItemDelegate.a(this.a).m != null)
      {
        localObject = CommonVideoItemDelegate.a(this.a).m;
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.a.a(bool)));
        }
      }
      paramAnimation.setInterpolator((Interpolator)new AnticipateInterpolator());
      return;
      label142:
      localObject = null;
      break;
      label147:
      bool = false;
    }
  }
  
  public void onAnimationStart(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.CommonVideoItemDelegate.onDianZanClick.1
 * JD-Core Version:    0.7.0.1
 */