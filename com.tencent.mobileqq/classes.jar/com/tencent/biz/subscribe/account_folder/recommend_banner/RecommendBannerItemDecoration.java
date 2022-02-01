package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class RecommendBannerItemDecoration
  extends RecyclerView.ItemDecoration
{
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == 0)
    {
      paramRect.left = DisplayUtil.a(paramView.getContext(), 3.0F);
      paramRect.right = 0;
      return;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1)) {
      paramRect.right = DisplayUtil.a(paramView.getContext(), 3.0F);
    } else {
      paramRect.right = 0;
    }
    paramRect.left = (-DisplayUtil.a(paramView.getContext(), 6.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemDecoration
 * JD-Core Version:    0.7.0.1
 */