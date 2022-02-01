package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;

public final class StoryVideoUploadManager$ShareGroupFakeItem
{
  public ShareGroupFeedItem a;
  public VideoListFeedItem a;
  public ArrayList<StoryVideoUploadManager.OneVideoInfo> a;
  
  public StoryVideoUploadManager$ShareGroupFakeItem()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShareGroupFakeItem{mFeedItem=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
    localStringBuilder.append(", mSucFeedItem=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem);
    localStringBuilder.append(", mVideos=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.ShareGroupFakeItem
 * JD-Core Version:    0.7.0.1
 */