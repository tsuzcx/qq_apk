package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;

class ForwardRecentActivity$14
  extends AutomatorObserver
{
  ForwardRecentActivity$14(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      this.a.mForwardOption.j();
    }
    try
    {
      ForwardRecentActivity.access$2000(this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ForwardOption.ForwardEntranceActivity", 1, "mInitObserver", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.14
 * JD-Core Version:    0.7.0.1
 */