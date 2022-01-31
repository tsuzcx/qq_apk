package com.tencent.av.report;

import java.util.HashMap;
import java.util.Map;

public class TraeConfigUpdate
{
  private static volatile TraeConfigUpdate jdField_a_of_type_ComTencentAvReportTraeConfigUpdate;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private TraeConfigUpdate()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static TraeConfigUpdate a()
  {
    if (jdField_a_of_type_ComTencentAvReportTraeConfigUpdate == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvReportTraeConfigUpdate == null) {
        jdField_a_of_type_ComTencentAvReportTraeConfigUpdate = new TraeConfigUpdate();
      }
      return jdField_a_of_type_ComTencentAvReportTraeConfigUpdate;
    }
    finally {}
  }
  
  private String a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if (paramString1.equals("request")) {
      localStringBuffer.append("|").append(paramString1).append("_").append(paramString2).append("|");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(paramString1).append("_").append(paramString2).append("|");
    }
  }
  
  private String b()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append(a("request", (String)this.jdField_a_of_type_JavaUtilMap.get("request")));
    localStringBuffer.append(a("update", (String)this.jdField_a_of_type_JavaUtilMap.get("update")));
    localStringBuffer.append(a("load", (String)this.jdField_a_of_type_JavaUtilMap.get("load")));
    return localStringBuffer.toString();
  }
  
  public String a()
  {
    return b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.report.TraeConfigUpdate
 * JD-Core Version:    0.7.0.1
 */