package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class DateCollectionListPageLoader$GetCollectionListEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List<VideoCollectionItem> a;
  public String b;
  public boolean e = true;
  
  public DateCollectionListPageLoader$GetCollectionListEvent(String paramString, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetCollectionListEvent{isEnd=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isUpdated=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isLocalData=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isFirstPage=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isRefreshFromLoadMore=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", collectionList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", totalVideoCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", context='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent
 * JD-Core Version:    0.7.0.1
 */