package com.tencent.av.report;

import java.util.HashMap;
import java.util.Map;

public class TraeConfigUpdate
{
  private static volatile TraeConfigUpdate jdField_a_of_type_ComTencentAvReportTraeConfigUpdate;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private TraeConfigUpdate()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static TraeConfigUpdate a()
  {
    if (jdField_a_of_type_ComTencentAvReportTraeConfigUpdate == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvReportTraeConfigUpdate == null) {
          jdField_a_of_type_ComTencentAvReportTraeConfigUpdate = new TraeConfigUpdate();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvReportTraeConfigUpdate;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramInt));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.TraeConfigUpdate
 * JD-Core Version:    0.7.0.1
 */