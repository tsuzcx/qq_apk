package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.HashSet;
import java.util.Set;

public class MsgTabStoryNodeView$HorizontalSpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  static final Set<Integer> a;
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1024));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
  }
  
  public MsgTabStoryNodeView$HorizontalSpaceItemDecoration(Context paramContext)
  {
    this.jdField_a_of_type_Int = AIOUtils.a(5.0F, paramContext.getResources());
    this.b = AIOUtils.a(16.0F, paramContext.getResources());
    this.c = AIOUtils.a(8.5F, paramContext.getResources());
    this.d = AIOUtils.a(3.0F, paramContext.getResources());
    this.e = AIOUtils.a(3.0F, paramContext.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int k = paramRecyclerView.getChildViewHolder(paramView).getAdapterPosition();
    paramView = paramRecyclerView.getAdapter();
    if ((k < 0) || (k >= paramView.getItemCount())) {
      return;
    }
    int m = paramView.getItemViewType(k);
    if (paramView.getItemCount() > k + 1)
    {
      int n = paramView.getItemViewType(k + 1);
      int i = 0;
      if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(m))) {
        i = 1;
      }
      int j = i;
      if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(n))) {
        j = i + 1;
      }
      if (j == 1)
      {
        paramRect.right = this.d;
        return;
      }
      if (j == 2)
      {
        paramRect.right = this.e;
        return;
      }
    }
    if (m == 2)
    {
      paramRect.right = this.b;
      return;
    }
    if (k == paramState.getItemCount() - 1)
    {
      paramRect.right = this.c;
      return;
    }
    paramRect.right = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.HorizontalSpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */