package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
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

public abstract class CommentLikeHomeFeed
  extends StoryHomeFeed
{
  protected HashSet a;
  protected List a;
  protected HashSet b;
  protected List b;
  
  public CommentLikeHomeFeed(@NonNull CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    super(paramCommentLikeFeedItem);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private BatchGetFeedCommentRequest.FeedCommentInfo a(int paramInt, CommentLikeHomeFeed paramCommentLikeHomeFeed, BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp)
  {
    List localList = paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramBatchGetFeedCommentResp = (BatchGetFeedCommentRequest.FeedCommentInfo)localList.get(paramInt);; paramBatchGetFeedCommentResp = null)
    {
      if ((paramBatchGetFeedCommentResp != null) && (paramBatchGetFeedCommentResp.jdField_a_of_type_JavaLangString.equals(paramCommentLikeHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramBatchGetFeedCommentResp;
      }
      paramBatchGetFeedCommentResp = new BatchGetFeedCommentRequest.FeedCommentInfo();
      paramBatchGetFeedCommentResp.jdField_a_of_type_JavaLangString = paramCommentLikeHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramBatchGetFeedCommentResp);
      if (paramInt >= 0) {
        return (BatchGetFeedCommentRequest.FeedCommentInfo)localList.get(paramInt);
      }
      SLog.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramCommentLikeHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  @Nullable
  private BatchGetFeedLikeRequest.FeedLikeInfo a(int paramInt, CommentLikeHomeFeed paramCommentLikeHomeFeed, BatchGetFeedLikeRequest.BatchGetFeedLikeResp paramBatchGetFeedLikeResp)
  {
    List localList = paramBatchGetFeedLikeResp.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramBatchGetFeedLikeResp = (BatchGetFeedLikeRequest.FeedLikeInfo)localList.get(paramInt);; paramBatchGetFeedLikeResp = null)
    {
      if ((paramBatchGetFeedLikeResp != null) && (paramBatchGetFeedLikeResp.jdField_a_of_type_JavaLangString.equals(paramCommentLikeHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramBatchGetFeedLikeResp;
      }
      paramBatchGetFeedLikeResp = new BatchGetFeedLikeRequest.FeedLikeInfo();
      paramBatchGetFeedLikeResp.jdField_a_of_type_JavaLangString = paramCommentLikeHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramBatchGetFeedLikeResp);
      if (paramInt >= 0) {
        return (BatchGetFeedLikeRequest.FeedLikeInfo)localList.get(paramInt);
      }
      SLog.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramCommentLikeHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  public CommentLikeFeedItem a()
  {
    return (CommentLikeFeedItem)super.a();
  }
  
  public abstract List a();
  
  public void a(int paramInt, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp, BatchGetFeedLikeRequest.BatchGetFeedLikeResp paramBatchGetFeedLikeResp)
  {
    if ((paramBatchGetFeedCommentResp != null) && (paramBatchGetFeedCommentResp.jdField_a_of_type_Int == 0))
    {
      paramGetFriendStoryFeedInfoResp = a(paramInt, this, paramBatchGetFeedCommentResp);
      if (paramGetFriendStoryFeedInfoResp != null)
      {
        a(paramGetFriendStoryFeedInfoResp.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentCount = paramGetFriendStoryFeedInfoResp.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentIsEnd = paramGetFriendStoryFeedInfoResp.jdField_b_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie = paramGetFriendStoryFeedInfoResp.jdField_b_of_type_JavaLangString;
      }
    }
    if ((paramBatchGetFeedLikeResp != null) && (paramBatchGetFeedLikeResp.jdField_a_of_type_Int == 0))
    {
      paramGetFriendStoryFeedInfoResp = a(paramInt, this, paramBatchGetFeedLikeResp);
      if (paramGetFriendStoryFeedInfoResp != null)
      {
        b(paramGetFriendStoryFeedInfoResp.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mLikeCount = paramGetFriendStoryFeedInfoResp.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mHadLike = paramGetFriendStoryFeedInfoResp.jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramCommentEntry.commentId))) {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramCommentEntry.commentId));
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)paramList.next();
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localCommentEntry.commentId))) {
        this.jdField_a_of_type_JavaUtilList.remove(localCommentEntry);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
        break;
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localCommentEntry.commentId));
      }
    }
  }
  
  public List b()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void b()
  {
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    LikeManager localLikeManager = (LikeManager)SuperManager.a(15);
    a(localCommentManager.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
    b(localLikeManager.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
  }
  
  public void b(List paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.next();
      if (this.jdField_b_of_type_JavaUtilHashSet.contains(localLikeEntry.unionId)) {
        this.jdField_b_of_type_JavaUtilList.remove(localLikeEntry);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilList.add(localLikeEntry);
        break;
        this.jdField_b_of_type_JavaUtilHashSet.add(localLikeEntry.unionId);
      }
    }
  }
  
  public List c()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed
 * JD-Core Version:    0.7.0.1
 */