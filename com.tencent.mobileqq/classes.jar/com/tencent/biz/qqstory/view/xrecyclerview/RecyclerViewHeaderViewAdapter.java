package com.tencent.biz.qqstory.view.xrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHeaderViewAdapter<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final T a;
  private final List<View> b = new ArrayList();
  private final List<View> c = new ArrayList();
  private RecyclerViewHeaderViewAdapter.ContentDataObserver d;
  
  public RecyclerViewHeaderViewAdapter(T paramT)
  {
    this.a = paramT;
    this.a.registerAdapterDataObserver(new RecyclerViewHeaderViewAdapter.1(this));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.b.size() - 1000);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.c.size() - 2000);
  }
  
  public RecyclerViewHeaderViewAdapter a(RecyclerViewHeaderViewAdapter.ContentDataObserver paramContentDataObserver)
  {
    this.d = paramContentDataObserver;
    return this;
  }
  
  public void a(@NonNull View paramView)
  {
    this.b.add(paramView);
  }
  
  public void b(@NonNull View paramView)
  {
    this.c.add(paramView);
  }
  
  public int getItemCount()
  {
    return this.b.size() + this.a.getItemCount() + this.c.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return paramInt - 1000;
    }
    if (paramInt < this.b.size() + this.a.getItemCount()) {
      return this.a.getItemViewType(paramInt - this.b.size());
    }
    return paramInt - 2000 - this.b.size() - this.a.getItemCount();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = this.b.size();
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt < i)
    {
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
    }
    else if (paramInt < this.b.size() + this.a.getItemCount())
    {
      this.a.onBindViewHolder(paramViewHolder, paramInt - this.b.size());
    }
    else
    {
      localObject1 = localObject2;
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (a(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new RecyclerViewHeaderViewAdapter.2(this, (View)this.b.get(paramInt));
    }
    if (b(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new RecyclerViewHeaderViewAdapter.3(this, (View)this.c.get(paramInt));
    }
    return this.a.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewHeaderViewAdapter
 * JD-Core Version:    0.7.0.1
 */