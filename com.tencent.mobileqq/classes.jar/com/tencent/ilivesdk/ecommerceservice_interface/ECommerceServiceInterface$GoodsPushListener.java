package com.tencent.ilivesdk.ecommerceservice_interface;

import com.tencent.ilivesdk.ecommerceservice_interface.model.GoodOnsaleBean;

public abstract interface ECommerceServiceInterface$GoodsPushListener
{
  public abstract void onPushGoodsNumber(int paramInt);
  
  public abstract void onPushGoodsRecommend(GoodOnsaleBean paramGoodOnsaleBean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceInterface.GoodsPushListener
 * JD-Core Version:    0.7.0.1
 */