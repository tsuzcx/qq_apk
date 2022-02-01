package com.tencent.biz.subscribe.bizdapters;

import java.io.File;
import java.io.FileFilter;

final class AnimationDrawableFactory$2
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.2
 * JD-Core Version:    0.7.0.1
 */