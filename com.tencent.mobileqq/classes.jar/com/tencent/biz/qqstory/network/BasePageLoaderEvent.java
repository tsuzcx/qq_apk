package com.tencent.biz.qqstory.network;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class BasePageLoaderEvent
  extends BaseEvent
{
  public boolean a;
  public boolean b = false;
  public boolean c = true;
  public boolean d = false;
  
  public BasePageLoaderEvent(ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
  }
  
  public String toString()
  {
    return "{\"_class\":\"BasePageLoaderEvent\", \"errorInfo\":\"" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + "\", \"isEnd\":\"" + this.jdField_a_of_type_Boolean + "\", \"isLocalData\":\"" + this.b + "\", \"isFirstPage\":\"" + this.c + "\"}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BasePageLoaderEvent
 * JD-Core Version:    0.7.0.1
 */