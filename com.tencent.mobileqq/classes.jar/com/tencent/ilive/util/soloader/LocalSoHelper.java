package com.tencent.ilive.util.soloader;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

public class LocalSoHelper
{
  private static final String TARGET_LIBS_NAME = "test_libs";
  private static volatile LocalSoHelper instance;
  private WeakReference<Context> weakReference;
  
  private LocalSoHelper(Context paramContext)
  {
    this.weakReference = new WeakReference(paramContext);
  }
  
  private static boolean copySdcardFile(String paramString1, String paramString2)
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
      return true;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("copySdcardFile error ");
      paramString2.append(paramString1);
      Log.d("dq", paramString2.toString());
    }
    return false;
  }
  
  public static LocalSoHelper getInstance(Context paramContext)
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new LocalSoHelper(paramContext);
        }
      }
      finally {}
    }
    return instance;
  }
  
  private File getTargetDir()
  {
    return ((Context)this.weakReference.get()).getDir("test_libs", 0);
  }
  
  public void copySo(String paramString, boolean paramBoolean, LocalSoHelper.CopyListener paramCopyListener)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (paramCopyListener != null) {
        paramCopyListener.failed();
      }
      return;
    }
    paramString = paramString.listFiles();
    File localFile = getTargetDir();
    boolean bool1 = localFile.exists();
    int j = 0;
    Object localObject;
    if (!bool1)
    {
      localFile.mkdirs();
    }
    else if (paramBoolean)
    {
      localObject = localFile.listFiles();
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    paramBoolean = false;
    int i = j;
    while (i < paramString.length)
    {
      String str = paramString[i];
      localObject = str.getName();
      bool1 = paramBoolean;
      if (((String)localObject).contains(".so"))
      {
        str = str.getPath();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localFile.toString());
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject);
        boolean bool2 = copySdcardFile(str, localStringBuilder.toString());
        bool1 = paramBoolean;
        if (bool2) {
          bool1 = bool2;
        }
      }
      i += 1;
      paramBoolean = bool1;
    }
    if ((paramCopyListener != null) && (paramBoolean)) {
      paramCopyListener.finish();
    }
  }
  
  public void loadSo(LocalSoHelper.LoadListener paramLoadListener)
  {
    File[] arrayOfFile = getTargetDir().listFiles();
    if (((arrayOfFile == null) || (arrayOfFile.length == 0)) && (paramLoadListener != null)) {
      paramLoadListener.failed();
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      System.load(arrayOfFile[i].getAbsolutePath());
      i += 1;
    }
    if (paramLoadListener != null) {
      paramLoadListener.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.LocalSoHelper
 * JD-Core Version:    0.7.0.1
 */