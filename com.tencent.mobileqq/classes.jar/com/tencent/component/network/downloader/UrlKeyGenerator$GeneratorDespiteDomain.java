package com.tencent.component.network.downloader;

class UrlKeyGenerator$GeneratorDespiteDomain
  extends UrlKeyGenerator
{
  public String generate(String paramString)
  {
    int i;
    if (UrlKeyGenerator.access$200(paramString, "http://")) {
      i = paramString.indexOf("/", 7);
    } else if (UrlKeyGenerator.access$200(paramString, "https://")) {
      i = paramString.indexOf("/", 8);
    } else {
      i = paramString.indexOf("/");
    }
    if (i != -1) {
      return paramString.substring(i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator.GeneratorDespiteDomain
 * JD-Core Version:    0.7.0.1
 */