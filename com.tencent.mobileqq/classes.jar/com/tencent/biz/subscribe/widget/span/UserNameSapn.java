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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSpanUserNameSapn$OnUserNameClickListener;
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
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.UserNameSapn
 * JD-Core Version:    0.7.0.1
 */