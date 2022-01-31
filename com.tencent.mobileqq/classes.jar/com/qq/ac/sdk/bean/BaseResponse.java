package com.qq.ac.sdk.bean;

import java.util.List;
import java.util.Map;

public abstract class BaseResponse<T>
{
  protected List<T> listData;
  protected Map<String, T> mapData;
  private int statusCode;
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public final void setData(List<T> paramList)
  {
    this.listData = paramList;
  }
  
  public final void setMapData(Map<String, T> paramMap)
  {
    this.mapData = paramMap;
  }
  
  public final void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.bean.BaseResponse
 * JD-Core Version:    0.7.0.1
 */