package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class StoryHomeFeed<T extends FeedItem>
{
  protected T f;
  public boolean g;
  
  public StoryHomeFeed(@NonNull T paramT)
  {
    AssertUtils.checkNotNull(paramT);
    this.f = paramT;
  }
  
  public static StoryHomeFeed a(int paramInt)
  {
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramInt);
    if (localFeedItem == null) {
      return null;
    }
    return localFeedItem.generateHomeFeed();
  }
  
  public abstract void a(int paramInt, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp, BatchGetFeedLikeRequest.BatchGetFeedLikeResp paramBatchGetFeedLikeResp);
  
  public abstract boolean a(qqstory_struct.StoryFeed paramStoryFeed);
  
  public abstract void b();
  
  public abstract void e();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (StoryHomeFeed)paramObject;
      FeedItem localFeedItem = this.f;
      if (localFeedItem != null) {
        return localFeedItem.equals(paramObject.f);
      }
      return paramObject.f == null;
    }
    return false;
  }
  
  public T g()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    FeedItem localFeedItem = this.f;
    if (localFeedItem != null) {
      return localFeedItem.hashCode();
    }
    return 0;
  }
  
  public List<StoryVideoItem> j()
  {
    return new ArrayList(0);
  }
  
  public String toString()
  {
    return this.f.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed
 * JD-Core Version:    0.7.0.1
 */