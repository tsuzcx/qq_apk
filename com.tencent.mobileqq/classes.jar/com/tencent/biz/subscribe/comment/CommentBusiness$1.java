package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;

class CommentBusiness$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedDetailRsp>
{
  CommentBusiness$1(CommentBusiness paramCommentBusiness, COMM.StCommonExt paramStCommonExt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    CommentBusiness.a(this.b, paramBoolean, paramLong, paramString, paramStGetFeedDetailRsp, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.1
 * JD-Core Version:    0.7.0.1
 */