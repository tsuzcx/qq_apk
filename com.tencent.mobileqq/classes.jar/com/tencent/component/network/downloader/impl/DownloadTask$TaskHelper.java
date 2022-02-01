package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.utils.FileUtils;
import java.io.File;
import java.util.Random;

final class DownloadTask$TaskHelper
{
  private static final Random sRandom = new Random();
  
  public static boolean ensureFile(File paramFile, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFile == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        File localFile = paramFile.getParentFile();
        if ((localFile.exists()) && (localFile.isFile())) {
          FileUtils.delete(localFile);
        }
        if (!localFile.exists())
        {
          bool1 = bool2;
          if (!localFile.mkdirs()) {
            continue;
          }
        }
        if ((paramBoolean) && (paramFile.exists())) {
          FileUtils.delete(paramFile);
        }
        if (!paramFile.exists())
        {
          paramBoolean = paramFile.createNewFile();
          bool1 = bool2;
          if (!paramBoolean) {
            continue;
          }
        }
        bool1 = true;
      }
      finally {}
    }
  }
  
  public static int generateRandomId(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      k = i;
      if (j < m)
      {
        Object localObject = paramVarArgs[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return k * 31 + sRandom.nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask.TaskHelper
 * JD-Core Version:    0.7.0.1
 */