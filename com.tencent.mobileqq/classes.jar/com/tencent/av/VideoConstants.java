package com.tencent.av;

import android.os.Build;
import com.tencent.av.app.DeprecatedClass.VideoConstants;
import com.tencent.avcore.engine.dav.DavClosedReason;
import com.tencent.avcore.engine.dav.DavRejectReason;
import com.tencent.avcore.util.AVConstants;

public class VideoConstants
  extends DeprecatedClass.VideoConstants
  implements DavClosedReason, DavRejectReason, AVConstants
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
    boolean bool = false;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
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
    if ((Build.MODEL.equalsIgnoreCase("OXF-AN10")) || (Build.MODEL.equalsIgnoreCase("OXF-AN00")) || (Build.MODEL.equalsIgnoreCase("OXP-AN00")) || (Build.MODEL.equalsIgnoreCase("MI 9 SE")) || (Build.MODEL.equalsIgnoreCase("Mi 10")) || (Build.MODEL.equalsIgnoreCase("PBAM00")) || (Build.MODEL.equalsIgnoreCase("PACM00")) || (Build.MODEL.equalsIgnoreCase("ART-AL00x")) || (Build.MODEL.equalsIgnoreCase("YAL-AL50")) || (Build.MODEL.equalsIgnoreCase("SPN-AL00")) || (Build.MODEL.equalsIgnoreCase("RMX2111")) || (Build.MODEL.equalsIgnoreCase("JEF-AN00")) || (Build.MODEL.equalsIgnoreCase("YAL-AL00")) || (Build.MODEL.equalsIgnoreCase("PDVM00")) || (Build.MODEL.equalsIgnoreCase("ONEPLUS A6000"))) {
      bool = true;
    }
    jdField_c_of_type_Boolean = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoConstants
 * JD-Core Version:    0.7.0.1
 */