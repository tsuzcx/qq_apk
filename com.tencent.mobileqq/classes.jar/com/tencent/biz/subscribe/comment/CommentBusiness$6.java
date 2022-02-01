package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class CommentBusiness$6
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoReplyRsp>
{
  CommentBusiness$6(CommentBusiness paramCommentBusiness, CertifiedAccountMeta.StReply paramStReply, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((paramStDoReplyRsp != null) && (this.a != null)) {
      paramStDoReplyRsp.reply.id.set(this.a.id.get());
    }
    StoryDispatcher.a().dispatch(this.c.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.b, Integer.valueOf(this.c.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.6
 * JD-Core Version:    0.7.0.1
 */