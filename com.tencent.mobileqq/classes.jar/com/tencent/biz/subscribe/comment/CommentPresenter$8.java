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
    CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, null);
    if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)
    {
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).b(null);
      if ((CommentPresenter.d(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)) && (CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)) {
        CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).setText(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a());
      }
      SubscribeCommentHelper.a().a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply, CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a());
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a("");
    }
    if ((CommentPresenter.e(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)) && (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != 0L))
    {
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, false);
      CommentPresenter.d(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, false);
    }
    if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null) {
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).j();
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter.b != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter.b.getVisibility() == 8)) {
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.8
 * JD-Core Version:    0.7.0.1
 */