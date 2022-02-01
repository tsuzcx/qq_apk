package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$4
  implements IWeishiServiceListener
{
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.m instanceof stDeleteFeedCommentRsp))
    {
      stDeleteFeedCommentRsp localstDeleteFeedCommentRsp = (stDeleteFeedCommentRsp)paramWeishiTask.m;
      paramWeishiTask = this.b.a(new Object[] { Integer.valueOf(5), Integer.valueOf(paramWeishiTask.e), paramWeishiTask.c, localstDeleteFeedCommentRsp, this.a.id, Integer.valueOf(this.b.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      return;
    }
    WSLog.d("WsCommentBusiness", "删除评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.4
 * JD-Core Version:    0.7.0.1
 */