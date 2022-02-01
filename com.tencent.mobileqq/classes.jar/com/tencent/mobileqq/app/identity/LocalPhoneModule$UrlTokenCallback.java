package com.tencent.mobileqq.app.identity;

import java.util.List;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

public abstract interface LocalPhoneModule$UrlTokenCallback
{
  public abstract void a(int paramInt, Exception paramException);
  
  public abstract void a(List<GetLocalPhone.LocalPhoneCodeData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.UrlTokenCallback
 * JD-Core Version:    0.7.0.1
 */