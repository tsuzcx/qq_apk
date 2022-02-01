package com.tencent.livesdk.servicefactory.builder.harvest;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.harvestservice.HarvestService;
import com.tencent.ilivesdk.harvestservice_interface.HarvestServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class HarvestServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    HarvestService localHarvestService = new HarvestService();
    localHarvestService.init(new HarvestServiceBuilder.1(this, paramServiceAccessor));
    return localHarvestService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.harvest.HarvestServiceBuilder
 * JD-Core Version:    0.7.0.1
 */