package com.tencent.mfsdk;

import adks;
import adkt;
import adkv;
import adkw;
import adkx;
import adla;
import adle;
import adlk;
import adlo;
import adlp;
import admb;
import admd;
import admf;
import admi;
import admj;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aran;
import arta;
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
  public static admj a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  public static Object a;
  public static String a;
  public static MqqHandler a;
  private adkt jdField_a_of_type_Adkt = new adlo();
  private adkw jdField_a_of_type_Adkw = new admb();
  private adkx jdField_a_of_type_Adkx = new admf();
  adla jdField_a_of_type_Adla = null;
  private adle jdField_a_of_type_Adle = new admd();
  private adlk jdField_a_of_type_Adlk = new adlk();
  private admi jdField_a_of_type_Admi = new admi();
  private APMConfRoot jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot;
  private APMConfig jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
  public Config a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private adle b = new adlp();
  
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
    return "V 8.4.5." + arta.a(BaseApplicationImpl.sApplication) + ".r" + AppSetting.g();
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
  
  public adks a()
  {
    return this.b;
  }
  
  public adkt a()
  {
    return this.jdField_a_of_type_Adkt;
  }
  
  public adkv a()
  {
    return this.jdField_a_of_type_Adlk;
  }
  
  public adkw a()
  {
    return this.jdField_a_of_type_Adkw;
  }
  
  public adkx a()
  {
    return this.jdField_a_of_type_Adkx;
  }
  
  public adla a()
  {
    try
    {
      if (this.jdField_a_of_type_Adla == null) {
        this.jdField_a_of_type_Adla = new adla();
      }
      adla localadla = this.jdField_a_of_type_Adla;
      return localadla;
    }
    finally {}
  }
  
  public adle a()
  {
    return this.jdField_a_of_type_Adle;
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null)
      {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot = ((APMConfRoot)aran.a().a(255));
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
    this.jdField_a_of_type_Admi.a(paramString);
  }
  
  public adks b()
  {
    return this.jdField_a_of_type_Admi;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "endScene:" + paramString);
    }
    this.jdField_a_of_type_Admi.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */