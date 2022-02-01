package com.tencent.livesdk.servicefactory.builder.violationstrike;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.violationstrikeservice.ViolationStrikeService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ViolationStrikeBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    ViolationStrikeService localViolationStrikeService = new ViolationStrikeService();
    localViolationStrikeService.init(new ViolationStrikeBuilder.1(this, paramServiceAccessor));
    return localViolationStrikeService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.violationstrike.ViolationStrikeBuilder
 * JD-Core Version:    0.7.0.1
 */