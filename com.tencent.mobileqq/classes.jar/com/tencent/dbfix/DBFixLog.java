package com.tencent.dbfix;

import android.util.Log;

public class DBFixLog
{
  public static final int USR = 1;
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    Log.d(paramString, localStringBuilder.toString());
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    Log.e(paramString, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dbfix.DBFixLog
 * JD-Core Version:    0.7.0.1
 */