package com.huawei.hms.api;

import com.huawei.hms.common.api.ConnectionPostProcessor;
import java.util.List;

public class Api<O extends Api.ApiOptions>
{
  private final String a;
  private final Api.Options<O> b;
  public List<ConnectionPostProcessor> mConnetctPostList;
  
  public Api(String paramString)
  {
    this.a = paramString;
    this.b = null;
  }
  
  public Api(String paramString, Api.Options<O> paramOptions)
  {
    this.a = paramString;
    this.b = paramOptions;
  }
  
  public String getApiName()
  {
    return this.a;
  }
  
  public Api.Options<O> getOptions()
  {
    return this.b;
  }
  
  public List<ConnectionPostProcessor> getmConnetctPostList()
  {
    return this.mConnetctPostList;
  }
  
  public void setmConnetctPostList(List<ConnectionPostProcessor> paramList)
  {
    this.mConnetctPostList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.Api
 * JD-Core Version:    0.7.0.1
 */