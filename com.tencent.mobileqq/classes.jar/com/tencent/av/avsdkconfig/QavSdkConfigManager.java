package com.tencent.av.avsdkconfig;

import android.text.TextUtils;

public class QavSdkConfigManager
{
  private static volatile QavSdkConfigManager jdField_a_of_type_ComTencentAvAvsdkconfigQavSdkConfigManager;
  private String jdField_a_of_type_JavaLangString;
  
  public static QavSdkConfigManager a()
  {
    if (jdField_a_of_type_ComTencentAvAvsdkconfigQavSdkConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvAvsdkconfigQavSdkConfigManager == null)
        {
          jdField_a_of_type_ComTencentAvAvsdkconfigQavSdkConfigManager = new QavSdkConfigManager();
          jdField_a_of_type_ComTencentAvAvsdkconfigQavSdkConfigManager.a();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvAvsdkconfigQavSdkConfigManager;
  }
  
  private void a() {}
  
  public String a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        String str2 = QavSdkConfigHelper.a("/sdcard/Android/data/com.tencent.mobileqq/", "QavSdkConfig.txt");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "";
        }
        this.jdField_a_of_type_JavaLangString = str1;
      }
      String str1 = this.jdField_a_of_type_JavaLangString;
      return str1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avsdkconfig.QavSdkConfigManager
 * JD-Core Version:    0.7.0.1
 */