package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

public class c
{
  private static Context a;
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      a = paramContext.getApplicationContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.c
 * JD-Core Version:    0.7.0.1
 */