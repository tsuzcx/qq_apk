package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class BaseViewHolder<M>
  extends RecyclerView.ViewHolder
{
  private SparseArray<View> a = new SparseArray();
  
  public BaseViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public BaseViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public void a(M paramM) {}
  
  protected Context b()
  {
    return this.itemView.getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */