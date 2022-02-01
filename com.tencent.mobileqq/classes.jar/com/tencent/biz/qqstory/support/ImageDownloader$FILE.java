package com.tencent.biz.qqstory.support;

public class ImageDownloader$FILE
{
  public static String a(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.ImageDownloader.FILE
 * JD-Core Version:    0.7.0.1
 */