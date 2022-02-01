package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/FooterItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseItemHolder;", "view", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "loadingLayout", "Landroid/view/ViewGroup;", "loadingProgressBar", "Landroid/widget/ProgressBar;", "loadingTextView", "Landroid/widget/TextView;", "onScroll", "", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "isCenter", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FooterItemHolder
  extends BaseItemHolder
{
  @JvmField
  @NotNull
  public ViewGroup a;
  @JvmField
  @NotNull
  public ProgressBar a;
  @JvmField
  @NotNull
  public TextView a;
  
  public FooterItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    View localView = paramView.findViewById(2131370745);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.loading_layout)");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131370758);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.loading_textview)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    paramView = paramView.findViewById(2131370752);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.loading_progress)");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView);
  }
  
  public void a(@NotNull VideoFeedsAdapter paramVideoFeedsAdapter, @NotNull LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoFeedsAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramLinearLayoutManager, "layoutManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.FooterItemHolder
 * JD-Core Version:    0.7.0.1
 */