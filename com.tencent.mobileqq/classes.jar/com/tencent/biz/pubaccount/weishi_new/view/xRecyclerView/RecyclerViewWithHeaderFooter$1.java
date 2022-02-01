package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

class RecyclerViewWithHeaderFooter$1
  extends RecyclerView.RecycledViewPool
{
  RecyclerViewWithHeaderFooter$1(RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.a.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof RecyclerViewHeaderViewAdapter)))
    {
      localObject = (RecyclerViewHeaderViewAdapter)localObject;
      if (((RecyclerViewHeaderViewAdapter)localObject).b(paramInt))
      {
        if (!RecyclerViewWithHeaderFooter.a(this.a).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((RecyclerViewHeaderViewAdapter)localObject).a(paramInt)) && (!RecyclerViewWithHeaderFooter.b(this.a).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.RecyclerViewWithHeaderFooter.1
 * JD-Core Version:    0.7.0.1
 */