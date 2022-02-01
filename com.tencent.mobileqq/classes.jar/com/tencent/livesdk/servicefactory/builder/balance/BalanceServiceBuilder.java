package com.tencent.livesdk.servicefactory.builder.balance;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.balanceservice.BalanceService;
import com.tencent.ilivesdk.balanceservice_interface.BalanceServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class BalanceServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    BalanceService localBalanceService = new BalanceService();
    localBalanceService.init(new BalanceServiceBuilder.1(this, paramServiceAccessor));
    return localBalanceService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.balance.BalanceServiceBuilder
 * JD-Core Version:    0.7.0.1
 */