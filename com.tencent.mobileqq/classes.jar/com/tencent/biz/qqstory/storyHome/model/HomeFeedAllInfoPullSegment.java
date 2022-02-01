package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class HomeFeedAllInfoPullSegment
  extends JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, HomeFeedData>
{
  private Vector<NetworkRequest> a = new Vector(5);
  private BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp b;
  private BatchGetFeedCommentRequest.BatchGetFeedCommentResp c;
  private BatchGetFeedLikeRequest.BatchGetFeedLikeResp d;
  private GetFeedFeatureResponse e;
  
  private FeedFeatureItem a(int paramInt, CommentLikeHomeFeed paramCommentLikeHomeFeed)
  {
    List localList = this.e.a;
    if (paramInt < localList.size()) {
      localFeedFeatureItem = (FeedFeatureItem)localList.get(paramInt);
    } else {
      localFeedFeatureItem = null;
    }
    if ((localFeedFeatureItem != null) && (localFeedFeatureItem.a.equals(paramCommentLikeHomeFeed.f.feedId))) {
      return localFeedFeatureItem;
    }
    FeedFeatureItem localFeedFeatureItem = new FeedFeatureItem();
    localFeedFeatureItem.a = paramCommentLikeHomeFeed.f.feedId;
    paramInt = localList.indexOf(localFeedFeatureItem);
    if (paramInt >= 0) {
      return (FeedFeatureItem)localList.get(paramInt);
    }
    SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "can't not find feed like for id:%s", new Object[] { paramCommentLikeHomeFeed.f.feedId });
    return null;
  }
  
  private void a(FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    Object localObject1 = this.b;
    boolean bool3 = true;
    int i = 0;
    boolean bool1;
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.c != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (this.d == null) {
      bool3 = false;
    }
    SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed info resp basic info:%b, comment %b, like %b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
    if (!this.a.isEmpty()) {
      return;
    }
    localObject1 = this.b;
    if ((localObject1 != null) && (((BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)localObject1).c == 0))
    {
      localObject1 = (FeedManager)SuperManager.a(11);
      HomeFeedData localHomeFeedData = new HomeFeedData(new ErrorMessage());
      localHomeFeedData.c = paramGetFeedIdListResult.b;
      localHomeFeedData.a = paramGetFeedIdListResult.c;
      localHomeFeedData.e = new ArrayList();
      Object localObject2 = this.b.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StoryHomeFeed)((Iterator)localObject2).next();
        localHomeFeedData.e.add(((StoryHomeFeed)localObject3).f.feedId);
      }
      localHomeFeedData.f = this.b.a;
      localObject2 = this.b.a.iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StoryHomeFeed)((Iterator)localObject2).next();
        ((StoryHomeFeed)localObject3).a(i, this.b, this.c, this.d);
        if ((localObject3 instanceof CommentLikeHomeFeed))
        {
          localObject3 = (CommentLikeHomeFeed)localObject3;
          if (this.e != null)
          {
            localObject4 = a(i, (CommentLikeHomeFeed)localObject3);
            if (localObject4 != null)
            {
              ((CommentLikeHomeFeed)localObject3).c().mViewTotalTime = ((FeedFeatureItem)localObject4).d;
              SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "get feature feedId=%s, view total=%d", ((CommentLikeHomeFeed)localObject3).f.feedId, Long.valueOf(((CommentLikeHomeFeed)localObject3).c().mViewTotalTime));
            }
          }
        }
        i += 1;
      }
      localObject2 = this.b.a.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StoryHomeFeed)((Iterator)localObject2).next()).b();
      }
      localObject2 = new ArrayList(localHomeFeedData.f.size());
      Object localObject3 = localHomeFeedData.f.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject2).add(((StoryHomeFeed)((Iterator)localObject3).next()).f);
      }
      localObject2 = ((FeedManager)localObject1).a((List)localObject2);
      localObject3 = localHomeFeedData.f.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (StoryHomeFeed)((Iterator)localObject3).next();
        i = ((List)localObject2).indexOf(((StoryHomeFeed)localObject4).f);
        if (i >= 0)
        {
          ((StoryHomeFeed)localObject4).f = ((FeedItem)((List)localObject2).get(i));
          ((StoryHomeFeed)localObject4).f.onRefresh();
        }
      }
      if (paramGetFeedIdListResult.b) {
        ((FeedManager)localObject1).f().a();
      }
      paramGetFeedIdListResult = this.c;
      if (paramGetFeedIdListResult != null)
      {
        SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "need sync comment size:%d", Integer.valueOf(paramGetFeedIdListResult.b.size()));
        if ((this.c.c == 0) && (this.c.b.size() > 0)) {
          ((FeedManager)localObject1).f().a(this.c.b);
        }
      }
      notifyResult(localHomeFeedData);
      return;
    }
    paramGetFeedIdListResult = this.b;
    if (paramGetFeedIdListResult == null) {
      i = 940001;
    } else {
      i = paramGetFeedIdListResult.c;
    }
    paramGetFeedIdListResult = this.b;
    if (paramGetFeedIdListResult == null) {
      paramGetFeedIdListResult = "";
    } else {
      paramGetFeedIdListResult = paramGetFeedIdListResult.d;
    }
    notifyError(new ErrorMessage(i, paramGetFeedIdListResult));
  }
  
  private void b(JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    List localList = paramGetFeedIdListResult.a;
    SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(localList.size()));
    if (SLog.a()) {
      SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "start pull feed info %s", localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FeedIdListSeqInfo)((Iterator)localObject).next()).a);
    }
    localObject = new BatchGetFriendStoryFeedInfoRequest();
    this.a.add(localObject);
    BatchGetFeedCommentRequest localBatchGetFeedCommentRequest = new BatchGetFeedCommentRequest(localArrayList, true);
    this.a.add(localBatchGetFeedCommentRequest);
    BatchGetFeedLikeRequest localBatchGetFeedLikeRequest = new BatchGetFeedLikeRequest(localArrayList, true);
    this.a.add(localBatchGetFeedLikeRequest);
    GetFeedFeatureRequest localGetFeedFeatureRequest = new GetFeedFeatureRequest();
    this.a.add(localGetFeedFeatureRequest);
    ((BatchGetFriendStoryFeedInfoRequest)localObject).f = localList;
    CmdTaskManger.a().a((NetworkRequest)localObject, new HomeFeedAllInfoPullSegment.1(this, paramJobContext, paramGetFeedIdListResult));
    CmdTaskManger.a().a(localBatchGetFeedCommentRequest, new HomeFeedAllInfoPullSegment.2(this, paramJobContext, paramGetFeedIdListResult));
    CmdTaskManger.a().a(localBatchGetFeedLikeRequest, new HomeFeedAllInfoPullSegment.3(this, paramJobContext, paramGetFeedIdListResult));
    localGetFeedFeatureRequest.f = localArrayList;
    CmdTaskManger.a().a(localGetFeedFeatureRequest, new HomeFeedAllInfoPullSegment.4(this, paramJobContext, paramGetFeedIdListResult));
  }
  
  protected void a(JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    Iterator localIterator = paramGetFeedIdListResult.a.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramGetFeedIdListResult.a.isEmpty())
    {
      if (paramGetFeedIdListResult.c)
      {
        paramJobContext = new HomeFeedData(new ErrorMessage());
        paramJobContext.c = paramGetFeedIdListResult.b;
        paramJobContext.a = paramGetFeedIdListResult.c;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      SLog.a("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramGetFeedIdListResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment
 * JD-Core Version:    0.7.0.1
 */