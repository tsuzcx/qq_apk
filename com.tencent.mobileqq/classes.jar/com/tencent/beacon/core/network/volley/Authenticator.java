package com.tencent.beacon.core.network.volley;

public abstract interface Authenticator
{
  public abstract String getAuthToken();
  
  public abstract void invalidateAuthToken(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Authenticator
 * JD-Core Version:    0.7.0.1
 */