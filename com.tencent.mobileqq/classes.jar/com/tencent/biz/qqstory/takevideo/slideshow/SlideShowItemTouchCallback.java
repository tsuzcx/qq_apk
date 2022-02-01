package com.tencent.biz.qqstory.takevideo.slideshow;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;

public class SlideShowItemTouchCallback
  extends ItemTouchHelper.Callback
{
  private ItemTouchHelperAction a;
  
  public SlideShowItemTouchCallback(ItemTouchHelperAction paramItemTouchHelperAction)
  {
    this.a = paramItemTouchHelperAction;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    if ((paramViewHolder instanceof SlideShowAdapter.SlideShowViewHolder))
    {
      ((SlideShowAdapter.SlideShowViewHolder)paramViewHolder).a = false;
      if ((paramRecyclerView.getScrollState() == 0) && (!paramRecyclerView.isComputingLayout())) {
        paramRecyclerView.getAdapter().notifyItemChanged(paramViewHolder.getAdapterPosition(), Integer.valueOf(0));
      }
    }
  }
  
  public float getMoveThreshold(RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.25F;
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).getOrientation() == 0)) {
      i = 15;
    } else {
      i = 0;
    }
    return makeMovementFlags(i, 0);
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return false;
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    paramRecyclerView = this.a;
    if (paramRecyclerView != null) {
      paramRecyclerView.a(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
    }
    return false;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    if ((paramInt == 2) && ((paramViewHolder instanceof SlideShowAdapter.SlideShowViewHolder)))
    {
      paramViewHolder = (SlideShowAdapter.SlideShowViewHolder)paramViewHolder;
      paramViewHolder.a = true;
      ItemTouchHelperAction localItemTouchHelperAction = this.a;
      if ((localItemTouchHelperAction instanceof SlideShowAdapter)) {
        ((SlideShowAdapter)localItemTouchHelperAction).notifyItemChanged(paramViewHolder.getAdapterPosition(), Integer.valueOf(0));
      }
    }
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowItemTouchCallback
 * JD-Core Version:    0.7.0.1
 */