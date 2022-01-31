package com.tencent.biz.qqstory.common.recyclerview;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseViewHolder
  extends RecyclerView.ViewHolder
{
  private SparseArray a = new SparseArray();
  
  public BaseViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public BaseViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public View a(@IdRes int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.a.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public void a() {}
  
  public void a(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */