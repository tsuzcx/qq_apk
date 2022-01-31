package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetApolloContentUpdateStatus
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetApolloContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    Object localObject = this.a.b.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_apollo_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l))
    {
      ApolloContentUpdateHandler localApolloContentUpdateHandler = (ApolloContentUpdateHandler)this.a.b.a(115);
      if (localApolloContentUpdateHandler != null)
      {
        localApolloContentUpdateHandler.a(null);
        ((SharedPreferences)localObject).edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      ApolloGameManager.b();
      ((ApolloGameManager)this.a.b.getManager(210)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      localObject = (ApolloManager)this.a.b.getManager(152);
      if ((localObject != null) && (((ApolloManager)localObject).b(this.a.b.getCurrentAccountUin()))) {
        ((ApolloManager)localObject).a(2);
      }
      ApolloSoLoader.a("login");
      ApolloManager.a = this.a.b.getCurrentAccountUin();
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (ApolloManager.a(this.a.b.getApp()))
      {
        ((ApolloManager)this.a.b.getManager(152)).a(false, "login check file", 1);
        int i = ((SharedPreferences)localObject).getInt("apollo_game_version" + this.a.b.getCurrentAccountUin(), 0);
        if ((i == 0) || (!FileUtil.a(ApolloUtil.b)))
        {
          QLog.i("QQInitHandler", 1, "try to update game json, gameVer:" + i);
          if ((ApolloContentUpdateHandler)this.a.b.a(115) != null) {
            ApolloContentUpdateHandler.a(this.a.b, 2);
          }
        }
      }
      else if (FileUtil.a(ApolloUtil.a))
      {
        ApolloManager.a(this.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */