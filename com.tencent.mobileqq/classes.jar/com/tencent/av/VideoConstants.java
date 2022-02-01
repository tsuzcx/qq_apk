package com.tencent.av;

import android.os.Build;
import ldo;

public class VideoConstants
  extends ldo
{
  public static int a;
  public static String a;
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static final boolean c;
  public static int d;
  public static String d;
  public static int e;
  public static String e;
  public static int f;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  
  static
  {
    boolean bool2 = true;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = "qua_report_current";
    jdField_b_of_type_JavaLangString = "qua_report_exception";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
    jdField_f_of_type_Int = 6;
    jdField_c_of_type_JavaLangString = "qav_score_count";
    jdField_d_of_type_JavaLangString = "qav_score_begintime";
    jdField_e_of_type_JavaLangString = "qav_score_endtime";
    jdField_f_of_type_JavaLangString = "qav_sdk_version";
    g = "qav_peer_sdk_version";
    h = "qav_ip";
    i = "qav_business_type";
    j = "qav_business_flag";
    k = "qav_touin";
    l = "qav_commited";
    boolean bool1 = bool2;
    if (!Build.MODEL.equalsIgnoreCase("OXF-AN10"))
    {
      bool1 = bool2;
      if (!Build.MODEL.equalsIgnoreCase("OXF-AN00"))
      {
        bool1 = bool2;
        if (!Build.MODEL.equalsIgnoreCase("OXP-AN00"))
        {
          bool1 = bool2;
          if (!Build.MODEL.equalsIgnoreCase("MI 9 SE"))
          {
            bool1 = bool2;
            if (!Build.MODEL.equalsIgnoreCase("Mi 10"))
            {
              bool1 = bool2;
              if (!Build.MODEL.equalsIgnoreCase("PBAM00")) {
                if (!Build.MODEL.equalsIgnoreCase("PACM00")) {
                  break label187;
                }
              }
            }
          }
        }
      }
    }
    label187:
    for (bool1 = bool2;; bool1 = false)
    {
      jdField_c_of_type_Boolean = bool1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoConstants
 * JD-Core Version:    0.7.0.1
 */