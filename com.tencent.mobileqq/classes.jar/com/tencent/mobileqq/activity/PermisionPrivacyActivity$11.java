package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.inputstatus.InputStatusObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.app.AppRuntime;

class PermisionPrivacyActivity$11
  extends InputStatusObserver
{
  PermisionPrivacyActivity$11(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (!paramBoolean1)
    {
      this.a.a(2131718834, 1);
      return;
    }
    Object localObject = this.a;
    PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, ((PermisionPrivacyActivity)localObject).c.a(), paramBoolean2);
    localObject = this.a.app;
    if (paramBoolean2) {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009D11", "0X8009D11", 0, 0, String.valueOf(i), "", "", "");
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      PermisionPrivacyActivity localPermisionPrivacyActivity = this.a;
      PermisionPrivacyActivity.a(localPermisionPrivacyActivity, localPermisionPrivacyActivity.c.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.11
 * JD-Core Version:    0.7.0.1
 */