package com.tencent.mobileqq.app.automator.step;

import ahla;
import aljq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqwa;
import ayvc;
import azyl;
import bdcs;
import behr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nav;

public class ActiveAccount
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.app.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.app.getApp().getSharedPreferences("acc_info" + this.a.app.getAccount(), 0);
    localObject = this.a.app;
    ThemeUtil.initTheme((QQAppInterface)localObject);
    try
    {
      ((QQAppInterface)localObject).a(true, this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L));
      bool = false;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        boolean bool;
        ((QQAppInterface)localObject).a(true);
        try
        {
          this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("PREF_PLUGIN_DELAY_TIME", 0L).apply();
          bool = true;
        }
        catch (Throwable localThrowable2)
        {
          bool = true;
        }
      }
    }
    azyl.a((QQAppInterface)localObject);
    ((QQAppInterface)localObject).b();
    aqwa.a().b();
    UnifiedMonitor.a().a();
    OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
    if (ahla.a(((QQAppInterface)localObject).getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      ((QQAppInterface)localObject).a().e("last_group_seq", 0L);
      ((QQAppInterface)localObject).a().e("last_group_suspicious_seq", 0L);
      ahla.a(((QQAppInterface)localObject).getCurrentAccountUin(), false);
      ((QQAppInterface)localObject).a().e("last_friend_seq_47", 0L);
    }
    if (nav.a != null) {
      nav.a().a();
    }
    if ((((QQAppInterface)localObject).a(107) instanceof behr)) {
      ((behr)((QQAppInterface)localObject).a(107)).a();
    }
    localObject = new File(aljq.aX);
    if (!bdcs.a(aljq.aX)) {
      ((File)localObject).mkdirs();
    }
    CleanCache.a(aljq.aX);
    QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(bool) });
    return 7;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */