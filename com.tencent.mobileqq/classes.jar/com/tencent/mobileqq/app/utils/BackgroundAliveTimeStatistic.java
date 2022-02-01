package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.gdtad.qqproxy.GdtAppPreOrderUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class BackgroundAliveTimeStatistic
{
  private static int jdField_a_of_type_Int = 0;
  public static long a = 0L;
  private static boolean jdField_a_of_type_Boolean = false;
  private static boolean b;
  private static boolean c;
  
  static
  {
    int i = MobileQQ.sProcessId;
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    b = bool1;
    jdField_a_of_type_Int = 0;
    boolean bool1 = bool2;
    if (Math.random() < 9.999999747378752E-005D) {
      bool1 = true;
    }
    c = bool1;
  }
  
  public static void a()
  {
    try
    {
      if ((b) && (c) && (jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Long += 1L;
        if (jdField_a_of_type_Long == 1L) {
          jdField_a_of_type_Int = (int)Debug.getPss();
        }
        Object localObject = MobileQQ.getContext();
        int i = 0;
        localObject = ((BaseApplication)localObject).getSharedPreferences("bg_alive_sp_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putLong("bg_time_sp_key", jdField_a_of_type_Long);
        ((SharedPreferences.Editor)localObject).putInt("bg_mem_sp_key", jdField_a_of_type_Int);
        if (GdtAppPreOrderUtil.a()) {
          i = 1;
        }
        ((SharedPreferences.Editor)localObject).putInt("bg_download_launched_sp_key", i);
        ((SharedPreferences.Editor)localObject).apply();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BackgroundAliveTimeStatistic", 1, "onBackgroundTick error", localThrowable);
    }
  }
  
  private static void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong > 0L) {
      ThreadManager.getFileThreadHandler().postDelayed(new BackgroundAliveTimeStatistic.1(paramLong, paramInt1, paramInt2), 1000L);
    }
  }
  
  public static void b()
  {
    try
    {
      if ((b) && (c) && (jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Long = 0L;
        jdField_a_of_type_Int = 0;
        SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("bg_alive_sp_file", 0).edit();
        localEditor.putLong("bg_time_sp_key", jdField_a_of_type_Long);
        localEditor.putInt("bg_mem_sp_key", 0);
        localEditor.putInt("bg_download_launched_sp_key", 0);
        localEditor.apply();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BackgroundAliveTimeStatistic", 1, "clearBackgroundTickCount error", localThrowable);
    }
  }
  
  public static void c()
  {
    try
    {
      if ((!jdField_a_of_type_Boolean) && (b))
      {
        jdField_a_of_type_Boolean = true;
        jdField_a_of_type_Long = 0L;
        jdField_a_of_type_Int = 0;
        SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("bg_alive_sp_file", 0);
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        a(localSharedPreferences.getLong("bg_time_sp_key", 0L), localSharedPreferences.getInt("bg_mem_sp_key", 0), localSharedPreferences.getInt("bg_download_launched_sp_key", 0));
        localEditor.putLong("bg_time_sp_key", 0L);
        localEditor.putInt("bg_mem_sp_key", 0);
        localEditor.putInt("bg_download_launched_sp_key", 0);
        localEditor.apply();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BackgroundAliveTimeStatistic", 1, "reportBackgroundAliveTime error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic
 * JD-Core Version:    0.7.0.1
 */