package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils.DynamicUnitUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class MsgTabStoryNodeView$HorizontalSpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  protected int a;
  protected int b;
  protected int c;
  final int d = DynamicUnitUtils.a(0.0F);
  final int e = DynamicUnitUtils.a(1.0F);
  
  public MsgTabStoryNodeView$HorizontalSpaceItemDecoration(Context paramContext)
  {
    this.a = AIOUtils.a(3.0F, paramContext.getResources());
    this.b = AIOUtils.a(16.0F, paramContext.getResources());
    this.c = AIOUtils.a(8.5F, paramContext.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramView = paramRecyclerView.getChildViewHolder(paramView);
    int i = paramView.getAdapterPosition();
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((i < 0) || (i >= paramRecyclerView.getItemCount())) {
      return;
    }
    int j = paramRecyclerView.getItemViewType(i);
    if ((paramRecyclerView.getItemCount() > i + 1) && ((j == 1024) || (j == 3)))
    {
      j = paramRecyclerView.getItemViewType(i + 1);
      if ((j != 1024) && (j != 3))
      {
        paramRect.right = this.d;
        SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView.VASH", "getItemOffsets(%d) use different margin %d", Integer.valueOf(i), Integer.valueOf(paramRect.right));
        return;
      }
      if ((j == 1024) || (j == 3))
      {
        paramRect.right = this.e;
        SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView.VASH", "getItemOffsets(%d) use different margin %d", Integer.valueOf(i), Integer.valueOf(paramRect.right));
        return;
      }
    }
    if (paramView.getItemViewType() == 2)
    {
      paramRect.right = this.b;
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView.VASH", "getItemOffsets(%d) use mMarginMsg %d", Integer.valueOf(i), Integer.valueOf(paramRect.right));
      return;
    }
    if (i == paramState.getItemCount() - 1)
    {
      paramRect.right = this.c;
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView.VASH", "getItemOffsets(%d) use mMarginEnd %d", Integer.valueOf(i), Integer.valueOf(paramRect.right));
      return;
    }
    paramRect.right = this.a;
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView.VASH", "getItemOffsets(%d) use mMarginDefault %d", Integer.valueOf(i), Integer.valueOf(paramRect.right));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.HorizontalSpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */