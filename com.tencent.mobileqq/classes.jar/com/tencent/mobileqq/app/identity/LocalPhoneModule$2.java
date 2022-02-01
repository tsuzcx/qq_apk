package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.servlet.LocalPhoneServlet;
import java.util.List;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

class LocalPhoneModule$2
  implements LocalPhoneModule.UrlTokenCallback
{
  public void a(int paramInt, Exception paramException)
  {
    this.a.a(paramInt, paramException);
  }
  
  public void a(List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    paramList = LocalPhoneServlet.a(LocalPhoneModule.a(this.b), LocalPhoneModule.b(this.b), LocalPhoneModule.c(this.b), LocalPhoneModule.d(this.b), "", "", LocalPhoneModule.e(this.b), paramList);
    LocalPhoneModule.a(this.b, paramList, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.2
 * JD-Core Version:    0.7.0.1
 */