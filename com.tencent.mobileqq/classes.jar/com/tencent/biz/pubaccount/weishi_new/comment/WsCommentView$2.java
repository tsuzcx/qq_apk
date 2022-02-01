package com.tencent.biz.pubaccount.weishi_new.comment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView.OnElementClickListener;

class WsCommentView$2
  implements FeedRichTextView.OnElementClickListener
{
  WsCommentView$2(WsCommentView paramWsCommentView) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    WSProfileFragment.a(this.a.getContext(), paramString, "at_nick");
    if (WsCommentView.d(this.a) == null) {
      return;
    }
    WSCommentBeaconReport.a("comment_at_user", WsCommentView.d(this.a).a(), WsCommentView.d(this.a).b(), paramString, WsCommentView.b(this.a), WsCommentView.d(this.a).c(), WsCommentView.d(this.a).d());
  }
  
  public void b(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView.2
 * JD-Core Version:    0.7.0.1
 */