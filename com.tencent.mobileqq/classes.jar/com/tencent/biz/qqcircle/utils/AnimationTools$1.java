package com.tencent.biz.qqcircle.utils;

import java.io.File;
import java.util.Comparator;

final class AnimationTools$1
  implements Comparator<File>
{
  private int a(String paramString)
  {
    int i;
    try
    {
      i = paramString.lastIndexOf('.');
      if (i == -1) {
        i = Integer.parseInt(paramString);
      } else {
        i = Integer.parseInt(paramString.substring(0, i));
      }
    }
    catch (Exception paramString)
    {
      return 0;
    }
    return i;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getName()) - a(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.AnimationTools.1
 * JD-Core Version:    0.7.0.1
 */