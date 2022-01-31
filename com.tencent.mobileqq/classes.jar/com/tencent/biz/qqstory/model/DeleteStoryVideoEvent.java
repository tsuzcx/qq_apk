package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class DeleteStoryVideoEvent
  extends BaseEvent
{
  public long a;
  public final String a;
  public final boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  
  public DeleteStoryVideoEvent(ErrorMessage paramErrorMessage, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    return "DeleteStoryVideoEvent{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", groupId='" + this.c + '\'' + ", feedId='" + this.d + '\'' + ", videoIndex=" + this.jdField_a_of_type_Long + ", localDelete=" + this.jdField_a_of_type_Boolean + ", isRemoveMember=" + this.jdField_b_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DeleteStoryVideoEvent
 * JD-Core Version:    0.7.0.1
 */