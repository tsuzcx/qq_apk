package com.tencent.map.sdk.a;

final class ax$a
{
  public String a;
  public boolean b = true;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private String[] h;
  
  public ax$a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    paramString1 = paramString1.split("-");
    if (paramString1.length < 5)
    {
      this.h = new String[] { "all", "all", "all", "all", "all" };
      int i = 0;
      while (i < paramString1.length)
      {
        this.h[i] = paramString1[i];
        i += 1;
      }
    }
    this.h = paramString1;
    this.c = a(0, String.valueOf(paramInt));
    this.d = a(1, paramString2);
    this.e = a(2, paramString3);
    this.f = a(3, paramString4);
    this.g = a(4, paramString5);
    this.h = null;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.h.length >= paramInt + 1)
    {
      boolean bool = this.h[paramInt].equals(paramString);
      if ((!bool) && (!this.h[paramInt].equals("all"))) {
        this.b = false;
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ax.a
 * JD-Core Version:    0.7.0.1
 */