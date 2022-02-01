package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.support.annotation.ColorInt;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;

public class ClickableColorSpan
  extends ClickableSpan
{
  private final int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  
  public ClickableColorSpan(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.ClickableColorSpan
 * JD-Core Version:    0.7.0.1
 */