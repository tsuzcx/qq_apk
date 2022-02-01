package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/ConstraindWidthLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "width", "", "height", "weight", "", "(IIF)V", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/LinearLayout$LayoutParams;)V", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/ConstraindWidthLayout$LayoutParams;)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "constrainedWidth", "", "getConstrainedWidth", "()Z", "setConstrainedWidth", "(Z)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ConstraindWidthLayout$LayoutParams
  extends LinearLayout.LayoutParams
{
  private boolean a;
  
  public ConstraindWidthLayout$LayoutParams(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramInt2, paramFloat);
  }
  
  public ConstraindWidthLayout$LayoutParams(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ContrainWidthLayout_Layout);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.obtainStyledAttr…ntrainWidthLayout_Layout)");
    this.a = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  public ConstraindWidthLayout$LayoutParams(@NotNull ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public final boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ConstraindWidthLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */