package com.tencent.mfsdk;

import acxu;
import acxv;
import acxx;
import acxy;
import acxz;
import acyc;
import acyf;
import acyg;
import acyl;
import acyp;
import acyq;
import acyr;
import aczd;
import aczf;
import aczh;
import aczk;
import aczl;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqxe;
import arqj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.config.APMConfRoot;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.mfsdk.config.Config;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class MagnifierSDK
{
  public static long a;
  public static aczl a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  public static Object a;
  public static String a;
  public static MqqHandler a;
  private acxv jdField_a_of_type_Acxv = new acyq();
  private acxy jdField_a_of_type_Acxy = new aczd();
  private acxz jdField_a_of_type_Acxz = new aczh();
  acyc jdField_a_of_type_Acyc = null;
  private acyf jdField_a_of_type_Acyf = new aczf();
  private acyl jdField_a_of_type_Acyl = new acyl();
  private acyp jdField_a_of_type_Acyp = new acyp();
  private aczk jdField_a_of_type_Aczk = new aczk();
  private APMConfRoot jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot;
  private APMConfig jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
  public Config a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private acyf b = new acyr();
  
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
    return "V 8.4.10." + arqj.a(BaseApplicationImpl.sApplication) + ".r" + AppSetting.g();
  }
  
  public static void a(long paramLong)
  {
    QLog.i("MagnifierSDK.QAPM", 1, "lifeCycle setUin " + paramLong);
    jdField_a_of_type_Long = paramLong;
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  private void a(ArrayList<acxu> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      acxu localacxu = (acxu)localIterator.next();
      boolean bool = localacxu.b();
      QLog.i("MagnifierSDK.QAPM", 1, "lifecycle " + localacxu.a() + " canStart " + bool);
      j = i;
      if (bool)
      {
        acyg.a();
        DefaultPluginConfig localDefaultPluginConfig = localacxu.a();
        localacxu.a();
        APMModuleConfig localAPMModuleConfig = localacxu.a();
        localDefaultPluginConfig.eventSampleRatio = localAPMModuleConfig.evenRatio;
        localDefaultPluginConfig.threshold = localAPMModuleConfig.threshold;
        localDefaultPluginConfig.maxReportNum = localAPMModuleConfig.maxReport;
        localDefaultPluginConfig.stackDepth = localAPMModuleConfig.stackDepth;
        j = i | localDefaultPluginConfig.mode;
        localacxu.a();
      }
    }
    if (i != 0) {
      QAPM.beginScene("SCENE_ALL", i);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((acxu)paramArrayList.next()).b();
    }
  }
  
  public static String b()
  {
    if ((2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId)) {
      return "100";
    }
    return "1";
  }
  
  public acxu a()
  {
    return this.b;
  }
  
  public acxv a()
  {
    return this.jdField_a_of_type_Acxv;
  }
  
  public acxx a()
  {
    return this.jdField_a_of_type_Acyl;
  }
  
  public acxy a()
  {
    return this.jdField_a_of_type_Acxy;
  }
  
  public acxz a()
  {
    return this.jdField_a_of_type_Acxz;
  }
  
  public acyc a()
  {
    try
    {
      if (this.jdField_a_of_type_Acyc == null) {
        this.jdField_a_of_type_Acyc = new acyc();
      }
      acyc localacyc = this.jdField_a_of_type_Acyc;
      return localacyc;
    }
    finally {}
  }
  
  public acyf a()
  {
    return this.jdField_a_of_type_Acyf;
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null)
      {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot = ((APMConfRoot)aqxe.a().a(255));
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
    this.jdField_a_of_type_Aczk.a(paramString);
  }
  
  public acxu b()
  {
    return this.jdField_a_of_type_Aczk;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "endScene:" + paramString);
    }
    this.jdField_a_of_type_Aczk.b(paramString);
  }
  
  public acxu c()
  {
    return this.jdField_a_of_type_Acyp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */