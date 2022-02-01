package com.tencent.mobileqq.app;

import android.os.Environment;
import java.io.File;

public abstract interface AppOpenConstants
{
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static final String b = a + "/DCIM/Camera/";
  public static final String c = a + "/Tencent/QQ_Images/";
  public static final String d = String.valueOf(9913L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.AppOpenConstants
 * JD-Core Version:    0.7.0.1
 */