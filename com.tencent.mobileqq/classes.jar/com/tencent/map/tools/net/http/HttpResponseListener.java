package com.tencent.map.tools.net.http;

public abstract interface HttpResponseListener<T>
{
  public abstract void onFailure(int paramInt, String paramString, Throwable paramThrowable);
  
  public abstract void onSuccess(int paramInt, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpResponseListener
 * JD-Core Version:    0.7.0.1
 */