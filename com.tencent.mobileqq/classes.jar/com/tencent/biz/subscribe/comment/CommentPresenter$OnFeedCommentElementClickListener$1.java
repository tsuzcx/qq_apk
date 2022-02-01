package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$OnFeedCommentElementClickListener$1
  implements View.OnClickListener
{
  CommentPresenter$OnFeedCommentElementClickListener$1(CommentPresenter.OnFeedCommentElementClickListener paramOnFeedCommentElementClickListener, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)CommentPresenter.q(this.b.a).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      ClipData localClipData = ClipData.newPlainText("", this.a.content.get());
      ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
      CommentPresenter.r(this.b.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener.1
 * JD-Core Version:    0.7.0.1
 */