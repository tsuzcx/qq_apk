package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.loginregister.LoginUtils;

class RegisterVerifyCodeActivity$5$1
  extends ClickableSpan
{
  RegisterVerifyCodeActivity$5$1(RegisterVerifyCodeActivity.5 param5, String paramString) {}
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(this.jdField_a_of_type_JavaLangString));
    if (TextUtils.isEmpty(RegisterVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity$5.this$0))) {}
    while (!RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity$5.this$0)) {
      return;
    }
    RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity$5.this$0, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity$5.this$0.handler.postDelayed(new RegisterVerifyCodeActivity.5.1.1(this), 1000L);
    paramView = new Intent();
    paramView.putExtra("url", RegisterVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity$5.this$0));
    paramView.putExtra("hide_more_button", true);
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity$5.this$0, paramView, "/base/browser");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16734752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.5.1
 * JD-Core Version:    0.7.0.1
 */