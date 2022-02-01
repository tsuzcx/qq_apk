package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsFollowButton;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView.OnSetNickNameListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView$OnSetNickNameListener;", "rootView", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "adHeaderdownloadView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInjoyHeaderAdDownloadView;", "biuLayout", "Landroid/view/ViewGroup;", "contentLayout", "followBtn", "Lcom/tencent/biz/pubaccount/readinjoy/video/IVideoFeedsFollowButton;", "footerBiuCountTextView", "Landroid/widget/TextView;", "footerBuiBtn", "Landroid/widget/ImageView;", "footerCommentBtn", "footerCommentBtnBg", "footerCommentBtnText", "footerDiversion", "footerLikeBtn", "footerLikeCountTextView", "footerViewGroup", "footerWriteCommentBar", "gameBarBtn", "gameBarContainer", "gameBarContent", "gameBarDownloadView", "gameBarThumbnail", "Lcom/tencent/image/URLImageView;", "gameBarTitle", "headerAccountIconImageView", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;", "headerAccountLayout", "headerAccountNameTextView", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;", "headerAdBarTitleLayout", "headerAdContainer", "headerAdMore", "headerAdThumbnail", "headerAdTips", "headerAdTitle", "headerDiversion", "headerSmallGameAdContainer", "headerSoftAdContainer", "headerViewGroup", "hearAdBarIvDownload", "isShowingContent", "", "()Z", "setShowingContent", "(Z)V", "mAdBarCloseSmallV3", "mAdBarDescSmallV3", "mAdBarExpandLayoutSmallV3", "mAdBarThumbnailDescSmallV3", "mAdBarTipsPromotionSmallV3", "mAdBarTipsSmallV3", "mAdBarTitleSmallV3", "mAdBarTitleSmallV4", "mBigCardNormalView", "mBigCardNormalViewAms184", "mBigCardNormalViewAms65", "mBigCardNormalViewTest", "mHeadAdBarThumbnailSmallV3", "mHeadAdBarThumbnailSmallV4", "mSoftAdDownloadViewBig", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "mSoftAdDownloadViewSmallV3", "mVideoFeedsHeaderTopAdContainerSmall", "mVideoFeedsHeaderTopAdContainerSmallV3", "Landroid/widget/LinearLayout;", "mVideoFeedsHeaderTopAdContainerSmallV4", "shareBtn", "shareGuideBtn", "shareLayout", "shuntBarCloseBtn", "shuntBarContainer", "shuntBarThumbnail", "shuntBarTitle", "smallGameBtnText", "smallGameDivider", "softAdBigCard", "softAdThumbnailCloseBtn", "Landroid/widget/FrameLayout;", "strongShuntBarCloseBtn", "strongShuntBarContainer", "strongShuntBarJumpBtn", "strongShuntBarSubTitle", "strongShuntBarThumbnail", "strongShuntBarTitle", "strongShuntBarViewStub", "Landroid/view/ViewStub;", "titleTextView", "ugViewShoot", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsUGView;", "ugViewTop", "onSetNickName", "", "nickName", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class VideoItemHolder
  extends BaseVideoItemHolder
  implements ReadInJoyNickNameTextView.OnSetNickNameListener
{
  @JvmField
  @Nullable
  public View A;
  @JvmField
  @Nullable
  public TextView A;
  @JvmField
  @Nullable
  public View B;
  @JvmField
  @Nullable
  public TextView B;
  @JvmField
  @NotNull
  public View C;
  @JvmField
  @Nullable
  public TextView C;
  @JvmField
  @Nullable
  public TextView D;
  @JvmField
  @Nullable
  public TextView E;
  @JvmField
  @Nullable
  public TextView F;
  @JvmField
  @Nullable
  public TextView G;
  @JvmField
  @Nullable
  public TextView H;
  @JvmField
  @Nullable
  public TextView I;
  @JvmField
  @Nullable
  public TextView J;
  @JvmField
  @Nullable
  public TextView K;
  @JvmField
  @Nullable
  public TextView L;
  @JvmField
  @Nullable
  public TextView M;
  @JvmField
  @Nullable
  public TextView N;
  @JvmField
  @Nullable
  public ViewStub a;
  @JvmField
  @Nullable
  public FrameLayout a;
  @JvmField
  @Nullable
  public IVideoFeedsFollowButton a;
  @JvmField
  @Nullable
  public VideoFeedsUGView a;
  @JvmField
  @Nullable
  public ReadInJoyNickNameTextView a;
  @JvmField
  @Nullable
  public ReadInjoyHeaderAdDownloadView a;
  private boolean a;
  @JvmField
  @Nullable
  public VideoFeedsUGView b;
  @JvmField
  @Nullable
  public ReadInJoyHeadImageView b;
  @JvmField
  @Nullable
  public RIJDownloadView c;
  @JvmField
  @Nullable
  public LinearLayout d;
  @JvmField
  @Nullable
  public RIJDownloadView d;
  @JvmField
  @Nullable
  public URLImageView d;
  @JvmField
  @Nullable
  public LinearLayout e;
  @JvmField
  @Nullable
  public URLImageView e;
  @JvmField
  @Nullable
  public URLImageView f;
  @JvmField
  @Nullable
  public URLImageView g;
  @JvmField
  @Nullable
  public URLImageView h;
  @JvmField
  @Nullable
  public URLImageView i;
  @JvmField
  @Nullable
  public ViewGroup j;
  @JvmField
  @Nullable
  public ViewGroup k;
  @JvmField
  @Nullable
  public ImageView k;
  @JvmField
  @Nullable
  public ViewGroup l;
  @JvmField
  @Nullable
  public ImageView l;
  @JvmField
  @Nullable
  public ViewGroup m;
  @JvmField
  @Nullable
  public ImageView m;
  @JvmField
  @Nullable
  public ViewGroup n;
  @JvmField
  @Nullable
  public ImageView n;
  @JvmField
  @Nullable
  public ViewGroup o;
  @JvmField
  @Nullable
  public ImageView o;
  @JvmField
  @Nullable
  public View p;
  @JvmField
  @Nullable
  public ViewGroup p;
  @JvmField
  @Nullable
  public View q;
  @JvmField
  @Nullable
  public ViewGroup q;
  @JvmField
  @Nullable
  public View r;
  @JvmField
  @Nullable
  public ViewGroup r;
  @JvmField
  @Nullable
  public View s;
  @JvmField
  @Nullable
  public ViewGroup s;
  @JvmField
  @Nullable
  public View t;
  @JvmField
  @Nullable
  public ViewGroup t;
  @JvmField
  @Nullable
  public View u;
  @JvmField
  @Nullable
  public ViewGroup u;
  @JvmField
  @Nullable
  public View v;
  @JvmField
  @Nullable
  public ViewGroup v;
  @JvmField
  @Nullable
  public TextView v;
  @JvmField
  @Nullable
  public View w;
  @JvmField
  @Nullable
  public ViewGroup w;
  @JvmField
  @Nullable
  public TextView w;
  @JvmField
  @Nullable
  public View x;
  @JvmField
  @Nullable
  public ViewGroup x;
  @JvmField
  @Nullable
  public TextView x;
  @JvmField
  @Nullable
  public View y;
  @JvmField
  @Nullable
  public ViewGroup y;
  @JvmField
  @Nullable
  public TextView y;
  @JvmField
  @Nullable
  public View z;
  @JvmField
  @Nullable
  public TextView z;
  
  public VideoItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    this.C = paramView;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_x_of_type_AndroidViewView = this.C.findViewById(2131381499);
    this.v = ((TextView)this.C.findViewById(2131379529));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)this.C.findViewById(2131380848));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView = ((VideoFeedsUGView)this.C.findViewById(2131380846));
    this.j = ((ViewGroup)this.C.findViewById(2131368371));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.C.findViewById(2131368349));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, (ReadInJoyNickNameTextView.OnSetNickNameListener)this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.C.findViewById(2131368345));
    View localView = this.C.findViewById(2131368339);
    paramView = localView;
    if (!(localView instanceof IVideoFeedsFollowButton)) {
      paramView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton = ((IVideoFeedsFollowButton)paramView);
    this.jdField_l_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(2131367356));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.C.findViewById(2131367342));
    this.jdField_n_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(2131372510));
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.C.findViewById(2131367350));
    this.jdField_m_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(2131367372));
    this.k = ((ImageView)this.C.findViewById(2131367344));
    this.w = ((TextView)this.C.findViewById(2131367346));
    this.jdField_p_of_type_AndroidViewView = this.C.findViewById(2131367371);
    this.jdField_x_of_type_AndroidWidgetTextView = ((TextView)this.C.findViewById(2131367353));
    this.y = ((TextView)this.C.findViewById(2131367340));
    this.r = ((ViewGroup)this.C.findViewById(2131381360));
    this.s = ((ViewGroup)this.C.findViewById(2131381359));
    this.jdField_p_of_type_AndroidViewViewGroup = ((ViewGroup)this.C.findViewById(2131381332));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.C.findViewById(2131374186));
    this.o = ((ViewGroup)this.C.findViewById(2131367366));
    this.q = this.C.findViewById(2131367365);
    this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.C.findViewById(2131367364));
    VideoReport.setElementId(this.j, "puin_button");
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton, "follow_button");
    VideoReport.setElementId(this.jdField_p_of_type_AndroidViewView, "write_comment_button");
    VideoReport.setElementId(this.jdField_m_of_type_AndroidViewViewGroup, "comment_button");
    VideoReport.setElementId(this.jdField_m_of_type_AndroidWidgetImageView, "like_button");
    VideoReport.setElementId(this.jdField_l_of_type_AndroidWidgetImageView, "biu_button");
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, "card");
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, ReportPolicy.REPORT_POLICY_NONE);
    VideoReport.setElementId(this.g, "card");
    VideoReport.setElementId(this.i, "card");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "nickName");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
    {
      VideoFeedsAccessibilityHelper.b((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramString);
      VideoFeedsAccessibilityHelper.c((View)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder
 * JD-Core Version:    0.7.0.1
 */