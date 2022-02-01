package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;

public abstract class UrlKeyGenerator
{
  public static final UrlKeyGenerator GENERATOR_DESPITE_DOMAIN = new UrlKeyGenerator.GeneratorDespiteDomain(null);
  public static final UrlKeyGenerator GENERATOR_DESPITE_HASH = new UrlKeyGenerator.GeneratorDespiteHash(null);
  private static final String HTTPS_PREFIX = "https://";
  private static final String HTTP_PREFIX = "http://";
  
  private static boolean startsWithIgnoreCase(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
    }
    return false;
  }
  
  public final String doGenerate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (!NetworkUtils.isNetworkUrl(paramString)) {
      return paramString;
    }
    return generate(paramString);
  }
  
  public abstract String generate(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator
 * JD-Core Version:    0.7.0.1
 */