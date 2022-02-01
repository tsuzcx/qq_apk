package com.tencent.biz.qqcircle.adapter;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QCircleMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleCommentReplyAdapter$ReplyItemViewHolder
  extends RecyclerView.ViewHolder
{
  private QCircleCommentReplyAdapter$ReplyItemViewHolder(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(QCircleReplyItemInfo paramQCircleReplyItemInfo, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt1, int paramInt2, OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    if ((this.itemView instanceof QCircleReplyItemView))
    {
      ((QCircleReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
      ((QCircleReplyItemView)this.itemView).setOnCommentElementClickListener(paramOnCommentElementClickListener);
      ((QCircleReplyItemView)this.itemView).a(paramQCircleReplyItemInfo, paramInt2);
      return;
    }
    if ((this.itemView instanceof QCircleMoreReplyItemView))
    {
      ((QCircleMoreReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
      ((QCircleMoreReplyItemView)this.itemView).setOnCommentElementClickListener(paramOnCommentElementClickListener);
      ((QCircleMoreReplyItemView)this.itemView).a(paramQCircleReplyItemInfo, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentReplyAdapter.ReplyItemViewHolder
 * JD-Core Version:    0.7.0.1
 */