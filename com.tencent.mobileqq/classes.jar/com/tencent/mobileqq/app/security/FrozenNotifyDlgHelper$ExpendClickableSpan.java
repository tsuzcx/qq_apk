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
  private String a;
  private WeakReference<QBaseActivity> b;
  private int c;
  
  public FrozenNotifyDlgHelper$ExpendClickableSpan(String paramString, WeakReference<QBaseActivity> paramWeakReference, int paramInt)
  {
    this.a = paramString;
    this.b = paramWeakReference;
    this.c = paramInt;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.b;
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
    if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.a))
    {
      int i = this.c;
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
    if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.a)) {
      FrozenNotifyDlgHelper.a().a(this.c);
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.contains("accounts.qq.com")) && (this.c == 1)) {
      ReportController.a(null, "dc00898", "", "", "0X800B428", "0X800B428", 0, 0, "", "", "", "");
    }
    FrozenNotifyDlgHelper.b().a(paramView, bool1, this.a);
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