package com.tencent.mobileqq.app.msgcache;

public class CacheConstants
{
  public static String a = "sp_msglrucache";
  public static String b = "sp_key_msglrucache_switch";
  public static String c = "sp_key_cacheinitadjust_switch";
  public static String d = "sp_key_report_aio_last_time";
  protected static int e = 1600;
  protected static int f = 1400;
  public static int g = 1;
  public static int h = 2;
  public static int i = 40;
  public static int j = 20;
  protected static int k = 10;
  protected static int l = 0;
  protected static int m = 5;
  public static int n = -1;
  public static int o = 2;
  public static int p = 1;
  public static int q = 0;
  public static int r = 1;
  public static String s = "msglrucacheMoniterLogin";
  public static int t = 100;
  public static int u = 10;
  public static long v = 60000L;
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("&")) {
        str = paramString.split("&")[0];
      }
    }
    return str;
  }
  
  public static int b(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.contains("&"))
        {
          paramString = paramString.split("&");
          if (paramString.length >= 2)
          {
            int i1 = Integer.valueOf(paramString[1]).intValue();
            return i1;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.CacheConstants
 * JD-Core Version:    0.7.0.1
 */