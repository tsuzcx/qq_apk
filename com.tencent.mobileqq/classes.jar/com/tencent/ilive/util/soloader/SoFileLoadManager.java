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
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return -1;
    }
    paramString1 = paramString1.listFiles();
    File localFile = new File(paramString2);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if ((paramString1 != null) && (paramString1.length > 0))
    {
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramString1[i];
        Object localObject;
        StringBuilder localStringBuilder;
        if (localFile.isDirectory())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localFile.getPath());
          ((StringBuilder)localObject).append("/");
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append("/");
          copy((String)localObject, localStringBuilder.toString());
        }
        else if (localFile.getName().endsWith(".so"))
        {
          localObject = localFile.getPath();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(localFile.getName());
          copySdcardFile((String)localObject, localStringBuilder.toString());
        }
        i += 1;
      }
    }
    return 0;
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
    paramFile = paramFile.listFiles();
    int i = 0;
    if (paramFile == null) {
      return false;
    }
    int j = paramFile.length;
    boolean bool = false;
    while (i < j)
    {
      if (paramFile[i].getName().toLowerCase().contains("duqian")) {
        bool = true;
      }
      i += 1;
    }
    return bool;
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
      paramString = new StringBuilder();
      paramString.append("loadSoFile error ");
      paramString.append(paramContext.getMessage());
      Log.e("dq", paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.SoFileLoadManager
 * JD-Core Version:    0.7.0.1
 */