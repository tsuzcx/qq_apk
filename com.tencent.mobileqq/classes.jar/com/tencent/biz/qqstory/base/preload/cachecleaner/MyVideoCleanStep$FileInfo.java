package com.tencent.biz.qqstory.base.preload.cachecleaner;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

class MyVideoCleanStep$FileInfo
  implements Comparable<FileInfo>
{
  public long a;
  public final File a;
  
  public MyVideoCleanStep$FileInfo(MyVideoCleanStep paramMyVideoCleanStep, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramMyVideoCleanStep = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramMyVideoCleanStep);
      return;
    }
    catch (Exception paramFile)
    {
      SLog.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramMyVideoCleanStep, paramFile.getMessage() });
    }
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
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.MyVideoCleanStep.FileInfo
 * JD-Core Version:    0.7.0.1
 */