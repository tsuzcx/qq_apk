package com.tencent.aelight.camera.aioeditor.shortvideo.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GloableValue
{
  public static Context a = ;
  public static String b;
  public static long c = -1L;
  public static int d = 1;
  public static int e = 1;
  public static int f = 640;
  public static int g = 480;
  public static final int[] h = { 960, 640 };
  public static final int[] i = { 720, 480 };
  public static final int[] j = { 720, 540, 640, 480, 480, 360, 320, 240 };
  public static final int[] k = { 1, 1, 0 };
  public static final int[] l = { 1, 0, 0 };
  public static final int[] m = { 1, 1, 0 };
  public static final int[] n = { 1280, 800 };
  public static final int[] o = { 720, 480 };
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static String t;
  
  public static boolean a()
  {
    boolean bool1 = FileUtils.hasSDCardAndWritable();
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
      }
      return bool1;
    }
    Object localObject1 = StorageManager.a().e;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "sdcardDirPath = empty");
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sdcardDirPath:storeVideoPath=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("initDirs", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (((File)localObject2).canWrite()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("trimvideo");
      b = ((StringBuilder)localObject2).toString();
      localObject2 = new File(b);
      bool1 = ((File)localObject2).mkdirs();
      boolean bool2 = ((File)localObject2).isDirectory();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("trimVideoFilesDirPath:mkd=");
        ((StringBuilder)localObject2).append(bool1);
        ((StringBuilder)localObject2).append(" isdir=");
        ((StringBuilder)localObject2).append(bool2);
        QLog.e("initDirs", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!bool1) && (!bool2)) {
        return false;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/Product");
      s = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/Material");
      r = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(r);
      ((StringBuilder)localObject2).append("/ProcessedMaterial");
      t = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/log.txt");
      p = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("Source");
      q = ((StringBuilder)localObject2).toString();
      localObject1 = new File(q);
      bool1 = ((File)localObject1).mkdirs();
      bool2 = ((File)localObject1).isDirectory();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("avSourceFilesDirPath:mkd=");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(" isdir=");
        ((StringBuilder)localObject1).append(bool2);
        QLog.e("initDirs", 2, ((StringBuilder)localObject1).toString());
      }
      return (bool1) || (bool2);
    }
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.common.GloableValue
 * JD-Core Version:    0.7.0.1
 */