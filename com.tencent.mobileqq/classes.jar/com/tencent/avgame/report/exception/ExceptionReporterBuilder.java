package com.tencent.avgame.report.exception;

import java.util.HashMap;

public class ExceptionReporterBuilder
{
  private HashMap<String, String> a = new HashMap(10);
  
  protected ExceptionReporterBuilder a(int paramInt)
  {
    this.a.put("type", String.valueOf(paramInt));
    return this;
  }
  
  protected ExceptionReporterBuilder a(int paramInt, String paramString)
  {
    if (paramInt >= 1)
    {
      if (paramInt > 9) {
        return this;
      }
      HashMap localHashMap = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ext");
      localStringBuilder.append(String.valueOf(paramInt));
      localHashMap.put(localStringBuilder.toString(), paramString);
    }
    return this;
  }
  
  protected HashMap<String, String> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.exception.ExceptionReporterBuilder
 * JD-Core Version:    0.7.0.1
 */