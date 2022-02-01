package com.tencent.biz.qqstory.support.report;

import com.tencent.mobileqq.statistics.ReportController;

public class VideoEditReport
{
  public static String a = "";
  public static String b = "";
  public static int c;
  public static int d;
  
  public static String a(int paramInt)
  {
    String str = "grp_qq_pic_base";
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return "grp_qq_pic_base";
        }
        return "grp_qq_pic_kandian";
      }
      str = "grp_qq_pic_qzone";
    }
    return str;
  }
  
  public static void a(String paramString)
  {
    if (!a()) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, c(), 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (!a()) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, c(), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (b()) {
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, d(), 0, "", "", paramString2, "");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!a()) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, c(), 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  private static boolean a()
  {
    return (a.equals("grp_qq")) || (a.equals("grp_qzone")) || (a.equals("grp_tribe")) || (a.equals("grp_readinjoy"));
  }
  
  public static void b(int paramInt)
  {
    c = paramInt;
  }
  
  public static void b(String paramString)
  {
    a(paramString, "");
  }
  
  public static void b(String paramString, int paramInt)
  {
    if (b()) {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, d(), 0, String.valueOf(paramInt), "", "", "");
    }
  }
  
  private static boolean b()
  {
    return (a.equals("grp_qq_pic_base")) || (a.equals("grp_qq_pic_qzone")) || (a.equals("grp_qq_pic_kandian"));
  }
  
  private static int c()
  {
    if (a.equals("grp_tribe")) {
      return 4;
    }
    if (a.equals("grp_qq")) {
      return 1;
    }
    if (a.equals("grp_readinjoy")) {
      return 5;
    }
    return 2;
  }
  
  public static void c(int paramInt)
  {
    d = paramInt;
  }
  
  private static int d()
  {
    if (a.equalsIgnoreCase("grp_qq_pic_qzone")) {
      return 2;
    }
    if (a.equalsIgnoreCase("grp_qq_pic_kandian")) {
      return 3;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.VideoEditReport
 * JD-Core Version:    0.7.0.1
 */