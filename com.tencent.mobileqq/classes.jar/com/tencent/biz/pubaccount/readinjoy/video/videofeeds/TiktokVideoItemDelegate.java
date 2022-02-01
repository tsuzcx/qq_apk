package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsFollowButton;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout.OnFollowActionListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout.StressState;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout$OnFollowActionListener;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "getRewardCoinIconRes", "info", "Lcom/tencent/biz/pubaccount/VideoInfo;", "hideAutoSeekBarTimer", "", "onFollowClick", "videoInfo", "onMenuDataChanged", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setFooterVisibility", "visible", "setHeaderVisibility", "showAutoSeekBarTimer", "updateCommentUI", "updateFollowStateAndUI", "needAnim", "updateStressFollowLayoutUi", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TiktokVideoItemDelegate
  extends ShortVideoItemDelegate
  implements VideoFeedsStressFollowLayout.OnFollowActionListener
{
  private final TiktokVideoItemHolder a;
  
  public TiktokVideoItemDelegate(@NotNull TiktokVideoItemHolder paramTiktokVideoItemHolder, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    super((ShortVideoItemHolder)paramTiktokVideoItemHolder, paramVideoFeedsRecommendPresenter, paramVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder = paramTiktokVideoItemHolder;
    paramTiktokVideoItemHolder = VideoFeedsHelper.b(paramVideoFeedsRecommendPresenter.a());
    if (paramTiktokVideoItemHolder[1] / paramTiktokVideoItemHolder[0] >= 1.97D)
    {
      paramTiktokVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder;
      paramVideoFeedsRecommendPresenter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.p;
      if (paramVideoFeedsRecommendPresenter == null) {
        break label128;
      }
      paramVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter.getLayoutParams();
      if (paramVideoFeedsRecommendPresenter == null) {
        break label128;
      }
    }
    label128:
    for (int i = paramVideoFeedsRecommendPresenter.height;; i = 0)
    {
      paramTiktokVideoItemHolder.jdField_d_of_type_Int = i;
      paramTiktokVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.p;
      if (paramTiktokVideoItemHolder != null) {
        paramTiktokVideoItemHolder.setBackgroundDrawable(null);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.a().a((VideoFeedsStressFollowLayout.OnFollowActionListener)this);
      return;
    }
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.q) {
      paramVideoInfo.a = VideoFeedsStressFollowLayout.StressState.Shrink;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.a().setVideoInfo(paramVideoInfo);
    VideoFeedsStressFollowHelper localVideoFeedsStressFollowHelper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowHelper;
    paramVideoInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.stressState");
    localVideoFeedsStressFollowHelper.a(paramVideoInfo);
  }
  
  protected int a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.o) {
      return 2130843349;
    }
    return 2130843351;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843347;
    }
    return 2130843350;
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo)
  {
    long l2 = -1L;
    Object localObject;
    if (paramVideoInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.b(paramVideoInfo);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) {
        break label145;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject == null) {
        break label139;
      }
      localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo);
      if (localObject == null) {
        break label151;
      }
    }
    label139:
    label145:
    label151:
    for (long l1 = ((VideoPlayerWrapper)localObject).a();; l1 = -1L)
    {
      paramVideoInfo = paramVideoInfo.a(l1);
      l1 = l2;
      if (localObject != null) {
        l1 = ((VideoPlayerWrapper)localObject).b();
      }
      paramVideoInfo = paramVideoInfo.c(l1).af(1).M(0).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80078FD", "0X80078FD", 0, 0, "3", "", "", paramVideoInfo.a(), false);
      return;
      localObject = null;
      break;
      localObject = null;
      break;
    }
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a() != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
      if (localQQAppInterface != null)
      {
        long l = localQQAppInterface.getLongAccountUin();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.a().setHeadImgByUin(l);
      }
    }
    if (paramVideoInfo.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.c().setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.a().setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.c().setVisibility(8);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a_(paramVideoInfo);
    d(paramVideoInfo);
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.b(paramVideoInfo);
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.q;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.k(), paramVideoInfo.r, "分享");
    }
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    d(paramVideoInfo);
    if (paramVideoInfo.a == VideoFeedsStressFollowLayout.StressState.Stretched)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton == null) {}
      do
      {
        do
        {
          return;
          paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
        } while (paramVideoInfo == null);
        paramVideoInfo = paramVideoInfo.a();
      } while (paramVideoInfo == null);
      paramVideoInfo.setVisibility(8);
      return;
    }
    super.b(paramVideoInfo, paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).q == true))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.f().setVisibility(0);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.f().setVisibility(8);
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.w, paramVideoInfo.e, "评论");
    paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.k;
    if (paramVideoInfo != null) {
      paramVideoInfo.setImageResource(2130843346);
    }
  }
  
  public void e()
  {
    super.e();
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.s, 0);
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.l, 0);
  }
  
  public void f()
  {
    super.f();
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.s, 8);
    VideoFeedsHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.l, 8);
  }
  
  public void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.d().getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (paramBoolean) {}
    for (int i = DisplayUtil.a((Context)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), 86.0F);; i = DisplayUtil.a((Context)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(), 5.0F))
    {
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, ((ViewGroup.MarginLayoutParams)localObject).topMargin, i, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsTiktokVideoItemHolder.d().setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.TiktokVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */