package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$OnFeedCommentElementClickListener$3
  implements View.OnClickListener
{
  CommentPresenter$OnFeedCommentElementClickListener$3(CommentPresenter.OnFeedCommentElementClickListener paramOnFeedCommentElementClickListener, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a, CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, null);
    CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener.3
 * JD-Core Version:    0.7.0.1
 */