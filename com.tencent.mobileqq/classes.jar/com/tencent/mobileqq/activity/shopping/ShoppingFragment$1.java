package com.tencent.mobileqq.activity.shopping;

import cooperation.qzone.mobilereport.MobileReportManager;

class ShoppingFragment$1
  implements ShoppingHeadView.OnClickEventListener
{
  ShoppingFragment$1(ShoppingFragment paramShoppingFragment) {}
  
  public void a()
  {
    ShoppingFragment.a(this.a, 1, 0);
    MobileReportManager.getInstance().reportActionLive("paying", "4", "qq_live", "shopcart_page", "order_paying_btn", 102, 1, System.currentTimeMillis(), "");
  }
  
  public void b()
  {
    ShoppingFragment.a(this.a, 1, 1);
    MobileReportManager.getInstance().reportActionLive("inqueue", "4", "qq_live", "shopcart_page", "order_inqueue_btn", 102, 1, System.currentTimeMillis(), "");
  }
  
  public void c()
  {
    ShoppingFragment.a(this.a, 1, 2);
    MobileReportManager.getInstance().reportActionLive("ship", "4", "qq_live", "shopcart_page", "order_ship_btn", 102, 1, System.currentTimeMillis(), "");
  }
  
  public void d()
  {
    ShoppingFragment.a(this.a, 1, 4);
    MobileReportManager.getInstance().reportActionLive("service", "4", "qq_live", "shopcart_page", "order_service_btn", 102, 1, System.currentTimeMillis(), "");
  }
  
  public void e()
  {
    ShoppingFragment.a(this.a, 0, 0);
    MobileReportManager.getInstance().reportActionLive("all", "4", "qq_live", "shopcart_page", "order_all_btn", 102, 1, System.currentTimeMillis(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment.1
 * JD-Core Version:    0.7.0.1
 */