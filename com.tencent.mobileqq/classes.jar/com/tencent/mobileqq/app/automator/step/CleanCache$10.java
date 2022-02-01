package com.tencent.mobileqq.app.automator.step;

import java.io.File;
import java.util.Comparator;

class CleanCache$10
  implements Comparator<File>
{
  CleanCache$10(CleanCache paramCleanCache) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return -1;
    }
    if (paramFile1.lastModified() == paramFile2.lastModified())
    {
      if (paramFile1.length() > paramFile2.length()) {
        return 1;
      }
      if (paramFile1.length() < paramFile2.length()) {
        return -1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.10
 * JD-Core Version:    0.7.0.1
 */