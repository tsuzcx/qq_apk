package com.tencent.biz.qqstory.storyHome.detail.model;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class SpannableStringUtils$1
  extends ClickableSpan
{
  SpannableStringUtils$1(SpannableStringUtils.ClickNickCallback paramClickNickCallback, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$ClickNickCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.1
 * JD-Core Version:    0.7.0.1
 */