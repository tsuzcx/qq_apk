package com.tencent.biz.subscribe.bizdapters;

import java.io.File;
import java.util.Comparator;

final class AnimationDrawableFactory$3
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.3
 * JD-Core Version:    0.7.0.1
 */