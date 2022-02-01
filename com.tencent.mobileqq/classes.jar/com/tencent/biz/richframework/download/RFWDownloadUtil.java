package com.tencent.biz.richframework.download;

import java.io.Closeable;
import java.io.IOException;

public class RFWDownloadUtil
{
  public static void closeAll(Closeable... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Closeable localCloseable = paramVarArgs[i];
      if (localCloseable != null) {
        try
        {
          localCloseable.close();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
      i += 1;
    }
  }
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf(".");
    int j = paramString.lastIndexOf("?");
    if (i == -1) {
      return null;
    }
    if (i == paramString.length() - 1) {
      return null;
    }
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFileNameFromUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf("?");
    if (i == -1) {
      return null;
    }
    if (i == paramString.length() - 1) {
      return null;
    }
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloadUtil
 * JD-Core Version:    0.7.0.1
 */