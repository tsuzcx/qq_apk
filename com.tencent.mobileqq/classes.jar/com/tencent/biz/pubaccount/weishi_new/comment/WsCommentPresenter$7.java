package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;

class WsCommentPresenter$7
  implements Runnable
{
  WsCommentPresenter$7(WsCommentPresenter paramWsCommentPresenter, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if (this.a == 8) {
      bool = true;
    } else {
      bool = false;
    }
    stSimpleMetaComment localstSimpleMetaComment = WSCommentRestoreManager.a().a(this.this$0.g());
    stSimpleMetaReply localstSimpleMetaReply = WSCommentRestoreManager.a().b(this.this$0.g());
    WsCommentPresenter.a(this.this$0, localstSimpleMetaComment, localstSimpleMetaReply, this.b, true, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.7
 * JD-Core Version:    0.7.0.1
 */