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
  
  public float a(RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.25F;
  }
  
  public int a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).getOrientation() == 0)) {}
    for (int i = 15;; i = 0) {
      return b(i, 0);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.a(paramRecyclerView, paramViewHolder);
    if ((paramViewHolder instanceof SlideShowPhotoListManager.SlideShowViewHolder))
    {
      ((SlideShowPhotoListManager.SlideShowViewHolder)paramViewHolder).a = false;
      paramRecyclerView.getAdapter().notifyItemChanged(paramViewHolder.getAdapterPosition(), Integer.valueOf(0));
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.a != null) {
      this.a.a(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
    }
    return false;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    if ((paramInt == 2) && ((paramViewHolder instanceof SlideShowPhotoListManager.SlideShowViewHolder)))
    {
      paramViewHolder = (SlideShowPhotoListManager.SlideShowViewHolder)paramViewHolder;
      paramViewHolder.a = true;
      if ((this.a instanceof SlideShowPhotoListManager.SlideShowAdapter)) {
        ((SlideShowPhotoListManager.SlideShowAdapter)this.a).notifyItemChanged(paramViewHolder.getAdapterPosition(), Integer.valueOf(0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowItemTouchCallback
 * JD-Core Version:    0.7.0.1
 */