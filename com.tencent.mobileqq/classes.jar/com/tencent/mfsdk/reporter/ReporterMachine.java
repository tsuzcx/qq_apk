package com.tencent.mfsdk.reporter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.Config;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.ReportedStatus;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.tools.PhoneUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.NetworkCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import rdv;
import rdw;
import rdx;
import rdy;
import rdz;

public class ReporterMachine
{
  public static int a;
  private static IReporter jdField_a_of_type_ComTencentMfsdkReporterIReporter;
  private static ReporterMachine jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private static Queue jdField_a_of_type_JavaUtilQueue;
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private static boolean jdField_a_of_type_Boolean;
  private static IReporter b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private ReporterMachine()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("ReporterMachine", 0);
      localHandlerThread.start();
      jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      jdField_a_of_type_ComTencentMfsdkReporterIReporter = new YunYingReporter(localHandlerThread);
      b = new QCloudReporter(localHandlerThread);
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
  
  private String a()
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
      label61:
      return jdField_a_of_type_JavaLangString;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label61;
    }
  }
  
  public static void a(ResultObject paramResultObject)
  {
    if ((true == paramResultObject.isRealTime) && (1 == NetworkCenter.a().a())) {
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
      paramResultObject = new rdx(paramResultObject);
      jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
      return;
    }
    jdField_a_of_type_JavaUtilList.add(paramResultObject);
  }
  
  private static void c(ResultObject paramResultObject)
  {
    if (ReportedStatus.jdField_a_of_type_Int > Config.jdField_a_of_type_Int) {}
    do
    {
      return;
      JSONObject localJSONObject = paramResultObject.params.getJSONObject("clientinfo");
      localJSONObject.put("versionname", MagnifierSDK.jdField_a_of_type_JavaLangString);
      localJSONObject.put("uin", String.valueOf(paramResultObject.uin));
      localJSONObject.put("manu", Build.MANUFACTURER);
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("os", Build.VERSION.RELEASE);
      localJSONObject.put("rdmuuid", jdField_a_of_type_JavaLangString);
      localJSONObject.put("deviceid", PhoneUtil.a(BaseApplicationImpl.sApplication));
      if ((jdField_a_of_type_Int & 0x1) > 0) {
        jdField_a_of_type_ComTencentMfsdkReporterIReporter.a(paramResultObject, new rdv());
      }
    } while ((jdField_a_of_type_Int & 0x2) <= 0);
    b.a(paramResultObject, new rdw());
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      rdy localrdy = new rdy(this, null);
      rdz localrdz = new rdz();
      jdField_a_of_type_MqqOsMqqHandler.postDelayed(localrdz, 120000L);
      jdField_a_of_type_MqqOsMqqHandler.postDelayed(localrdy, 300000L);
      jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */