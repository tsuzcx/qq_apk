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
  public static boolean a = true;
  public static boolean b = false;
  public static String c = "qua_report_current";
  public static String d = "qua_report_exception";
  public static int e = 1;
  public static int f = 2;
  public static int g = 3;
  public static int h = 4;
  public static int i = 5;
  public static int j = 6;
  public static String k = "qav_score_count";
  public static String l = "qav_score_begintime";
  public static String m = "qav_score_endtime";
  public static String n = "qav_sdk_version";
  public static String o = "qav_peer_sdk_version";
  public static String p = "qav_ip";
  public static String q = "qav_business_type";
  public static String r = "qav_business_flag";
  public static String s = "qav_touin";
  public static String t = "qav_commited";
  public static int u = 36;
  public static int v = 20;
  public static int w = 24;
  public static int x = 71;
  public static final boolean y;
  
  static
  {
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("OXF-AN10")) && (!Build.MODEL.equalsIgnoreCase("OXF-AN00")) && (!Build.MODEL.equalsIgnoreCase("OXP-AN00")) && (!Build.MODEL.equalsIgnoreCase("MI 9 SE")) && (!Build.MODEL.equalsIgnoreCase("Mi 10")) && (!Build.MODEL.equalsIgnoreCase("PBAM00")) && (!Build.MODEL.equalsIgnoreCase("PACM00")) && (!Build.MODEL.equalsIgnoreCase("ART-AL00x")) && (!Build.MODEL.equalsIgnoreCase("YAL-AL50")) && (!Build.MODEL.equalsIgnoreCase("SPN-AL00")) && (!Build.MODEL.equalsIgnoreCase("RMX2111")) && (!Build.MODEL.equalsIgnoreCase("JEF-AN00")) && (!Build.MODEL.equalsIgnoreCase("YAL-AL00")) && (!Build.MODEL.equalsIgnoreCase("PDVM00")) && (!Build.MODEL.equalsIgnoreCase("ONEPLUS A6000"))) {
      bool = false;
    } else {
      bool = true;
    }
    y = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoConstants
 * JD-Core Version:    0.7.0.1
 */