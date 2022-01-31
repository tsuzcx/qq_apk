package com.tencent.biz.qqstory.network;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class BasePageLoaderEvent
  extends BaseEvent
{
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  
  public BasePageLoaderEvent(ErrorMessage paramErrorMessage)
  {
    this.errorInfo = paramErrorMessage;
  }
  
  public String toString()
  {
    return "{\"_class\":\"BasePageLoaderEvent\", \"errorInfo\":\"" + this.errorInfo + "\", \"isEnd\":\"" + this.a + "\", \"isLocalData\":\"" + this.b + "\", \"isFirstPage\":\"" + this.c + "\"}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BasePageLoaderEvent
 * JD-Core Version:    0.7.0.1
 */