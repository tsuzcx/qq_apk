package com.tencent.biz.qqstory.support.report;

import com.tencent.mobileqq.statistics.ReportController;

public class VideoEditReport
{
  public static int a = 0;
  public static String a = "";
  public static int b = 0;
  public static String b = "";
  
  private static int a()
  {
    if (jdField_a_of_type_JavaLangString.equals("grp_tribe")) {
      return 4;
    }
    if (jdField_a_of_type_JavaLangString.equals("grp_qq")) {
      return 1;
    }
    if (jdField_a_of_type_JavaLangString.equals("grp_readinjoy")) {
      return 5;
    }
    return 2;
  }
  
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
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(String paramString)
  {
    if (!a()) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, a(), 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (!a()) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, a(), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (b()) {
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, b(), 0, "", "", paramString2, "");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!a()) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, a(), 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  private static boolean a()
  {
    return (jdField_a_of_type_JavaLangString.equals("grp_qq")) || (jdField_a_of_type_JavaLangString.equals("grp_qzone")) || (jdField_a_of_type_JavaLangString.equals("grp_tribe")) || (jdField_a_of_type_JavaLangString.equals("grp_readinjoy"));
  }
  
  private static int b()
  {
    if (jdField_a_of_type_JavaLangString.equalsIgnoreCase("grp_qq_pic_qzone")) {
      return 2;
    }
    if (jdField_a_of_type_JavaLangString.equalsIgnoreCase("grp_qq_pic_kandian")) {
      return 3;
    }
    return 1;
  }
  
  public static void b(int paramInt)
  {
    b = paramInt;
  }
  
  public static void b(String paramString)
  {
    a(paramString, "");
  }
  
  public static void b(String paramString, int paramInt)
  {
    if (b()) {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, b(), 0, String.valueOf(paramInt), "", "", "");
    }
  }
  
  private static boolean b()
  {
    return (jdField_a_of_type_JavaLangString.equals("grp_qq_pic_base")) || (jdField_a_of_type_JavaLangString.equals("grp_qq_pic_qzone")) || (jdField_a_of_type_JavaLangString.equals("grp_qq_pic_kandian"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.VideoEditReport
 * JD-Core Version:    0.7.0.1
 */