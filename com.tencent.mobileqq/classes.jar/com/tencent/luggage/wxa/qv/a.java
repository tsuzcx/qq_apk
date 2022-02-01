package com.tencent.luggage.wxa.qv;

import android.os.Build;
import android.os.Build.VERSION;

@Deprecated
public final class a
{
  public static String a;
  public static final String b;
  public static final String c;
  public static String d;
  public static final String e;
  public static String f;
  public static final String g;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android-");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    a = localStringBuilder.toString();
    b = Build.BRAND;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(Build.CPU_ABI);
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("android-");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("android-");
    localStringBuilder.append(Build.MANUFACTURER);
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.MODEL);
    g = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qv.a
 * JD-Core Version:    0.7.0.1
 */