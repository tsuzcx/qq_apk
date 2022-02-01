package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;

public class WatchVideoHandler$WatchVideoEvent
  extends BaseEvent
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchVideoEvent{vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isLiveVideo=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", unReadCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent
 * JD-Core Version:    0.7.0.1
 */