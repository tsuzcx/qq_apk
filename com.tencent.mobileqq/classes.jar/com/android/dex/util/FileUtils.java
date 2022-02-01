package com.android.dex.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileUtils
{
  public static boolean hasArchiveSuffix(String paramString)
  {
    return (paramString.endsWith(".zip")) || (paramString.endsWith(".jar")) || (paramString.endsWith(".apk"));
  }
  
  public static byte[] readFile(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new RuntimeException(paramFile + ": file not found");
    }
    if (!paramFile.isFile()) {
      throw new RuntimeException(paramFile + ": not a file");
    }
    if (!paramFile.canRead()) {
      throw new RuntimeException(paramFile + ": file not readable");
    }
    long l = paramFile.length();
    int i = (int)l;
    if (i != l) {
      throw new RuntimeException(paramFile + ": file too long");
    }
    byte[] arrayOfByte = new byte[i];
    FileInputStream localFileInputStream;
    for (;;)
    {
      int j;
      int k;
      try
      {
        localFileInputStream = new FileInputStream(paramFile);
        j = 0;
        if (i <= 0) {
          break;
        }
        k = localFileInputStream.read(arrayOfByte, j, i);
        if (k == -1) {
          throw new RuntimeException(paramFile + ": unexpected EOF");
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(paramFile + ": trouble reading", localIOException);
      }
      j += k;
      i -= k;
    }
    localFileInputStream.close();
    return localIOException;
  }
  
  public static byte[] readFile(String paramString)
  {
    return readFile(new File(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.util.FileUtils
 * JD-Core Version:    0.7.0.1
 */