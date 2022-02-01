package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AddFriendVerifyActivity$4
  implements View.OnClickListener
{
  AddFriendVerifyActivity$4(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.s != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.s.hideSoftInputFromWindow(AddFriendVerifyActivity.e(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.e(this.a).clearFocus();
    }
    if (this.a.B != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
    }
    Object localObject = AddFriendVerifyActivity.e(this.a).getText().toString().trim();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!this.a.isFinishing())
      {
        localObject = new QQAnonymousDialog(this.a);
        ((QQAnonymousDialog)localObject).c.setText(HardCodeUtil.a(2131898136));
        ((QQAnonymousDialog)localObject).b.setImageResource(2130852641);
        ((QQAnonymousDialog)localObject).a();
      }
    }
    else if (((String)localObject).length() > 90)
    {
      localObject = new ReportDialog(this.a, 2131953338);
      ((Dialog)localObject).setContentView(2131629210);
      ((TextView)((Dialog)localObject).findViewById(2131431876)).setText(this.a.getString(2131888051));
      ((ProgressBar)((Dialog)localObject).findViewById(2131433567)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131449154)).setImageResource(2130840055);
      ((Dialog)localObject).show();
    }
    else
    {
      this.a.a((String)localObject, true);
      if (NetworkUtil.isNetSupport(this.a))
      {
        AddFriendVerifyActivity localAddFriendVerifyActivity = this.a;
        AddFriendVerifyActivity.a(localAddFriendVerifyActivity, AddFriendVerifyActivity.d(localAddFriendVerifyActivity), (String)localObject, this.a.getIntent().getIntExtra("stat_option", 0), 2000);
      }
      else
      {
        QQToast.makeText(this.a, 1, 2131892104, 0).show(this.a.getTitleBarHeight());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.4
 * JD-Core Version:    0.7.0.1
 */