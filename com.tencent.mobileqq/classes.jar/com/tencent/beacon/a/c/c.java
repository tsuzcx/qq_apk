package com.tencent.beacon.a.c;

import android.content.Context;

public final class c
  implements f
{
  private final Context a;
  private final String b;
  private final String c;
  private String d = null;
  
  public c(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public final String a()
  {
    if (this.d != null) {
      return this.d;
    }
    this.d = com.tencent.beacon.a.a.c.a(this.a).a("QIMEI_DENGTA", "");
    int i;
    if ("".equals(this.d))
    {
      str = this.b;
      if ((str != null) && (!str.equals(""))) {
        break label81;
      }
      i = 1;
      if (i == 0) {
        break label86;
      }
    }
    label81:
    label86:
    for (String str = this.c;; str = this.b)
    {
      this.d = str;
      return this.d;
      i = 0;
      break;
    }
  }
  
  public final void a(byte[] paramArrayOfByte) {}
  
  public final void a_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.c.c
 * JD-Core Version:    0.7.0.1
 */