package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.widget.XPanelContainer;

class HongBaoPanel$SpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  public HongBaoPanel$SpaceItemDecoration(HongBaoPanel paramHongBaoPanel)
  {
    if (XPanelContainer.a > 196.0F * paramHongBaoPanel.mContext.getResources().getDisplayMetrics().density) {}
    for (boolean bool = true;; bool = false)
    {
      paramHongBaoPanel.isSoftKeyBoardHeight = bool;
      return;
    }
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).getItemCount();
    if (this.this$0.isSoftKeyBoardHeight) {
      paramRect.top = this.this$0.itemTopMargin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.SpaceItemDecoration
 * JD-Core Version:    0.7.0.1
 */