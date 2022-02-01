package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AddFriendVerifyActivity$6
  implements View.OnClickListener
{
  AddFriendVerifyActivity$6(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b.s != null)
    {
      this.b.getWindow().setSoftInputMode(2);
      this.b.s.hideSoftInputFromWindow(this.b.b.getWindowToken(), 0);
      this.b.b.clearFocus();
    }
    Object localObject;
    if (this.b.b.getText().toString().length() > 30)
    {
      localObject = new ReportDialog(this.b, 2131953338);
      ((Dialog)localObject).setContentView(2131629210);
      ((TextView)((Dialog)localObject).findViewById(2131431876)).setText(this.b.getString(2131888051));
      ((ProgressBar)((Dialog)localObject).findViewById(2131433567)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131449154)).setImageResource(2130840055);
      ((Dialog)localObject).show();
    }
    else
    {
      localObject = this.b.b.getText().toString().trim();
      this.b.a((String)localObject, false);
      if ((this.b.getString(2131888921).equals(localObject)) && (!AddFriendVerifyActivity.g(this.b))) {
        AddFriendVerifyActivity.h(this.b);
      }
      localObject = this.b;
      ((AddFriendVerifyActivity)localObject).b(((AddFriendVerifyActivity)localObject).b.getText().toString().trim());
      if (this.a == 0) {
        ReportController.b(this.b.app, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.b.app, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(this.b.w)) {
        ReportController.b(this.b.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.6
 * JD-Core Version:    0.7.0.1
 */