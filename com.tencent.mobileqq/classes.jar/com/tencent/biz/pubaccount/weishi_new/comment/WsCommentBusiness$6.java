package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$6
  implements IWeishiServiceListener
{
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.m instanceof stDeleteFeedCommentRsp))
    {
      Object localObject = (stDeleteFeedCommentRsp)paramWeishiTask.m;
      localObject = this.c;
      int i = paramWeishiTask.e;
      paramWeishiTask = paramWeishiTask.c;
      String str = this.a.id;
      stSimpleMetaReply localstSimpleMetaReply = this.b;
      paramWeishiTask = ((WsCommentBusiness)localObject).a(new Object[] { Integer.valueOf(6), Integer.valueOf(i), paramWeishiTask, str, localstSimpleMetaReply, localstSimpleMetaReply.id, Integer.valueOf(this.c.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      return;
    }
    WSLog.d("WsCommentBusiness", "删除回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.6
 * JD-Core Version:    0.7.0.1
 */