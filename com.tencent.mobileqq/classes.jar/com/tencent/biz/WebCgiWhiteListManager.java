package com.tencent.biz;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVWhiteListConfBean;

public class WebCgiWhiteListManager
{
  public static String a()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.a;
    }
    return null;
  }
  
  public static String b()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.c;
    }
    return null;
  }
  
  public static int c()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.d;
    }
    return 0;
  }
  
  public static String d()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.e;
    }
    return null;
  }
  
  public static int e()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.f;
    }
    return -1;
  }
  
  public static String f()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.g;
    }
    return null;
  }
  
  public static String g()
  {
    WVWhiteListConfBean localWVWhiteListConfBean = (WVWhiteListConfBean)QConfigManager.b().b(207);
    if (localWVWhiteListConfBean != null) {
      return localWVWhiteListConfBean.h;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.WebCgiWhiteListManager
 * JD-Core Version:    0.7.0.1
 */