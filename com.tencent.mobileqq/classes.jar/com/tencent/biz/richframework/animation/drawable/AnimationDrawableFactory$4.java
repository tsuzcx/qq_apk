package com.tencent.biz.richframework.animation.drawable;

import java.io.File;
import java.util.Comparator;

final class AnimationDrawableFactory$4
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.4
 * JD-Core Version:    0.7.0.1
 */