package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$5
  implements IWeishiServiceListener
{
  WsCommentBusiness$5(WsCommentBusiness paramWsCommentBusiness, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.m instanceof stPostCommentReplyV2Rsp))
    {
      stPostCommentReplyV2Rsp localstPostCommentReplyV2Rsp = (stPostCommentReplyV2Rsp)paramWeishiTask.m;
      if ((localstPostCommentReplyV2Rsp.reply != null) && (localstPostCommentReplyV2Rsp.reply.poster != null)) {
        this.a.poster.id = localstPostCommentReplyV2Rsp.reply.poster.id;
      }
      WsCommentBusiness localWsCommentBusiness = this.b;
      int i = paramWeishiTask.e;
      paramWeishiTask = paramWeishiTask.c;
      stSimpleMetaReply localstSimpleMetaReply = this.a;
      paramWeishiTask = localWsCommentBusiness.a(new Object[] { Integer.valueOf(4), Integer.valueOf(i), paramWeishiTask, localstPostCommentReplyV2Rsp, localstSimpleMetaReply, localstSimpleMetaReply.id, Integer.valueOf(this.b.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      return;
    }
    WSLog.d("WsCommentBusiness", "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.5
 * JD-Core Version:    0.7.0.1
 */