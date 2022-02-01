package com.tencent.luggage.wxa.rc;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d$a
{
  private static final Pattern c = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
  public final String a;
  public final String b;
  
  private d$a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static a a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool) {
      return null;
    }
    Object localObject = c.matcher(paramString);
    if (!((Matcher)localObject).find()) {
      return null;
    }
    localObject = ((Matcher)localObject).group(0);
    if (paramString.contains("charset=")) {
      str = paramString.substring(paramString.indexOf("charset=") + 8).trim();
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "UTF-8";
    }
    return new a((String)localObject, paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ContentType{mimeType='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", charset='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rc.d.a
 * JD-Core Version:    0.7.0.1
 */