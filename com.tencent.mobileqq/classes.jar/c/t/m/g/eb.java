package c.t.m.g;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;

public final class eb
{
  private long A = 30000L;
  private String B = "6.0.5.4";
  private String C = "200210";
  private String D = this.B;
  public int a;
  String b;
  String c;
  public String d;
  String e;
  public String f;
  public String g;
  public String h;
  int i;
  public String j;
  public long k;
  boolean l = true;
  boolean m = true;
  boolean n = true;
  public int o = -2;
  public Pair<String, String> p;
  private final ea q;
  private String r;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private long z = 20000L;
  
  eb(ea paramea)
  {
    this.q = paramea;
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.e.contains("0000")) || (Build.VERSION.SDK_INT >= 29)) {
      return "0123456789ABCDEF";
    }
    return this.e;
  }
  
  public final String d()
  {
    if (this.B == null) {
      return "None";
    }
    return this.B;
  }
  
  public final String e()
  {
    if (this.C == null) {
      return "None";
    }
    return this.C;
  }
  
  public final String f()
  {
    if (this.r == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
      this.r = co.d(localStringBuilder.toString());
    }
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eb
 * JD-Core Version:    0.7.0.1
 */