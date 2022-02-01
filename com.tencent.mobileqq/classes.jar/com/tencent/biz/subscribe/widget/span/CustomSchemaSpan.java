package com.tencent.biz.subscribe.widget.span;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class CustomSchemaSpan
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private CustomSchemaSpan.OnCustomSchemaClickListener jdField_a_of_type_ComTencentBizSubscribeWidgetSpanCustomSchemaSpan$OnCustomSchemaClickListener;
  private String jdField_a_of_type_JavaLangString;
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSpanCustomSchemaSpan$OnCustomSchemaClickListener;
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    int i = this.jdField_a_of_type_Int;
    if (i > 0) {
      paramTextPaint.setColor(i);
    }
    ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    if (localColorStateList != null) {
      paramTextPaint.setColor(localColorStateList.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.CustomSchemaSpan
 * JD-Core Version:    0.7.0.1
 */