package com.tencent.mobileqq.app.automator.step;

import java.io.File;
import java.util.Comparator;

class CleanCache$5
  implements Comparator<File>
{
  CleanCache$5(CleanCache paramCleanCache) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.5
 * JD-Core Version:    0.7.0.1
 */