package com.heytap.mcssdk.f;

import android.util.Log;

public class c
{
  private static String a = "MCS";
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = true;
  private static boolean e = true;
  private static boolean f = true;
  private static String g = "-->";
  private static boolean h = true;
  
  public static void a(String paramString)
  {
    if ((d) && (h))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(g);
      localStringBuilder.append(paramString);
      Log.d("mcssdk---", localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((f) && (h))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(g);
      localStringBuilder.append(paramString2);
      Log.e(paramString1, localStringBuilder.toString());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    h = paramBoolean;
    if (h) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    b = paramBoolean;
    d = paramBoolean;
    c = paramBoolean;
    e = paramBoolean;
    f = paramBoolean;
  }
  
  public static void b(String paramString)
  {
    if ((f) && (h))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(g);
      localStringBuilder.append(paramString);
      Log.e("mcssdk---", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.c
 * JD-Core Version:    0.7.0.1
 */