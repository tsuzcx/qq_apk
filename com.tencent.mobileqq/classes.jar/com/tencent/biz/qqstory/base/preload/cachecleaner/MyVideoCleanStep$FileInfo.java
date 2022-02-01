package com.tencent.biz.qqstory.base.preload.cachecleaner;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

class MyVideoCleanStep$FileInfo
  implements Comparable<FileInfo>
{
  public final File a;
  public long b;
  
  public MyVideoCleanStep$FileInfo(MyVideoCleanStep paramMyVideoCleanStep, File paramFile)
  {
    this.a = paramFile;
    paramMyVideoCleanStep = paramFile.getName();
    try
    {
      this.b = Long.parseLong(paramMyVideoCleanStep);
      return;
    }
    catch (Exception paramFile)
    {
      SLog.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramMyVideoCleanStep, paramFile.getMessage() });
    }
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
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.MyVideoCleanStep.FileInfo
 * JD-Core Version:    0.7.0.1
 */