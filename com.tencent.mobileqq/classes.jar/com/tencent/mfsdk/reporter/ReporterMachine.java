package com.tencent.mfsdk.reporter;

import aaaj;
import aaal;
import aaam;
import aaan;
import aaaq;
import aabb;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import axrn;
import ayta;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import zzn;
import zzv;
import zzy;

public class ReporterMachine
{
  public static int a;
  private static aaaj jdField_a_of_type_Aaaj;
  private static ReporterMachine jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List<ResultObject> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private static Queue<String> jdField_a_of_type_JavaUtilQueue;
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private static boolean jdField_a_of_type_Boolean;
  private static aaaj b;
  
  static
  {
    jdField_a_of_type_Int = 2;
    jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private ReporterMachine()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("ReporterMachine", 0);
      localHandlerThread.start();
      jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      jdField_a_of_type_Aaaj = new aaaq(localHandlerThread);
      b = new aaal(localHandlerThread);
    }
    jdField_a_of_type_JavaLangString = a();
  }
  
  public static ReporterMachine a()
  {
    if (jdField_a_of_type_ComTencentMfsdkReporterReporterMachine == null) {}
    try
    {
      jdField_a_of_type_ComTencentMfsdkReporterReporterMachine = new ReporterMachine();
      return jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    QLog.i("Magnifier_ReporterMachine", 1, "setReportType t=" + paramInt + "");
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(ResultObject paramResultObject)
  {
    zzy.a(paramResultObject.params);
    if ((true == paramResultObject.isRealTime) && (1 == ayta.a().a())) {
      try
      {
        c(paramResultObject);
        return;
      }
      catch (Exception paramResultObject)
      {
        paramResultObject.printStackTrace();
        return;
      }
    }
    if (jdField_a_of_type_MqqOsMqqHandler != null)
    {
      paramResultObject = new ReporterMachine.InsertRunnable(paramResultObject);
      jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
      return;
    }
    jdField_a_of_type_JavaUtilList.add(paramResultObject);
  }
  
  private static void c(ResultObject paramResultObject)
  {
    if (zzv.jdField_a_of_type_Int > zzn.jdField_a_of_type_Int) {}
    for (;;)
    {
      return;
      Object localObject = paramResultObject.params.getJSONObject("clientinfo");
      ((JSONObject)localObject).put("versionname", MagnifierSDK.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("uin", String.valueOf(paramResultObject.uin));
      ((JSONObject)localObject).put("manu", Build.MANUFACTURER);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("os", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("rdmuuid", jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("deviceid", aabb.a(BaseApplicationImpl.sApplication));
      if (BaseApplicationImpl.sProcessId == 1) {}
      try
      {
        if (TextUtils.equals(String.valueOf(paramResultObject.params.get("newplugin")), String.valueOf(102)))
        {
          localObject = new HashMap();
          axrn.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actAPMReportMainLooper", true, 0L, 0L, (HashMap)localObject, null);
        }
        if ((jdField_a_of_type_Int & 0x1) > 0) {
          jdField_a_of_type_Aaaj.a(paramResultObject, new aaam());
        }
        if ((jdField_a_of_type_Int & 0x2) <= 0) {
          continue;
        }
        b.a(paramResultObject, new aaan());
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("Magnifier_ReporterMachine", 1, "reportAtOnce", localException);
        }
      }
    }
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.sApplication.getPackageManager().getApplicationInfo(BaseApplicationImpl.sApplication.getPackageName(), 128).metaData.get("com.tencent.rdm.uuid").toString();
      if ("1234567890".equals(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = "0";
      }
      label64:
      return jdField_a_of_type_JavaLangString;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label64;
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      ReporterMachine.ReportRunnable localReportRunnable = new ReporterMachine.ReportRunnable(this, null);
      ReporterMachine.getFileRunnable localgetFileRunnable = new ReporterMachine.getFileRunnable();
      jdField_a_of_type_MqqOsMqqHandler.postDelayed(localgetFileRunnable, 120000L);
      jdField_a_of_type_MqqOsMqqHandler.postDelayed(localReportRunnable, 300000L);
      jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */