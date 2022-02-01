package com.tencent.biz.pubaccount.weishi_new.main;

import java.util.HashMap;
import java.util.Map;

public class WSMainPresenterFactory
{
  private static final Map<String, WSMainPresenterFactory.OnCreatePresenterListener> a = new HashMap();
  
  static
  {
    a();
    b();
    c();
    e();
    d();
  }
  
  public static WSMainContract.Presenter a(String paramString, WSMainContract.View paramView)
  {
    paramString = (WSMainPresenterFactory.OnCreatePresenterListener)a.get(paramString);
    if (paramString == null) {
      return new WSMainVerticalPresenter(paramView);
    }
    return paramString.a(paramView);
  }
  
  private static void a()
  {
    a.put("home", new WSMainPresenterFactory.1());
  }
  
  private static void b()
  {
    a.put("personal_main", new WSMainPresenterFactory.2());
  }
  
  private static void c()
  {
    a.put("personal_guest", new WSMainPresenterFactory.3());
  }
  
  private static void d()
  {
    a.put("mini_app_personal_main", new WSMainPresenterFactory.4());
  }
  
  private static void e()
  {
    a.put("mini_app_personal_guest", new WSMainPresenterFactory.5());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainPresenterFactory
 * JD-Core Version:    0.7.0.1
 */