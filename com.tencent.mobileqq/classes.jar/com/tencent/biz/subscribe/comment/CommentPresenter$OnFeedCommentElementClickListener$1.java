package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$OnFeedCommentElementClickListener$1
  implements View.OnClickListener
{
  CommentPresenter$OnFeedCommentElementClickListener$1(CommentPresenter.OnFeedCommentElementClickListener paramOnFeedCommentElementClickListener, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)CommentPresenter.c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.content.get()));
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener.1
 * JD-Core Version:    0.7.0.1
 */