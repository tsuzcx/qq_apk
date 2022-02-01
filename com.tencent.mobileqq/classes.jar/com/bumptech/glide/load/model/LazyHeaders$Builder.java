package com.bumptech.glide.load.model;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LazyHeaders$Builder
{
  private static final String a = ;
  private static final Map<String, List<LazyHeaderFactory>> b;
  private boolean c = true;
  private Map<String, List<LazyHeaderFactory>> d = b;
  private boolean e = true;
  
  static
  {
    HashMap localHashMap = new HashMap(2);
    if (!TextUtils.isEmpty(a)) {
      localHashMap.put("User-Agent", Collections.singletonList(new LazyHeaders.StringHeaderFactory(a)));
    }
    b = Collections.unmodifiableMap(localHashMap);
  }
  
  @VisibleForTesting
  static String b()
  {
    String str = System.getProperty("http.agent");
    if (TextUtils.isEmpty(str)) {
      return str;
    }
    int j = str.length();
    StringBuilder localStringBuilder = new StringBuilder(str.length());
    int i = 0;
    while (i < j)
    {
      char c1 = str.charAt(i);
      if (((c1 > '\037') || (c1 == '\t')) && (c1 < '')) {
        localStringBuilder.append(c1);
      } else {
        localStringBuilder.append('?');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public LazyHeaders a()
  {
    this.c = true;
    return new LazyHeaders(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.LazyHeaders.Builder
 * JD-Core Version:    0.7.0.1
 */