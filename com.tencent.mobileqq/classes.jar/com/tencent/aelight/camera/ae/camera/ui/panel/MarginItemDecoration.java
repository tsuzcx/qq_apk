package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/MarginItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "spaceSize", "", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
final class MarginItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final int a;
  
  public MarginItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "outRect");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    if (paramRecyclerView.getChildAdapterPosition(paramView) > 0) {
      paramRect.left = this.a;
    }
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.MarginItemDecoration
 * JD-Core Version:    0.7.0.1
 */