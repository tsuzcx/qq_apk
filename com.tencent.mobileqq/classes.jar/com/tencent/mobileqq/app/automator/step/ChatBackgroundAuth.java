package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ChatBackgroundAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class ChatBackgroundAuth
  extends AsyncStep
{
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.b.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastChabgAuthTime", 0L);
    Object localObject;
    if (System.currentTimeMillis() - l > 86400000L)
    {
      localObject = ((ChatBackgroundManager)this.a.b.getManager(62)).a();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        ((ChatBackgroundAuthHandler)this.a.b.a(54)).a((List)localObject);
      }
      localSharedPreferences.edit().putLong("lastChabgAuthTime", System.currentTimeMillis()).commit();
    }
    localSharedPreferences = this.a.b.getApp().getSharedPreferences(this.a.b.getCurrentAccountUin(), 0);
    l = localSharedPreferences.getLong("last_pull_drawer_expire_info_time", 0L);
    if (System.currentTimeMillis() - l <= 86400000L) {}
    for (;;)
    {
      return 7;
      localObject = (VasExtensionHandler)this.a.b.a(71);
      if (localObject != null)
      {
        ((VasExtensionHandler)localObject).a(3);
        localSharedPreferences.edit().putLong("last_pull_drawer_expire_info_time", System.currentTimeMillis()).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth
 * JD-Core Version:    0.7.0.1
 */