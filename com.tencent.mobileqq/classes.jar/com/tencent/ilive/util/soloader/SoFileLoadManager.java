package com.tencent.ilive.util.soloader;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SoFileLoadManager
{
  public static int copy(String paramString1, String paramString2)
  {
    int k = 0;
    paramString1 = new File(paramString1);
    int i;
    if (!paramString1.exists()) {
      i = -1;
    }
    int m;
    int j;
    do
    {
      do
      {
        do
        {
          return i;
          paramString1 = paramString1.listFiles();
          localFile = new File(paramString2);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          i = k;
        } while (paramString1 == null);
        i = k;
      } while (paramString1.length <= 0);
      m = paramString1.length;
      j = 0;
      i = k;
    } while (j >= m);
    File localFile = paramString1[j];
    if (localFile.isDirectory()) {
      copy(localFile.getPath() + "/", paramString2 + localFile.getName() + "/");
    }
    for (;;)
    {
      j += 1;
      break;
      if (localFile.getName().endsWith(".so")) {
        copySdcardFile(localFile.getPath(), paramString2 + File.separator + localFile.getName());
      }
    }
  }
  
  public static int copySdcardFile(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileInputStream(paramString1);
      paramString2 = new FileOutputStream(paramString2);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString2.write(localByteArrayOutputStream.toByteArray());
      localByteArrayOutputStream.close();
      paramString2.close();
      paramString1.close();
      return 0;
    }
    catch (Exception paramString1) {}
    return -1;
  }
  
  private static boolean isLoadSoFile(File paramFile)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return bool2;
    }
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      if (paramFile[i].getName().toLowerCase().contains("duqian")) {
        bool1 = true;
      }
      i += 1;
    }
  }
  
  public static void loadSoFile(Context paramContext, String paramString)
  {
    try
    {
      LoadLibraryUtil.installNativeLibraryPath(paramContext.getApplicationContext().getClassLoader(), paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("dq", "loadSoFile error " + paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.SoFileLoadManager
 * JD-Core Version:    0.7.0.1
 */