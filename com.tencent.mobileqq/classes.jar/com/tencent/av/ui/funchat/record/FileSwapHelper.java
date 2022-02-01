package com.tencent.av.ui.funchat.record;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

public class FileSwapHelper
{
  public static String a = ".mp4";
  
  public static long a()
  {
    File localFile = Environment.getExternalStorageDirectory();
    try
    {
      Object localObject = new StatFs(localFile.getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getAvailableBlocks();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStorageLeft left=");
        ((StringBuilder)localObject).append(l1 * l2);
        QLog.d("FileSwapHelper", 2, ((StringBuilder)localObject).toString());
      }
      return l1 * l2;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSpaceLeft exception:");
      localStringBuilder.append(localThrowable);
      localStringBuilder.append(", path=");
      localStringBuilder.append(localFile);
      QLog.e("FileSwapHelper", 1, localStringBuilder.toString(), localThrowable);
    }
    return 2147483647L;
  }
  
  public static long a(File paramFile)
  {
    if (paramFile.exists())
    {
      paramFile = new FileInputStream(paramFile);
      long l = paramFile.available();
      paramFile.close();
      return l;
    }
    QLog.e("FileSwapHelper", 1, new Object[] { "获取文件大小", "文件不存在!" });
    return 0L;
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyMp4Saved=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FileSwapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject = new File(paramString.replace(BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath()));
    a(paramString, (File)localObject);
    com.tencent.biz.qqstory.utils.FileUtils.a(paramContext, (File)localObject);
  }
  
  private static void a(String paramString, File paramFile)
  {
    if (paramString != null)
    {
      if (paramFile.exists()) {
        return;
      }
      paramString = new File(paramString);
      if (paramString.exists())
      {
        com.tencent.mobileqq.utils.FileUtils.copyFile(paramString, paramFile);
        paramString.delete();
      }
    }
  }
  
  public static String b()
  {
    String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("/QQVideo/");
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis())));
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(a);
    str = ((StringBuilder)localObject).toString();
    localObject = new File(str).getParentFile();
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.FileSwapHelper
 * JD-Core Version:    0.7.0.1
 */