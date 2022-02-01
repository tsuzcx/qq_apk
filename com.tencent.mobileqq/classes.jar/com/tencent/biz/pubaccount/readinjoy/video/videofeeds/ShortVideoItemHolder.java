package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "aboveAutoSeekBarContent", "getAboveAutoSeekBarContent", "()Landroid/view/View;", "setAboveAutoSeekBarContent", "adGuideContent", "adGuideGotoBtn", "Landroid/widget/TextView;", "adGuideIcon", "Landroid/widget/ImageView;", "adGuideMask", "adGuideName", "adGuideProgress", "Lcom/tencent/biz/pubaccount/readinjoy/view/CircleCountdownView;", "adGuideReplayBtn", "aioGuideView", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAioGuideView;", "getAioGuideView", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAioGuideView;", "setAioGuideView", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAioGuideView;)V", "autoSeekBarCurrentTime", "getAutoSeekBarCurrentTime", "()Landroid/widget/TextView;", "setAutoSeekBarCurrentTime", "(Landroid/widget/TextView;)V", "autoSeekBarTimer", "Landroid/view/ViewGroup;", "getAutoSeekBarTimer", "()Landroid/view/ViewGroup;", "setAutoSeekBarTimer", "(Landroid/view/ViewGroup;)V", "autoSeekBarTimerViewStub", "Landroid/view/ViewStub;", "getAutoSeekBarTimerViewStub", "()Landroid/view/ViewStub;", "setAutoSeekBarTimerViewStub", "(Landroid/view/ViewStub;)V", "autoSeekBarTotalTime", "getAutoSeekBarTotalTime", "setAutoSeekBarTotalTime", "backgroundImageview", "Lcom/tencent/image/URLImageView;", "getBackgroundImageview", "()Lcom/tencent/image/URLImageView;", "setBackgroundImageview", "(Lcom/tencent/image/URLImageView;)V", "columnBanner", "getColumnBanner", "setColumnBanner", "columnBannerArrow", "getColumnBannerArrow", "()Landroid/widget/ImageView;", "setColumnBannerArrow", "(Landroid/widget/ImageView;)V", "columnBannerBlackArrow", "getColumnBannerBlackArrow", "setColumnBannerBlackArrow", "columnBannerHighLightText", "getColumnBannerHighLightText", "setColumnBannerHighLightText", "columnBannerIcon", "getColumnBannerIcon", "setColumnBannerIcon", "columnBannerLightLine", "Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;", "getColumnBannerLightLine", "()Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;", "setColumnBannerLightLine", "(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;)V", "columnBannerLogo", "getColumnBannerLogo", "setColumnBannerLogo", "columnBannerName", "getColumnBannerName", "setColumnBannerName", "columnBannerNormalText", "getColumnBannerNormalText", "setColumnBannerNormalText", "columnBannerPrefix", "getColumnBannerPrefix", "setColumnBannerPrefix", "columnBannerSubscribeBtn", "getColumnBannerSubscribeBtn", "setColumnBannerSubscribeBtn", "columnBannerViewStub", "getColumnBannerViewStub", "setColumnBannerViewStub", "columnExpandBannerBg", "getColumnExpandBannerBg", "setColumnExpandBannerBg", "columnSmallBanner", "getColumnSmallBanner", "setColumnSmallBanner", "headerAccountIconViewGroup", "Landroid/widget/FrameLayout;", "getHeaderAccountIconViewGroup", "()Landroid/widget/FrameLayout;", "setHeaderAccountIconViewGroup", "(Landroid/widget/FrameLayout;)V", "headerAccountLiveLogo", "headerAccountViconImageView", "getHeaderAccountViconImageView", "setHeaderAccountViconImageView", "innerFooterViewGroupBG", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGradientMaskView;", "getInnerFooterViewGroupBG", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGradientMaskView;", "setInnerFooterViewGroupBG", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGradientMaskView;)V", "innerVideoArea", "getInnerVideoArea", "setInnerVideoArea", "locationContent", "getLocationContent", "setLocationContent", "locationIcon", "getLocationIcon", "setLocationIcon", "locationViewGroup", "getLocationViewGroup", "setLocationViewGroup", "logoImageView", "playCountTextView", "getPlayCountTextView", "setPlayCountTextView", "rewardCoinBtn", "getRewardCoinBtn", "setRewardCoinBtn", "rewardCoinCountText", "getRewardCoinCountText", "setRewardCoinCountText", "rewardCoinIcon", "getRewardCoinIcon", "setRewardCoinIcon", "subscriptText", "switchVideoForAccessibility", "yourFollowText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class ShortVideoItemHolder
  extends VideoItemHolder
{
  @Nullable
  private ViewGroup A;
  @Nullable
  private ViewGroup B;
  @NotNull
  private ViewGroup C;
  @Nullable
  private ViewGroup D;
  @Nullable
  private ViewGroup E;
  @Nullable
  private TextView O;
  @JvmField
  @Nullable
  public View a;
  @JvmField
  @NotNull
  public ImageView a;
  @JvmField
  @Nullable
  public TextView a;
  @Nullable
  private VideoFeedsAioGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
  @NotNull
  private VideoFeedsGradientMaskView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
  @JvmField
  @Nullable
  public CircleCountdownView a;
  @Nullable
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  @NotNull
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  @JvmField
  @Nullable
  public View b;
  @NotNull
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  @NotNull
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  @JvmField
  @Nullable
  public ImageView b;
  @JvmField
  @Nullable
  public TextView b;
  @Nullable
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  @JvmField
  @Nullable
  public View c;
  @Nullable
  private ViewStub c;
  @JvmField
  @NotNull
  public ImageView c;
  @JvmField
  @Nullable
  public TextView c;
  @NotNull
  private View jdField_d_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  @JvmField
  @Nullable
  public TextView d;
  @Nullable
  private View jdField_e_of_type_AndroidViewView;
  @Nullable
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  @JvmField
  @Nullable
  public TextView e;
  @Nullable
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  @Nullable
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  @Nullable
  private TextView g;
  @Nullable
  private TextView h;
  @Nullable
  private TextView i;
  @Nullable
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  @Nullable
  private URLImageView jdField_j_of_type_ComTencentImageURLImageView;
  @Nullable
  private TextView k;
  @Nullable
  private TextView l;
  @Nullable
  private TextView m;
  @Nullable
  private TextView n;
  @NotNull
  private ImageView p;
  @Nullable
  private ImageView q;
  @NotNull
  private ViewGroup z;
  
  public ShortVideoItemHolder(@NotNull View paramView)
  {
    super(paramView, 2);
    View localView = paramView.findViewById(2131369132);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_footer_view_group_bg)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)localView);
    localView = paramView.findViewById(2131368351);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.h…_account_vicon_imageview)");
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView);
    this.jdField_a_of_type_AndroidViewView = VideoFeedsAccessibilityHelper.a(paramView);
    localView = paramView.findViewById(2131363423);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.background_imageview)");
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381439));
    localView = paramView.findViewById(2131370840);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.logo_imageview)");
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131368346);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_layout)");
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView);
    localView = paramView.findViewById(2131381335);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…eeds_fl_inner_video_area)");
    this.z = ((ViewGroup)localView);
    localView = paramView.findViewById(2131381378);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…o_feeds_vs_column_banner)");
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)localView);
    localView = paramView.findViewById(2131368347);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.header_account_icon_living)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131367361);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_layout)");
    this.C = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367360);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.footer_send_coin_icon)");
    this.p = ((ImageView)localView);
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367362));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381371));
    this.D = ((ViewGroup)paramView.findViewById(2131381340));
    this.q = ((ImageView)paramView.findViewById(2131381339));
    this.m = ((TextView)paramView.findViewById(2131381338));
    this.jdField_c_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131381377));
    localView = paramView.findViewById(2131381355);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.v…ove_auto_seekbar_content)");
    this.jdField_d_of_type_AndroidViewView = localView;
    if (Aladdin.getConfig(327).getIntegerFromString("is_show_your_follow", 0) == 1) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381372));
    }
    int i1 = (int)(Aladdin.getConfig(263).getFloatFromString("bottom_mask_alpha", 0.7F) * 'ÿ');
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setMaskAlpha(i1);
    if (this.jdField_l_of_type_AndroidViewViewGroup != null) {
      VideoFeedsHelper.a(this.jdField_l_of_type_AndroidViewViewGroup);
    }
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_d_of_type_AndroidViewView;
  }
  
  @NotNull
  public final ViewGroup a()
  {
    return this.z;
  }
  
  @NotNull
  public final ViewStub a()
  {
    return this.jdField_b_of_type_AndroidViewViewStub;
  }
  
  @NotNull
  public final FrameLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetFrameLayout;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView a()
  {
    return this.jdField_f_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final VideoFeedsAioGuideView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView;
  }
  
  @NotNull
  public final VideoFeedsGradientMaskView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView;
  }
  
  @Nullable
  public final KandianUrlImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  }
  
  @NotNull
  public final URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.jdField_d_of_type_AndroidViewView = paramView;
  }
  
  public final void a(@Nullable ViewGroup paramViewGroup)
  {
    this.A = paramViewGroup;
  }
  
  public final void a(@Nullable ImageView paramImageView)
  {
    this.jdField_e_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void a(@Nullable TextView paramTextView)
  {
    this.g = paramTextView;
  }
  
  public final void a(@Nullable VideoFeedsAioGuideView paramVideoFeedsAioGuideView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = paramVideoFeedsAioGuideView;
  }
  
  public final void a(@Nullable KandianUrlImageView paramKandianUrlImageView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = paramKandianUrlImageView;
  }
  
  public final void a(@Nullable URLImageView paramURLImageView)
  {
    this.jdField_b_of_type_ComTencentImageURLImageView = paramURLImageView;
  }
  
  @Nullable
  public final View b()
  {
    return this.jdField_e_of_type_AndroidViewView;
  }
  
  @Nullable
  public final ViewGroup b()
  {
    return this.A;
  }
  
  @Nullable
  public final ViewStub b()
  {
    return this.jdField_c_of_type_AndroidViewViewStub;
  }
  
  @Nullable
  public final ImageView b()
  {
    return this.jdField_e_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView b()
  {
    return this.g;
  }
  
  @Nullable
  public final URLImageView b()
  {
    return this.jdField_b_of_type_ComTencentImageURLImageView;
  }
  
  public final void b(@Nullable View paramView)
  {
    this.jdField_e_of_type_AndroidViewView = paramView;
  }
  
  public final void b(@Nullable ViewGroup paramViewGroup)
  {
    this.B = paramViewGroup;
  }
  
  public final void b(@Nullable ImageView paramImageView)
  {
    this.jdField_f_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void b(@Nullable TextView paramTextView)
  {
    this.h = paramTextView;
  }
  
  public final void b(@Nullable URLImageView paramURLImageView)
  {
    this.jdField_j_of_type_ComTencentImageURLImageView = paramURLImageView;
  }
  
  @NotNull
  public final ViewGroup c()
  {
    return this.C;
  }
  
  @Nullable
  public final ImageView c()
  {
    return this.jdField_f_of_type_AndroidWidgetImageView;
  }
  
  @Nullable
  public final TextView c()
  {
    return this.h;
  }
  
  @Nullable
  public final URLImageView c()
  {
    return this.jdField_j_of_type_ComTencentImageURLImageView;
  }
  
  public final void c(@Nullable ViewGroup paramViewGroup)
  {
    this.E = paramViewGroup;
  }
  
  public final void c(@Nullable TextView paramTextView)
  {
    this.i = paramTextView;
  }
  
  @Nullable
  public final ViewGroup d()
  {
    return this.D;
  }
  
  @NotNull
  public final ImageView d()
  {
    return this.p;
  }
  
  @Nullable
  public final TextView d()
  {
    return this.i;
  }
  
  public final void d(@Nullable TextView paramTextView)
  {
    this.jdField_j_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  @Nullable
  public final ViewGroup e()
  {
    return this.E;
  }
  
  @Nullable
  public final ImageView e()
  {
    return this.q;
  }
  
  @Nullable
  public final TextView e()
  {
    return this.jdField_j_of_type_AndroidWidgetTextView;
  }
  
  public final void e(@Nullable TextView paramTextView)
  {
    this.k = paramTextView;
  }
  
  @Nullable
  public final TextView f()
  {
    return this.k;
  }
  
  public final void f(@Nullable TextView paramTextView)
  {
    this.n = paramTextView;
  }
  
  @Nullable
  public final TextView g()
  {
    return this.jdField_l_of_type_AndroidWidgetTextView;
  }
  
  public final void g(@Nullable TextView paramTextView)
  {
    this.O = paramTextView;
  }
  
  @Nullable
  public final TextView h()
  {
    return this.m;
  }
  
  @Nullable
  public final TextView i()
  {
    return this.n;
  }
  
  @Nullable
  public final TextView j()
  {
    return this.O;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */