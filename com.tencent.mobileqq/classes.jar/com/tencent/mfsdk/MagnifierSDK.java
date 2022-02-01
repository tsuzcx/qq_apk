package com.tencent.mfsdk;

import adbu;
import adbv;
import adbx;
import adby;
import adbz;
import adcc;
import adcg;
import adcm;
import adcq;
import adcr;
import addd;
import addf;
import addh;
import addk;
import addl;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqlk;
import ardl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.config.APMConfRoot;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.Config;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class MagnifierSDK
{
  public static long a;
  public static addl a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  public static Object a;
  public static String a;
  public static MqqHandler a;
  private adbv jdField_a_of_type_Adbv = new adcq();
  private adby jdField_a_of_type_Adby = new addd();
  private adbz jdField_a_of_type_Adbz = new addh();
  adcc jdField_a_of_type_Adcc = null;
  private adcg jdField_a_of_type_Adcg = new addf();
  private adcm jdField_a_of_type_Adcm = new adcm();
  private addk jdField_a_of_type_Addk = new addk();
  private APMConfRoot jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot;
  private APMConfig jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
  public Config a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private adcg b = new adcr();
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private MagnifierSDK()
  {
    this.jdField_a_of_type_ComTencentMfsdkConfigConfig = new Config();
  }
  
  public static SharedPreferences a(Application paramApplication)
  {
    return paramApplication.getSharedPreferences("MagnifierSDK.QAPM", 4);
  }
  
  public static MagnifierSDK a()
  {
    if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null) {
        jdField_a_of_type_ComTencentMfsdkMagnifierSDK = new MagnifierSDK();
      }
      return jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
    }
    finally {}
  }
  
  public static String a()
  {
    return "V 8.4.1." + ardl.a(BaseApplicationImpl.sApplication) + ".r" + AppSetting.g();
  }
  
  public static void a(long paramLong)
  {
    QLog.i("MagnifierSDK.QAPM", 1, "lifeCycle setUin " + paramLong);
    jdField_a_of_type_Long = paramLong;
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  public static String b()
  {
    if ((2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId)) {
      return "100";
    }
    return "1";
  }
  
  public adbu a()
  {
    return this.b;
  }
  
  public adbv a()
  {
    return this.jdField_a_of_type_Adbv;
  }
  
  public adbx a()
  {
    return this.jdField_a_of_type_Adcm;
  }
  
  public adby a()
  {
    return this.jdField_a_of_type_Adby;
  }
  
  public adbz a()
  {
    return this.jdField_a_of_type_Adbz;
  }
  
  public adcc a()
  {
    try
    {
      if (this.jdField_a_of_type_Adcc == null) {
        this.jdField_a_of_type_Adcc = new adcc();
      }
      adcc localadcc = this.jdField_a_of_type_Adcc;
      return localadcc;
    }
    finally {}
  }
  
  public adcg a()
  {
    return this.jdField_a_of_type_Adcg;
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null)
      {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot = ((APMConfRoot)aqlk.a().a(255));
        if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot != null) {
          this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig = this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot.pub;
        }
        if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {
          this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig = new APMConfig();
        }
      }
      return this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
      jdField_a_of_type_JavaLangString = a();
      MagnifierSDK.RunSDKRunnable localRunSDKRunnable = new MagnifierSDK.RunSDKRunnable(this, BaseApplicationImpl.getApplication());
      jdField_a_of_type_MqqOsMqqHandler.post(localRunSDKRunnable);
      QLog.i("MagnifierSDK.QAPM", 1, "startVersion = " + jdField_a_of_type_JavaLangString + " gray=" + false + " pub=" + true);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "beginScene:" + paramString);
    }
    this.jdField_a_of_type_Addk.a(paramString);
  }
  
  public adbu b()
  {
    return this.jdField_a_of_type_Addk;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "endScene:" + paramString);
    }
    this.jdField_a_of_type_Addk.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */