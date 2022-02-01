package com.tencent.mobileqq.ar;

import java.util.HashMap;

public class ReportUtil
{
  public static HashMap<String, GapDataCollector> a = new HashMap();
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static int f;
  private static int g = 5;
  private static int h = 1;
  private static boolean i = false;
  private static boolean j = false;
  
  static
  {
    b = "";
    c = "";
    d = "";
    e = "";
    f = 0;
    a.put("recogQ3", new GapDataCollector(2147483647));
    a.put("recogQ4", new GapDataCollector(2147483647));
    a.put("recogQ5", new GapDataCollector(2147483647));
    a.put("trackQ3", new GapDataCollector(2147483647));
    a.put("trackQ4", new GapDataCollector(2147483647));
    a.put("trackQ5", new GapDataCollector(2147483647));
    a.put("renderQ1", new GapDataCollector(2147483647));
    a.put("renderQ0", new GapDataCollector(2147483647));
    a.put("glRenderQ1", new GapDataCollector(2147483647));
    a.put("glRenderQ0", new GapDataCollector(2147483647));
    a.put("camRenderQ0", new GapDataCollector(2147483647));
    a.put("modelRenderQ1", new GapDataCollector(2147483647));
    a.put("modelRenderQ0", new GapDataCollector(2147483647));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ReportUtil
 * JD-Core Version:    0.7.0.1
 */