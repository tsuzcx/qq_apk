package com.tencent.biz.qqstory.common.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class HeaderAndFooterAdapter<M, VH extends BaseViewHolder<M>>
  extends RecyclerView.Adapter<BaseViewHolder<M>>
{
  protected View a;
  protected View b;
  protected Context c;
  protected BaseAdapter.OnItemClickListener d;
  protected BaseAdapter.OnItemLongClickListener e;
  
  public HeaderAndFooterAdapter(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public final BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new BaseViewHolder(this.a);
    } else if (paramInt == 1025) {
      paramViewGroup = new BaseViewHolder(this.b);
    } else {
      paramViewGroup = b(paramViewGroup, paramInt);
    }
    if (this.d != null) {
      paramViewGroup.itemView.setOnClickListener(new HeaderAndFooterAdapter.1(this, paramViewGroup));
    }
    if (this.e != null) {
      paramViewGroup.itemView.setOnLongClickListener(new HeaderAndFooterAdapter.2(this, paramViewGroup));
    }
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the header view is null");
      return;
    }
    this.a = paramView;
    notifyDataSetChanged();
  }
  
  public void a(BaseAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.d = paramOnItemClickListener;
  }
  
  public void a(BaseAdapter.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.e = paramOnItemLongClickListener;
  }
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    int i = paramBaseViewHolder.getItemViewType();
    if ((i != 1024) && (i != 1025)) {
      b(paramBaseViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseViewHolder, paramInt, getItemId(paramInt));
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void b(VH paramVH, int paramInt);
  
  public int c()
  {
    int i;
    if (this.a != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (this.b != null) {
      j = i + 1;
    }
    return j;
  }
  
  public int d()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
  
  public abstract long getItemId(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter
 * JD-Core Version:    0.7.0.1
 */