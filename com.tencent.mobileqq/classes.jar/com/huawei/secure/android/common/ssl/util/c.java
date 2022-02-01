package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

public class c
{
  private static Context u;
  
  public static Context k()
  {
    return u;
  }
  
  public static void setContext(Context paramContext)
  {
    if ((paramContext != null) && (u == null)) {
      u = paramContext.getApplicationContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.c
 * JD-Core Version:    0.7.0.1
 */