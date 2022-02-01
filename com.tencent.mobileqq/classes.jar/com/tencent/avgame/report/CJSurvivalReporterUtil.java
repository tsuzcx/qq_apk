package com.tencent.avgame.report;

import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;

public class CJSurvivalReporterUtil
{
  private static int a = 0;
  private static String b = "0";
  private static CJSurvivalReporterUtil c;
  
  public static CJSurvivalReporterUtil a()
  {
    if (c == null) {
      c = new CJSurvivalReporterUtil();
    }
    return c;
  }
  
  public int a(EngineData paramEngineData)
  {
    switch (paramEngineData.X())
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
  
  public void a(int paramInt)
  {
    a = paramInt;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      paramString = "0";
    }
    b = paramString;
  }
  
  public String b()
  {
    if (a == 3) {
      return b;
    }
    return "0";
  }
  
  public String b(EngineData paramEngineData)
  {
    if (paramEngineData.h().a != null) {
      return String.valueOf(paramEngineData.h().a.a());
    }
    return "";
  }
  
  public int c()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.CJSurvivalReporterUtil
 * JD-Core Version:    0.7.0.1
 */