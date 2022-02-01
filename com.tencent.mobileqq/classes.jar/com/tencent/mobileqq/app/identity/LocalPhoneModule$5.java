package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.loginwelcome.LocalPhoneGatewayCallback;
import java.util.List;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

class LocalPhoneModule$5
  extends LocalPhoneGatewayCallback
{
  LocalPhoneModule$5(LocalPhoneModule paramLocalPhoneModule, int paramInt, LocalPhoneModule.UrlTokenCallback paramUrlTokenCallback)
  {
    super(paramInt);
  }
  
  public void a(int paramInt, Exception paramException)
  {
    this.a.a(paramInt, paramException);
  }
  
  public void a(List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    LocalPhoneModule localLocalPhoneModule = this.b;
    LocalPhoneModule.a(localLocalPhoneModule, paramList, LocalPhoneModule.f(localLocalPhoneModule));
    LocalPhoneModule.f(this.b).clear();
    LocalPhoneModule.f(this.b).addAll(paramList);
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.5
 * JD-Core Version:    0.7.0.1
 */