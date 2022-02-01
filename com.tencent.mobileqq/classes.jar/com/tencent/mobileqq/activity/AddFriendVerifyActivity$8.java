package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyActivity$8
  implements View.OnClickListener
{
  AddFriendVerifyActivity$8(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyActivity.i(this.d);
    Object localObject = AddFriendVerifyActivity.a(this.d, false);
    String str = this.d.b.getText().toString().trim();
    if ((str != null) && (localObject != null) && (!str.equals(localObject))) {
      ReportController.b(this.d.app, "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
    }
    this.d.a(str, false);
    if ((this.d.getString(2131888921).equals(str)) && (!AddFriendVerifyActivity.g(this.d))) {
      AddFriendVerifyActivity.h(this.d);
    }
    if (this.d.v != null)
    {
      ReportController.b(this.d.app, "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
      if ((!TextUtils.isEmpty(this.d.v.verifyMsg)) && (!this.d.v.verifyMsg.equals(this.d.b.getText().toString()))) {
        ReportController.b(this.d.app, "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
      }
    }
    localObject = this.d;
    ((AddFriendVerifyActivity)localObject).a(((AddFriendVerifyActivity)localObject).b.getText().toString().trim(), null, "");
    ReportController.b(this.d.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.a), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.d.w)) {
      ReportController.b(this.d.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.d.a(this.a, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.8
 * JD-Core Version:    0.7.0.1
 */