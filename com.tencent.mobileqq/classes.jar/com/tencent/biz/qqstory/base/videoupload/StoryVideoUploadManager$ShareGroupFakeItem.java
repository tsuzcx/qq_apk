package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;

public final class StoryVideoUploadManager$ShareGroupFakeItem
{
  public VideoListFeedItem a;
  public ShareGroupFeedItem b;
  public ArrayList<StoryVideoUploadManager.OneVideoInfo> c = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShareGroupFakeItem{mFeedItem=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mSucFeedItem=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mVideos=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.ShareGroupFakeItem
 * JD-Core Version:    0.7.0.1
 */