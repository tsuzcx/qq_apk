package com.tencent.component.network.downloader;

class UrlKeyGenerator$GeneratorDespiteDomain
  extends UrlKeyGenerator
{
  public String generate(String paramString)
  {
    String str = null;
    int i;
    if (UrlKeyGenerator.access$200(paramString, "http://")) {
      i = paramString.indexOf("/", "http://".length());
    }
    for (;;)
    {
      if (i != -1) {
        str = paramString.substring(i);
      }
      return str;
      if (UrlKeyGenerator.access$200(paramString, "https://")) {
        i = paramString.indexOf("/", "https://".length());
      } else {
        i = paramString.indexOf("/");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator.GeneratorDespiteDomain
 * JD-Core Version:    0.7.0.1
 */