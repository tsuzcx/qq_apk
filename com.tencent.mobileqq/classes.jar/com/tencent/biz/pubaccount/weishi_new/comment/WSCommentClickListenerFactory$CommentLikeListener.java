package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

class WSCommentClickListenerFactory$CommentLikeListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$CommentLikeListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof stSimpleMetaComment))
    {
      paramObject = (stSimpleMetaComment)paramObject;
      this.a.h().a(this.a.n(), paramObject);
      this.a.a(true);
      int i;
      if (paramObject.isDing == 0) {
        i = 1001002;
      } else {
        i = 1001001;
      }
      a(i, 3, paramObject.id);
      paramObject = this.a.c();
      if ((paramObject instanceof WSFollowFragment))
      {
        paramInt -= 1;
        paramObject = ((WSFollowFragment)paramObject).y().getRecyclerView().findViewHolderForAdapterPosition(this.a.o());
        if ((paramObject instanceof WSFollowFeedHolder))
        {
          paramObject = (WSFollowFeedHolder)paramObject;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("***getPosition():");
          localStringBuilder.append(this.a.o());
          localStringBuilder.append(",realPosition:");
          localStringBuilder.append(paramInt);
          WSLog.c("comment", localStringBuilder.toString());
          paramObject.a(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.CommentLikeListener
 * JD-Core Version:    0.7.0.1
 */