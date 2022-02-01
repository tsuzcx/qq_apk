package c.t.m.g;

import android.os.Build;
import android.os.Build.VERSION;

public final class bq
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public bq()
  {
    try
    {
      this.a = Build.MODEL;
      this.b = Build.VERSION.RELEASE;
      this.c = cn.a();
      this.d = cn.b();
      cn.e();
      this.e = cn.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.bq
 * JD-Core Version:    0.7.0.1
 */