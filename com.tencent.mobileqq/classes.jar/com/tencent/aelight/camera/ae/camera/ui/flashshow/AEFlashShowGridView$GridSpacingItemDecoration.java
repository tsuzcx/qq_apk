package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowGridView$GridSpacingItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "spanCount", "", "hSpacing", "vSpacing", "includeEdge", "", "(Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowGridView;IIIZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowGridView$GridSpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final int b;
  private final int c;
  private final int d;
  private final boolean e;
  
  public AEFlashShowGridView$GridSpacingItemDecoration(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramBoolean;
    boolean bool;
    this.e = bool;
  }
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "outRect");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = this.b;
    int k = i % j;
    if (this.e)
    {
      m = this.c;
      paramRect.left = (m - k * m / j);
      paramRect.right = ((k + 1) * m / j);
      if (i < j) {
        paramRect.top = this.d;
      }
      paramRect.bottom = this.d;
      return;
    }
    int m = this.c;
    paramRect.left = (k * m / j);
    paramRect.right = (m - (k + 1) * m / j);
    if (i >= j) {
      paramRect.top = this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowGridView.GridSpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */