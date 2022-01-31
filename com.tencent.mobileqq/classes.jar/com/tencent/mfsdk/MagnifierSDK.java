package com.tencent.mfsdk;

import aaag;
import aaap;
import aaaw;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.reporter.DFObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import zzt;
import zzu;
import zzy;

public class MagnifierSDK
{
  public static int a;
  public static long a;
  public static aaag a;
  private static aaap jdField_a_of_type_Aaap = new aaap();
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  private static DFObserver jdField_a_of_type_ComTencentMfsdkReporterDFObserver = new DFObserver();
  public static String a;
  public static MqqHandler a;
  private zzt jdField_a_of_type_Zzt;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
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
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK", 2, "beginSceneStage:" + paramString);
    }
    aaaw.a().a(paramString);
  }
  
  public static void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull Class<? extends zzu> paramClass)
  {
    QLog.i("MagnifierSDK", 1, "setABFactor:" + paramClass + " val " + paramString2);
    paramClass = zzy.a(paramClass);
    paramClass.a(paramString2, paramString1);
    paramClass.a();
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK", 2, "endSceneStage:" + paramString);
    }
    aaaw.a().b(paramString);
  }
  
  public void a(Application paramApplication)
  {
    if ((this.jdField_a_of_type_Zzt != null) && (jdField_a_of_type_MqqOsMqqHandler != null)) {
      LeakInspector.a(jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_Zzt);
    }
  }
  
  public void a(zzt paramzzt)
  {
    this.jdField_a_of_type_Zzt = paramzzt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */