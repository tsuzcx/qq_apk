package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

public class UploadTmpVideoCleanStep
  extends AbsCleanStep
{
  public UploadTmpVideoCleanStep(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  protected void a(String[] paramArrayOfString, AbsCleanStep.CleanContext paramCleanContext)
  {
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      paramCleanContext = new File(paramArrayOfString[i]).listFiles();
      if (paramCleanContext != null)
      {
        int m = paramCleanContext.length;
        int j = 0;
        for (;;)
        {
          if ((j >= m) || (j % 150 == 0)) {}
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException)
          {
            label65:
            File localFile;
            break label65;
          }
          SLog.e("Q.qqstory.cleaner:UploadTmpVideoCleanStep", "sleep error ,InterruptedException");
          localFile = paramCleanContext[j];
          if (a(localFile)) {
            a(localFile);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  protected boolean a(File paramFile)
  {
    if (!paramFile.isDirectory()) {
      return false;
    }
    if (System.currentTimeMillis() - paramFile.lastModified() <= 86400000L) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(paramFile[i].getName(), "dont_delete.txt")) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.UploadTmpVideoCleanStep
 * JD-Core Version:    0.7.0.1
 */