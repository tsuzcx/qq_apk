package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

class WSCommentRichParserImpl$1
  extends ClickableSpan
{
  WSCommentRichParserImpl$1(WSCommentRichParserImpl paramWSCommentRichParserImpl, FeedRichTextView.OnElementClickListener paramOnElementClickListener, WSRichTextParserImpl.WSUser paramWSUser, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    if ((this.a != null) && (TextUtils.equals(this.b.c, "1"))) {
      this.a.a(this.c);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.WSCommentRichParserImpl.1
 * JD-Core Version:    0.7.0.1
 */