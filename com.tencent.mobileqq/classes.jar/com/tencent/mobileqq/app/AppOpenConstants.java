package com.tencent.mobileqq.app;

import android.os.Environment;
import java.io.File;

public abstract interface AppOpenConstants
{
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e = String.valueOf(9913L);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/DCIM/Camera/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/Tencent/QQ_Images/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/DCIM/");
    d = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.AppOpenConstants
 * JD-Core Version:    0.7.0.1
 */