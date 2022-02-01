package com.tencent.biz.pubaccount.weishi_new.view;

import android.view.View;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k=3, mv={1, 1, 16})
final class RecyclerViewHelper$isLoadMoreViewExposed$1
  extends Lambda
  implements Function1<View, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  RecyclerViewHelper$isLoadMoreViewExposed$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "it");
    return paramView instanceof XLoadMoreLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper.isLoadMoreViewExposed.1
 * JD-Core Version:    0.7.0.1
 */