package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleCommentPanelBlock$CommentItemHolder
  extends RecyclerView.ViewHolder
{
  private QCircleCommentPanelBlock$CommentItemHolder(QCircleCommentPanelBlock paramQCircleCommentPanelBlock, View paramView)
  {
    super(paramView);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, QCircleCommentItemInfo paramQCircleCommentItemInfo, OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    if ((this.itemView instanceof QCircleCommentItemView))
    {
      ((QCircleCommentItemView)this.itemView).setFeed(paramStFeed);
      ((QCircleCommentItemView)this.itemView).setOnCommentElementClickListener(paramOnCommentElementClickListener);
      ((QCircleCommentItemView)this.itemView).a(paramQCircleCommentItemInfo, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.CommentItemHolder
 * JD-Core Version:    0.7.0.1
 */