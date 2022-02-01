package com.tencent.biz.pubaccount.weishi_new.presenter.view;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;

public abstract interface IWSHomeView
  extends IWSBaseView
{
  public abstract void a(stGetTabsRsp paramstGetTabsRsp);
  
  public abstract void a(stPublisherRsp paramstPublisherRsp);
  
  public abstract void a(stRedDotRsp paramstRedDotRsp);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView
 * JD-Core Version:    0.7.0.1
 */