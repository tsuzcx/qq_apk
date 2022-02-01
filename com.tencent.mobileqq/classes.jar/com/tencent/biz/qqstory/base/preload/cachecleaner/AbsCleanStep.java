package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import java.io.File;

public abstract class AbsCleanStep
{
  protected AbsCleanStep a;
  protected String[] b;
  
  public AbsCleanStep(@NonNull String[] paramArrayOfString)
  {
    this.b = paramArrayOfString;
  }
  
  public static double b(File paramFile)
  {
    double d1;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      double d2 = 0.0D;
      d1 = d2;
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          d1 = d2;
          if (i >= j) {
            break;
          }
          d2 += b(paramFile[i]);
          i += 1;
        }
      }
    }
    else
    {
      d1 = paramFile.length();
      Double.isNaN(d1);
      d1 = d1 / 1024.0D / 1024.0D;
    }
    return d1;
  }
  
  public AbsCleanStep a(AbsCleanStep paramAbsCleanStep)
  {
    this.a = paramAbsCleanStep;
    return this.a;
  }
  
  public void a(AbsCleanStep.CleanContext paramCleanContext)
  {
    a(this.b, paramCleanContext);
    if (this.a != null) {}
    try
    {
      Thread.sleep(100L);
    }
    catch (InterruptedException localInterruptedException)
    {
      label25:
      long l;
      break label25;
    }
    SLog.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
    this.a.a(paramCleanContext);
    return;
    l = FileUtils.b() / 1024L;
    SLog.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramCleanContext.b), Long.valueOf(l) });
    if (paramCleanContext.c != 0) {
      StoryReportor.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramCleanContext.c), String.valueOf(paramCleanContext.d), String.valueOf(l) });
    }
    if (paramCleanContext.e != 0) {
      StoryReportor.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramCleanContext.e), String.valueOf(paramCleanContext.f), String.valueOf(l) });
    }
  }
  
  public void a(File paramFile)
  {
    try
    {
      FileUtils.e(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete failed : ");
      localStringBuilder.append(paramFile);
      SLog.d("Q.qqstory.cleaner:AbsCleanStep", localStringBuilder.toString());
    }
  }
  
  protected abstract void a(String[] paramArrayOfString, AbsCleanStep.CleanContext paramCleanContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.AbsCleanStep
 * JD-Core Version:    0.7.0.1
 */