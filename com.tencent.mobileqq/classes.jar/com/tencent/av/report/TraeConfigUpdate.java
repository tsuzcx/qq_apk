package com.tencent.av.report;

import java.util.HashMap;
import java.util.Map;

public class TraeConfigUpdate
{
  private static volatile TraeConfigUpdate a;
  private Map<String, String> b = new HashMap();
  
  private TraeConfigUpdate()
  {
    this.b.put("request", new String("-1"));
    this.b.put("update", new String("-1"));
    this.b.put("load", new String("-1"));
  }
  
  public static TraeConfigUpdate a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TraeConfigUpdate();
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a(String paramString)
  {
    return (String)this.b.get(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.b.put(paramString, String.valueOf(paramInt));
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