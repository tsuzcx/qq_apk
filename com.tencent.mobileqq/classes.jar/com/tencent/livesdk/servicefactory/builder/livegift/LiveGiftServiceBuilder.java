package com.tencent.livesdk.servicefactory.builder.livegift;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.giftservice.GiftService;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LiveGiftServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    GiftService localGiftService = new GiftService();
    localGiftService.init(new LiveGiftServiceBuilder.1(this, paramServiceAccessor));
    return localGiftService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.livegift.LiveGiftServiceBuilder
 * JD-Core Version:    0.7.0.1
 */