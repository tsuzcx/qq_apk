package c.t.m.g;

final class ae$a
{
  public String a;
  public boolean b = true;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private String[] h;
  
  public ae$a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
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
    String[] arrayOfString = this.h;
    boolean bool1;
    if (arrayOfString.length >= paramInt + 1)
    {
      boolean bool2 = arrayOfString[paramInt].equals(paramString);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.h[paramInt].equals("all"))
        {
          this.b = false;
          return bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ae.a
 * JD-Core Version:    0.7.0.1
 */