package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupPageLoader$GetShareGroupListEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List<ShareGroupCollectionItem> a;
  
  public ShareGroupPageLoader$GetShareGroupListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupListEvent{mShareGroupList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append(", mShareGroupTotalCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode);
    localStringBuilder.append(", isLocalData=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isFirstPage=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.GetShareGroupListEvent
 * JD-Core Version:    0.7.0.1
 */