package com.tencent.component.network.downloader;

import android.text.TextUtils;

class UrlKeyGenerator$GeneratorDespiteHash
  extends UrlKeyGenerator.GeneratorDespiteDomain
{
  private UrlKeyGenerator$GeneratorDespiteHash()
  {
    super(null);
  }
  
  public String generate(String paramString)
  {
    String str = super.generate(paramString);
    if (TextUtils.isEmpty(str)) {
      return str;
    }
    int i = str.indexOf('#');
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator.GeneratorDespiteHash
 * JD-Core Version:    0.7.0.1
 */