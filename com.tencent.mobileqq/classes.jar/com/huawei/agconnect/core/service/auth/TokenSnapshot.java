package com.huawei.agconnect.core.service.auth;

public abstract interface TokenSnapshot
{
  public abstract TokenSnapshot.State getState();
  
  public abstract String getToken();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.core.service.auth.TokenSnapshot
 * JD-Core Version:    0.7.0.1
 */