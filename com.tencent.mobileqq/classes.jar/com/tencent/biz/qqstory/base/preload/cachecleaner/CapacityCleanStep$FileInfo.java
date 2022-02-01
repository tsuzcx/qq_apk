package com.tencent.biz.qqstory.base.preload.cachecleaner;

import java.io.File;

class CapacityCleanStep$FileInfo
  implements Comparable<FileInfo>
{
  public final long a;
  public final File a;
  
  public CapacityCleanStep$FileInfo(CapacityCleanStep paramCapacityCleanStep, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(FileInfo paramFileInfo)
  {
    long l1 = this.jdField_a_of_type_Long;
    long l2 = paramFileInfo.jdField_a_of_type_Long;
    if (l1 < l2) {
      return -1;
    }
    if (l1 == l2) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep.FileInfo
 * JD-Core Version:    0.7.0.1
 */