package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class CommentLinkItemView$1
  implements MiniAppLaunchListener
{
  CommentLinkItemView$1(CommentLinkItemView paramCommentLinkItemView) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("CommentLinkItemView", 2, "open mini app" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkItemView.1
 * JD-Core Version:    0.7.0.1
 */