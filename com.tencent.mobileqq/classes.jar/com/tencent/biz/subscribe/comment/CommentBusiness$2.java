package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;

class CommentBusiness$2
  implements OnTaskListener<Object>
{
  CommentBusiness$2(CommentBusiness paramCommentBusiness, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      this.a.onReceive(null, ((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (CertifiedAccountRead.StGetFeedDetailRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.2
 * JD-Core Version:    0.7.0.1
 */