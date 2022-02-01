package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSReportUtils
{
  private static SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static String jdField_a_of_type_JavaLangString = "";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1, 2, 9, 12, 10007 };
  private static String b = "";
  
  public static String a()
  {
    return b;
  }
  
  public static String a(int paramInt)
  {
    String str = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = c();
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = WSExpABTestManager.a().d();
    }
    return paramString;
  }
  
  public static void a()
  {
    jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public static void a(int paramInt, String paramString)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramString);
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  public static boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "fullscreen_videoplay")) || (TextUtils.equals(paramString, "collection_videoplay")) || (TextUtils.equals(paramString, "feeds_fullscreen"));
  }
  
  public static String b()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void b(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  private static String c()
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      String str = WeishiUtils.a(arrayOfInt[i]);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils
 * JD-Core Version:    0.7.0.1
 */