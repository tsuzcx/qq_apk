package com.tencent.mobileqq.app.automator.step;

import java.io.File;
import java.io.FilenameFilter;

class CleanCache$6
  implements FilenameFilter
{
  CleanCache$6(CleanCache paramCleanCache) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.contains("CrashInfoSummary.txt") ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.6
 * JD-Core Version:    0.7.0.1
 */