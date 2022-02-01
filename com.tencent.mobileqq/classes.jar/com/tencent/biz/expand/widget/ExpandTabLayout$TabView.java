package com.tencent.biz.expand.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/widget/ExpandTabLayout$TabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$ITabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "badgeAnchorView", "Landroid/view/View;", "getBadgeAnchorView", "()Landroid/view/View;", "setBadgeAnchorView", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "tab", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;", "getTab", "()Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;", "setTab", "(Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandTabLayout$TabView
  extends LinearLayout
  implements ExpandTabLayout.ITabView
{
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private ExpandTabLayout.Tab jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$Tab;
  
  public ExpandTabLayout$TabView(@NotNull Context paramContext)
  {
    super(paramContext);
    setGravity(17);
    setOrientation(1);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    paramContext = (View)this.jdField_a_of_type_AndroidWidgetImageView;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext = (View)this.jdField_a_of_type_AndroidWidgetTextView;
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)localLayoutParams);
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public final void setBadgeAnchorView(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public final void setImageView(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void setTab(@Nullable ExpandTabLayout.Tab paramTab)
  {
    this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$Tab = paramTab;
  }
  
  public final void setTextView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.widget.ExpandTabLayout.TabView
 * JD-Core Version:    0.7.0.1
 */