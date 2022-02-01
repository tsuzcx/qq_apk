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
  public static int a = 1;
  public static String a = "qua_report_current";
  public static boolean a = true;
  public static int b = 2;
  public static String b = "qua_report_exception";
  public static boolean b = false;
  public static int c = 3;
  public static String c = "qav_score_count";
  public static final boolean c;
  public static int d = 4;
  public static String d = "qav_score_begintime";
  public static int e = 5;
  public static String e = "qav_score_endtime";
  public static int f = 6;
  public static String f = "qav_sdk_version";
  public static String g = "qav_peer_sdk_version";
  public static String h = "qav_ip";
  public static String i = "qav_business_type";
  public static String j = "qav_business_flag";
  public static String k = "qav_touin";
  public static String l = "qav_commited";
  
  static
  {
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("OXF-AN10")) && (!Build.MODEL.equalsIgnoreCase("OXF-AN00")) && (!Build.MODEL.equalsIgnoreCase("OXP-AN00")) && (!Build.MODEL.equalsIgnoreCase("MI 9 SE")) && (!Build.MODEL.equalsIgnoreCase("Mi 10")) && (!Build.MODEL.equalsIgnoreCase("PBAM00")) && (!Build.MODEL.equalsIgnoreCase("PACM00")) && (!Build.MODEL.equalsIgnoreCase("ART-AL00x")) && (!Build.MODEL.equalsIgnoreCase("YAL-AL50")) && (!Build.MODEL.equalsIgnoreCase("SPN-AL00")) && (!Build.MODEL.equalsIgnoreCase("RMX2111")) && (!Build.MODEL.equalsIgnoreCase("JEF-AN00")) && (!Build.MODEL.equalsIgnoreCase("YAL-AL00")) && (!Build.MODEL.equalsIgnoreCase("PDVM00")) && (!Build.MODEL.equalsIgnoreCase("ONEPLUS A6000"))) {
      bool = false;
    } else {
      bool = true;
    }
    c = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoConstants
 * JD-Core Version:    0.7.0.1
 */