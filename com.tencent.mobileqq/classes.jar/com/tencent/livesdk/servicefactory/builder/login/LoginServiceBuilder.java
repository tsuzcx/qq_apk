package com.tencent.livesdk.servicefactory.builder.login;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.loginservice.LoginServiceImpl;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LoginServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LoginServiceImpl localLoginServiceImpl = new LoginServiceImpl();
    localLoginServiceImpl.init(new LoginServiceBuilder.1(this, paramServiceAccessor));
    return localLoginServiceImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.login.LoginServiceBuilder
 * JD-Core Version:    0.7.0.1
 */