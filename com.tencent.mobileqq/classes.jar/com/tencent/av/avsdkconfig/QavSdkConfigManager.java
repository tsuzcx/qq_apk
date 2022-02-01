package com.tencent.av.avsdkconfig;

import android.text.TextUtils;

public class QavSdkConfigManager
{
  private static volatile QavSdkConfigManager a;
  private String b;
  
  public static QavSdkConfigManager a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = new QavSdkConfigManager();
          a.c();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c() {}
  
  public String b()
  {
    try
    {
      if (this.b == null)
      {
        String str2 = QavSdkConfigHelper.a("/sdcard/Android/data/com.tencent.mobileqq/", "QavSdkConfig.txt");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "";
        }
        this.b = str1;
      }
      String str1 = this.b;
      return str1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avsdkconfig.QavSdkConfigManager
 * JD-Core Version:    0.7.0.1
 */