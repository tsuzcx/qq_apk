package c.t.m.g;

import android.content.Context;

public final class b
{
  public Context a;
  int b;
  public boolean c;
  public String d = "";
  public String e = "";
  String f = "0M100WJ33N1CQ08O";
  private boolean g = false;
  private int h = -1;
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramContext.getApplicationContext();
    this.b = 100;
    this.c = true;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    StringBuilder localStringBuilder2 = new StringBuilder("appid:");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",uuid:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",channelid:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isSDKMode:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",isTest:false");
    localStringBuilder2 = new StringBuilder(",testAppid:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.b
 * JD-Core Version:    0.7.0.1
 */