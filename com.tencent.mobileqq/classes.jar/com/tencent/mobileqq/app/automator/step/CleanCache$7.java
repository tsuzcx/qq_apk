package com.tencent.mobileqq.app.automator.step;

import java.io.File;
import java.util.Comparator;

class CleanCache$7
  implements Comparator<File>
{
  CleanCache$7(CleanCache paramCleanCache) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.7
 * JD-Core Version:    0.7.0.1
 */