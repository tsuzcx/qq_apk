package com.squareup.okhttp;

public abstract interface Interceptor$Chain
{
  public abstract Connection connection();
  
  public abstract Response proceed(Request paramRequest);
  
  public abstract Request request();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Interceptor.Chain
 * JD-Core Version:    0.7.0.1
 */