package com.tencent.featuretoggle.hltxkg.access.http;

public abstract interface IHttpClient
{
  public abstract IHttpRequest createRequest(String paramString, byte[] paramArrayOfByte);
  
  public abstract void enqueue(IHttpRequest paramIHttpRequest, IHttpCallback paramIHttpCallback);
  
  public abstract IHttpResponse execute(IHttpRequest paramIHttpRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.IHttpClient
 * JD-Core Version:    0.7.0.1
 */