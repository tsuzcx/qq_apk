package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListAdapter$DYAEEffectVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "downloadView", "getDownloadView", "()Landroid/view/View;", "iconContainer", "getIconContainer", "iconImage", "Landroid/widget/ImageView;", "getIconImage", "()Landroid/widget/ImageView;", "iconParent", "Landroid/widget/FrameLayout;", "getIconParent", "()Landroid/widget/FrameLayout;", "maskView", "getMaskView", "progressView", "Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "getProgressView", "()Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "subListIndicator", "getSubListIndicator", "titleText", "Landroid/widget/TextView;", "getTitleText", "()Landroid/widget/TextView;", "createIndicatorDotBackground", "Landroid/graphics/drawable/Drawable;", "highlightColor", "", "normalColor", "createItemForeground", "createItemNameColor", "Landroid/content/res/ColorStateList;", "initProgressView", "", "view", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEEffectListAdapter$DYAEEffectVH
  extends RecyclerView.ViewHolder
{
  @NotNull
  private final ImageView a;
  @NotNull
  private final FrameLayout b;
  @NotNull
  private final TextView c;
  @NotNull
  private final View d;
  @NotNull
  private final View e;
  @NotNull
  private final View f;
  @NotNull
  private final View g;
  @NotNull
  private final AEDownLoadingView h;
  
  public DYAEEffectListAdapter$DYAEEffectVH(@NotNull View paramView)
  {
    super(paramView);
    Object localObject = paramView.findViewById(2063991142);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.id.item_icon)");
    this.a = ((ImageView)localObject);
    localObject = paramView.findViewById(2063991128);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.id.icon_parent)");
    this.b = ((FrameLayout)localObject);
    localObject = paramView.findViewById(2063991147);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.id.item_name)");
    this.c = ((TextView)localObject);
    localObject = paramView.findViewById(2063991148);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.….item_sub_list_indicator)");
    this.d = ((View)localObject);
    localObject = paramView.findViewById(2063991019);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.id.download_view)");
    this.e = ((View)localObject);
    localObject = paramView.findViewById(2063991256);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.id.mask_view)");
    this.f = ((View)localObject);
    localObject = paramView.findViewById(2063991127);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "itemView.findViewById(R.id.icon_container)");
    this.g = ((View)localObject);
    paramView = paramView.findViewById(2063991328);
    localObject = (AEDownLoadingView)paramView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
    a((AEDownLoadingView)localObject);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById<AE…gressView(this)\n        }");
    this.h = ((AEDownLoadingView)localObject);
    int i = DYAEBeautyPanelConfigHolder.a().d();
    int j = DYAEBeautyPanelConfigHolder.a().e();
    this.b.setForeground(a(i));
    this.c.setTextColor(a(i, j));
    this.d.setBackgroundDrawable(b(i, j));
  }
  
  private final ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList((int[][])new int[][] { { -16842910 }, { 16842919 }, { 16842913 }, new int[0] }, new int[] { paramInt2, paramInt1, paramInt1, paramInt2 });
  }
  
  private final Drawable a(int paramInt)
  {
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    Object localObject2 = this.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView");
    localObject2 = ((View)localObject2).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.resources");
    ((GradientDrawable)localObject1).setCornerRadius(TypedValue.applyDimension(1, 9.0F, ((Resources)localObject2).getDisplayMetrics()));
    localObject2 = this.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView");
    localObject2 = ((View)localObject2).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.resources");
    ((GradientDrawable)localObject1).setStroke((int)TypedValue.applyDimension(1, 2.0F, ((Resources)localObject2).getDisplayMetrics()), paramInt);
    localObject2 = new StateListDrawable();
    localObject1 = (Drawable)localObject1;
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842913 }, (Drawable)localObject1);
    return (Drawable)localObject2;
  }
  
  private final void a(AEDownLoadingView paramAEDownLoadingView)
  {
    Object localObject = paramAEDownLoadingView.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.resources");
    localObject = ((Resources)localObject).getDisplayMetrics();
    float f1 = TypedValue.applyDimension(1, 6.0F, (DisplayMetrics)localObject);
    float f2 = TypedValue.applyDimension(1, 2.0F, (DisplayMetrics)localObject);
    float f3 = TypedValue.applyDimension(1, 16.0F, (DisplayMetrics)localObject);
    paramAEDownLoadingView.setBgCorner(f3 / 2.0F);
    paramAEDownLoadingView.setMinimumHeight((int)f3);
    paramAEDownLoadingView.setProgressSizeAndMode(f1, f2, false);
    paramAEDownLoadingView.setBgColor(Color.parseColor("#FFFFFF"));
    paramAEDownLoadingView.setProgressColor(Color.parseColor("#00CAFC"));
    paramAEDownLoadingView.a(false);
  }
  
  private final Drawable b(int paramInt1, int paramInt2)
  {
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(1);
    ((GradientDrawable)localObject1).setColor(paramInt2);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(1);
    ((GradientDrawable)localObject2).setColor(paramInt1);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localObject2 = (Drawable)localObject2;
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
    localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject2);
    localObject1 = (Drawable)localObject1;
    localStateListDrawable.addState(new int[0], (Drawable)localObject1);
    return (Drawable)localStateListDrawable;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.a;
  }
  
  @NotNull
  public final FrameLayout b()
  {
    return this.b;
  }
  
  @NotNull
  public final TextView c()
  {
    return this.c;
  }
  
  @NotNull
  public final View d()
  {
    return this.d;
  }
  
  @NotNull
  public final View e()
  {
    return this.e;
  }
  
  @NotNull
  public final View f()
  {
    return this.g;
  }
  
  @NotNull
  public final AEDownLoadingView g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListAdapter.DYAEEffectVH
 * JD-Core Version:    0.7.0.1
 */