package com.tencent.biz.qqstory.storyHome.discover.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class DiscoverPagerLoader$GetDiscoverCardsEvent
  extends BasePageLoaderEvent
{
  public int a;
  public long a;
  public List a;
  
  public DiscoverPagerLoader$GetDiscoverCardsEvent(ErrorMessage paramErrorMessage, int paramInt, long paramLong)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    return "GetDiscoverCardsEvent{mCommentEntries=" + this.jdField_a_of_type_JavaUtilList.size() + ", mListType=" + this.jdField_a_of_type_Int + ", mTopicId=" + this.jdField_a_of_type_Long + '}' + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader.GetDiscoverCardsEvent
 * JD-Core Version:    0.7.0.1
 */