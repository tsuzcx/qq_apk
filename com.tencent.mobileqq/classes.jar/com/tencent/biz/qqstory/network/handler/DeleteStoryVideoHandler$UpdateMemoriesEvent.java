package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.ArrayList;

public class DeleteStoryVideoHandler$UpdateMemoriesEvent
  extends BaseEvent
{
  public final int a;
  public ArrayList a;
  
  public DeleteStoryVideoHandler$UpdateMemoriesEvent(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "UpdateMemoriesEvent{dateList=" + this.jdField_a_of_type_JavaUtilArrayList + ", source=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler.UpdateMemoriesEvent
 * JD-Core Version:    0.7.0.1
 */