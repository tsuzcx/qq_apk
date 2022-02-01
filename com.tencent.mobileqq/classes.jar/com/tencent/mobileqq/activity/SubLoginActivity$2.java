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
    if (this.a.b) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(this.a.app, "dc00898", "", "", "0X800B290", "0X800B290", 0, 0, "", "", "", "");
      paramView = null;
      if (SubLoginActivity.a(this.a) != null) {
        paramView = SubLoginActivity.a(this.a).getText().toString();
      }
      String str = "https://ti.qq.com/safe/forgetpw?source_id=2756";
      if (!TextUtils.isEmpty(paramView)) {
        str = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });
      }
      paramView = new Intent();
      paramView.putExtra("uin", SubLoginActivity.a(this.a));
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", str);
      RouteUtils.a(this.a, paramView, "/base/browser");
      this.a.startActivity(paramView);
    }
    else if (paramInt == 1)
    {
      ReportController.a(this.a.app, "dc00898", "", "", "0X800AFDF", "0X800AFDF", 0, 0, "", "", "", "");
      paramView = new Intent();
      paramView.putExtra("isSubaccount", true);
      paramView.putExtra("fromWhere", this.a.fromWhere);
      paramView.putExtra("entrance", "fromSubLogin");
      RouteUtils.a(this.a, paramView, "/base/safe/loginPhoneNumActivity");
    }
    paramView = this.a;
    paramView.b = true;
    paramView.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.2
 * JD-Core Version:    0.7.0.1
 */