package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;

public final class n
{
  public static Locale a = ;
  
  public static String a()
  {
    String str = af.b(ad.a("language_key"));
    if ((str.length() > 0) && (!str.equals("language_default"))) {
      return str;
    }
    return a("en");
  }
  
  public static String a(Context paramContext)
  {
    String str1 = a(paramContext.getSharedPreferences(r.f(), 0), paramContext);
    String str2 = a();
    paramContext = str1;
    if (str1.equalsIgnoreCase("language_default")) {
      paramContext = str2;
    }
    return paramContext;
  }
  
  public static String a(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    paramSharedPreferences = af.b(paramSharedPreferences.getString("language_key", null));
    if (!af.c(paramSharedPreferences)) {
      return paramSharedPreferences;
    }
    return "language_default";
  }
  
  private static String a(String paramString)
  {
    String str = Locale.getDefault().getLanguage().trim();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Locale.getDefault().getCountry().trim());
    localObject = ((StringBuilder)localObject).toString();
    if (str.equals("en")) {
      return str;
    }
    if (((String)localObject).equals("zh_TW")) {
      return "zh_TW";
    }
    if (((String)localObject).equals("zh_HK")) {
      return "zh_HK";
    }
    if (((String)localObject).equals("zh_CN")) {
      return "zh_CN";
    }
    if (str.equals("th")) {
      return "th";
    }
    if (str.equals("id")) {
      return "id";
    }
    if (((String)localObject).equals("in_ID")) {
      return "id";
    }
    if (str.equals("vi")) {
      return "vi";
    }
    if (str.equals("pt")) {
      return "pt";
    }
    if (str.equals("es")) {
      return "es";
    }
    if (str.equals("ru")) {
      return "ru";
    }
    if (str.equals("ar")) {
      return "ar";
    }
    if (str.equals("ja")) {
      return "ja";
    }
    if (str.equals("it")) {
      return "it";
    }
    if (str.equals("ko")) {
      return "ko";
    }
    if (str.equals("ms")) {
      return "ms";
    }
    if (str.equals("tr")) {
      return "tr";
    }
    if (str.equals("de")) {
      return "de";
    }
    if (str.equals("fr")) {
      return "fr";
    }
    if (str.equals("my")) {
      return "my";
    }
    if (str.equals("lo")) {
      paramString = "lo";
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.n
 * JD-Core Version:    0.7.0.1
 */