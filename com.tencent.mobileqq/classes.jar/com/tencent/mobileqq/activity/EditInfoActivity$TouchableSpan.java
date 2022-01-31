package com.tencent.mobileqq.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class EditInfoActivity$TouchableSpan
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public EditInfoActivity$TouchableSpan(EditInfoActivity paramEditInfoActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.b;; i = this.jdField_a_of_type_Int)
    {
      paramTextPaint.setColor(i);
      paramTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.TouchableSpan
 * JD-Core Version:    0.7.0.1
 */