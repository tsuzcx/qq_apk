package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsItemUIDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.MsgLayoutHelper;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseItemHolder;", "view", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "autoSeekBar", "Landroid/widget/SeekBar;", "bottomSeekbarLayout", "Landroid/view/ViewGroup;", "coverImageView", "Lcom/tencent/image/URLImageView;", "currentTimeTextView", "Landroid/widget/TextView;", "delegate", "Lcom/tencent/biz/pubaccount/readinjoy/video/IVideoFeedsItemUIDelegate;", "exitFullScreenButton", "fullOperationIconImageView", "Landroid/widget/ImageView;", "fullOperationLayout", "fullScreenLayout", "fullTitleTextView", "gestureLayout", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGestureLayout;", "kingcardGuideTextView", "msgLayoutHelper", "Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/MsgLayoutHelper;", "playButton", "playButtonLayout", "seekBar", "speedRatioBtn", "speedRatioContainer", "totalTimeTextView", "videoArea", "videoAreaBottomOffset", "videoControllerLayout", "videoEndMaskView", "videoInfoShowTextViewDebug", "videoLayout", "videoPlayParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "videoUIDelegate", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsVideoUIDelegate;", "volumeIcon", "xgFileSizeBlackToast", "xgFileSizeTextView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class BaseVideoItemHolder
  extends BaseItemHolder
{
  @JvmField
  @NotNull
  public ViewGroup a;
  @JvmField
  @NotNull
  public SeekBar a;
  @JvmField
  @Nullable
  public IVideoFeedsItemUIDelegate a;
  @JvmField
  @NotNull
  public VideoFeedsGestureLayout a;
  @JvmField
  @Nullable
  public VideoFeedsPlayManager.VideoPlayParam a;
  @JvmField
  @Nullable
  public VideoFeedsVideoUIDelegate a;
  @JvmField
  @NotNull
  public MsgLayoutHelper a;
  @JvmField
  @NotNull
  public ViewGroup b;
  @JvmField
  @NotNull
  public SeekBar b;
  @JvmField
  @NotNull
  public ViewGroup c;
  @JvmField
  @NotNull
  public URLImageView c;
  @JvmField
  public int d;
  @JvmField
  @NotNull
  public ViewGroup d;
  @JvmField
  @NotNull
  public ViewGroup e;
  @JvmField
  @NotNull
  public ViewGroup f;
  @JvmField
  @NotNull
  public ViewGroup g;
  @JvmField
  @NotNull
  public ImageView g;
  @JvmField
  @NotNull
  public ViewGroup h;
  @JvmField
  @NotNull
  public ImageView h;
  @JvmField
  @Nullable
  public ViewGroup i;
  @JvmField
  @NotNull
  public ImageView i;
  @JvmField
  @Nullable
  public ImageView j;
  @JvmField
  @NotNull
  public View o;
  @JvmField
  @NotNull
  public TextView o;
  @JvmField
  @NotNull
  public TextView p;
  @JvmField
  @NotNull
  public TextView q;
  @JvmField
  @NotNull
  public TextView r;
  @JvmField
  @NotNull
  public TextView s;
  @JvmField
  @NotNull
  public TextView t;
  @JvmField
  @NotNull
  public TextView u;
  
  public BaseVideoItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    View localView = paramView.findViewById(2131369128);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_auto_seekBar)");
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)localView);
    paramView = paramView.findViewById(2131365123);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.common_content_view_group)");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    paramView = (View)this.jdField_a_of_type_AndroidViewViewGroup;
    localView = paramView.findViewById(2131381401);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_layout)");
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367857);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.gesture_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)localView);
    localView = paramView.findViewById(2131365429);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.cover_imageview)");
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)localView);
    localView = paramView.findViewById(2131373247);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button)");
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131381303);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_controller_layout)");
    this.d = ((ViewGroup)localView);
    localView = paramView.findViewById(2131377696);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.seekbar)");
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView);
    localView = paramView.findViewById(2131365503);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.current_time_textview)");
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramView.findViewById(2131379734);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.total_time_textview)");
    this.q = ((TextView)localView);
    localView = paramView.findViewById(2131373248);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button_layout)");
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131363807);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.bottom_controller_layout)");
    this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367653);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation)");
    this.jdField_h_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367654);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation_icon)");
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131372582);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.operate_button_xg)");
    this.r = ((TextView)localView);
    localView = paramView.findViewById(2131366953);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.file_size_black_toast)");
    this.s = ((TextView)localView);
    localView = paramView.findViewById(2131370003);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.king_card_guide)");
    this.t = ((TextView)localView);
    localView = paramView.findViewById(2131378084);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.show_video_info_for_debug)");
    this.p = ((TextView)localView);
    localView = paramView.findViewById(2131367652);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_layout)");
    this.e = ((ViewGroup)localView);
    localView = paramView.findViewById(2131364828);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.close_button)");
    this.f = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367655);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_title)");
    this.u = ((TextView)localView);
    localView = paramView.findViewById(2131381567);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_volume_icon)");
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131381328);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_end_mask_view)");
    this.jdField_o_of_type_AndroidViewView = localView;
    this.j = ((ImageView)paramView.findViewById(2131381502));
    this.jdField_i_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131381503));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper = new MsgLayoutHelper(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */