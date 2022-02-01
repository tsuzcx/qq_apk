package com.tencent.luggage.wxa.hd;

import android.os.Build;
import com.tencent.luggage.wxa.qz.af;

public final class c
{
  private static final c.b a = new c.5(new c.1("a", 5));
  private static final c.b b = new c.6(new c.d("c", 5));
  private static final c.b c = new c.7(new c.d("d", 5));
  private static final c.b d = new c.8(new c.d("e", 5));
  private static final c.b e = new c.10(new c.9("f", 5));
  private static final c.b f = new c.11(new c.d("g", 5));
  private static final c.b g = new c.12(new c.d("h", 5));
  private static final c.b h = new c.2(new c.d("i", 5));
  private static final c.b i = new c.4(new c.3("j", 5));
  
  public static String a()
  {
    return af.b(g.a());
  }
  
  public static String a(boolean paramBoolean)
  {
    String str = a.d();
    if (!af.c(str)) {
      return str;
    }
    if (paramBoolean) {
      return "1234567890ABCDEF";
    }
    return "";
  }
  
  public static String b()
  {
    return af.b(e.d());
  }
  
  public static String c()
  {
    return af.b(f.d());
  }
  
  public static boolean d()
  {
    String str = Build.CPU_ABI;
    return ("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c
 * JD-Core Version:    0.7.0.1
 */