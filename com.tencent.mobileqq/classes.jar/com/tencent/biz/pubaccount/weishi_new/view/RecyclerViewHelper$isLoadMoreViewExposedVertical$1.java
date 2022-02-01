package com.tencent.biz.pubaccount.weishi_new.view;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k=3, mv={1, 1, 16})
final class RecyclerViewHelper$isLoadMoreViewExposedVertical$1
  extends Lambda
  implements Function1<View, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  RecyclerViewHelper$isLoadMoreViewExposedVertical$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "it");
    return paramView instanceof TextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper.isLoadMoreViewExposedVertical.1
 * JD-Core Version:    0.7.0.1
 */