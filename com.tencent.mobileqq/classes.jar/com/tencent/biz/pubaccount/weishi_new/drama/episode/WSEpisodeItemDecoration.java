package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;

public class WSEpisodeItemDecoration
  extends RecyclerView.ItemDecoration
{
  public static final int a = WSFeedUtils.a(12.0F);
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0) {
      paramRect.left = a;
    }
    paramRect.right = a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemDecoration
 * JD-Core Version:    0.7.0.1
 */