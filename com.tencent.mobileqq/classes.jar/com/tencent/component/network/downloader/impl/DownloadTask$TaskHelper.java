package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.utils.FileUtils;
import java.io.File;
import java.util.Random;

final class DownloadTask$TaskHelper
{
  private static final Random sRandom = new Random();
  
  public static boolean ensureFile(File paramFile, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramFile == null) {
      return false;
    }
    try
    {
      File localFile = paramFile.getParentFile();
      if ((localFile.exists()) && (localFile.isFile())) {
        FileUtils.delete(localFile);
      }
      boolean bool2;
      if (!localFile.exists())
      {
        bool2 = localFile.mkdirs();
        if (!bool2) {
          return false;
        }
      }
      if ((paramBoolean) && (paramFile.exists())) {
        FileUtils.delete(paramFile);
      }
      if (!paramFile.exists())
      {
        bool2 = paramFile.createNewFile();
        paramBoolean = bool1;
        if (!bool2) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    finally {}
  }
  
  public static int generateRandomId(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        Object localObject = paramVarArgs[j];
        if (localObject != null) {
          i = i * 31 + localObject.hashCode();
        }
        j += 1;
      }
    }
    return k * 31 + sRandom.nextInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask.TaskHelper
 * JD-Core Version:    0.7.0.1
 */