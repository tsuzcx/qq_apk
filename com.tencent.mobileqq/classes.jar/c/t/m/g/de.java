package c.t.m.g;

import android.os.Bundle;

public abstract class de
{
  private String a;
  private String b;
  private boolean c;
  
  public de(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true;
  }
  
  public void a() {}
  
  protected abstract boolean a(Bundle paramBundle);
  
  public final boolean b(Bundle paramBundle)
  {
    if (!this.c) {
      return false;
    }
    return a(paramBundle);
  }
  
  public String toString()
  {
    return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.de
 * JD-Core Version:    0.7.0.1
 */