package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.List;

public class VideoListPageLoader$GetVideoListEvent
  extends BasePageLoaderEvent
{
  public FeedVideoInfo a;
  public String a;
  public List a;
  public String b;
  
  public VideoListPageLoader$GetVideoListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetVideoListEvent{mVideoItems=" + this.jdField_a_of_type_JavaUtilList.size() + ", feedId=" + this.jdField_a_of_type_JavaLangString + ", mUnionId=" + this.b + '}' + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent
 * JD-Core Version:    0.7.0.1
 */