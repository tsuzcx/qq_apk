package c.t.m.g;

import android.os.Build.VERSION;

public final class cx
{
  public static volatile String a = "";
  
  public static String a()
  {
    return dz.a();
  }
  
  public static String b()
  {
    return dz.d();
  }
  
  public static String c()
  {
    return dz.b();
  }
  
  public static String d()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    return dz.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.cx
 * JD-Core Version:    0.7.0.1
 */