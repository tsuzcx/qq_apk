package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;

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
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the footer view is null");
      return;
    }
    this.b = paramView;
    notifyDataSetChanged();
  }
  
  public void a(BaseAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.d = paramOnItemClickListener;
  }
  
  public abstract void a(VH paramVH, int paramInt);
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public final void b(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    int i = paramBaseViewHolder.getItemViewType();
    if ((i != 1024) && (i != 1025)) {
      a(paramBaseViewHolder, paramInt);
    }
  }
  
  public final BaseViewHolder c(ViewGroup paramViewGroup, int paramInt)
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
  
  public void d()
  {
    if (this.b != null)
    {
      this.b = null;
      notifyDataSetChanged();
    }
  }
  
  public int e()
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
  
  public int f()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.HeaderAndFooterAdapter
 * JD-Core Version:    0.7.0.1
 */