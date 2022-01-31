package com.tencent.mobileqq.app.automator.step;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mqp.app.sec.SecClientInfoTask;
import com.tencent.mqp.app.sec.SecClientInfoTaskEx;
import java.util.HashMap;
import java.util.Random;

public class ReportClientInfo
  extends AsyncStep
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private static void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (!BaseApplicationImpl.isFirstLogin) {
        return;
      }
      if (a(paramLong))
      {
        int i = new Random().nextInt() & 0x7FFFFFFF;
        new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new SecClientInfoTask(paramLong, 1, i), 5000L);
        int j = new Random().nextInt(50000);
        new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new SecClientInfoTask(paramLong, 2, i), j + 120000);
        i = new Random().nextInt() & 0x7FFFFFFF;
        j = new Random().nextInt(50000);
        new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new SecClientInfoTaskEx(paramLong, 1, i), j + 10000);
        Handler localHandler = new Handler(ThreadManager.getSubThreadLooper());
        j = new Random().nextInt(50000);
        localHandler.postDelayed(new SecClientInfoTaskEx(paramLong, 2, i), j + 240000);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static boolean a(long paramLong)
  {
    try
    {
      Long localLong1 = Long.valueOf(System.currentTimeMillis());
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
        {
          Long localLong2 = (Long)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
          if (localLong1.longValue() - localLong2.longValue() < 86400000L) {
            return false;
          }
        }
        jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localLong1);
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected int a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getLongAccountUin(), true);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportClientInfo
 * JD-Core Version:    0.7.0.1
 */