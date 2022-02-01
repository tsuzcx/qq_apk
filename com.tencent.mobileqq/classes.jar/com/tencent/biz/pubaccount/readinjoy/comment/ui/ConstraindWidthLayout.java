package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/ConstraindWidthLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "generateDefaultLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "lp", "Landroid/view/ViewGroup$LayoutParams;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "LayoutParams", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ConstraindWidthLayout
  extends LinearLayout
{
  public ConstraindWidthLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ConstraindWidthLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ConstraindWidthLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  @Nullable
  protected LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    return (LinearLayout.LayoutParams)new ConstraindWidthLayout.LayoutParams(-2, -2, 0.0F, 4, null);
  }
  
  @Nullable
  public LinearLayout.LayoutParams generateLayoutParams(@NotNull AttributeSet paramAttributeSet)
  {
    Intrinsics.checkParameterIsNotNull(paramAttributeSet, "attrs");
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return (LinearLayout.LayoutParams)new ConstraindWidthLayout.LayoutParams(localContext, paramAttributeSet);
  }
  
  @Nullable
  protected LinearLayout.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "lp");
    return (LinearLayout.LayoutParams)new ConstraindWidthLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject1 = (View)null;
    int i = getChildCount();
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      Object localObject2 = localView.getLayoutParams();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ui.ConstraindWidthLayout.LayoutParams");
      }
      ConstraindWidthLayout.LayoutParams localLayoutParams = (ConstraindWidthLayout.LayoutParams)localObject2;
      localObject2 = localObject1;
      if (localLayoutParams.a())
      {
        if (localObject1 != null) {
          throw ((Throwable)new IllegalStateException("count of constrained children must be less than 1"));
        }
        localObject2 = localView;
      }
      int j = localView.getMeasuredWidth();
      int k = localLayoutParams.leftMargin;
      int m = localLayoutParams.rightMargin;
      paramInt2 += 1;
      paramInt1 += m + (j + k);
      localObject1 = localObject2;
    }
    if ((paramInt1 > getMeasuredWidth()) && (localObject1 != null)) {
      ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (paramInt1 - ((View)localObject1).getMeasuredWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getMeasuredHeight(), 1073741824));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ConstraindWidthLayout
 * JD-Core Version:    0.7.0.1
 */