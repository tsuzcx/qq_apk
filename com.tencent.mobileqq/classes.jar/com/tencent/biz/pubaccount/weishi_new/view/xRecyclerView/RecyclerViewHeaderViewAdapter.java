package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHeaderViewAdapter<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final T a;
  private final List<View> b = new ArrayList();
  private final List<View> c = new ArrayList();
  private RecyclerViewHeaderViewAdapter.ContentDataObserver d;
  private RecyclerViewHeaderViewAdapter.OnBindHeaderObserver e;
  
  public RecyclerViewHeaderViewAdapter(T paramT)
  {
    this.a = paramT;
    this.a.registerAdapterDataObserver(new RecyclerViewHeaderViewAdapter.1(this));
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
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    RecyclerViewHeaderViewAdapter.OnBindHeaderObserver localOnBindHeaderObserver = this.e;
    if (localOnBindHeaderObserver != null) {
      localOnBindHeaderObserver.a(paramViewHolder, paramInt);
    }
  }
  
  public void a(RecyclerViewHeaderViewAdapter.OnBindHeaderObserver paramOnBindHeaderObserver)
  {
    this.e = paramOnBindHeaderObserver;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.b.size() - 1000);
  }
  
  public void b(@NonNull View paramView)
  {
    this.c.add(paramView);
  }
  
  public boolean b(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.c.size() - 2000);
  }
  
  public int getItemCount()
  {
    return this.b.size() + this.a.getItemCount() + this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return ((View)this.b.get(paramInt)).hashCode();
    }
    if (paramInt < this.b.size() + this.a.getItemCount()) {
      return this.a.getItemId(paramInt - this.b.size());
    }
    return ((View)this.c.get(paramInt - this.b.size() - this.a.getItemCount())).hashCode();
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
      a(paramViewHolder, paramInt);
      return;
    }
    if (paramInt < this.b.size() + this.a.getItemCount())
    {
      this.a.onBindViewHolder(paramViewHolder, paramInt - this.b.size());
      return;
    }
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
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramInt < this.b.size())
    {
      super.onBindViewHolder(paramViewHolder, paramInt, paramList);
      return;
    }
    if (paramInt < this.b.size() + this.a.getItemCount())
    {
      this.a.onBindViewHolder(paramViewHolder, paramInt - this.b.size(), paramList);
      return;
    }
    super.onBindViewHolder(paramViewHolder, paramInt, paramList);
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
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    RecyclerView.Adapter localAdapter = this.a;
    if ((localAdapter != null) && ((paramViewHolder instanceof BaseViewHolder))) {
      localAdapter.onViewAttachedToWindow(paramViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    RecyclerView.Adapter localAdapter = this.a;
    if ((localAdapter != null) && ((paramViewHolder instanceof BaseViewHolder))) {
      localAdapter.onViewDetachedFromWindow(paramViewHolder);
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    RecyclerView.Adapter localAdapter = this.a;
    if ((localAdapter != null) && ((paramViewHolder instanceof BaseViewHolder))) {
      localAdapter.onViewRecycled(paramViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.RecyclerViewHeaderViewAdapter
 * JD-Core Version:    0.7.0.1
 */