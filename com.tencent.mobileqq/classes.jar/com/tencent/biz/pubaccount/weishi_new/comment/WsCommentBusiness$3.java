package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$3
  implements IWeishiServiceListener
{
  WsCommentBusiness$3(WsCommentBusiness paramWsCommentBusiness, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.m instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramWeishiTask.m;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      WsCommentBusiness.a(this.b, this.a, localstSimpleMetaComment);
      WSLog.c("WsCommentBusiness", "---CommentEvent, addFeedComment！");
      paramWeishiTask = this.b.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramWeishiTask.e), paramWeishiTask.c, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.b.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      WsCommentBusiness.a(this.b).a(this.a);
      return;
    }
    WSLog.d("WsCommentBusiness", "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.3
 * JD-Core Version:    0.7.0.1
 */