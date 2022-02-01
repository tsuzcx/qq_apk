package com.tencent.biz.pubaccount.weishi_new.comment;

import android.text.TextPaint;
import android.text.style.StyleSpan;

class WSCommentInputPresenter$1
  extends StyleSpan
{
  WSCommentInputPresenter$1(WSCommentInputPresenter paramWSCommentInputPresenter, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(WSCommentInputPresenter.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentInputPresenter.1
 * JD-Core Version:    0.7.0.1
 */