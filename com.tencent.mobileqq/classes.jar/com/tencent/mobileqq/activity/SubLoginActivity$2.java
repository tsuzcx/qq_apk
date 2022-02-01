package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Locale;

class SubLoginActivity$2
  implements ActionSheet.OnButtonClickListener
{
  SubLoginActivity$2(SubLoginActivity paramSubLoginActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(this.a.app, "dc00898", "", "", "0X800B290", "0X800B290", 0, 0, "", "", "", "");
      paramView = null;
      if (SubLoginActivity.a(this.a) != null) {
        paramView = SubLoginActivity.a(this.a).getText().toString();
      }
      if (TextUtils.isEmpty(paramView)) {
        break label258;
      }
    }
    label258:
    for (paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });; paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756")
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("uin", SubLoginActivity.a(this.a));
      localIntent.putExtra("reqType", 3);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      for (;;)
      {
        this.a.jdField_b_of_type_Boolean = true;
        this.a.a.dismiss();
        return;
        if (paramInt == 1)
        {
          ReportController.a(this.a.app, "dc00898", "", "", "0X800AFDF", "0X800AFDF", 0, 0, "", "", "", "");
          paramView = new Intent();
          paramView.putExtra("isSubaccount", true);
          paramView.putExtra("fromWhere", this.a.jdField_b_of_type_JavaLangString);
          paramView.putExtra("entrance", "fromSubLogin");
          RouteUtils.a(this.a, paramView, "/base/safe/loginPhoneNumActivity");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.2
 * JD-Core Version:    0.7.0.1
 */