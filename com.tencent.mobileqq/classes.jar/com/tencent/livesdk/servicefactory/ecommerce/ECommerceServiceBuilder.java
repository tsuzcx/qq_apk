package com.tencent.livesdk.servicefactory.ecommerce;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.ecommerceservice.ECommerceService;
import com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ECommerceServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    ECommerceService localECommerceService = new ECommerceService();
    localECommerceService.init(new ECommerceServiceBuilder.1(this, paramServiceAccessor));
    return localECommerceService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ecommerce.ECommerceServiceBuilder
 * JD-Core Version:    0.7.0.1
 */