package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONArray;
import org.json.JSONObject;

public class RIJStudyModeUtils
{
  public static int a()
  {
    int i = 0;
    if (StudyModeManager.a()) {
      i = 1;
    }
    while (!b()) {
      return i;
    }
    return 2;
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    return localJSONObject.toString();
  }
  
  public static JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Object localObject = (String)ReadInJoyHelper.a("key_study_mode_grade_choose", "");
      QLog.d("RIJStudyModeUtils", 1, "getSelectedGrades error! result= " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONArray((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.d("RIJStudyModeUtils", 1, "getSelectedGrades error! msg= " + localException);
    }
    return localJSONArray;
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ReadInJoyHelper.a("key_study_mode_grade_choose", paramString);
      ReadInJoyLogicEngineEventDispatcher.a().a(new RIJStudyModeUtils.1(paramString));
    }
    QLog.d("RIJStudyModeUtils", 1, "updateSelectedGrades ! res= " + paramString);
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!StudyModeManager.a()) {
      return;
    }
    try
    {
      paramJSONObject.put("study_mode_selected_grade", a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJStudyModeUtils", 1, "addSelectedGrades error! msg= " + paramJSONObject);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(315);
    if (!StudyModeManager.a()) {}
    for (;;)
    {
      QLog.d("RIJStudyModeUtils", 1, "showStudyGradeEntry ! res= " + localAladdinConfig.toString());
      return bool;
      if (localAladdinConfig.getIntegerFromString("study_mode_select_grade_entry_enable", 0) == 1) {
        bool = true;
      }
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
      localReportR5Builder.l();
      localReportR5Builder.m();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", localReportR5Builder.a(), false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("RIJStudyModeUtils", 1, "gradeEntryReport error! e= " + paramString);
    }
  }
  
  public static boolean b()
  {
    return ((Integer)ReadInJoyHelper.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils
 * JD-Core Version:    0.7.0.1
 */