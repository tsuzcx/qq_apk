package com.tencent.featuretoggle;

public class Constants
{
  private static String a;
  
  public static String a()
  {
    String str = a;
    if ((str == null) || (!str.contains(ToggleSetting.y()))) {
      a = String.format("%s%s%s", new Object[] { d(), ToggleSetting.y(), "/feature-result" });
    }
    return a;
  }
  
  public static String b()
  {
    return String.format("%s%s", new Object[] { d(), "product-set" });
  }
  
  public static String c()
  {
    if (ToggleSetting.q()) {
      return "https://togglestatdev.sparta.html5.qq.com/report/feature-trigger-event";
    }
    return "https://event.toggle.qq.com/report/feature-trigger-event";
  }
  
  private static String d()
  {
    if (ToggleSetting.q()) {
      return "https://toggleaccesspre.sparta.html5.qq.com/";
    }
    return "https://access.toggle.qq.com/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.Constants
 * JD-Core Version:    0.7.0.1
 */