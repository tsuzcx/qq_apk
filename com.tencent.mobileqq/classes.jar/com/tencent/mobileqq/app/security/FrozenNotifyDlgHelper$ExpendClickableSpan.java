package com.tencent.mobileqq.app.security;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class FrozenNotifyDlgHelper$ExpendClickableSpan
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QBaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  
  public FrozenNotifyDlgHelper$ExpendClickableSpan(String paramString, WeakReference<QBaseActivity> paramWeakReference, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_MqqUtilWeakReference;
    if (paramView == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: mActivity == null");
      return;
    }
    paramView = (QBaseActivity)paramView.get();
    if (paramView == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: context == null");
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.jdField_a_of_type_JavaLangString))
    {
      int i = this.jdField_a_of_type_Int;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.jdField_a_of_type_JavaLangString)) {
      FrozenNotifyDlgHelper.a().a(this.jdField_a_of_type_Int);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("accounts.qq.com")) && (this.jdField_a_of_type_Int == 1)) {
      ReportController.a(null, "dc00898", "", "", "0X800B428", "0X800B428", 0, 0, "", "", "", "");
    }
    FrozenNotifyDlgHelper.a().a(paramView, bool1, this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper.ExpendClickableSpan
 * JD-Core Version:    0.7.0.1
 */