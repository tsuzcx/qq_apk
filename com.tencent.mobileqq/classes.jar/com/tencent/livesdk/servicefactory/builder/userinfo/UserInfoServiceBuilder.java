package com.tencent.livesdk.servicefactory.builder.userinfo;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.userinfoservice.UserInfoService;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class UserInfoServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    UserInfoService localUserInfoService = new UserInfoService();
    localUserInfoService.init(new UserInfoServiceBuilder.1(this, paramServiceAccessor));
    return localUserInfoService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.userinfo.UserInfoServiceBuilder
 * JD-Core Version:    0.7.0.1
 */