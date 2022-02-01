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
  public static int a;
  public static long a;
  public static Context a;
  public static String a;
  public static final int[] a;
  public static int b;
  private static String b;
  public static final int[] b;
  public static int c;
  private static String c;
  public static final int[] c;
  public static int d;
  private static String d;
  public static final int[] d;
  private static String e;
  public static final int[] e;
  private static String f;
  public static final int[] f;
  public static final int[] g = { 1280, 800 };
  public static final int[] h = { 720, 480 };
  
  static
  {
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.getContext();
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 640;
    jdField_d_of_type_Int = 480;
    jdField_a_of_type_ArrayOfInt = new int[] { 960, 640 };
    jdField_b_of_type_ArrayOfInt = new int[] { 720, 480 };
    jdField_c_of_type_ArrayOfInt = new int[] { 720, 540, 640, 480, 480, 360, 320, 240 };
    jdField_d_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_e_of_type_ArrayOfInt = new int[] { 1, 0, 0 };
    jdField_f_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
  }
  
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
    Object localObject1 = StorageManager.a().jdField_b_of_type_JavaLangString;
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
      jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject2 = new File(jdField_a_of_type_JavaLangString);
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
      jdField_e_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/Material");
      jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("/ProcessedMaterial");
      jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/log.txt");
      jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("Source");
      jdField_c_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject1 = new File(jdField_c_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.common.GloableValue
 * JD-Core Version:    0.7.0.1
 */