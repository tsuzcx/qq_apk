package com.tencent.biz.subscribe.widget.span;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class UserNameSapn
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private UserNameSapn.OnUserNameClickListener jdField_a_of_type_ComTencentBizSubscribeWidgetSpanUserNameSapn$OnUserNameClickListener;
  private String jdField_a_of_type_JavaLangString;
  
  public UserNameSapn(String paramString, int paramInt, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSpanUserNameSapn$OnUserNameClickListener = paramOnUserNameClickListener;
  }
  
  public UserNameSapn(String paramString, ColorStateList paramColorStateList, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSpanUserNameSapn$OnUserNameClickListener = paramOnUserNameClickListener;
  }
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSpanUserNameSapn$OnUserNameClickListener != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSpanUserNameSapn$OnUserNameClickListener.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.jdField_a_of_type_Int > 0) {
      paramTextPaint.setColor(this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      paramTextPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.UserNameSapn
 * JD-Core Version:    0.7.0.1
 */