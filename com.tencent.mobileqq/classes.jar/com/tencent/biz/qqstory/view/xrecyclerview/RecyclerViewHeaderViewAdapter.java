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
  private final T jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private RecyclerViewHeaderViewAdapter.ContentDataObserver jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewHeaderViewAdapter$ContentDataObserver;
  private final List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final List<View> b = new ArrayList();
  
  public RecyclerViewHeaderViewAdapter(T paramT)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramT;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(new RecyclerViewHeaderViewAdapter.1(this));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.jdField_a_of_type_JavaUtilList.size() - 1000);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.b.size() - 2000);
  }
  
  public RecyclerViewHeaderViewAdapter a(RecyclerViewHeaderViewAdapter.ContentDataObserver paramContentDataObserver)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewHeaderViewAdapter$ContentDataObserver = paramContentDataObserver;
    return this;
  }
  
  public void a(@NonNull View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramView);
  }
  
  public void b(@NonNull View paramView)
  {
    this.b.add(paramView);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return paramInt - 1000;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemViewType(paramInt - this.jdField_a_of_type_JavaUtilList.size());
    }
    return paramInt - 2000 - this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
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
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - this.jdField_a_of_type_JavaUtilList.size());
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
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (a(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new RecyclerViewHeaderViewAdapter.2(this, (View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    if (b(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new RecyclerViewHeaderViewAdapter.3(this, (View)this.b.get(paramInt));
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewHeaderViewAdapter
 * JD-Core Version:    0.7.0.1
 */