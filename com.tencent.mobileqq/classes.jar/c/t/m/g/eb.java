package c.t.m.g;

import android.os.Bundle;

public abstract class eb
{
  private String a;
  private String b;
  private boolean c;
  
  public eb(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true;
  }
  
  public void a() {}
  
  public final boolean a(Bundle paramBundle)
  {
    if (!this.c) {
      return false;
    }
    return b(paramBundle);
  }
  
  protected abstract boolean b(Bundle paramBundle);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",desc=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",enabled=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eb
 * JD-Core Version:    0.7.0.1
 */