package com.tencent.avgame.util;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class CostTraceUtil
{
  private static CostTraceUtil jdField_a_of_type_ComTencentAvgameUtilCostTraceUtil;
  private String jdField_a_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  
  public static CostTraceUtil a()
  {
    if (jdField_a_of_type_ComTencentAvgameUtilCostTraceUtil == null) {
      try
      {
        jdField_a_of_type_ComTencentAvgameUtilCostTraceUtil = new CostTraceUtil();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvgameUtilCostTraceUtil;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (paramString == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
      return;
    }
    paramString.clear();
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = paramIntent.getLongExtra("key_start_time", 0L);
      if (l2 != 0L)
      {
        paramIntent = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append("]");
        QLog.i(paramIntent, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
    }
  }
  
  public void c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l1 = SystemClock.elapsedRealtime();
      Object localObject = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localObject != null)
      {
        long l2 = ((Long)localObject).longValue();
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.CostTraceUtil
 * JD-Core Version:    0.7.0.1
 */