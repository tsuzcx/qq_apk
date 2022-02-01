package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AddFriendVerifyActivity$2
  implements View.OnClickListener
{
  AddFriendVerifyActivity$2(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (!AddFriendVerifyActivity.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.b != 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
      }
      if (this.a.a != null)
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 90)
      {
        ReportDialog localReportDialog = new ReportDialog(this.a, 2131755842);
        localReportDialog.setContentView(2131562946);
        ((TextView)localReportDialog.findViewById(2131365807)).setText(this.a.getString(2131691184));
        ((ProgressBar)localReportDialog.findViewById(2131367330)).setVisibility(8);
        ((ImageView)localReportDialog.findViewById(2131380971)).setImageResource(2130839732);
        localReportDialog.show();
      }
      else
      {
        this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
        if (NetworkUtil.d(this.a))
        {
          if (AddFriendVerifyActivity.a(this.a) != null) {}
          for (int i = AddFriendVerifyActivity.a(this.a).a();; i = 2000)
          {
            QLog.e("AddFriendVerifyActivity", 1, "joinTroop templateId: " + i);
            AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), i);
            ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A62B", PobingTemplateAdapter.a(i), 0, "", "", "", "");
            if (!"d2g".equals(this.a.getIntent().getStringExtra("jump_from"))) {
              break;
            }
            ReportController.b(this.a.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.a), "", "", "");
            break;
          }
        }
        QQToast.a(this.a, 1, 2131694459, 0).b(this.a.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.2
 * JD-Core Version:    0.7.0.1
 */