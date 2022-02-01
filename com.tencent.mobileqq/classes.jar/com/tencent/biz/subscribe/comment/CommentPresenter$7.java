package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.utils.SubscribeCommentHelper;

class CommentPresenter$7
  implements DialogInterface.OnShowListener
{
  CommentPresenter$7(CommentPresenter paramCommentPresenter, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (CommentPresenter.N(this.c) != null) {
      CommentPresenter.N(this.c).a(paramDialogInterface);
    }
    paramDialogInterface = SubscribeCommentHelper.a().a(CommentPresenter.k(this.c), this.a, this.b);
    CommentPresenter.B(this.c).a(paramDialogInterface);
    SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.7
 * JD-Core Version:    0.7.0.1
 */