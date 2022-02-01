package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class RecyclerViewHeaderViewAdapter$1
  extends RecyclerView.AdapterDataObserver
{
  RecyclerViewHeaderViewAdapter$1(RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.b(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.a;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeChanged(paramInt1 + RecyclerViewHeaderViewAdapter.c(localRecyclerViewHeaderViewAdapter).size(), paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.b(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.a;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeChanged(paramInt1 + RecyclerViewHeaderViewAdapter.c(localRecyclerViewHeaderViewAdapter).size(), paramInt2, paramObject);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.b(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.a;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeInserted(paramInt1 + RecyclerViewHeaderViewAdapter.c(localRecyclerViewHeaderViewAdapter).size(), paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.b(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.a;
    localRecyclerViewHeaderViewAdapter.notifyItemMoved(paramInt1 + RecyclerViewHeaderViewAdapter.c(localRecyclerViewHeaderViewAdapter).size(), paramInt2 + RecyclerViewHeaderViewAdapter.c(this.a).size());
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.b(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = this.a;
    localRecyclerViewHeaderViewAdapter.notifyItemRangeRemoved(paramInt1 + RecyclerViewHeaderViewAdapter.c(localRecyclerViewHeaderViewAdapter).size(), paramInt2);
    if (RecyclerViewHeaderViewAdapter.a(this.a) != null) {
      RecyclerViewHeaderViewAdapter.a(this.a).a(RecyclerViewHeaderViewAdapter.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.RecyclerViewHeaderViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */