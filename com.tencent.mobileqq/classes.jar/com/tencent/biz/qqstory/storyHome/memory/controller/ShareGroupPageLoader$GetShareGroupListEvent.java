package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupPageLoader$GetShareGroupListEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List a;
  
  public ShareGroupPageLoader$GetShareGroupListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetShareGroupListEvent{mShareGroupList=" + this.jdField_a_of_type_JavaUtilList.size() + ", mShareGroupTotalCount=" + this.jdField_a_of_type_Int + ", errorCode=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + ", isLocalData=" + this.b + ", isFirstPage=" + this.c + ", isEnd=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.GetShareGroupListEvent
 * JD-Core Version:    0.7.0.1
 */