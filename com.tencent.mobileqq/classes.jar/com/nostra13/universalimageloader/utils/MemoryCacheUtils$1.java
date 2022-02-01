package com.nostra13.universalimageloader.utils;

import java.util.Comparator;

final class MemoryCacheUtils$1
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    return paramString1.substring(0, paramString1.lastIndexOf("_")).compareTo(paramString2.substring(0, paramString2.lastIndexOf("_")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.MemoryCacheUtils.1
 * JD-Core Version:    0.7.0.1
 */