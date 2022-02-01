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
  protected T a;
  public boolean b;
  
  public StoryHomeFeed(@NonNull T paramT)
  {
    AssertUtils.a(paramT);
    this.a = paramT;
  }
  
  public static StoryHomeFeed a(int paramInt)
  {
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramInt);
    if (localFeedItem == null) {
      return null;
    }
    return localFeedItem.generateHomeFeed();
  }
  
  public T a()
  {
    return this.a;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp, BatchGetFeedLikeRequest.BatchGetFeedLikeResp paramBatchGetFeedLikeResp);
  
  public abstract boolean a(qqstory_struct.StoryFeed paramStoryFeed);
  
  public abstract void b();
  
  public List<StoryVideoItem> d()
  {
    return new ArrayList(0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (StoryHomeFeed)paramObject;
      if (this.a != null) {
        return this.a.equals(paramObject.a);
      }
    } while (paramObject.a == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed
 * JD-Core Version:    0.7.0.1
 */