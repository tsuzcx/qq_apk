package com.tencent.biz.subscribe.bizdapters;

import java.io.File;
import java.util.Comparator;

class AnimationDrawableFactory$1$1
  implements Comparator<File>
{
  AnimationDrawableFactory$1$1(AnimationDrawableFactory.1 param1) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */