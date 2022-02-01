package com.tencent.biz.pubaccount.weishi_new.util;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class FeedTextParser$2
  extends ClickableSpan
{
  FeedTextParser$2(FeedRichTextView.OnElementClickListener paramOnElementClickListener, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView$OnElementClickListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView$OnElementClickListener.b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser.2
 * JD-Core Version:    0.7.0.1
 */