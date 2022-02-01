package com.tencent.biz.subscribe.part.block.base;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseListViewAdapter<E>
  extends RecyclerView.Adapter
{
  private Handler a;
  protected ArrayList<E> j = new ArrayList();
  
  public Handler M()
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper());
    }
    return this.a;
  }
  
  public ArrayList<E> N()
  {
    return this.j;
  }
  
  public void a(E paramE, int paramInt)
  {
    if (paramE != null)
    {
      if (paramInt >= this.j.size()) {
        return;
      }
      this.j.set(paramInt, paramE);
    }
  }
  
  public void b()
  {
    this.j.clear();
  }
  
  public void b(ArrayList<E> paramArrayList)
  {
    this.j.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    this.j.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void b(List<E> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.j.addAll(paramList);
    notifyItemRangeInserted(this.j.size(), paramList.size());
  }
  
  public int getItemCount()
  {
    return this.j.size();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    M().removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter
 * JD-Core Version:    0.7.0.1
 */