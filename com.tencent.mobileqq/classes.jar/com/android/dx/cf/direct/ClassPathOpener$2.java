package com.android.dx.cf.direct;

import java.io.File;
import java.util.Comparator;

class ClassPathOpener$2
  implements Comparator<File>
{
  ClassPathOpener$2(ClassPathOpener paramClassPathOpener) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    return ClassPathOpener.access$000(paramFile1.getName(), paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.ClassPathOpener.2
 * JD-Core Version:    0.7.0.1
 */