package com.tencent.ilivesdk.pluginloaderservice.utils;

import com.tencent.ilivesdk.pluginloaderservice.install.SafeZipInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;

public class FileUtil
{
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    a(localStringBuffer, paramString);
    return localStringBuffer.toString();
  }
  
  private static void a(SafeZipInputStream paramSafeZipInputStream, String paramString)
  {
    try
    {
      paramString = new BufferedOutputStream(new FileOutputStream(paramString));
      try
      {
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramSafeZipInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramString.write(arrayOfByte, 0, i);
        }
        if (paramString == null) {
          break label52;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        label52:
        paramString = null;
      }
    }
    paramString.close();
    throw paramSafeZipInputStream;
    paramString.close();
    if (paramString != null) {
      paramString.close();
    }
  }
  
  public static void a(StringBuffer paramStringBuffer, String paramString)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      paramStringBuffer.append(paramString);
      paramStringBuffer.append("\n");
    }
    localBufferedReader.close();
    localFileInputStream.close();
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!a(new File(paramFile, arrayOfString[i]))) {
          return false;
        }
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (!paramFile2.exists()) {
      paramFile2.mkdir();
    }
    for (;;)
    {
      try
      {
        paramFile1 = new SafeZipInputStream(new FileInputStream(paramFile1));
        try
        {
          ZipEntry localZipEntry = paramFile1.getNextEntry();
          if (localZipEntry == null) {
            continue;
          }
          if (localZipEntry.getName().startsWith("__MACOSX")) {
            continue;
          }
          str = paramFile2.getAbsolutePath() + File.separator + localZipEntry.getName();
          if (localZipEntry.isDirectory()) {
            continue;
          }
          a(paramFile1, str);
          paramFile1.closeEntry();
          continue;
          if (paramFile2 == null) {
            continue;
          }
        }
        finally
        {
          paramFile2 = paramFile1;
          paramFile1 = localObject;
        }
      }
      finally
      {
        String str;
        paramFile2 = null;
        continue;
      }
      paramFile2.close();
      throw paramFile1;
      new File(str).mkdir();
    }
    if (paramFile1 != null) {
      paramFile1.close();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */