package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class WSRichTextParserImpl$2
  extends ClickableSpan
{
  WSRichTextParserImpl$2(WSRichTextParserImpl paramWSRichTextParserImpl, FeedRichTextView.OnElementClickListener paramOnElementClickListener, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView.b(this.b);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl.2
 * JD-Core Version:    0.7.0.1
 */