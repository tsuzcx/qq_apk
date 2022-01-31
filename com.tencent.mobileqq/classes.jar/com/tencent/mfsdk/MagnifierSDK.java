package com.tencent.mfsdk;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorListener;
import com.tencent.mfsdk.persist.DBHandler;
import com.tencent.mfsdk.reporter.DFObserver;
import com.tencent.mfsdk.reporter.StackObserver;
import mqq.os.MqqHandler;
import rdq;

public class MagnifierSDK
{
  public static int a;
  public static long a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  public static DBHandler a;
  private static DFObserver jdField_a_of_type_ComTencentMfsdkReporterDFObserver = new DFObserver();
  private static StackObserver jdField_a_of_type_ComTencentMfsdkReporterStackObserver;
  public static String a;
  public static MqqHandler a;
  private LeakInspector.InspectorListener jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_ComTencentMfsdkReporterStackObserver = new StackObserver();
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
    return "-1";
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Application paramApplication)
  {
    if ((this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener != null) && (jdField_a_of_type_MqqOsMqqHandler != null)) {
      LeakInspector.a(jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener);
    }
  }
  
  public void a(LeakInspector.InspectorListener paramInspectorListener)
  {
    this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener = paramInspectorListener;
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
    paramApplication = new rdq(this, paramApplication, paramInt);
    jdField_a_of_type_MqqOsMqqHandler.post(paramApplication);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */