package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

public class BaseForwardUtil
{
  protected static int[] a = { 11, 2 };
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext)
  {
    return (Build.VERSION.SDK_INT < 23) || (paramContext == null) || (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseForwardUtil
 * JD-Core Version:    0.7.0.1
 */