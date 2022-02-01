package com.tencent.mobileqq.app;

import android.os.Looper;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class SqliteExcuteMonitor$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    try
    {
      localObject = paramMethodHookParam.args;
      boolean bool = false;
      int i = ((Integer)localObject[0]).intValue();
      if (this.jdField_a_of_type_JavaLangReflectMethod != null)
      {
        paramMethodHookParam = this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramMethodHookParam.thisObject, new Object[] { Integer.valueOf(i) });
        if (SqliteExcuteMonitor.a() == null)
        {
          SqliteExcuteMonitor.a(paramMethodHookParam.getClass().getDeclaredField("mStartTime"));
          SqliteExcuteMonitor.a().setAccessible(true);
        }
        if (SqliteExcuteMonitor.b() == null)
        {
          SqliteExcuteMonitor.b(paramMethodHookParam.getClass().getDeclaredField("mEndTime"));
          SqliteExcuteMonitor.b().setAccessible(true);
        }
        if (SqliteExcuteMonitor.c() == null)
        {
          SqliteExcuteMonitor.c(paramMethodHookParam.getClass().getDeclaredField("mSql"));
          SqliteExcuteMonitor.c().setAccessible(true);
        }
        long l1 = ((Long)SqliteExcuteMonitor.a().get(paramMethodHookParam)).longValue();
        long l2 = ((Long)SqliteExcuteMonitor.b().get(paramMethodHookParam)).longValue();
        paramMethodHookParam = ((String)SqliteExcuteMonitor.c().get(paramMethodHookParam)).toUpperCase();
        l1 = l2 - l1;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          bool = true;
        }
        if (SqliteExcuteMonitor.a(paramMethodHookParam, l1, bool))
        {
          SqliteExcuteMonitor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMethodHookParam, l1, bool, this.jdField_a_of_type_Int);
          return;
        }
      }
    }
    catch (Throwable paramMethodHookParam)
    {
      SqliteExcuteMonitor.a(true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hook exception :");
        ((StringBuilder)localObject).append(paramMethodHookParam.getMessage());
        QLog.i("SqliteExcuteMonitor", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramMethodHookParam)
    {
      Object localObject;
      SqliteExcuteMonitor.a(true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hook exception :");
        ((StringBuilder)localObject).append(paramMethodHookParam.getMessage());
        QLog.i("SqliteExcuteMonitor", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SqliteExcuteMonitor.1
 * JD-Core Version:    0.7.0.1
 */