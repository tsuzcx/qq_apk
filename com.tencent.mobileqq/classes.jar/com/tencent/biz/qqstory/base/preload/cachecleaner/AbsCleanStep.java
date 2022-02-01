package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import java.io.File;

public abstract class AbsCleanStep
{
  protected AbsCleanStep a;
  protected String[] a;
  
  public AbsCleanStep(@NonNull String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public static double a(File paramFile)
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
          d2 += a(paramFile[i]);
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
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep = paramAbsCleanStep;
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep;
  }
  
  public void a(AbsCleanStep.CleanContext paramCleanContext)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramCleanContext);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep != null) {}
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
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerAbsCleanStep.a(paramCleanContext);
    return;
    l = FileUtils.a() / 1024L;
    SLog.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramCleanContext.jdField_a_of_type_Long), Long.valueOf(l) });
    if (paramCleanContext.jdField_a_of_type_Int != 0) {
      StoryReportor.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramCleanContext.jdField_a_of_type_Int), String.valueOf(paramCleanContext.jdField_a_of_type_Double), String.valueOf(l) });
    }
    if (paramCleanContext.jdField_b_of_type_Int != 0) {
      StoryReportor.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramCleanContext.jdField_b_of_type_Int), String.valueOf(paramCleanContext.jdField_b_of_type_Double), String.valueOf(l) });
    }
  }
  
  public void a(File paramFile)
  {
    try
    {
      FileUtils.d(paramFile.getPath());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.AbsCleanStep
 * JD-Core Version:    0.7.0.1
 */