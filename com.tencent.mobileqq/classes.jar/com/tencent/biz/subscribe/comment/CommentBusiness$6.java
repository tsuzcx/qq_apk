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
    if ((paramStDoReplyRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null)) {
      paramStDoReplyRsp.reply.id.set(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.id.get());
    }
    StoryDispatcher.a().dispatch(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, Integer.valueOf(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.6
 * JD-Core Version:    0.7.0.1
 */