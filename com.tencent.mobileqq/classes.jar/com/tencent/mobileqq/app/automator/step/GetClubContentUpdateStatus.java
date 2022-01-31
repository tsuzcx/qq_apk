package com.tencent.mobileqq.app.automator.step;

import alpu;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdrh;
import bdtc;
import bdty;
import bdvk;
import bdzy;
import befg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (VasQuickUpdateManager)this.a.app.getManager(184);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    bdrh.b(this.a.app);
    bdvk.a().a(this.a.app);
    befg.a().a(this.a.app);
    bdrh.a(this.a.app);
    localObject = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      alpu localalpu = (alpu)this.a.app.a(16);
      if (localalpu != null)
      {
        localalpu.a();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      bdzy.a().a(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
      localObject = (bdtc)this.a.app.getManager(177);
      if (!((bdtc)localObject).b) {
        ((bdtc)localObject).a(this.a.app.getCurrentAccountUin());
      }
      ((bdty)this.a.app.getManager(192)).a();
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */