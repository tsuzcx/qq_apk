package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$OnFeedCommentElementClickListener$4
  implements View.OnClickListener
{
  CommentPresenter$OnFeedCommentElementClickListener$4(CommentPresenter.OnFeedCommentElementClickListener paramOnFeedCommentElementClickListener, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)CommentPresenter.i(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.content.get()));
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener.4
 * JD-Core Version:    0.7.0.1
 */