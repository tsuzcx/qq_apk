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
  private final QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<QBaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public RiskHintDlgFragment$RiskLinkClickableSpan(String paramString, QQCustomDialog paramQQCustomDialog, WeakReference<QBaseActivity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = paramQQCustomDialog;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramView = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramView != null)
      {
        paramView = (QBaseActivity)paramView.get();
        if (paramView == null)
        {
          QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan error: activity == null");
          return;
        }
        ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).cancelVerifyRiskDialog(paramView.getAppRuntime().getCurrentAccountUin());
        if (this.jdField_a_of_type_JavaLangString.contains("1108149324")) {
          ReportController.b(paramView.getAppRuntime(), "dc00898", "", "", "0X800B259", "0X800B259", 0, 0, "", "", "", "");
        }
        QLog.d("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: startMiniApp");
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramView, this.jdField_a_of_type_JavaLangString, 4010, null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment.RiskLinkClickableSpan
 * JD-Core Version:    0.7.0.1
 */