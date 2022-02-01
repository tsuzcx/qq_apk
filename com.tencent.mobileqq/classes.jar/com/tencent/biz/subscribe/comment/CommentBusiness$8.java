package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tribe.async.dispatch.Dispatcher;

class CommentBusiness$8
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoLikeRsp>
{
  CommentBusiness$8(CommentBusiness paramCommentBusiness) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    StoryDispatcher.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Long.valueOf(paramLong), paramString, paramStDoLikeRsp }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.8
 * JD-Core Version:    0.7.0.1
 */