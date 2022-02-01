package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForRecommendPresenter;
import java.util.HashMap;
import java.util.Map;

public class WSVerticalPresenterFactory
{
  private static final Map<String, WSVerticalPresenterFactory.OnCreatePresenterListener> a = new HashMap();
  
  static
  {
    j();
    i();
    a("mini_app_personal_main");
    a("mini_app_personal_guest");
    g();
    h();
    f();
    e();
    d();
    k();
    c();
    b();
    l();
    m();
    n();
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
    a.put("qq_scheme_open_player", new WSVerticalPresenterFactory.1());
  }
  
  private static void a(String paramString)
  {
    a.put(paramString, new WSVerticalPresenterFactory.9());
  }
  
  private static void b()
  {
    a.put("share", new WSVerticalPresenterFactory.2());
  }
  
  private static void c()
  {
    a.put("trends", new WSVerticalPresenterFactory.3());
  }
  
  private static void d()
  {
    a.put("qqchat", new WSVerticalPresenterFactory.4());
  }
  
  private static void e()
  {
    a.put("aio_home_page", new WSVerticalPresenterFactory.5());
  }
  
  private static void f()
  {
    a.put("friend_feed", new WSVerticalPresenterFactory.6());
  }
  
  private static void g()
  {
    a.put("vertical_layer_collection", new WSVerticalPresenterFactory.7());
  }
  
  private static void h()
  {
    a.put("vertical_layer_collection_of_card", new WSVerticalPresenterFactory.8());
  }
  
  private static void i()
  {
    a.put("follow_tab", new WSVerticalPresenterFactory.10());
  }
  
  private static void j()
  {
    a.put("recommend_tab", new WSVerticalPresenterFactory.11());
  }
  
  private static void k()
  {
    a.put("aio_new_msg", new WSVerticalPresenterFactory.12());
  }
  
  private static void l()
  {
    a.put("drama_preview", new WSVerticalPresenterFactory.13());
  }
  
  private static void m()
  {
    a.put("drama_history", new WSVerticalPresenterFactory.14());
  }
  
  private static void n()
  {
    a.put("drama_collection", new WSVerticalPresenterFactory.15());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPresenterFactory
 * JD-Core Version:    0.7.0.1
 */