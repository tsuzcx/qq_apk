package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

class CheckPublicAccount$MyPublicAccountObserver
  extends PublicAccountObserver
{
  private CheckPublicAccount$MyPublicAccountObserver(CheckPublicAccount paramCheckPublicAccount) {}
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "PublicAccount onUpdateUserFollowList:" + paramBoolean + " " + paramInt);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      this.a.a.a.edit().putBoolean("isPublicAccountListOK", true).commit();
      this.a.a(7);
    }
    while (paramInt == 0) {
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount.MyPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */