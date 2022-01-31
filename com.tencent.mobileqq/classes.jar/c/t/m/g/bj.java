package c.t.m.g;

import android.os.Build;
import android.os.Build.VERSION;

public final class bj
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public bj()
  {
    try
    {
      this.a = Build.MODEL;
      this.b = Build.VERSION.RELEASE;
      this.c = ch.a();
      this.d = ch.b();
      ch.e();
      this.e = ch.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bj
 * JD-Core Version:    0.7.0.1
 */