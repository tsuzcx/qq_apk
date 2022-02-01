package com.tencent.biz.pubaccount.readinjoy.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;

class RecyclerViewWithHeaderFooterFix$1
  extends RecyclerViewHeaderViewAdapter<RecyclerView.Adapter>
{
  RecyclerViewWithHeaderFooterFix$1(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix, RecyclerView.Adapter paramAdapter)
  {
    super(paramAdapter);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    this.a.a(paramViewHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix.1
 * JD-Core Version:    0.7.0.1
 */