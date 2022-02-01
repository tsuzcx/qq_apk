package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.SimpleCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/aeeditor/view/reorder/ReorderContainerView$initial$itemTouchCallback$1", "Lcom/tencent/widget/itemtouchhelper/ItemTouchHelper$SimpleCallback;", "interpolateOutOfBoundsScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewSize", "viewSizeOutOfBounds", "totalSize", "msSinceStartScroll", "", "isLongPressDragEnabled", "", "onMove", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "target", "onSelectedChanged", "", "actionState", "onSwiped", "direction", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView$initial$itemTouchCallback$1
  extends ItemTouchHelper.SimpleCallback
{
  ReorderContainerView$initial$itemTouchCallback$1(int paramInt1, int paramInt2)
  {
    super(paramInt2, i);
  }
  
  public int interpolateOutOfBoundsScroll(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return (int)Math.signum(paramInt2) * 5;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return false;
  }
  
  public boolean onMove(@Nullable RecyclerView paramRecyclerView, @Nullable RecyclerView.ViewHolder paramViewHolder1, @Nullable RecyclerView.ViewHolder paramViewHolder2)
  {
    int j = -1;
    int i;
    if (paramViewHolder1 != null) {
      i = paramViewHolder1.getAdapterPosition();
    } else {
      i = -1;
    }
    if (paramViewHolder2 != null) {
      j = paramViewHolder2.getAdapterPosition();
    }
    if ((j != 0) && (!(paramViewHolder2 instanceof ReorderContainerView.SpacingVH)))
    {
      if (j == ReorderContainerView.a(this.a).getItemCount() - 1) {
        return false;
      }
      paramRecyclerView = ReorderContainerView.a(this.a);
      int k = j - 1;
      paramRecyclerView.a(i - 1, k);
      ReorderContainerView.a(this.a).notifyItemMoved(i, j);
      ReorderContainerView.a(this.a, k);
      if (paramViewHolder1 != null)
      {
        paramRecyclerView = paramViewHolder1.itemView;
        if (paramRecyclerView != null) {
          paramRecyclerView.performHapticFeedback(0, 2);
        }
      }
      return true;
    }
    return false;
  }
  
  public void onSelectedChanged(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return;
      }
      ReorderContainerView.a(this.a, paramViewHolder);
      paramViewHolder = ReorderContainerView.c(this.a);
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.itemView;
        if (paramViewHolder != null) {
          paramViewHolder.setSelected(true);
        }
      }
      paramViewHolder = ReorderContainerView.c(this.a);
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.itemView;
        if (paramViewHolder != null) {
          paramViewHolder.performHapticFeedback(0, 2);
        }
      }
    }
    else
    {
      paramViewHolder = ReorderContainerView.c(this.a);
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.itemView;
        if (paramViewHolder != null) {
          paramViewHolder.setSelected(false);
        }
      }
      ReorderContainerView.a(this.a, (RecyclerView.ViewHolder)null);
      paramViewHolder = ReorderContainerView.d(this.a);
      if (paramViewHolder != null)
      {
        ReorderListener localReorderListener = this.a.getReorderListener();
        if (localReorderListener != null) {
          localReorderListener.a(paramViewHolder, ReorderContainerView.b(this.a));
        }
      }
      ReorderContainerView.a(this.a, (String)null);
      ReorderContainerView.a(this.a, -1);
    }
  }
  
  public void onSwiped(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView.initial.itemTouchCallback.1
 * JD-Core Version:    0.7.0.1
 */