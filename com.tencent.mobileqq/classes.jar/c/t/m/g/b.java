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
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append("appid:" + this.b);
    localStringBuilder.append(",uuid:" + this.d);
    localStringBuilder.append(",channelid:" + this.e);
    localStringBuilder.append(",isSDKMode:" + this.c);
    localStringBuilder.append(",isTest:false");
    localStringBuilder.append(",testAppid:" + this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.b
 * JD-Core Version:    0.7.0.1
 */