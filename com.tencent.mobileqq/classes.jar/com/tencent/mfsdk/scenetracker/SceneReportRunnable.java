package com.tencent.mfsdk.scenetracker;

import abwd;
import abwg;
import abwl;
import abwn;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class SceneReportRunnable
  implements Runnable
{
  private static volatile SceneReportRunnable jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable;
  public static String a;
  private static final String b;
  private long jdField_a_of_type_Long;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA);
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "SceneReportRunnable";
    jdField_b_of_type_JavaLangString = "APM_Resource_" + MagnifierSDK.a() + "_";
  }
  
  public static SceneReportRunnable a(String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable == null) {
        jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable = new SceneReportRunnable();
      }
      if (jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable.c == null) {
        jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable.c = paramString;
      }
      return jdField_a_of_type_ComTencentMfsdkScenetrackerSceneReportRunnable;
    }
    finally {}
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 5000L) {}
    Object localObject4;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = l;
      localObject4 = (Vector)abwd.a.clone();
      localObject2 = (Vector)abwd.b.clone();
      abwd.a.clear();
      abwd.b.clear();
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("p_id", MagnifierSDK.jdField_a_of_type_Int);
        localJSONObject1.put("version", MagnifierSDK.jdField_a_of_type_JavaLangString);
        localJSONObject1.put("uin", String.valueOf(MagnifierSDK.jdField_a_of_type_Long));
        localJSONObject1.put("manu", Build.MANUFACTURER);
        localJSONObject1.put("device", Build.MODEL);
        localJSONObject1.put("os", Build.VERSION.RELEASE);
        localJSONObject1.put("rdmuuid", ReporterMachine.a().a());
        localJSONObject1.put("plugin", 138);
        localJSONObject1.put("deviceid", abwn.a(BaseApplicationImpl.sApplication));
        localJSONObject1.put("zone", "default");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("p_id", "1");
        ((JSONObject)localObject1).put("plugin", 138);
        localJSONObject1.put("clientinfo", localObject1);
        localObject3 = new JSONArray();
        localObject1 = new JSONArray();
        localObject4 = ((Vector)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          abwg localabwg = (abwg)((Iterator)localObject4).next();
          if (!Double.isNaN(localabwg.jdField_a_of_type_Long))
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("event_time", localabwg.jdField_a_of_type_Long);
            localJSONObject2.put("process_name", this.c);
            localJSONObject2.put("stage", localabwg.jdField_a_of_type_JavaLangString);
            localJSONObject2.put("sub_stage", "");
            JSONObject localJSONObject3;
            if ((9223372036854775807L != localabwg.c) || (9223372036854775807L != localabwg.d) || (!Double.isNaN(localabwg.jdField_a_of_type_Double)) || (!Double.isNaN(localabwg.jdField_b_of_type_Double)))
            {
              localJSONObject3 = new JSONObject();
              if (9223372036854775807L != localabwg.c) {
                localJSONObject3.put("app_jiffies", localabwg.c);
              }
              if (9223372036854775807L != localabwg.d) {
                localJSONObject3.put("sys_jiffies", localabwg.d);
              }
              if (!Double.isNaN(localabwg.jdField_a_of_type_Double)) {
                localJSONObject3.put("cpu_rate", localabwg.jdField_a_of_type_Double);
              }
              if (!Double.isNaN(localabwg.jdField_b_of_type_Double)) {
                localJSONObject3.put("sys_cpu_rate", localabwg.jdField_b_of_type_Double);
              }
              localJSONObject2.put("cpu", localJSONObject3);
            }
            if (9223372036854775807L != localabwg.jdField_b_of_type_Long)
            {
              localJSONObject3 = new JSONObject();
              if (9223372036854775807L != localabwg.jdField_b_of_type_Long) {
                localJSONObject3.put("mem_used", localabwg.jdField_b_of_type_Long);
              }
              localJSONObject2.put("memory", localJSONObject3);
            }
            ((JSONArray)localObject3).put(localJSONObject2);
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception localException) {}
    }
    QLog.e(jdField_a_of_type_JavaLangString, 0, "", localException);
    return;
    localException.put("immediates", localObject3);
    Object localObject2 = ((Vector)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (abwl)((Iterator)localObject2).next();
      if ((!Double.isNaN(((abwl)localObject3).jdField_a_of_type_Double)) && (((abwl)localObject3).jdField_a_of_type_Long != 9223372036854775807L))
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("event_time", ((abwl)localObject3).jdField_a_of_type_Double);
        ((JSONObject)localObject4).put("tag_id", ((abwl)localObject3).jdField_a_of_type_Long);
        if (!Double.isNaN(((abwl)localObject3).jdField_b_of_type_Double)) {
          ((JSONObject)localObject4).put("during_time", ((abwl)localObject3).jdField_b_of_type_Double);
        }
        ((JSONObject)localObject4).put("type", ((abwl)localObject3).jdField_a_of_type_Int);
        ((JSONObject)localObject4).put("stage", ((abwl)localObject3).jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject4).put("sub_stage", ((abwl)localObject3).jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject4).put("extra_info", ((abwl)localObject3).c);
        ((JSONObject)localObject4).put("process_name", this.c);
        ((JSONArray)localObject1).put(localObject4);
      }
    }
    localException.put("manu_tags", localObject1);
    ReporterMachine.a(new ResultObject(0, "sample", true, 1L, 1L, localException, true, false, MagnifierSDK.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.scenetracker.SceneReportRunnable
 * JD-Core Version:    0.7.0.1
 */