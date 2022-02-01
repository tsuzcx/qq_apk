package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Locale;

class AddAccountActivity$12
  implements ActionSheet.OnButtonClickListener
{
  AddAccountActivity$12(AddAccountActivity paramAddAccountActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AddAccountActivity.access$700(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(this.a.app, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
      ReportController.a(this.a.app, "dc00898", "", "", "0X800B28F", "0X800B28F", 0, 0, "", "", "", "");
      paramView = null;
      if (this.a.mAutoTextAccount != null) {
        paramView = this.a.mAutoTextAccount.getText().toString();
      }
      String str = "https://ti.qq.com/safe/forgetpw?source_id=2756";
      if (!TextUtils.isEmpty(paramView)) {
        str = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });
      }
      paramView = new Intent(this.a, QQBrowserActivity.class);
      paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", str);
      this.a.startActivity(paramView);
    }
    else if (paramInt == 1)
    {
      ReportController.a(this.a.app, "dc00898", "", "", "0X800AFD8", "0X800AFD8", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
      boolean bool = this.a.getIntent().getBooleanExtra("login_from_account_change", false);
      paramView = new Intent();
      paramView.putExtra("login_from_account_change", bool);
      paramView.putExtra("entrance", "fromAddAccount");
      RouteUtils.a(this.a, paramView, "/base/safe/loginPhoneNumActivity");
    }
    AddAccountActivity.access$702(this.a, true);
    AddAccountActivity.access$800(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.12
 * JD-Core Version:    0.7.0.1
 */