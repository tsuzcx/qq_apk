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
    if (AddFriendVerifyActivity.a(this.a))
    {
      if (this.a.b != 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
      }
      if (this.a.a != null)
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      Object localObject;
      if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 90)
      {
        localObject = new ReportDialog(this.a, 2131756189);
        ((Dialog)localObject).setContentView(2131562765);
        ((TextView)((Dialog)localObject).findViewById(2131365644)).setText(this.a.getString(2131691105));
        ((ProgressBar)((Dialog)localObject).findViewById(2131367113)).setVisibility(8);
        ((ImageView)((Dialog)localObject).findViewById(2131380236)).setImageResource(2130839590);
        ((Dialog)localObject).show();
      }
      else
      {
        localObject = this.a;
        ((AddFriendVerifyActivity)localObject).a(AddFriendVerifyActivity.a((AddFriendVerifyActivity)localObject).getText().toString(), true);
        if (NetworkUtil.isNetSupport(this.a))
        {
          int i;
          if (AddFriendVerifyActivity.a(this.a) != null) {
            i = AddFriendVerifyActivity.a(this.a).a();
          } else {
            i = 2000;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("joinTroop templateId: ");
          ((StringBuilder)localObject).append(i);
          QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
          localObject = this.a;
          AddFriendVerifyActivity.a((AddFriendVerifyActivity)localObject, AddFriendVerifyActivity.a((AddFriendVerifyActivity)localObject), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), i);
          ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A62B", PobingTemplateAdapter.a(i), 0, "", "", "", "");
          if ("d2g".equals(this.a.getIntent().getStringExtra("jump_from"))) {
            ReportController.b(this.a.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.a), "", "", "");
          }
        }
        else
        {
          QQToast.a(this.a, 1, 2131694424, 0).b(this.a.getTitleBarHeight());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.2
 * JD-Core Version:    0.7.0.1
 */