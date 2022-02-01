package com.tencent.mobileqq.app.automator.step;

import ajpz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import antf;
import aure;
import bcrg;
import bdho;
import bdwt;
import bhmi;
import bitz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import nlj;

public class ActiveAccount
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.app.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("startService", Long.valueOf(SystemClock.uptimeMillis() - bdho.i));
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
    bdwt.a((QQAppInterface)localObject);
    ((QQAppInterface)localObject).b();
    aure.a().b();
    UnifiedMonitor.a().a();
    OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
    if (ajpz.a(((QQAppInterface)localObject).getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      ((QQAppInterface)localObject).a().e("last_group_seq", 0L);
      ((QQAppInterface)localObject).a().e("last_group_suspicious_seq", 0L);
      ajpz.a(((QQAppInterface)localObject).getCurrentAccountUin(), false);
      ((QQAppInterface)localObject).a().e("last_friend_seq_47", 0L);
    }
    if (nlj.a != null) {
      nlj.a().a();
    }
    if ((((QQAppInterface)localObject).a(107) instanceof bitz)) {
      ((bitz)((QQAppInterface)localObject).a(107)).a();
    }
    localObject = new File(antf.ba);
    if (!bhmi.a(antf.ba)) {
      ((File)localObject).mkdirs();
    }
    CleanCache.a(antf.ba);
    QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(bool) });
    return 7;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */