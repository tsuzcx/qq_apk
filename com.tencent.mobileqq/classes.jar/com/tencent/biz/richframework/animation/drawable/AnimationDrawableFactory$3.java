package com.tencent.biz.richframework.animation.drawable;

import java.io.File;
import java.io.FileFilter;

final class AnimationDrawableFactory$3
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.3
 * JD-Core Version:    0.7.0.1
 */