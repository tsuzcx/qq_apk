package com.android.dx.cf.direct;

import java.util.Comparator;
import java.util.zip.ZipEntry;

class ClassPathOpener$3
  implements Comparator<ZipEntry>
{
  ClassPathOpener$3(ClassPathOpener paramClassPathOpener) {}
  
  public int compare(ZipEntry paramZipEntry1, ZipEntry paramZipEntry2)
  {
    return ClassPathOpener.access$000(paramZipEntry1.getName(), paramZipEntry2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.ClassPathOpener.3
 * JD-Core Version:    0.7.0.1
 */