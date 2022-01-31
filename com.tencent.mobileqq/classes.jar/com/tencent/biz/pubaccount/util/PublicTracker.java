package com.tencent.biz.pubaccount.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class PublicTracker
{
  public static int a;
  private static long jdField_a_of_type_Long;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  public static boolean a;
  private static long b;
  public static boolean b;
  private static long c;
  public static boolean c;
  private static long d;
  public static boolean d;
  private static long e;
  public static boolean e;
  private static long f;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    jdField_e_of_type_Boolean = true;
    jdField_a_of_type_Int = 1;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    jdField_e_of_type_Boolean = true;
    jdField_a_of_type_Int = 1;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString2 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      if (paramString2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PubAccAutoMonitor", 2, paramString1 + ", cost=" + (l - paramString2.longValue()));
        }
        if (!TextUtils.equals(paramString1, "KANDIAN_NEW_FEEDS_CREATE")) {
          break label82;
        }
        jdField_d_of_type_Long = l - paramString2.longValue();
      }
    }
    label82:
    label627:
    while (paramString2 == null)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (TextUtils.equals(paramString1, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE"))
              {
                jdField_e_of_type_Long = l - paramString2.longValue();
                return;
              }
              if (TextUtils.equals(paramString1, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW"))
              {
                f = l - paramString2.longValue();
                return;
              }
              if (TextUtils.equals(paramString1, "KANDIAN_FEEDS_STAGE_1_COST"))
              {
                jdField_a_of_type_Long = l - paramString2.longValue();
                return;
              }
              if (TextUtils.equals(paramString1, "KANDIAN_FEEDS_STAGE_2_COST"))
              {
                jdField_b_of_type_Long = l - paramString2.longValue();
                return;
              }
              jdField_c_of_type_Long = l - paramString2.longValue();
            } while (jdField_c_of_type_Long > 10000L);
            if (TextUtils.equals(paramString1, "SUBSCRIPT_FEEDS_COST"))
            {
              StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actSubscribeOpenCost", true, jdField_c_of_type_Long, 0L, null, null);
              return;
            }
            if (TextUtils.equals(paramString1, "SUBSCRIPT_AIO_COST"))
            {
              StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actSubscribeAIOOpenCost", true, jdField_c_of_type_Long, 0L, null, null);
              return;
            }
            if (!TextUtils.equals(paramString1, "KANDIAN_FEEDS_COST")) {
              break;
            }
            paramString1 = new HashMap();
            paramString1.put("stage_total", String.valueOf(jdField_c_of_type_Long));
            paramString1.put("tab_index", String.valueOf(jdField_a_of_type_Int));
            paramString1.put("stage_1", String.valueOf(jdField_a_of_type_Long));
            paramString1.put("stage_2", String.valueOf(jdField_b_of_type_Long));
            paramString1.put("on_create", String.valueOf(jdField_d_of_type_Long));
            paramString1.put("load_article", String.valueOf(jdField_e_of_type_Long));
            paramString1.put("listView_cost", String.valueOf(f));
            StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianOpenCost", true, jdField_c_of_type_Long, 0L, paramString1, null);
          } while (!QLog.isColorLevel());
          QLog.i("PubAccAutoMonitor", 2, "isRecommendFirst = " + jdField_a_of_type_Boolean);
          QLog.d("PubAccAutoMonitor", 2, new Object[] { "kandian_feeds_open_cost, total_cost = ", Long.valueOf(jdField_c_of_type_Long), ", tab_index = ", Integer.valueOf(jdField_a_of_type_Int) });
          return;
          if (TextUtils.equals(paramString1, "KANDIAN_TO_SUBSCRIPT_COST"))
          {
            StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianToSubscribeCost", true, jdField_c_of_type_Long, 0L, null, null);
            return;
          }
        } while (TextUtils.equals(paramString1, "LEBA_KANDIAN_FEEDS_COST"));
        if (TextUtils.equals(paramString1, "SERVICE_FOLDER_COST"))
        {
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actServiceFolderToServiceNumListCost", true, jdField_c_of_type_Long, 0L, null, null);
          return;
        }
        if (TextUtils.equals(paramString1, "recommend_tab_cost"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PubAccAutoMonitor", 2, "isRecommendCostFirst = " + jdField_b_of_type_Boolean);
          }
          paramString2 = new HashMap();
          if (jdField_b_of_type_Boolean)
          {
            i = 1;
            paramString2.put("first", String.valueOf(i));
            paramString2.put("which", String.valueOf(1));
            if (!ReadInJoyHelper.f()) {
              break label627;
            }
          }
          for (paramString1 = "0";; paramString1 = "1")
          {
            paramString2.put("which_kandian", paramString1);
            StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianTabOpenCost", true, jdField_c_of_type_Long, 0L, paramString2, null);
            jdField_b_of_type_Boolean = false;
            return;
            i = 0;
            break;
          }
        }
        if (TextUtils.equals(paramString1, "video_tab_cost"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PubAccAutoMonitor", 2, "isVideoFirst = " + jdField_c_of_type_Boolean);
          }
          paramString1 = new HashMap();
          if (jdField_c_of_type_Boolean) {}
          for (i = 1;; i = 0)
          {
            paramString1.put("first", String.valueOf(i));
            paramString1.put("which", String.valueOf(2));
            StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianTabOpenCost", true, jdField_c_of_type_Long, 0L, paramString1, null);
            jdField_c_of_type_Boolean = false;
            return;
          }
        }
        if (TextUtils.equals(paramString1, "subscribe_tab_cost"))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PubAccAutoMonitor", 2, "isSubscribeFirst = " + jdField_d_of_type_Boolean);
          }
          paramString1 = new HashMap();
          if (jdField_d_of_type_Boolean) {}
          for (i = 1;; i = 0)
          {
            paramString1.put("first", String.valueOf(i));
            paramString1.put("which", String.valueOf(3));
            StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianTabOpenCost", true, jdField_c_of_type_Long, 0L, paramString1, null);
            jdField_d_of_type_Boolean = false;
            return;
          }
        }
      } while (!TextUtils.equals(paramString1, "self_tab_cost"));
      if (QLog.isColorLevel()) {
        QLog.i("PubAccAutoMonitor", 2, "isSelfFirst = " + jdField_e_of_type_Boolean);
      }
      paramString1 = new HashMap();
      if (jdField_e_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        paramString1.put("first", String.valueOf(i));
        paramString1.put("which", String.valueOf(4));
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianTabOpenCost", true, jdField_c_of_type_Long, 0L, paramString1, null);
        jdField_e_of_type_Boolean = false;
        return;
      }
    }
    if (TextUtils.equals(paramString2, "KANDIAN_NEW_FEEDS_CREATE")) {
      jdField_d_of_type_Long = 0L;
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l));
      return;
      if (TextUtils.equals(paramString2, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE")) {
        jdField_e_of_type_Long = 0L;
      } else if (TextUtils.equals(paramString2, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW")) {
        f = 0L;
      } else if (TextUtils.equals(paramString2, "KANDIAN_FEEDS_STAGE_1_COST")) {
        jdField_a_of_type_Long = 0L;
      } else if (TextUtils.equals(paramString2, "KANDIAN_FEEDS_STAGE_2_COST")) {
        jdField_b_of_type_Long = 0L;
      } else {
        jdField_c_of_type_Long = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicTracker
 * JD-Core Version:    0.7.0.1
 */