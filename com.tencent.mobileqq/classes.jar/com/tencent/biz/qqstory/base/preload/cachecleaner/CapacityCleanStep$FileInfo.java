package com.tencent.biz.qqstory.base.preload.cachecleaner;

import java.io.File;

class CapacityCleanStep$FileInfo
  implements Comparable<FileInfo>
{
  public final File a;
  public final long b;
  
  public CapacityCleanStep$FileInfo(CapacityCleanStep paramCapacityCleanStep, File paramFile)
  {
    this.a = paramFile;
    this.b = paramFile.lastModified();
  }
  
  public int a(FileInfo paramFileInfo)
  {
    long l1 = this.b;
    long l2 = paramFileInfo.b;
    if (l1 < l2) {
      return -1;
    }
    if (l1 == l2) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep.FileInfo
 * JD-Core Version:    0.7.0.1
 */