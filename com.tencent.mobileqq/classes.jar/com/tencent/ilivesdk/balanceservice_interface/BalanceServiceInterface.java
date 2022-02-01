package com.tencent.ilivesdk.balanceservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface BalanceServiceInterface
  extends ServiceBaseInterface
{
  public abstract void init(BalanceServiceAdapter paramBalanceServiceAdapter);
  
  public abstract void queryTBalance(QueryTBalanceReq paramQueryTBalanceReq, BalanceServiceInterface.QueryTBalanceCallback paramQueryTBalanceCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.balanceservice_interface.BalanceServiceInterface
 * JD-Core Version:    0.7.0.1
 */