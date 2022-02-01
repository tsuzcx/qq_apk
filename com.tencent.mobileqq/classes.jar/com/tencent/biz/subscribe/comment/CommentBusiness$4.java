package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class CommentBusiness$4
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoCommentRsp>
{
  CommentBusiness$4(CommentBusiness paramCommentBusiness, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((paramStDoCommentRsp != null) && (this.a != null)) {
      paramStDoCommentRsp.comment.id.set(this.a.id.get());
    }
    StoryDispatcher.a().dispatch(this.b.a(new Object[] { Integer.valueOf(5), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, Integer.valueOf(this.b.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.4
 * JD-Core Version:    0.7.0.1
 */