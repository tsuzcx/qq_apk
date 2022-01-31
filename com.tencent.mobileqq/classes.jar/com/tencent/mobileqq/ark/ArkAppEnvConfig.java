package com.tencent.mobileqq.ark;

import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class ArkAppEnvConfig
{
  private static final ArkAppEnvConfig jdField_a_of_type_ComTencentMobileqqArkArkAppEnvConfig = new ArkAppEnvConfig(1);
  private static final ArkAppEnvConfig jdField_b_of_type_ComTencentMobileqqArkArkAppEnvConfig = new ArkAppEnvConfig(2);
  private static ArkAppEnvConfig jdField_c_of_type_ComTencentMobileqqArkArkAppEnvConfig = jdField_b_of_type_ComTencentMobileqqArkArkAppEnvConfig;
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final String jdField_b_of_type_JavaLangString;
  private final String jdField_c_of_type_JavaLangString;
  private final String d;
  
  private ArkAppEnvConfig(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramInt);
    this.jdField_c_of_type_JavaLangString = b(paramInt);
    this.d = c(paramInt);
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaLangString = "test.ark.qq.com";
      return;
    }
    this.jdField_b_of_type_JavaLangString = "ark.qq.com";
  }
  
  public static ArkAppEnvConfig a()
  {
    return jdField_c_of_type_ComTencentMobileqqArkArkAppEnvConfig;
  }
  
  private static String a(int paramInt)
  {
    if (a()) {}
    for (String str = AppConstants.aJ;; str = g()) {
      switch (paramInt)
      {
      default: 
        return str + "/ArkApp";
      }
    }
    return str + "/ArkAppTest";
    return str + "/ArkApp";
  }
  
  private static boolean a()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      ArkAppCenter.b("ArkApp", String.format("getRootDirectoryByEnvType, getExternalStorageState fail, msg=%s", new Object[] { localException.getMessage() }));
    }
    return false;
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g() + "/ArkApp";
    case 1: 
      if (a()) {}
      for (String str = AppConstants.aJ;; str = g()) {
        return str + "/ArkAppTest";
      }
    }
    return g() + "/ArkApp";
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g() + "/pddata/prd/arkapp";
    case 1: 
      if (a()) {}
      for (String str = AppConstants.aJ;; str = g()) {
        return str + "/ArkAppTest";
      }
    }
    return g() + "/pddata/prd/arkapp";
  }
  
  private static String g()
  {
    return BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString + "/Storage";
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString + "/Cache";
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString + "/Install";
  }
  
  public String d()
  {
    return this.d + "/Dict";
  }
  
  public String e()
  {
    return this.jdField_c_of_type_JavaLangString + "/Debug";
  }
  
  public String f()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppEnvConfig
 * JD-Core Version:    0.7.0.1
 */