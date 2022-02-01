package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.FeedCommentInfo;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.FeedLikeInfo;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class CommentLikeHomeFeed<T extends CommentLikeFeedItem>
  extends StoryHomeFeed<T>
{
  protected List<CommentEntry> a = new ArrayList(0);
  protected HashSet<Integer> b = new HashSet();
  protected List<LikeEntry> c = new ArrayList(0);
  protected HashSet<String> d = new HashSet();
  
  public CommentLikeHomeFeed(@NonNull T paramT)
  {
    super(paramT);
  }
  
  private BatchGetFeedCommentRequest.FeedCommentInfo a(int paramInt, CommentLikeHomeFeed paramCommentLikeHomeFeed, BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp)
  {
    List localList = paramBatchGetFeedCommentResp.a;
    if (paramInt < localList.size()) {
      paramBatchGetFeedCommentResp = (BatchGetFeedCommentRequest.FeedCommentInfo)localList.get(paramInt);
    } else {
      paramBatchGetFeedCommentResp = null;
    }
    if ((paramBatchGetFeedCommentResp != null) && (paramBatchGetFeedCommentResp.a.equals(paramCommentLikeHomeFeed.f.feedId))) {
      return paramBatchGetFeedCommentResp;
    }
    paramBatchGetFeedCommentResp = new BatchGetFeedCommentRequest.FeedCommentInfo();
    paramBatchGetFeedCommentResp.a = paramCommentLikeHomeFeed.f.feedId;
    paramInt = localList.indexOf(paramBatchGetFeedCommentResp);
    if (paramInt >= 0) {
      return (BatchGetFeedCommentRequest.FeedCommentInfo)localList.get(paramInt);
    }
    SLog.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramCommentLikeHomeFeed.f.feedId });
    return null;
  }
  
  @Nullable
  private BatchGetFeedLikeRequest.FeedLikeInfo a(int paramInt, CommentLikeHomeFeed paramCommentLikeHomeFeed, BatchGetFeedLikeRequest.BatchGetFeedLikeResp paramBatchGetFeedLikeResp)
  {
    List localList = paramBatchGetFeedLikeResp.a;
    if (paramInt < localList.size()) {
      paramBatchGetFeedLikeResp = (BatchGetFeedLikeRequest.FeedLikeInfo)localList.get(paramInt);
    } else {
      paramBatchGetFeedLikeResp = null;
    }
    if ((paramBatchGetFeedLikeResp != null) && (paramBatchGetFeedLikeResp.a.equals(paramCommentLikeHomeFeed.f.feedId))) {
      return paramBatchGetFeedLikeResp;
    }
    paramBatchGetFeedLikeResp = new BatchGetFeedLikeRequest.FeedLikeInfo();
    paramBatchGetFeedLikeResp.a = paramCommentLikeHomeFeed.f.feedId;
    paramInt = localList.indexOf(paramBatchGetFeedLikeResp);
    if (paramInt >= 0) {
      return (BatchGetFeedLikeRequest.FeedLikeInfo)localList.get(paramInt);
    }
    SLog.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramCommentLikeHomeFeed.f.feedId });
    return null;
  }
  
  public abstract List<StoryVideoItem> a();
  
  public void a(int paramInt, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp, BatchGetFeedLikeRequest.BatchGetFeedLikeResp paramBatchGetFeedLikeResp)
  {
    if ((paramBatchGetFeedCommentResp != null) && (paramBatchGetFeedCommentResp.c == 0))
    {
      paramGetFriendStoryFeedInfoResp = a(paramInt, this, paramBatchGetFeedCommentResp);
      if (paramGetFriendStoryFeedInfoResp != null)
      {
        a(paramGetFriendStoryFeedInfoResp.e, true);
        ((CommentLikeFeedItem)this.f).mCommentCount = paramGetFriendStoryFeedInfoResp.b;
        ((CommentLikeFeedItem)this.f).mCommentIsEnd = paramGetFriendStoryFeedInfoResp.c;
        ((CommentLikeFeedItem)this.f).mCommentLastCookie = paramGetFriendStoryFeedInfoResp.d;
      }
    }
    if ((paramBatchGetFeedLikeResp != null) && (paramBatchGetFeedLikeResp.c == 0))
    {
      paramGetFriendStoryFeedInfoResp = a(paramInt, this, paramBatchGetFeedLikeResp);
      if (paramGetFriendStoryFeedInfoResp != null)
      {
        b(paramGetFriendStoryFeedInfoResp.d, true);
        ((CommentLikeFeedItem)this.f).mLikeCount = paramGetFriendStoryFeedInfoResp.b;
        ((CommentLikeFeedItem)this.f).mHadLike = paramGetFriendStoryFeedInfoResp.c;
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (!this.b.contains(Integer.valueOf(paramCommentEntry.commentId))) {
      this.b.add(Integer.valueOf(paramCommentEntry.commentId));
    }
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.clear();
      this.b.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)paramList.next();
      if (this.b.contains(Integer.valueOf(localCommentEntry.commentId))) {
        this.a.remove(localCommentEntry);
      } else {
        this.b.add(Integer.valueOf(localCommentEntry.commentId));
      }
      this.a.add(localCommentEntry);
    }
  }
  
  public void b(List<LikeEntry> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.clear();
      this.d.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.next();
      if (this.d.contains(localLikeEntry.unionId)) {
        this.c.remove(localLikeEntry);
      } else {
        this.d.add(localLikeEntry.unionId);
      }
      this.c.add(localLikeEntry);
    }
  }
  
  public T c()
  {
    return (CommentLikeFeedItem)super.g();
  }
  
  public List<CommentEntry> d()
  {
    return this.a;
  }
  
  public void e()
  {
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    LikeManager localLikeManager = (LikeManager)SuperManager.a(15);
    a(localCommentManager.a(((CommentLikeFeedItem)this.f).feedId, false), true);
    b(localLikeManager.a(((CommentLikeFeedItem)this.f).feedId, false), true);
  }
  
  public List<LikeEntry> f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed
 * JD-Core Version:    0.7.0.1
 */