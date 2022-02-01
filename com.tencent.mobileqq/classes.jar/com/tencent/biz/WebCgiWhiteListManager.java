package com.tencent.biz;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVWhiteListConfBean;

public class WebCgiWhiteListManager
{
  public static int a()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public static String a()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public static int b()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.b;
    }
    return -1;
  }
  
  public static String b()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.c;
    }
    return null;
  }
  
  public static String c()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.d;
    }
    return null;
  }
  
  public static String d()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.e;
    }
    return null;
  }
  
  public static String e()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.a().a(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.f;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.WebCgiWhiteListManager
 * JD-Core Version:    0.7.0.1
 */