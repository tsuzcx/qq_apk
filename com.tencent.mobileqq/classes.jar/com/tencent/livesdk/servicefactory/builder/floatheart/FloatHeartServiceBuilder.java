package com.tencent.livesdk.servicefactory.builder.floatheart;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.floatheartservice.FloatHeartService;
import com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class FloatHeartServiceBuilder
  implements BaseServiceBuilder
{
  private static final String KEY_FLOAT_HEART_ICON_URL_CONFIG = "float_heart_icon_url";
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    FloatHeartService localFloatHeartService = new FloatHeartService();
    localFloatHeartService.init(new FloatHeartServiceBuilder.1(this, paramServiceAccessor));
    return localFloatHeartService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.floatheart.FloatHeartServiceBuilder
 * JD-Core Version:    0.7.0.1
 */