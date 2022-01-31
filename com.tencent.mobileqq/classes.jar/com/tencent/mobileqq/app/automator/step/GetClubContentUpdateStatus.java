package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.FlashCarGameManager;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vas.SonicTemplateUpdateManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  protected int a()
  {
    Object localObject1 = (VasQuickUpdateManager)this.a.b.getManager(183);
    if (!((VasQuickUpdateManager)localObject1).a.get()) {
      ((VasQuickUpdateManager)localObject1).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    Object localObject2 = (VasExtensionManager)this.a.b.getManager(234);
    if (((VasExtensionManager)localObject2).a.e)
    {
      ((VasQuickUpdateManager)localObject1).a(1005L, "flashcar.gameres.2000.zip", "FlashCarGameManager");
      ((VasExtensionManager)localObject2).a.e = false;
    }
    ClubContentJsonTask.b(this.a.b);
    VipGrayConfigHelper.a().a(this.a.b);
    WebViewTitleStyleHelper.a().a(this.a.b);
    ClubContentJsonTask.a(this.a.b);
    localObject1 = this.a.b.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject1).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      localObject2 = (ClubContentUpdateHandler)this.a.b.a(16);
      if (localObject2 != null)
      {
        ((ClubContentUpdateHandler)localObject2).b();
        ((SharedPreferences)localObject1).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      localObject1 = (ThemeSwitchManager)this.a.b.getManager(184);
      ((ThemeSwitchManager)localObject1).a(((ThemeSwitchManager)localObject1).jdField_a_of_type_OrgJsonJSONArray, ((ThemeSwitchManager)localObject1).jdField_a_of_type_Int, "206", 1);
      AioVipKeywordHelper.a().a(this.a.b.getApplication(), this.a.b.getCurrentAccountUin());
      localObject1 = (IndividuationABTestManager)this.a.b.getManager(176);
      if (!((IndividuationABTestManager)localObject1).b) {
        ((IndividuationABTestManager)localObject1).a(this.a.b.getCurrentAccountUin());
      }
      ((SonicTemplateUpdateManager)this.a.b.getManager(191)).a();
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