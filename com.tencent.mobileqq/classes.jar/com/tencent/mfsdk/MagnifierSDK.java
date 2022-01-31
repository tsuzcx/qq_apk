package com.tencent.mfsdk;

import abqq;
import abrd;
import abrm;
import abrt;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azpi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.reporter.DFObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class MagnifierSDK
{
  public static int a;
  public static long a;
  public static abrd a;
  private static abrm jdField_a_of_type_Abrm = new abrm();
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  private static DFObserver jdField_a_of_type_ComTencentMfsdkReporterDFObserver = new DFObserver();
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  public static String a;
  public static MqqHandler a;
  private abqq jdField_a_of_type_Abqq;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static SharedPreferences a(Application paramApplication)
  {
    return paramApplication.getSharedPreferences("MagnifierSDK_QAPM", 4);
  }
  
  public static MagnifierSDK a(MqqHandler paramMqqHandler, int paramInt, String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null)
      {
        jdField_a_of_type_ComTencentMfsdkMagnifierSDK = new MagnifierSDK();
        jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
        jdField_a_of_type_Int = paramInt;
        jdField_a_of_type_JavaLangString = paramString;
      }
      return jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
    }
    finally {}
  }
  
  public static String a()
  {
    if (1 == BaseApplicationImpl.sProcessId) {
      return "1";
    }
    if ((2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId)) {
      return "100";
    }
    if (7 == BaseApplicationImpl.sProcessId) {
      return "217";
    }
    if (10 == BaseApplicationImpl.sProcessId) {
      return "591";
    }
    return "-1";
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
    if (a()) {
      azpi.a().a(paramLong);
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK_QAPM", 2, "beginSceneStage:" + paramString);
    }
    abrt.a().a(paramString);
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(a(MobileQQ.sMobileQQ).getBoolean("qapm_enable", false));
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK_QAPM", 2, "endSceneStage:" + paramString);
    }
    abrt.a().b(paramString);
  }
  
  public void a(abqq paramabqq)
  {
    this.jdField_a_of_type_Abqq = paramabqq;
  }
  
  public void a(Application paramApplication)
  {
    if (a()) {
      azpi.a().b();
    }
    while ((this.jdField_a_of_type_Abqq == null) || (jdField_a_of_type_MqqOsMqqHandler == null)) {
      return;
    }
    LeakInspector.a(jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_Abqq);
  }
  
  public boolean a(Application paramApplication)
  {
    return a(paramApplication, 63);
  }
  
  public boolean a(Application paramApplication, int paramInt)
  {
    if ((jdField_a_of_type_Int <= 0) || (jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() == 0) || (paramApplication == null)) {}
    while (jdField_a_of_type_MqqOsMqqHandler == null) {
      return false;
    }
    paramApplication = new MagnifierSDK.RunSDKRunnable(this, paramApplication, paramInt);
    jdField_a_of_type_MqqOsMqqHandler.post(paramApplication);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */