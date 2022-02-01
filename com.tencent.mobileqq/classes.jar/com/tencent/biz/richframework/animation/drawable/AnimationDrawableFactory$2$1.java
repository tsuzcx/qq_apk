package com.tencent.biz.richframework.animation.drawable;

import java.io.File;
import java.util.Comparator;

class AnimationDrawableFactory$2$1
  implements Comparator<File>
{
  AnimationDrawableFactory$2$1(AnimationDrawableFactory.2 param2) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2.1
 * JD-Core Version:    0.7.0.1
 */