package com.nostra13.universalimageloader.cache.disc.naming;

public class HashCodeFileNameGenerator
  implements FileNameGenerator
{
  public String generate(String paramString)
  {
    return String.valueOf(paramString.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator
 * JD-Core Version:    0.7.0.1
 */