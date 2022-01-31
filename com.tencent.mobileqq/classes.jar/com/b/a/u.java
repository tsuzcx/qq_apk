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
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label154;
      }
      if (paramVarArgs[i].getClass().equals(u.class)) {
        break label147;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label147:
    label154:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i += 1;
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.b.a.u
 * JD-Core Version:    0.7.0.1
 */