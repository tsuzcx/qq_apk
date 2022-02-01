package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForRecommendPresenter;
import java.util.HashMap;
import java.util.Map;

public class WSVerticalPresenterFactory
{
  private static final Map<String, WSVerticalPresenterFactory.OnCreatePresenterListener> a = new HashMap();
  
  static
  {
    h();
    g();
    a("mini_app_personal_main");
    a("mini_app_personal_guest");
    e();
    f();
    d();
    c();
    b();
    i();
    a();
  }
  
  public static WSVerticalPageContract.Presenter a(String paramString, WSVerticalPageContract.View paramView)
  {
    paramString = (WSVerticalPresenterFactory.OnCreatePresenterListener)a.get(paramString);
    if (paramString == null) {
      return new WSVerticalForRecommendPresenter(paramView);
    }
    return paramString.a(paramView);
  }
  
  private static void a()
  {
    a.put("trends", new WSVerticalPresenterFactory.1());
  }
  
  private static void a(String paramString)
  {
    a.put(paramString, new WSVerticalPresenterFactory.7());
  }
  
  private static void b()
  {
    a.put("qqchat", new WSVerticalPresenterFactory.2());
  }
  
  private static void c()
  {
    a.put("aio_home_page", new WSVerticalPresenterFactory.3());
  }
  
  private static void d()
  {
    a.put("friend_feed", new WSVerticalPresenterFactory.4());
  }
  
  private static void e()
  {
    a.put("vertical_layer_collection", new WSVerticalPresenterFactory.5());
  }
  
  private static void f()
  {
    a.put("vertical_layer_collection_of_card", new WSVerticalPresenterFactory.6());
  }
  
  private static void g()
  {
    a.put("follow_tab", new WSVerticalPresenterFactory.8());
  }
  
  private static void h()
  {
    a.put("recommend_tab", new WSVerticalPresenterFactory.9());
  }
  
  private static void i()
  {
    a.put("aio_new_msg", new WSVerticalPresenterFactory.10());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPresenterFactory
 * JD-Core Version:    0.7.0.1
 */