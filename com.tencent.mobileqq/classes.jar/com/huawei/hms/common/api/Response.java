package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

public class Response<T extends Result>
{
  protected T result;
  
  public Response() {}
  
  protected Response(T paramT)
  {
    this.result = paramT;
  }
  
  protected T getResult()
  {
    return this.result;
  }
  
  public void setResult(T paramT)
  {
    this.result = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.api.Response
 * JD-Core Version:    0.7.0.1
 */