package com.b.a;

import android.util.Log;
import java.util.Locale;

public class u
{
  public static boolean a = Log.isLoggable("Volley", 2);
  private static String b = "Volley";
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a) {
      Log.v(b, d(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(b, d(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    Log.d(b, d(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    Log.e(b, d(paramString, paramVarArgs));
  }
  
  private static String d(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      paramString = String.format(Locale.US, paramString, paramVarArgs);
    }
    paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
    int i = 2;
    while (i < paramVarArgs.length)
    {
      if (!paramVarArgs[i].getClass().equals(u.class))
      {
        String str = paramVarArgs[i].getClassName();
        str = str.substring(str.lastIndexOf('.') + 1);
        str = str.substring(str.lastIndexOf('$') + 1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(".");
        localStringBuilder.append(paramVarArgs[i].getMethodName());
        paramVarArgs = localStringBuilder.toString();
        break label140;
      }
      i += 1;
    }
    paramVarArgs = "<unknown>";
    label140:
    return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.u
 * JD-Core Version:    0.7.0.1
 */