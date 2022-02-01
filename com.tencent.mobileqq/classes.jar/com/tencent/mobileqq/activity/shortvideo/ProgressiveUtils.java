package com.tencent.mobileqq.activity.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProgressiveUtils
{
  private static ArrayList<String> jdField_a_of_type_JavaUtilArrayList = null;
  public static AtomicBoolean a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MI 3", "Coolpad 8675", "OPPO R7", "Redmi Note 2", "MX4", "vivo X5L", "m3 note", "PRO 6" };
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      if (Integer.valueOf(paramString).intValue() == 0) {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      } else {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    catch (Exception localException)
    {
      label37:
      StringBuilder localStringBuilder;
      break label37;
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    break label54;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    label54:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseConfig(): config = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", sProgressiveEnable = ");
      localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.d("ShortVideo.ProgressiveUtils", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils
 * JD-Core Version:    0.7.0.1
 */