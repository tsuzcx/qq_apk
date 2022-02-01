package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class FeedListPageLoaderBase$FeedData
  extends BasePageLoaderEvent
{
  public List<String> a = new ArrayList();
  
  public FeedListPageLoaderBase$FeedData(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String toString()
  {
    return "FeedData{" + super.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedData
 * JD-Core Version:    0.7.0.1
 */