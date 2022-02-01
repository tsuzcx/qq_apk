package com.tencent.avgame.report;

import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;

public class CJSurvivalReporterUtil
{
  private static int jdField_a_of_type_Int = 0;
  private static CJSurvivalReporterUtil jdField_a_of_type_ComTencentAvgameReportCJSurvivalReporterUtil;
  private static String jdField_a_of_type_JavaLangString = "0";
  
  public static CJSurvivalReporterUtil a()
  {
    if (jdField_a_of_type_ComTencentAvgameReportCJSurvivalReporterUtil == null) {
      jdField_a_of_type_ComTencentAvgameReportCJSurvivalReporterUtil = new CJSurvivalReporterUtil();
    }
    return jdField_a_of_type_ComTencentAvgameReportCJSurvivalReporterUtil;
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public int a(EngineData paramEngineData)
  {
    switch (paramEngineData.o())
    {
    case 6: 
    case 7: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    case 9: 
    case 10: 
      return 2;
    }
    return 1;
  }
  
  public String a()
  {
    if (jdField_a_of_type_Int == 3) {
      return jdField_a_of_type_JavaLangString;
    }
    return "0";
  }
  
  public String a(EngineData paramEngineData)
  {
    if (paramEngineData.a().a != null) {
      return String.valueOf(paramEngineData.a().a.a());
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      paramString = "0";
    }
    jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.CJSurvivalReporterUtil
 * JD-Core Version:    0.7.0.1
 */