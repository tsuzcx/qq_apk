package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

class QQMapActivity$7$1
  implements ActionSheet.OnButtonClickListener
{
  QQMapActivity$7$1(QQMapActivity.7 param7) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
      QQMapRoutingHelper.a("share_success");
      this.a.a.u();
      continue;
      if (QfavBuilder.a((float)this.a.a.jdField_a_of_type_Double, (float)this.a.a.b, this.a.a.l, this.a.a.i, null).c(this.a.a.getIntent().getStringExtra("uin")).b(this.a.a, this.a.a.getIntent().getStringExtra("uin"), 1, null))
      {
        paramInt = QQMapActivity.a(this.a.a).getDimensionPixelSize(2131299166);
        QQToast.a(this.a.a, 2, this.a.a.getString(2131692259), 1).b(paramInt);
        QQMapRoutingHelper.a("favorite_success");
      }
      QfavReport.a(null, 65, 7);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.7.1
 * JD-Core Version:    0.7.0.1
 */