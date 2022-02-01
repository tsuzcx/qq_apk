package com.tencent.mfsdk;

import achm;
import achn;
import achp;
import achq;
import achr;
import achu;
import achx;
import acid;
import acih;
import acii;
import aciu;
import aciw;
import aciy;
import acjb;
import acjc;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apub;
import aqmy;
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
  public static acjc a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  public static Object a;
  public static String a;
  public static MqqHandler a;
  private achn jdField_a_of_type_Achn = new acih();
  private achq jdField_a_of_type_Achq = new aciu();
  private achr jdField_a_of_type_Achr = new aciy();
  achu jdField_a_of_type_Achu = null;
  private achx jdField_a_of_type_Achx = new aciw();
  private acid jdField_a_of_type_Acid = new acid();
  private acjb jdField_a_of_type_Acjb = new acjb();
  private APMConfRoot jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot;
  private APMConfig jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
  public Config a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private achx b = new acii();
  
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
    return "V 8.4.8." + aqmy.a(BaseApplicationImpl.sApplication) + ".r" + AppSetting.g();
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
  
  public achm a()
  {
    return this.b;
  }
  
  public achn a()
  {
    return this.jdField_a_of_type_Achn;
  }
  
  public achp a()
  {
    return this.jdField_a_of_type_Acid;
  }
  
  public achq a()
  {
    return this.jdField_a_of_type_Achq;
  }
  
  public achr a()
  {
    return this.jdField_a_of_type_Achr;
  }
  
  public achu a()
  {
    try
    {
      if (this.jdField_a_of_type_Achu == null) {
        this.jdField_a_of_type_Achu = new achu();
      }
      achu localachu = this.jdField_a_of_type_Achu;
      return localachu;
    }
    finally {}
  }
  
  public achx a()
  {
    return this.jdField_a_of_type_Achx;
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null)
      {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot = ((APMConfRoot)apub.a().a(255));
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
    this.jdField_a_of_type_Acjb.a(paramString);
  }
  
  public achm b()
  {
    return this.jdField_a_of_type_Acjb;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "endScene:" + paramString);
    }
    this.jdField_a_of_type_Acjb.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */