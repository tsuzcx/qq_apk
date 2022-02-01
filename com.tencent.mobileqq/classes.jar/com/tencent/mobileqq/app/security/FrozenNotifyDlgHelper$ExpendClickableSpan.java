package com.tencent.mobileqq.app.security;

import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class FrozenNotifyDlgHelper$ExpendClickableSpan
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  
  public FrozenNotifyDlgHelper$ExpendClickableSpan(String paramString, WeakReference<BaseActivity> paramWeakReference, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: mActivity == null");
      return;
    }
    paramView = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramView == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: context == null");
      return;
    }
    if (("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4))) {}
    for (int i = 1;; i = 0)
    {
      if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.jdField_a_of_type_JavaLangString)) {
        FrozenNotifyDlgHelper.a().a(this.jdField_a_of_type_Int);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("accounts.qq.com")) && (this.jdField_a_of_type_Int == 1)) {
        ReportController.a(null, "dc00898", "", "", "0X800B428", "0X800B428", 0, 0, "", "", "", "");
      }
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      paramView.startActivity(localIntent);
      if ((i != 0) && ((paramView instanceof NotificationActivity)) && (!paramView.isFinishing()))
      {
        ((NotificationActivity)paramView).enableJumpLoginFromFund();
        return;
      }
      paramView.finish();
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper.ExpendClickableSpan
 * JD-Core Version:    0.7.0.1
 */