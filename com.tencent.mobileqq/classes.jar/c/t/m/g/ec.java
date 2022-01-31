package c.t.m.g;

import android.os.Bundle;

public abstract class ec
{
  private String a;
  private String b;
  private boolean c;
  
  public ec(String paramString1, String paramString2)
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
    return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ec
 * JD-Core Version:    0.7.0.1
 */