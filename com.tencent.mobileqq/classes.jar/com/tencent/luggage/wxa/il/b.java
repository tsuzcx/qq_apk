package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.content.res.Resources;

public class b
  implements com.tencent.luggage.wxa.im.a
{
  private Context a;
  private final String[] b = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
  private final int[] c = { 2131892607, 2131892606, 2131892610, 2131892603, 2131892611, 2131892609, 2131892608, 2131892604, 2131892614, 2131892613, 2131892612, 2131892605 };
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public String a(String paramString)
  {
    junit.framework.a.a(12, this.b.length);
    junit.framework.a.a(12, this.c.length);
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = this.b;
      if (i >= arrayOfString.length) {
        break;
      }
      if (paramString.equals(arrayOfString[i])) {
        return this.a.getResources().getString(this.c[i]);
      }
      i += 1;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.il.b
 * JD-Core Version:    0.7.0.1
 */