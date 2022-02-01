package com.tencent.luggage.wxa.f;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class g
  implements n
{
  public static final g a = new g();
  private String b = "camera";
  private int c = 4;
  
  public static g a()
  {
    return a;
  }
  
  private String a(String paramString)
  {
    Object localObject = paramString;
    if (this.b != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private static String a(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\n');
    localStringBuilder.append(a(paramThrowable));
    return localStringBuilder.toString();
  }
  
  private static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    Log.println(paramInt, a(paramString1), paramString2);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.println(paramInt, a(paramString1), a(paramString2, paramThrowable));
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public boolean a(int paramInt)
  {
    return this.c <= paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.g
 * JD-Core Version:    0.7.0.1
 */