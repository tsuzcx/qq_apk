package com.tencent.mobileqq.activity.qwallet.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class QWalletTools$2
  extends ClickableSpan
{
  QWalletTools$2(QWalletTools.TextUrlClickListener paramTextUrlClickListener, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletUtilsQWalletTools$TextUrlClickListener.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.2
 * JD-Core Version:    0.7.0.1
 */