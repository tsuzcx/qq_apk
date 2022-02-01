package com.tencent.ilivesdk.ecommerceservice_interface;

import com.tencent.ilivesdk.ecommerceservice_interface.model.GoodOnsaleBean;

public abstract interface ECommerceServiceInterface$ECommerceServiceCallBack
{
  public abstract void onError(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onGetCurrentGoodInfo(long paramLong, String paramString, GoodOnsaleBean paramGoodOnsaleBean);
  
  public abstract void onGetSelectedGoodsNum(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceInterface.ECommerceServiceCallBack
 * JD-Core Version:    0.7.0.1
 */