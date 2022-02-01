package com.tencent.luggage.wxa.oi;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import org.apache.commons.lang.StringUtils;

public enum f$a
{
  private f$a() {}
  
  public static a a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBoolean) {
        return a;
      }
      return b;
    }
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (StringUtils.equalsIgnoreCase(locala.a(), paramString)) {
        return locala;
      }
      i += 1;
    }
    o.b("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
    if (paramBoolean) {
      return a;
    }
    return b;
  }
  
  public String a()
  {
    return name().toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oi.f.a
 * JD-Core Version:    0.7.0.1
 */