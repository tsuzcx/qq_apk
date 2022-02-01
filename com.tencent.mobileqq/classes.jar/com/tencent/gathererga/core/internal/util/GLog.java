package com.tencent.gathererga.core.internal.util;

import android.util.Log;
import com.tencent.gathererga.core.ILog;

public class GLog
{
  private static ILog jdField_a_of_type_ComTencentGatherergaCoreILog;
  private static String jdField_a_of_type_JavaLangString = "Gatherer";
  
  public static void a(ILog paramILog)
  {
    jdField_a_of_type_ComTencentGatherergaCoreILog = paramILog;
  }
  
  public static void a(String paramString)
  {
    ILog localILog = jdField_a_of_type_ComTencentGatherergaCoreILog;
    if (localILog != null)
    {
      localILog.i(jdField_a_of_type_JavaLangString, paramString);
      return;
    }
    Log.i(jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    ILog localILog = jdField_a_of_type_ComTencentGatherergaCoreILog;
    if (localILog != null)
    {
      localILog.w(jdField_a_of_type_JavaLangString, paramString, paramThrowable);
      return;
    }
    Log.w(jdField_a_of_type_JavaLangString, paramString, paramThrowable);
  }
  
  public static void a(Throwable paramThrowable)
  {
    a("", paramThrowable);
  }
  
  public static void b(String paramString)
  {
    ILog localILog = jdField_a_of_type_ComTencentGatherergaCoreILog;
    if (localILog != null)
    {
      localILog.d(jdField_a_of_type_JavaLangString, paramString);
      return;
    }
    Log.d(jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    ILog localILog = jdField_a_of_type_ComTencentGatherergaCoreILog;
    if (localILog != null)
    {
      localILog.e(jdField_a_of_type_JavaLangString, paramString, paramThrowable);
      return;
    }
    Log.e(jdField_a_of_type_JavaLangString, paramString, paramThrowable);
  }
  
  public static void c(String paramString)
  {
    ILog localILog = jdField_a_of_type_ComTencentGatherergaCoreILog;
    if (localILog != null)
    {
      localILog.w(jdField_a_of_type_JavaLangString, paramString);
      return;
    }
    Log.w(jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void d(String paramString)
  {
    ILog localILog = jdField_a_of_type_ComTencentGatherergaCoreILog;
    if (localILog != null)
    {
      localILog.e(jdField_a_of_type_JavaLangString, paramString);
      return;
    }
    Log.e(jdField_a_of_type_JavaLangString, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.GLog
 * JD-Core Version:    0.7.0.1
 */