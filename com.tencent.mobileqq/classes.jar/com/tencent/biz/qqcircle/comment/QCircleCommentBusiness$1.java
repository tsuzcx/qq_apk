package com.tencent.biz.qqcircle.comment;

import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

class QCircleCommentBusiness$1
  implements OnTaskListener<Object>
{
  QCircleCommentBusiness$1(QCircleCommentBusiness paramQCircleCommentBusiness, int paramInt, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      QCircleCommentBusiness.a(this.d, this.a, ((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetCommentListRsp)paramVarArgs[3], this.b, false, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.1
 * JD-Core Version:    0.7.0.1
 */