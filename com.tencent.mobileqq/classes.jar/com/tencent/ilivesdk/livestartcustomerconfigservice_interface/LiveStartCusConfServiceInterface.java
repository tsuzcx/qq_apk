package com.tencent.ilivesdk.livestartcustomerconfigservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LiveStartCusConfServiceInterface
  extends ServiceBaseInterface
{
  public abstract boolean getCommodityEnabled();
  
  public abstract String getGoodsUrl();
  
  public abstract void init(LiveStartCusConfServiceAdapter paramLiveStartCusConfServiceAdapter);
  
  public abstract void setCommodityEnabled(boolean paramBoolean);
  
  public abstract void setGoodsUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.livestartcustomerconfigservice_interface.LiveStartCusConfServiceInterface
 * JD-Core Version:    0.7.0.1
 */