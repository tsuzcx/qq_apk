package c.t.m.g;

import android.location.Location;
import android.os.Bundle;

public final class eg
{
  public static final Location a = new Location("Empty");
  
  static
  {
    new Bundle();
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    boolean bool = da.a().d("https");
    StringBuilder localStringBuilder2 = new StringBuilder("http");
    String str;
    if (bool) {
      str = "s";
    } else {
      str = "";
    }
    localStringBuilder2.append(str);
    localStringBuilder2.append("://lbs.map.qq.com/loc");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("?");
    localStringBuilder1.append("c=1");
    localStringBuilder1.append("&mars=");
    localStringBuilder1.append(paramInt1);
    localStringBuilder1.append("&obs=");
    localStringBuilder1.append(paramInt2);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eg
 * JD-Core Version:    0.7.0.1
 */