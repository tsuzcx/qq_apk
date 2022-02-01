package com.tencent.av.business.manager.filter;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class EffectFilterTools$DataReport
{
  static long jdField_a_of_type_Long = 0L;
  static String jdField_a_of_type_JavaLangString = "EffectFilterTools";
  static boolean jdField_a_of_type_Boolean = false;
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(1))
    {
      paramVideoAppInterface = (FilterItem)((EffectFilterTools)paramVideoAppInterface.a(1)).a();
      a(paramVideoAppInterface);
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DataReport onUserdFilter:");
      localStringBuilder.append(paramVideoAppInterface);
      localStringBuilder.append("|");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      AVLog.printColorLog(str, localStringBuilder.toString());
      if (jdField_a_of_type_Boolean) {
        paramVideoAppInterface = "0X80076B2";
      } else {
        paramVideoAppInterface = "0X80076B1";
      }
      a(paramVideoAppInterface);
    }
  }
  
  static void a(FilterItem paramFilterItem)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReport onUserdFilter:");
    localStringBuilder.append(paramFilterItem);
    localStringBuilder.append("|");
    localStringBuilder.append(jdField_a_of_type_Long);
    AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    if ((paramFilterItem != null) && (!paramFilterItem.isEmptyFilter()))
    {
      long l2 = jdField_a_of_type_Long;
      if (l2 != 0L)
      {
        l2 = l1 - l2;
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DataReport onUserdFilter:");
        localStringBuilder.append(l2);
        AVLog.printColorLog((String)localObject, localStringBuilder.toString());
        if (l2 > 5000L)
        {
          jdField_a_of_type_Boolean = true;
          a(paramFilterItem, l2 / 1000L);
        }
      }
      paramFilterItem = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DataReport onUserdFilter 33:");
      ((StringBuilder)localObject).append(jdField_a_of_type_Long);
      AVLog.printColorLog(paramFilterItem, ((StringBuilder)localObject).toString());
    }
    jdField_a_of_type_Long = l1;
  }
  
  public static void a(FilterItem paramFilterItem, long paramLong)
  {
    paramFilterItem = paramFilterItem.getId();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReport onStateReport:");
    localStringBuilder.append(paramFilterItem);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong);
    AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    localObject = new HashMap();
    ((Map)localObject).put("filterName", paramFilterItem);
    ((Map)localObject).put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatFilter", true, -1L, -1L, (Map)localObject, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      return;
    }
    catch (Exception paramFilterItem)
    {
      AVLog.printErrorLog(jdField_a_of_type_JavaLangString, paramFilterItem.getMessage());
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReport onSupport:");
    localStringBuilder.append(paramBoolean);
    AVLog.printColorLog(str, localStringBuilder.toString());
    if (paramBoolean) {
      str = "0X80076AF";
    } else {
      str = "0X80076B0";
    }
    a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.EffectFilterTools.DataReport
 * JD-Core Version:    0.7.0.1
 */