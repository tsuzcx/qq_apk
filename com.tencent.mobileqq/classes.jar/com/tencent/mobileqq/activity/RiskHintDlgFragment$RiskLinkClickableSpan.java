package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class RiskHintDlgFragment$RiskLinkClickableSpan
  extends ClickableSpan
{
  private final String a;
  private final QQCustomDialog b;
  private final WeakReference<QBaseActivity> c;
  
  public RiskHintDlgFragment$RiskLinkClickableSpan(String paramString, QQCustomDialog paramQQCustomDialog, WeakReference<QBaseActivity> paramWeakReference)
  {
    this.a = paramString;
    this.b = paramQQCustomDialog;
    this.c = paramWeakReference;
  }
  
  public void onClick(View paramView)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.a)))
    {
      paramView = this.c;
      if (paramView != null)
      {
        paramView = (QBaseActivity)paramView.get();
        if (paramView == null)
        {
          QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan error: activity == null");
          return;
        }
        ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).cancelVerifyRiskDialog(paramView.getAppRuntime().getCurrentAccountUin());
        if (this.a.contains("1108149324")) {
          ReportController.b(paramView.getAppRuntime(), "dc00898", "", "", "0X800B259", "0X800B259", 0, 0, "", "", "", "");
        }
        QLog.d("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: startMiniApp");
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramView, this.a, 4010, null);
        this.b.dismiss();
        return;
      }
    }
    QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: params invalid");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment.RiskLinkClickableSpan
 * JD-Core Version:    0.7.0.1
 */