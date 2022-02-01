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
  protected Context a;
  protected View a;
  protected BaseAdapter.OnItemClickListener a;
  protected BaseAdapter.OnItemLongClickListener a;
  protected View b;
  
  public HeaderAndFooterAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    int i;
    if (this.jdField_a_of_type_AndroidViewView != null) {
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
  
  public final BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new BaseViewHolder(this.jdField_a_of_type_AndroidViewView);
    } else if (paramInt == 1025) {
      paramViewGroup = new BaseViewHolder(this.b);
    } else {
      paramViewGroup = b(paramViewGroup, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseAdapter$OnItemClickListener != null) {
      paramViewGroup.itemView.setOnClickListener(new HeaderAndFooterAdapter.1(this, paramViewGroup));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseAdapter$OnItemLongClickListener != null) {
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
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyDataSetChanged();
  }
  
  public void a(BaseAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(BaseAdapter.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseAdapter$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    int i = paramBaseViewHolder.getItemViewType();
    if ((i != 1024) && (i != 1025)) {
      b(paramBaseViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    return 1;
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void b(VH paramVH, int paramInt);
  
  public abstract long getItemId(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter
 * JD-Core Version:    0.7.0.1
 */