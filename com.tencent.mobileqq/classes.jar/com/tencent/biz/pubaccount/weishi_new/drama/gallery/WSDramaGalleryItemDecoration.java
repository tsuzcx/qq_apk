package com.tencent.biz.pubaccount.weishi_new.drama.gallery;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;

public class WSDramaGalleryItemDecoration
  extends RecyclerView.ItemDecoration
{
  public static final int a = WSFeedUtils.a(12.0F);
  public static final int b = WSFeedUtils.a(4.0F);
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if (i == 0) {
      paramRect.left = a;
    }
    if (i == paramRecyclerView.getAdapter().getItemCount() - 1)
    {
      paramRect.right = a;
      return;
    }
    paramRect.right = b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryItemDecoration
 * JD-Core Version:    0.7.0.1
 */