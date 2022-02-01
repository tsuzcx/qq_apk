package com.tencent.acstat.a.a;

import android.content.Context;

public class c
{
  private static Context a;
  private static volatile c b;
  
  private c(Context paramContext)
  {
    a = paramContext.getApplicationContext();
  }
  
  public static c a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new c(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public String a()
  {
    return h.a(a).a().c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.a.a.c
 * JD-Core Version:    0.7.0.1
 */