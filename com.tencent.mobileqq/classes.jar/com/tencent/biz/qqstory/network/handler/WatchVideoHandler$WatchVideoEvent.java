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
    return "WatchVideoEvent{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uin=" + this.b + ", isLiveVideo=" + this.jdField_a_of_type_Boolean + ", unReadCount=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent
 * JD-Core Version:    0.7.0.1
 */