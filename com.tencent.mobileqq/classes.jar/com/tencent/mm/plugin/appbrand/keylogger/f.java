package com.tencent.mm.plugin.appbrand.keylogger;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.nk.e;
import com.tencent.luggage.wxa.qz.af;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
  implements e
{
  private static final Pattern a = Pattern.compile(String.format("%s(.*)%s", new Object[] { "<kLog>", "</kLog>" }));
  @Nullable
  private e b = null;
  
  public static String a(String paramString)
  {
    if (af.c(paramString)) {
      return paramString;
    }
    paramString = a.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  public List<String> a(String paramString, long paramLong)
  {
    e locale = this.b;
    if (locale == null) {
      return new ArrayList();
    }
    return locale.a(paramString, paramLong);
  }
  
  public void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    e locale = this.b;
    if (locale == null) {
      return;
    }
    locale.a(paramString1, String.format("%s%s%s", new Object[] { "<kLog>", paramString2, "</kLog>" }), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.f
 * JD-Core Version:    0.7.0.1
 */