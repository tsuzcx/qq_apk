package com.tencent.biz.pubaccount.weishi_new.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/RecyclerViewHelper;", "", "()V", "TAG", "", "sGlobalRect", "Landroid/graphics/Rect;", "getSGlobalRect", "()Landroid/graphics/Rect;", "sGlobalRect$delegate", "Lkotlin/Lazy;", "isLoadMoreViewExposed", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isFooterView", "Lkotlin/Function1;", "Landroid/view/View;", "isLoadMoreViewExposedVertical", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class RecyclerViewHelper
{
  public static final RecyclerViewHelper a = new RecyclerViewHelper();
  private static final Lazy b = LazyKt.lazy((Function0)RecyclerViewHelper.sGlobalRect.2.INSTANCE);
  
  private final Rect a()
  {
    return (Rect)b.getValue();
  }
  
  @JvmStatic
  public static final boolean a(@Nullable RecyclerView paramRecyclerView)
  {
    return a(paramRecyclerView, (Function1)RecyclerViewHelper.isLoadMoreViewExposed.1.INSTANCE);
  }
  
  @JvmStatic
  public static final boolean a(@Nullable RecyclerView paramRecyclerView, @NotNull Function1<? super View, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "isFooterView");
    boolean bool2 = false;
    if (paramRecyclerView == null) {
      return false;
    }
    paramRecyclerView = paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1);
    boolean bool1 = bool2;
    if (paramRecyclerView != null)
    {
      bool1 = bool2;
      if (((Boolean)paramFunction1.invoke(paramRecyclerView)).booleanValue()) {
        bool1 = paramRecyclerView.getGlobalVisibleRect(a.a());
      }
    }
    return bool1;
  }
  
  @JvmStatic
  public static final boolean b(@Nullable RecyclerView paramRecyclerView)
  {
    return a(paramRecyclerView, (Function1)RecyclerViewHelper.isLoadMoreViewExposedVertical.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper
 * JD-Core Version:    0.7.0.1
 */