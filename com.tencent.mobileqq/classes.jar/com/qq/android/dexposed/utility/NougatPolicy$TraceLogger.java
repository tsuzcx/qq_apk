package com.qq.android.dexposed.utility;

import android.util.Log;

class NougatPolicy$TraceLogger
{
  static void e(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  static void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.NougatPolicy.TraceLogger
 * JD-Core Version:    0.7.0.1
 */