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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeleteStoryVideoEvent{vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", localDelete=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isRemoveMember=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DeleteStoryVideoEvent
 * JD-Core Version:    0.7.0.1
 */