package com.tencent.mobileqq.ark.env;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ArkAppEnvConfig
{
  private static final ArkAppEnvConfig jdField_a_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig = new ArkAppEnvConfig(1);
  private static boolean jdField_a_of_type_Boolean = false;
  private static final ArkAppEnvConfig jdField_b_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig = new ArkAppEnvConfig(2);
  private static ArkAppEnvConfig jdField_c_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig = jdField_b_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig;
  private final int jdField_a_of_type_Int;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final String jdField_a_of_type_JavaLangString;
  private final SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private final String jdField_b_of_type_JavaLangString;
  private final String jdField_c_of_type_JavaLangString;
  
  private ArkAppEnvConfig(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramInt);
    this.jdField_c_of_type_JavaLangString = b(paramInt);
    this.jdField_a_of_type_AndroidContentSharedPreferences = a(paramInt);
    this.jdField_b_of_type_AndroidContentSharedPreferences = b(paramInt);
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaLangString = "test.ark.qq.com";
      return;
    }
    this.jdField_b_of_type_JavaLangString = "cgi.ark.qq.com";
  }
  
  private static SharedPreferences a(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfigDebug", 0);
  }
  
  public static ArkAppEnvConfig a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkTemp.getCurrent sso env isTestEnv=");
      localStringBuilder.append(false);
      QLog.i("ArkApp", 1, localStringBuilder.toString());
    }
    jdField_c_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig = jdField_b_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig;
    return jdField_c_of_type_ComTencentMobileqqArkEnvArkAppEnvConfig;
  }
  
  private static String a(int paramInt)
  {
    String str = e();
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/ArkAppTest");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/ArkApp");
    return localStringBuilder.toString();
  }
  
  private static SharedPreferences b(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfigDebug", 0);
  }
  
  private static String b(int paramInt)
  {
    String str = e();
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/pddata/prd/arkapp/test");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/pddata/prd/arkapp");
    return localStringBuilder.toString();
  }
  
  private static String e()
  {
    return BaseApplication.getContext().getFilesDir().getAbsolutePath();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("/Dict");
    return localStringBuilder.toString();
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/Debug");
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/Crash");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.env.ArkAppEnvConfig
 * JD-Core Version:    0.7.0.1
 */