package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class MsgTabStoryNodeView$HorizontalSpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  protected int a;
  protected int b;
  protected int c;
  
  public MsgTabStoryNodeView$HorizontalSpaceItemDecoration(Context paramContext)
  {
    this.a = AIOUtils.a(5.0F, paramContext.getResources());
    this.b = AIOUtils.a(0.5F, paramContext.getResources());
    this.c = AIOUtils.a(8.5F, paramContext.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramView = paramRecyclerView.getChildViewHolder(paramView);
    if (paramView.getItemViewType() == 2)
    {
      paramRect.right = this.b;
      return;
    }
    if (paramView.getPosition() == paramState.getItemCount() - 1)
    {
      paramRect.right = this.c;
      return;
    }
    paramRect.right = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.HorizontalSpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */