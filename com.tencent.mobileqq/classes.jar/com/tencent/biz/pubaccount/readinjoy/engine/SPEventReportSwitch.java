package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReportConditionParam;

public class SPEventReportSwitch
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long;
  private static SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static HashMap<Integer, SPEventReportSwitch.SPEventReportCondition> jdField_a_of_type_JavaUtilHashMap;
  private static int b = -2;
  private static int c = -1;
  private static int d = -2;
  private static int e = -1;
  private static int f = -2;
  private static int g = -1;
  private static int h = -2;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    i = -1;
    j = 30;
    k = -1;
    l = 30;
    m = -1;
    n = 0;
  }
  
  public SPEventReportSwitch()
  {
    jdField_a_of_type_JavaUtilHashMap = (HashMap)RIJSPUtils.a(ReadInJoyUtils.a(), "idle_high_frequency_report_condition", true);
  }
  
  public static int a()
  {
    if (e == -1)
    {
      SharedPreferences localSharedPreferences = ReadInJoyHelper.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (e = f;; e = localSharedPreferences.getInt("kd_tab_click_push_algo_id", f)) {
        return e;
      }
    }
    return e;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == a()) {
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public static void a(List<oidb_cmd0x80a.ReportConditionParam> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    for (int i1 = 1;; i1 = 0)
    {
      int i3 = 0;
      label25:
      label174:
      int i2;
      label129:
      label257:
      int i4;
      if (i3 < paramList.size())
      {
        oidb_cmd0x80a.ReportConditionParam localReportConditionParam = (oidb_cmd0x80a.ReportConditionParam)paramList.get(i3);
        if (!localReportConditionParam.uint32_event_id.has()) {
          break label396;
        }
        SPEventReportSwitch.SPEventReportCondition localSPEventReportCondition = (SPEventReportSwitch.SPEventReportCondition)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localReportConditionParam.uint32_event_id.get()));
        if (localSPEventReportCondition != null) {
          break label393;
        }
        localSPEventReportCondition = new SPEventReportSwitch.SPEventReportCondition();
        SPEventReportSwitch.SPEventReportCondition.access$102(localSPEventReportCondition, new ArrayList());
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localReportConditionParam.uint32_event_id.get()), localSPEventReportCondition);
        i1 = 1;
        boolean bool;
        if ((localReportConditionParam.uint32_report_next_time.has()) && (localReportConditionParam.uint32_report_next_time.get() != 0)) {
          bool = true;
        }
        for (;;)
        {
          if (bool != SPEventReportSwitch.SPEventReportCondition.access$000(localSPEventReportCondition))
          {
            SPEventReportSwitch.SPEventReportCondition.access$002(localSPEventReportCondition, bool);
            i1 = 1;
            i2 = i1;
            if (localReportConditionParam.report_time_seg.has())
            {
              List localList = localReportConditionParam.report_time_seg.get();
              TreeSet localTreeSet = new TreeSet();
              i2 = 0;
              for (;;)
              {
                if (i2 < localList.size())
                {
                  localTreeSet.add(Integer.valueOf(((Long)localList.get(i2)).intValue()));
                  i2 += 1;
                  continue;
                  bool = false;
                  break;
                }
              }
              i2 = 0;
              if (i2 >= SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).size()) {
                break label384;
              }
              if (!((TreeSet)SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).get(i2)).equals(localTreeSet)) {
                break;
              }
              i4 = 1;
              label292:
              i2 = i1;
              if (i4 == 0)
              {
                SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).add(localTreeSet);
                i2 = 1;
              }
            }
            QLog.d("ReadinjoySPEventReport", 2, "update eventID : " + localReportConditionParam.uint32_event_id.get() + ", condition : " + localSPEventReportCondition);
            i1 = i2;
          }
        }
      }
      label384:
      label393:
      label396:
      for (;;)
      {
        i3 += 1;
        break label25;
        i2 += 1;
        break label257;
        if (i1 == 0) {
          break;
        }
        RIJSPUtils.a("idle_high_frequency_report_condition", jdField_a_of_type_JavaUtilHashMap, true);
        return;
        i4 = 0;
        break label292;
        break label174;
        break label129;
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickGapInSeconds");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_gap_in_seconds", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      b = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    boolean bool = true;
    if (m == -1)
    {
      SharedPreferences localSharedPreferences = ReadInJoyHelper.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (m = n; m == 1; m = localSharedPreferences.getInt("kd_user_idle_report", n)) {
        return true;
      }
      return false;
    }
    if (m == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (b(paramInt)) {
      return true;
    }
    if ((jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      return false;
    }
    SPEventReportSwitch.SPEventReportCondition localSPEventReportCondition = (SPEventReportSwitch.SPEventReportCondition)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    boolean bool1 = bool2;
    if (localSPEventReportCondition != null) {
      if (!SPEventReportSwitch.SPEventReportCondition.access$000(localSPEventReportCondition))
      {
        bool1 = bool2;
        if (SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition) == null) {}
      }
      else
      {
        if (!SPEventReportSwitch.SPEventReportCondition.access$000(localSPEventReportCondition)) {
          break label264;
        }
      }
    }
    label258:
    label264:
    for (bool1 = true;; bool1 = false)
    {
      int i1 = Calendar.getInstance().get(11) * 3600 + Calendar.getInstance().get(12) * 60 + Calendar.getInstance().get(13);
      if ((SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition) != null) && (!SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).isEmpty()))
      {
        paramInt = 0;
        while (paramInt < SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).size())
        {
          TreeSet localTreeSet = (TreeSet)SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).get(paramInt);
          Object localObject = (Integer)localTreeSet.floor(Integer.valueOf(i1));
          if (localObject == null) {
            break label258;
          }
          Integer localInteger;
          do
          {
            localTreeSet.remove(localObject);
            localInteger = (Integer)localTreeSet.floor(Integer.valueOf(i1));
            localObject = localInteger;
          } while (localInteger != null);
          if (localTreeSet.size() == 1)
          {
            localTreeSet.clear();
            SPEventReportSwitch.SPEventReportCondition.access$100(localSPEventReportCondition).remove(localTreeSet);
          }
          bool1 = true;
          paramInt += 1;
        }
      }
      for (;;)
      {
        if (bool1) {
          RIJSPUtils.a("idle_high_frequency_report_condition", jdField_a_of_type_JavaUtilHashMap, true);
        }
        return bool1;
        break;
      }
    }
  }
  
  public static int b()
  {
    if (i == -1)
    {
      SharedPreferences localSharedPreferences = ReadInJoyHelper.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (i = j;; i = localSharedPreferences.getInt("kd_fore_ground_gap_in_seconds", j)) {
        return i;
      }
    }
    return i;
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_count_limit", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      c = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  /* Error */
  private static boolean b(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 65	com/tencent/biz/pubaccount/readinjoy/engine/SPEventReportSwitch:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   6: iload_0
    //   7: invokevirtual 306	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 308	java/lang/Boolean
    //   13: ifnonnull +21 -> 34
    //   16: getstatic 65	com/tencent/biz/pubaccount/readinjoy/engine/SPEventReportSwitch:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   19: iload_0
    //   20: iconst_1
    //   21: invokestatic 311	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: invokevirtual 314	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   27: iconst_1
    //   28: istore_1
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_1
    //   36: goto -7 -> 29
    //   39: astore_2
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramInt	int
    //   28	8	1	bool	boolean
    //   39	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	27	39	finally
  }
  
  public static int c()
  {
    if (k == -1)
    {
      SharedPreferences localSharedPreferences = ReadInJoyHelper.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (k = l;; k = localSharedPreferences.getInt("kd_screen_switch_in_seconds", l)) {
        return k;
      }
    }
    return k;
  }
  
  public static void c(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_push_algo_id", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      e = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void d(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_forbid_report_time_in_seconds", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      g = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void e(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_fore_ground_gap_in_seconds", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      i = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void f(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_screen_switch_in_seconds", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      k = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void g(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_user_idle_report", i1);
      ReadInJoyHelper.a(paramAppRuntime, true);
      m = i1;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch
 * JD-Core Version:    0.7.0.1
 */