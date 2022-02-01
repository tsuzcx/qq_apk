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
  static final Set<Integer> f = new HashSet();
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  
  static
  {
    f.add(Integer.valueOf(1024));
    f.add(Integer.valueOf(12));
    f.add(Integer.valueOf(3));
  }
  
  public MsgTabStoryNodeView$HorizontalSpaceItemDecoration(Context paramContext)
  {
    this.a = AIOUtils.b(5.0F, paramContext.getResources());
    this.b = AIOUtils.b(16.0F, paramContext.getResources());
    this.c = AIOUtils.b(8.5F, paramContext.getResources());
    this.d = AIOUtils.b(3.0F, paramContext.getResources());
    this.e = AIOUtils.b(3.0F, paramContext.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int k = paramRecyclerView.getChildViewHolder(paramView).getAdapterPosition();
    paramView = paramRecyclerView.getAdapter();
    if (k >= 0)
    {
      if (k >= paramView.getItemCount()) {
        return;
      }
      int m = paramView.getItemViewType(k);
      int i = paramView.getItemCount();
      int j = k + 1;
      if (i > j)
      {
        int n = paramView.getItemViewType(j);
        i = 0;
        if (f.contains(Integer.valueOf(m))) {
          i = 1;
        }
        j = i;
        if (f.contains(Integer.valueOf(n))) {
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
      paramRect.right = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.HorizontalSpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */