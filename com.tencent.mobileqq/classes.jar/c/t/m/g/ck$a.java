package c.t.m.g;

import android.os.Bundle;

public final class ck$a
{
  public String a;
  public boolean b = false;
  public boolean c = false;
  public String d = "";
  public Bundle e;
  private int f;
  
  public ck$a(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, Bundle paramBundle)
  {
    this.f = paramInt;
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString2;
    this.e = paramBundle;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("appid:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ck.a
 * JD-Core Version:    0.7.0.1
 */