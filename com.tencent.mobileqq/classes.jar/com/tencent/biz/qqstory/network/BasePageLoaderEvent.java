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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"_class\":\"BasePageLoaderEvent\", \"errorInfo\":\"");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuilder.append("\", \"isEnd\":\"");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\", \"isLocalData\":\"");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\", \"isFirstPage\":\"");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BasePageLoaderEvent
 * JD-Core Version:    0.7.0.1
 */