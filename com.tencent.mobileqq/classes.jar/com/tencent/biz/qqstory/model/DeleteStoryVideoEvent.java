package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class DeleteStoryVideoEvent
  extends BaseEvent
{
  public final String a;
  public String b;
  public String c;
  public String d;
  public long e;
  public final boolean f;
  public boolean h;
  
  public DeleteStoryVideoEvent(ErrorMessage paramErrorMessage, String paramString, boolean paramBoolean)
  {
    this.g = paramErrorMessage;
    this.a = paramString;
    this.f = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeleteStoryVideoEvent{vid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", localDelete=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isRemoveMember=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DeleteStoryVideoEvent
 * JD-Core Version:    0.7.0.1
 */