package com.tencent.biz.pubaccount.weishi_new.util;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class FeedTextParser$1
  extends ClickableSpan
{
  FeedTextParser$1(FeedRichTextView.OnElementClickListener paramOnElementClickListener, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView$OnElementClickListener;
    if (paramView != null) {
      paramView.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser.1
 * JD-Core Version:    0.7.0.1
 */