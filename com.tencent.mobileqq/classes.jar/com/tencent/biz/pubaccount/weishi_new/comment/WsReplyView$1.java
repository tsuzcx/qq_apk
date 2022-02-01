package com.tencent.biz.pubaccount.weishi_new.comment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView.OnElementClickListener;

class WsReplyView$1
  implements FeedRichTextView.OnElementClickListener
{
  WsReplyView$1(WsReplyView paramWsReplyView) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    WSProfileFragment.a(this.a.getContext(), paramString, "at_nick");
    if (WsReplyView.a(this.a) == null) {
      return;
    }
    WSCommentBeaconReport.a("comment_at_user", WsReplyView.a(this.a).a(), WsReplyView.a(this.a).b(), paramString, WsReplyView.b(this.a), WsReplyView.a(this.a).c(), WsReplyView.a(this.a).d());
  }
  
  public void b(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyView.1
 * JD-Core Version:    0.7.0.1
 */