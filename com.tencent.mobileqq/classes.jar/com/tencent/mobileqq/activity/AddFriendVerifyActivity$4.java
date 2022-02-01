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
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    if (this.a.b != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
    }
    Object localObject = AddFriendVerifyActivity.a(this.a).getText().toString().trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (!this.a.isFinishing())
      {
        localObject = new QQAnonymousDialog(this.a);
        ((QQAnonymousDialog)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131699950));
        ((QQAnonymousDialog)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850874);
        ((QQAnonymousDialog)localObject).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((String)localObject).length() > 90)
      {
        localObject = new ReportDialog(this.a, 2131755842);
        ((Dialog)localObject).setContentView(2131562946);
        ((TextView)((Dialog)localObject).findViewById(2131365807)).setText(this.a.getString(2131691184));
        ((ProgressBar)((Dialog)localObject).findViewById(2131367330)).setVisibility(8);
        ((ImageView)((Dialog)localObject).findViewById(2131380971)).setImageResource(2130839732);
        ((Dialog)localObject).show();
      }
      else
      {
        this.a.a((String)localObject, true);
        if (NetworkUtil.d(this.a)) {
          AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), (String)localObject, this.a.getIntent().getIntExtra("stat_option", 0), 2000);
        } else {
          QQToast.a(this.a, 1, 2131694459, 0).b(this.a.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.4
 * JD-Core Version:    0.7.0.1
 */