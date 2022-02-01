package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.utils.SubscribeCommentHelper;

class CommentPresenter$8
  implements SubscribeCommentInputPopupWindow.OnDismissListener
{
  CommentPresenter$8(CommentPresenter paramCommentPresenter, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    CommentPresenter.a(this.c, null);
    if (CommentPresenter.B(this.c) != null)
    {
      CommentPresenter.B(this.c).b(null);
      if ((CommentPresenter.O(this.c)) && (CommentPresenter.P(this.c) != null)) {
        CommentPresenter.P(this.c).setText(CommentPresenter.B(this.c).d());
      }
      SubscribeCommentHelper.a().a(CommentPresenter.k(this.c), this.a, this.b, CommentPresenter.B(this.c).d());
      CommentPresenter.B(this.c).a("");
    }
    if ((CommentPresenter.Q(this.c)) && (CommentPresenter.J(this.c) != 0L))
    {
      CommentPresenter.e(this.c, false);
      CommentPresenter.d(this.c, false);
    }
    if (CommentPresenter.N(this.c) != null) {
      CommentPresenter.N(this.c).q();
    }
    if ((this.c.h != null) && (this.c.h.getVisibility() == 8)) {
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */