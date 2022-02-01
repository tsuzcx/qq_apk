package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.ScalingFrameLayout;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarBgView", "Landroid/view/View;", "avatarView", "followBtn", "followClickListeners", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout$OnFollowActionListener;", "Lkotlin/collections/ArrayList;", "followCountTextView", "Landroid/widget/TextView;", "infoView", "liveMaskView", "nickNameTextView", "nowStressState", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout$StressState;", "scalingLayout", "Lcom/tencent/biz/pubaccount/readinjoy/widgets/ScalingFrameLayout;", "shrinkWidth", "", "stretchWidth", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "addFollowButtonClick", "", "onFollowActionListener", "canDoAnim", "", "getFormatFollowCount", "", "count", "getState", "isShowStressFollowed", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setStressState", "state", "setVideoInfo", "info", "updateStretchPercent", "percent", "Companion", "OnFollowActionListener", "StressState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowLayout
  extends FrameLayout
{
  public static final VideoFeedsStressFollowLayout.Companion a;
  private static final float jdField_b_of_type_Float = 0.48F;
  private final float jdField_a_of_type_Float = DisplayUtils.a((Context)BaseApplication.getContext(), 48.0F);
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsStressFollowLayout.StressState jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState = VideoFeedsStressFollowLayout.StressState.Shrink;
  private final ScalingFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsScalingFrameLayout;
  private final ArrayList<VideoFeedsStressFollowLayout.OnFollowActionListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final View jdField_b_of_type_AndroidViewView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final View c;
  private final View d;
  private final View e;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$Companion = new VideoFeedsStressFollowLayout.Companion(null);
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2131560468, (ViewGroup)this, true);
    setBackgroundResource(2130843437);
    paramContext = findViewById(2131369118);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131367099);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsScalingFrameLayout = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131368337);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131368345);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.c = paramContext;
    paramContext = findViewById(2131368347);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.d = paramContext;
    paramContext = findViewById(2131369127);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.e = paramContext;
    paramContext = findViewById(2131380481);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131380368);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131560468, (ViewGroup)this, true);
    setBackgroundResource(2130843437);
    paramContext = findViewById(2131369118);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131367099);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsScalingFrameLayout = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131368337);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131368345);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.c = paramContext;
    paramContext = findViewById(2131368347);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.d = paramContext;
    paramContext = findViewById(2131369127);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.e = paramContext;
    paramContext = findViewById(2131380481);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131380368);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131560468, (ViewGroup)this, true);
    setBackgroundResource(2130843437);
    paramContext = findViewById(2131369118);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131367099);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsScalingFrameLayout = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131368337);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131368345);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.c = paramContext;
    paramContext = findViewById(2131368347);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.d = paramContext;
    paramContext = findViewById(2131369127);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.e = paramContext;
    paramContext = findViewById(2131380481);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131380368);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  private final String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Float.valueOf(paramInt / 10000.0F);
    localObject = String.format("%.1fW", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    return localObject;
  }
  
  @NotNull
  public final VideoFeedsStressFollowLayout.StressState a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState;
  }
  
  public final void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      return;
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.width = ((int)(this.jdField_a_of_type_Int * paramFloat + this.jdField_a_of_type_Float));
      setLayoutParams(localLayoutParams);
      float f = RangesKt.coerceAtLeast(paramFloat - jdField_b_of_type_Float, 0.0F) / (1.0F - jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidViewView.setAlpha(f);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsScalingFrameLayout.setScale(1.2F - 0.2F * paramFloat);
      if (paramFloat == 0.0F) {}
      for (int i = 8; this.e.getVisibility() != i; i = 0)
      {
        this.e.setVisibility(i);
        return;
      }
    }
  }
  
  public final void a(@NotNull VideoFeedsStressFollowLayout.OnFollowActionListener paramOnFollowActionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnFollowActionListener, "onFollowActionListener");
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnFollowActionListener);
  }
  
  public final boolean a()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    return (localVideoInfo != null) && (!localVideoInfo.q);
  }
  
  public final boolean b()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    return (localVideoInfo != null) && (localVideoInfo.jdField_k_of_type_Boolean == true);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ((int)(getMeasuredWidth() - this.jdField_a_of_type_Float));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState != VideoFeedsStressFollowLayout.StressState.Stretched) {
        break label46;
      }
    }
    label46:
    for (float f = 1.0F;; f = 0.0F)
    {
      a(f);
      return;
    }
  }
  
  public final void setStressState(@NotNull VideoFeedsStressFollowLayout.StressState paramStressState)
  {
    Intrinsics.checkParameterIsNotNull(paramStressState, "state");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState == paramStressState) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState = paramStressState;
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (localVideoInfo != null) {
      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState = paramStressState;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState == VideoFeedsStressFollowLayout.StressState.Stretched) {
      a(1.0F);
    }
    for (;;)
    {
      post((Runnable)new VideoFeedsStressFollowLayout.setStressState.1(this));
      return;
      a(0.0F);
    }
  }
  
  public final void setVideoInfo(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramVideoInfo.jdField_k_of_type_JavaLangString);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    localTextView.setText((CharSequence)localBaseApplication.getResources().getString(2131718260, new Object[] { a(paramVideoInfo.o) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout
 * JD-Core Version:    0.7.0.1
 */