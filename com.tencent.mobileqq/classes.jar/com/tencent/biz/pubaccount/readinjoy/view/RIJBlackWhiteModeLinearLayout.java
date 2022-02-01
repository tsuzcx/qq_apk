package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uad;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/RIJBlackWhiteModeLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dispatchDrawCanvas", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "drawCanvas", "mContext", "dispatchDraw", "canvas", "draw", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJBlackWhiteModeLinearLayout
  extends LinearLayout
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private final Function1<Canvas, Unit> b;
  
  @JvmOverloads
  public RIJBlackWhiteModeLinearLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public RIJBlackWhiteModeLinearLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public RIJBlackWhiteModeLinearLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)new RIJBlackWhiteModeLinearLayout.drawCanvas.1(this));
    this.b = ((Function1)new RIJBlackWhiteModeLinearLayout.dispatchDrawCanvas.1(this));
  }
  
  protected void dispatchDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    uad.a.a(paramCanvas, true, this.b);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    uad.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJBlackWhiteModeLinearLayout
 * JD-Core Version:    0.7.0.1
 */