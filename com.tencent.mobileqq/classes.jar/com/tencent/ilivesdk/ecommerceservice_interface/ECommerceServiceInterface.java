package com.tencent.ilivesdk.ecommerceservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface ECommerceServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addGoodsPushListener(ECommerceServiceInterface.GoodsPushListener paramGoodsPushListener);
  
  public abstract void getCurrentGoodInfo(ECommerceServiceInterface.ECommerceServiceCallBack paramECommerceServiceCallBack, boolean paramBoolean);
  
  public abstract int getSelectedGoodsNum();
  
  public abstract void getSelectedGoodsNum(ECommerceServiceInterface.ECommerceServiceCallBack paramECommerceServiceCallBack);
  
  public abstract void init(ECommerceServiceAdapter paramECommerceServiceAdapter);
  
  public abstract void removeGoodsPushListener(ECommerceServiceInterface.GoodsPushListener paramGoodsPushListener);
  
  public abstract void setSelectedGoodsNum(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceInterface
 * JD-Core Version:    0.7.0.1
 */