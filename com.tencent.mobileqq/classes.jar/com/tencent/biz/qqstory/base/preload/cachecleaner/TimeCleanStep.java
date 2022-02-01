package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

@TargetApi(14)
public class TimeCleanStep
  extends AbsCleanStep
{
  public TimeCleanStep(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  protected void a(String[] paramArrayOfString, AbsCleanStep.CleanContext paramCleanContext)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    while (i < m)
    {
      File localFile1 = new File(paramArrayOfString[i]);
      double d1 = a(localFile1);
      File[] arrayOfFile = localFile1.listFiles();
      if (arrayOfFile != null)
      {
        long l = System.currentTimeMillis();
        int n = arrayOfFile.length;
        int j = 0;
        int k = 0;
        for (;;)
        {
          if ((j >= n) || (j % 150 == 0)) {}
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException)
          {
            label89:
            File localFile2;
            double d2;
            break label89;
          }
          SLog.e("Q.qqstory.cleaner:TimeCleanStep", "sleep error ,InterruptedException");
          localFile2 = arrayOfFile[j];
          if (l - localFile2.lastModified() > 86400000L)
          {
            a(localFile2);
            k += 1;
          }
          j += 1;
        }
        d2 = a(localFile1);
        paramCleanContext.jdField_b_of_type_Double += d1 - d2;
        paramCleanContext.jdField_b_of_type_Int += k;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.TimeCleanStep
 * JD-Core Version:    0.7.0.1
 */