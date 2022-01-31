package com.squareup.okhttp;

import java.net.Proxy;

public abstract interface Authenticator
{
  public abstract Request authenticate(Proxy paramProxy, Response paramResponse);
  
  public abstract Request authenticateProxy(Proxy paramProxy, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Authenticator
 * JD-Core Version:    0.7.0.1
 */