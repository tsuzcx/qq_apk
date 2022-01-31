package com.tencent.av.ui.funchat.record;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.biz.qqstory.utils.FileUtils;
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
      StatFs localStatFs = new StatFs(localFile.getPath());
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getAvailableBlocks();
      if (QLog.isColorLevel()) {
        QLog.d("FileSwapHelper", 2, "getStorageLeft left=" + l1 * l2);
      }
      return l1 * l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FileSwapHelper", 1, "getSpaceLeft exception:" + localThrowable + ", path=" + localFile, localThrowable);
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
  
  public static String a()
  {
    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    str = str + "/QQVideo/";
    str = str + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    str = str + a;
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileSwapHelper", 2, "notifyMp4Saved=" + paramString);
    }
    FileUtils.a(paramContext, new File(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.FileSwapHelper
 * JD-Core Version:    0.7.0.1
 */