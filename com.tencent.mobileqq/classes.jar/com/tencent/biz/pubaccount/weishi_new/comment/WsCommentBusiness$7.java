package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$7
  implements IWeishiServiceListener
{
  WsCommentBusiness$7(WsCommentBusiness paramWsCommentBusiness, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.m instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramWeishiTask.m;
      StringBuilder localStringBuilder;
      if (this.a.isDing == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("点赞成功,nothing is ");
        localStringBuilder.append(localstPostCommentDingRsp.nothing);
        WSLog.d("WsCommentBusiness", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("取消点赞成功,nothing is ");
        localStringBuilder.append(localstPostCommentDingRsp.nothing);
        WSLog.d("WsCommentBusiness", localStringBuilder.toString());
      }
      StoryDispatcher.a().dispatch(this.b.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramWeishiTask.e), paramWeishiTask.c, localstPostCommentDingRsp }));
      return;
    }
    WSLog.d("WsCommentBusiness", "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.7
 * JD-Core Version:    0.7.0.1
 */