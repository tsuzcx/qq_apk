package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/SelectableThumbClipView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "durationView", "Landroid/widget/TextView;", "getDurationView", "()Landroid/widget/TextView;", "setDurationView", "(Landroid/widget/TextView;)V", "foregroundView", "Landroid/view/View;", "thumbView", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "getThumbView", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "setSelected", "", "selected", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
@RequiresApi(16)
public final class SelectableThumbClipView
  extends FrameLayout
{
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final ThumbClipView jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderThumbClipView;
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderThumbClipView = new ThumbClipView(paramContext, null, 0, 6, null);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(2063990853), getResources().getDimensionPixelSize(2063990851)));
    this.jdField_a_of_type_AndroidViewView.setBackground(getResources().getDrawable(2064056427));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, (int)getResources().getDimension(2063990836));
    paramAttributeSet.leftMargin = ((int)getResources().getDimension(2063990812));
    paramAttributeSet.bottomMargin = ((int)getResources().getDimension(2063990814));
    paramAttributeSet.gravity = 83;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2063990832));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setTextColor(localTextView.getResources().getColor(2131167394));
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 1.0F, 1.0F, 2131165336);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)getResources().getDimension(2063990813), 0, (int)getResources().getDimension(2063990813), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(paramContext, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    addView((View)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderThumbClipView);
    addView(this.jdField_a_of_type_AndroidViewView);
    addView((View)this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final ThumbClipView a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderThumbClipView;
  }
  
  public final void setDurationView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    View localView = this.jdField_a_of_type_AndroidViewView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.SelectableThumbClipView
 * JD-Core Version:    0.7.0.1
 */