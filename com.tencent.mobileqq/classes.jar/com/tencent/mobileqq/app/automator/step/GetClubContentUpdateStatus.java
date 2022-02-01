package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anva;
import bhwl;
import bhyg;
import bhzg;
import bias;
import biho;
import bind;
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
    bhwl.b(this.a.app);
    bias.a().a(this.a.app);
    bind.a().a(this.a.app);
    bhwl.a(this.a.app);
    localObject = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      anva localanva = (anva)this.a.app.a(16);
      if (localanva != null)
      {
        localanva.a();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      biho.a().a(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
      localObject = (bhyg)this.a.app.getManager(177);
      if (!((bhyg)localObject).b) {
        ((bhyg)localObject).a(this.a.app.getCurrentAccountUin());
      }
      ((bhzg)this.a.app.getManager(192)).a();
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