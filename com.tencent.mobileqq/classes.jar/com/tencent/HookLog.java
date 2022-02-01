package com.tencent;

import android.util.Log;

public class HookLog
{
  public static final String TAG = "HookLog";
  
  public static int d(String paramString)
  {
    return Log.d("HookLog", paramString);
  }
  
  public static int e(String paramString)
  {
    return Log.e("HookLog", paramString);
  }
  
  public static int e(String paramString, Throwable paramThrowable)
  {
    return Log.e("HookLog", paramString, paramThrowable);
  }
  
  public static int i(String paramString)
  {
    return Log.i("HookLog", paramString);
  }
  
  public static int v(String paramString)
  {
    return Log.v("HookLog", paramString);
  }
  
  public static int w(String paramString)
  {
    return Log.w("HookLog", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.HookLog
 * JD-Core Version:    0.7.0.1
 */