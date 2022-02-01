package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class CommentListPageLoader$GetFeedCommentEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List<CommentEntry> a;
  public int b;
  public String b;
  public int c;
  
  public CommentListPageLoader$GetFeedCommentEvent(ErrorMessage paramErrorMessage, String paramString, int paramInt)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetFeedCommentEvent{feedId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mSource=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mCommentEntries=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append(", mTotalCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent
 * JD-Core Version:    0.7.0.1
 */