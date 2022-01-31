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
    paramString = super.generate(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf('#');
    } while (i <= 0);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator.GeneratorDespiteHash
 * JD-Core Version:    0.7.0.1
 */