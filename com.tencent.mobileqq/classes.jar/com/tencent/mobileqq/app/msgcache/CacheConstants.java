package com.tencent.mobileqq.app.msgcache;

public class CacheConstants
{
  protected static int a = 1600;
  public static long a = 60000L;
  public static String a = "sp_msglrucache";
  protected static int b = 1400;
  public static String b = "sp_key_msglrucache_switch";
  public static int c = 1;
  public static String c = "sp_key_cacheinitadjust_switch";
  public static int d = 2;
  public static String d = "sp_key_report_aio_last_time";
  public static int e = 40;
  public static String e = "msglrucacheMoniterLogin";
  public static int f = 20;
  protected static int g = 10;
  protected static int h = 0;
  protected static int i = 5;
  public static int j = -1;
  public static int k = 2;
  public static int l = 1;
  public static int m = 0;
  public static int n = 1;
  public static int o = 100;
  public static int p = 10;
  
  public static int a(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.CacheConstants
 * JD-Core Version:    0.7.0.1
 */