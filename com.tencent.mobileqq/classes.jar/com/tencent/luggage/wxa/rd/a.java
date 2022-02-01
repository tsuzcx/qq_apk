package com.tencent.luggage.wxa.rd;

import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

@Deprecated
public class a
{
  public static final a a = new a();
  
  @Deprecated
  public static void a(Runnable paramRunnable, String paramString, int paramInt)
  {
    a.a(paramRunnable, paramString);
  }
  
  @Deprecated
  public static void b(Runnable paramRunnable, String paramString)
  {
    a.a(paramRunnable, paramString);
  }
  
  @Deprecated
  public void a(Runnable paramRunnable, String paramString)
  {
    if ((!b) && (paramRunnable == null)) {
      throw new AssertionError();
    }
    f.a.c(new a.1(this, paramString, paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rd.a
 * JD-Core Version:    0.7.0.1
 */