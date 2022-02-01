package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyFragment$5
  extends AddFriendVerifyFragment.AddFriendOnclick
{
  AddFriendVerifyFragment$5(AddFriendVerifyFragment paramAddFriendVerifyFragment, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramAddFriendVerifyFragment);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AddFriendVerifyFragment.g(this.d);
    Object localObject = AddFriendVerifyFragment.a(this.d, false);
    String str = AddFriendVerifyFragment.c(this.d).getText().toString().trim();
    if ((str != null) && (localObject != null) && (!str.equals(localObject))) {
      ReportController.b(AddFriendVerifyFragment.f(this.d), "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
    }
    this.d.a(str, false);
    if ((this.d.getString(2131888921).equals(str)) && (!AddFriendVerifyFragment.d(this.d))) {
      AddFriendVerifyFragment.e(this.d);
    }
    if (this.d.e != null)
    {
      ReportController.b(AddFriendVerifyFragment.f(this.d), "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
      if ((!TextUtils.isEmpty(this.d.e.verifyMsg)) && (!this.d.e.verifyMsg.equals(AddFriendVerifyFragment.c(this.d).getText().toString()))) {
        ReportController.b(AddFriendVerifyFragment.f(this.d), "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
      }
    }
    localObject = this.d;
    ((AddFriendVerifyFragment)localObject).a(AddFriendVerifyFragment.c((AddFriendVerifyFragment)localObject).getText().toString().trim(), null, "");
    ReportController.b(AddFriendVerifyFragment.f(this.d), "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.a), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.d.b)) {
      ReportController.b(AddFriendVerifyFragment.f(this.d), "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.d.a(this.a, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.5
 * JD-Core Version:    0.7.0.1
 */